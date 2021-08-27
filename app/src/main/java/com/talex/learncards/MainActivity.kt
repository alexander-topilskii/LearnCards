package com.talex.learncards

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talex.learncards.ui.theme.LearnCardsTheme
import com.talex.main_page.MainScreen
import com.talex.main.page.NewMessageScreen

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearnCardsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Text("Complex Screen")


                    NavHost(navController = navController, startDestination = Screen.Main.screenName) {
                        composable(Screen.Main.screenName) {
                            MainScreen(
                                createExternalRouter { screen, params ->
                                    navController.navigate(screen, params)
                                }
                            )
                        }
                        composable(Screen.NewMessage.screenName) {
                            PresentModal { NewMessageScreen() }
                        }
                    }
                }
            }
        }
    }
}