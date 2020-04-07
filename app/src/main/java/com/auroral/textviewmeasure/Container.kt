package com.auroral.textviewmeasure

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.BoringLayout
import android.text.Layout
import android.text.TextPaint
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import auroral.extension.getValue
import auroral.extension.setViewParams

/**
 * Author: AuroralLove
 *
 * Description:
 */
class Container(context: Context?) : ViewGroup(context) {

    val a = A(context)
    val b = B(context)
    val c = AppCompatTextView(context)

    companion object {
        val textSize = getValue(30f)
        val content = "爱AA82"
    }

    init {
        addView(a)
        addView(b)
        addView(c)

        a.setBackgroundColor(0x20ff00ff)
        b.setBackgroundColor(0x20ff00ff)
        c.setBackgroundColor(0x20ff00ff)

        c.setTextColor(0xff666666.toInt())
        c.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        c.gravity = Gravity.CENTER
        c.text = content
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for (i in 0 until childCount) {
            measureChild(
                setViewParams(
                    getChildAt(i),
                    getValue(160),
                    getValue(160)
                ), widthMeasureSpec, heightMeasureSpec
            )
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var left = getValue(20)
        var right = left + a.measuredWidth
        val top = getValue(20)
        val bottom = top + a.measuredHeight
        a.layout(
            left,
            top,
            right,
            bottom
        )

        left = right
        right = left + this.b.measuredWidth
        this.b.layout(
            left,
            top,
            right,
            bottom
        )

        left = right
        right = left + this.c.measuredWidth
        this.c.layout(
            left,
            top,
            right,
            bottom
        )
    }

    class A(context: Context?) : View(context) {

        val textPaint = Paint()

        val colorPaint = Paint()

        init {
            textPaint.isAntiAlias = true
            textPaint.isDither = true
            textPaint.textAlign = Paint.Align.CENTER
            textPaint.textSize = textSize
            textPaint.color = 0xff666666.toInt()

            colorPaint.isAntiAlias = true
            colorPaint.isDither = true
            colorPaint.style = Paint.Style.STROKE
            colorPaint.strokeWidth = 1f
        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            val metrics: Paint.FontMetrics = textPaint.fontMetrics
            val y = measuredHeight / 2f + (metrics.descent - metrics.ascent) / 2.0f - metrics.descent

            colorPaint.color = Color.RED
            canvas?.drawLine(
                0f,
                y + metrics.top,
                measuredWidth.toFloat(),
                y + metrics.top,
                colorPaint
            )

            colorPaint.color = Color.BLUE
            canvas?.drawLine(
                0f,
                y + metrics.ascent,
                measuredWidth.toFloat(),
                y + metrics.ascent,
                colorPaint
            )

            colorPaint.color = Color.GREEN
            canvas?.drawLine(
                0f,
                y + metrics.descent,
                measuredWidth.toFloat(),
                y + metrics.descent,
                colorPaint
            )

            colorPaint.color = Color.CYAN
            canvas?.drawLine(
                0f,
                y + metrics.bottom,
                measuredWidth.toFloat(),
                y + metrics.bottom,
                colorPaint
            )

            canvas?.drawText(
                content,
                measuredWidth / 2f,
                y,
                textPaint
            )
        }
    }

    class B(context: Context?) : View(context) {

        val textPaint = Paint()

        val colorPaint = Paint()

        init {
            textPaint.isAntiAlias = true
            textPaint.isDither = true
            textPaint.textAlign = Paint.Align.CENTER
            textPaint.textSize = textSize
            textPaint.color = 0xff666666.toInt()

            colorPaint.isAntiAlias = true
            colorPaint.isDither = true
            colorPaint.style = Paint.Style.STROKE
            colorPaint.strokeWidth = 1f
        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            val metrics: Paint.FontMetrics = textPaint.fontMetrics
            val y = measuredHeight / 2f + (metrics.bottom - metrics.top) / 2.0f - metrics.bottom

            colorPaint.color = Color.RED
            canvas?.drawLine(
                0f,
                y + metrics.top,
                measuredWidth.toFloat(),
                y + metrics.top,
                colorPaint
            )

            colorPaint.color = Color.BLUE
            canvas?.drawLine(
                0f,
                y + metrics.ascent,
                measuredWidth.toFloat(),
                y + metrics.ascent,
                colorPaint
            )

            colorPaint.color = Color.GREEN
            canvas?.drawLine(
                0f,
                y + metrics.descent,
                measuredWidth.toFloat(),
                y + metrics.descent,
                colorPaint
            )

            colorPaint.color = Color.CYAN
            canvas?.drawLine(
                0f,
                y + metrics.bottom,
                measuredWidth.toFloat(),
                y + metrics.bottom,
                colorPaint
            )

            canvas?.drawText(
                content,
                measuredWidth / 2f,
                y,
                textPaint
            )
        }
    }

    class D(context: Context?) : View(context) {

        val textPaint = TextPaint()

        val colorPaint = Paint()

        val rect = Rect()

        init {
            textPaint.isAntiAlias = true
            textPaint.isDither = true
            textPaint.textAlign = Paint.Align.CENTER
            textPaint.textSize = textSize
            textPaint.color = 0xff666666.toInt()

            colorPaint.isAntiAlias = true
            colorPaint.isDither = true
            colorPaint.style = Paint.Style.STROKE
            colorPaint.strokeWidth = 1f
        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            val metrics: Paint.FontMetrics = textPaint.fontMetrics
            val y = measuredHeight / 2f

            colorPaint.color = Color.RED
            canvas?.drawLine(
                0f,
                y + metrics.top,
                measuredWidth.toFloat(),
                y + metrics.top,
                colorPaint
            )

            colorPaint.color = Color.BLUE
            canvas?.drawLine(
                0f,
                y + metrics.ascent,
                measuredWidth.toFloat(),
                y + metrics.ascent,
                colorPaint
            )

            colorPaint.color = Color.GREEN
            canvas?.drawLine(
                0f,
                y + metrics.descent,
                measuredWidth.toFloat(),
                y + metrics.descent,
                colorPaint
            )

            colorPaint.color = Color.CYAN
            canvas?.drawLine(
                0f,
                y + metrics.bottom,
                measuredWidth.toFloat(),
                y + metrics.bottom,
                colorPaint
            )


            textPaint.getTextBounds(content, 0, content.length, rect)


            canvas?.drawText(
                content,
                measuredWidth / 2f,
                y + (metrics.bottom - metrics.top) / 2.0f - metrics.bottom,
                textPaint
            )
//
//            BoringLayout.make(content,textPaint,0,Layout.Alignment.ALIGN_CENTER,0f,0f,
//                textPaint.fontMetricsInt as BoringLayout.Metrics?,false)
        }
    }
}