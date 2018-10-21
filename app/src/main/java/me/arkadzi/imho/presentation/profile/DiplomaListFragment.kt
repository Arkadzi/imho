package me.arkadzi.imho.presentation.profile

import android.os.Bundle
import me.arkadzi.imho.app.utils.Launcher
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.BaseListFragment
import me.arkadzi.imho.presentation.adapters.BaseAdapter
import me.arkadzi.imho.presentation.views.DiplomaListView

class DiplomaListFragment: BaseListFragment<GraduateWork, DiplomaListView<GraduateWork>, DiplomaPresenter>(), DiplomaListView<GraduateWork> {
    override val userId: Long
        get() = arguments!!.getLong(ARG_USER_ID)
    override val isOwner: Boolean
        get() = arguments!!.getBoolean(ARG_IS_OWNER)

    override fun generateAdapter(): BaseAdapter<GraduateWork> {
        return DiplomaAdapter(layoutInflater)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun onItemClick(item: GraduateWork) {
        Launcher.startDiplomaWorkScreen(activity!!, item)
    }
    companion object {
        const val ARG_USER_ID = "arg_lab"
        const val ARG_IS_OWNER = "arg_owner"
        fun getInstance(userId: Long, isOwner: Boolean): DiplomaListFragment {
            return DiplomaListFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_USER_ID, userId)
                    putBoolean(ARG_IS_OWNER, isOwner)
                }
            }
        }
    }
}