package com.imholynx.abbyytestapp.data.source

import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus

class TasksRepository():TaskDataSource{

    companion object {
        private var INSTANCE: TasksRepository? = null

        @JvmStatic fun getInstance():TasksRepository{
            return INSTANCE ?: TasksRepository().apply { INSTANCE = this }
        }

        @JvmStatic fun destroyInstance(){
            INSTANCE = null
        }
    }

    override fun getTasks(callback: TaskDataSource.LoadTasksCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTask(id: String, callback: TaskDataSource.GetTaskCallback) {
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