package me.arkadzi.imho.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast

import me.arkadzi.imho.app.Application
import me.arkadzi.imho.app.utils.applicationComponent
import me.arkadzi.imho.app.utils.trySetContentView
import me.arkadzi.imho.presentation.di.ActivityComponent
import me.arkadzi.imho.presentation.di.ActivityModule
import me.arkadzi.imho.presentation.views.View

abstract class BaseActivity : AppCompatActivity(), View {
    protected open val hasBackButton = false
    abstract val contentViewId: Int?
    protected val activityComponent: ActivityComponent by lazy {
        val configurationInstance = lastCustomNonConfigurationInstance
        if (configurationInstance == null)
            applicationComponent.include(ActivityModule())
        else
            configurationInstance as ActivityComponent
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return activityComponent
    }


    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trySetContentView(contentViewId)
        injectSelf()
        initViews()
        supportActionBar?.title = provideTitle()
    }

    protected open fun initViews() {

    }

    protected open fun provideTitle(): CharSequence? = null

    abstract fun injectSelf()

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
