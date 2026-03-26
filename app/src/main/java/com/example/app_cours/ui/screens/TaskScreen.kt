package com.example.app_cours.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_cours.ui.TaskViewModel

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    // Observation de l'état (List) depuis le ViewModel
    val tasks by viewModel.tasks.collectAsState()
    // État local uniquement pour le texte en cours de saisie
    var text by remember { mutableStateOf("") }
    Column(Modifier.padding(16.dp)) {
        Row {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Faire...") }
            )
            Button(onClick = {
                viewModel.addTask(text) // Délégation au ViewModel
                text = ""
            }) {
                Text("OK")
            }
        }
        LazyColumn {
            items(tasks) { task ->
                TextButton(onClick = { viewModel.deleteTask(task) }) {
                    Text("${task.title} (Supprimer)")
                }
            }
        }
    }
}
