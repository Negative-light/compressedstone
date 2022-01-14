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

    //*******************DECLARE BLOCKS HERE
    public static final RegistryObject<Block> STONEWORK_PATH = resisterBlock("stonework_path",
            () -> new StoneworkPathBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .requiresCorrectToolForDrops().strength(3.5f).speedFactor(1.1f)));

    public static final RegistryObject<Block> REINFORCED_STONEWORK_PATH = resisterBlock("reinforced_stonework_path",
            () -> new StoneworkPathBlock(BlockBehaviour.Properties.of(Material.AMETHYST).requiresCorrectToolForDrops()
                    .strength(3.5f, 7f).speedFactor(1.5f).speedFactor(1.1f)));

    public static final RegistryObject<Block> INFUSED_STONEWORK_PATH = resisterBlock("infused_stonework_path",
            () -> new StoneworkPathBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .requiresCorrectToolForDrops()
                    .strength(3.5f).lightLevel((p_50872_) -> { return 15; }).speedFactor(1.5f)));

    public static final RegistryObject<Block> STONEWORK_BLOCK = resisterBlock("stonework_block",
            () -> new StoneworkBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(3.5f).requiresCorrectToolForDrops(), false, STONEWORK_PATH));
    public static final RegistryObject<Block> REINFORCED_STONEWORK_BLOCK = resisterBlock("reinforced_stonework_block",
            () -> new StoneworkBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(3.5f, 7).requiresCorrectToolForDrops(), false, REINFORCED_STONEWORK_PATH));



    public static final RegistryObject<Block> INFUSED_STONEWORK_BLOCK = resisterBlock("infused_stonework_block",
            () -> new StoneworkBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .requiresCorrectToolForDrops().strength(3.5f).lightLevel((p_50872_) -> { return 15; }), true, INFUSED_STONEWORK_PATH));

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
