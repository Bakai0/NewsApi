package com.example.newsapiandroid4.ui.fragment.sourceNews

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapiandroid4.R
import com.example.newsapiandroid4.base.BaseFragment
import com.example.newsapiandroid4.databinding.FragmentSourceNewsBinding
import com.example.newsapiandroid4.ui.adapter.SourcesNewsAdapter
import com.example.newsapiandroid4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceNewsFragment : BaseFragment<FragmentSourceNewsBinding, SourceNewsViewModel>(R.layout.fragment_source_news) {

    override val binding by viewBinding(FragmentSourceNewsBinding::bind)
    override val viewModel by viewModels<SourceNewsViewModel>()
    private val sourcesNewsAdapter = SourcesNewsAdapter()

    override fun initialize() {
        binding.recyclerViewSourcesNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sourcesNewsAdapter
        }
    }

    override fun setupSubscribes() {
        everythingNewsSubscribe()
    }

    private fun everythingNewsSubscribe() {
        viewModel.fetchSourcesNews().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("SourcesNewsError", it.message.toString())
                }

                is Resource.Loading -> {
                    Log.e("SourcesNewsLoading", it.message.toString())
                }

                is Resource.Success -> {
                    Log.d("SourcesNewsSuccess", it.data?.sources.toString())
                    sourcesNewsAdapter.submitList(it.data?.sources)
                }
            }
        }
    }
}