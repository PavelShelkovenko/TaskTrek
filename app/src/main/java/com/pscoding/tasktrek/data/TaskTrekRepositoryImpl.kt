package com.pscoding.tasktrek.data

import com.pscoding.tasktrek.data.database.TaskTrekDao
import com.pscoding.tasktrek.domain.model.Task
import com.pscoding.tasktrek.domain.TaskTrekRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskTrekRepositoryImpl(
    private val taskTrekDao: TaskTrekDao,
    private val mapper: TaskTrekMapper
) : TaskTrekRepository {
    override suspend fun addTask(task: Task) {
        taskTrekDao.insertTask(
            mapper.mapDomainToDataModel(task = task)
        )
    }

    override suspend fun deleteTask(task: Task) {
        taskTrekDao.deleteTask(
            mapper.mapDomainToDataModel(task = task)
        )
    }

    override suspend fun editTask(task: Task) {
        taskTrekDao.insertTask(
            mapper.mapDomainToDataModel(task = task)
        )
    }

    override suspend fun getTaskById(taskId: Int): Task {
        val taskDbModel = taskTrekDao.getTaskById(taskId = taskId)
        return mapper.mapDataToDomainModel(taskDbModel = taskDbModel)
    }

    override fun getAllTasks(): Flow<List<Task>> {
        return taskTrekDao.getAllTasks().map { list ->
            list.map { task ->
                mapper.mapDataToDomainModel(task)
            }
        }
    }

}