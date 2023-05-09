package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.organizations.OrganizationData

sealed class NewOrganizationEvent {
    data class Success(val organizationData: OrganizationData): NewOrganizationEvent()
    data class Error(val error: ErrorData): NewOrganizationEvent()
}
