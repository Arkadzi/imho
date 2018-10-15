package me.arkadzi.imho.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AlertDialog
import me.arkadzi.imho.R
import me.arkadzi.imho.presentation.views.ProgressView
import me.arkadzi.imho.presentation.views.View
import javax.inject.Inject

abstract class BaseMvpFragment<V : View, P : Presenter<V>> : BaseFragment(), ProgressView {
    @Inject
    lateinit var presenter: P
    private var progressDialog: AlertDialog? = null

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreate(this as V)
    }

    override fun onDestroyView() {
        hideProgress()
        presenter.onRelease()
        super.onDestroyView()
    }

    override fun showProgress() {
        val view = android.view.View.inflate(activity, R.layout.dialog_progress, null)
        progressDialog = AlertDialog.Builder(activity!!)
                .setView(view)
                .setCancelable(false)
                .create()
                .apply {
                    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    show()
                }
    }

    override fun hideProgress() {
        progressDialog?.dismiss()
    }


}
