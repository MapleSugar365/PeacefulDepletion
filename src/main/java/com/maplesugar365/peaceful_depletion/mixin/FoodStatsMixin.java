package com.maplesugar365.peaceful_depletion.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.util.FoodStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = FoodStats.class, priority = 1010)
public class FoodStatsMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty peaceful_depletion_tick_Inject(World instance) {
        return Difficulty.HARD;
    }
}