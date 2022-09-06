package com.example.layoutmusicapp.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.layoutmusicapp.R
import com.example.layoutmusicapp.ui.screen.screensForBottomNavigation.FirstScreen
import com.example.layoutmusicapp.ui.screen.screensForBottomNavigation.SecondScreen
import com.example.layoutmusicapp.ui.screen.screensForBottomNavigation.ThirdScreen
import com.example.layoutmusicapp.ui.theme.LayoutMusicAppTheme

@SuppressLint("StaticFieldLeak")
private lateinit var navController: NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNav() {
    navController = rememberNavController()

    val listItems = listOf (
        NavItems.First,
        NavItems.Second,
        NavItems.Third
    )

    Scaffold(bottomBar = {
        BottomNavigationMain(navController = navController, items = listItems)
    }) {
        MainNavHost(navHostController = navController as NavHostController)
    }
}

@Composable
fun MainNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavItems.First.route
    ) {
        composable(route = NavItems.First.route)
        {
            FirstScreen()
        }
        composable(route = NavItems.Second.route)
        {
            SecondScreen()
        }
        composable(route = NavItems.Third.route)
        {
            ThirdScreen()
        }
    }
}

sealed class NavItems(
    val route: String,
    val title: String,
    val icon: Int
) {
    object First : NavItems(
        route = "first",
        title = "First",
        icon = R.drawable.ic_add
    )
    object Second : NavItems(
        route = "second",
        title = "Second",
        icon = R.drawable.ic_add
    )
    object Third : NavItems(
        route = "third",
        title = "Third",
        icon = R.drawable.ic_add
    )
}

@Composable
fun BottomNavigationMain(items: List<NavItems>, navController: NavController) {
    val navBackStateEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStateEntry?.destination

    BottomNavigation(
        modifier = Modifier.background(Color.White)
    ) {
        items.forEach { elem ->
            BottomNavigationItem(
                selected = currentDestination?.route == elem.route,
                onClick = {
                    navController.navigate(elem.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                label = {
                    Text(text = elem.title)
                },
                icon = {
                    Icon(painter = painterResource(id = elem.icon), contentDescription = null)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true
            )
        }
    }
}