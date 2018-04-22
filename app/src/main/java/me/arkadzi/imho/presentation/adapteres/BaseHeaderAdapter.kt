package me.arkadzi.imho.presentation.adapteres

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseHeaderAdapter<D, H>(protected val inflater: LayoutInflater) : RecyclerView.Adapter<BaseHolder<*>>() {
    companion object {
        const val TYPE_HEADER = 1
        const val TYPE_ITEM = 2
    }

    var data = listOf<D>()
        set(value) {
            field = value.toMutableList()
            notifyDataSetChanged()
        }

    var header: H? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemViewType(position: Int): Int = when {
        header != null && position == 0 -> TYPE_HEADER
        else -> TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return data.size + (if (header != null) 1 else 0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<*> {
        return when (viewType) {
            TYPE_HEADER -> generateHeaderHolder(inflater, parent)
            else -> generateViewHolder(inflater, parent)
        }
    }

    protected abstract fun generateHeaderHolder(inflater: LayoutInflater, parent: ViewGroup): BaseHolder<H>


    protected abstract fun generateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BaseHolder<D>

    override fun onBindViewHolder(holder: BaseHolder<*>, position: Int) {
        when (getItemViewType(position)) {
            TYPE_HEADER -> (holder as BaseHolder<H>).bind(header!!)
            TYPE_ITEM -> (holder as BaseHolder<D>).bind(getDataItem(position))
        }
    }

    fun getDataItem(position: Int): D = data[if (header != null) position - 1 else position]
}

