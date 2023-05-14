package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 获取当前组件的上下文
            val contextForToast = LocalContext.current.applicationContext
            // 调用 ClickableButtonExample 函数，并传入 onClick 回调函数
            ClickableButtonExample(onClick = {
                // 处理按钮点击事件，在这里创建 Toast 显示消息
                Toast.makeText(contextForToast, "Clicked the button", Toast.LENGTH_SHORT).show()
            })
        }
    }

    // 定义一个可组合函数，返回一个 Button 组件
    @Composable
    fun ClickableButtonExample(onClick: () -> Unit) {
        // 使用修饰符指定 Button 的特性，例如高度和宽度
        Button(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            // 添加 onClick 回调函数，用于处理按钮的点击事件
            onClick = onClick,
            // 添加 Text 组件，作为 Button 的内容
            content = { Text(text = "Click me!") }
        )

    }
}
