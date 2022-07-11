package com.example.soul.presentation.ui.screens.chats

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.soul.presentation.ui.screens.search.SearchWidgetState

class ChatsViewModel : ViewModel() {

    private val _chatWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val chatWidgetState: State<SearchWidgetState> = _chatWidgetState

    private val _chatTextState: MutableState<String> =
        mutableStateOf(value = "")
    val chatTextState: State<String> = _chatTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _chatWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _chatTextState.value = newValue
    }

    val chatList: List<String> = listOf("Mukola", "Dima", "Oleksiy", "Stas")
}
