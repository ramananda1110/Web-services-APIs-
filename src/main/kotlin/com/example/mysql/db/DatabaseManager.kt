package com.example.mysql.db

import com.example.mysql.entity.DBTodoEntity
import com.example.mysql.entity.TodoEntry
import org.ktorm.database.Database
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
}