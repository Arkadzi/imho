package me.arkadzi.imho.app.utils

import android.view.View
import android.widget.Adapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import com.squareup.picasso.Picasso
import me.arkadzi.imho.presentation.utils.CircleTransform

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

fun ImageView.setImageUrl(url: String?, round: Boolean = false) {
    if (url == null) {
        return
    }
    val load = Picasso.get().load(url)
    if (round) {
        load.transform(CircleTransform())
    }
    load.into(this)
}

fun View.shown(shown: Boolean) {
    if (shown) {
        visible()
    } else {
        gone()
    }
}

val Adapter.data
    get() = (0..count - 1).map { getItem(it) }.toList()

fun <T> Spinner.data(): List<T> =
        adapter.data.map { it as T }