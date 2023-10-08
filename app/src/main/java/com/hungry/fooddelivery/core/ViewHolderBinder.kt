package com.hungry.fooddelivery.core

interface ViewHolderBinder<T> {
    fun bind(item: T)
}