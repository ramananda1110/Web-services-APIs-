package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

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


data class Book(val id: String, val title: String, val author: String)
data class BookResponse(val book: Book, val links: List<HypermediaLink>)
data class BookReverseResponse(val message: String, val links: List<HypermediaLink>)
data class HypermediaLink(val href: String, val rel: String, val type: String)