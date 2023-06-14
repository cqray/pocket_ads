package cn.cqray.plugin.flutter

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 * Flutter插件基础实现
 * @property name 通道名
 */
open class BaseFlutterPlugin(private val name: String) : FlutterPlugin, MethodChannel.MethodCallHandler {

    private lateinit var channel: MethodChannel

    private val pluginMethods: MutableList<PluginMethods> = mutableListOf()

//    private val methods: MutableMap<PluginMethods, List<Method>> = mutableMapOf()

    open override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        // 注册通道
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, name)
        channel.setMethodCallHandler(this)
    }

    open override fun onDetachedFromEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        // 释放通道
        channel.setMethodCallHandler(null)
    }

    open override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        for (methods in pluginMethods) {
            val array = methods.javaClass.methods
            for (method in array) {
                println("================${method.name}====${call.method} ==== ${call.arguments}")
                if (method.name == call.method) {
                    result.success(method.invoke(methods))
                    return
                }
            }
        }
        result.notImplemented()
    }

    fun addPluginMethod(methods: PluginMethods) {
        pluginMethods.add(methods)
//        pluginMethods.forEach {
//            val methods = this.methods[it]
//            if (methods == null) {
//                this.methods[methods]
//                it.javaClass.methods
//            }
//        }
//        this.methods.forEach {
//            val pm = it.key
//
//        }
    }
}