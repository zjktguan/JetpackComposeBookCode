package com.zhijieketang.helloproj

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                // 添加“苹果”文本
                Text(
                    modifier = Modifier.padding(start = 1.dp),
                    text = "苹果"
                )
                Checkbox(
                    checked = false,
                    onCheckedChange = {
                        Log.i(TAG, "苹果：$it")
                    },
                )
                // 添加“香蕉”文本
                Text(
                    modifier = Modifier.padding(start = 1.dp),
                    text = "香蕉"
                )
                // 添加一个复选框，并在复选框状态变化时弹出 Toast 消息
                Checkbox(
                    checked = true,
                    onCheckedChange = {
                        Log.i(TAG, "香蕉：$it")
                    },
                )

                // 添加“芒果”文本
                Text(
                    modifier = Modifier.padding(start = 1.dp),
                    text = "芒果"
                )
                // 添加一个复选框，并在复选框状态变化时弹出 Toast 消息
                Checkbox(
                    checked = true,
                    onCheckedChange = {
                        Log.i(TAG, "芒果：$it")
                    },
                )
            }
        }
    }
}
