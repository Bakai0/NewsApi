package com.example.newsapiandroid4.ui.fragment.everythingNews

import androidx.lifecycle.ViewModel
import com.example.newsapiandroid4.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingNewsViewModel @Inject constructor(
    private val repository: EverythingRepository
): ViewModel() {

    fun fetchVideoCategory() = repository.fetchEverythingBitcoinNews()
}