package com.example.mysql.repository

import com.example.mysql.entity.ToDo
import com.example.mysql.entity.ToDoDraft

class MySqlTodoRepository : ToDoRepository {
    override fun getAllToDos(): List<ToDo> {
        TODO("Not yet implemented")
    }

    override fun getToDo(id: Int): ToDo? {
        TODO("Not yet implemented")
    }

    override fun addToDo(draft: ToDoDraft): ToDo {
        TODO("Not yet implemented")
    }

    override fun removeTodo(int: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateToDo(id: Int, draft: ToDoDraft): Boolean {
        TODO("Not yet implemented")
    }
}