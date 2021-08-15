package com.talex.learncards.components.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talex.learncards.ui.theme.LearnCardsTheme

@Preview
@Composable
fun DisplaySimpleList() {
    LearnCardsTheme {
        Row {
            SimpleList()
            Spacer(
                modifier = Modifier
                    .width(4.dp)
                    .background(Color.Black)
            )
            LazyList()
        }
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(Color.White)
    ) {
        repeat(100) {
            Text(
                text = "SimpleItem #$it",
                modifier = Modifier.padding(all = 4.dp)
            )
        }
    }
}

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier.background(Color.White)
    ) {
        items(100) {
            Text(
                text = "LazyItem #$it",
                modifier = Modifier.padding(all = 4.dp)
            )
        }
    }
}



