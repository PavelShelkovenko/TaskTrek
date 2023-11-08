package com.pscoding.tasktrek.data.database

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.pscoding.tasktrek.domain.model.TaskStatus
import java.io.ByteArrayOutputStream

class RoomConverters {

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return list.joinToString(separator = ",")
    }

    @TypeConverter
    fun fromStringToList(string: String): List<String> {
        return string.split(",").map { it }
    }

    @TypeConverter
    fun fromTaskStatus(taskStatus: TaskStatus): String {
        return taskStatus.name
    }

    @TypeConverter
    fun toTaskStatus(taskStatus: String): TaskStatus {
        return TaskStatus.valueOf(taskStatus)
    }

    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }
}
