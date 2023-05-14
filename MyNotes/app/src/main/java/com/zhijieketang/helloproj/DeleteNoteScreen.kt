package com.zhijieketang.helloproj

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DeleteNoteScreen(navController: NavController, args: Long) {

    // 获取当前上下文环境
    val context = LocalContext.current
    // 创建数据库助手
    val dbHelper = DatabaseHelper(context)
    // 通过备忘录ID获取备忘录信息
    val note = dbHelper.getNoteById(args) ?: return

    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it),
            ) {
                ShowDetail(navController, note)
            }
        },
    )
}

@Composable
fun ShowDetail(navController: NavController, note: Note?) {

    // 获取当前上下文环境
    val context = LocalContext.current
    // 创建数据库助手
    val dbHelper = DatabaseHelper(context)

    // 使用Column函数创建一个垂直方向的列，用于展示备忘录的详细信息
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 展示文本 "Delete Note"
        Text(
            text = "Delete Note",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 展示备忘录的ID信息
        Text(
            text = "ID: ${note?.id}",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 展示备忘录的日期信息
        Text(
            text = "Date: ${note?.date}",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 展示备忘录的内容信息
        Text(
            text = "Content: ${note?.content}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 使用Row函数创建一个水平方向的行，用于展示删除和取消按钮
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // 展示删除按钮
            Button(
                onClick = {
                    // 通过备忘录ID删除备忘录
                    dbHelper.deleteNoteById(note?.id)
                    // 返回上一个屏幕
                    navController.popBackStack()

                }, modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp) // 添加8dp的右内边距
            ) {
                Text("Delete")
            }
            // 展示取消按钮
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp) // 添加8dp的左内边距
            ) {
                Text("Cancel")
            }
        }
    }
}