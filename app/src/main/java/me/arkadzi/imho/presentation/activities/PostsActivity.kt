package me.arkadzi.imho.presentation.activities

import android.os.Bundle
import me.arkadzi.imho.R

class PostsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
    }


}
