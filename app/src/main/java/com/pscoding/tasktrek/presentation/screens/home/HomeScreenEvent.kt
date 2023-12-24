package com.pscoding.tasktrek.presentation.screens.home

sealed class HomeScreenEvent {
    data class UserImageChanged(val newUserImage: ByteArray?) : HomeScreenEvent()
    data class UserNameChanged(val newUserName: String) : HomeScreenEvent()
    data class UserStatusChanged(val newUserStatus: String) : HomeScreenEvent()
}