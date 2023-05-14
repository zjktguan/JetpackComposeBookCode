package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Row { // 水平排列的容器
                Column( // 第一列容器
                    modifier = Modifier
                        .weight(1f) // 分配相等的空间
                        .padding(16.dp), // 添加填充
                    horizontalAlignment = Alignment.CenterHorizontally, // 居中对齐
                ) {
                    Text("第一列 - 第一行") // 第一列第一行的文本
                    Text("第一列 - 第二行") // 第一列第二行的文本
                    Text("第一列 - 第三行") // 第一列第三行的文本
                }

                Column( // 第二列容器
                    modifier = Modifier
                        .weight(1f) // 分配相等的空间
                        .padding(16.dp), // 添加填充
                    horizontalAlignment = Alignment.CenterHorizontally, // 居中对齐
                ) {
                    Text("第二列 - 第一行") // 第二列第一行的文本
                    Text("第二列 - 第二行") // 第二列第二行的文本
                    Text("第二列 - 第三行") // 第二列第三行的文本
                }
            }
        }
    }
}
