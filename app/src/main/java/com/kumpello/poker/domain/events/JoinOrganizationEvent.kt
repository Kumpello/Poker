package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.organizations.OrganizationData

sealed class JoinOrganizationEvent {
    data class Success(val organizationData: OrganizationData): JoinOrganizationEvent()
    data class Error(val error: ErrorData): JoinOrganizationEvent()
}
