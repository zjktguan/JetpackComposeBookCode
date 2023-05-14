package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyText()
        }
    }
    /**
     * Composable 函数，用于创建一个包含文本的组件
     */
    @Composable
    fun MyText() {
        Text(
            modifier = Modifier
                .fillMaxWidth() // 设置宽度为最大可用宽度
                .padding(26.dp) // 设置内边距为26dp
                .height(90.dp) // 设置高度为100dp
                .background(Color.Red), // 设置背景颜色为红色
            color = Color.White, // 设置文本颜色为白色
            textAlign = TextAlign.Center, // 设置文本居中对齐
            text = "Hello, Jetpack Compose!", // 显示的文本内容
            fontSize = 24.sp // 设置字体大小为24sp
        )
    }
}
