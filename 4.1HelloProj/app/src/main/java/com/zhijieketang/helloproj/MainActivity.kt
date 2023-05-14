package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                // Box是一个可组合函数，它是一个容器，用于包含其他可组合函数。
                modifier = Modifier
                    .width(100.dp)  // 设置Box的宽度为100dp
                    .height(100.dp)  // 设置Box的高度为100dp
                    .background(Color.Red)  // 设置Box的背景颜色为红色
            )
        }
    }
}
