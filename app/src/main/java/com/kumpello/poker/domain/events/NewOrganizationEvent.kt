package com.kumpello.poker.domain.events

sealed class NewOrganizationEvent {
    object Success: NewOrganizationEvent()
}
