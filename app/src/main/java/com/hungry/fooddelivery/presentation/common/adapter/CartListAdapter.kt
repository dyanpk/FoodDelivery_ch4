package com.hungry.fooddelivery.presentation.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.hungry.fooddelivery.R
import com.hungry.fooddelivery.core.ViewHolderBinder
import com.hungry.fooddelivery.databinding.ItemCartMenuBinding
import com.hungry.fooddelivery.databinding.ItemCartMenuOrderBinding
import com.hungry.fooddelivery.databinding.ItemCostBinding
import com.hungry.fooddelivery.model.Cart
import com.hungry.fooddelivery.model.CartMenu
import com.hungry.fooddelivery.utils.doneEditing
import com.hungry.fooddelivery.utils.toCurrencyFormat

class CartListAdapter(
    private val cartListener: CartListener? = null
) : RecyclerView.Adapter<ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<CartMenu>() {
        override fun areItemsTheSame(oldItem: CartMenu, newItem: CartMenu): Boolean {
            return oldItem.cart.id == newItem.cart.id && oldItem.menu.id == newItem.menu.id
        }

        override fun areContentsTheSame(oldItem: CartMenu, newItem: CartMenu): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    fun submitData(data: List<CartMenu>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (cartListener != null) {
            CartViewHolder(
                ItemCartMenuBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                cartListener
            )
        } else {
            CartOrderViewHolder(
                ItemCartMenuOrderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                ItemCostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolderBinder<CartMenu>).bind(dataDiffer.currentList[position])
    }
}

class CartViewHolder(
    private val binding: ItemCartMenuBinding,
    private val cartListener: CartListener?
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<CartMenu> {

    override fun bind(item: CartMenu) {
        setCartData(item)
        setCartNotes(item)
        setClickListeners(item)
    }

    private fun setCartData(item: CartMenu) {
        with(binding) {
            binding.ivItemMenu.load(item.menu.imgUrlMenu) {
                crossfade(true)
            }
            tvMenuCount.text = item.cart.itemQuantity.toString()
            tvMenuName.text = item.menu.nameOfMenu
            tvProductPrice.text =
                (item.cart.itemQuantity * item.menu.priceOfMenu).toCurrencyFormat()
        }
    }

    private fun setCartNotes(item: CartMenu) {
        binding.etNotesItem.setText(item.cart.itemNotes)
        binding.etNotesItem.doneEditing {
            binding.etNotesItem.clearFocus()
            val newItem = item.cart.copy().apply {
                itemNotes = binding.etNotesItem.text.toString().trim()
            }
            cartListener?.onUserDoneEditingNotes(newItem)
        }
    }

    private fun setClickListeners(item: CartMenu) {
        with(binding) {
            ivMinus.setOnClickListener {
                cartListener?.onMinusTotalItemCartClicked(item.cart)
            }
            ivPlus.setOnClickListener {
                cartListener?.onPlusTotalItemCartClicked(item.cart)
            }
            ivRemoveCart.setOnClickListener {
                cartListener?.onRemoveCartClicked(item.cart)
            }
        }
    }
}

class CartOrderViewHolder(
    private val binding: ItemCartMenuOrderBinding,
    private val sumBind: ItemCostBinding
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<CartMenu> {

    override fun bind(item: CartMenu) {
        setCartData(item)
        setCartNotes(item)
        setSumCheckout(item)
    }

    private fun setCartData(item: CartMenu) {
        with(binding) {
            binding.ivItemMenu.load(item.menu.imgUrlMenu) {
                crossfade(true)
            }
            tvTotalQuantity.text = itemView.rootView.context.getString(
                R.string.total_quantity,
                item.cart.itemQuantity.toString()
            )
            tvMenuName.text = item.menu.nameOfMenu
            tvMenuPrice.text =
                (item.cart.itemQuantity * item.menu.priceOfMenu).toCurrencyFormat()
        }
    }

    private fun setCartNotes(item: CartMenu) {
        binding.tvNotes.text = item.cart.itemNotes
    }

    private fun setSumCheckout(item: CartMenu) {
        with(sumBind) {
            tvItemTitle.text = item.menu.nameOfMenu
            tvItemPrice.text =
                (item.cart.itemQuantity * item.menu.priceOfMenu).toCurrencyFormat()
        }
    }
}

interface CartListener {
    fun onPlusTotalItemCartClicked(cart: Cart)
    fun onMinusTotalItemCartClicked(cart: Cart)
    fun onRemoveCartClicked(cart: Cart)
    fun onUserDoneEditingNotes(cart: Cart)
}