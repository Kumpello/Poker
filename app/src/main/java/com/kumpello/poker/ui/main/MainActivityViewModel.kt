package com.kumpello.poker.ui.main

import androidx.lifecycle.ViewModel
import com.kumpello.poker.app.PokerApplication
import com.kumpello.poker.domain.events.OrganizationsEvents
import com.kumpello.poker.domain.usecase.OrganizationsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val organizationsService: OrganizationsService): ViewModel() {

    fun onEvent(event: OrganizationsEvents) {
        when(event) {
            is OrganizationsEvents.DeleteOrganization -> {
                //Todo add to PokerGo
            }
            is OrganizationsEvents.JoinOrganization -> {
                //ToDo checks/filter
                organizationsService.getOrganizations(event.token)
            }
            is OrganizationsEvents.NewOrganization -> {
                //ToDo Checks
                organizationsService.createOrganization(event.token, event.name)
            }
        }
    }

    fun getUserOrganizations() {

    }

    fun makeNewOrganization() {

    }

    fun joinOrganization() {

    }
}