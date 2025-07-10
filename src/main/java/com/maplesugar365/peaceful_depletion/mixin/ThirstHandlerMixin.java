package com.maplesugar365.peaceful_depletion.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import toughasnails.thirst.ThirstHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(ThirstHandler.class)
public class ThirstHandlerMixin {
    @Redirect(method = "onPlayerTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty peaceful_depletion_onPlayerTick_Inject(World instance) {
        return Difficulty.HARD;
    }
}
