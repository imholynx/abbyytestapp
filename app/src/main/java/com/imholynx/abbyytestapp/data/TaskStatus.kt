package com.imholynx.abbyytestapp.data

enum class TaskStatus(val code: Int){
    //новая задача
    NEW_TASK(0),
    //в процессе выполнения
    ACTIVE_TASK(1),
    //выполнена
    COMPLITED_TASK(2)
}