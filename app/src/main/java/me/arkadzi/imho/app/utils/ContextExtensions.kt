package me.arkadzi.imho.app.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()