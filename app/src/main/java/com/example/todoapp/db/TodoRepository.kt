package com.example.todoapp.db


import kotlinx.coroutines.flow.Flow

class TodoRepository(private val dao: TodoDao){

    val allTodos: Flow<List<TodoEntity>> = dao.getAll()

    suspend fun insert(todo: TodoEntity) = dao.insert(todo)
    suspend fun delete(todo: TodoEntity) = dao.delete(todo.id)

}