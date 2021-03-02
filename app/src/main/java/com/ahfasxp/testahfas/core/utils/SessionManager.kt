package com.ahfasxp.testahfas.core.utils

import android.content.Context
import com.ahfasxp.testahfas.R

class SessionManager(context: Context) {
    private val preferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String?) {
        val editor = preferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return preferences.getString(USER_TOKEN, null)
    }

    /**
     * Function to delete auth token
     */
    fun deleteAuthToken() {
        preferences.edit().clear().clear().commit()
    }
}