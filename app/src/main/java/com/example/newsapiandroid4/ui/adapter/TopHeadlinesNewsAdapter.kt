package com.example.newsapiandroid4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapiandroid4.data.models.NewsModel
import com.example.newsapiandroid4.databinding.ItemNewsBinding

class TopHeadlinesNewsAdapter:
    ListAdapter<NewsModel, TopHeadlinesNewsAdapter.TopHeadlinesNewsViewHolder>(DiffUtilCallback()) {

    inner class TopHeadlinesNewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: NewsModel) = with(binding) {
            Glide.with(binding.imageView.context)
                .load(item.urlToImage)
                .into(binding.imageView)
            name.text = item.title
            description.text = item.description
            pushingAt.text = item.publeshedAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesNewsViewHolder {
        return TopHeadlinesNewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopHeadlinesNewsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        class DiffUtilCallback : DiffUtil.ItemCallback<NewsModel>() {
            override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem.source.id == newItem.source.id
            }

            override fun areContentsTheSame(
                oldItem: NewsModel,
                newItem: NewsModel,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}