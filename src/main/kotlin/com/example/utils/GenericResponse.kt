package com.example.utils


data class GenericResponse<out T>(val isSuccess:Boolean, val data:T)
