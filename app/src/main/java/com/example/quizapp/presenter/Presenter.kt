package com.example.quizapp.presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.quizapp.model.api.ApiService
import com.example.quizapp.model.api.GetData
import com.example.quizapp.model.api.QuizResponse
import com.example.quizapp.model.api.RetrofitClient

lateinit var service: ApiService

fun getQuizBody() {
    service= GetData.service

    service.getQuiz().enqueue(object : Callback<QuizResponse> {

        override fun onResponse(
            call: Call<QuizResponse?>,
            response: Response<QuizResponse?>
        ) {
            if (response.isSuccessful) {
                val quizResponse = response.body()
                quizResponse?.let { data ->
                    Log.d("Quiz", response.code().toString())
                    Log.d("Quiz", data.toString())
                }
            } else {
                Log.d("Quiz", "Response error: ${response.code()}")
            }
        }

        override fun onFailure(
            call: Call<QuizResponse>?,
            t: Throwable
        ) {
            Log.d("Quiz", "fail")
            Log.d("Quiz", t.toString())
        }
    })
}
