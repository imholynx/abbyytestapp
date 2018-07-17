package com.imholynx.abbyytestapp.data

import android.arch.persistence.room.*
import java.util.*

@Entity(tableName = "tasks")
data class Task @JvmOverloads constructor(
        @PrimaryKey @ColumnInfo(name = "id") var id:String = UUID.randomUUID().toString(),
        @ColumnInfo(name = "title") var title: String ="",
        @ColumnInfo(name = "description") var description: String ="",
        @ColumnInfo(name = "date") var date: Date = Date(),
        @ColumnInfo(name = "status") var status: TaskStatus = TaskStatus.NEW_TASK
){}