package com.kumpello.poker.data.model.organizations

import com.kumpello.poker.data.model.authorization.ID
import java.sql.Timestamp

data class OrganizationData (val id: ID, val name:String, val admin: ID, val members: List<ID>, val created: Timestamp) : OrganizationsResponse{
}