package com.hungry.fooddelivery.model

import java.util.UUID


data class Category(
    val id: String = UUID.randomUUID().toString(),
    val imgUrlCategory: String,
    val nameOfCategory: String
)
