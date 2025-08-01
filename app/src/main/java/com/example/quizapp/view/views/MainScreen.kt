package com.example.quizapp.view.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.model.quiz.QuizResult
import com.example.quizapp.presenter.*

lateinit var startQuiz: () -> Unit
lateinit var startLoad: () -> Unit
lateinit var startHello: () -> Unit
lateinit var startEnd: () -> Unit

@Composable
fun MainScreen(navController: NavController) {
    var status by remember { mutableStateOf(ScreenStatus.HELLO) }
    startQuiz = {
        status = ScreenStatus.QUIZ
    }
    startHello = {
        status =
            ScreenStatus.HELLO
    }
    startLoad = {
        status = ScreenStatus.LOAD
    }
    startEnd = {
        status = ScreenStatus.END
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.quizapp.view.theme.Purple)
            .padding(25.dp)
    ) {
        if (status == ScreenStatus.QUIZ) {
            QuizScreen()
        } else if (status == ScreenStatus.HELLO) {
            HelloScreen()
        } else if (status == ScreenStatus.LOAD) {
            LoadScreen()
        } else if (status == ScreenStatus.END) {
            EndScreen()
        }
    }
}

@Composable
private fun EndScreen() {
    var quiz_result: QuizResult = current_quiz.getResult()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Результаты")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
        ) {
            Row {
                var i: Int = 0
                repeat(5) {
                    if (quiz_result.getRate() > i) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.active_star),
                            contentDescription = "Back",
                            tint = Color.Yellow
                        )
                    } else {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.inactive_star),
                            contentDescription = "Back",
                            tint = Color.Gray
                        )
                    }
                    i++
                }
            }
            Text(quiz_result.getRate().toString() + " из 5")
            Text(quiz_result.getText())
            Text(quiz_result.getSubText())
            Button(onClick = startHello) {
                Text("Начать заново")
            }
        }
    }
}

@Composable
private fun LoadScreen() {
    loadQuiz(startHello, startQuiz)
    Text(
        text = "DAILY QUIZ",
        color = com.example.quizapp.view.theme.White,
        fontSize = 40.sp,
        fontWeight = FontWeight.Black,
    )
}

@Composable
private fun QuizScreen() {
    var question_number by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = {
                    startHello
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.arrow_back_icon),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = "DAILY QUIZ",
                color = com.example.quizapp.view.theme.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Black,
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .background(Color.White)
                .wrapContentHeight()
                .fillMaxWidth()
                .weight(2f)
        ) {
            var qn = question_number + 1
            Text(
                "Вопрос " + qn + " из 5",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                textAlign = TextAlign.Center
            )
            Text(
                current_quiz.getQuestion(question_number).getQuestion(),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            val state = remember { mutableStateOf(-1) }
            Column(
                Modifier.selectableGroup(),
                horizontalAlignment = Alignment.Start
            )
            {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state.value == 0,
                        onClick = { state.value = 0 }
                    )
                    Text(current_quiz.getQuestion(question_number).getVariant(0))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state.value == 1,
                        onClick = { state.value = 1 }
                    )
                    Text(current_quiz.getQuestion(question_number).getVariant(1))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state.value == 2,
                        onClick = { state.value = 2 }
                    )
                    Text(current_quiz.getQuestion(question_number).getVariant(2))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state.value == 3,
                        onClick = { state.value = 3 }
                    )
                    Text(current_quiz.getQuestion(question_number).getVariant(3))
                }
            }
            if (question_number != 3) {
                Button(
                    onClick = {
                        if (state.value >= 0 && state.value <= 3) {
                            current_quiz.getQuestion(question_number).answer(state.value)
                            question_number += 1
                            state.value = -1
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Далее")
                }
            } else {
                Button(onClick = {
                    if (state.value >= 0 && state.value <= 3) {
                        current_quiz.getQuestion(question_number).answer(state.value)
                        startEnd()
                    }
                }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text("Завершить")
                }
            }
        }
        Text("Вернуться к предыдущим вопросам нельзя", color = Color.White)
    }
}

@Composable
private fun HelloScreen() {
    Button(modifier = Modifier.background(Color.White), onClick = {}) {
        Text("История", color = Color.Black)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "DAILY QUIZ",
            color = com.example.quizapp.view.theme.White,
            fontSize = 50.sp,
            fontWeight = FontWeight.Black,
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(25.dp)
                .clip(shape = RoundedCornerShape(20.dp))
        ) {
            Text(text = "Добро пожаловать в Daily Quiz!")
            Button(
                modifier = Modifier.background(com.example.quizapp.view.theme.Purple),
                onClick = startLoad
            ) {
                Text("Начать тест", color = Color.White)
            }
        }
    }
}
