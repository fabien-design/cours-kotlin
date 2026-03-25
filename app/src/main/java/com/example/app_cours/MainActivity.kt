package com.example.app_cours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, SchoolDb::class.java,
            "school").build()
        val dao = db.dao()
        setContent {
            val scope = rememberCoroutineScope()
            val students by dao.getAllStudents().collectAsState(initial =
                emptyList())
            var name by remember { mutableStateOf("") }
            Column(Modifier.padding(16.dp)) {
                Row() {
                    TextField(value = name, onValueChange = { name = it },
                        Modifier.weight(1f))
                    Button(onClick = {
                        scope.launch {
                            dao.insertStudent(Student(name = name));
                            name = ""
                        }
                    }){
                        Text("Ajouter Élève")
                    }
                }
                Spacer(Modifier.height(20.dp))
                LazyColumn() {
                    items(students.size) { index ->
                        val grades by
                        dao.getGradesForStudent(students[index].studentId).collectAsState(initial =
                            emptyList())
                        Card(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                            Column(Modifier.padding(8.dp)) {
                                Text("Élève : ${students[index].name}", style =
                                    MaterialTheme.typography.headlineSmall)
                                Text("Notes : ${grades.map { it.value
                                }.joinToString(", ")}")
                                Button(onClick = {
                                    scope.launch {
                                        dao.insertGrade(Grade(ownerId =
                                            students[index].studentId, value = (10..20).random()))
                                    }
                                }) { Text("Donner une note aléatoire") }
                            }
                        }
                    }
                }
            }
        }
    }
}
