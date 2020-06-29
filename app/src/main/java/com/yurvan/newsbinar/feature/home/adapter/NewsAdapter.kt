package com.yurvan.newsbinar.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yurvan.newsbinar.core.platform.BaseAdapter
import com.yurvan.newsbinar.databinding.ListItemNewsBinding

import com.yurvan.newsbinar.feature.home.model.Articles

class NewsAdapter(val onClick: (Articles) -> Unit): BaseAdapter<NewsAdapter.ViewHolder, Articles>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemNewsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = models[position]
        holder.apply {
            bind(article)
            itemView.setOnClickListener{onClick(article)}
        }
    }

    class ViewHolder(private val binding: ListItemNewsBinding)
        : RecyclerView.ViewHolder(binding.root)  {
        fun bind(item: Articles){
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }
}