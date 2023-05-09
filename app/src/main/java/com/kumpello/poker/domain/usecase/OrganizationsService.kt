package com.kumpello.poker.domain.usecase

import android.util.Log
import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.JoinOrganizationData
import com.kumpello.poker.data.model.organizations.NewOrganizationData
import com.kumpello.poker.data.model.organizations.OrganizationData
import com.kumpello.poker.data.model.organizations.OrganizationsApi
import com.kumpello.poker.data.model.organizations.OrganizationsData
import com.kumpello.poker.data.model.organizations.OrganizationsResponse
import com.kumpello.poker.data.services.RetrofitClient
import dagger.hilt.android.scopes.ViewModelScoped
import java.util.Optional
import javax.inject.Inject

@ViewModelScoped
class OrganizationsService @Inject constructor(){

    private val retrofit = RetrofitClient.getClient()
    private val orgApi = retrofit.create(OrganizationsApi::class.java)

    fun createOrganization(token: String, organizationName: String): OrganizationsResponse {
        val authResponse = orgApi.newOrganization(token, NewOrganizationData(organizationName)).execute()
        Log.e("Creating Organization:", authResponse.errorBody().toString())
        Log.d("Creating Organization:", authResponse.body().toString())
        return if (authResponse.isSuccessful) {
            authResponse.body()!!
        } else {
            ErrorData(authResponse.errorBody()!!)
        }
    }

    fun getOrganizations(token: String): OrganizationsResponse {
        val authResponse = orgApi.getOrganizations(token).execute()
        Log.e("Getting organizations:", authResponse.errorBody().toString())
        Log.d("Getting organizations:", authResponse.body().toString())
        return if (authResponse.isSuccessful) {
            OrganizationsData(authResponse.body()!!)
        } else {
            ErrorData(authResponse.errorBody()!!)
        }
    }

    fun joinOrganization(token: String, organizationName: String, name: String): OrganizationsResponse {
        val authResponse = orgApi.joinOrganization(token, JoinOrganizationData(organizationName, name)).execute()
        Log.e("Joining organization:", authResponse.errorBody().toString())
        Log.d("Joining organization:", authResponse.body().toString())
        return if (authResponse.isSuccessful) {
            authResponse.body()!!
        } else {
            ErrorData(authResponse.errorBody()!!)
        }
    }

    //ToDo: Add some generic logging class handling both fail and success
}