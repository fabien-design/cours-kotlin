package com.example.app_cours.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_cours.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun dao(): TaskDao
}
