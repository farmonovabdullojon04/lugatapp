package com.abdullojon.lugatapp.adapter

import android.text.SpannableString
import android.text.style.ForegroundColorSpan

fun String.generateTextColor(query: String, color: Int): SpannableString {
    if (query.isEmpty()) return SpannableString(this)
    val startIndex = this.indexOf(query, ignoreCase = true)
    if (startIndex == -1) return SpannableString(this)
    val lastIndex = startIndex + query.length

    val spannableText = SpannableString(this)
    spannableText.setSpan(
        ForegroundColorSpan(color),
        startIndex,
        lastIndex,
        SpannableString.SPAN_INCLUSIVE_EXCLUSIVE
    )

    return spannableText
}