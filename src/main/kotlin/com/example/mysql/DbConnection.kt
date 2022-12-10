package com.example.mysql

import org.ktorm.database.Database

object DbConnection {

    private val db: Database? = null

    fun getDatabaseInstance(): Database {

        return db ?: Database.Companion.connect(
            url = "jdbc:mysql://localhost:3306/note_app",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = ""
        )

    }
}