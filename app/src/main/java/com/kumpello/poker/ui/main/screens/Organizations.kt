package com.kumpello.poker.ui.main.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kumpello.poker.data.model.organizations.OrganizationsUIState
import com.kumpello.poker.domain.events.GetOrganizationsEvent
import com.kumpello.poker.domain.events.SendOrganizationsEvent
import com.kumpello.poker.domain.usecase.OrganizationsService
import com.kumpello.poker.ui.main.MainActivityViewModel
import com.kumpello.poker.ui.theme.PokerTheme

@Composable
fun Organizations(viewModel: MainActivityViewModel) {
    val mContext = LocalContext.current

    LaunchedEffect(mContext) {
        //Get this out to other initialization?
        viewModel.event.collect { event ->
            when(event) {
                is GetOrganizationsEvent.DeleteError -> {
                    Toast
                        .makeText(mContext,event.error.errorBody.string(), Toast.LENGTH_SHORT)
                        .show()
                }
                GetOrganizationsEvent.DeleteSuccess -> TODO()
                is GetOrganizationsEvent.GetError -> {
                    Toast
                        .makeText(mContext,event.error.errorBody.string(), Toast.LENGTH_SHORT)
                        .show()
                }
                is GetOrganizationsEvent.GetSuccess -> {
                    viewModel._uiState.value = OrganizationsUIState(event.organizationsData.organizations)
                }
                is GetOrganizationsEvent.JoinError -> {
                    Toast
                        .makeText(mContext,event.error.errorBody.string(), Toast.LENGTH_SHORT)
                        .show()
                }
                is GetOrganizationsEvent.JoinSuccess -> {
                    viewModel._uiState.value.dialogOpen = false;
                    Toast
                        .makeText(mContext, "Success!", Toast.LENGTH_SHORT)
                        .show()
                }
                is GetOrganizationsEvent.NewError -> {
                    Toast
                        .makeText(mContext,event.error.errorBody.string(), Toast.LENGTH_SHORT)
                        .show()
                }
                is GetOrganizationsEvent.NewSuccess -> {
                    viewModel._uiState.value.dialogOpen = false;
                    Toast
                        .makeText(mContext, "Success!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
    
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            NewOrganizationButton(viewModel)
            Spacer(Modifier.size(20.dp))
            JoinOrganizationButton(viewModel)
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(viewModel.uiState.value.organizations) { organization ->
                Organization(organization.id, organization.name, organization.members.size)
            }
        }
    }
}

@Composable
fun NewOrganizationButton(viewModel: MainActivityViewModel) {
    if (viewModel._uiState.value.dialogOpen) {
        var text by remember {
            mutableStateOf("")
        }

        PokerTheme {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back button.
                    // If you want to disable that functionality, simply leave this block empty.
                    //viewModel._uiState.value.dialogOpen = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.onEvent(SendOrganizationsEvent(SendOrganizationsEvent.NewOrganization()))
                            viewModel._uiState.value.dialogOpen = false
                        }
                    ) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            // close the dialog
                            viewModel._uiState.value.dialogOpen = false
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                },
                title = {
                    Text(text = "Create new Organization")
                },
                text = {
                    OutlinedTextField(text, onValueChange = { newText ->
                        text = newText
                    })
                    Text(text = "Please write name of your new organization")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                shape = RoundedCornerShape(5.dp),
                backgroundColor = Color.White
            )
        }
    }

    Button(
        onClick = {
            viewModel._uiState.value.dialogOpen = true
        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(text = "New organization")
    }
}

@Composable
fun JoinOrganizationButton(viewModel: MainActivityViewModel) {
    //ToDo this need to be changed to another screen with realtime result of input
    if (viewModel._uiState.value.dialogOpen) {
        var text by remember {
            mutableStateOf("")
        }

        PokerTheme {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back button.
                    // If you want to disable that functionality, simply leave this block empty.
                    //viewModel._uiState.value.dialogOpen = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            // perform the confirm action and
                            // close the dialog
                            viewModel._uiState.value.dialogOpen = false
                        }
                    ) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            // close the dialog
                            viewModel._uiState.value.dialogOpen = false
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                },
                title = {
                    Text(text = "Join organization")
                },
                text = {
                    OutlinedTextField(text, onValueChange = { newText ->
                        text = newText
                    })
                    Text(text = "Please write name of organization you wish to join")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                shape = RoundedCornerShape(5.dp),
                backgroundColor = Color.White
            )
        }
    }

    Button(
        onClick = {
            viewModel._uiState.value.dialogOpen = true
        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(text = "Join organization")
    }
}

@Preview(showBackground = true)
@Composable
fun OrganizationsPreview() {
    PokerTheme {
        Organizations(MainActivityViewModel(OrganizationsService()))
    }
}