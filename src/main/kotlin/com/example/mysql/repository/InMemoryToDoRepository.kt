package com.example.mysql.repository

import com.example.mysql.entity.ToDo


class InMemoryToDoRepository : ToDoRepository {


    val todos = listOf<ToDo>(
        ToDo(1, "Plan content #2", true),
        ToDo(1, "Record vedio", true),
        ToDo(1, "upload video #2", false)
    )

    override fun getAllToDos(): List<ToDo> {
        TODO("Not yet implemented")
    }

    override fun getToDo(id: Int): ToDo? {
        return todos.firstOrNull { it.id == id }
    }
}