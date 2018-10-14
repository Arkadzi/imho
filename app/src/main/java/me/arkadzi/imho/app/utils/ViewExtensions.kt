package me.arkadzi.imho.app.utils

import android.view.View
import android.widget.EditText

val EditText.textStr
    get() = text.toString()

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}