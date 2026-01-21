package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class SungerKirmaMod implements ModInitializer {
    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            // Eskiden isClientSide, şimdi world.isClient() metodunu kullan
            if (!world.isClient() && world.getBlockState(pos).is(Blocks.SPONGE)) {
                world.destroyBlock(pos, true);
            }
            return InteractionResult.PASS;
        });
    }
}
