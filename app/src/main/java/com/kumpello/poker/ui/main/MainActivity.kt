package com.kumpello.poker.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kumpello.poker.ui.main.screens.Games
import com.kumpello.poker.ui.main.screens.News
import com.kumpello.poker.ui.main.screens.Organizations
import com.kumpello.poker.ui.navigation.MainRoutes
import com.kumpello.poker.ui.theme.PokerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

@AndroidEntryPoint
class MainActivity : ComponentActivity(), CoroutineScope by MainScope() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainActivityViewModel by viewModels()
        this.viewModel = viewModel

        setContent {
            PokerTheme {
                Navigation()
            }
        }
    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController, MainRoutes.News.route) {
            composable(MainRoutes.News.route) {
                News()
            }

            composable(MainRoutes.Games.route) {
                Games()
            }

            composable(MainRoutes.Organizations.route) {
                Organizations()
            }
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                content = { padding -> Column(modifier = Modifier.padding(padding)) {
                    NavigationGraph(navController)}
                },
                bottomBar = {BottomNavigationBar(navController)})
        }
    }

    @Composable
    fun BottomNavigationBar(navController: NavHostController) {
        BottomNavigation {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            NavBarItems.BarItems.forEach { navItem ->

                BottomNavigationItem(
                    selected = currentRoute == navItem.route,
                    onClick = {
                        navController.navigate(navItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },

                    icon = {
                        Icon(imageVector = navItem.image,
                            contentDescription = navItem.title)
                    },
                    label = {
                        Text(text = navItem.title)
                    },
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PokerTheme {
            Navigation()
        }
    }
}