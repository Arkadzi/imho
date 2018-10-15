package me.arkadzi.imho.presentation.base

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AlertDialog
import me.arkadzi.imho.R
import me.arkadzi.imho.presentation.views.ProgressView
import me.arkadzi.imho.presentation.views.View
import javax.inject.Inject

@SuppressLint("Registered")
abstract class BaseMvpActivity<V : View, P : Presenter<V>> : BaseActivity(), ProgressView {
    @Inject
    lateinit var presenter: P
    private var progressDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(this as V)
    }

    override fun onDestroy() {
        hideProgress()
        presenter.onRelease()
        super.onDestroy()
    }

    override fun showProgress() {
        val view = android.view.View.inflate(this, R.layout.dialog_progress, null)
        progressDialog = AlertDialog.Builder(this)
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
