package com.zhijieketang.helloproj

data class Note( // 定义一个数据类Note，用于表示备忘录
    var date: String, // 备忘录的日期
    var id: Long, // 备忘录的ID
    var content: String // 备忘录的内容
) {
    constructor() : this("", 0L, "") // 定义一个无参构造函数，用于创建一个空的备忘录对象
}