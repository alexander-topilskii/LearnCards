package com.talex.learncards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talex.enter_page.EnterScreen
import com.talex.enter_page.EnterViewModel
import com.talex.ui.theme.LearnCardsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearnCardsTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = MyScreen.Enter.screenName) {
                    composable(MyScreen.Enter.screenName) {
                        EnterScreen(hiltViewModel(it))
                    }
                }
            }
        }
    }
}
