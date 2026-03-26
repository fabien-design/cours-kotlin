package com.example.app_cours.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    // @PrimaryKey : Identifiant unique pour chaque tâche.
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String
)