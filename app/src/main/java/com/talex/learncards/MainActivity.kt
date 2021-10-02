package com.talex.learncards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talex.enter_page.EnterScreen
import com.talex.settings.SettingsScreen
import com.talex.ui.stateValue
import com.talex.ui.theme.LearnCardsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearnCardsTheme {
                val navController = rememberNavController()
                val mainViewModel: MainViewModel = viewModel()
                val router = createExternalRouter { screen, params ->
                    navController.navigate(screen, params)
                }

                Scaffold(
                    bottomBar = { BottomNavigationUi(router) }
                ) {
                    NavHost(navController = navController, startDestination = MyScreen.Enter.screenName) {
                        composable(MyScreen.Enter.screenName) {
                            EnterScreen(hiltViewModel(it))
                        }
                        composable(MyScreen.Settings.screenName) {
                            SettingsScreen(hiltViewModel(it))
                        }
                    }
                }

            }
        }
    }
}
