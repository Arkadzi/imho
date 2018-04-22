package me.arkadzi.imho.presentation.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_post_details.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.toast
import me.arkadzi.imho.domain.model.Comment
import me.arkadzi.imho.domain.model.Post
import me.arkadzi.imho.domain.model.PostInfo
import me.arkadzi.imho.domain.model.User
import me.arkadzi.imho.presentation.adapteres.BaseHeaderAdapter
import me.arkadzi.imho.presentation.adapteres.PostInfoAdapter
import me.arkadzi.imho.presentation.presenters.PostDetailsPresenter
import me.arkadzi.imho.presentation.views.PostDetailsView
import javax.inject.Inject

class PostDetailsActivity : BaseActivity(), PostDetailsView {
    override val hasBackButton = true

    @Inject
    lateinit var presenter: PostDetailsPresenter

    private lateinit var adapter: BaseHeaderAdapter<Comment, User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        activityComponent.inject(this)
        init()
        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onRelease()
        super.onDestroy()
    }

    private fun init() {
        rvData.layoutManager = LinearLayoutManager(this)
        adapter = PostInfoAdapter(layoutInflater)
        rvData.adapter = adapter
        ltRefresh.setOnRefreshListener { presenter.onRefresh(getPost()) }
    }

    override fun renderInfo(data: PostInfo) {
        adapter.header = data.user
        adapter.data = data.comments
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

    override fun getPost(): Post {
        return intent.getParcelableExtra(ARG_POST)
    }


    companion object {
        const val ARG_POST = "arg_post"
    }
}
