package com.negative_light.compressedstone.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;

public class StoneworkPathBlock extends DirtPathBlock {
    public StoneworkPathBlock(Properties properties) {
        super(properties);
    }


    @Override
    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.BLOCK;
    }
    public boolean useShapeForLightOcclusion(BlockState p_153159_) {
        return true;
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

            //LOGGER.info("Living Entity on Path");
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        //DO NOTHING WE DON"T WANT TO BECOME DIRT
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return this.defaultBlockState();
    }
}
