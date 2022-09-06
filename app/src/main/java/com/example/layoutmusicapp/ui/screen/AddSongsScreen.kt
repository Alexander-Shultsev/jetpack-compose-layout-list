package com.example.layoutmusicapp.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.ui.component.MainTopAppBar
import com.example.layoutmusicapp.ui.component.SongsList
import com.example.layoutmusicapp.ui.component.TabWidget
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme
import com.example.layoutmusicapp.viewmodel.AddSongsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddSongsScreen(addSongsViewModel: AddSongsViewModel = viewModel()) {
    val selectedTab by addSongsViewModel.selectedTab.observeAsState(0)

    LayoutMusicAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
                stickyHeader {
                    Column {
                        MainTopAppBar()
                        TabWidget(
                            items = addSongsViewModel.tabElem,
                            addSongsViewModel = addSongsViewModel)
                    }
                }
                item {
                    when(selectedTab) {
                        0 -> SongsList()
                        1 -> Text("1")
                        2 -> Text("2")
                    }
                }
            }
        }
    }
}