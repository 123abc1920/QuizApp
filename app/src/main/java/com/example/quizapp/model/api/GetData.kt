package com.example.quizapp.model.api

object GetData {
    private val BASE_URL = "https://opentdb.com/"
    val service: ApiService
        get() = RetrofitClient.getClient(BASE_URL).create(ApiService::class.java)
}