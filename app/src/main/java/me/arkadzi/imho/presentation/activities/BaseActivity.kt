package me.arkadzi.imho.presentation.activities

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

import me.arkadzi.imho.app.Application
import me.arkadzi.imho.presentation.di.ActivityComponent
import me.arkadzi.imho.presentation.di.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    protected open val hasBackButton = false
    protected val activityComponent: ActivityComponent by lazy {
        val configurationInstance = lastCustomNonConfigurationInstance
        if (configurationInstance == null)
            Application.getApp(this).appComponent.plus(ActivityModule())
        else
            configurationInstance as ActivityComponent
    }


    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return activityComponent
    }

    override fun onStart() {
        super.onStart()
        if (hasBackButton) {
            val supportActionBar = supportActionBar
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true)
                supportActionBar.setDisplayShowHomeEnabled(true)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
