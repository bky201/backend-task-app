package com.example.backendtaskapp.data.model

import com.example.backendtaskapp.data.Priority
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class TaskCreateRequest(
    @NotBlank(message = "Task description can't be empty")
    val description: String,

    val isReminderSet: Boolean,

    val isTaskOpen: Boolean,

    @NotBlank(message = "Task created_on can't be empty")
    val createdOn: LocalDateTime,

    val priority: Priority
)
