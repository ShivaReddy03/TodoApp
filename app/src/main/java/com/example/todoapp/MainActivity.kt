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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.ToDoAppTheme

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
    var todoList = listOf("shiva","krishna","krish","pavi")
    Column {
        Row {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(1f),
                label = { Text("Enter todo")}
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Add")
            }
        }
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(todoList) {
                todo -> TodoCard(todo)
            }
        }
    }
}


@Composable
fun TodoCard(todo: String, modifier: Modifier = Modifier){
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row {
            Text(
                text = todo,
                modifier = Modifier.padding(16.dp).weight(1f)
            )
            Button(
                onClick = { /*TODO*/ },
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


