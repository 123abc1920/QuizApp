package com.example.quizapp.model.quiz

import android.util.Log

class QuizResult {
    private var textArray = arrayOf(
        "Бывает и так!",
        "Сложный вопрос?",
        "Есть над чем поработать!",
        "Хороший результат!",
        "Почти идеально!",
        "Идеально!"
    )
    private var subTextArray =
        arrayOf(
            "0/5 — не отчаивайтесь. Начните заново и удивите себя!",
            "1/5 — иногда просто не ваш день. Следующая попытка будет лучше!",
            "2/5 — не расстраивайтесь, попробуйте ещё раз!",
            "3/5 — вы на верном пути. Продолжайте тренироваться!",
            "4/5 — очень близко к совершенству. Ещё один шаг!",
            "5/5 — вы ответили на всё правильно. Это блестящий результат!"
        )

    private var rate: Int
    private var text: String
    private var subText: String

    constructor(_rate: Int) {
        rate = _rate
        text = textArray[rate]
        subText = subTextArray[rate]
        Log.d("Quiz", rate.toString())
    }

    fun getRate(): Int {
        return rate
    }

    fun getText(): String {
        return text
    }

    fun getSubText(): String {
        return subText
    }
}