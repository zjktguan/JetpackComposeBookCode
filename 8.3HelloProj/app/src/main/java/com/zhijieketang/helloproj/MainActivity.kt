package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
    // 创建 ScaffoldState 对象来管理 Scaffold 的状态
    val scaffoldState = rememberScaffoldState()

    // 使用Scaffold组件创建应用程序界面，并将 ScaffoldState 对象传递给 Scaffold 组件
    Scaffold(scaffoldState = scaffoldState,
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
                // 使用 GlobalScope.launch 来启动一个新的协程
                GlobalScope.launch {
                    // 在协程中调用 showSnackbar 函数以显示一个消息
                    scaffoldState.snackbarHostState.showSnackbar("Clicked Add")
                }
            }) {
                // 在浮动操作按钮中添加一个图标
                Icon(Icons.Rounded.Add, contentDescription = "Add")
            }
        })
}