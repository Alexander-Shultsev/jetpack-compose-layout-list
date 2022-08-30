package com.example.layoutmusicapp.ui.component

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutmusicapp.ui.theme.Gray100
import com.example.layoutmusicapp.ui.theme.Orange100
import com.example.layoutmusicapp.viewmodel.AddSongsViewModel

@Composable
fun TabWidget(
    items: List<String>,
    selectedTabIndexValue: Int = 0,
    addSongsViewModel: AddSongsViewModel
) {
    var selectedTabIndex by remember { mutableStateOf(selectedTabIndexValue) }

    Box(modifier = Modifier
        .background(Color.White)) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.White,
            indicator = {
                Box(
                    Modifier
                        .tabIndicatorOffset(it[selectedTabIndex])
                        .height(4.dp)
                        .background(Orange100)
                )
            }
        ) {
            items.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        addSongsViewModel.changeSelectedTab(selectedTabIndex)
                    },
                    text = { Subtitle1(title) },
                    selectedContentColor = Orange100,
                    unselectedContentColor = Gray100
                )
            }
        }
    }
}