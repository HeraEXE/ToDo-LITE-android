package com.hera.todo_lite.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hera.todo_lite.data.dao.TaskDao
import com.hera.todo_lite.data.model.Task
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao
}

@Module
@InstallIn(SingletonComponent::class)
class TaskDatabaseModule {

    @Provides
    @Singleton
    fun provideTaskDao(
        @ApplicationContext context: Context
    ): TaskDao {
        val db: TaskDatabase = Room
            .databaseBuilder(context, TaskDatabase::class.java, "task_database")
            .build()
        return db.getTaskDao()
    }
}