package com.example.route

import com.example.mysql.model.Book
import com.example.mysql.model.BookResponse
import com.example.mysql.model.BookReverseResponse
import com.example.mysql.model.HypermediaLink
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.testRoute() {

    routing {


        get("/library/book/{bookid}/checkout") {
            val bookId = call.parameters.get("bookid")
            call.respond("Your checked out the book $bookId")
        }
        get("/library/book/{bookid}/reserve") {
            val bookId = call.parameters.get("bookid")
            call.respond(BookReverseResponse("Your reserved the book $bookId", emptyList<HypermediaLink>()))
        }

        get("/library/book/{bookid}") {
            val bookId = call.parameters.get("bookid")
            val book = Book(bookId!!, " apples", "Mr. appleton")
            val hypermediaLink = listOf<HypermediaLink>(
                HypermediaLink("http://localhost:8080/library/book/$bookId/checkout", "checkout", "GET"),
                HypermediaLink("http://localhost:8080/library/book/$bookId/reserve", "reserve", "GET"),
                HypermediaLink("http://localhost:8080/library/book/$bookId/reserve", "reserve", "GET")
            )

            val bookResponse = BookResponse(book, hypermediaLink)
            call.respond(bookResponse)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }

}