package com.example.android.nataraj.dottedspan

import android.graphics.*
import android.text.style.ReplacementSpan

/**
 * created by nataraj-7085 on 3/1/20
 */

class DottedSpan(val textColor: Int, val mSpan: String, val dashEffect: Float, val sw: Float) :
    ReplacementSpan() {

    private var mPaint: Paint = Paint().apply {
        color = textColor
        style = Paint.Style.STROKE
        pathEffect = DashPathEffect(floatArrayOf(dashEffect, dashEffect), 0F)
        strokeWidth = sw
    }

    private var rectPaint: Paint = Paint().apply {
        color = Color.CYAN
        style = Paint.Style.FILL
    }

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        return paint.measureText(text, start, end).toInt()
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        val mSpanLength = paint.measureText(mSpan)

        canvas.drawRect(
            x,
            top.toFloat(),
            y.toFloat().plus(mSpanLength),
            bottom.toFloat(),
            rectPaint
        )
        canvas.drawText(mSpan, start, end, x, y.toFloat(), paint)


        val path = Path()
        path.moveTo(x, y.toFloat())
        path.lineTo(x.plus(mSpanLength), y.toFloat())
        canvas.drawPath(path, mPaint)
    }

}