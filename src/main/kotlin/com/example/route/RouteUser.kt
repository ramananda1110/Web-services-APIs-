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

            /* print(call.request.queryParameters)

             val formParameters = call.receiveParameters() // query params
             val username = formParameters["username"].toString()
            */
            val user: User = call.receive() // json format

            println("---------not working------------")

            println(user.firstName)


            /* if (user.dob == null) {
                 println("please enter user dob")
                 return@post
             }*/

            val noOrRowsAffected = db.insert(EntityUser) {
                set(it.firstname, user.firstName ?: "")
                set(it.lastname, user.lastName ?: "")
                set(it.dob, user.dob ?: "")
                set(it.gender, user.gender ?: "")
            }

            if (noOrRowsAffected > 0) {
                // success
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        message = "Record added successfully",
                        statusCode = HttpStatusCode.OK.hashCode(),
                        data = user
                    )
                )

            } else {
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        message = "Record not added",
                        statusCode = HttpStatusCode.OK.hashCode(),
                        data = null
                    )
                )

            }
        }

    }
}