package com.kumpello.poker.app

import android.accounts.AccountManager
import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
object PokerApplication: Application() {
    val accountManager: AccountManager = AccountManager.get(this)

    private val mainKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private const val preferencesName = "secret_keeper"
    private const val userIDKey = "user_id"
    private const val authTokenKey = "auth_token"
    private const val authRefreshTokenKey = "auth_refresh_token"

    private val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        preferencesName,
        mainKey,
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveUserID(id: String) {
        sharedPreferences.edit().putString(userIDKey, id).apply()
    }

    fun getUserID(): String? {
        return sharedPreferences.getString(userIDKey, null)
    }

    fun saveAuthToken(token: String) {
        sharedPreferences.edit().putString(authTokenKey, token).apply()
    }

    fun getAuthToken(): String? {
        return sharedPreferences.getString(authTokenKey, null)
    }

    fun saveAuthRefreshToken(token: String) {
        sharedPreferences.edit().putString(authRefreshTokenKey, token).apply()
    }

    fun getAuthRefreshToken(): String? {
        return sharedPreferences.getString(authRefreshTokenKey, null)
    }
}