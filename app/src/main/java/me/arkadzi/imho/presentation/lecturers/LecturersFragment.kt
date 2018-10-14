package me.arkadzi.imho.presentation.lecturers

import android.os.Bundle
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.presentation.BaseListFragment
import me.arkadzi.imho.presentation.adapters.BaseAdapter
import me.arkadzi.imho.presentation.labs.LabsAdapter
import me.arkadzi.imho.presentation.views.BaseListView

class LecturersFragment : BaseListFragment<Lecturer, BaseListView<Lecturer>, LecturersPresenter>() {
    override fun generateAdapter(): BaseAdapter<Lecturer> {
        return LecturersAdapter(layoutInflater)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    companion object {
        fun getInstance(): LecturersFragment {
            return LecturersFragment().apply {
                arguments = Bundle()
            }
        }
    }
}