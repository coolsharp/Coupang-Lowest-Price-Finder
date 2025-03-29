package com.coolsharp.coupang.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolsharp.coupang.data.model.Categories
import com.coolsharp.coupang.data.model.Products
import com.coolsharp.coupang.data.repository.CategoryRepository
import com.coolsharp.coupang.data.repository.DanawaProductsRepository
import com.coolsharp.coupang.data.repository.ProductsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val categoryRepository = CategoryRepository()
    private val _category = mutableStateOf<Categories>(Categories())
    val category: State<Categories> = _category

    val productsRepository= ProductsRepository()
    private val _products = mutableStateMapOf<String, Products>()
    val products: Map<String, Products> = _products

    val danawaProductsRepository = DanawaProductsRepository()

    fun getCategoryFetch() {
        viewModelScope.launch {
            categoryRepository.fetchCategory().body()?.let { _category.value = it }
        }
    }

    fun getProductFetch() {
        viewModelScope.launch {
            Log.d("coolsharp", "run launch")
            danawaProductsRepository.fetchProducts().body()?.let {
                Log.d("coolsharp", "res")
                Log.d("coolsharp", it)
            }
        }
    }

    suspend fun getProductsFetch(categoryOneDepth: String, categoryTwoDepth: String, category: String) {
        viewModelScope.async {
            productsRepository.fetchProducts(categoryOneDepth, categoryTwoDepth).body()?.let {
                _products[category] = it
            }
        }.await()
    }
}