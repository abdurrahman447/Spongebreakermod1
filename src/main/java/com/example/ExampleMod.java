package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.util.ActionResult;

public class SungerKirmaMod implements ModInitializer {
    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!world.isClient && world.getBlockState(pos).getBlock() == Blocks.SPONGE) {
                world.breakBlock(pos, true);
            }
            return ActionResult.PASS;
        });
    }
}
