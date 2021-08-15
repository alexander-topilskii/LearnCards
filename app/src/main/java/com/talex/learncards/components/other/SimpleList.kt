package com.talex.learncards.components.other

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talex.learncards.ui.theme.LearnCardsTheme
import kotlinx.coroutines.launch


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun PreviewSimpleList() {
    DisplaySimpleList(listOf(1, 2, 3, 4, 5, 6))
}


@Composable
fun DisplaySimpleList(list: List<Any>) {
    LearnCardsTheme {
        val scrollState1 = rememberLazyListState()
        val scrollState2 = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        Column {
            Row {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            scrollState1.animateScrollToItem(0)
                            scrollState2.animateScrollToItem(0)
                        }
                    }
                ) { Text("Scroll to the top") }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            scrollState1.animateScrollToItem(list.size - 1)
                            scrollState2.animateScrollToItem(list.size - 1)
                        }
                    }
                ) { Text("Scroll to the end") }
            }

            Row {
                SimpleList(list, scrollState1)
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                        .background(Color.Black)
                )
                LazyList(list, scrollState2)
            }
        }
    }
}

@Composable
fun SimpleList(list: List<Any>, scrollState: LazyListState) {
    LazyColumn(
        state = scrollState,
        modifier = Modifier.background(Color.White)
    ) {
        items(list.size) {
            ImageListItem(it)
        }
    }
}

@Composable
fun LazyList(list: List<Any>, scrollState: LazyListState) {
    LazyColumn(
        state = scrollState,
        modifier = Modifier.background(Color.White)
    ) {
        items(list.size) {
            ImageListItem(it)
        }
    }
}



