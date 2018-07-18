package com.imholynx.abbyytestapp.data.tasks

import android.app.Activity
import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus
import com.imholynx.abbyytestapp.data.source.TasksDataSource
import com.imholynx.abbyytestapp.data.source.TasksRepository

class TasksPresenter(val tasksRepository: TasksRepository, val tasksView: TasksContract.View):
        TasksContract.Presenter{
    init{
        tasksView.presenter = this
    }

    override fun start() {
        loadTasks()
    }

    override fun result(requestCode: Int, resultCode: Int) {
        if(TaskEditorActiviy.REQUEST_ADD_TASK == requestCode &&
                Activity.RESULT_OK == resultCode) {
            tasksView.showSuccessfullySavedMessage()
        }
    }

    override fun loadTasks() {
        tasksView.setLoadingIndicator(true)
        tasksRepository.getTasks(object: TasksDataSource.LoadTasksCallBack{
            override fun onTasksLoaded(tasks: List<Task>) {
                val tasksToShow = ArrayList<Task>()
                for(task in tasks) {
                    when(currentFilter) {
                        TasksFilterType.ALL_TASKS -> tasksToShow.add(task)
                        TasksFilterType.ACTIVE_TASKS -> if (task.status == TaskStatus.ACTIVE_TASK) {
                            tasksToShow.add(task)
                        }
                        TasksFilterType.COMPLITED_TASKS -> if (task.status == TaskStatus.COMPLITED_TASK) {
                            tasksToShow.add(task)
                        }
                        TasksFilterType.NEW_TASKS -> if (task.status == TaskStatus.NEW_TASK) {
                            tasksToShow.add(task)
                        }
                    }
                }
                if(!tasksView.isActive)
                    return
                tasksView.setLoadingIndicator(false)
                if(tasks.isEmpty()){
                    tasksView.showNoTasks()}
                else {
                    tasksView.showTasks(tasksToShow)
                }
            }

            override fun onDataNotAvailable() {
                if(!tasksView.isActive) {
                    return
                }
                tasksView.showLoadingTasksError()
            }
        })
        firstLoad = false
    }

    override fun addNewTask() {
        tasksView.showAddTask()
    }

    override fun openTaskEditor(task: Task) {
        tasksView.showTaskEditorUi(task.id)
    }

    override var currentFilter = TasksFilterType.ALL_TASKS}
    private var firstLoad = true

}