package me.arkadzi.imho.presentation.activities

import android.os.Bundle
import me.arkadzi.imho.R

class PostDetailsActivity : BaseActivity() {
    override val hasBackButton = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
    }

    companion object {
        const val ARG_POST = "arg_post"
    }
}
