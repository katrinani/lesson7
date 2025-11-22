package com.example.lesson7.domain

import com.example.lesson7.data.TaskRepository
import com.example.lesson7.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetTaskUseCase {
    operator fun invoke(): Flow<List<TaskEntity>>
}

class GetTaskUseCaseImpl @Inject constructor(
    private val repository: TaskRepository,
): GetTaskUseCase {

    override fun invoke(): Flow<List<TaskEntity>> =
        repository.getAllTAsks()

}