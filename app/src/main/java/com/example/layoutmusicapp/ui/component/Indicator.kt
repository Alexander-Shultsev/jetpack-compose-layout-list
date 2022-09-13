package com.example.layoutmusicapp.ui.component

import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutmusicapp.ui.screen.EasyPayAppScreen
import com.example.layoutmusicapp.ui.theme.EasyPayGray100

@Composable
fun Indicator(
    isActive: Boolean = false,
    onClick: () -> Unit = {},
) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(4.dp))
                .size(13.dp)
                .background(EasyPayGray100)
                .border(
                    if (isActive) 2.dp else 0.dp,
                    if (isActive) Color.Black else EasyPayGray100
                )
                .clickable { onClick() }
        )
}

@Preview(showBackground = false)
@Composable
fun IndicationPreview() {
    Indicator()
}