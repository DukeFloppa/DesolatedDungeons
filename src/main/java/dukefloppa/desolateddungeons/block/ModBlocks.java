package dukefloppa.desolateddungeons.block;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TEAL_WOOL = registerBlock("teal_wool",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block SALMON_WOOL = registerBlock("salmon_wool",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    public static void registerModBlocks() {
        DesolatedDungeons.LOGGER.info("Registering Mod Blocks for " + DesolatedDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(ModBlocks::addBlocksToColoredBlocksItemGroup);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DesolatedDungeons.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DesolatedDungeons.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void addBlocksToColoredBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(TEAL_WOOL);
        entries.add(SALMON_WOOL);
    }
}
