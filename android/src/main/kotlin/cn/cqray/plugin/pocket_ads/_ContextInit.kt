package cn.cqray.plugin.pocket_ads

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.*
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.Utils
import java.util.*

/**
 * 上下文初始化，不暴露给外部
 * @author Cqray
 */
@Suppress("ClassName")
internal class _ContextInit : ContentProvider() {

    //========================================================
    //=================ContentProvider相关部分=================
    //========================================================

    override fun onCreate(): Boolean {
        // 初始化Application
        application = context!!.applicationContext as Application
        MultiDex.install(application)
        Utils.init(application)
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? = null

    override fun getType(uri: Uri): String? = null

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = 0

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?) = 0

    companion object {
        lateinit var application: Application

        // 获取上下文
        val context: Context get() = application.applicationContext;

        //context get() = application.app
    }
}