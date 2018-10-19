package me.arkadzi.imho.presentation.labs

import android.os.Bundle
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.showFragment
import me.arkadzi.imho.presentation.base.BaseActivity

class LabsActivity : BaseActivity() {
    override val hasBackButton = true
    override val contentViewId = R.layout.fragment_container
    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun provideTitle() = getString(R.string.hint_labs)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            showFragment(LaboratoriesFragment.getInstance())
        }
    }

}
