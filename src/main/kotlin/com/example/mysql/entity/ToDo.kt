package com.example.mysql.entity

data class ToDo(
    val id: Int,
    var title: String,
    var done: Boolean
)


data class ToDoDraft(
    val title: String,
    var done: Boolean
)