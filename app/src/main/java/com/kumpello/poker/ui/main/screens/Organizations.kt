package com.kumpello.poker.ui.main.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kumpello.poker.ui.theme.PokerTheme

@Composable
fun Organizations() {
    val mContext = LocalContext.current

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {



    }
}

@Composable
fun NewOrganizationButton() {

}

@Composable
fun FindOrganizationsButton() {

}

@Preview(showBackground = true)
@Composable
fun OrganizationsPreview() {
    PokerTheme {
        Organizations()
    }
}