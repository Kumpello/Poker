package com.kumpello.poker.domain.usecase

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Authentication @Inject constructor() {

    fun signUp(username: String, email: String, password: String) {

    }

    fun logIn(username: String, password: String) {

    }
    
}