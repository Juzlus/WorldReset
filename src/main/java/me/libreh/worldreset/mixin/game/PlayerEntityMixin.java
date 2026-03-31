package me.libreh.worldreset.mixin.game;

import me.libreh.worldreset.WorldReset;
import me.libreh.worldreset.config.ConfigManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class PlayerEntityMixin {
    @Inject(method = "die", at = @At("TAIL"))
    private void onPlayerDie(DamageSource damageSource, CallbackInfo ci) {
        if (ConfigManager.config().resetOnPlayerDeath)
            WorldReset.getWorldManager().startPlayerDeathReset(5);
    }
}
