package com.zhijieketang.helloproj

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//"Home"屏幕
@Composable
fun HomeScreen(navController: NavController) {
    AppScaffold(navController)
}

@Composable
fun AppScaffold(navController: NavController) {

    // 定义可变的 Boolean 值，用于控制浮动操作按钮是否可见
    var isFabVisible by remember { mutableStateOf(true) }

    // 使用 Scaffold 组件创建应用程序界面
    Scaffold(
        // 设置顶部应用栏
        topBar = {
            TopAppBar(title = {
                Text(text = "My Notes")
            })
        },
        // 设置内容区域
        content = {
            // 创建一个 Column 组件，用于垂直排列其子组件
            Column(
                modifier = Modifier
                    .fillMaxSize() // 将 Column 组件的大小设置为最大尺寸
                    .padding(paddingValues = it), // 在 Column 组件周围添加 padding
                verticalArrangement = Arrangement.Center, // 设置子组件的垂直排列方式为居中对齐
                horizontalAlignment = Alignment.CenterHorizontally // 设置子组件的水平排列方式为居中对齐
            ) {
                CreateLazyColumn(navController) // 调用 CreateLazyColumn 函数，创建主要内容区域
            }
        },
        // 设置浮动操作按钮
        floatingActionButton = {
            if (isFabVisible) { // 如果 isFabVisible 为 true，显示浮动操作按钮
                FloatingActionButton(
                    onClick = {
                        navController.navigate("add") // 当点击浮动操作按钮时，将用户导航到“add”屏幕
                        isFabVisible = false // 将 isFabVisible 设置为 false，使浮动操作按钮不可见
                    },
                ) {
                    // 在浮动操作按钮中添加一个图标
                    Icon(Icons.Rounded.Add, contentDescription = "Add")
                }
            }
        },
    )
}

@Composable
fun CreateLazyColumn(navController: NavController) {

    // 获取当前组件的上下文
    val context = LocalContext.current  //获取当前组件的上下文

    // 创建一个 DatabaseHelper 实例
    val dbHelper = DatabaseHelper(context)

    // 查询所有数据
    val datas = dbHelper.allNotes

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()  // 填满父组件的大小
            .padding(horizontal = 1.dp, vertical = 10.dp)  // 设置组件的内边距
            .animateContentSize(),  // 添加 animateContentSize 修饰符，让组件的大小变化具有动画效果
        contentPadding = PaddingValues(1.dp)  // 设置列表项的内边距
    ) {
        // 对于列表中的每个项，创建一个文本节点，并为其添加 clickable 修饰符
        items(count = datas.size) { index ->
            val note = datas[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()  // 填满父组件的宽度
                    .height(72.dp)  // 设置容器的高度
                    .padding(horizontal = 2.dp)  // 设置容器的内边距
                    .clickable(  // 添加 clickable 修饰符，使容器可以被点击
                        interactionSource = remember { MutableInteractionSource() },  // 创建可变的 InteractionSource 对象
                        indication = rememberRipple(color = Color.LightGray),  // 设置点击时的涟漪效果
                        onClick = {
                            // 将 note.id 作为参数传递给 navController 的 navigate 函数，并在 lambda 表达式中修改 noteId 的值
                            navController.navigate("delete/${note.id}")
                        })
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterStart)  // 设置组件的对齐方式
                ) {
                    Text(
                        text = note.date,  // 设置文本内容为备忘录的日期
                        fontSize = 14.sp,  // 设置字体大小
                        fontWeight = FontWeight.Medium,  // 设置字体粗细
                        color = Color.Gray  // 设置字体颜色
                    )
                    Text(
                        text = note.content,  // 设置文本内容为备忘录的内容
                        fontSize = 16.sp,  // 设置字体大小
                        fontWeight = FontWeight.Bold  // 设置字体粗细
                    )
                }
                Divider(
                    color = Color.Gray,  // 设置分割线的颜色
                    thickness = 0.5.dp,  // 设置分割线的粗细
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)  // 设置分割线的内边距
                )
            }
        }
    }
}