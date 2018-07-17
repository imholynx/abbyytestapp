package com.imholynx.abbyytestapp.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.imholynx.abbyytestapp.data.Task

@Database(entities = arrayOf(Task::class),version = 1)
@TypeConverters(Converters::class)
abstract class TasksDatabase: RoomDatabase() {
    abstract fun taskDao(): TasksDao

    companion object {
        private var INSTANCE: TasksDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): TasksDatabase{
            synchronized(lock){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            TasksDatabase::class.java, "Tasks.db")
                            .build()
                }
                return INSTANCE!!
            }
        }

    }
}