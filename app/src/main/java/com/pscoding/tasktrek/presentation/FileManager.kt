package com.pscoding.tasktrek.presentation

import android.content.Context
import android.util.Log
import com.pscoding.tasktrek.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class FileManager(
    private val context: Context
) {

    private val filesDir = context.filesDir
    private val imageFile = File(filesDir, USER_IMAGE_FILE)
    private val nameFile = File(filesDir, USER_NAME_FILE)
    private val statusFile = File(filesDir, USER_STATUS_FILE)


    suspend fun getUserImage(scope: CoroutineScope): ByteArray? {
        val deferredUserImage = scope.async(Dispatchers.IO) {
            try {
                val data = FileInputStream(imageFile).use {
                    it.readBytes()
                }
                data
            } catch (e: Exception) {
                null
            }
        }
        return deferredUserImage.await()
    }

    suspend fun saveUserImage(newUserImage: ByteArray) {
        withContext(Dispatchers.IO) {
            try {
                FileOutputStream(imageFile).use {
                    it.write(newUserImage)
                }
            } catch (e: Exception) {
                Log.e(LOG_TAG,"Can't save user image")
            }
        }
    }

    suspend fun getUserName(scope: CoroutineScope): String? {
        val deferredUserName = scope.async(Dispatchers.IO) {
            try {
                val data = FileInputStream(nameFile).use {
                    String(it.readBytes())
                }
                data
            } catch (e: Exception) {
                null
            }
        }
        return deferredUserName.await()
    }

    suspend fun saveUserName(newUserName: String) {
        withContext(Dispatchers.IO) {
            try {
                FileOutputStream(nameFile).use {
                    it.write(newUserName.toByteArray())
                }
            } catch (e: Exception) {
                Log.e(LOG_TAG,"Can't save user name")
            }
        }
    }

    suspend fun getUserStatus(scope: CoroutineScope): String? {
        val deferredUserStatus = scope.async(Dispatchers.IO) {
            try {
                val data = FileInputStream(statusFile).use {
                    String(it.readBytes())
                }
                data
            } catch (e: Exception) {
                null
            }
        }
        return deferredUserStatus.await()
    }

    suspend fun saveUserStatus(newUserStatus: String) {
        withContext(Dispatchers.IO) {
            try {
                FileOutputStream(statusFile).use {
                    it.write(newUserStatus.toByteArray())
                }
            } catch (e: Exception) {
                Log.e(LOG_TAG,"Can't save user status")
            }
        }
    }

    companion object {
        const val USER_IMAGE_FILE = "user_image"
        const val USER_NAME_FILE = "user_name.txt"
        const val USER_STATUS_FILE = "user_status.txt"
        const val LOG_TAG = "FILE_MANAGER"
    }
}