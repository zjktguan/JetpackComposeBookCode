package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 在setContent函数中调用MyScaffold组件，作为应用程序的根组件
            MyScaffold()
        }
    }
}

// 定义一个组件，作为应用程序的根组件
@Composable
fun MyScaffold() {
    Scaffold(
        topBar = {
            // 顶部应用栏
            TopAppBar(title = {
                Text(text = "LazyRow Example")
            })
        },
        content = {
            // 应用程序的主要内容
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it)
            ) {
                // 在Box中添加一个Column，将LazyRow组件包含在其中
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 添加一个文本组件，说明这是一个LazyRow的示例
                    Text(text = "This is a LazyRow example")
                    // 调用CreateLazyRow函数，显示横向滚动的项目列表
                    CreateLazyRow()
                }
            }
        }
    )
}

// 定义一个组件，用于显示横向滚动的项目列表
@Composable
fun CreateLazyRow() {
    // 获取当前上下文
    val context = LocalContext.current
    // 创建一个包含10个项目的列表
    val items = (1..10).toList()
    // 显示横向滚动的项目列表
    LazyRow(
        modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp)
    ) {
        items(count = items.size) { index ->
            // 对于每个项目，创建一个Box组件
            Box(modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .background(Color.LightGray)
                .clickable {
                    // 当用户点击项目时，显示一个Toast，说明用户点击了哪个项目
                    Toast
                        .makeText(
                            context, "You clicked on item ${index + 1}", Toast.LENGTH_SHORT
                        )
                        .show()
                }) {
                // 在Box中加又包含一个Box，将文本组件包含在其中，以显示项目编号
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text(text = "Item ${index + 1}", fontSize = 16.sp)
                }
            }
        }
    }
}