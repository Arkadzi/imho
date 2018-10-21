package me.arkadzi.imho.app.utils

import android.view.View
import android.widget.EditText
import android.widget.ImageView
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

fun ImageView.setImageUrl(url: String, round: Boolean = false) {
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