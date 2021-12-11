package com.hera.todo_lite.data.repository

import com.hera.todo_lite.data.dao.TaskDao
import com.hera.todo_lite.data.model.Task
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface TaskRepository {

    fun addTask(task: Task): Completable

    fun editTask(task: Task): Completable

    fun deleteTask(task: Task): Completable

    fun deleteDoneTasks(): Completable

    fun getAllTasks(): Single<List<Task>>

    fun getDoneTasks(): Single<List<Task>>

    fun getUndoneTasks(): Single<List<Task>>
}

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun addTask(task: Task): Completable {
        return taskDao.insertTask(task)
    }

    override fun editTask(task: Task): Completable {
        return taskDao.updateTask(task)
    }

    override fun deleteTask(task: Task): Completable {
        return taskDao.deleteTask(task)
    }

    override fun deleteDoneTasks(): Completable {
        return taskDao.deleteDone()
    }

    override fun getAllTasks(): Single<List<Task>> {
        return taskDao.getAllTasks()
    }

    override fun getDoneTasks(): Single<List<Task>> {
        return taskDao.getAllDoneTasks()
    }

    override fun getUndoneTasks(): Single<List<Task>> {
        return taskDao.getAllUndoneTasks()
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface TaskRepositoryModule {

    @Binds
    fun bindTaskRepository(impl: TaskRepositoryImpl): TaskRepository
}