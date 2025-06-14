package com.example.todoapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.todoapp.db.TodoEntity

@Composable
fun TodoScreen(
    viewModel: TodoViewModel,
    modifier: Modifier = Modifier
) {
    var newTodo by rememberSaveable { mutableStateOf("") }
    val todoList by viewModel.allTodos.collectAsState()

    Column(modifier = modifier.padding(16.dp)) {
        Row {
            TextField(
                value = newTodo,
                onValueChange = { newTodo = it },
                modifier = Modifier.weight(1f),
                label = { Text("Enter todo") }
            )
            Button(
                onClick = {
                    if (newTodo.isNotBlank()) {
                        viewModel.insert(TodoEntity(title = newTodo))
                        newTodo = ""
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Add")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(todoList) { todo ->
                TodoCard(
                    todo = todo,
                    onDelete = { viewModel.delete(todo) }
                )
            }
        }
    }
}

@Composable
fun TodoCard(
    todo: TodoEntity,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = todo.title,
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = onDelete,
                modifier = Modifier.padding(start = 8.dp)
            ) { Text(text = "Delete") }
        }
    }
}