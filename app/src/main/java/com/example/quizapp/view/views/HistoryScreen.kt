package com.example.quizapp.view.views

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.presenter.*

private lateinit var navController: NavController

@Composable
fun HistoryScreen(_navController: NavController) {
    var status by remember { mutableStateOf(historyStatus) }
    navController = _navController

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.quizapp.view.theme.Purple)
            .padding(25.dp)
    ) {
        Text("История", color = Color.White, fontWeight = FontWeight.Bold)
        if (status == HistoryScreenStatus.EMPTY) {
            NoQuizScreen()
        } else if (status == HistoryScreenStatus.SHOW) {
            QuizScreen()
        }
    }
}

@Composable
private fun NoQuizScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text("Вы еще не проходили ни одной викторины", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Button(onClick = { navController.navigate("home") }) {
            Text("Начать викторину", fontWeight = FontWeight.Bold)
        }
    }
    Text(
        text = "DAILY QUIZ",
        color = com.example.quizapp.view.theme.White,
        fontSize = 40.sp,
        fontWeight = FontWeight.Black,
    )
}

@Composable
private fun QuizScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.verticalScroll(ScrollState(0))
    ) {
        var i = 0;
        repeat(history.getSize()) {
            Column(
                modifier = Modifier.background(Color.White)
            ) {
                Row {
                    Text("Quiz " + i, fontSize = 20.sp)
                    var j = 0
                    repeat(5) {
                        if (history.getQuiz(i).getResult().getRate() > i) {
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
                        j++
                    }
                }
                Row {
                    Text(history.getQuiz(i).getDate())
                    Text(history.getQuiz(i).getTime())
                }
            }
            i++
        }
    }
}