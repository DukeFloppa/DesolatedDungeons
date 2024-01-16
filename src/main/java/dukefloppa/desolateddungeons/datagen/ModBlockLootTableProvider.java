package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TEAL_WOOL);
        addDrop(ModBlocks.SALMON_WOOL);
        addDrop(ModBlocks.ALIEN_DIRT);
        addDrop(ModBlocks.SANDSTONE_BRICKS);
        addDrop(ModBlocks.SANDSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.SANDSTONE_BRICK_SLAB);
        addDrop(ModBlocks.SANDSTONE_BRICK_WALL);
    }
}
