package com.example.layoutmusicapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.base.ButtonMain
import com.example.layoutmusicapp.ui.component.EasyPaySubtitle1
import com.example.layoutmusicapp.ui.component.EasyPayTitle1
import com.example.layoutmusicapp.ui.component.Indicator
import com.example.layoutmusicapp.ui.theme.EasyPayGrayLight
import com.example.layoutmusicapp.ui.theme.IBMPlexSans
import com.example.layoutmusicapp.ui.theme.roboto
import com.example.layoutmusicapp.viewmodel.EasyPayStartViewModel


@Composable
fun EasyPayMainScreen() {

    Surface(
        modifier = Modifier
            .background(EasyPayGrayLight)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding()
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.img_logo_main),
                    contentDescription = null,
                    modifier = Modifier
                        .width(130.dp)
                        .height(30.dp)
                )
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            "Hi, Samantha",
                            style = TextStyle(
                                fontFamily = roboto,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            "Your available balance",
                            style = TextStyle(
                                fontFamily = roboto,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }

                    Text(
                        "₹4,590.00",
                        style = TextStyle(
                            fontFamily = IBMPlexSans,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EasyPayMainScreenPreview() {
    EasyPayMainScreen()
}