package cn.cqray.plugin.pocket_ads

import cn.cqray.plugin.flutter.PluginMethods
import com.blankj.utilcode.util.ActivityUtils
import com.zh.pocket.PocketSdk
import com.zh.pocket.ads.reward_video.RewardVideoAD
import com.zh.pocket.ads.reward_video.RewardVideoADListener
import com.zh.pocket.error.ADError

@Suppress("Unused")
class PocketAdsMethods : PluginMethods {

    fun init() {
        // 初始化
        PocketSdk.initSDK(_ContextInit.context, "xiaomi", "11723")
    }

    /**
     * 加载激励视频
     */
    fun loadRewardVideoAD() {
        var ad = RewardVideoAD(ActivityUtils.getTopActivity()!!, "").also {
            it.setRewardVideoADListener(object : RewardVideoADListener {
                override fun onFailed(error: ADError?) {}

                override fun onSuccess() {}

                override fun onVideoCached() {}

                override fun onADShow() {}

                override fun onADExposure() {}

                override fun onReward() {}

                override fun onADClicked() {}

                override fun onADClosed() {}

                override fun onVideoComplete() {}

                override fun onSkippedVideo() {}

                override fun onADLoaded() {}

            })
        }
    }
}