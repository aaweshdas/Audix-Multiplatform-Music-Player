package dev.brahmkshatriya.echo.utils.image

import android.graphics.Bitmap
import coil3.size.Size
import coil3.transform.Transformation

class SquareCropTransformation : Transformation() {
    val version = 1
    override val cacheKey = "${javaClass.simpleName}.$version"
    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        val safeInput = if (input.config == Bitmap.Config.HARDWARE) {
            runCatching { input.copy(Bitmap.Config.ARGB_8888, false) }.getOrNull() ?: input
        } else {
            input
        }
        val max = safeInput.width.coerceAtMost(safeInput.height).coerceAtLeast(1)
        val x = ((safeInput.width - max) / 2).coerceAtLeast(0)
        val y = ((safeInput.height - max) / 2).coerceAtLeast(0)
        return Bitmap.createBitmap(safeInput, x, y, max, max)
    }
}