package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Switch
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 获取当前组件的上下文
            val context = LocalContext.current.applicationContext
            Switch(
                checked = false,
                onCheckedChange = { checked ->
                    if(checked) {
                        Toast.makeText(context, "开启!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "关闭!", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}
