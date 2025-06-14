package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.todoapp.presentation.TodoScreen
import com.example.todoapp.presentation.TodoViewModel
import com.example.todoapp.ui.theme.ToDoAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                val todoViewModel : TodoViewModel = viewModel()
                TodoScreen(
                    viewModel = todoViewModel
                )
            }
        }
    }
}




