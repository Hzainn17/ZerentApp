package com.example.zerentapp.utils

import com.example.zerentapp.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Whishlist.route,
        Screen.Request.route,
        Screen.About.route,
        Screen.Order.route,
        Screen.Detail.route,

    )
}