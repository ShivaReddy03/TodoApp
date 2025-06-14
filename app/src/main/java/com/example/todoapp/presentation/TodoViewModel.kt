package com.example.todoapp.presentation

import androidx.lifecycle.ViewModel
import com.example.todoapp.db.TodoEntity
import com.example.todoapp.db.TodoRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


class TodoViewModel(private val repository: TodoRepository): ViewModel() {
    val allTodos: StateFlow<List<TodoEntity>> = repository.allTodos
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun insert(todo: TodoEntity) {
        viewModelScope.launch {
            repository.insert(todo)
        }
    }

    fun delete(todo: TodoEntity) {
        viewModelScope.launch {
            repository.delete(todo)
        }
    }
}