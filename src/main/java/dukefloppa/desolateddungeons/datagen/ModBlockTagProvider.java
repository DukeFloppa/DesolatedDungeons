package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SANDSTONE_BRICKS)
                .add(ModBlocks.SANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.SANDSTONE_BRICK_SLAB)
                .add(ModBlocks.SANDSTONE_BRICK_WALL)
                .add(ModBlocks.LATERITE_BRICKS)
                .add(ModBlocks.LATERITE_BRICK_STAIRS)
                .add(ModBlocks.LATERITE_BRICK_SLAB)
                .add(ModBlocks.LATERITE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.LATERITE)
                .add(ModBlocks.ALIEN_DIRT);

        // Needs at least Wooden Level Tool to be mined
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_0")))
                .add(ModBlocks.SANDSTONE_BRICKS)
                .add(ModBlocks.SANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.SANDSTONE_BRICK_SLAB)
                .add(ModBlocks.SANDSTONE_BRICK_WALL)
                .add(ModBlocks.LATERITE_BRICKS)
                .add(ModBlocks.LATERITE_BRICK_STAIRS)
                .add(ModBlocks.LATERITE_BRICK_SLAB)
                .add(ModBlocks.LATERITE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.SANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.LATERITE_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.SANDSTONE_BRICK_SLAB)
                .add(ModBlocks.LATERITE_BRICK_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SANDSTONE_BRICK_WALL)
                .add(ModBlocks.LATERITE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.ALIEN_DIRT);

        getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ModBlocks.TEAL_WOOL)
                .add(ModBlocks.SALMON_WOOL);
    }
}
