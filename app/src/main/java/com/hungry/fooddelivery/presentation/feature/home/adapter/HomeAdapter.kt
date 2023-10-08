package com.hungry.fooddelivery.presentation.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemEmptyViewHolderBinding
import com.hungry.fooddelivery.databinding.ItemSectionBannerBinding
import com.hungry.fooddelivery.databinding.ItemSectionCategoryBinding
import com.hungry.fooddelivery.databinding.ItemSectionHeaderBinding
import com.hungry.fooddelivery.databinding.ItemSectionMenuBinding
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.presentation.feature.home.adapter.model.HomeSection
import com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter.AdapterLayoutMode
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.BannerSectionViewHolder
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.CategoriesSectionViewHolder
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.EmptyViewHolder
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.HeaderSectionViewHolder
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.MenuSectionViewHolder

class HomeAdapter(
    private val onMenuClicked: (Menu) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<HomeSection>() {
            override fun areItemsTheSame(
                oldItem: HomeSection,
                newItem: HomeSection
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: HomeSection,
                newItem: HomeSection
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        })

    fun submitData(data: List<HomeSection>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ITEM_TYPE_HEADER -> {
                HeaderSectionViewHolder(
                    ItemSectionHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ITEM_TYPE_BANNER -> {
                BannerSectionViewHolder(
                    ItemSectionBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ITEM_TYPE_CATEGORY_LIST -> {
                CategoriesSectionViewHolder(
                    ItemSectionCategoryBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ITEM_TYPE_MENU_LIST -> {
                MenuSectionViewHolder(
                    ItemSectionMenuBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), layoutModePref = AdapterLayoutMode.GRID,
                    onMenuClicked
                )
            }

            else -> EmptyViewHolder(
                ItemEmptyViewHolderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }


    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun getItemViewType(position: Int): Int {
        return when (dataDiffer.currentList[position]) {
            HomeSection.HeaderSection -> ITEM_TYPE_HEADER
            HomeSection.BannerSection -> ITEM_TYPE_BANNER
            is HomeSection.CategoriesSection -> ITEM_TYPE_CATEGORY_LIST
            is HomeSection.MenusSection -> ITEM_TYPE_MENU_LIST
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolderBinder<HomeSection>).bind(dataDiffer.currentList[position])
    }

    companion object {
        const val ITEM_TYPE_HEADER = 1
        const val ITEM_TYPE_BANNER = 2
        const val ITEM_TYPE_CATEGORY_LIST = 3
        const val ITEM_TYPE_MENU_LIST = 4
    }
}
