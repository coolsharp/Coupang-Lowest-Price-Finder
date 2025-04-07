package com.coolsharp.coupang.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolsharp.coupang.data.model.Categories
import com.coolsharp.coupang.data.model.DanawaProduct
import com.coolsharp.coupang.data.model.DanawaProducts
import com.coolsharp.coupang.data.model.Product
import com.coolsharp.coupang.data.model.Products
import com.coolsharp.coupang.data.repository.CategoryRepository
import com.coolsharp.coupang.data.repository.DanawaProductsRepository
import com.coolsharp.coupang.data.repository.ProductsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MainViewModel : ViewModel() {
    val categoryRepository = CategoryRepository()
    private val _category = mutableStateOf<Categories>(Categories())
    val category: State<Categories> = _category

    val productsRepository= ProductsRepository()
    private val _products = mutableStateMapOf<String, Products>()
    val products: Map<String, Products> = _products

    val danawaProductsRepository = DanawaProductsRepository()
    private val _danawaProducts = mutableStateOf(DanawaProducts())
    val danawaProducts: DanawaProducts = _danawaProducts.value

    fun getCategoryFetch() {
        viewModelScope.launch {
            categoryRepository.fetchCategory().body()?.let { _category.value = it }
        }
    }

    suspend fun getProductsFetch() {
        viewModelScope.async {
            danawaProductsRepository.fetchProducts().body()?.let {
                Log.d("coolsharp", "size : " + danawaProducts.products.size)
                var document: Document = Jsoup.parse(it)
                var element = document.getElementsByClass("prod_item")

                for (i in element) {
                    val thumb = i.getElementsByClass("thumb_img")
                    val url = "https:" + thumb.attr("data-original").ifEmpty { thumb.attr("src") }
                    val link = i.select("a").attr("href")
                    val title = thumb.attr("alt")
                    val num = i.getElementsByClass("num").text()
                    danawaProducts.products.add(DanawaProduct(num, title, url, link))
                    Log.d("coolsharp", link)
//                    Log.d("coolsharp", thumb.toString())
                }
            }
        }.await()
    }

    suspend fun getProductsFetch(categoryOneDepth: String, categoryTwoDepth: String, category: String) {
        viewModelScope.async {
            productsRepository.fetchProducts(categoryOneDepth, categoryTwoDepth).body()?.let {
                _products[category] = it
            }
        }.await()
    }
}