package com.example.lesson7.domain

import com.example.lesson7.data.TaskRepository
import com.example.lesson7.data.model.TaskEntity
import javax.inject.Inject

interface CreateTaskUseCase {
    suspend operator fun invoke(task: TaskEntity)
}


class CreateTaskUseCaseImpl @Inject constructor(
    private val repository: TaskRepository
): CreateTaskUseCase {
    override suspend fun invoke(task: TaskEntity) {
        repository.createTask(task)
    }

}