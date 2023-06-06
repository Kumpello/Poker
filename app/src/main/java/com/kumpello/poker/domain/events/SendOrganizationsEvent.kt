package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.authorization.ID

sealed class SendOrganizationsEvent {
    data class DeleteOrganization(val token: String, val id: ID): SendOrganizationsEvent()
    data class JoinOrganization(val token: String, val organizationName: String, val name: String): SendOrganizationsEvent()
    data class NewOrganization(val token: String, val name: String): SendOrganizationsEvent()
    data class GetOrganization(val token: String, val id: ID): SendOrganizationsEvent()
}