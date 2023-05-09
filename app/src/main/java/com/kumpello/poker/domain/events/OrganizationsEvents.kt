package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.ID

sealed class OrganizationsEvents {
    data class DeleteOrganization(val id: ID, val token: String): OrganizationsEvents()
    data class JoinOrganization(val token: String, val organizationName: String, val name: String): OrganizationsEvents()
    data class NewOrganization(val token: String, val name: String): OrganizationsEvents()
    data class GetOrganization(val token: String, val name: String): OrganizationsEvents()
}