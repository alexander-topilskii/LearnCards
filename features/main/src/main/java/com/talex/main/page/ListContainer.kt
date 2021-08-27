package com.talex.main.page

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.talex.navigation.NavigationController
import com.talex.navigation.Router
import com.talex.navigation.Screen

@ExperimentalAnimationApi
@Composable
fun ListContainer(
    externalRouter: Router
) {
    NavigationController(
        startDestination = Screen.List.screenName,
        router = externalRouter,
        screens = listOf(
            Pair(Screen.List.screenName, { nav, router, _ -> ListScreen(router, nav) }),
            Pair(Screen.User.screenName, { _, _, params ->
                params?.getParcelable<UserModel>(UserModel.USER)?.let {
                    UserScreen(model = it)
                }
            })
        )
    )
}