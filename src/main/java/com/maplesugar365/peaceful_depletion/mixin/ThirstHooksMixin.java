package com.maplesugar365.peaceful_depletion.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import toughasnails.thirst.ThirstHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(ThirstHooks.class)
public class ThirstHooksMixin {
    @Redirect(method = "doFoodDataTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private static Difficulty peaceful_depletion_doFoodDataTick_Inject(Level instance) {
        return Difficulty.HARD;
    }
}
