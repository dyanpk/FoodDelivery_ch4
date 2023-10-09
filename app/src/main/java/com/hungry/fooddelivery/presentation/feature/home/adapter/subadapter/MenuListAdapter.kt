package com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemGridMenuBinding
import com.hungry.fooddelivery.databinding.ItemLinearMenuBinding
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.GridMenuItemViewHolder
import com.hungry.fooddelivery.presentation.feature.home.adapter.viewholder.LinearMenuItemViewHolder

class MenuListAdapter(
    private val itemClick: (Menu) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    lateinit var adapterLayoutMode: AdapterLayoutMode

    private var layoutMode: AdapterLayoutMode = AdapterLayoutMode.LINEAR
    

    private val dataDiffer =
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<Menu>() {
            override fun areItemsTheSame(
                oldItem: Menu,
                newItem: Menu
            ): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.nameOfMenu == newItem.nameOfMenu &&
                        oldItem.imgUrlMenu == newItem.imgUrlMenu &&
                        oldItem.priceOfMenu == newItem.priceOfMenu
            }

            override fun areContentsTheSame(
                oldItem: Menu,
                newItem: Menu
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        })

    fun submitData(data: List<Menu>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (layoutMode) {
            AdapterLayoutMode.LINEAR-> {
                LinearMenuItemViewHolder(
                    binding = ItemLinearMenuBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), itemClick
                )
            }
            else -> {
                GridMenuItemViewHolder(
                        binding = ItemGridMenuBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), itemClick
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderBinder<Menu>).bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size


}