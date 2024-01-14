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

    // Doesn't generate an item model for blocks, for now manually add those
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEAL_WOOL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALMON_WOOL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALIEN_DIRT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SCARAB_BEETLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANKH_TOTEM, Models.GENERATED);
    }
}
