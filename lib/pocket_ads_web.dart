import 'dart:html' as html show window;

import 'package:flutter_web_plugins/flutter_web_plugins.dart';

import 'pocket_ads_platform_interface.dart';

/// A web implementation of the PocketAdsPlatform of the PocketAds plugin.
class PocketAdsWeb extends PocketAdsPlatform {
  /// Constructs a PocketAdsWeb
  PocketAdsWeb();

  static void registerWith(Registrar registrar) {
    PocketAdsPlatform.instance = PocketAdsWeb();
  }

  /// Returns a [String] containing the version of the platform.
  @override
  Future<String?> getPlatformVersion() async {
    final version = html.window.navigator.userAgent;
    return version;
  }

  @override
  Future<void> init(String channel, String appId) {
    // TODO: implement init
    throw UnimplementedError();
  }

  @override
  Future<void> loadRewardVideoAD() {
    // TODO: implement loadRewardVideoAD
    throw UnimplementedError();
  }
}
