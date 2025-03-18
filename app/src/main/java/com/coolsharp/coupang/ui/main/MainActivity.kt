package com.coolsharp.coupang.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.coolsharp.coupang.ui.screen.OneDepthScrollableTabs
import com.coolsharp.coupang.ui.theme.CoupangLowPriceFinderTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CoupangLowPriceFinderTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),
                ) { innerPadding ->
                    MainUI(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainUI(modifier: Modifier = Modifier) {
//    TwoDepthScrollableTabs()
    OneDepthScrollableTabs()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Horizontal() {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoupangLowPriceFinderTheme {
        MainUI()
    }
}
