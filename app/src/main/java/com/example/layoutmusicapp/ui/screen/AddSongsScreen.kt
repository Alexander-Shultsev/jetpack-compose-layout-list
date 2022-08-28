package com.example.layoutmusicapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.ui.component.MainTopAppBar
import com.example.layoutmusicapp.ui.component.TabWidget
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme
import com.example.layoutmusicapp.viewmodel.AddSongsViewModel

@Composable
fun AddSongsScreen(addSongsViewModel: AddSongsViewModel = viewModel()) {
    LayoutMusicAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
                item { MainTopAppBar() }
                item { TabWidget(addSongsViewModel.tabElem) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutMusicAppTheme {
        AddSongsScreen()
    }
}