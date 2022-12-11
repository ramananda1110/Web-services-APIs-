package com.example.utils

import io.ktor.http.*


data class GenericResponse<out T>(val message:String, val statusCode:Int, val data:T)
