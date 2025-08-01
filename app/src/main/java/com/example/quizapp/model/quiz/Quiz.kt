package com.example.quizapp.model.quiz

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

    fun getResult(): QuizResult {
        var rate: Int = 0
        questions.forEach { question ->
            if (question.getIsCorrect()) {
                rate += 1
            }
        }
        return QuizResult(rate)
    }

    fun clear() {
        questions.forEach { question ->
            question.clear()
        }
    }
}