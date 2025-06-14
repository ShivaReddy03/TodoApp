package com.example.todoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    companion object {
        const val DB_NAME = "todo.db"
    }
    abstract fun gettodoDao(): TodoDao

}