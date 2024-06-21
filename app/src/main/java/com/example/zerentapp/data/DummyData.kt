package com.example.zerentapp.data

import com.example.zerentapp.R
import com.example.zerentapp.model.Onboarding

object DummyData {
    val onboardings = listOf(
        Onboarding (
            title = "Temukan Kebutuhan Mu",
            description = "Dengan adanya berbagai fitur dapat dengan mudah menemukan barang yang diperlukan.",
            image = R.drawable.onboarding1
        ),
        Onboarding (
            title = "Dengan Katalog Barang\n" +
                    "dan Profile Toko",
            description = "Mempermudahmu menemukan barang serta toko yang ada di sekitar mu.",
            image = R.drawable.onboarding2
        ),
        Onboarding (
            title = "Request dan Dapatkan\n" +
                    "Barangmu",
            description = "Fitur request yang dapat membantu user mendapatkan barang yang ingin disewa.",
            image = R.drawable.onboarding3
        ),
        Onboarding (
            title = "Selamat Datang",
            description = "Ayo, temukan barang keperluanmu disini " +
                    "Kualitas Tanpa Kepemilikan, Nikmati dengan Sewa",
            image = R.drawable.logofix
        ),
    )
}