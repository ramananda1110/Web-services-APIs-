package com.example.mysql.repository

import com.example.mysql.entity.ToDo

interface ToDoRepository {
    fun getAllToDos(): List<ToDo>

    fun getToDo(id: Int): ToDo?
}