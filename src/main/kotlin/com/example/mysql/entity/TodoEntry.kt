package com.example.mysql.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object TodoEntry : Table<DBTodoEntity>(tableName = "note_user") {
    val id = int(name = "id").primaryKey().bindTo { it.id }
    val title = varchar(name = "title").bindTo { it.title }
    val done = boolean(name = "done").bindTo { it.done }

}

interface DBTodoEntity : Entity<DBTodoEntity> {
    companion object : Entity.Factory<DBTodoEntity>()

    val id: Int
    val title: String
    val done: Boolean
}