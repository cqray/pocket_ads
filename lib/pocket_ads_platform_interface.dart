import 'package:plugin_platform_interface/plugin_platform_interface.dart';
import 'package:pocket_ads/pocket_ads_interface.dart';

import 'pocket_ads_method_channel.dart';

abstract class PocketAdsPlatform extends PlatformInterface implements PocketAdsInterface {
  /// Constructs a PocketAdsPlatform.
  PocketAdsPlatform() : super(token: _token);

  static final Object _token = Object();

  static PocketAdsPlatform _instance = MethodChannelPocketAds();

  /// The default instance of [PocketAdsPlatform] to use.
  ///
  /// Defaults to [MethodChannelPocketAds].
  static PocketAdsPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [PocketAdsPlatform] when
  /// they register themselves.
  static set instance(PocketAdsPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  Future<String?> test(String s) {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
