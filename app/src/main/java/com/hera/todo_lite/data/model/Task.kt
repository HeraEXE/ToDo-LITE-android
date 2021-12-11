package com.hera.todo_lite.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "task_table")
data class Task(
    val title: String,
    val description: String,
    val isDone: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
) : Parcelable
