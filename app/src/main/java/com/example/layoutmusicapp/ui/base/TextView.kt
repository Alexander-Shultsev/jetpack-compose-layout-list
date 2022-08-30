package com.example.layoutmusicapp.ui.component

import android.icu.text.CaseMap
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.layoutmusicapp.ui.theme.Gray200
import com.example.layoutmusicapp.ui.theme.urbanist

@Composable
fun Subtitle1(title: String, modifier: Modifier = Modifier) =
    Text(
        text = title,
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = .2.sp
        ),
        modifier = modifier)

@Composable
fun Subtitle2(title: String, modifier: Modifier = Modifier) =
    Text(
        text = title,
        style = TextStyle(
            fontSize = 11.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.Medium,
            color = Gray200
        ),
        modifier = modifier)

@Composable // toolbar
fun Title1(title: String, modifier: Modifier = Modifier) =
    Text(
        text = title,
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.Bold,
        ),
        modifier = modifier)

@Composable
fun Title2(title: String, modifier: Modifier = Modifier) =
    Text(
        text = title,
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.Bold,
        ),
        modifier = modifier)
