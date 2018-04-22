package me.arkadzi.imho.presentation.adapteres

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<D>(private val inflater: LayoutInflater) : RecyclerView.Adapter<BaseHolder<D>>() {
    var data = listOf<D>()
        set(value) {
            field = value.toMutableList()
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = generateViewHolder(inflater, parent)

    protected abstract fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BaseHolder<D>

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BaseHolder<D>, position: Int) = holder.bind(data[position])

}
