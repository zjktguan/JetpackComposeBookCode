package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTextField()
        }
    }
    @Composable
    fun MyTextField() {
        var textValue by remember { mutableStateOf("") }
        TextField(value = textValue,
            onValueChange = { textValue = it },
            label = { Text("请输入一些内容") }
        )
    }
}
