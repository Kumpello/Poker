package com.kumpello.poker.ui.login

import androidx.lifecycle.ViewModel
import com.kumpello.poker.domain.usecase.Authentication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginActivityViewModel @Inject constructor(val authentication: Authentication) : ViewModel() {
}