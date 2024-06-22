package com.example.zerentapp.navigation

sealed class Screen (val route : String) {
    data object Onboarding : Screen("onboarding")
    data object Home : Screen("home")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object VerifikasiEmail : Screen("verifemail")
    data object Request : Screen("request")
    data object Whishlist : Screen("whishlist")
    data object Order : Screen("order")
    data object About : Screen("about")

    data object ProfileSetting : Screen("profilesetting")
    data object Bantuan : Screen("bantuan")
    data object Toko : Screen("toko")
    data object PostingBarang : Screen("postingbarang")

    data object Chat : Screen("chat")
    data object chatDetail : Screen("chatdetail")

    data object Detail : Screen("detail")
    data object Result : Screen("result")
    data object Check : Screen("check")
    data object Done : Screen("done")
    data object ResultFailed : Screen("fail")


}