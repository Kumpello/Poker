package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.ID

sealed class OrganizationsEvents {
    data class DeleteOrganization(val id: ID, val token: String): OrganizationsEvents()
    data class JoinOrganization(val name: String, val token: String): OrganizationsEvents()
    data class NewOrganization(val name: String, val token: String): OrganizationsEvents()
}