package com.example.mysql.repository

import com.example.mysql.entity.ToDo
import com.example.mysql.entity.ToDoDraft


class InMemoryToDoRepository : ToDoRepository {


    val todos = mutableListOf<ToDo>()

    override fun getAllToDos(): List<ToDo> {
        return todos
    }

    override fun getToDo(id: Int): ToDo? {
        return todos.firstOrNull { it.id == id }
    }

    override fun addToDo(draft: ToDoDraft): ToDo {
        val todo = ToDo(id = todos.size + 1, title = draft.title, done = draft.done)
        todos.add(todo)

        return todo
    }

    override fun removeTodo(removeId: Int): Boolean {
        return todos.removeIf { it.id == removeId }
    }

    override fun updateToDo(id: Int, draft: ToDoDraft): Boolean {
        val todo = todos.firstOrNull { it.id == id } ?: return false

        todo.title = draft.title
        todo.done = draft.done

        return true
    }
}