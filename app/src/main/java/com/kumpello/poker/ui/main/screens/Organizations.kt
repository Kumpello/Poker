package com.kumpello.poker.ui.main.screens

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
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
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
import com.kumpello.poker.data.model.ID
import com.kumpello.poker.data.model.OrganizationData
import com.kumpello.poker.ui.theme.PokerTheme
import java.sql.Timestamp

@Composable
fun Organizations(organizations: List<OrganizationData>) {
    val mContext = LocalContext.current
    
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            NewOrganizationButton()
            Spacer(Modifier.size(20.dp))
            JoinOrganizationButton()
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(organizations) { organization ->
                Organization(organization.id, organization.name, organization.members.size)
            }
        }
    }
}

@Composable
fun NewOrganizationButton() {
    var dialogOpen by remember {
        mutableStateOf(false)
    }
    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back button.
                // If you want to disable that functionality, simply leave this block empty.
                dialogOpen = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // perform the confirm action and
                        // close the dialog
                        dialogOpen = false
                    }
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // close the dialog
                        dialogOpen = false
                    }
                ) {
                    Text(text = "Dismiss")
                }
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(text = "Description")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(5.dp),
            backgroundColor = Color.White
        )
    }

    Button(
        onClick = {
            dialogOpen = true
        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(text = "New organization")
    }
}

@Composable
fun JoinOrganizationButton() {
    var dialogOpen by remember {
        mutableStateOf(false)
    }
    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back button.
                // If you want to disable that functionality, simply leave this block empty.
                dialogOpen = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // perform the confirm action and
                        // close the dialog
                        dialogOpen = false
                    }
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // close the dialog
                        dialogOpen = false
                    }
                ) {
                    Text(text = "Dismiss")
                }
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(text = "Description")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(5.dp),
            backgroundColor = Color.White
        )
    }

    Button(
        onClick = {
            dialogOpen = true
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
        Organizations(listOf(OrganizationData(ID("2137"), "dupa", ID("1488"),listOf(ID("420")),
            Timestamp.valueOf("2005-04-02 21:37:00.000")
        )))
    }
}