package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun MyScaffold() {

    // 使用Scaffold组件创建应用程序界面
    Scaffold(
        // 设置顶部应用栏
        topBar = {
            TopAppBar(title = {
                Text(text = "LazyColumn Example")
            })
        },
        // 设置内容区域
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it),
            ) {
                // 调用CreateLazyColumn函数创建示例LazyColumn
                CreateLazyColumn()
            }
        })
}


@Composable
fun CreateLazyColumn() {
    // 获取当前组件的上下文
    val context = LocalContext.current
    // 创建一个包含20个项的整数列表
    val items = (1..20).toList()
    LazyColumn(
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)
    ) {
        // 对于列表中的每个项，创建一个文本节点，并为其添加clickable修饰符
        items(count = items.size) { index ->
            Text(text = "Item ${index + 1}",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // 当用户单击文本节点时，显示一个短暂的Toast消息，显示用户单击了哪个项目
                        Toast
                            .makeText(
                                context, "You clicked on item ${index + 1}", Toast.LENGTH_SHORT
                            )
                            .show()
                    }

            )
        }
    }
}