package com.kumpello.poker.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.organizations.OrganizationData
import com.kumpello.poker.domain.events.JoinOrganizationEvent
import com.kumpello.poker.domain.events.NewOrganizationEvent
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
                joinOrganization(event.token, event.organizationName, event.name)
            }
            is OrganizationsEvents.NewOrganization -> {
                organizationsService.createOrganization(event.token, event.name)
            }
            is OrganizationsEvents.GetOrganization -> {
                //ToDo
            }
        }
    }

    fun getUserOrganizations() {

    }

    fun makeNewOrganization(token: String, organizationName: String) {
        val newEvent = MutableSharedFlow<NewOrganizationEvent>()
        viewModelScope.launch {
            when(val response = organizationsService.createOrganization(token, organizationName)) {
                is OrganizationData -> newEvent.emit(NewOrganizationEvent.Success(response))
                is ErrorData -> newEvent.emit(NewOrganizationEvent.Error(response))
            }
        }
    }

    private fun joinOrganization(token: String, organizationName: String, name: String) {
        val joinEvent = MutableSharedFlow<JoinOrganizationEvent>()
        viewModelScope.launch {
            when(val response = organizationsService.joinOrganization(token, organizationName, name)) {
                is OrganizationData -> joinEvent.emit(JoinOrganizationEvent.Success(response))
                is ErrorData -> joinEvent.emit(JoinOrganizationEvent.Error(response))
            }
        }
    }
}