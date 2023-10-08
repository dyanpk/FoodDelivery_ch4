package com.hungry.fooddelivery.data.local.database.mapper

import com.hungry.fooddelivery.data.local.database.entity.MenuEntity
import com.hungry.fooddelivery.model.Menu

fun MenuEntity?.toMenu() = Menu(
    id = this?.id ?: 0,
    nameOfMenu = this?.nameOfMenu.orEmpty(),
    imgUrlMenu = this?.imgUrlMenu.orEmpty(),
    priceOfMenu = this?.priceOfMenu ?: 0.0,
    descOfMenu = this?.descOfMenu.orEmpty(),
    locationOfMenu = this?.locationOfMenu.orEmpty(),
    locationUrlMenu = this?.locationUrlMenu.orEmpty()
)
fun Menu?.toMenuEntity() = MenuEntity(
    id = this?.id ?: 0,
    nameOfMenu = this?.nameOfMenu.orEmpty(),
    imgUrlMenu = this?.imgUrlMenu.orEmpty(),
    priceOfMenu = this?.priceOfMenu ?: 0.0,
    descOfMenu = this?.descOfMenu.orEmpty(),
    locationOfMenu = this?.locationOfMenu.orEmpty(),
    locationUrlMenu = this?.locationUrlMenu.orEmpty()
)

fun List<MenuEntity?>.toMenuList() = this.map { it.toMenu() }
fun List<Menu?>.toMenuEntity() = this.map { it.toMenuEntity() }


