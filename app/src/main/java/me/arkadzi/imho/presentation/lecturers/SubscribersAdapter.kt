package me.arkadzi.imho.presentation.lecturers

import android.view.LayoutInflater
import android.view.ViewGroup
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.adapters.BaseAdapter

class SubscribersAdapter(layoutInflater: LayoutInflater) : BaseAdapter<User>(layoutInflater) {
    override fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup) =
            SubscribersHolder(inflater, parent)
}