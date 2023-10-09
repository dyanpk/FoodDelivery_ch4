package com.hungry.fooddelivery.presentation.feature.checkout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.hungry.fooddelivery.R
import com.hungry.fooddelivery.data.local.database.AppDatabase
import com.hungry.fooddelivery.data.local.database.datasource.CartDataSource
import com.hungry.fooddelivery.data.local.database.datasource.CartDatabaseDataSource
import com.hungry.fooddelivery.data.repository.CartRepository
import com.hungry.fooddelivery.data.repository.CartRepositoryImpl
import com.hungry.fooddelivery.databinding.ActivityCheckoutBinding
import com.hungry.fooddelivery.databinding.ItemCostBinding
import com.hungry.fooddelivery.presentation.common.adapter.CartListAdapter
import com.hungry.fooddelivery.utils.GenericViewModelFactory
import com.hungry.fooddelivery.utils.proceedWhen
import com.hungry.fooddelivery.utils.toCurrencyFormat

class CheckoutActivity : AppCompatActivity() {

    private val viewModel: CheckoutViewModel by viewModels {
        val database = AppDatabase.getInstance(this)
        val cartDao = database.cartDao()
        val cartDataSource: CartDataSource = CartDatabaseDataSource(cartDao)
        val repo: CartRepository = CartRepositoryImpl(cartDataSource)
        GenericViewModelFactory.create(CheckoutViewModel(repo))
    }

    private val binding: ActivityCheckoutBinding by lazy {
        ActivityCheckoutBinding.inflate(layoutInflater)
    }
    private val sumBind: ItemCostBinding by lazy {
        ItemCostBinding.inflate(layoutInflater)
    }

    private val adapter: CartListAdapter by lazy {
        CartListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupList()
        observeData()
    }

    private fun setupList() {
        binding.layoutContent.rvCart.adapter = adapter
    }

    private fun observeData() {
        viewModel.cartList.observe(this) { it.proceedWhen(
            doOnSuccess = { result ->
                binding.layoutState.root.isVisible = false
                binding.layoutState.pbLoading.isVisible = false
                binding.layoutState.tvError.isVisible = false
                binding.layoutContent.root.isVisible = true
                binding.layoutContent.rvCart.isVisible = true
                binding.cvSectionOrder.isVisible = true
                binding.layoutContent.rvShoppingSummary.isVisible = true
                binding.layoutContent.cvShoppingSummary.isVisible = true

                result.payload?.let { (carts, totalPrice) ->
                    adapter.submitData(carts)
                    binding.tvTotalPrice.text = totalPrice.toCurrencyFormat()
                    sumBind.tvItemPrice.text = totalPrice.toCurrencyFormat()
                }
            },
            doOnLoading = {
                binding.layoutState.root.isVisible = true
                binding.layoutState.pbLoading.isVisible = true
                binding.layoutState.tvError.isVisible = false
                binding.layoutContent.root.isVisible = false
                binding.layoutContent.rvCart.isVisible = false
                binding.cvSectionOrder.isVisible = false
            },
            doOnError = { err ->
                binding.layoutState.root.isVisible = true
                binding.layoutState.pbLoading.isVisible = false
                binding.layoutState.tvError.isVisible = true
                binding.layoutState.tvError.text = err.exception?.message.orEmpty()
                binding.layoutContent.root.isVisible = false
                binding.layoutContent.rvCart.isVisible = false
                binding.cvSectionOrder.isVisible = false
            },
            doOnEmpty = { data ->
                binding.layoutState.root.isVisible = true
                binding.layoutState.pbLoading.isVisible = false
                binding.layoutState.tvError.isVisible = true
                binding.layoutState.tvError.text = getString(R.string.text_cart_is_empty)
                data.payload?.let { (_, totalPrice) ->
                    binding.tvTotalPrice.text = totalPrice.toCurrencyFormat()
                    sumBind.tvItemPrice.text = totalPrice.toCurrencyFormat()
                }
                binding.layoutContent.root.isVisible = false
                binding.layoutContent.rvCart.isVisible = false
                binding.cvSectionOrder.isVisible = false
            }
        ) }

        viewModel.cartList.observe(this){
            binding.btnCheckout.setOnClickListener {
                showToast(getString(R.string.checkout_success))
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}