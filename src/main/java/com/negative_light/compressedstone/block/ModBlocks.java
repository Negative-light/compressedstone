package com.negative_light.compressedstone.block;

import com.negative_light.compressedstone.Compressedstone;
import com.negative_light.compressedstone.block.custom.StoneworkBlock;
import com.negative_light.compressedstone.block.custom.StoneworkPathBlock;
import com.negative_light.compressedstone.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Compressedstone.MOD_ID);

    //*******************DECLARE BLOCK CONSTANTS
    private  static  final float STONEWORK_STRENGTH = 3.5f;
    private  static  final float REINFORCED_BLAST_RESIST = 7f;
    private  static  final int INFUSED_LIGHT_LEVEL = 7;
    private  static final float PATH_SPEED_FACTOR = 1.33f;

    //*******************DECLARE BLOCKS HERE


    //***STONEWORK PATH
    public static final RegistryObject<Block> STONEWORK_PATH = resisterBlock("stonework_path",
            () -> new StoneworkPathBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .requiresCorrectToolForDrops().strength(STONEWORK_STRENGTH).speedFactor(PATH_SPEED_FACTOR)));

    //***REINFORCED STONEWORK PATH
    public static final RegistryObject<Block> REINFORCED_STONEWORK_PATH = resisterBlock("reinforced_stonework_path",
            () -> new StoneworkPathBlock(BlockBehaviour.Properties.of(Material.AMETHYST).requiresCorrectToolForDrops()
                    .strength(STONEWORK_STRENGTH, REINFORCED_BLAST_RESIST).speedFactor(PATH_SPEED_FACTOR)));

    //***INFUSED STONEWORK PATH
    public static final RegistryObject<Block> INFUSED_STONEWORK_PATH = resisterBlock("infused_stonework_path",
            () -> new StoneworkPathBlock(BlockBehaviour.Properties.of(Material.AMETHYST).requiresCorrectToolForDrops()
                    .strength(STONEWORK_STRENGTH).lightLevel((p_50872_) -> INFUSED_LIGHT_LEVEL).speedFactor(PATH_SPEED_FACTOR)));

    //***STONEWORK BLOCK
    public static final RegistryObject<Block> STONEWORK_BLOCK = resisterBlock("stonework_block",
            () -> new StoneworkBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(STONEWORK_STRENGTH), false, STONEWORK_PATH));

    //***REINFORCED STONEWORK BLOCK
    public static final RegistryObject<Block> REINFORCED_STONEWORK_BLOCK = resisterBlock("reinforced_stonework_block",
            () -> new StoneworkBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(STONEWORK_STRENGTH, REINFORCED_BLAST_RESIST).requiresCorrectToolForDrops(), false, REINFORCED_STONEWORK_PATH));


    //***STONEWORK BLOCK
    public static final RegistryObject<Block> INFUSED_STONEWORK_BLOCK = resisterBlock("infused_stonework_block",
            () -> new StoneworkBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .requiresCorrectToolForDrops().strength(STONEWORK_STRENGTH).lightLevel((p_50872_) -> INFUSED_LIGHT_LEVEL), true, INFUSED_STONEWORK_PATH));

    //*******************HELPER FUNCTIONS
    private static <T extends Block> RegistryObject<T> resisterBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(),
                        new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));


    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
