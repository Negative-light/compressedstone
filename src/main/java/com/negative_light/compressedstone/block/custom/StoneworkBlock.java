package com.negative_light.compressedstone.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;

import java.util.logging.Logger;

public class StoneworkBlock extends Block {

    private boolean isPushable;
    private RegistryObject<Block> pathType;
    public StoneworkBlock(Properties p_49795_, boolean pushable, RegistryObject<Block> pathType)
    {
        super(p_49795_);
        isPushable = pushable;
        this.pathType = pathType;

    }


    @Override
    public PushReaction getPistonPushReaction(BlockState pState)
    {
        if(isPushable)
        {
            return  PushReaction.NORMAL;
        }
        return PushReaction.BLOCK;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            if(pHand == InteractionHand.OFF_HAND)
            {

                Item playerItem = pPlayer.getMainHandItem().getItem();
                if(playerItem instanceof PickaxeItem)
                    pLevel.setBlockAndUpdate(pPos, pushEntitiesUp(pState, pathType.get().defaultBlockState(), pLevel, pPos));
                LOGGER.warn("PLAYER INTERACTION");
            }


        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
