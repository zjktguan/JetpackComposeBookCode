package com.zhijieketang.helloproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 使用 setContent 函数设置 Activity 的内容视图为 LeftRightText
        setContent {
            LeftRightText()
        }
    }
}

// 定义一个 Composable 函数，用于显示两个 Text 组件，并使用 ConstraintLayout 进行布局
@Composable
fun LeftRightText() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize() // 通过 fillMaxSize() 属性使 ConstraintLayout 占据整个父容器
    ) {
        // 创建两个 Ref，用于在组件之间建立关系
        val (leftText, rightText) = createRefs()
        // 左侧 Text 组件
        Text(
            text = "Left Text", // 文本内容
            modifier = Modifier
                .constrainAs(leftText) { // 约束该组件的位置
                    top.linkTo(parent.top) // 上边缘与父容器上边缘对齐
                    bottom.linkTo(parent.bottom) // 下边缘与父容器下边缘对齐
                    start.linkTo(parent.start) // 左边缘与父容器左边缘对齐
                }
                .padding(16.dp) // 设置组件的 padding
                .layoutId("leftText") // 为该组件指定 layoutId，用于在 ConstraintLayout 中建立关系
        )

        // 右侧 Text 组件
        Text(
            text = "Right Text", // 文本内容
            modifier = Modifier
                .constrainAs(rightText) { // 约束该组件的位置
                    top.linkTo(parent.top) // 上边缘与父容器上边缘对齐
                    bottom.linkTo(parent.bottom) // 下边缘与父容器下边缘对齐
                    end.linkTo(parent.end) // 右边缘与父容器右边缘对齐
                    start.linkTo(leftText.end) // 左边缘与左侧 Text 组件的右边缘对齐
                }
                .padding(16.dp) // 设置组件的 padding
                .layoutId("rightText") // 为该组件指定 layoutId，用于在 ConstraintLayout 中建立关系
        )
    }
}
