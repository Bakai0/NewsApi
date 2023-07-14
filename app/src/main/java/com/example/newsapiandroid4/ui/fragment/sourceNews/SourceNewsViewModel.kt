package com.example.newsapiandroid4.ui.fragment.sourceNews

import androidx.lifecycle.ViewModel
import com.example.newsapiandroid4.data.repositories.SourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourceNewsViewModel @Inject constructor(
    private val repository: SourceRepository
): ViewModel() {

    fun fetchSourcesNews() = repository.fetchSourcesNews()
}