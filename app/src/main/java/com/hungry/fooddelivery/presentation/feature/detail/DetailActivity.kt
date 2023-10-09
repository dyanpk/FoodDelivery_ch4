package com.hungry.fooddelivery.presentation.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.hungry.fooddelivery.data.local.database.AppDatabase
import com.hungry.fooddelivery.data.local.database.datasource.CartDataSource
import com.hungry.fooddelivery.data.local.database.datasource.CartDatabaseDataSource
import com.hungry.fooddelivery.data.repository.CartRepository
import com.hungry.fooddelivery.data.repository.CartRepositoryImpl
import com.hungry.fooddelivery.databinding.ActivityDetailBinding
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.utils.GenericViewModelFactory
import com.hungry.fooddelivery.utils.proceedWhen
import com.hungry.fooddelivery.utils.toCurrencyFormat

class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailViewModel by viewModels {
        val database = AppDatabase.getInstance(this)
        val cartDao = database.cartDao()
        val cartDataSource: CartDataSource = CartDatabaseDataSource(cartDao)
        val repo: CartRepository= CartRepositoryImpl(cartDataSource)
        GenericViewModelFactory.create(
            DetailViewModel(intent?.extras, repo)
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindMenu(viewModel.menu)
        observeData()
        setClickListener()
    }

    private fun bindMenu(menu: Menu?) {
        menu?.let { item ->
            binding.ivItemMenu.load(item.imgUrlMenu){
                crossfade(true)
            }
            binding.tvNameOfMenu.text = item.nameOfMenu
            binding.tvDescMenu.text = item.descOfMenu
            binding.tvPriceOfMenu.text = item.priceOfMenu.toCurrencyFormat()
            binding.tvLocation.text = item.locationOfMenu
        }

    }

    private fun observeData() {
        viewModel.priceLiveData.observe(this) {
            binding.btnAddToCart.text = it.toCurrencyFormat()
        }
        viewModel.menuCountLiveData.observe(this) {
            binding.tvItemQuantity.text = it.toString()
        }
        viewModel.addToCartResult.observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    Toast.makeText(this, "Add to cart success !", Toast.LENGTH_SHORT).show()
                    finish()
                }, doOnError = {
                    Toast.makeText(this, it.exception?.message.orEmpty(), Toast.LENGTH_SHORT).show()
                })
        }
    }

    private fun setClickListener() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.icMinus.setOnClickListener {
            viewModel.minus()
        }
        binding.icPlus.setOnClickListener {
            viewModel.add()
        }
        binding.btnAddToCart.setOnClickListener {
            viewModel.addToCart()
        }
        /*binding.clLocation.setOnClickListener{
            viewModel.navigateToGoogleMap()
        }*/
    }

    companion object {
        const val EXTRA_MENU = "EXTRA_MENU"
        fun startActivity(context: Context, menu: Menu) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_MENU, menu)
            context.startActivity(intent)
        }
    }
}