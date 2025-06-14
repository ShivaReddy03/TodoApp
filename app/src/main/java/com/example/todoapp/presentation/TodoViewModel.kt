package com.example.todoapp.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.MainApplication
import com.example.todoapp.db.TodoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TodoViewModel:ViewModel() {
    val todoDao = MainApplication.db.gettodoDao()
    val todoList: LiveData<List<TodoEntity>> = todoDao.getAll()

    fun addTodo(todo: String) {
        viewModelScope.launch { withContext(Dispatchers.IO) {
            todoDao.insert(TodoEntity(title = todo))
             }
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch { withContext(Dispatchers.IO) {
            todoDao.delete(TodoEntity(id = id, title = ""))
        }
        }
    }

}