package com.talex.main_page

import androidx.compose.runtime.Composable
import com.talex.learncards.NavigationController
import com.talex.learncards.Router
import com.talex.learncards.Screen
import com.talex.main_page.UserScreen

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