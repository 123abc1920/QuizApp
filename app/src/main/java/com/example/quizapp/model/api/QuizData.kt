package com.example.quizapp.model.api

import com.google.gson.annotations.SerializedName

data class QuizData (
    var type: String? = null,
    var difficulty: String? = null,
    var category: String? = null,
    var question: String? = null,
    @SerializedName("correct_answer")
    var correctAnswer: String? = null//,
    //var incorrectAnswers: Array<String>? = null
)