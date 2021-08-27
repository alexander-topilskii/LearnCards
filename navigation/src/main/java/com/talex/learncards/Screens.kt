package com.talex.learncards

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.talex.learncards.navigation.R

/**
 * This class described screen navigation objects
 * @param screenName - deeplink screen representation
 * @param titleResourceId - resource to name tabbar or appbar navigation title
 */
sealed class Screen(val screenName: String, val titleResourceId: Int) {
    object Main : Screen("main", -1)
    object User : Screen("user", -1)
    object List : Screen("list", R.string.title_list)
    object Complex : Screen("complex", R.string.title_complex)
    object Push : Screen("push", R.string.title_push)
    object NewMessage : Screen("new_message", R.string.title_message)
}

sealed class MyScreen(val screenName: String, val titleResourceId: Int, val icon: ImageVector) {
    object Enter : MyScreen("main", R.string.title_enter, Icons.Rounded.Menu)
    object Settings : MyScreen("main", R.string.title_settings, Icons.Rounded.ThumbUp)
}