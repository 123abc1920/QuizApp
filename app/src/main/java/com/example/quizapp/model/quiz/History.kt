package com.example.quizapp.model.quiz

import android.util.Log

class History {
    private var quizes: MutableList<Quiz> = emptyList<Quiz>().toMutableList()

    constructor() {

    }

    fun add(quiz: Quiz) {
        quizes.add(quiz)
    }

    fun getSize(): Int {
        return quizes.size
    }

    fun getQuiz(index: Int): Quiz {
        return quizes[index]
    }
}