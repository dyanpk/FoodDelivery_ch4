package com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemLinearMenuBinding
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.utils.toCurrencyFormat

class LinearMenuItemViewHolder(
    private val binding: ItemLinearMenuBinding,
    private val onClickListener: (Menu) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Menu> {

    override fun bind(item: Menu) {
        binding.ivItemMenu.load(item.imgUrlMenu)
        binding.tvNameOfMenu.text = item.nameOfMenu
        binding.tvPriceOfMenu.text = item.priceOfMenu.toCurrencyFormat()
        binding.root.setOnClickListener {
            onClickListener.invoke(item)
        }
    }
}
