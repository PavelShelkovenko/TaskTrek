package com.pscoding.tasktrek.data

import com.pscoding.tasktrek.data.database.TaskDbModel
import com.pscoding.tasktrek.domain.model.Task


object TaskTrekMapper {
    fun mapDomainToDataModel(task: Task) = TaskDbModel(
        id = task.id,
        title = task.title,
        status = task.status,
        date = task.date,
        startingTime = task.startingTime,
        remindStatus = task.remindStatus,
        category = task.category
    )

    fun mapDataToDomainModel(taskDbModel: TaskDbModel) = Task(
        id = taskDbModel.id,
        title = taskDbModel.title,
        status = taskDbModel.status,
        date = taskDbModel.date,
        startingTime = taskDbModel.startingTime,
        remindStatus = taskDbModel.remindStatus,
        category = taskDbModel.category
    )
}