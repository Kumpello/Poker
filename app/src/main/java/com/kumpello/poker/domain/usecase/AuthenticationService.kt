package com.kumpello.poker.domain.usecase

import android.util.Log
import com.kumpello.poker.data.model.AuthApi
import com.kumpello.poker.data.model.AuthResponseData
import com.kumpello.poker.data.model.LogInRequestData
import com.kumpello.poker.data.model.SignUpRequestData
import com.kumpello.poker.data.services.RetrofitClient
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import java.util.Optional
import javax.inject.Inject

@ViewModelScoped
class AuthenticationService @Inject constructor() {

    private val retrofit = RetrofitClient.getClient()
    private val authApi = retrofit.create(AuthApi::class.java)

    fun signUp(username: String, email: String, password: String): Optional<AuthResponseData> {
        val authResponse = authApi.signUp(SignUpRequestData(username, email, password)).execute()
        logError(authResponse)
        Log.e("SignUp:", authResponse.errorBody().toString())
        Log.d("SignUp:", authResponse.body().toString())
        return Optional.ofNullable(authResponse.body())
    }

    fun logIn(username: String, password: String): Optional<AuthResponseData> {
        val authResponse = authApi.login(LogInRequestData(username, password)).execute()
        logError(authResponse)
        return Optional.ofNullable(authResponse.body())
    }

    private fun logError(response: Response<AuthResponseData>) {
        if (!response.isSuccessful) {
            Log.e("Authentication error: ", response.errorBody().toString())
        }
    }

}