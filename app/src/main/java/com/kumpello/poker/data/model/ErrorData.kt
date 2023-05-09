package com.kumpello.poker.data.model

import com.kumpello.poker.data.model.organizations.OrganizationsResponse
import okhttp3.ResponseBody

class ErrorData(val errorBody: ResponseBody) : OrganizationsResponse
