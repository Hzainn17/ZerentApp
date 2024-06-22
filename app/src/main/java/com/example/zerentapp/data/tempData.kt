package com.example.zerentapp.data

import com.example.zerentapp.R
import com.example.zerentapp.model.ChatList

object tempData {
    val chatList = listOf(
        ChatList(
            id = 1,
            user = "Kumii",
            role = "sender",
            textchat = "Fix yaaa??",
            photo = R.drawable.ku
        ),
        ChatList(
            id = 2,
            user = "Juna",
            role = "sender",
            textchat = "unruk tangal 13 juni bisa?",
            photo = R.drawable.jun
        )
    )
}