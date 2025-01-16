package com.robertx22.ancient_obelisks.block;

import com.robertx22.library_of_exile.components.PlayerDataCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ObeliskTpBackBlock extends Block {

    public ObeliskTpBackBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN));
    }

    @Override
    public InteractionResult use(BlockState pState, Level world, BlockPos pPos, Player p, InteractionHand pHand, BlockHitResult pHit) {

        if (!world.isClientSide) {
            if (p.isCrouching()) {
                PlayerDataCapability.get(p).mapTeleports.teleportHome(p);
            } else {
                PlayerDataCapability.get(p).mapTeleports.exitTeleportLogic(p);
            }
        }

        return InteractionResult.SUCCESS;
    }

}
