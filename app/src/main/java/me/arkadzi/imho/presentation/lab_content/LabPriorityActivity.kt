package me.arkadzi.imho.presentation.lab_content

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab_priority.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.showFragment
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.presentation.base.BaseActivity

class LabPriorityActivity : BaseActivity() {
    override val hasBackButton = true
    val labPriority
    get() = intent.getSerializableExtra(ARG_LAB_PRIORITY) as LabPriority
    override val contentViewId = R.layout.activity_lab_priority
    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun provideTitle() = labPriority.title

    override fun initViews() {
        tvDescription.text = labPriority.description
    }

    companion object {
        const val ARG_LAB_PRIORITY = "ARG_LAB_PRIORITY"
    }

}
