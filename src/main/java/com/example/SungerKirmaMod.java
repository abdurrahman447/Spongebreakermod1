package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register((Player player, Level world, InteractionHand hand, BlockPos pos, Direction direction) -> {
            // Server tarafında mı diye kontrol: Level parametresi üzerinden isClientSide değil
            if (!world.isClientSide()) { // 1.21.4 için Loom mappings: Level.isClientSide() mevcut ve public
                if (world.getBlockState(pos).is(Blocks.SPONGE)) {
                    world.destroyBlock(pos, true);
                }
            }
            return InteractionResult.PASS;
        });
    }
}
