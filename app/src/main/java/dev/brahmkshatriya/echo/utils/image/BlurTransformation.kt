@file:Suppress("DEPRECATION")

package dev.brahmkshatriya.echo.utils.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Paint
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import androidx.core.graphics.applyCanvas
import coil3.size.Size
import coil3.transform.Transformation
import kotlin.math.max
import kotlin.math.min

class BlurTransformation(
    private val context: Context,
    private val radius: Float = DEFAULT_RADIUS
) : Transformation() {

    override val cacheKey = "${BlurTransformation::class.simpleName}-$radius"

    override suspend fun transform(input: Bitmap, size: Size) =
        input.blurred(context, radius)

    companion object {
        private const val DEFAULT_RADIUS = 20f
        private const val MAX_WIDTH = 256

        fun Bitmap.blurred(
            context: Context,
            radius: Float = DEFAULT_RADIUS
        ): Bitmap {
            val safeRadius = radius.coerceIn(1f, 25f)

            // 1. Convert HARDWARE bitmaps to software ARGB_8888 bitmap safely
            val safeSource = if (this.config == Bitmap.Config.HARDWARE) {
                runCatching {
                    this.copy(Bitmap.Config.ARGB_8888, false)
                }.getOrNull() ?: this
            } else {
                this
            }

            val scale = (safeSource.width.toFloat() / MAX_WIDTH).coerceAtLeast(0.1f)
            val scaledHeight = (safeSource.height / scale).toInt().coerceAtLeast(1)

            // 2. Always create output as a mutable ARGB_8888 software bitmap (NEVER Config.HARDWARE)
            val output = Bitmap.createBitmap(MAX_WIDTH, scaledHeight, Bitmap.Config.ARGB_8888)
            val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
            output.applyCanvas {
                scale(1f / scale, 1f / scale)
                drawBitmap(safeSource, 0f, 0f, paint)
            }

            // 3. Try RenderScript on older Android versions where available
            var blurSuccess = false
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                var script: RenderScript? = null
                var tmpInt: Allocation? = null
                var tmpOut: Allocation? = null
                var blur: ScriptIntrinsicBlur? = null
                try {
                    script = RenderScript.create(context)
                    tmpInt = Allocation.createFromBitmap(
                        script,
                        output,
                        Allocation.MipmapControl.MIPMAP_NONE,
                        Allocation.USAGE_SCRIPT
                    )
                    tmpOut = Allocation.createTyped(script, tmpInt.type)
                    blur = ScriptIntrinsicBlur.create(script, Element.U8_4(script))
                    blur.setRadius(safeRadius)
                    blur.setInput(tmpInt)
                    blur.forEach(tmpOut)
                    tmpOut.copyTo(output)
                    blurSuccess = true
                } catch (_: Throwable) {
                    blurSuccess = false
                } finally {
                    runCatching { script?.destroy() }
                    runCatching { tmpInt?.destroy() }
                    runCatching { tmpOut?.destroy() }
                    runCatching { blur?.destroy() }
                }
            }

            // 4. Guaranteed crash-proof Software StackBlur fallback
            if (!blurSuccess) {
                stackBlur(output, safeRadius.toInt().coerceAtLeast(1))
            }

            return output
        }

        /**
         * High performance in-place StackBlur algorithm for Android bitmaps.
         * Runs in O(width * height) time and works across all Android versions without RenderScript.
         */
        fun stackBlur(bitmap: Bitmap, radius: Int) {
            if (radius < 1) return
            val w = bitmap.width
            val h = bitmap.height
            val pix = IntArray(w * h)
            bitmap.getPixels(pix, 0, w, 0, 0, w, h)

            val wm = w - 1
            val hm = h - 1
            val wh = w * h
            val div = radius + radius + 1

            val r = IntArray(wh)
            val g = IntArray(wh)
            val b = IntArray(wh)
            var rsum: Int
            var gsum: Int
            var bsum: Int
            var p: Int
            var yp: Int
            var yi: Int
            var yw: Int
            val vmin = IntArray(max(w, h))

            var divsum = (div + 1) shr 1
            divsum *= divsum
            val dv = IntArray(256 * divsum)
            for (currI in 0 until 256 * divsum) {
                dv[currI] = currI / divsum
            }

            yw = 0
            yi = 0

            val stack = Array(div) { IntArray(3) }
            var stackpointer: Int
            var stackstart: Int
            var sir: IntArray
            var rbs: Int
            val r1 = radius + 1
            var routsum: Int
            var goutsum: Int
            var boutsum: Int
            var rinsum: Int
            var ginsum: Int
            var binsum: Int

            for (currY in 0 until h) {
                rinsum = 0
                ginsum = 0
                binsum = 0
                routsum = 0
                goutsum = 0
                boutsum = 0
                rsum = 0
                gsum = 0
                bsum = 0
                for (currI in -radius..radius) {
                    p = pix[yi + min(wm, max(currI, 0))]
                    sir = stack[currI + radius]
                    sir[0] = (p and 0xff0000) shr 16
                    sir[1] = (p and 0x00ff00) shr 8
                    sir[2] = p and 0x0000ff
                    rbs = r1 - Math.abs(currI)
                    rsum += sir[0] * rbs
                    gsum += sir[1] * rbs
                    bsum += sir[2] * rbs
                    if (currI > 0) {
                        rinsum += sir[0]
                        ginsum += sir[1]
                        binsum += sir[2]
                    } else {
                        routsum += sir[0]
                        goutsum += sir[1]
                        boutsum += sir[2]
                    }
                }
                stackpointer = radius

                for (currX in 0 until w) {
                    r[yi] = dv[rsum]
                    g[yi] = dv[gsum]
                    b[yi] = dv[bsum]

                    rsum -= routsum
                    gsum -= goutsum
                    bsum -= boutsum

                    stackstart = stackpointer - radius + div
                    sir = stack[stackstart % div]

                    routsum -= sir[0]
                    goutsum -= sir[1]
                    boutsum -= sir[2]

                    if (currY == 0) {
                        vmin[currX] = min(currX + radius + 1, wm)
                    }
                    p = pix[yw + vmin[currX]]

                    sir[0] = (p and 0xff0000) shr 16
                    sir[1] = (p and 0x00ff00) shr 8
                    sir[2] = p and 0x0000ff

                    rinsum += sir[0]
                    ginsum += sir[1]
                    binsum += sir[2]

                    rsum += rinsum
                    gsum += ginsum
                    bsum += binsum

                    stackpointer = (stackpointer + 1) % div
                    sir = stack[stackpointer % div]

                    routsum += sir[0]
                    goutsum += sir[1]
                    boutsum += sir[2]

                    rinsum -= sir[0]
                    ginsum -= sir[1]
                    binsum -= sir[2]

                    yi++
                }
                yw += w
            }

            for (currX in 0 until w) {
                rinsum = 0
                ginsum = 0
                binsum = 0
                routsum = 0
                goutsum = 0
                boutsum = 0
                rsum = 0
                gsum = 0
                bsum = 0
                yp = -radius * w
                for (currI in -radius..radius) {
                    yi = max(0, yp) + currX
                    sir = stack[currI + radius]
                    sir[0] = r[yi]
                    sir[1] = g[yi]
                    sir[2] = b[yi]
                    rbs = r1 - Math.abs(currI)
                    rsum += r[yi] * rbs
                    gsum += g[yi] * rbs
                    bsum += b[yi] * rbs
                    if (currI > 0) {
                        rinsum += sir[0]
                        ginsum += sir[1]
                        binsum += sir[2]
                    } else {
                        routsum += sir[0]
                        goutsum += sir[1]
                        boutsum += sir[2]
                    }
                    if (currI < hm) {
                        yp += w
                    }
                }
                yi = currX
                stackpointer = radius
                for (currY in 0 until h) {
                    val origAlpha = pix[yi] and -0x1000000
                    pix[yi] = origAlpha or (dv[rsum] shl 16) or (dv[gsum] shl 8) or dv[bsum]

                    rsum -= routsum
                    gsum -= goutsum
                    bsum -= boutsum

                    stackstart = stackpointer - radius + div
                    sir = stack[stackstart % div]

                    routsum -= sir[0]
                    goutsum -= sir[1]
                    boutsum -= sir[2]

                    if (currX == 0) {
                        vmin[currY] = min(currY + r1, hm) * w
                    }
                    p = currX + vmin[currY]

                    sir[0] = r[p]
                    sir[1] = g[p]
                    sir[2] = b[p]

                    rinsum += sir[0]
                    ginsum += sir[1]
                    binsum += sir[2]

                    rsum += rinsum
                    gsum += ginsum
                    bsum += binsum

                    stackpointer = (stackpointer + 1) % div
                    sir = stack[stackpointer]

                    routsum += sir[0]
                    goutsum += sir[1]
                    boutsum += sir[2]

                    rinsum -= sir[0]
                    ginsum -= sir[1]
                    binsum -= sir[2]

                    yi += w
                }
            }
            bitmap.setPixels(pix, 0, w, 0, 0, w, h)
        }
    }
}
