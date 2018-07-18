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
    }

    override fun getTask(id: String, callback: TasksDataSource.GetTaskCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveTask(task: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStatus(id: String, status: TaskStatus) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllTasks() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}