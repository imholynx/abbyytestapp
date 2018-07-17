package com.imholynx.abbyytestapp.data.source.local

import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus
import com.imholynx.abbyytestapp.data.source.TasksDataSource

class TasksLocalDataSource(val tasksDao: TasksDao): TasksDataSource{

    companion object {
        private var INSTANCE: TasksLocalDataSource? = null

        @JvmStatic fun getInstance(tasksDao: TasksDao):TasksLocalDataSource{
            if(INSTANCE == null){
                synchronized(TasksLocalDataSource::javaClass){
                    INSTANCE = TasksLocalDataSource(tasksDao)
                }
            }
            return INSTANCE!!
        }

        @JvmStatic fun destroyInstance(){
            INSTANCE = null
        }
    }

    override fun getTasks(callback: TasksDataSource.LoadTasksCallBack) {
        val tasks = tasksDao.getTasks();
        if(tasks != null)
            callback.onTasksLoaded(tasks)
        else
            callback.onDataNotAvailable()
    }

    override fun getTask(id: String, callback: TasksDataSource.GetTaskCallback) {
        val task = tasksDao.getTaskById(id)
        if(task != null)
            callback.onTaskLoaded(task)
        else
            callback.onDataNotAvailable()
    }

    override fun saveTask(task: Task) {
        tasksDao.insertTask(task)
    }

    override fun setStatus(id: String, status: TaskStatus) {
        tasksDao.updateStatus(id,status)
    }

    override fun deleteTask(id: String) {
        tasksDao.deleteTaskById(id)
    }

    override fun deleteAllTasks() {
        tasksDao.deleteTasks()
    }

}