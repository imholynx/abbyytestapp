package com.imholynx.abbyytestapp.data.source

import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus
import com.imholynx.abbyytestapp.data.source.local.TasksLocalDataSource

class TasksRepository(val tasksLocalDataSource: TasksDataSource):TasksDataSource{

    companion object {
        private var INSTANCE: TasksRepository? = null

        @JvmStatic fun getInstance(tasksLocalDataSource: TasksLocalDataSource):TasksRepository{
            return INSTANCE ?: TasksRepository(tasksLocalDataSource).apply { INSTANCE = this }
        }

        @JvmStatic fun destroyInstance(){
            INSTANCE = null
        }
    }

    override fun getTasks(callback: TasksDataSource.LoadTasksCallBack) {
        tasksLocalDataSource.getTasks(object: TasksDataSource.LoadTasksCallBack{
            override fun onTasksLoaded(tasks: List<Task>) {
                callback.onTasksLoaded(tasks)
            }
            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getTask(id: String, callback: TasksDataSource.GetTaskCallback) {
        tasksLocalDataSource.getTask(id, object : TasksDataSource.GetTaskCallback {
            override fun onTaskLoaded(task: Task) {
                callback.onTaskLoaded(task)
            }
            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun saveTask(task: Task) {
        tasksLocalDataSource.saveTask(task)
    }

    override fun setStatus(id: String, status: TaskStatus) {
        tasksLocalDataSource.setStatus(id,status)
    }

    override fun deleteTask(id: String) {
        tasksLocalDataSource.deleteTask(id)
    }

    override fun deleteAllTasks() {
        tasksLocalDataSource.deleteAllTasks()
    }
}