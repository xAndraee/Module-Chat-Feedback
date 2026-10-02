package autismclient.addon.moduletogglefeedback;

import autismclient.api.ApiVersion;
import autismclient.api.AutismAddon;
import autismclient.modules.Module;
import autismclient.modules.ModuleRegistry;
import autismclient.util.AutismConfig;

public final class ModuleToggleFeedbackAddon extends AutismAddon {
    public static final String ID = "autism-module-toggle-feedback";
    public static final String SETTING_ID = "module-toggle-feedback";

    private static final String LEGACY_SETTINGS_ID = ID + ":settings";

    @Override
    public int apiVersion() {
        return ApiVersion.CURRENT;
    }

    @Override
    public void onInitialize() {
        migrateLegacyValues();
    }

    public static boolean shouldSuppress(Module module) {
        if (module == null) return true;
        return Boolean.parseBoolean(module.value(SETTING_ID));
    }

    private static void migrateLegacyValues() {
        AutismConfig config = AutismConfig.getGlobal();
        AutismConfig.ModuleState legacyGlobal = config.modules.get(LEGACY_SETTINGS_ID);
        for (Module module : ModuleRegistry.all()) {
            if (module == null || module.id() == null || module.id().isBlank()) continue;
            if (module.id().startsWith(ID + ":")) continue;
            if (module.settingValue(SETTING_ID) != null) continue;

            String legacyValue = legacyGlobal == null ? null : legacyGlobal.settings.get(module.id());
            if (legacyValue == null) {
                AutismConfig.ModuleState legacyProxy = config.modules.get(ID + ":" + stableId(module.id()));
                legacyValue = legacyProxy == null ? null : legacyProxy.settings.get(SETTING_ID);
            }
            if (legacyValue != null) module.setValue(SETTING_ID, legacyValue);
        }
    }

    private static String stableId(String moduleId) {
        return java.util.Base64.getUrlEncoder().withoutPadding()
            .encodeToString(moduleId.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    @Override
    public String getPackage() {
        return "autismclient.addon.moduletogglefeedback";
    }
}
