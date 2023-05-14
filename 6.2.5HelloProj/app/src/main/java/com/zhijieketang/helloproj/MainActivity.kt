package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 获取当前组件的上下文
            val context = LocalContext.current.applicationContext
            Slider(
                value = 0f,
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                onValueChange  = { value ->
                    Toast.makeText(context, "滑块位置变化!", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
