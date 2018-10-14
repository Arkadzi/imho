package me.arkadzi.imho.presentation.base

import android.support.annotation.StringRes
import me.arkadzi.imho.R
import me.arkadzi.imho.presentation.labs.LaboratoriesFragment
import me.arkadzi.imho.presentation.lecturers.LecturersFragment

class TabAdapters(
        val activity: TabBarActivity
) {
    companion object {
        const val LABS_LECTURERS = "LABS_LECTURERS"
    }

    operator fun get(key: String) =
            when (key) {
                LABS_LECTURERS -> LabsLecturersAdapter(activity)
                else -> throw IllegalArgumentException("TabAdapters get key $key")
            }
}

interface TabAdapter {
    fun getCount(): Int
    @StringRes
    fun getTabTitle(position: Int): Int

    fun showView(position: Int, vararg params: Any)
}

abstract class FragmentTabAdapter(
        private val tabBarActivity: TabBarActivity
) : TabAdapter {

    override fun showView(position: Int, vararg params: Any) {
        tabBarActivity.supportFragmentManager.beginTransaction()
                .replace(R.id.flContainer, generateFragment(position, params))
                .commit()
    }

    abstract fun generateFragment(position: Int, vararg params: Any): BaseFragment
}

class LabsLecturersAdapter(tabBarActivity: TabBarActivity) : FragmentTabAdapter(tabBarActivity) {
    override fun getTabTitle(position: Int) = when (position) {
        0 -> R.string.hint_labs
        1 -> R.string.hint_lecturers
        else -> throw IllegalArgumentException("LabsLecturersAdapter getTabTitle position:$position")
    }

    override fun getCount() = 2

    override fun generateFragment(position: Int, vararg params: Any): BaseFragment {
        return when (position) {
            0 -> LaboratoriesFragment.getInstance()
            1 -> LecturersFragment.getInstance()
            else -> throw IllegalArgumentException("LabsLecturersAdapter generateFragment position:$position")
        }
    }

}



