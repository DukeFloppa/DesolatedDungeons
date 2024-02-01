package dukefloppa.desolateddungeons.block;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

//use ModBlocks class for adding items
public class ModBlocks {
    public static final Block TEAL_WOOL = registerBlock("teal_wool",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block SALMON_WOOL = registerBlock("salmon_wool",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block ALIEN_DIRT = registerBlock("alien_dirt",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.SLIME)));
    public static final Block SANDSTONE_BRICKS = registerBlock("sandstone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block SANDSTONE_BRICK_STAIRS = registerBlock("sandstone_brick_stairs",
            new StairsBlock(ModBlocks.SANDSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block SANDSTONE_BRICK_SLAB = registerBlock("sandstone_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block SANDSTONE_BRICK_WALL = registerBlock("sandstone_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block LATERITE = registerBlock("laterite",
            new Block(FabricBlockSettings.copyOf(Blocks.CLAY)));
    public static final Block LATERITE_BRICKS = registerBlock("laterite_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block LATERITE_BRICK_STAIRS = registerBlock("laterite_brick_stairs",
            new StairsBlock(ModBlocks.LATERITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block LATERITE_BRICK_SLAB = registerBlock("laterite_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block LATERITE_BRICK_WALL = registerBlock("laterite_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(FabricBlockSettings.copyOf(Blocks.ANDESITE)));
    public static final Block POLISHED_LIMESTONE = registerBlock("polished_limestone",
            new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)));
    public static final Block PERIDOTITE = registerBlock("peridotite",
            new Block(FabricBlockSettings.copyOf(Blocks.ANDESITE)));

    public static void registerModBlocks() {
        DesolatedDungeons.LOGGER.info("Registering Mod Blocks for " + DesolatedDungeons.MOD_ID);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DesolatedDungeons.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DesolatedDungeons.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}