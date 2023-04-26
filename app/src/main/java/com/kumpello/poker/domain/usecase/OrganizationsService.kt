package com.kumpello.poker.domain.usecase

import android.util.Log
import com.kumpello.poker.data.model.*
import com.kumpello.poker.data.services.RetrofitClient
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import java.util.*
import javax.inject.Inject

@ViewModelScoped
class OrganizationsService @Inject constructor(){

    private val retrofit = RetrofitClient.getClient()
    private val orgApi = retrofit.create(OrganizationsApi::class.java)

    fun createOrganization(token: String, organizationName: String): Optional<OrganizationData> {
        val authResponse = orgApi.newOrganization(token, NewOrganizationData(organizationName)).execute()
        Log.e("Creating Organization:", authResponse.errorBody().toString())
        Log.d("Creating Organization:", authResponse.body().toString())
        return Optional.ofNullable(authResponse.body())
    }

    fun getOrganizations(token: String): Optional<List<OrganizationData>> {
        val authResponse = orgApi.getOrganizations(token).execute()
        Log.e("Creating Organization:", authResponse.errorBody().toString())
        Log.d("Creating Organization:", authResponse.body().toString())
        return Optional.ofNullable(authResponse.body())
    }

    //ToDo: Add some generic logging class handling both fail and success
}