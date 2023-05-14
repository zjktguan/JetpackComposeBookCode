package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// 定义传递的参数
data class MyArgs(val name: String, val age: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }

    // 定义导航图表
    @Composable
    fun AppNavigation() {
        // 创建NavController来管理导航
        val navController = rememberNavController()
        // 导航主机, 起始目标为 "home" 屏幕
        NavHost(navController = navController, startDestination = "home") {
            //定义"home"屏幕
            composable("home") {
                HomeScreen(navController = navController)
            }
            // 定义 "profile" 屏幕
            composable("profile/{name}/{age}",
                arguments = listOf(navArgument("name") { type = NavType.StringType },
                    navArgument("age") { type = NavType.IntType })) { backStackEntry ->
                val args = MyArgs(
                    name = backStackEntry.arguments?.getString("name") ?: "",
                    age = backStackEntry.arguments?.getInt("age") ?: 0
                )
                ProfileScreen(navController = navController, args = args)
            }
        }
    }

    // "Home" 屏幕
    @Composable
    fun HomeScreen(navController: NavController) {
        Column {
            // 导航到 "profile" 屏幕的按钮
            Button(onClick = { navController.navigate("profile/Jane/25") }) {
                Text(text = "Go to profile screen")
            }
        }
    }

    // "Profile" 屏幕
    @Composable
    fun ProfileScreen(navController: NavController, args: MyArgs) {
        Column {
            // 显示文本 "欢迎来到个人资料屏幕!"
            // 显示欢迎文本和传递的参数
            Text(text = "Welcome to the profile screen, ${args.name}! You are ${args.age} years old.")
            // 返回 "home" 屏幕的按钮
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Go back to home screen")
            }
        }
    }
}