package dukefloppa.desolateddungeons;

import dukefloppa.desolateddungeons.datagen.ModAdvancementProvider;
import dukefloppa.desolateddungeons.datagen.ModBlockLootTableProvider;
import dukefloppa.desolateddungeons.datagen.ModModelProvider;
import dukefloppa.desolateddungeons.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DesolatedDungeonsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
	}
}
