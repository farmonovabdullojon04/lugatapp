package com.abdullojon.lugatapp.adapter


import android.text.SpannableString
import android.text.style.ForegroundColorSpan


fun String.generateTextColor(query: String,color: Int): SpannableString{
    val startIndex=this.indexOf(query)
    val lastIndex=startIndex+query.length

    val spannableText= SpannableString(this)
    spannableText.setSpan(ForegroundColorSpan(color),startIndex,lastIndex,SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)

    return spannableText
}