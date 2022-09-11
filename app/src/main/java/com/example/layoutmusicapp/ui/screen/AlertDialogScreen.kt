package com.example.layoutmusicapp.ui.screen

import android.app.AlertDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.ui.component.Dialog
import com.example.layoutmusicapp.ui.component.MainTopAppBar
import com.example.layoutmusicapp.ui.component.SongsList
import com.example.layoutmusicapp.ui.component.TabWidget
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme
import com.example.layoutmusicapp.viewmodel.AlertDialogViewModel

@Composable
fun AlertDialogScreen(alertDialogViewModel: AlertDialogViewModel = viewModel()) {
    val showDialog = alertDialogViewModel.showDialog.observeAsState(false)
    val dialogText = alertDialogViewModel.dialogText.observeAsState("")

    LayoutMusicAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            if (showDialog.value) {
                Dialog(
                    changeText = {
                        alertDialogViewModel.changeDialogText(it)
                    },
                    changeVisibility = {
                        alertDialogViewModel.changeVisibleDialog()
                    }
                )
            }
        }
        LazyColumn {
            item {
                Button(onClick = { alertDialogViewModel.changeVisibleDialog() }) {
                    Text(text = "Показать диалоговое окно")
                }
            }
            item {
                Text(text = dialogText.value.toString())
            }
        }
    }
}