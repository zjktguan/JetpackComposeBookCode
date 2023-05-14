package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 在 setContent 中设置界面内容为 MyScreenContent 函数的返回值
            MyScreenContent()
        }
    }

    // 定义一个可组合函数 MyColumn，接受一个中间内容的可组合函数作为参数
    @Composable
    fun MyColumn(middleContent: @Composable () -> Unit) {
        Column {
            Text("Top Text")
            // 调用中间内容的可组合函数
            middleContent()
            Text("Bottom Text")
        }
    }

    // 定义一个 ButtonDemo 可组合函数，显示一个带有文本的按钮
    @Composable
    fun ButtonDemo() {
        Button(onClick = { }) {
            Text("Click Me")
        }
    }

    // 定义 MyScreenContent 可组合函数，调用 MyColumn 函数并传递 ButtonDemo 函数作为中间内容
    @Composable
    fun MyScreenContent() {
        MyColumn(middleContent = { ButtonDemo() })
    }
}