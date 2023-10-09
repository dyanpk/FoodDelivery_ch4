package com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemSectionCategoryBinding
import com.hungry.fooddelivery.presentation.feature.home.adapter.model.HomeSection
import com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter.CategoryListAdapter

class CategoriesSectionViewHolder(
    private val binding: ItemSectionCategoryBinding
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection>{

    private val adapter: CategoryListAdapter by lazy {
        CategoryListAdapter{
            Toast.makeText(binding.root.context, it.nameOfCategory, Toast.LENGTH_SHORT).show()
        }
    }

    override fun bind(item: HomeSection) {
        if(item is HomeSection.CategoriesSection){
            binding.rvCategory.apply {
                adapter = this@CategoriesSectionViewHolder.adapter
            }
            adapter.setItems(items = item.data)
        }
    }
}