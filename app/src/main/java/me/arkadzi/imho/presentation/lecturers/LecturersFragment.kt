package me.arkadzi.imho.presentation.lecturers

import android.os.Bundle
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.BaseListFragment
import me.arkadzi.imho.presentation.adapters.BaseAdapter
import me.arkadzi.imho.presentation.views.LabContentView

class LecturersFragment : BaseListFragment<Lecturer, LabContentView<Lecturer>, LecturersPresenter>(), LabContentView<Lecturer> {
    override val labId: Long?
        get() = (arguments!!.getSerializable(ARG_LAB) as? Lab)?.id

    override fun generateAdapter(): BaseAdapter<Lecturer> {
        return LecturersAdapter(layoutInflater)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    companion object {
        const val ARG_LAB = "arg_lab"
        fun getInstance(lab: Lab?): LecturersFragment {
            return LecturersFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LAB, lab)
                }
            }
        }
    }
}