package me.arkadzi.imho.presentation.lab_content

import android.os.Bundle
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.presentation.BaseListFragment
import me.arkadzi.imho.presentation.adapters.BaseAdapter
import me.arkadzi.imho.presentation.views.LabContentView

class LabPrioritiesFragment : BaseListFragment<LabPriority, LabContentView<LabPriority>, LabPriorityPresenter>(), LabContentView<LabPriority> {
    override val labId: Long
        get() = (arguments!!.getSerializable(ARG_LAB) as Lab).id

    override fun generateAdapter(): BaseAdapter<LabPriority> {
        return LabPriorityAdapter(layoutInflater)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    companion object {
        const val ARG_LAB = "arg_lab"
        fun getInstance(lab: Lab): LabPrioritiesFragment {
            return LabPrioritiesFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LAB, lab)
                }
            }
        }
    }
}