package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 获取当前组件的上下文
            val contextForToast = LocalContext.current.applicationContext
            // 创建一个按钮，当用户点击时调用lambda表达式
            Button(onClick = {
                Toast.makeText(contextForToast, "Clicked the button", Toast.LENGTH_SHORT).show()
            }) {
                Text("Click me")
            }
        }
    }
}
