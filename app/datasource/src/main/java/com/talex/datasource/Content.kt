package com.talex.datasource

const val messageBody =
    """Our conversation is getting more interesting. 
It's time to play with animations! We will add 
the ability to expand a message to show a longer one,
animating both the content size and the background 
color. To store this local UI state, we need to keep
track of whether a message has been extended or not.
To keep track of this state change, we have to use 
the functions remember and mutableStateOf."""