package me.arkadzi.imho.presentation.lecturers

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_lecturer.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.avatar
import me.arkadzi.imho.app.utils.grade
import me.arkadzi.imho.app.utils.setImageUrl
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.adapters.BaseHolder

class SubscribersHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
) : BaseHolder<User>(inflater.inflate(R.layout.item_subscriber, parent, false)),
        LayoutContainer {

    override fun bind(data: User) {
        tvName.text = data.fullName
        tvGrade.text = data.grade()
        ivAvatar.setImageUrl(data.avatar(), round = true)
    }

    val User.fullName
        get() = "$lastName $firstName $middleName"
}