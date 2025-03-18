package com.coolsharp.coupang.data.repository

import com.coolsharp.coupang.data.model.Categories
import com.coolsharp.coupang.data.model.CategoryItem
import com.coolsharp.coupang.data.network.CategoryService
import com.coolsharp.coupang.data.network.RetrofitHelper
import retrofit2.Response

class CategoryRepository {
    suspend fun fetchCategory(): Response<Categories> {
        val categoryService = RetrofitHelper.getInstance().create(
            CategoryService::class.java)
        val category = categoryService.getCategory()
        category.body()?.add(0, CategoryItem("All", "all", ""))
        return category
    }
}