package com.kumpello.poker.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumpello.poker.data.model.ErrorData
import com.kumpello.poker.data.model.ID
import com.kumpello.poker.data.model.organizations.OrganizationData
import com.kumpello.poker.data.model.organizations.OrganizationsData
import com.kumpello.poker.data.model.organizations.OrganizationsUIState
import com.kumpello.poker.domain.events.GetOrganizationsEvent
import com.kumpello.poker.domain.events.SendOrganizationsEvent
import com.kumpello.poker.domain.usecase.OrganizationsService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val organizationsService: OrganizationsService): ViewModel() {

    var _uiState = mutableStateOf(OrganizationsUIState())
    val uiState: State<OrganizationsUIState> = _uiState
    val event = MutableSharedFlow<GetOrganizationsEvent>()

    fun onEvent(event: SendOrganizationsEvent) {
        when(event) {
            is SendOrganizationsEvent.DeleteOrganization -> {
                //Todo add to PokerGo
            }
            is SendOrganizationsEvent.JoinOrganization -> {
                joinOrganization(event.token, event.organizationName, event.name)
            }
            is SendOrganizationsEvent.NewOrganization -> {
                makeNewOrganization(event.token, event.name)
            }
            is SendOrganizationsEvent.GetOrganization -> {
                getUserOrganizations(event.token, event.id)
            }
        }
    }

    private fun getUserOrganizations(token: String, id: ID) {
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = organizationsService.getOrganizations(token)) {
                is OrganizationsData -> {
                    event.emit(GetOrganizationsEvent.GetSuccess(OrganizationsData(response.organizations.filter { organizationData ->  organizationData.members.contains(id)})))
                }
                is ErrorData -> event.emit(GetOrganizationsEvent.GetError(response))
            }
        }
    }

    private fun makeNewOrganization(token: String, organizationName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = organizationsService.createOrganization(token, organizationName)) {
                is OrganizationData -> event.emit(GetOrganizationsEvent.NewSuccess(response))
                is ErrorData -> event.emit(GetOrganizationsEvent.NewError(response))
            }
        }
    }

    private fun joinOrganization(token: String, organizationName: String, name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = organizationsService.joinOrganization(token, organizationName, name)) {
                is OrganizationData -> event.emit(GetOrganizationsEvent.JoinSuccess(response))
                is ErrorData -> event.emit(GetOrganizationsEvent.JoinError(response))
            }
        }
    }
}