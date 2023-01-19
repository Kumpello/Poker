package com.kumpello.poker.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "News",
            image = Icons.Filled.Notifications,
            route = "news"
        ),
        BarItem(
            title = "Games",
            image = Icons.Filled.List,
            route = "games"
        ),
        BarItem(
            title = "Organizations",
            image = Icons.Filled.Face,
            route = "organizations"
        )
    )
}