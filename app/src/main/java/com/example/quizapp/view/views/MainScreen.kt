package com.example.quizapp.view.views

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavController) {
    var isQuizScreenVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.quizapp.view.theme.Purple)
            .padding(25.dp)
    ) {
        //QuizScreen()
        if (isQuizScreenVisible) {
            QuizScreen(onBack = { isQuizScreenVisible = false })
        } else {
            HelloScreen(onStartQuiz = { isQuizScreenVisible = true })
        }
    }
}

@Preview
@Composable
private fun EndScreen() {
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
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.arrow_back_icon),
                    contentDescription = "Back"
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.arrow_back_icon),
                    contentDescription = "Back"
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.arrow_back_icon),
                    contentDescription = "Back"
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.arrow_back_icon),
                    contentDescription = "Back"
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.example.quizapp.R.drawable.arrow_back_icon),
                    contentDescription = "Back"
                )
            }
            Text ("4 из 5")
            Text ("Почти идеально")
            Text ("Описание")
            Button(onClick = {}) {
                Text("Начать заново")
            }
        }
    }
}


@Composable
private fun QuizScreen(onBack: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = onBack
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
                fontSize = 50.sp,
                fontWeight = FontWeight.Black,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Color.White)
                .wrapContentHeight()
                .fillMaxWidth()
                .weight(2f)
        ) {
            Text("Вопрос")
            Text("Как переводится")
            Column {
                Text("Вопрос")
                Text("Вопрос")
                Text("Вопрос")
                Text("Вопрос")
            }
            Button(onClick = {}) {
                Text("Далее")
            }
        }
        Text("Вернуться к предыдущим вопросам нельзя", color = Color.White)
    }
}

@Composable
private fun HelloScreen(onStartQuiz: () -> Unit) {
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
                onClick = onStartQuiz
            ) {
                Text("Начать тест", color = Color.White)
            }
        }
    }
}
