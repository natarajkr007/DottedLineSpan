package com.example.android.nataraj.dottedspan

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dashEffect = resources.getDimension(R.dimen.dashEffect)
        val strokeWidth = resources.getDimension(R.dimen.strokeWidth)

        val spanText = "gnikjaratan"
        val dottedSpan = DottedSpan(Color.RED, "king", dashEffect, strokeWidth)
        val spannableString = SpannableStringBuilder(spanText).apply {
            setSpan(
                dottedSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            setSpan(
                BackgroundColorSpan(Color.CYAN), 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
        }

        spanTextView.text = spannableString
    }
}
