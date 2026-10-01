package autismclient.addon.moduletogglefeedback;

import autismclient.api.ApiVersion;
import autismclient.api.AutismAddon;
import autismclient.api.AutismAddons;
import autismclient.util.AutismConfig;

public final class ModuleToggleFeedbackAddon extends AutismAddon {
    public static final String ID = "autism-module-toggle-feedback";

    private static ToggleFeedbackSettings settings;

    @Override
    public int apiVersion() {
        return ApiVersion.CURRENT;
    }

    @Override
    public void onInitialize() {
        settings = new ToggleFeedbackSettings();
        AutismConfig.ModuleState previousState = AutismConfig.getGlobal().modules.get(settings.id());
        AutismAddons.modules().register(settings);
        if (previousState == null) {
            settings.setEnabled(true);
        } else if (previousState.settings.containsKey("module-toggle-feedback")) {
            settings.setEnabled(Boolean.parseBoolean(previousState.settings.get("module-toggle-feedback")));
        }
    }

    public static boolean isFeedbackEnabled() {
        return settings == null || settings.isFeedbackEnabled();
    }

    @Override
    public String getPackage() {
        return "autismclient.addon.moduletogglefeedback";
    }
}
