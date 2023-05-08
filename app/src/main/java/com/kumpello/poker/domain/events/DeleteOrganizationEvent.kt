package com.kumpello.poker.domain.events

sealed class DeleteOrganizationEvent {
    object Success: DeleteOrganizationEvent()
}
