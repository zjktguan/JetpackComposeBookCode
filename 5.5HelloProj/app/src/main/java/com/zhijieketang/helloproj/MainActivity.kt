package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            // 创建可变状态变量，保存当前选中的水果
            var selectedFruit by remember { mutableStateOf("") }
            Column {
                // 添加“苹果”文本
                Text(
                    modifier = Modifier.padding(start = 1.dp),
                    text = "苹果"
                )
                RadioButton(
                    selected = selectedFruit == "苹果",
                    onClick = { selectedFruit = "苹果" },
                )
                // 添加“香蕉”文本
                Text(
                    modifier = Modifier.padding(start = 1.dp),
                    text = "香蕉"
                )
                RadioButton(
                    selected = selectedFruit == "香蕉",
                    onClick = { selectedFruit = "香蕉" },
                )
                // 添加“芒果”文本
                Text(
                    modifier = Modifier.padding(start = 1.dp),
                    text = "芒果"
                )
                RadioButton(
                    selected = selectedFruit == "芒果",
                    onClick = { selectedFruit = "芒果" },
                )
            }
        }
    }
}
