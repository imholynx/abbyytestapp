package com.imholynx.abbyytestapp.data.tasks

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.imholynx.abbyytestapp.R
import com.imholynx.abbyytestapp.data.source.TasksRepository
import com.imholynx.abbyytestapp.data.source.local.TasksDao
import com.imholynx.abbyytestapp.data.source.local.TasksDatabase
import com.imholynx.abbyytestapp.data.source.local.TasksLocalDataSource

class TasksActivity : AppCompatActivity(){

    private val CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY"

    private lateinit var tasksPresenter: TasksPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.tasks_activity)

        setSupportActionBar(findViewById(R.id.toolbar))

        val tasksFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as TasksFragment? ?: TasksFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.contentFrame,tasksFragment).commit()

        val tasksPresenter = TasksPresenter(TasksRepository.getInstance(TasksLocalDataSource.getInstance(TasksDatabase.getInstance(applicationContext).taskDao())),tasksFragment)
    }

    //TODO save and restore CURRENT_FILTERING_KEY

}