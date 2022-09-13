package com.example.layoutmusicapp.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutmusicapp.ui.component.EasyPayTitleButton

@Composable
fun ButtonMain(
    onClick: () -> Unit,
    text: String,
    thisBackground: Boolean = true
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(6.dp),
        colors =
            if (thisBackground)
                ButtonDefaults.buttonColors(Color.Black)
            else
                ButtonDefaults.buttonColors(Color.White),
        border = BorderStroke(
            if (thisBackground) 0.dp else 3.dp,
            Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        EasyPayTitleButton(
            title = text,
            color = if (thisBackground) Color.White else Color.Black
        )
    }
}