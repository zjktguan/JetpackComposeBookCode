package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

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
    // 获取当前组件的上下文
    val context = LocalContext.current

    // 使用Scaffold组件创建应用程序界面
    Scaffold(
        // 设置顶部应用栏
        topBar = {
            TopAppBar(title = {
                Text(text = "Scaffold Basic Example")
            })
        },
        // 设置内容区域
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 在内容区域中添加一个文本
                Text(text = "Content")
            }
        },
        // 设置浮动操作按钮
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(
                    context, "Clicked Add", Toast.LENGTH_SHORT
                ).show()
            }) {
                // 在浮动操作按钮中添加一个图标
                Icon(Icons.Rounded.Add, contentDescription = "Add")
            }
        })
}