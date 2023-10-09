package com.hungry.fooddelivery.presentation.feature.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hungry.fooddelivery.data.repository.CartRepository
import kotlinx.coroutines.Dispatchers

class CheckoutViewModel(
    private val cartRepository: CartRepository
) : ViewModel(){
    val cartList = cartRepository.getUserCartData().asLiveData(Dispatchers.IO)
}