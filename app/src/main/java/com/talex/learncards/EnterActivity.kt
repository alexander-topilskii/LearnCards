package com.talex.learncards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.talex.learncards.ui.theme.LearnCardsTheme
import com.talex.learncards.ui.theme.Red
import com.talex.learncards.viewmodel.BlankViewModel

class EnterActivity : ComponentActivity() {
    private lateinit var viewModel: BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

        viewModel.dataLiveData.observe(this, {
            setContent {
                LearnCardsTheme {
                    val bottomItems = listOf(MyScreen.Enter, MyScreen.Settings)

                    Scaffold(
                        bottomBar = {
                            BottomNavigation {
                                bottomItems.forEach { screen ->
                                    BottomNavigationItem(
                                        selected = false,
                                        onClick = {
                                            println("GGGG EnterActivity.onCreate ${getString(screen.titleResourceId)}")
                                        },
                                        label = { Text(stringResource(id = screen.titleResourceId)) },
                                        icon = {
                                            Icon(screen.icon, "${getString(screen.titleResourceId)}", tint = Color.White)
                                        })
                                }
                            }
                        }
                    ) {
                        Row {
                            Button(onClick = {
                                println("GGGG EnterActivity.onCreate")
                            }) {
                                Text("Button")
                            }
                        }
                    }
                }
            }
        })
    }
}