package me.arkadzi.imho.presentation.base

import android.support.annotation.StringRes
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.showFragment
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.lab_content.LabPrioritiesFragment
import me.arkadzi.imho.presentation.labs.LaboratoriesFragment
import me.arkadzi.imho.presentation.lecturers.LecturersFragment
import me.arkadzi.imho.presentation.profile.DiplomaListFragment

class TabAdapters(
        val activity: BaseActivity
) {
    companion object {
        const val LABS_LECTURERS = "LABS_LECTURERS"
        const val LAB_CONTENT = "LAB_CONTENT"
    }

    operator fun get(key: String) =
            when (key) {
                LABS_LECTURERS -> LabsLecturersAdapter(activity)
                LAB_CONTENT -> LabContentAdapter(activity)
                else -> throw IllegalArgumentException("TabAdapters get key $key")
            }
}

interface TabAdapter {
    fun getCount(): Int
    @StringRes
    fun getTabTitle(position: Int): Int

    fun showView(position: Int, params: Array<Any>)
}

abstract class FragmentTabAdapter(
        private val activity: BaseActivity
) : TabAdapter {

    override fun showView(position: Int, params: Array<Any>) {
        activity.showFragment(generateFragment(position, params))
    }

    abstract fun generateFragment(position: Int, params: Array<Any>): BaseFragment
}

class LabsLecturersAdapter(baseActivity: BaseActivity) : FragmentTabAdapter(baseActivity) {
    override fun getTabTitle(position: Int) = when (position) {
        0 -> R.string.hint_labs
        1 -> R.string.hint_lecturers
        else -> throw IllegalArgumentException("LabsLecturersAdapter getTabTitle position:$position")
    }

    override fun getCount() = 2

    override fun generateFragment(position: Int, params: Array<Any>): BaseFragment {
        return when (position) {
            0 -> LaboratoriesFragment.getInstance()
            1 -> LecturersFragment.getInstance()
            else -> throw IllegalArgumentException("LabsLecturersAdapter generateFragment position:$position")
        }
    }
}

class LabContentAdapter(baseActivity: BaseActivity) : FragmentTabAdapter(baseActivity) {
    override fun getTabTitle(position: Int) = when (position) {
        0 -> R.string.hint_priorities
        1 -> R.string.hint_lecturers
        else -> throw IllegalArgumentException("LabContentAdapter getTabTitle position:$position")
    }

    override fun getCount() = 2

    override fun generateFragment(position: Int, params: Array<Any>): BaseFragment {
        val lab = params[0] as Lab
        return when (position) {
            0 -> LabPrioritiesFragment.getInstance(lab)
            1 -> LecturersFragment.getInstance(lab)
            else -> throw IllegalArgumentException("LabContentAdapter generateFragment position:$position")
        }
    }
}

class DiplomasAdapter(baseActivity: BaseActivity) : FragmentTabAdapter(baseActivity) {
    override fun getTabTitle(position: Int) = when (position) {
        0 -> R.string.hint_own
        1 -> R.string.hint_offered
        else -> throw IllegalArgumentException("DiplomasAdapter getTabTitle position:$position")
    }

    override fun getCount() = 2

    override fun generateFragment(position: Int, params: Array<Any>): BaseFragment {
        val user = params[0] as User
        return when (position) {
            0 -> DiplomaListFragment.getInstance(user.id, true)
            1 -> DiplomaListFragment.getInstance(user.id, false)
            else -> throw IllegalArgumentException("DiplomasAdapter generateFragment position:$position")
        }
    }
}



