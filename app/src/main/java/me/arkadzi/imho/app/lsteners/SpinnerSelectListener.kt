package me.arkadzi.imho.app.lsteners

import android.view.View
import android.widget.AdapterView

abstract class SpinnerSelectListener<T>: AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        onItemSelected(parent.adapter.getItem(position) as T)
    }

    abstract fun onItemSelected(item: T)
}