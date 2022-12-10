package com.example.route

import com.example.mysql.DbConnection
import com.example.mysql.entity.EntityUser
import com.example.mysql.model.User
import com.example.utils.GenericResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database
import org.ktorm.dsl.insert


fun Application.routeUser() {

    val db: Database = DbConnection.getDatabaseInstance()

    routing {
        get("/") {
            call.respond("welcome to ktor database")
        }

        post("/register") {
            val user: User = call.receive()

            val noOrRowsAffected = db.insert(EntityUser) {
                set(it.firstname, user.firstName)
                set(it.lastname, user.lastName)
                set(it.dob, user.dob)
                set(it.gender, user.gender)
            }

            if (noOrRowsAffected > 0) {
                // success
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(isSuccess = true, data = "$noOrRowsAffected rows are effected")
                )

            } else {
                call.respond(
                    HttpStatusCode.BadRequest,
                    GenericResponse(isSuccess = false, data = "Data not insert")
                )

            }
        }

    }
}