package com.example.lesson7.domain

import com.example.lesson7.data.TaskRepository
import com.example.lesson7.data.model.TaskEntity
import com.example.lesson7.data.model.TaskStates
import javax.inject.Inject

interface UpdateTaskStateUseCase {
    suspend operator fun invoke(task: TaskEntity, taskStates: TaskStates)
}

class UpdateTaskStateUseCaseImpl @Inject constructor(
    private val repository: TaskRepository,
): UpdateTaskStateUseCase {
    override suspend fun invoke(task: TaskEntity, taskStates: TaskStates) {
        repository.updateTaskState(
            taskEntity = task,
            taskState = taskStates
        )
    }

}