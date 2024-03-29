package com.kumpello.poker.domain.usecase

import android.util.Log
import com.kumpello.poker.data.model.authorization.AuthApi
import com.kumpello.poker.data.model.authorization.AuthData
import com.kumpello.poker.data.model.authorization.AuthResponse
import com.kumpello.poker.data.model.authorization.LogInRequestData
import com.kumpello.poker.data.model.authorization.SignUpRequestData
import com.kumpello.poker.data.services.RetrofitClient
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import java.util.Optional
import javax.inject.Inject

@ViewModelScoped
class AuthenticationService @Inject constructor() {

    private val retrofit = RetrofitClient.getClient()
    private val authApi = retrofit.create(AuthApi::class.java)

    fun signUp(username: String, email: String, password: String): AuthResponse {
        val authResponse = authApi.signUp(SignUpRequestData(username, email, password)).execute()
        logError(authResponse)
        return authResponse?.body() ?:
    }

    fun logIn(username: String, password: String): AuthResponse {
        val authResponse = authApi.login(LogInRequestData(username, password)).execute()
        logError(authResponse)
        return authResponse.body()
    }

    private fun logError(response: Response<AuthData>) {
        if (!response.isSuccessful) {
            Log.e("Authentication error: ", response.errorBody().toString())
        } else {
            Log.d("Authentication:", response.body().toString())
        }
    }

}