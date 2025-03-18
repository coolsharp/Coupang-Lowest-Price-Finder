package com.coolsharp.coupang.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.coolsharp.coupang.ui.viewmodel.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OneDepthScrollableTabs() {
    val viewModel = MainViewModel()
    var tabs by remember { mutableStateOf(viewModel.category) }
    var parentTabIndex by remember { mutableStateOf(0) }
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState =
        rememberPagerState(initialPage = selectedTabIndex, pageCount = { tabs.value.size })

    LaunchedEffect(Unit) {
        viewModel.getCategoryFetch()
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.scrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }

    if (0 < tabs.value.size) {
        Column {
            ScrollableTabRow(
                modifier = Modifier
                    .height(40.dp)
                    .padding(horizontal = 0.dp),
                containerColor = Color.White,
                contentColor = Color.White,
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp,
                divider = { HorizontalDivider(color = Color.White) },
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .padding(horizontal = 0.dp, vertical = 0.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Blue)
                    )
                }
            ) {
                tabs.value.forEachIndexed { index, tab ->
                    Tab(
                        selected = index == selectedTabIndex,
                        text = {
                            val color =
                                remember { mutableStateOf(if (index == selectedTabIndex) Color.Black else Color.Black) }
                            val animatedColor = animateColorAsState(
                                targetValue = color.value,
                                animationSpec = tween(durationMillis = 250),
                                label = ""
                            )
                            Text(
                                text = tab.name,
                                color = animatedColor.value,
                                fontWeight = if (index == selectedTabIndex) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        onClick = {
                            selectedTabIndex = index
                        },
                        modifier = Modifier
                            .padding(animateDpAsState(if (index == selectedTabIndex) 0.dp else 0.dp).value)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                animateColorAsState(
                                    if (index == selectedTabIndex) Color.Transparent else Color.Transparent,
                                    animationSpec = tween(durationMillis = 250),
                                    label = ""
                                ).value
                            )
                            .padding(0.dp)
                    )
                }
            }

            HorizontalPagerUi(pagerState, tabs.value[selectedTabIndex].slug)
        }
    }
}