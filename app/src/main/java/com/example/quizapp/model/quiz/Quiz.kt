package com.example.quizapp.model.quiz

import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.os.CountDownTimer
import java.util.Date
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Locale

class Quiz {
    private var questions: MutableList<Question>
    private var current_question: Int = 0

    private var calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"))
    private var date: String
    private var time: String

    private fun parseTime(input: String): String {
        val parser = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US)
        val date = parser.parse(input) ?: throw IllegalArgumentException("Invalid date format")

        val timeFormat = SimpleDateFormat("HH:mm", Locale.US)
        val formattedTime = timeFormat.format(date)

        return formattedTime
    }

    private fun parseDate(input: String): String {
        val parser = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US)
        val date = parser.parse(input) ?: throw IllegalArgumentException("Invalid date format")

        val dateFormat = SimpleDateFormat("MMM dd", Locale.US)
        val formattedDate = dateFormat.format(date)

        return formattedDate
    }

    constructor(_questions: MutableList<Question>) {
        questions = _questions
        current_question = 0

        date = parseDate(calendar.time.toString())
        time = parseTime(calendar.time.toString())
        Log.d("Quiz", date)
        Log.d("Quiz", time)
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

    fun getTime(): String {
        return time
    }

    fun getDate(): String {
        return date
    }
}