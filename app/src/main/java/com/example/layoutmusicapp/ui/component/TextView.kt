package com.example.layoutmusicapp.ui.component

import android.icu.text.CaseMap
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.layoutmusicapp.ui.theme.urbanist

@Composable
fun Subtitle1(title: String) =
    Text(
        text = title,
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = .2.sp
        ))

@Composable
fun Title1(title: String) =
    Text(
        text = title,
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.Bold,
        ))
