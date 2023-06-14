package cn.cqray.plugin.pocket_ads

import android.util.Log
import com.blankj.utilcode.util.ActivityUtils
import com.zh.pocket.PocketSdk
import com.zh.pocket.ads.fullscreen_video.FullscreenVideoAD
import com.zh.pocket.ads.fullscreen_video.FullscreenVideoADListener
import com.zh.pocket.ads.reward_video.RewardVideoAD
import com.zh.pocket.ads.reward_video.RewardVideoADListener
import com.zh.pocket.error.ADError
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

@Suppress("Unused")
class PocketAdsPlugin : FlutterPlugin, MethodCallHandler {

    private lateinit var channel: MethodChannel

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "pocket_ads")
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "init" -> onInit(call, result)
            "loadRewardVideoAD" -> onLoadRewardVideoAD(call, result)
            "getPlatformVersion" -> {
                result.success("Android ${android.os.Build.VERSION.RELEASE}")
            }
            "test" -> {
                println(call.method + "${call.arguments}")
                result.success("123465789")
            }
            else -> {
                result.notImplemented()
            }
        }
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    // 初始化
    private fun onInit(call: MethodCall, result: Result) {
        val params = call.arguments as Map<*, *>
        PocketSdk.initSDK(
            _ContextInit.context,
            params["channel"] as String?,
            params["appId"] as String?
        )
        result.success(null)
    }

    // 激励视频
    private fun onLoadRewardVideoAD(call: MethodCall, result: Result) {
        print("===========================我被调用了")
        Log.e("删数据", "\"===========================我被调用了")
        val ad = RewardVideoAD(ActivityUtils.getTopActivity(), "55339", false)
        ad.setRewardVideoADListener(object : RewardVideoADListener {
            override fun onADLoaded() {
                ad.showAD()
                Log.e("删数据", "\"===========================我被调用了")
            }

            override fun onVideoCached() {}
            override fun onADShow() {}
            override fun onADExposure() {}
            override fun onReward() {}
            override fun onADClicked() {}
            override fun onVideoComplete() {}
            override fun onADClosed() {}
            override fun onSuccess() {}
            override fun onFailed(error: ADError) {
                Log.e("======", error.toString())
            }

            override fun onSkippedVideo() {}
        })
        ad.loadAD()

//        val mFullscreenVideoAD = FullscreenVideoAD(ActivityUtils.getTopActivity(), "55337")
//        mFullscreenVideoAD.setFullscreenVideoADListener(object : FullscreenVideoADListener {
//            override fun onADLoaded() {
//                mFullscreenVideoAD.showAD(ActivityUtils.getTopActivity())
//            }
//
//            override fun onVideoCached() {}
//            override fun onADShow() {}
//            override fun onADExposure() {}
//            override fun onADClicked() {}
//            override fun onVideoComplete() {}
//            override fun onADClosed() {}
//            override fun onSuccess() {}
//            override fun onFailed(error: ADError) {
//                Log.e("======", error.toString())
//            }
//            override fun onSkippedVideo() {}
//            override fun onPreload() {}
//        })
//        mFullscreenVideoAD.loadAD()
        result.success(null)
    }
}
