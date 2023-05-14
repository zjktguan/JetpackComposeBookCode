package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Box(
                modifier = Modifier.size(150.dp), // 设置 Box 大小为 150dp
                contentAlignment = Alignment.Center // 将 Box 内容居中对齐

            ) {
                Image(
                    painter = painterResource(id = R.drawable.orange),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .size(150.dp)// 设置 Image 大小为 150dp
                        .clip(CircleShape) // 使用 CircleShape 剪辑修饰符将其裁剪成圆形
                )
            }
        }
    }
}
