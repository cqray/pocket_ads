
import 'package:pocket_ads/pocket_ads_interface.dart';

import 'pocket_ads_platform_interface.dart';

class PocketAds implements PocketAdsInterface {
  Future<String?> getPlatformVersion() {
    return PocketAdsPlatform.instance.getPlatformVersion();
  }

  Future<String?> test(String s) {
    return PocketAdsPlatform.instance.test(s);
  }

  @override
  Future<void> init(String channel, String appId) {
    return PocketAdsPlatform.instance.init(channel, appId);
  }

  @override
  Future<void> loadRewardVideoAD() {
    return PocketAdsPlatform.instance.loadRewardVideoAD();
  }
}
