package com.kumpello.poker.ui.main.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kumpello.poker.data.model.ID
import com.kumpello.poker.data.model.OrganizationData
import com.kumpello.poker.ui.theme.PokerTheme
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalTime
import kotlin.random.Random

@Composable
fun Organization(id: ID, name: String, membersCount: Int) {
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