package com.example.layoutmusicapp.ui.component

import android.app.AlertDialog
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.example.layoutmusicapp.viewmodel.AlertDialogViewModel

@Composable
fun Dialog(
    changeText: (dialogText: String) -> Unit,
    changeVisibility: () -> Unit,
) {
    val dialogText = remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { changeVisibility() },
        title = { Text("Заголовок") },
        text = {
            TextField(
                value = dialogText.value,
                onValueChange = {
                    dialogText.value = it
                }
            )
        },
        confirmButton = {
            Button(onClick = {
                changeVisibility()
                changeText(dialogText.value)}
            ) {
                Text(text = "OK")
            }
        }
    )
}
