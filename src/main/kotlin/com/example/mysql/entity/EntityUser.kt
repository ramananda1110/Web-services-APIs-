package com.example.mysql.entity

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object EntityUser : Table<Nothing>(tableName = "user") {
    val userid = int(name = "userid").primaryKey()
    val firstname = varchar(name = "first_name")
    val lastname = varchar(name = "last_name")
    val dob = varchar(name = "dob")
    val gender = varchar(name = "gender")
}