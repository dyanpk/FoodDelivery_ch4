package com.hungry.fooddelivery.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.hungry.fooddelivery.data.local.database.entity.MenuEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {

    @Query("SELECT * FROM MENUS")
    fun getAllMenus(): Flow<List<MenuEntity>>

    @Query("Select * FROM MENUS WHERE id == :id")
    fun getMenuById(id: Int): Flow<MenuEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenus(menu: List<MenuEntity>)

    @Delete
    suspend fun deleteMenu(menu: MenuEntity): Int

    @Update
    suspend fun updateMenu(menu: MenuEntity): Int
}