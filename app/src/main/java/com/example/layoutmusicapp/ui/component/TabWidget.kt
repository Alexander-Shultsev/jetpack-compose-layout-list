package com.example.layoutmusicapp.ui.component

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.layoutmusicapp.ui.theme.Gray100
import com.example.layoutmusicapp.ui.theme.Orange100

@Composable
fun TabWidget(
    items: List<String>,
    selectedTabIndexValue: Int = 0
) {
    val selectedTabIndex by remember { mutableStateOf(selectedTabIndexValue) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.White,
//        contentColor = Gray100
    ) {
        items.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { /*TODO*/ },
                text = { Text(title) },
                selectedContentColor = Orange100,
                unselectedContentColor = Gray100
            )
        }
    }

}