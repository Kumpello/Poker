package com.kumpello.poker.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumpello.poker.app.PokerApplication
import com.kumpello.poker.domain.events.JoinOrganizationEvent
import com.kumpello.poker.domain.events.OrganizationsEvents
import com.kumpello.poker.domain.usecase.OrganizationsService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
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
                joinOrganization(event.token, event.name)
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

    fun joinOrganization(token: String, organizationName: String) {
        val joinEvent = MutableSharedFlow<JoinOrganizationEvent>()
        organizationsService.joinOrganization(token, organizationName)
        viewModelScope.launch {
            if (!hasError) {
                joinEvent.emit(JoinOrganizationEvent.Success)
            }
        }
    }
}