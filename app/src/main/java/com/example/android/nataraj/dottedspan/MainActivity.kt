package com.example.android.nataraj.dottedspan

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dashEffect = resources.getDimension(R.dimen.dashEffect)
        val strokeWidth = resources.getDimension(R.dimen.strokeWidth)

        val dottedSpan = DottedSpan(Color.RED, dashEffect, strokeWidth)
        val spannableString = SpannableStringBuilder("nobody is king here").apply {
            setSpan(dottedSpan, 10, 13, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        }

        spanTextView.text = spannableString
    }
}
