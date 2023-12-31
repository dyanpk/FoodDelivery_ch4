package com.hungry.fooddelivery.presentation.feature.detail

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hungry.fooddelivery.data.repository.CartRepository
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.utils.ResultWrapper
import kotlinx.coroutines.launch

class DetailViewModel (
    private val extras: Bundle?,
    private val cartRepository: CartRepository
): ViewModel(){

    val menu = extras?.getParcelable<Menu>(DetailActivity.EXTRA_MENU)

    val priceLiveData = MutableLiveData<Double>().apply {
        postValue(0.0)
    }
    val menuCountLiveData = MutableLiveData<Int>().apply {
        postValue(0)
    }
    private val _addToCartResult = MutableLiveData<ResultWrapper<Boolean>>()

    val addToCartResult: LiveData<ResultWrapper<Boolean>>
        get() = _addToCartResult

    fun add() {
        val count = (menuCountLiveData.value ?: 0) + 1
        menuCountLiveData.postValue(count)
        priceLiveData.postValue(menu?.priceOfMenu?.times(count) ?: 0.0)
    }

    fun minus() {
        if ((menuCountLiveData.value ?: 0) > 0) {
            val count = (menuCountLiveData.value ?: 0) - 1
            menuCountLiveData.postValue(count)
            priceLiveData.postValue(menu?.priceOfMenu?.times(count) ?: 0.0)
        }
    }

    fun addToCart() {
        viewModelScope.launch {
            val menuQuantity =
                if ((menuCountLiveData.value ?: 0) <= 0) 1 else menuCountLiveData.value ?: 0
            menu?.let {
                cartRepository.createCart(it, menuQuantity).collect { result ->
                    _addToCartResult.postValue(result)
                }
            }
        }
    }

/*    fun navigateToGoogleMap() {
        val locationUrl = menu?.locationUrlMenu
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(locationUrl))
        startActivity(intent)
    }*/

}