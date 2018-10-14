package me.arkadzi.imho.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.*
import me.arkadzi.imho.R
import me.arkadzi.imho.domain.model.User1

class UserHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseHolder<User1>(inflater.inflate(R.layout.item_user, parent, false)),
        LayoutContainer {

    override fun bind(data: User1) {
        tvName.text = data.name
        tvEmail.text = data.email
        tvCompany.text = data.company.name
    }
}