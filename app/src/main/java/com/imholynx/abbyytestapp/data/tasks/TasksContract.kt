package com.imholynx.abbyytestapp.data.tasks

import com.imholynx.abbyytestapp.BasePresenter
import com.imholynx.abbyytestapp.BaseView
import com.imholynx.abbyytestapp.data.Task
import com.imholynx.abbyytestapp.data.TaskStatus

interface TasksContract{

    interface View: BaseView<Presenter>{
        var isActive: Boolean
        fun setLoadingIndicator(active: Boolean)
        fun showTasks(tasks: List<Task>)
        fun showAddTask()
        fun showTaskEditorUi(id: String)
        fun showTasksWithFilter(filer: TasksFilterType)
        fun showLoadingTasksError()
        fun showNoTasks()
        fun showSuccessfullySavedMessage()
        fun showFilteringPopUpMenu()
    }

    interface Presenter:BasePresenter {
        var currentFilter: TasksFilterType
        fun result(requestCode: Int, resultCode: Int)
        fun loadTasks()
        fun addNewTask()
        fun openTaskEditor(task: Task)
    }

}