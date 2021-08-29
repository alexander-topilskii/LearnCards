package com.talex.learncards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talex.enter_page.EnterScreen
import com.talex.ui.theme.LearnCardsTheme
import com.talex.learncards.viewmodel.BlankViewModel
import com.talex.ui.stateValue

class EnterActivity : ComponentActivity() {
    private lateinit var viewModel: BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

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
