package com.example.quizapp.view.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun HistoryScreen(navController: NavController) {
    Screen()
}

@Preview
@Composable
private fun Screen() {
    Column {
        Text("Hello")
    }
}