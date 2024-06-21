package com.example.zerentapp.utils

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKey {
    const val EMAIL_PREF = "login_preferences"
    const val EMAIL_KEY = "email"
    const val PASSWORD_KEY = "password"

    val STATUS_LOGIN_KEY = booleanPreferencesKey("status_login")
}