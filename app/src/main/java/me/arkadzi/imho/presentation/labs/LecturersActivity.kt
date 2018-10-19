package me.arkadzi.imho.presentation.labs

import android.os.Bundle
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.showFragment
import me.arkadzi.imho.presentation.base.BaseActivity
import me.arkadzi.imho.presentation.lecturers.LecturersFragment

class LecturersActivity : BaseActivity() {
    override val hasBackButton = true
    override val contentViewId = R.layout.fragment_container
    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun provideTitle() = getString(R.string.hint_lecturers)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showFragment(LecturersFragment.getInstance())
        }
    }
}
