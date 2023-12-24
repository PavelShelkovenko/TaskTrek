package com.pscoding.tasktrek.di

import com.pscoding.tasktrek.data.TaskTrekMapper
import com.pscoding.tasktrek.data.TaskTrekRepositoryImpl
import com.pscoding.tasktrek.data.database.AppDatabase
import com.pscoding.tasktrek.domain.TaskTrekRepository
import com.pscoding.tasktrek.domain.usecase.AddTask
import com.pscoding.tasktrek.domain.usecase.DeleteTask
import com.pscoding.tasktrek.domain.usecase.EditTask
import com.pscoding.tasktrek.domain.usecase.GetAllTasks
import com.pscoding.tasktrek.domain.usecase.GetLastAddedTask
import com.pscoding.tasktrek.domain.usecase.GetTaskById
import com.pscoding.tasktrek.domain.usecase.TaskUseCases
import com.pscoding.tasktrek.presentation.FileManager
import com.pscoding.tasktrek.presentation.screens.home.HomeViewModel
import com.pscoding.tasktrek.presentation.screens.new_task.NewTaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    single<TaskTrekRepository> {
        TaskTrekRepositoryImpl(
            mapper = get(),
            taskTrekDao = get()
        )
    }
    single { TaskTrekMapper }
    single { AppDatabase.getInstance(application = get()).taskTrekDao() }
    single { FileManager(context = get()) }
    factory { AddTask(repository = get()) }
    factory { DeleteTask(repository = get()) }
    factory { EditTask(repository = get()) }
    factory { GetAllTasks(repository = get()) }
    factory { GetTaskById(repository = get()) }
    factory { GetLastAddedTask(repository = get()) }
    factoryOf(::TaskUseCases)
    viewModelOf(::HomeViewModel)
    viewModelOf(::NewTaskViewModel)
}