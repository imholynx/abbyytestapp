package com.imholynx.abbyytestapp.data.source.local

import com.imholynx.abbyytestapp.data.TaskStatus

class Converters{
    fun toStatus(value: String): TaskStatus?{
        return when(value){
            null -> null
            else -> {TaskStatus.valueOf(value)}
            }
        }
    fun fromStatus(status: TaskStatus): String?{
        return when(status){
            null -> null
            else -> {status.name}
        }
    }
}