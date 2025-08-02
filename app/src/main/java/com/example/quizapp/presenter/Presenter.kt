package com.example.quizapp.presenter

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.quizapp.model.api.ApiService
import com.example.quizapp.model.api.GetData
import com.example.quizapp.model.api.QuizResponse
import com.example.quizapp.model.quiz.Question
import com.example.quizapp.model.quiz.Quiz
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.Hyphens
import com.example.quizapp.model.quiz.History
import com.example.quizapp.view.views.HistoryScreen

lateinit var service: ApiService

lateinit var current_quiz: Quiz
var history: History = History()

enum class ScreenStatus {
    HELLO, LOAD, QUIZ, END
}

enum class HistoryScreenStatus {
    EMPTY, SHOW
}

var historyStatus = HistoryScreenStatus.EMPTY

fun loadQuiz(startHello: () -> Unit, startQuiz: () -> Unit) {
    service = GetData.service

    service.getQuiz().enqueue(object : Callback<QuizResponse> {

        override fun onResponse(
            call: Call<QuizResponse?>,
            response: Response<QuizResponse?>
        ) {
            if (response.isSuccessful) {
                val quizResponse = response.body()
                quizResponse?.let { data ->
                    var questions: MutableList<Question> = emptyList<Question>().toMutableList()
                    data.results?.forEach { quizData ->
                        var _varinants = emptyList<String>().toMutableList()
                        _varinants.add(quizData.correctAnswer.toString())
                        quizData.incorrectAnswers?.forEach { el ->
                            _varinants.add(el.toString())
                        }
                        questions.add(
                            Question(
                                quizData.question.toString(),
                                _varinants,
                                quizData.correctAnswer.toString()
                            )
                        )
                    }
                    current_quiz = Quiz(questions)
                    historyStatus = HistoryScreenStatus.SHOW
                    startQuiz()
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
            startHello()
        }
    })
}