package com.coolsharp.coupang.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.coolsharp.coupang.data.model.Products
import com.coolsharp.coupang.ui.viewmodel.MainViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerUi(pagerState: PagerState, category: String) {
    Log.w("coolsharp", "category : ${category}")

    val viewModel = MainViewModel()

    Log.d("coolsharp", "launched")
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { page ->

        val items = remember { mutableStateOf(Products()) }

        LaunchedEffect(Unit) {
            var pathOneDepth = "category"
            var pathTwoDepth = category
            if (category == "all") {
                pathOneDepth = ""
                pathTwoDepth = ""
            }
            viewModel.getProductsFetch(pathOneDepth, pathTwoDepth, category)

            viewModel.products[category]?.let {
                Log.d("coolsharp", "in")
                items.value = it
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items?.value?.let {
                items(it.products.size) { index ->
                ProductCard(it.products[index].title, it.products[index].thumbnail, it.products[index].price.toString())
            }
            }
        }
    }
}