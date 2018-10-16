package me.arkadzi.imho.presentation.profile

import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_tab.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Account
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.base.BaseMvpActivity
import me.arkadzi.imho.presentation.base.DiplomasAdapter
import me.arkadzi.imho.presentation.base.FragmentTabAdapter
import me.arkadzi.imho.presentation.views.ProfileView
import javax.inject.Inject

class MainActivity : BaseMvpActivity<ProfileView, ProfilePresenter>(), ProfileView {
    override val contentViewId = R.layout.activity_profile
    @Inject
    lateinit var account: Account

    val fragmentTabAdapter: FragmentTabAdapter by lazy {
        DiplomasAdapter(this)
    }

    override fun renderUser(user: User) {

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
        fragmentTabAdapter.showView(position, arrayOf(account.getUser()!!))
    }

    private fun isOwner(position: Int) = position == 0
}