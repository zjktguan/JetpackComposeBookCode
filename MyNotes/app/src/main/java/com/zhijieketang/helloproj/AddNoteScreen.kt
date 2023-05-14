package com.zhijieketang.helloproj

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddNoteScreen(navController: NavController) {
// 创建一个可变状态的变量noteText，初始值为空
    var noteText by remember { mutableStateOf("") }
// 获取当前组件的上下文
    val context = LocalContext.current

// 创建一个垂直的线性布局，添加16dp的内边距，内容居中，水平方向居中
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 创建一个文本组件，用于展示标题
        Text(
            text = "Add Note",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 创建一个带有边框的文本输入框，用于输入备忘录内容，将输入的内容存储到noteText变量中
        OutlinedTextField(
            value = noteText,
            onValueChange = { noteText = it },
            label = { Text("Enter note content here") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // 创建一个水平的线性布局，添加在同一行中的两个按钮，用于保存或取消备忘录
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            // 创建一个保存按钮
            Button(
                onClick = {

                    val dbHelper = DatabaseHelper(context)
                    val note = Note()
                    note.content = noteText

                    dbHelper.insertNote(note)
                    navController.popBackStack()
                }, modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp) // 添加8dp的左内边距
            ) {
                Text("Save")
            }

            // 创建一个取消按钮，用于返回到上一个屏幕
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp) // 添加8dp的左内边距
            ) {
                Text("Cancel")
            }
        }
    }
}