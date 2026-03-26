package com.example.app_cours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.room.Room
import com.example.app_cours.data.AppDb
import com.example.app_cours.ui.TaskViewModel
import com.example.app_cours.ui.TaskViewModelFactory
import com.example.app_cours.ui.screens.TaskScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, AppDb::class.java,
            "db").build()
        val dao = db.dao()
        // Récupération du ViewModel via la Factory
        val viewModel: TaskViewModel by viewModels { TaskViewModelFactory(dao) }
        setContent {
            TaskScreen(viewModel)
        }
    }
}