package com.coolsharp.coupang.data.model

data class Products(
    val limit: Int = 0,
    val products: List<Product> = emptyList(),
    val skip: Int = 0,
    val total: Int = 0
)