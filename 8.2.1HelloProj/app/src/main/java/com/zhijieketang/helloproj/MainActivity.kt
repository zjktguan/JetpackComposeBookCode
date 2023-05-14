package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldBasicExample()
        }
    }
}

@Composable
fun ScaffoldBasicExample() {
    // 创建一个带有顶部应用栏的屏幕布局
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Scaffold Basic Example") },
        )
    }, content = {
        // 创建一个填充整个屏幕的列布局
        Column(
            // 通过 Modifier.fillMaxSize() 设置为填充整个屏幕
            modifier = Modifier
                .fillMaxSize()
                // 通过 padding(it) 从 content 参数中获取填充值
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            // 在列布局中添加一个文本组件
            Text(text = "This is Content")
        }
    })
}