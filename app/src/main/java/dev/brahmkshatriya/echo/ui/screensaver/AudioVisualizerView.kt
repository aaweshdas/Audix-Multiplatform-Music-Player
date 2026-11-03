package dev.brahmkshatriya.echo.ui.screensaver

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.sin
import kotlin.random.Random

class AudioVisualizerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val barCount = 32
    private val barHeights = FloatArray(barCount) { 0.1f }
    private val targetHeights = FloatArray(barCount) { 0.1f }

    private val barPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private var phase = 0f
    private var isPlaying = true

    private val animator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 50
        repeatCount = ValueAnimator.INFINITE
        interpolator = LinearInterpolator()
        addUpdateListener {
            phase += 0.08f
            updateBands()
            invalidate()
        }
    }

    init {
        animator.start()
    }

    fun setPlaying(playing: Boolean) {
        isPlaying = playing
        if (!playing) {
            for (i in 0 until barCount) {
                targetHeights[i] = 0.05f
            }
        }
    }

    private fun updateBands() {
        for (i in 0 until barCount) {
            if (isPlaying) {
                val wave = sin(phase * 1.8 + i * 0.35).toFloat() * 0.5f + 0.5f
                val jitter = Random.nextFloat() * 0.25f
                val target = (wave * 0.75f + jitter).coerceIn(0.12f, 0.98f)
                targetHeights[i] = target
            } else {
                targetHeights[i] = 0.04f
            }
            // Smooth lerp
            barHeights[i] += (targetHeights[i] - barHeights[i]) * 0.28f
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (w > 0 && h > 0) {
            barPaint.shader = LinearGradient(
                0f, 0f, 0f, h.toFloat(),
                intArrayOf(0xFF38BDF8.toInt(), 0xFF06B6D4.toInt(), 0x3306B6D4.toInt()),
                floatArrayOf(0f, 0.65f, 1f),
                Shader.TileMode.CLAMP
            )
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = width.toFloat()
        val h = height.toFloat()
        if (w <= 0f || h <= 0f) return

        val totalBarWidth = w / barCount
        val barWidth = totalBarWidth * 0.65f
        val spacing = totalBarWidth * 0.35f

        for (i in 0 until barCount) {
            val left = i * totalBarWidth + spacing / 2f
            val right = left + barWidth
            val barH = (h * barHeights[i]).coerceIn(4f, h)
            val top = h - barH
            val bottom = h
            canvas.drawRoundRect(left, top, right, bottom, barWidth / 2f, barWidth / 2f, barPaint)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.cancel()
    }
}
