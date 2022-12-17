package com.example.mysql.db

import com.example.mysql.entity.DBTodoEntity
import com.example.mysql.entity.ToDo
import com.example.mysql.entity.ToDoDraft
import com.example.mysql.entity.TodoEntry
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {

    // config

    private val url = "jdbc:mysql://localhost:3306/note_app"
    private val driver = "com.mysql.cj.jdbc.Driver"
    private val user = "root"
    private val password = ""

    // database

    private val dbInstance: Database

    init {
        dbInstance = Database.connect(url = url, driver = driver, user = user, password = password)
    }

    fun getAllTodos(): List<DBTodoEntity> {
        return dbInstance.sequenceOf(TodoEntry).toList()
    }

    fun getToDo(id: Int): DBTodoEntity? {
        return dbInstance.sequenceOf(TodoEntry).firstOrNull { it.id eq id }
    }

    fun addToDo(draft: ToDoDraft): ToDo {
        val insertedId = dbInstance.insertAndGenerateKey(TodoEntry) {
            set(TodoEntry.title, draft.title)
            set(TodoEntry.done, draft.done)
        } as Int

        return ToDo(insertedId, draft.title, draft.done)
    }

    fun updateToDo(id: Int, draft: ToDoDraft): Boolean {
        val updateRows = dbInstance.update(TodoEntry) {
            set(TodoEntry.title, draft.title)
            set(TodoEntry.done, draft.done)

            where {
                it.id eq id
            }
        }

        return updateRows > 0
    }

    fun removeTodo(id: Int): Boolean {
        val deleteRow = dbInstance.delete(TodoEntry) {
            it.id eq id
        }

        return deleteRow > 0
    }


}