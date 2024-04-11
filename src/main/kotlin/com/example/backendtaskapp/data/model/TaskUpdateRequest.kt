package com.example.backendtaskapp.data.model

import com.example.backendtaskapp.data.Priority

data class TaskUpdateRequest(
    val description: String?,
    val isReminderSet: Boolean?,
    val isTaskOpen: Boolean?,
    val priority: Priority?
)
