package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.organizations.OrganizationData

sealed class GetOrganizationEvent {
    data class Success(val organizationData: OrganizationData): GetOrganizationEvent()
    data class Error(val error: ErrorData): GetOrganizationEvent()
}
