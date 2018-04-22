package me.arkadzi.imho.app.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.presentation.activities.BaseActivity
import me.arkadzi.imho.presentation.activities.PostDetailsActivity

fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


fun BaseActivity.navigateToDetails(post: Post) {
    val intent = Intent(this, PostDetailsActivity::class.java)
            .putExtra(PostDetailsActivity.ARG_POST, post)
    startActivity(intent)
}
