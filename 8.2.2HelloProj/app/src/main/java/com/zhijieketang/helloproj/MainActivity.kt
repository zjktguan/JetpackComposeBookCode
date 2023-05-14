package com.zhijieketang.helloproj

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext

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
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Scaffold Basic Example")
        })
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

    }, bottomBar = { MyBottomBar() })
}

@Composable
fun MyBottomBar() {
// 获取当前组件的上下文
    val context = LocalContext.current

// 创建 BottomNavigation 组件，并添加三个 BottomNavigationItem 条目
    BottomNavigation {
        // 第一个条目，选中状态为 true
        BottomNavigationItem(
            selected = true,
            onClick = {
                // 处理点击事件，弹出 Toast 提示
                Toast.makeText(context, "Clicked Home", Toast.LENGTH_SHORT).show()
            },
            icon = {
                // 添加图标
                Icon(
                    imageVector = Icons.Filled.Home, contentDescription = "Home"
                )
            },
            label = {
                // 添加标签
                Text("Home")
            }
        )

        // 第二个条目，选中状态为 false
        BottomNavigationItem(
            selected = false,
            onClick = {
                // 处理点击事件，弹出 Toast 提示
                Toast.makeText(context, "Clicked Shopping Cart", Toast.LENGTH_SHORT).show()
            },
            icon = {
                // 添加图标
                Icon(
                    imageVector = Icons.Filled.ShoppingCart, contentDescription = "ShoppingCart"
                )
            },
            label = {
                // 添加标签
                Text("ShoppingCart")
            }
        )

        // 第三个条目，选中状态为 false
        BottomNavigationItem(
            selected = false,
            onClick = {
                // 处理点击事件，弹出 Toast 提示
                Toast.makeText(context, "Clicked Settings", Toast.LENGTH_SHORT).show()
            },
            icon = {
                // 添加图标
                Icon(
                    imageVector = Icons.Filled.Settings, contentDescription = "Settings"
                )
            },
            label = {
                // 添加标签
                Text("Settings")
            }
        )
    }

}
