package me.arkadzi.imho.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class BaseHolder<T>(
        override val containerView: View?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    val context
        get() = itemView.context

    abstract fun bind(data: T)
}
