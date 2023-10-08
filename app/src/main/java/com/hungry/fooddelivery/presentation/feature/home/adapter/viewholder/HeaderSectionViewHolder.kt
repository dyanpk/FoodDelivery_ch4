package com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemSectionHeaderBinding
import com.hungry.fooddelivery.presentation.feature.home.adapter.model.HomeSection

class HeaderSectionViewHolder(
    private val binding: ItemSectionHeaderBinding,
): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection>{
    override fun bind(item: HomeSection) {
        if(item is HomeSection.HeaderSection){

        }
    }
}