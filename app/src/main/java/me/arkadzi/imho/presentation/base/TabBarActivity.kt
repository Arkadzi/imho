package me.arkadzi.imho.presentation.base

import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_tab.*
import me.arkadzi.imho.R

class TabBarActivity : BaseActivity() {
    override val contentViewId = R.layout.activity_tab
    val tabMode
        get() = intent.getStringExtra(ARG_TAB_MODE)
    val additionalArgs
        get() = (intent.getSerializableExtra(ARG_ADDITIONAL_ARGS) as? Array<Any>) ?: arrayOf()

    val fragmentTabAdapter: FragmentTabAdapter by lazy {
        TabAdapters(this)[tabMode]
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (0..fragmentTabAdapter.getCount() - 1).map {
            tabView.newTab().apply {
                this.text = getString(fragmentTabAdapter.getTabTitle(it))
            }
        }.forEach {
            tabView.addTab(it)
        }
        tabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                showScreen(tab.position)
            }
        })
        showScreen(0)
    }

    private fun showScreen(position: Int) {
        fragmentTabAdapter.showView(position, additionalArgs)
    }

    companion object {
        const val ARG_TAB_MODE = "arg_tab_mode"
        const val ARG_ADDITIONAL_ARGS = "arg_additional_args"
    }

}

