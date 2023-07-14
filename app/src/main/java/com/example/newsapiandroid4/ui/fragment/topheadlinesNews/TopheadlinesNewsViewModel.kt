package com.example.newsapiandroid4.ui.fragment.topheadlinesNews

import androidx.lifecycle.ViewModel
import com.example.newsapiandroid4.data.repositories.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopheadlinesNewsViewModel @Inject constructor(
    private val repository: TopHeadlinesRepository
) : ViewModel() {

    fun fetchVideoCategory() = repository.fetchTopHeadlinesNews()
}