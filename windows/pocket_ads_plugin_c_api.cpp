#include "include/pocket_ads/pocket_ads_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "pocket_ads_plugin.h"

void PocketAdsPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  pocket_ads::PocketAdsPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
