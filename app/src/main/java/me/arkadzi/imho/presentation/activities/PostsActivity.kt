package me.arkadzi.imho.presentation.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.navigateToDetails
import me.arkadzi.imho.app.utils.toast
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.presentation.adapteres.BaseAdapter
import me.arkadzi.imho.presentation.adapteres.PostsAdapter
import me.arkadzi.imho.presentation.presenters.PostPresenter
import me.arkadzi.imho.presentation.views.PostView
import javax.inject.Inject

class PostsActivity : BaseActivity(), PostView {
    @Inject
    lateinit var presenter: PostPresenter
    private lateinit var adapter: BaseAdapter<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        init()
        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onRelease()
        super.onDestroy()
    }

    private fun init() {
        rvPosts.layoutManager = LinearLayoutManager(this)
        adapter = PostsAdapter(layoutInflater)
        adapter.setOnItemClickListener { navigateToDetails(it) }
        rvPosts.adapter = adapter
        ltRefresh.setOnRefreshListener { presenter.onRefresh() }
    }

    override fun renderList(data: List<Post>) {
        adapter.data = data
    }

    override fun showProgress() {
        if (!ltRefresh.isRefreshing) {
            ltRefresh.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    override fun hideProgress() {
        if (ltRefresh.isRefreshing) {
            ltRefresh.isRefreshing = false
        } else {
            ltRefresh.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }

    override fun showMessage(message: String) {
        toast(message)
    }

}
