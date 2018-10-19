package me.arkadzi.imho.presentation.profile

import android.os.Bundle
import android.support.design.widget.TabLayout
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Account
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.base.BaseMvpActivity
import me.arkadzi.imho.presentation.base.DiplomasAdapter
import me.arkadzi.imho.presentation.base.FragmentTabAdapter
import me.arkadzi.imho.presentation.views.ProfileView
import javax.inject.Inject
import android.R.attr.fragment
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*
import me.arkadzi.imho.app.utils.Launcher


class MainActivity : BaseMvpActivity<ProfileView, ProfilePresenter>(), ProfileView {
    override val contentViewId = R.layout.activity_profile
    @Inject
    lateinit var account: Account

    val fragmentTabAdapter: FragmentTabAdapter by lazy {
        DiplomasAdapter(this)
    }

    override fun provideTitle(): CharSequence = getString(R.string.hint_profile)

    override fun renderUser(user: User) {

    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun initViews() {
        setSupportActionBar(toolbar)
        prepareDrawer()
        prepareTabs()
    }

    private fun prepareTabs() {
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

    private fun prepareDrawer() {
        navigationView.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                drawer.closeDrawer(navigationView)
                when (menuItem.itemId) {
                    R.id.it_labs -> Launcher.startLabsActivity(this@MainActivity)
                    R.id.it_lecturers -> Launcher.startLecturersActivity(this@MainActivity)
                }
                return false
            }
        })

        val actionBarDrawerToggle = object : ActionBarDrawerToggle(
                this, drawer, toolbar, 0, 0){}
        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
}