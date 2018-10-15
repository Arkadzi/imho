package me.arkadzi.imho.presentation

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_recycler.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.gone
import me.arkadzi.imho.app.utils.visible
import me.arkadzi.imho.presentation.adapters.BaseAdapter
import me.arkadzi.imho.presentation.base.BaseListPresenter
import me.arkadzi.imho.presentation.base.BaseMvpFragment
import me.arkadzi.imho.presentation.views.BaseListView

abstract class BaseListFragment<D, V : BaseListView<D>, P : BaseListPresenter<D, V>>
    : BaseMvpFragment<V, P>(), BaseListView<D> {
    override val contentViewId = R.layout.fragment_recycler

    private lateinit var adapter: BaseAdapter<D>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = generateAdapter()
        adapter.setOnItemClickListener {
            onItemClick(it)
        }
        recyclerView.adapter = adapter
    }

    protected open fun onItemClick(item: D) {

    }

    override fun showProgress() {
        progressBar.visible()
        recyclerView.gone()
    }

    override fun hideProgress() {
        progressBar.gone()
        recyclerView.visible()
    }

    override fun setData(data: List<D>) {
        adapter.data = data
    }

    abstract fun generateAdapter(): BaseAdapter<D>
}