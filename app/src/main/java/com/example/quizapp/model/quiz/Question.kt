package com.example.quizapp.model.quiz

class Question {
    private var question: String
    fun getQuestion(): String {
        return question
    }

    private var variants: MutableList<String>
    fun getVariant(_number: Int): String {
        return variants[_number]
    }

    private var correct: String

    constructor(_question: String, _variants: MutableList<String>, _correct: String) {
        question = _question
        variants = _variants
        correct = _correct
    }

    private var isCorrect: Boolean = false
        get() {
            return isCorrect
        }

    fun answer(_answer: Int) {
        if (variants[_answer].equals(correct)) {
            isCorrect = true
        }
    }
}