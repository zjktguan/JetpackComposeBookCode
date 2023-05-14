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
            TextField(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                value = "Hello, world!", // 初始文本值
                onValueChange = { text ->
                    // 处理文本值变更回调函数
                    val  msg = "Text value changed to $text!"
                    println(msg)
                    Toast.makeText(contextForToast, msg, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
