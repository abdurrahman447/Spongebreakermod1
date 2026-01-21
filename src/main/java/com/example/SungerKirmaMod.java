package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;

public class SungerKirmaMod implements ModInitializer {

    @Override
    public void onInitialize() {
        // AttackBlockCallback event'ini kaydet
        // 5 parametreli versiyon (player, world, hand, pos, direction)
        // Eğer build sırasında "hand" parametresi hatası verirse InteractionHand hand kısmını sil
        AttackBlockCallback.EVENT.register((Player player, Level world, InteractionHand hand, BlockPos pos, Direction direction) -> {

            // Server tarafında olduğumuzdan emin ol
            if (!world.isClientSide()) {

                // Bloğun sünger olup olmadığını kontrol et
                if (world.getBlockState(pos).is(Blocks.SPONGE)) {

                    // Bloğu kır ve eşya düşür (true: particles ve ses çıkarır)
                    world.destroyBlock(pos, true);

                    // Bloğu kırdık, event burada biter
                    return InteractionResult.SUCCESS;
                }
            }

            // Event diğer işlemler için devam etsin
            return InteractionResult.PASS;
        });
    }
}            return InteractionResult.PASS;
        });
    }
}
