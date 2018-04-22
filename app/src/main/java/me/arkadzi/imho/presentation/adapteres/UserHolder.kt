package me.arkadzi.imho.presentation.adapteres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.User

class UserHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseHolder<User>(inflater.inflate(R.layout.item_user, parent, false)),
        LayoutContainer {

    override fun bind(data: User) {
        tvName.text = data.name
        tvEmail.text = data.email
        tvCompany.text = data.company.name
    }
}