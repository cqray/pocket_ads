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
}
