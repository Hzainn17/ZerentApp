package com.example.zerentapp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.navigation.NavigationItem
import com.example.zerentapp.navigation.Screen
import com.example.zerentapp.presentation.screen.HomeScreen
import com.example.zerentapp.presentation.screen.LoginScreen
import com.example.zerentapp.presentation.screen.OnBoardingScreen
import com.example.zerentapp.presentation.screen.RegisterScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ZerentApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
        NavHost(
            navController = navController,
            startDestination = Screen.Onboarding.route,
        ) {
            composable(Screen.Onboarding.route){
                OnBoardingScreen(navController)
            }
            composable(Screen.Login.route){
                LoginScreen(navController)
            }
            composable(Screen.Register.route){
                RegisterScreen(navController)
            }
            composable(Screen.Home.route){
                HomeScreen(navController)
            }
        }

    }

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Request,
        BottomBarScreen.Whishlist,
        BottomBarScreen.Order,
        BottomBarScreen.About,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    Row (modifier = Modifier
        .background(Color(0xFF043C5B))
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically){


        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }

}

@Composable
fun AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val background =
        if (selected) Magenta.copy(alpha = 0.6f) else Color.Transparent

    val contentColor =
        if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(50.dp)
            .clip(CircleShape)
            //.background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(painter = painterResource(id = if (selected) screen.iconSelected else screen.icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp))
            AnimatedVisibility(visible = selected) {
//                Text(
//                    text = screen.title,
//                    color = contentColor
//                )
            }
        }
    }
}