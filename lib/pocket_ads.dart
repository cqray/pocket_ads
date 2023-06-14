
import 'pocket_ads_platform_interface.dart';

class PocketAds {
  Future<String?> getPlatformVersion() {
    return PocketAdsPlatform.instance.getPlatformVersion();
  }
}
