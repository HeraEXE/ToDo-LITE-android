package com.hera.todo_lite.data.dao

import androidx.room.*
import com.hera.todo_lite.data.model.Task
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(vararg tasks: Task): Completable

    @Update
    fun updateTask(vararg tasks: Task): Completable

    @Delete
    fun deleteTask(vararg tasks: Task): Completable

    @Query("DELETE FROM task_table WHERE isDone == 1")
    fun deleteDone(): Completable

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): Single<List<Task>>

    @Query("SELECT * FROM task_table WHERE isDone == 1")
    fun getAllDoneTasks(): Single<List<Task>>

    @Query("SELECT * FROM task_table WHERE isDone == 0")
    fun getAllUndoneTasks(): Single<List<Task>>
}