package com.zhijieketang.helloproj

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Switch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 获取当前组件的上下文
            val context = LocalContext.current.applicationContext
            // 创建可变状态的变量 switchChecked，初始值为 false
            val switchChecked = remember { mutableStateOf(false) }
            // 使用 Switch 的 checked 和 onCheckedChange 属性来实现开关状态的切换

            Switch(
                checked = switchChecked.value,
                onCheckedChange = { checked ->
                    // 更新 switchChecked 变量的值
                    switchChecked.value = checked
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
