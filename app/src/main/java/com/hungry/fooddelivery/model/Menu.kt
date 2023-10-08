package com.hungry.fooddelivery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Menu(
    val id: Int? = null,
    val nameOfMenu: String,
    val imgUrlMenu: String,
    val priceOfMenu: Double,
    val descOfMenu: String,
    val locationOfMenu : String,
    val locationUrlMenu : String
) : Parcelable
