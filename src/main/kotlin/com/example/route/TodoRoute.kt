package com.example.route

import com.example.mysql.DbConnection
import com.example.mysql.entity.ToDoDraft
import com.example.mysql.repository.InMemoryToDoRepository
import com.example.mysql.repository.ToDoRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database


fun Application.todoRoute() {

    val db: Database = DbConnection.getDatabaseInstance()

    val repository: ToDoRepository = InMemoryToDoRepository()


    routing {
        get("/hello") {
            call.respond("Hello TodoList")
        }

        get("/todos") {

            val todoList = repository.getAllToDos()

            call.respond(todoList)
        }

        get("/todos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "id parameter has to be a number")
                return@get
            }

            val todo = repository.getToDo(id)

            if (todo == null) {
                call.respond(HttpStatusCode.NotFound, "found no todo for the provided id $id")
            } else {
                call.respond(todo)
            }


        }

        post("/todos") {
            val toDoDraft = call.receive<ToDoDraft>()
            val todo = repository.addToDo(toDoDraft)

            call.respond(todo)
        }

        post("/dodos/{id}") {

        }

        put("/dodos/{id}") {
            val toDoDraft = call.receive<ToDoDraft>()
            val toDoId = call.parameters["id"]?.toIntOrNull()

            if (toDoId == null) {
                call.respond(HttpStatusCode.BadRequest, "id parameter has to be a number")
                return@put
            }

            val updated = repository.updateToDo(toDoId, toDoDraft)

            if (updated) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.NotFound, "found no todo for the provided id $toDoId")

            }
        }

        delete("/dodos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "id parameter has to be a number")
                return@delete
            }

            val removed = repository.removeTodo(id)

            if (removed) {
                call.respond(removed)
            } else {
                call.respond(HttpStatusCode.NotFound, "found no todo for the provided id $id")
            }
        }

    }
}