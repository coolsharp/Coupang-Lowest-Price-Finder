package com.coolsharp.coupang.data.network

import com.coolsharp.coupang.data.model.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ProductService {
    @GET("/products/{categoryOneDepth}/{categoryTwoDepth}")
    suspend fun getProducts(
        @Path(value = "categoryOneDepth") categoryOneDepth: String,
        @Path(value = "categoryTwoDepth") categoryTwoDepth: String,
        @Query("skip") skip: Int,
    ): Response<Products>
}