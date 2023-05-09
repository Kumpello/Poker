package com.kumpello.poker.data.model.organizations

import com.kumpello.poker.data.model.JoinOrganizationData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.Header

interface OrganizationsApi {
    @HTTP(method = "POST", path = "org/newOrg", hasBody = true)
    fun newOrganization(@Header("Authorization") token:String, @Body requestData: NewOrganizationData): Call<OrganizationData>

    @HTTP(method = "POST", path = "org/addToOrg", hasBody = true)
    fun joinOrganization(@Header("Authorization") token:String, @Body requestData: JoinOrganizationData): Call<OrganizationData>

    @HTTP(method = "GET", path = "org/listOrg", hasBody = false)
    fun getOrganizations(@Header("Authorization") token:String): Call<List<OrganizationData>>
}