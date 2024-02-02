package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.block.ModBlocks;
import dukefloppa.desolateddungeons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEAL_WOOL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALMON_WOOL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALIEN_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LATERITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIMESTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PERIDOTITE);
        BlockStateModelGenerator.BlockTexturePool sandstoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SANDSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool lateriteBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LATERITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polishedLimestonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_LIMESTONE);

        sandstoneBricksPool.stairs(ModBlocks.SANDSTONE_BRICK_STAIRS);
        sandstoneBricksPool.slab(ModBlocks.SANDSTONE_BRICK_SLAB);
        sandstoneBricksPool.wall(ModBlocks.SANDSTONE_BRICK_WALL);
        lateriteBricksPool.stairs(ModBlocks.LATERITE_BRICK_STAIRS);
        lateriteBricksPool.slab(ModBlocks.LATERITE_BRICK_SLAB);
        lateriteBricksPool.wall(ModBlocks.LATERITE_BRICK_WALL);
        polishedLimestonePool.stairs(ModBlocks.POLISHED_LIMESTONE_STAIRS);
        polishedLimestonePool.slab(ModBlocks.POLISHED_LIMESTONE_SLAB);
        polishedLimestonePool.wall(ModBlocks.POLISHED_LIMESTONE_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SCARAB_BEETLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANKH_TOTEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.KHOPESH_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_KHOPESH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_KHOPESH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_KHOPESH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_KHOPESH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_KHOPESH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_KHOPESH, Models.HANDHELD);
    }
}
