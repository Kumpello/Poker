package com.kumpello.poker.ui.login

import android.content.Context
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kumpello.poker.ui.login.screens.Login
import com.kumpello.poker.ui.login.screens.SignUp
import com.kumpello.poker.ui.login.screens.Splash
import com.kumpello.poker.ui.navigation.LoginRoutes
import com.kumpello.poker.ui.theme.PokerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : ComponentActivity(), CoroutineScope by MainScope() {
    private lateinit var viewModel: LoginActivityViewModel
    lateinit var activity: LoginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LoginActivityViewModel by viewModels()
        this.viewModel = viewModel
        activity = this

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                //Runs on every launch
            }
        }
        //ToDo: automatic login
/*      if (User is logged) {
            //this.startActivity(Intent(this, ApplicationActivity::class.java))
        }*/
        setContent {
            PokerTheme() {
                Navigation()
            }
        }
    }

    @Composable
    fun NavigationGraph() {
        val navController = rememberNavController()

        NavHost(navController, LoginRoutes.Splash.route) {
            composable(LoginRoutes.Splash.route) {
                Splash(navController)
            }

            composable(LoginRoutes.Login.route) {
                Login(navController, viewModel.authenticationService, activity)
            }

            composable(LoginRoutes.SignUp.route) {
                SignUp(navController, viewModel.authenticationService, activity)
            }
        }
    }

    @Composable
    fun Navigation() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavigationGraph()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PokerTheme() {
            Navigation()
        }
    }

    fun makeToast(mContext: Context, message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
    }
}