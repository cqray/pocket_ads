import 'package:flutter_test/flutter_test.dart';
import 'package:pocket_ads/pocket_ads.dart';
import 'package:pocket_ads/pocket_ads_platform_interface.dart';
import 'package:pocket_ads/pocket_ads_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockPocketAdsPlatform
    with MockPlatformInterfaceMixin
    implements PocketAdsPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final PocketAdsPlatform initialPlatform = PocketAdsPlatform.instance;

  test('$MethodChannelPocketAds is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelPocketAds>());
  });

  test('getPlatformVersion', () async {
    PocketAds pocketAdsPlugin = PocketAds();
    MockPocketAdsPlatform fakePlatform = MockPocketAdsPlatform();
    PocketAdsPlatform.instance = fakePlatform;

    expect(await pocketAdsPlugin.getPlatformVersion(), '42');
  });
}
