package com.example.quizapp.model.api

import com.google.gson.annotations.SerializedName

data class QuizResponse (
    @SerializedName("response_code")
    var responseCode: Int? = null,
    var results: List<QuizData>? = null
)