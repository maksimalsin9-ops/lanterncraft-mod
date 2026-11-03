package ru.college.lanterncraft;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block CHINESE_LANTERN = registerBlock("chinese_lantern",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .luminance(state -> 15)
                    .nonOpaque()
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LanternCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LanternCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(CHINESE_LANTERN);
        });
    }
}