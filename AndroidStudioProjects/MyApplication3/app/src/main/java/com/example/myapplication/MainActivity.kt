

package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.model.Tutor
import com.example.myapplication.ui.theme.HomeScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tutors = listOf(
            Tutor("Ayesha Rahman", "Mathematics", 4.5f, true, R.drawable.ic_launcher_foreground),
            Tutor("Tir Ahmed", "Physics", 4.0f, false, R.drawable.ic_launcher_foreground),
            Tutor("Nusrat Jahan", "Chemistry", 5.0f, true, R.drawable.ic_launcher_foreground)
        )

        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController, tutors)
                    }
                    composable("profile/{name}") { backStackEntry ->
                        val tutorName = backStackEntry.arguments?.getString("name")
                        val tutor = tutors.find { it.name == tutorName }
                        tutor?.let {
                            TutorProfileScreen(it) { navController.popBackStack() }
                        }
                    }
                }
            }
        }
    }
}
