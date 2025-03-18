package com.coolsharp.coupang.data.network

import com.coolsharp.coupang.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET


interface CategoryService {
    @GET("/products/categories")
    suspend fun getCategory(
    ): Response<Categories>
}