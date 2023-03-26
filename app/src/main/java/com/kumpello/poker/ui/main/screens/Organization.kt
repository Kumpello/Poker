package com.kumpello.poker.ui.main.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kumpello.poker.data.model.ID

@Composable
fun Organization(id: ID, name: String, membersCount: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(name)
        Text(membersCount.toString())
        IconButton(
            onClick = {

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