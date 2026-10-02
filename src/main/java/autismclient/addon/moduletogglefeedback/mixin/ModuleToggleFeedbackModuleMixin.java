package autismclient.addon.moduletogglefeedback.mixin;

import autismclient.addon.moduletogglefeedback.ModuleToggleFeedbackAddon;
import autismclient.api.module.BoolSetting;
import autismclient.api.module.Setting;
import autismclient.modules.Module;
import autismclient.modules.ModuleCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Module.class)
public abstract class ModuleToggleFeedbackModuleMixin {
    @Shadow @Final
    private List<Setting<?, ?>> settings;

    @Inject(method = "<init>(Ljava/lang/String;Ljava/lang/String;Lautismclient/modules/ModuleCategory;Ljava/lang/String;)V", at = @At("TAIL"))
    private void moduleToggleFeedback$addSetting(
            String id, String name, ModuleCategory category, String description, CallbackInfo ci) {
        if (id == null || id.startsWith(ModuleToggleFeedbackAddon.ID + ":")) return;
        for (Setting<?, ?> setting : settings) {
            if (ModuleToggleFeedbackAddon.SETTING_ID.equals(setting.id())) return;
        }
        Module module = (Module) (Object) this;
        BoolSetting feedback = new BoolSetting(
            ModuleToggleFeedbackAddon.SETTING_ID, "Module Toggle Feedback", true)
            .description("Suppresses enable and disable chat feedback for this module.");
        feedback.attach(module);
        settings.add(feedback);
    }
}