package com.example.bookapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizapp.view.views.MainScreen

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
    }
}