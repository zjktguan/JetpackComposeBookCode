package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 显示一个图像
            Image(
                painter = painterResource(id = R.drawable.orange), // 加载资源文件中的图像
                alpha = 0.2F,  // 加载资源文件中的图像透明度
                contentDescription = "My Image", // 设置图像的内容描述，有助于可访问性
                modifier = Modifier.size(width = 400.dp, height = 400.dp) // 设置图像的大小
            )
        }
    }
}
