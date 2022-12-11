package com.example.plugins

import com.example.route.routeUser
import com.example.route.testRoute
import com.example.route.todoRoute
import io.ktor.server.application.*

fun Application.configureRouting() {

    routeUser()

    testRoute()

    todoRoute()
}


