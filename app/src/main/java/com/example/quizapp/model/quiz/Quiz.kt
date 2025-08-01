package com.example.quizapp.model.quiz

import android.util.Log

class Quiz {
    private var questions: MutableList<Question>
    private var current_question: Int = 0

    constructor(_questions: MutableList<Question>) {
        questions = _questions
        current_question = 0
    }

    fun getQuestion(_number: Int): Question {
        current_question += 1
        return questions[_number]
    }

    fun isEnded(): Boolean {
        if (current_question >= 3 || current_question < 0) {
            return true
        } else {
            return false
        }
    }
}