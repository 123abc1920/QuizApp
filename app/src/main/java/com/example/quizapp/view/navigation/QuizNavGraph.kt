package com.example.bookapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizapp.view.views.HistoryScreen
import com.example.quizapp.view.views.MainScreen
import com.example.quizapp.view.views.ResultScreen

@Composable
fun QuizNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController=navController,
        startDestination = "home",
        modifier= Modifier.fillMaxSize()){
        composable("home") {
            MainScreen(navController)
        }
        composable("result") {
            ResultScreen(navController)
        }
        composable("history") {
            HistoryScreen(navController)
        }
    }
}