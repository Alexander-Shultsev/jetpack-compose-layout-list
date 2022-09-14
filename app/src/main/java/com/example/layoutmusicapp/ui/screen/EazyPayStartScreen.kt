package com.example.layoutmusicapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.base.ButtonMain
import com.example.layoutmusicapp.ui.component.EasyPaySubtitle1
import com.example.layoutmusicapp.ui.component.EasyPayTitle1
import com.example.layoutmusicapp.ui.component.Indicator
import com.example.layoutmusicapp.viewmodel.EasyPayStartViewModel

// https://www.figma.com/file/5xGpvwli4ZFkna4PEc0Wnk/EasyPay%3A-E-Wallet-Digital-Payment-App-(Community)?node-id=1%3A41

@Composable
fun EasyPayAppScreen(easyPayViewModel: EasyPayStartViewModel = viewModel()) {
    val loginCurrentIndicator = easyPayViewModel.loginCurrentIndicator.observeAsState(0)

    Column {
        Image(
            painter = painterResource(id = R.drawable.img_login),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(.6f),
            contentScale = ContentScale.Crop
        )

        // Переклчатель
        Column(
            modifier = Modifier
                .weight(.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Индикаторы
            Row(
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 22.dp)
            ) {
                for (item in easyPayViewModel.infoOnLoginScreen) {
                    Indicator(
                        isActive = loginCurrentIndicator.value == item.position,
                        onClick = { easyPayViewModel.setLoginCurrentIndicator(item.position) }
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }

            // Тексты
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (item in easyPayViewModel.infoOnLoginScreen) {
                    if (loginCurrentIndicator.value == item.position) {
                        EasyPayTitle1(
                            title = item.title
                        )
                        EasyPaySubtitle1(
                            title = item.subtitle,
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 30.dp)
                        )
                    }
                }
            }
        }

        // Кнопки авторизации и регистрации
        Column(
            modifier = Modifier
                .height(140.dp)
                .padding(horizontal = 20.dp)
        ) {
            ButtonMain(
                onClick = {},
                text = "Login",
            )
            Spacer(modifier = Modifier.height(10.dp))
            ButtonMain(
                onClick = {},
                text = "Sign Up",
                thisBackground = false
            )
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