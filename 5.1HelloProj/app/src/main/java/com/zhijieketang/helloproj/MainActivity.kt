package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            // 调用自定义的 Composable 函数 MyStyledText() 来显示样式化的文本
            MyStyledText()
//            Text(
//                "Hello, world!",
//                fontSize = 20.sp,
//                color = Color.Red,
//                fontStyle = FontStyle.Italic
//            )
        }
    }

    // 定义一个 Composable 函数 MyStyledText() 来显示样式化的文本
    @Composable
    fun MyStyledText() {
        // 使用 Column 组件来垂直排列文本
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // 第一行文本：标题
            Text(
                text = "My Title",
                fontSize = 28.sp, // 设置字体大小为 28sp
                fontWeight = FontWeight.Bold, // 设置字体粗细为粗体
                color = Color.Blue, // 设置字体颜色为蓝色
                modifier = Modifier.padding(bottom = 8.dp) // 设置底边距为 8dp
            )
            // 第二行文本：正文
            Text(
                text = "This is some styled text!",
                fontSize = 18.sp, // 设置字体大小为 18sp
                color = Color.Black, // 设置字体颜色为黑色
                fontStyle = FontStyle.Italic, // 设置字体样式为斜体
                modifier = Modifier.padding(top = 8.dp) // 设置顶边距为 8dp
            )
        }
    }
}
