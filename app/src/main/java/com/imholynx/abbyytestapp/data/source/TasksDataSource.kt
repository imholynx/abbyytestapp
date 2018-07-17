package com.imholynx.abbyytestapp.data.source

import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus

interface TasksDataSource {
    interface LoadTasksCallBack {
        fun onTasksLoaded(tasks: List<Task>)
        fun onDataNotAvailable()
    }

    interface GetTaskCallback {
        fun onTaskLoaded(task: Task)
        fun onDataNotAvailable()
    }

    fun getTasks(callback: LoadTasksCallBack)
    fun getTask(id: String, callback: GetTaskCallback)

    fun saveTask(task: Task)
    fun setStatus(id: String, status: TaskStatus)
    fun deleteTask(id: String)
    fun deleteAllTasks()
}