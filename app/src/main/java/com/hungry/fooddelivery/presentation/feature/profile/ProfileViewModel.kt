package com.hungry.fooddelivery.presentation.feature.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _username = MutableLiveData<String>().apply {
        value = "Username"
    }

    private val _password = MutableLiveData<String>().apply {
        value = "Password"
    }

    private val _email = MutableLiveData<String>().apply {
        value = "E-Mail"
    }

    private val _phone = MutableLiveData<String>().apply {
        value = "Phone Number"
    }

    val username: LiveData<String> = _username
    val password: LiveData<String> = _password
    val email: LiveData<String> = _email
    val phone: LiveData<String> = _phone
}
