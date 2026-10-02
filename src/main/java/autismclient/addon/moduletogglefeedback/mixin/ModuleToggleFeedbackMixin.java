package autismclient.addon.moduletogglefeedback.mixin;

import autismclient.addon.moduletogglefeedback.ModuleToggleFeedbackAddon;
import autismclient.modules.Module;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Module.class)
public abstract class ModuleToggleFeedbackMixin {
    @Inject(
        method = "setEnabled(Z)V",
        at = @At(
            value = "INVOKE",
            target = "Lautismclient/util/AutismClientMessaging;sendPrefixed(Ljava/lang/String;)V"),
        cancellable = true)
    private void moduleToggleFeedback$suppress(boolean enabled, CallbackInfo ci) {
        if (ModuleToggleFeedbackAddon.shouldSuppress((Module) (Object) this)) ci.cancel();
    }
}
