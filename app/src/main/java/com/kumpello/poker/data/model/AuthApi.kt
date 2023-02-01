package com.kumpello.poker.data.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HTTP

interface AuthApi {
    @HTTP(method = "POST", path = "auth/signup", hasBody = true)
    fun signUp(@Body requestData: SignUpRequestData): Call<AuthResponseData>

    @HTTP(method = "POST", path = "auth/login", hasBody = true)
    fun login(@Body requestData: LogInRequestData): Call<AuthResponseData>
}