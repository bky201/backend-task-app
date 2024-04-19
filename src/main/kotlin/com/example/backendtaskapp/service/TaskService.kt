package com.example.backendtaskapp.service

import com.example.backendtaskapp.data.Task
import com.example.backendtaskapp.data.model.TaskCreateRequest
import com.example.backendtaskapp.data.model.TaskDto
import com.example.backendtaskapp.exception.TaskNotFoundException
import com.example.backendtaskapp.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TaskService(private val repository: TaskRepository) {

    private fun mappingEntityToDto(task: Task) = TaskDto(
        task.id,
        task.description,
        task.isReminderSet,
        task.isTaskOpen,
        task.createdOn,
        task.priority
    )

    private fun mappingFromRequestToEntity(task: Task, request: TaskCreateRequest) {
        task.description = request.description
        task.isReminderSet = request.isReminderSet
        task.isTaskOpen = request.isTaskOpen
        task.priority = request.priority
    }

    private fun checkTaskForId(id: Long) {
        if (!repository.existsById(id)) {
            throw TaskNotFoundException("Task with the ID: $id does not exist!")
        }
    }

    fun getTaskById(id: Long): TaskDto {
        checkTaskForId(id)
        val task: Task = repository.findTaskById(id)
        return mappingEntityToDto(task)
    }

    fun getAllTasks(): List<TaskDto> =
        repository.findAll().stream().map(this::mappingEntityToDto).collect(Collectors.toList())
    fun getAllOpenTasks(): List<TaskDto> =
        repository.queryAllOpenTasks().stream().map(this::mappingEntityToDto).collect(Collectors.toList())
    fun getAllClosedTasks(): List<TaskDto> =
        repository.queryAllClosedTasks().stream().map(this::mappingEntityToDto).collect(Collectors.toList())
}