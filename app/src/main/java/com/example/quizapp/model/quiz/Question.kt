package com.example.quizapp.model.quiz

class Question {
    private var question: String
        get() {
            return question
        }
        set(value) {}

    private var variants: Array<String>
        get() {
            return variants
        }

    constructor(_question: String, _variants: Array<String>){
        question=_question
        variants=_variants
    }
}