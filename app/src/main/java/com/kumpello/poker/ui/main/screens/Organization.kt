package com.kumpello.poker.ui.main.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kumpello.poker.data.model.authorization.ID
import com.kumpello.poker.ui.theme.PokerTheme
import java.time.LocalTime
import kotlin.random.Random

@Composable
fun Organization(id: ID, name: String, membersCount: Int) {
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
                Text(text = "Confirmation")
            },
            text = {
                Text(text = "Are you sure you want to delete $name from your organizations?")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(5.dp),
            backgroundColor = Color.White
        )
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(name)
            Text(membersCount.toString())
            IconButton(
                onClick = {
                    dialogOpen = true;
                },
                modifier = Modifier
                    .height(50.dp)
            ) {
                Icon(
                    modifier = Modifier.size(size = 50.dp),
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "",
                    tint = androidx.compose.ui.graphics.Color.Red
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Organization() {
    val random = Random(LocalTime.now().nano);
    val randomNumber = random.nextInt();
    PokerTheme {
        Organization(ID("id$randomNumber"), "name$randomNumber", randomNumber)
    }
}