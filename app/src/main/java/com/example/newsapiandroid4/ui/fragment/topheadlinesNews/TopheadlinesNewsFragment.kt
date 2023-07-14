package com.example.newsapiandroid4.ui.fragment.topheadlinesNews

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapiandroid4.R
import com.example.newsapiandroid4.base.BaseFragment
import com.example.newsapiandroid4.databinding.FragmentTopheadlinesNewsBinding
import com.example.newsapiandroid4.ui.adapter.TopHeadlinesNewsAdapter
import com.example.newsapiandroid4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopheadlinesNewsFragment : BaseFragment<FragmentTopheadlinesNewsBinding, TopheadlinesNewsViewModel>(R.layout.fragment_topheadlines_news) {

    override val binding by viewBinding(FragmentTopheadlinesNewsBinding::bind)
    override val viewModel by viewModels<TopheadlinesNewsViewModel>()
    private val topHeadlinesNewsAdapter = TopHeadlinesNewsAdapter()

    override fun initialize() {
        binding.recyclerViewTopHeadlinesNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = topHeadlinesNewsAdapter
        }
    }

    override fun setupSubscribes() {
        everythingNewsSubscribe()
    }

    private fun everythingNewsSubscribe() {
        viewModel.fetchVideoCategory().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("TopHeadlinesNewsError", it.message.toString())
                }

                is Resource.Loading -> {
                    Log.e("TopHeadlinesNewsLoading", it.message.toString())
                }

                is Resource.Success -> {
                    Log.d("TopHeadlinesNewsSuccess", it.data?.articles.toString())
                    topHeadlinesNewsAdapter.submitList(it.data?.articles)
                }
            }
        }
    }
}