package com.kevicsalazar.uplabs.presentation.views

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.kevicsalazar.uplabs.R
import com.kevicsalazar.uplabs.presentation.BaseFragment
import com.kevicsalazar.uplabs.presentation.BasePresenter
import com.kevicsalazar.uplabs.presentation.ActivityComponent
import com.kevicsalazar.uplabs.presentation.adapters.PostRecyclerAdapter
import com.kevicsalazar.uplabs.domain.model.Post
import com.kevicsalazar.uplabs.presentation.presenters.PagePresenter
import kotlinx.android.synthetic.main.fragment_page.*
import javax.inject.Inject

/**
 * Created by Kevin.
 */
class PageFragment : BaseFragment(), PagePresenter.View {

    @Inject lateinit var mPresenter: PagePresenter

    var postAdapter: PostRecyclerAdapter? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postAdapter = PostRecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = postAdapter

        mPresenter.getPosts(arguments.getString("type"))

    }

    override val layout: Int get() = R.layout.fragment_page

    override val presenter: BasePresenter<*>? get() = mPresenter.with(this)

    override fun setupComponent(component: ActivityComponent) = component.inject(this)

    override fun clearAdapter() {
        postAdapter?.clear()
    }

    override fun addPostToAdapter(post: Post) {
        postAdapter?.add(post)
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(title: String, message: String) {

    }

}