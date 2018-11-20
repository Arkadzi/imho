package me.arkadzi.imho.presentation.diploma

import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_diploma.*
import kotlinx.android.synthetic.main.item_lecturer.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.lsteners.SpinnerSelectListener
import me.arkadzi.imho.app.utils.*
import me.arkadzi.imho.domain.model.*
import me.arkadzi.imho.presentation.base.BaseMvpActivity
import me.arkadzi.imho.presentation.model.UIAcademicDegree
import javax.inject.Inject

class DiplomaActivity : BaseMvpActivity<DiplomaView, DiplomaPresenter>(), DiplomaView {
    override val contentViewId = R.layout.activity_diploma
    override val hasBackButton = true
    override val graduateWork: GraduateWork?
        get() = intent!!.getSerializableExtra(ARG_DIPLOMA) as? GraduateWork
    override val isCreatingNew
        get() = (graduateWork == null)
    @Inject
    lateinit var account: Account

    private var lecturersAlert: AlertDialog? = null

    override fun initViews() {
        initSpinners()
        spYear.isEnabled = isCreatingNew
        spPriority.isEnabled = isCreatingNew
        spLab.isEnabled = isCreatingNew
        etSubject.isEnabled = isCreatingNew
        etDescription.isEnabled = isCreatingNew
        initAuthorView()
        initButtons()

    }

    private fun initAuthorView() {
        val work = graduateWork
        if (work != null) {
            val owner = work.owner!!
            tvName.text = owner.fullName
            tvGrade.text = owner.grade
            ivAvatar.setImageUrl(owner.avatarUrl, round = true)
            authorView.visible()
            shadowView.visible()
        } else {
            authorView.gone()
            shadowView.gone()
        }
    }

    private fun initButtons() {
        fab.setOnClickListener {
            onCreateClick()
        }
        btShare.setOnClickListener {
            presenter.onOfferClick()
        }

        fab.shown(isCreatingNew)
        btShare.shown(canShare())
        btAccept.shown(canAccept())
    }

    private fun canAccept() = isOfferedToCurrentUser()

    private fun canShare() = isCurrentUserOwner() && account.getUser()!!.isStudent


    override fun showLecturers(value: List<Lecturer>) {
        val list = value.map { it.fullName }.toTypedArray()
        lecturersAlert = AlertDialog.Builder(this)
                .setItems(list) { dialog, which ->
                    presenter.onLecturerChosen(value[which])
                }
                .create()
                .apply {
                    show()
                }
    }

    override fun onDestroy() {
        lecturersAlert?.dismiss()
        super.onDestroy()
    }

    private fun onCreateClick() {
        try {
            val subject = getText(etSubject, R.string.warn_input_subject)
            val description = getText(etDescription, R.string.warn_input_description)
            val labPriority = spPriority.selectedItem() as? LabPriority
                    ?: throw IllegalArgumentException(getString(R.string.warn_choose_priprity))
            val academicDegree = (spYear.selectedItem as UIAcademicDegree).academicDegree
            presenter.onCreateGraduateWork(GraduateWork(0, subject, description, 1, 0))
        } catch (e: IllegalArgumentException) {
            showMessage(e.message!!)
        }
    }

    override fun close() {
        finish()
    }

    fun isCurrentUserOwner() =
            graduateWork != null && graduateWork!!.isUserOwner(account.getUser()!!)
    fun isOfferedToCurrentUser() =
            graduateWork != null && graduateWork!!.isUserSubscribed(account.getUser()!!)

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
        spLab.adapter = ArrayAdapter<Lab>(this, R.layout.item_spinner, labs)
    }

    override fun setLabPriorities(priorities: List<LabPriority>) {
        if (priorities.isEmpty()) {
            spPriority.gone()
        } else {
            spPriority.adapter = ArrayAdapter<LabPriority>(this, R.layout.item_spinner, priorities)
            spPriority.visible()
        }
    }

    override fun setDiploma(graduateWork: GraduateWork) {
        etSubject.setText(graduateWork.title)
        etDescription.setText(graduateWork.description)
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
