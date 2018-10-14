package me.arkadzi.imho.app.utils

import android.content.Context
import android.widget.Toast
import me.arkadzi.imho.app.Application
import me.arkadzi.imho.presentation.base.BaseActivity

fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

//
//fun BaseActivity.navigateToDetails(post: Post) {
//    val intent = Intent(this, PostDetailsActivity::class.java)
//            .putExtra(PostDetailsActivity.ARG_POST, post)
//    startActivity(intent)
//}


fun BaseActivity.trySetContentView(layoutId: Int?) {
    setContentView(layoutId ?: return)
}

val Context.applicationComponent
    get() = (applicationContext as Application).appComponent
