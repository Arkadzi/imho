package me.arkadzi.imho.presentation.views

interface BaseListView<D> : ProgressView {
    fun setData(data: List<D>)
}
