package com.pscoding.tasktrek.presentation.screens.home


data class HomeScreenState(
    val userImage: ByteArray? = null,
    val userName: String = "Your name",
    val userStatus: String = "Your status",
    val toDoTasksCount: Int = 0,
    val inProgressTasksCount: Int = 0,
    val doneTasksCount: Int = 0,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HomeScreenState

        if (userImage != null) {
            if (other.userImage == null) return false
            if (!userImage.contentEquals(other.userImage)) return false
        } else if (other.userImage != null) return false
        if (userName != other.userName) return false
        if (userStatus != other.userStatus) return false
        if (toDoTasksCount != other.toDoTasksCount) return false
        if (inProgressTasksCount != other.inProgressTasksCount) return false
        return doneTasksCount == other.doneTasksCount
    }

    override fun hashCode(): Int {
        var result = userImage?.contentHashCode() ?: 0
        result = 31 * result + userName.hashCode()
        result = 31 * result + userStatus.hashCode()
        result = 31 * result + toDoTasksCount
        result = 31 * result + inProgressTasksCount
        result = 31 * result + doneTasksCount
        return result
    }
}

