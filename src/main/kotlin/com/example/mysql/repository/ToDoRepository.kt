package com.example.mysql.repository

import com.example.mysql.entity.ToDo
import com.example.mysql.entity.ToDoDraft

interface ToDoRepository {
    fun getAllToDos(): List<ToDo>

    fun getToDo(id: Int): ToDo?

    fun addToDo(draft: ToDoDraft): ToDo

    fun removeTodo(int: Int): Boolean

    fun updateToDo(id:Int, draft: ToDoDraft):Boolean
}