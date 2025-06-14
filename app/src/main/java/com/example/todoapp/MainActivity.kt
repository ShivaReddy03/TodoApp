package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.presentation.TodoViewModel
import com.example.todoapp.ui.theme.ToDoAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                Todo()
            }
        }
    }
}

@Composable
fun Todo(modifier: Modifier = Modifier){
    var viewModel : TodoViewModel = viewModel()
    val todoList by viewModel.todoList.observeAsState(emptyList())
    var title by remember { mutableStateOf("") }
    Column(modifier = modifier.padding(16.dp)) {
        Row(modifier = Modifier.padding(top = 24.dp)) {
            TextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier.weight(1f),
                label = { Text("Enter todo")}
            )
            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        viewModel.addTodo(title)
                        title = "" // Clear input after adding
                    }
                          },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Add")
            }
        }
        LazyColumn {
            items(todoList) { todo ->
                TodoCard(todo = todo.title, id = todo.id, viewModel = viewModel)
            }
        }
    }
}


@Composable
fun TodoCard(todo: String, id: Int, viewModel: TodoViewModel){
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row {
            Text(
                text = todo,
                modifier = Modifier.padding(16.dp).weight(1f)
            )
            Button(
                onClick = { viewModel.deleteTodo(id) },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "Delete") }
        }
    }
}


@Preview
@Composable
fun TodoPreview() {
    ToDoAppTheme {
        Todo()
    }
}


