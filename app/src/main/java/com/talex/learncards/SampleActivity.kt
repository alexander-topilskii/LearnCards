package com.talex.learncards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NamedNavArgument
import com.talex.learncards.components.other.DisplaySimpleList
import com.talex.learncards.viewmodel.BlankViewModel

class SampleActivity : ComponentActivity() {
    private lateinit var viewModel: BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

        viewModel.dataLiveData.observe(this, {
            setContent {
                DisplaySimpleList(it)
            }
        })
    }
}

interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}