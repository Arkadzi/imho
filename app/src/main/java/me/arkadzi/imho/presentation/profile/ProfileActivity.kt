package me.arkadzi.imho.presentation.profile

import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.*
import me.arkadzi.imho.domain.model.Account
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.base.BaseMvpActivity
import me.arkadzi.imho.presentation.base.DiplomasAdapter
import me.arkadzi.imho.presentation.base.FragmentTabAdapter
import me.arkadzi.imho.presentation.views.ProfileView
import javax.inject.Inject


class ProfileActivity : BaseMvpActivity<ProfileView, ProfilePresenter>(), ProfileView {
    override val contentViewId = R.layout.activity_profile
    override val user: User
        get() = intent!!.getSerializableExtra(ARG_USER) as User
    @Inject
    lateinit var account: Account

    val fragmentTabAdapter: FragmentTabAdapter by lazy {
        DiplomasAdapter(this)
    }

    override val hasBackButton: Boolean
        get() = !isCurrentUser()

    private fun isCurrentUser() = account.getUser()!!.id == user.id

    override fun provideTitle() = getString(R.string.hint_profile)

    override fun renderUser(user: User) {
        tvName.text = user.fullName
        tvGrade.text = user.grade
        ivAvatar.setImageUrl(user.avatar, round = true)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    override fun initViews() {
        setSupportActionBar(toolbar)
        prepareDrawer()
        prepareTabs()
        fab.shown(isCurrentUser())
        fab.setOnClickListener {
            Launcher.startDiplomaWorkScreen(this)
        }
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
        fragmentTabAdapter.showView(position, arrayOf(user))
    }

    private fun prepareDrawer() {
        if (!isCurrentUser()) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        } else {
            navigationView.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                    drawer.closeDrawer(navigationView)
                    when (menuItem.itemId) {
                        R.id.it_labs -> Launcher.startLabsActivity(this@ProfileActivity)
                        R.id.it_lecturers -> Launcher.startLecturersActivity(this@ProfileActivity)
                    }
                    return false
                }
            })

            val actionBarDrawerToggle = object : ActionBarDrawerToggle(
                    this, drawer, toolbar, 0, 0) {}
            drawer.addDrawerListener(actionBarDrawerToggle)
            actionBarDrawerToggle.syncState()
        }
    }

    companion object {
        const val ARG_USER = "ARG_USER"
    }
}