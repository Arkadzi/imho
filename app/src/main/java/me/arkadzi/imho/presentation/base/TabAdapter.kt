package me.arkadzi.imho.presentation.base

import android.support.annotation.StringRes
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.presentation.lab_content.LabPriorityFragment
import me.arkadzi.imho.presentation.labs.LaboratoriesFragment
import me.arkadzi.imho.presentation.lecturers.LecturersFragment

class TabAdapters(
        val activity: TabBarActivity
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
        private val tabBarActivity: TabBarActivity
) : TabAdapter {

    override fun showView(position: Int, params: Array<Any>) {
        tabBarActivity.supportFragmentManager.beginTransaction()
                .replace(R.id.flContainer, generateFragment(position, params))
                .commit()
    }

    abstract fun generateFragment(position: Int, params: Array<Any>): BaseFragment
}

class LabsLecturersAdapter(tabBarActivity: TabBarActivity) : FragmentTabAdapter(tabBarActivity) {
    override fun getTabTitle(position: Int) = when (position) {
        0 -> R.string.hint_labs
        1 -> R.string.hint_lecturers
        else -> throw IllegalArgumentException("LabsLecturersAdapter getTabTitle position:$position")
    }

    override fun getCount() = 2

    override fun generateFragment(position: Int, params: Array<Any>): BaseFragment {
        return when (position) {
            0 -> LaboratoriesFragment.getInstance()
            1 -> LecturersFragment.getInstance(null)
            else -> throw IllegalArgumentException("LabsLecturersAdapter generateFragment position:$position")
        }
    }
}

class LabContentAdapter(tabBarActivity: TabBarActivity) : FragmentTabAdapter(tabBarActivity) {
    override fun getTabTitle(position: Int) = when (position) {
        0 -> R.string.hint_priorities
        1 -> R.string.hint_lecturers
        else -> throw IllegalArgumentException("LabContentAdapter getTabTitle position:$position")
    }

    override fun getCount() = 2

    override fun generateFragment(position: Int, params: Array<Any>): BaseFragment {
        val lab = params[0] as Lab
        return when (position) {
            0 -> LabPriorityFragment.getInstance(lab)
            1 -> LecturersFragment.getInstance(lab)
            else -> throw IllegalArgumentException("LabContentAdapter generateFragment position:$position")
        }
    }

}



