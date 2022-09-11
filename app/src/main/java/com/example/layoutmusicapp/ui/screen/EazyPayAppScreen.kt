package com.example.layoutmusicapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.component.EasyPaySubtitle1
import com.example.layoutmusicapp.ui.component.EasyPayTitle1
import com.example.layoutmusicapp.ui.component.Indicator
import com.example.layoutmusicapp.viewmodel.EasyPayViewModel

@Composable
fun EasyPayAppScreen(easyPayViewModel: EasyPayViewModel = viewModel()) {
    val loginCurrentIndicator = easyPayViewModel.loginCurrentIndicator.observeAsState(0)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_login),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .padding(vertical = 24.dp)
        ) {
            for(item in easyPayViewModel.infoOnLoginScreen) {
                Indicator(
                    isActive = loginCurrentIndicator.value == item.position,
                    onClick = { easyPayViewModel.setLoginCurrentIndicator(item.position) }
                )
            }
        }
        for(item in easyPayViewModel.infoOnLoginScreen) {
            if (loginCurrentIndicator.value == item.position) {
                EasyPayTitle1(
                    title = item.title,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )
                EasyPaySubtitle1(
                    title = item.subtitle,
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 20.dp)
                        .padding(horizontal = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EasyPayAppScreenPreview() {
    Surface(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        EasyPayAppScreen()
    }
}