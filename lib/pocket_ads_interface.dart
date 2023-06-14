
abstract class PocketAdsInterface {

  /// 初始化
  Future<void> init(String channel, String appId);

  Future<void> loadRewardVideoAD();
}