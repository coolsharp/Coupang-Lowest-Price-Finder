package com.coolsharp.coupang.data.repository

import com.coolsharp.coupang.data.model.Products
import com.coolsharp.coupang.data.network.ProductService
import com.coolsharp.coupang.data.network.RetrofitHelper
import retrofit2.Response

class ProductsRepository {
    suspend fun fetchProducts(categoryOneDepth: String, categoryTwoDepth: String): Response<Products> {
        val productList = RetrofitHelper.getInstance().create(
            ProductService::class.java)
        return productList.getProducts(categoryOneDepth, categoryTwoDepth, 0)
    }
}