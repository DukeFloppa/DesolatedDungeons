package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBlocks.SANDSTONE_BRICK_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBlocks.SANDSTONE_BRICK_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.SANDSTONE_BRICK_WALL.asItem());

        getOrCreateTagBuilder(ItemTags.WOOL)
                .add(ModBlocks.TEAL_WOOL.asItem())
                .add(ModBlocks.SALMON_WOOL.asItem());

        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(ModBlocks.ALIEN_DIRT.asItem());
    }
}
