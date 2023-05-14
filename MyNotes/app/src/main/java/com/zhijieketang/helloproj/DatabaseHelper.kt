package com.zhijieketang.helloproj

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) { // 创建一个DatabaseHelper类，用于管理备忘录的数据库

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {  // 当数据库创建时调用此方法
        sqLiteDatabase.execSQL(CREATE_TABLE)  // 执行创建备忘录表的SQL语句
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {  // 当数据库升级时调用此方法
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)  // 删除备忘录表
        onCreate(db)  // 重新创建备忘录表
    }

    fun insertNote(note: Note) {  // 插入备忘录的方法
        val db = this.writableDatabase  // 获取可写的数据库实例
        val values = ContentValues()  // 创建一个ContentValues对象，用于添加备忘录的内容
        values.put(COLUMN_CONTENT, note.content)  // 向ContentValues对象添加备忘录的内容
        db.insert(TABLE_NAME, null, values)  // 将备忘录插入到数据库中
        db.close()  // 关闭数据库连接
    }

    val allNotes: List<Note>  // 获取所有备忘录的方法
        get() {
            val list: MutableList<Note> = ArrayList()  // 创建一个空的备忘录列表
            val db = readableDatabase  // 获取只读的数据库实例
            val projection = arrayOf(COLUMN_ID, COLUMN_CONTENT, COLUMN_DATE)  // 定义查询的列名
            val cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)  // 查询备忘录表中的所有记录
            while (cursor.moveToNext()) {  // 遍历查询结果
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID))  // 获取备忘录的ID
                val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))  // 获取备忘录的日期
                val content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))  // 获取备忘录的内容
                val note = Note()  // 创建一个新的备忘录对象
                note.id = id  // 设置备忘录对象的ID
                note.date = date  // 设置备忘录对象的日期
                note.content = content  // 设置备忘录对象的内容
                list.add(note)  // 将备忘录对象添加到备忘录列表中
            }
            cursor.close()  // 关闭查询结果的游标
            db.close()  // 关闭数据库连接
            return list  // 返回备忘录列表
        }

    fun deleteNoteById(id: Long?) {  // 根据备忘录的ID删除备忘录的方法
        val db = writableDatabase  // 获取可写的数据库实例
        db.delete(TABLE_NAME, COLUMN_ID + "=?", arrayOf(id.toString()))  // 根据ID删除备忘录
        db.close()  // 关闭数据库连接
    }

    fun getNoteById(id: Long): Note? {  // 根据备忘录的ID获取备忘录的方法
        val db = writableDatabase  // 获取可写的数据库实例
        val projection = arrayOf(COLUMN_ID, COLUMN_CONTENT, COLUMN_DATE)  // 定义查询的列名
        val selection = "$COLUMN_ID = ?"  // 定义查询的条件
        val selectionArgs = arrayOf(id.toString())  // 定义查询的参数
        val cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null)  // 查询备忘录表中符合条件的记录
        var note: Note? = null  // 创建一个空的备忘录对象
        if (cursor.moveToFirst()) {  // 如果查询结果非空
            val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))  // 获取备忘录的日期
            val content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))  // 获取备忘录的内容
            note = Note()  // 创建一个新的备忘录对象
            note.id = id  // 设置备忘录对象的ID
            note.date = date  // 设置备忘录对象的日期
            note.content = content  // 设置备忘录对象的内容
        }
        cursor.close()  // 关闭查询结果的游标
        db.close()  // 关闭数据库连接
        return note  // 返回备忘录对象
    }

    companion object {  // 定义一些常量
        const val DATABASE_NAME = "notes.db"  // 数据库名称
        private const val DATABASE_VERSION = 1  // 数据库版本号
        const val TABLE_NAME = "note"  // 数据库表名
        const val COLUMN_ID = "_id"  // 备忘录的ID列名
        const val COLUMN_CONTENT = "content"  // 备忘录的内容列名
        const val COLUMN_DATE = "date"  // 备忘录的日期列名
        private const val CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +  // 创建备忘录表的SQL语句
                COLUMN_DATE + " DATE DEFAULT CURRENT_TIMESTAMP, " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CONTENT + " VARCHAR(255))"
    }
}