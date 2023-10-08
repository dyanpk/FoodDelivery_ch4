package com.hungry.fooddelivery.presentation.feature.home.adapter.model

import com.hungry.fooddelivery.model.Category
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.presentation.feature.home.adapter.HomeAdapter
import com.hungry.fooddelivery.utils.ResultWrapper

sealed class HomeSection (val id : Int){
    data object HeaderSection : HomeSection(HomeAdapter.ITEM_TYPE_HEADER)
    data object BannerSection : HomeSection(HomeAdapter.ITEM_TYPE_BANNER)
    data class CategoriesSection(val data : List<Category>) : HomeSection(HomeAdapter.ITEM_TYPE_CATEGORY_LIST)
    data class MenusSection(val data : ResultWrapper<List<Menu>>) : HomeSection(HomeAdapter.ITEM_TYPE_MENU_LIST)
}