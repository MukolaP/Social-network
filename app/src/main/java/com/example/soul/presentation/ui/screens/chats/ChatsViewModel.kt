package com.example.soul.presentation.ui.screens.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soul.domain.model.Message

class ChatsViewModel : ViewModel() {

    val message = MutableLiveData(listOf(Message(0, "1", "2", "3")))
}
