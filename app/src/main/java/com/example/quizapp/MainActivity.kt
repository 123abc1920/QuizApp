package com.example.quizapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.presentation.navigation.QuizNavGraph
import com.example.quizapp.view.theme.QuizAppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()

        QuizAppTheme {
            Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                QuizNavGraph(
                    navController = navController,
                    modifier = Modifier.Companion.padding(innerPadding)
                )
            }
        }

    }

}