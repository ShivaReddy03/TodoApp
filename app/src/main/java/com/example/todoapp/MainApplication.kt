package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.db.TodoDatabase

class MainApplication: Application() {
    companion object {
        lateinit var db: TodoDatabase
    }
    override fun onCreate() {
        super.onCreate()
        db=Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.DB_NAME
        ).build()
    }
}