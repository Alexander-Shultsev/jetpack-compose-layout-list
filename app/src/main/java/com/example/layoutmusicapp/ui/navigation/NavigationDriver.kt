package com.example.layoutmusicapp.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.component.BottomNav
import com.example.layoutmusicapp.ui.screen.*
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()

    val navigationItem = listOf(
        NavigationItem.First,
        NavigationItem.Second,
        NavigationItem.Third,
        NavigationItem.MediaRecorder,
        NavigationItem.Location,
        NavigationItem.Oath,
        NavigationItem.EasyPayScreen,
    )

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier.size(20.dp))
            Text("Шапка")
            Divider(modifier = Modifier.height(3.dp))

            navigationItem.forEach { item ->
                Row(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(item.id) {
                                launchSingleTop = true
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                            }
                            scope.launch { drawerState.close() }
                        }
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp))
                    Text(item.title)
                }
            }
        },
        content = {
            Column {
                NavHost(navController = navController)
            }
        }
    )
}

sealed class NavigationItem(
    val id: String,
    val title: String,
    val icon: Int,
) {
    object First: NavigationItem(
        id = "first",
        title = "First",
        icon = R.drawable.ic_launcher_background
    )
    object Second: NavigationItem(
        id = "Second",
        title = "Second",
        icon = R.drawable.ic_launcher_background
    )
    object Third: NavigationItem(
        id = "third",
        title = "Third",
        icon = R.drawable.ic_launcher_background
    )
    object MediaRecorder: NavigationItem(
        id = "MediaRecorder",
        title = "Диктофон",
        icon = R.drawable.ic_launcher_background
    )
    object Location: NavigationItem(
        id = "Location",
        title = "Текущее местоположение",
        icon = R.drawable.ic_launcher_background
    )
    object Oath: NavigationItem(
        id = "Oath",
        title = "Oath авторизация",
        icon = R.drawable.ic_launcher_background
    )
    object EasyPayScreen: NavigationItem(
        id = "EasyPayScreen",
        title = "Вёрстка Easy Pay",
        icon = R.drawable.ic_launcher_background
    )
}

@Composable
fun NavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Location.id
    ) {
        composable(route = NavigationItem.First.id) {
            AddSongsScreen()
        }
        composable(route = NavigationItem.Second.id) {
            AlertDialogScreen()
        }
        composable(route = NavigationItem.Third.id) {
            BottomNav()
        }
        composable(route = NavigationItem.MediaRecorder.id) {
            MediaRecorderScreen()
        }
        composable(route = NavigationItem.Location.id) {
            LocationScreen()
        }
        composable(route = NavigationItem.Oath.id) {
            OathAuthorizationScreen()
        }
        composable(route = NavigationItem.EasyPayScreen.id) {
            EasyPayAppScreen()
        }
    }
}