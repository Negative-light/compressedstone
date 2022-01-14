package com.negative_light.compressedstone.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

import static net.minecraft.world.effect.MobEffects.*;

public class StoneworkPathBlock extends DirtPathBlock {
    public StoneworkPathBlock(Properties properties) {
        super(properties);
    }


    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.BLOCK;
    }
    public boolean useShapeForLightOcclusion(BlockState p_153159_) {
        return true;
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

            if (!pLevel.isClientSide) {
                if(pEntity instanceof LivingEntity){
                    LivingEntity entity = ((LivingEntity) pEntity);
                    /*entity.addEffect(new MobEffectInstance(MOVEMENT_SPEED,
                            1,
                            2,false,false));*/
                }
                //LOGGER.info("PLAYER ON PATH");

            }
            //LOGGER.info("Living Entity on Path");
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void tick(BlockState p_153133_, ServerLevel p_153134_, BlockPos p_153135_, Random p_153136_) {
        //DO NOTHING WE DON"T WANT TO BECOME DIRT

    }

    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return this.defaultBlockState();
    }
}
