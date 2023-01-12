package com.kumpello.poker.app

import android.accounts.AccountManager
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
object PokerApplication: Application() {
    val accountManager: AccountManager = AccountManager.get(this)
}