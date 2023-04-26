package com.kumpello.poker.ui.main.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kumpello.poker.data.model.ID
import com.kumpello.poker.data.model.OrganizationData
import com.kumpello.poker.ui.theme.PokerTheme
import java.sql.Timestamp
import java.time.Instant

@Composable
fun Organizations(organizations: List<OrganizationData>) {
    val mContext = LocalContext.current

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            NewOrganizationButton()
            Spacer(Modifier.size(20.dp))
            FindOrganizationsButton()
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            state = rememberLazyListState(),
        ) {
            items(organizations) { organization ->
                Organization(organization.id, organization.name, organization.members.size)
            }
        }
    }
}

@Composable
fun NewOrganizationButton() {
    Button(
        onClick = {

        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(text = "New organization")
    }
}

@Composable
fun FindOrganizationsButton() {
    Button(
        onClick = {

        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(text = "Find organization")
    }
}

@Preview(showBackground = true)
@Composable
fun OrganizationsPreview() {
    PokerTheme {
        Organizations(listOf(OrganizationData(ID("2137"), "dupa", ID("1"),listOf(ID("420")),
            Timestamp.from(Instant.now()) as Timestamp
        )))
    }
}