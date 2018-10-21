package me.arkadzi.imho.presentation.diploma

import android.support.annotation.StringRes
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_diploma.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.lsteners.SpinnerSelectListener
import me.arkadzi.imho.app.utils.gone
import me.arkadzi.imho.app.utils.mapToUI
import me.arkadzi.imho.app.utils.visible
import me.arkadzi.imho.domain.model.AcademicDegree
import me.arkadzi.imho.domain.model.GraduateWork
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.LabPriority
import me.arkadzi.imho.presentation.base.BaseMvpActivity
import me.arkadzi.imho.presentation.model.UIAcademicDegree

class DiplomaActivity : BaseMvpActivity<DiplomaView, DiplomaPresenter>(), DiplomaView {
    override val contentViewId = R.layout.activity_diploma
    override val hasBackButton = true
    val graduateWork: GraduateWork?
        get() = intent!!.getSerializableExtra(ARG_DIPLOMA) as? GraduateWork
    val isCreatingNew
        get() = (graduateWork == null)

    override fun initViews() {
        initSpinners()
        fab.setOnClickListener {
            try {
                val subject = getText(etSubject, R.string.warn_input_subject)
                val description = getText(etDescription, R.string.warn_input_description)
                val labPriority = spPriority.selectedItem() as? LabPriority
                        ?: throw IllegalArgumentException(getString(R.string.warn_choose_priprity))
                val academicDegree = (spYear.selectedItem as UIAcademicDegree).academicDegree
                presenter.onCreateGraduateWork(GraduateWork(subject, description, academicDegree, labPriority.id, emptyList()))
            } catch (e: IllegalArgumentException) {
                showMessage(e.message!!)
            }
        }
    }

    override fun close() {
        finish()
    }

    private fun getText(editText: EditText, @StringRes errorMes: Int): String {
        return with(editText.text.trim()) {
            if (isEmpty()) {
                throw IllegalArgumentException(getString(errorMes))
            } else {
                this.toString()
            }
        }
    }

    private fun initSpinners() {
        spLab.onItemSelectedListener = object : SpinnerSelectListener<Lab>() {
            override fun onItemSelected(item: Lab) {
                presenter.onLabSelected(item)
            }
        }
        spPriority.gone()
        val uiDegrees = AcademicDegree.values().toList().mapToUI(this)
        spYear.adapter = ArrayAdapter<UIAcademicDegree>(this, R.layout.item_spinner, uiDegrees)
    }

    override fun setLabs(labs: List<Lab>) {
        val list = labs.toMutableList().apply {
            add(0, Lab(-1, getString(R.string.hint_not_selected)))
        }
        spLab.adapter = ArrayAdapter<Lab>(this, R.layout.item_spinner, list)
        fab.visible()
    }

    override fun setLabPriorities(labs: List<LabPriority>) {
        if (labs.isEmpty()) {
            spPriority.gone()
        } else {
            val list = labs.toMutableList().apply {
                add(0, LabPriority(-1, getString(R.string.hint_not_selected), "", -1))
            }
            spPriority.adapter = ArrayAdapter<LabPriority>(this, R.layout.item_spinner, list)
            spPriority.visible()
        }
    }

    override fun provideTitle() = if (isCreatingNew) {
        getString(R.string.action_create_work)
    } else {
        getString(R.string.action_edit_work)
    }

    override fun injectSelf() {
        activityComponent.inject(this)
    }

    companion object {
        const val ARG_DIPLOMA = "ARG_DIPLOMA"
    }

    private fun Spinner.selectedItem(): LabPriority? {
        val labPriority = selectedItem as? LabPriority
        return if (labPriority == null || labPriority.id < 0) {
            null
        } else {
            labPriority
        }
    }
}
