package com.kumpello.poker.domain.events

import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.organizations.OrganizationData
import com.kumpello.poker.data.model.organizations.OrganizationsData

sealed class GetOrganizationsEvent {
    data class GetSuccess(val organizationsData: OrganizationsData): GetOrganizationsEvent()
    data class GetError(val error: ErrorData): GetOrganizationsEvent()
    object DeleteSuccess: GetOrganizationsEvent()
    data class DeleteError(val error: ErrorData): GetOrganizationsEvent()
    data class JoinSuccess(val organizationData: OrganizationData): GetOrganizationsEvent()
    data class JoinError(val error: ErrorData): GetOrganizationsEvent()
    data class NewSuccess(val organizationData: OrganizationData): GetOrganizationsEvent()
    data class NewError(val error: ErrorData): GetOrganizationsEvent()
}
