package com.coolsharp.coupang.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductCard(title: String, thumb: String, price: String) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(1.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .padding(0.dp) // Box 주변의 padding
                .shadow(
                    elevation = 10.dp, // 그림자 높이
                    shape = RoundedCornerShape(10.dp), // 그림자 모양
                    clip = true // 그림자를 Box 모양에 맞게 자르기
                )
                .background(Color.White) // Box 배경색 (선택 사항)
        ) {
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp.dp
            val colWidth = screenWidth / 2
            val imageWidth = colWidth - 10.dp
            val imageHeight = imageWidth * (181 / 165)
            GlideImage(
                model = thumb,
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(imageWidth)
                    .height(imageHeight)
                    .padding(5.dp) // 이미지 주변에 16dp 흰색 마진 추가
                    .clip(RoundedCornerShape(6.dp)) // 이미지에 둥근 모서리 적용
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),

                )
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = price + "원",
            style = TextStyle(
                fontSize = 17.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF202020),
            )
        )
    }
}