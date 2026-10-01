package autismclient.addon.moduletogglefeedback;

import autismclient.modules.Module;

public final class ToggleFeedbackSettings extends Module {
    public ToggleFeedbackSettings() {
        super(ModuleToggleFeedbackAddon.ID + ":settings", "Module Toggle Feedback",
            "Controls chat feedback when modules are enabled or disabled.");
    }

    public boolean isFeedbackEnabled() {
        return isEnabled();
    }

    @Override
    public boolean showInArrayList() {
        return false;
    }
}
