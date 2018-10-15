package me.arkadzi.imho.presentation.labs

import android.os.Bundle
import me.arkadzi.imho.app.utils.Launcher
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.presentation.BaseListFragment
import me.arkadzi.imho.presentation.adapters.BaseAdapter
import me.arkadzi.imho.presentation.base.TabAdapters
import me.arkadzi.imho.presentation.views.BaseListView

class LaboratoriesFragment : BaseListFragment<Lab, BaseListView<Lab>, LaboratoriesPresenter>() {
    override fun generateAdapter(): BaseAdapter<Lab> {
        return LabsAdapter(layoutInflater)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    companion object {
        fun getInstance(): LaboratoriesFragment {
            return LaboratoriesFragment().apply {
                arguments = Bundle()
            }
        }
    }

    override fun onItemClick(item: Lab) {
        Launcher.startTabScreen(activity!!, TabAdapters.LAB_CONTENT, item)
    }
}