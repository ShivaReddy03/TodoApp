package com.example.todoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todoentity")
    fun getAll(): Flow<List<TodoEntity>>

    @Insert
    fun insert(todo: TodoEntity)

    @Query("DELETE FROM todoentity WHERE id = :id")
    fun delete(id: Int)


}