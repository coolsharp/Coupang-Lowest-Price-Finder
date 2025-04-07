package com.coolsharp.coupang.data.model

import androidx.compose.runtime.mutableStateOf

data class DanawaProducts(
    val products: MutableList<DanawaProduct> = mutableListOf<DanawaProduct>(),
)