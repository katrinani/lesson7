package com.example.lesson7.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.lesson7.data.TaskRepositoryImp
import com.example.lesson7.data.TaskRepository
import com.example.lesson7.data.db.TaskDatabase
import com.example.lesson7.data.db.TasksDAO
import com.example.lesson7.domain.CreateTaskUseCase
import com.example.lesson7.domain.CreateTaskUseCaseImpl
import com.example.lesson7.domain.GetTaskUseCase
import com.example.lesson7.domain.GetTaskUseCaseImpl
import com.example.lesson7.domain.UpdateTaskStateUseCase
import com.example.lesson7.domain.UpdateTaskStateUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppBindsModule {
    @Binds
    @Singleton
    fun binTaskRepository(impl: TaskRepositoryImp): TaskRepository

    @Binds
    @Singleton
    fun bindGetTaskUseCase(impl: GetTaskUseCaseImpl): GetTaskUseCase

    @Binds
    @Singleton
    fun bindUpdateTaskStateUseCase(impl: UpdateTaskStateUseCaseImpl): UpdateTaskStateUseCase

    @Binds
    @Singleton
    fun bindCreateTaskUseCase(impl: CreateTaskUseCaseImpl): CreateTaskUseCase

    companion object {
        @Provides
        fun provideContext(
            app: Application,
        ): Context = app.applicationContext

        @Provides
        @Singleton
        fun provideDB(
            context: Context,
        ): TaskDatabase =
            Room.databaseBuilder(
                context,
                TaskDatabase::class.java,
                "tasks.db"
            ).build()

        @Provides
        @Singleton
        fun provideDao(
            db: TaskDatabase
        ): TasksDAO = db.tasksDao
    }
}