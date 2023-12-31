package com.pscoding.tasktrek.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskTrekDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskDbModel: TaskDbModel)

    @Delete
    suspend fun deleteTask(taskDbModel: TaskDbModel): Int

    @Query("SELECT * FROM task_trek WHERE id= :taskId LIMIT 1")
    suspend fun getTaskById(taskId: String): TaskDbModel

    @Query("SELECT * FROM task_trek ORDER BY id DESC LIMIT 1")
    suspend fun getLastAddedTask(): TaskDbModel

    @Query("SELECT * FROM task_trek")
    fun getAllTasks(): Flow<List<TaskDbModel>>
}