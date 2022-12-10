package com.example.mysql.model

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("dob")
    val dob: String? = null,
)


data class Book(val id: String, val title: String, val author: String)
data class BookResponse(val book: Book, val links: List<HypermediaLink>)
data class BookReverseResponse(val message: String, val links: List<HypermediaLink>)
data class HypermediaLink(val href: String, val rel: String, val type: String)