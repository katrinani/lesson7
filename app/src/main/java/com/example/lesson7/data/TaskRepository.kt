package com.example.lesson7.data

import com.example.lesson7.data.db.TasksDAO
import com.example.lesson7.data.model.TaskEntity
import com.example.lesson7.data.model.TaskStates
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface TaskRepository {
    fun getAllTAsks(): Flow<List<TaskEntity>>
    suspend fun updateTaskState(taskEntity: TaskEntity, taskState: TaskStates)
    suspend fun createTask(taskEntity: TaskEntity)
}

class TaskRepositoryImp @Inject constructor(
    private val dao: TasksDAO
): TaskRepository {

    override fun getAllTAsks(): Flow<List<TaskEntity>> =
        dao.getAllTasks()


    override suspend fun updateTaskState(taskEntity: TaskEntity, taskState: TaskStates) {
        dao.upsertTask(
            taskEntity.copy(
                state = taskState
            )
        )
    }

    override suspend fun createTask(taskEntity: TaskEntity) {
        dao.upsertTask(
            taskEntity
        )
    }
}