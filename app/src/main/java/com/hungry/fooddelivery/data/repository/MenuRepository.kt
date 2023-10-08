package com.hungry.fooddelivery.data.repository

import com.hungry.fooddelivery.data.dummy.DummyCategoryDataSource
import com.hungry.fooddelivery.data.local.database.datasource.MenuDataSource
import com.hungry.fooddelivery.data.local.database.mapper.toMenuList
import com.hungry.fooddelivery.model.Category
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.utils.ResultWrapper
import com.hungry.fooddelivery.utils.proceed
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

interface MenuRepository {
    fun getCategories(): List<Category>
    fun getMenu(): Flow<ResultWrapper<List<Menu>>>
}

class MenuRepositoryImpl(
    private val menuDataSource: MenuDataSource,
    private val dummyCategoryDataSource: DummyCategoryDataSource
) : MenuRepository {
    override fun getCategories(): List<Category> {
        return dummyCategoryDataSource.getMenuCategory()
    }

    override fun getMenu(): Flow<ResultWrapper<List<Menu>>> {
        return menuDataSource.getAllMenus().map {
            proceed { it.toMenuList() }
        }.onStart {
            emit(ResultWrapper.Loading())
            delay(2000)
        }
    }
}

