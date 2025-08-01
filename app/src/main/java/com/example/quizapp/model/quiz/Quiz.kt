package com.example.quizapp.model.quiz

class Quiz {
    private var questions: Array<Question>

    constructor(_questions: Array<Question>){
        questions=_questions
    }

    fun getQuestion(_number: Int): Question {
        return questions[_number]
    }
}