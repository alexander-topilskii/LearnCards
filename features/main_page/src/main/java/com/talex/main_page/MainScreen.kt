package com.talex.main_page

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talex.learncards.Router
import com.talex.learncards.Screen

@ExperimentalAnimationApi
@Composable
fun MainScreen(
    router: Router
) {
    // Stored in memory NavHostController
    // Live through recompose and configuration changed cycle by rememberSaveable
    val navController = rememberNavController()
    val bottomItems = listOf(Screen.List, Screen.Complex, Screen.Push)

    Scaffold(
        bottomBar = {
            BottomNavigation {
                bottomItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                        },
                        label = { Text(stringResource(id = screen.titleResourceId)) },
                        icon = {

                        })
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.List.screenName) {
            composable(Screen.List.screenName) { ListContainer(externalRouter = router) }
            composable(Screen.Complex.screenName) { ComplexScreen(navController) }
            composable(Screen.Push.screenName) { PushScreen(navController) }
        }
    }
}