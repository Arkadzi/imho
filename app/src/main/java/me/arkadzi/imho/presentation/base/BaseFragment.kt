package me.arkadzi.imho.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import me.arkadzi.imho.app.utils.applicationComponent
import me.arkadzi.imho.presentation.di.ActivityComponent
import me.arkadzi.imho.presentation.di.ActivityModule
import me.arkadzi.imho.presentation.views.View


abstract class BaseFragment : Fragment(), View {
    protected val activityComponent: ActivityComponent by lazy {
        activity!!.applicationComponent.include(ActivityModule())
    }
    var isFirstLaunch = true
        private set
    abstract val contentViewId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        injectSelf()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View {
        return inflater.inflate(contentViewId, container, false)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFirstLaunch = false
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    abstract fun injectSelf()

}
