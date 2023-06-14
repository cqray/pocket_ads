import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'pocket_ads_platform_interface.dart';

/// An implementation of [PocketAdsPlatform] that uses method channels.
class MethodChannelPocketAds extends PocketAdsPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('pocket_ads');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }

  @override
  Future<String?> test(String s) async {
    final version = await methodChannel.invokeMethod<String>('test', s);
    return version;
  }

  @override
  Future<void> init(String channel, String appId) async {
    var params = {}
      ..putIfAbsent("channel", () => channel)
      ..putIfAbsent("appId", () => appId);
    return await methodChannel.invokeMethod<void>("init", params);
  }

  @override
  Future<void> loadRewardVideoAD() async {
    return await methodChannel.invokeMethod<void>("loadRewardVideoAD");
  }
}
