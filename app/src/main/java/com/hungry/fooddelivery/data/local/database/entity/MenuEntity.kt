package com.hungry.fooddelivery.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menus")
data class MenuEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name_of_menu")
    val nameOfMenu: String,
    @ColumnInfo(name = "img_url_menu")
    val imgUrlMenu: String,
    @ColumnInfo(name = "price_of_menu")
    val priceOfMenu: Double,
    @ColumnInfo(name = "desc_of_menu")
    val descOfMenu: String,
    @ColumnInfo(name = "location_of_menu")
    val locationOfMenu : String,
    @ColumnInfo(name = "location_url_menu")
    val locationUrlMenu : String
)
