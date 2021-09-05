package com.talex.learncards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talex.enter_page.EnterScreen
import com.talex.ui.theme.LearnCardsTheme

class EnterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearnCardsTheme {

                val navController = rememberNavController()
                val router = createExternalRouter { screen, params ->
                    navController.navigate(screen, params)
                }
                NavHost(navController = navController, startDestination = MyScreen.Enter.screenName) {
                    composable(MyScreen.Enter.screenName) {
                        EnterScreen(router)
                    }
                }
            }
        }
    }
}
