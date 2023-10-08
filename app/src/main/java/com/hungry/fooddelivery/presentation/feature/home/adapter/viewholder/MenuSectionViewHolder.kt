package com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemSectionMenuBinding
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.presentation.feature.home.adapter.model.HomeSection
import com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter.AdapterLayoutMode
import com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter.MenuListAdapter
import com.hungry.fooddelivery.utils.proceedWhen

class MenuSectionViewHolder(
    private val binding: ItemSectionMenuBinding,
    private val layoutModePref: AdapterLayoutMode,
    private val onClickListener: (Menu) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection> {

    private val adapter: MenuListAdapter by lazy {
        MenuListAdapter { item ->
            onClickListener.invoke(item)
        }
    }

    init {
        with(binding.rvMenuList) {
            adapter = this@MenuSectionViewHolder.adapter
            layoutManager = when (layoutModePref) {
                AdapterLayoutMode.LINEAR -> {
                    LinearLayoutManager(context)
                }
                AdapterLayoutMode.GRID -> {
                    GridLayoutManager(context, 2)
                }
            }
        }
    }

    override fun bind(item: HomeSection) {
        if (item is HomeSection.MenusSection) {
            item.data.proceedWhen(doOnSuccess = {
                binding.layoutState.root.isVisible = false
                binding.layoutState.pbLoading.isVisible = false
                binding.layoutState.tvError.isVisible = false
                binding.rvMenuList.apply {
                    isVisible = true
                    adapter = this@MenuSectionViewHolder.adapter
                }
                item.data.payload?.let { data -> adapter.submitData(data) }
            }, doOnLoading = {
                binding.layoutState.root.isVisible = true
                binding.layoutState.pbLoading.isVisible = true
                binding.layoutState.tvError.isVisible = false
                binding.rvMenuList.isVisible = false
            }, doOnError = {
                binding.layoutState.root.isVisible = true
                binding.layoutState.pbLoading.isVisible = false
                binding.layoutState.tvError.isVisible = true
                binding.layoutState.tvError.text = item.data.exception?.message.orEmpty()
                binding.rvMenuList.isVisible = false
            })
        }
    }
}
