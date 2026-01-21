package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((Player player, Level world, net.minecraft.world.InteractionHand hand, BlockPos pos, net.minecraft.core.Direction direction) -> {
            // Client-side kontrol artık player üzerinden
            if (!player.level.isClientSide && world.getBlockState(pos).is(Blocks.SPONGE)) {
                world.destroyBlock(pos, true);
            }
            return InteractionResult.PASS;
        });
    }
}
