package com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemEmptyViewHolderBinding
import com.hungry.fooddelivery.presentation.feature.home.adapter.model.HomeSection

class EmptyViewHolder(
    private val binding : ItemEmptyViewHolderBinding
) : ViewHolder(binding.root), ViewHolderBinder<HomeSection>{
    override fun bind(item: HomeSection) {
        TODO("Not yet implemented")
    }
}