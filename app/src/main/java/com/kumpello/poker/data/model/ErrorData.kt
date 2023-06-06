package com.kumpello.poker.data.model

import com.kumpello.poker.data.model.authorization.AuthResponse
import com.kumpello.poker.data.model.organizations.OrganizationsResponse
import okhttp3.ResponseBody

class ErrorData(val errorBody: ResponseBody) : AuthResponse, OrganizationsResponse
