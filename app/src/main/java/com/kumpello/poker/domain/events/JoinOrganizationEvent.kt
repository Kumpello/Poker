package com.kumpello.poker.domain.events

sealed class JoinOrganizationEvent {
    object Success: JoinOrganizationEvent()
}
