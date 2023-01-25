package com.kumpello.poker.data.model

import java.sql.Timestamp

data class OrganizationData (val id: ID, val name:String, val admin:ID, val members: List<ID>, val created: Timestamp){
}