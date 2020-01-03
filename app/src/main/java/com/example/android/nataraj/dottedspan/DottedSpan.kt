package com.example.android.nataraj.dottedspan

import android.graphics.*
import android.text.style.ReplacementSpan

/**
 * created by nataraj-7085 on 3/1/20
 */

class DottedSpan(
    val textColor: Int,
    val strokeColor: Int,
    val bgColor: Int,
    val dashEffect: Float,
    val sw: Float
) :
    ReplacementSpan() {

    private var mStrokePaint: Paint = Paint().apply {
        color = strokeColor
        style = Paint.Style.STROKE
        pathEffect = DashPathEffect(floatArrayOf(dashEffect, dashEffect), 0F)
        strokeWidth = sw
    }

    private var mBgPaint: Paint = Paint().apply {
        color = bgColor
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
        val mSpanLength = paint.measureText(text.subSequence(start, end.plus(1)).toString())

        canvas.drawRect(RectF(x, top.toFloat(), x.plus(mSpanLength), bottom.toFloat()), mBgPaint)
        paint.color = textColor
        canvas.drawText(text, start, end.plus(1), x, y.toFloat(), paint)


        val path = Path()
        path.moveTo(x, y.toFloat())
        path.lineTo(x.plus(mSpanLength), y.toFloat())
        canvas.drawPath(path, mStrokePaint)
    }

}