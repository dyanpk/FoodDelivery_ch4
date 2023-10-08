package com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hungry.fooddelivery.databinding.ItemCategoryBinding
import com.hungry.fooddelivery.model.Category

class CategoryListAdapter(
    private val itemClick: (Category) -> Unit
): RecyclerView.Adapter<CategoryListAdapter.ItemCategoryViewHolder>(){

    private var items: MutableList<Category> = mutableListOf()

    fun setItems(items: List<Category>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Category>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ItemCategoryViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(
        holder: ItemCategoryViewHolder,
        position: Int
    ) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ItemCategoryViewHolder(
        private val binding: ItemCategoryBinding,
        val itemClick: (Category) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){

        fun bindView(item: Category){
            with(item) {
                binding.ivCategoryIcon.load(item.imgUrlCategory){
                    crossfade(true)
                }
                binding.tvCategoryName.text = item.nameOfCategory
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }
}