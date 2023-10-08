package com.hungry.fooddelivery.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hungry.fooddelivery.data.local.preferences.UserPreferenceDataSource
import com.hungry.fooddelivery.data.repository.MenuRepository
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.presentation.feature.home.adapter.model.HomeSection
import com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter.AdapterLayoutMode
import com.hungry.fooddelivery.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repo: MenuRepository
) : ViewModel() {

    val homeData: LiveData<List<HomeSection>>
        get() = repo.getMenu().map {
            mapToHomeData(it)
        }.asLiveData(Dispatchers.IO)


    private fun mapToHomeData(menuResult: ResultWrapper<List<Menu>>) : List<HomeSection> = listOf(
        HomeSection.HeaderSection,
        HomeSection.BannerSection,
        HomeSection.CategoriesSection(repo.getCategories()),
        HomeSection.MenusSection(menuResult)
    )

}