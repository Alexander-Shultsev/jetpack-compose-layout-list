package com.example.layoutmusicapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.theme.Orange100

@Composable
fun SongsList() {
    Column(modifier = Modifier
        .padding(horizontal = 18.dp)
    ) {
        for (item in 1..100) {
             SongsListItem()
        }
    }
}

@Composable
fun SongsListItem() {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .size(60.dp),
            contentDescription = null)

        Column(modifier = Modifier
            .padding(start = 16.dp)
            .weight(1f)
        ) {
            Title2(
                title ="Somebody’s Nobody",
                modifier = Modifier
                    .padding(bottom = 7.dp))

            Subtitle2("Alexander 23")
        }

        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable {  },
            tint = Orange100,
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null)
    }
}