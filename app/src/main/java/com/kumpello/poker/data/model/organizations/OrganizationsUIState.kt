package com.kumpello.poker.data.model.organizations

data class OrganizationsUIState(
    val organizations: List<OrganizationData> = ArrayList(),
    var dialogOpen: Boolean = false
)
