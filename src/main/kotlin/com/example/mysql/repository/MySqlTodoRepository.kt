package com.example.mysql.repository

import com.example.mysql.db.DatabaseManager
import com.example.mysql.entity.ToDo
import com.example.mysql.entity.ToDoDraft

class MySqlTodoRepository : ToDoRepository {

    private val database = DatabaseManager()

    override fun getAllToDos(): List<ToDo> {
        return database.getAllTodos().map { ToDo(it.id, it.title, it.done) }
    }

    override fun getToDo(id: Int): ToDo? {
        return database.getToDo(id)?.let { ToDo(it.id, it.title, it.done) }
    }

    override fun addToDo(draft: ToDoDraft): ToDo {
        return database.addToDo(draft)
    }

    override fun removeTodo(id: Int): Boolean {
        return database.removeTodo(id)
    }

    override fun updateToDo(id: Int, draft: ToDoDraft): Boolean {
        return database.updateToDo(id, draft)
    }
}