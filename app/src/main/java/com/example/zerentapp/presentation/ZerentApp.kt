package com.example.zerentapp.presentation

import Order
import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.navigation.NavigationItem
import com.example.zerentapp.navigation.Screen
import com.example.zerentapp.presentation.screen.HomeScreen
import com.example.zerentapp.presentation.screen.Login.Login
import com.example.zerentapp.presentation.screen.Login.LoginScreen
import com.example.zerentapp.presentation.screen.OnBoardingScreen
import com.example.zerentapp.presentation.screen.ProfileScreen
import com.example.zerentapp.presentation.screen.RegisterScreen
import com.example.zerentapp.presentation.screen.RequestScreen
import com.example.zerentapp.presentation.screen.VerifEmail
import com.example.zerentapp.presentation.screen.WhishlistScreen
import com.example.zerentapp.utils.shouldShowBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ZerentApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {



    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current


    Scaffold (
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ){ contentPadding->

        NavHost(
            navController = navController,
            startDestination = Screen.Onboarding.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Onboarding.route){
                OnBoardingScreen(navController)
            }
            composable(Screen.Login.route){
                Login(navController)
            }
            composable(Screen.Register.route){
                RegisterScreen(navController)
            }
            composable(Screen.VerifikasiEmail.route){
                VerifEmail(navController)
            }
            composable(Screen.Home.route){
                HomeScreen(navController)
            }

            composable(Screen.Request.route){
                RequestScreen(navController)
            }
            composable(Screen.Whishlist.route){
                WhishlistScreen(navController)
            }
            composable(Screen.Order.route){
                Order()
            }
            composable(Screen.About.route){
                ProfileScreen(navController)
            }
        }

    }
}


@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xff043C5B)) {

    NavigationBar (modifier = modifier.height(50.dp),
        containerColor = backgroundColor){

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = R.drawable.ic_home,
                iconSelected = R.drawable.ic_selected_home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Request",
                icon = R.drawable.ic_request,
                iconSelected = R.drawable.ic_selected_request,
                screen = Screen.Request
            ),
            NavigationItem(
                title = "Whishlist",
                icon = R.drawable.ic_whishlist,
                iconSelected = R.drawable.ic_selected_whishlist,
                screen = Screen.Whishlist
            ),
            NavigationItem(
                title = "Order",
                icon = R.drawable.ic_order,
                iconSelected = R.drawable.ic_selected_order,
                screen = Screen.Order
            ),
            NavigationItem(
                title = "Profile",
                icon = R.drawable.ic_profile,
                iconSelected = R.drawable.ic_selected_profile,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    val iconRes = if (currentRoute == item.screen.route) item.iconSelected else item.icon
                    Icon(painterResource(id  = iconRes),
                    contentDescription = item.title,
                    modifier.size(30.dp)
                    ) },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified,
                    selectedTextColor = Color.Unspecified,
                    unselectedTextColor = Color.Unspecified,
                    indicatorColor = Color(0xff043C5B)
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun InfiniteAppPrev() {
    ZerentApp()
}

