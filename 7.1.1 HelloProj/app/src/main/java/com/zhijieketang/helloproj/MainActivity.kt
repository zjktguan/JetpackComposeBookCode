package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 获取当前组件的上下文
            val contextForToast = LocalContext.current.applicationContext
            // 创建可变状态变量
            val textState = remember { mutableStateOf("世界您好！") }

            TextField(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                value = textState.value,
                onValueChange = { text ->
                    textState.value = text
                    // 处理文本值变更回调函数
                }
            )
        }
    }
}
