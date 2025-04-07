package com.coolsharp.coupang.data.model

import androidx.compose.runtime.mutableStateOf

data class Products(
    val limit: Int = 0,
    val products: MutableList<Product> = mutableListOf<Product>(),
    val skip: Int = 0,
    val total: Int = 0
)