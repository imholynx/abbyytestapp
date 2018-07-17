package com.imholynx.abbyytestapp.data.source.local

import android.arch.persistence.room.*
import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus

@Dao
interface TasksDao {

    @Query("SELECT * FROM Tasks")
    fun getTasks(): List<Task>

    @Query("SELECT * FROM Tasks WHERE id = :id")
    fun getTaskById(id:String): Task?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update fun updateTask(task: Task): Int

    @Query("UPDATE Tasks SET status= :status WHERE id = :id")
    fun updateStatus(id:String,status: TaskStatus)

    @Query("DELETE FROM Tasks WHERE id = :id")
    fun deleteTaskById(id:String): Int

    @Query("DELETE FROM Tasks")
    fun deleteTasks()
}
