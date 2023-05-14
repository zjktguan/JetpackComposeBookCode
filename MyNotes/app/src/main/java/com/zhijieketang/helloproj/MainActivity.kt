package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController)
        }
    }

    //定义导航图表
    @Composable
    fun AppNavigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {

            //定义"home"屏幕
            composable("home") {
                HomeScreen(navController = navController)
            }
            //定义"Add Note"屏幕
            composable("add") {
                AddNoteScreen(navController = navController)
            }
            //定义"Delete Note"屏幕
            composable(
                "delete/{id}", arguments = listOf(
                    navArgument("id") { type = NavType.LongType },
                )
            ) { backStackEntry ->
                val argId = backStackEntry.arguments?.getLong("id") ?: 0
                DeleteNoteScreen(navController = navController, args = argId)
            }
        }
    }
}