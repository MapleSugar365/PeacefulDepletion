package com.maplesugar365.peaceful_depletion.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import toughasnails.thirst.ThirstHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(ThirstHandler.class)
public class ThirstHandlerMixin {
    @Redirect(method = "onPlayerTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private static Difficulty peaceful_depletion_onPlayerTick_Inject(Level instance) {
        return Difficulty.HARD;
    }
}
