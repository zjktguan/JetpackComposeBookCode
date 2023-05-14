package com.zhijieketang.helloproj

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    companion object MyCompanion {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 获取当前组件的上下文
            val contextForToast = LocalContext.current.applicationContext
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                // First button
                Button(onClick = {
                    Toast.makeText(contextForToast, "Button 1 clicked!", Toast.LENGTH_SHORT).show()
                    Log.i("MainActivity", "Button 1 clicked!")
                }) {
                    Text("Button 1")
                }
                Spacer(modifier = Modifier.height(20.dp))
                // Second button
                Button(onClick = {
                    Toast.makeText(contextForToast, "Button 2 clicked!", Toast.LENGTH_SHORT).show()
                    Log.i("MainActivity", "Button 2 clicked!")
                }, modifier = Modifier.height(60.dp)) {
                    Text("Button 2")
                }
            }
        }
    }
}
