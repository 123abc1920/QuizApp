package com.example.quizapp.model.api
//https://opentdb.com/api.php?amount=5&type=multiple
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("api.php?amount=5&type=multiple")
    fun getQuiz(): Call<QuizResponse>
}