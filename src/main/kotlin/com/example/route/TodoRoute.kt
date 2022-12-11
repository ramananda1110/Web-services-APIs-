package com.example.route

import com.example.mysql.DbConnection
import com.example.mysql.entity.ToDo
import com.example.mysql.repository.InMemoryToDoRepository
import com.example.mysql.repository.ToDoRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database


fun Application.todoRoute() {

    val db: Database = DbConnection.getDatabaseInstance()

    val repository:ToDoRepository = InMemoryToDoRepository()


    routing {
        get("/hello") {
            call.respond("Hello TodoList")
        }

        get("/todos") {
            call.respond(repository.getAllToDos())
        }

        get("/dodos/{id}") {
            val id = call.parameters["id"]!!.toInt()

            if(id==null){
                call.respond(HttpStatusCode.BadRequest, "id parameter has to be a number")
                return@get
            }

           val todo = call.respond(repository.getToDo(id))
        }

        post("/todos") {

        }

        post("/dodos/{id}") {

        }

        put("/dodos/{id}") {

        }

        delete("/dodos/{id}") {

        }

    }
}