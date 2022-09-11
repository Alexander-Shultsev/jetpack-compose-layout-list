package com.example.layoutmusicapp.ui.component

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.theme.Orange100

@Composable
fun SongsList() {
    Column(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .padding(top = 10.dp)
    ) {
        for (item in 0..10) {
            SongsListItem(item)
        }
    }
}

@Composable
fun SongsListItem(number: Int) {
    var addSongsStatus by remember { mutableStateOf(false) }

    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable {
                Toast
                    .makeText(context, number.toString(), Toast.LENGTH_SHORT)
                    .show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageView(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaytfpFF7DhpFlyNStvoSloA_hGLvMD2CmcIomfVdv&s",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .size(60.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Title2(
                title = "Somebody’s Nobody",
                modifier = Modifier
                    .padding(bottom = 7.dp)
            )

            Subtitle2("Alexander 23")
        }

        IconButton(onClick = { addSongsStatus = !addSongsStatus }) {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                tint = Orange100,
                painter = painterResource(
                    id = if (addSongsStatus) R.drawable.ic_added else R.drawable.ic_add
                ),
                contentDescription = null
            )
        }
    }
}
