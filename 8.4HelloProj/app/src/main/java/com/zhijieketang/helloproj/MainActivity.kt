package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCard()
        }
    }
}

// 定义 MyCard 组件
@Composable
fun MyCard() {
    // 创建 Card 组件，指定属性
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        // 创建 Column 组件，指定属性
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // 创建 Text 组件，添加标题
            Text(
                "工程狮", modifier = Modifier.padding(bottom = 8.dp)
            )
            // 创建 Image 组件，添加图片
            Image(
                painter = painterResource(R.drawable.my_image),
                contentDescription = null,
                modifier = Modifier
                    .height(240.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            // 创建 Text 组件，添加描述
            Text(
                "这是我的《漫画Java》一书中的漫画角色。", modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}