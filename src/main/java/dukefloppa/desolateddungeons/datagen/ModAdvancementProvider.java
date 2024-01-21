package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import dukefloppa.desolateddungeons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.ANKH_TOTEM,
                        Text.translatable("advancements.desolated_dungeons.root.title"),
                        Text.translatable("advancements.desolated_dungeons.root.description"),
                        new Identifier("textures/block/sand.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("root", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .build(consumer, DesolatedDungeons.MOD_ID + "/root");

        AdvancementEntry sandsweptRuinsAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.SCARAB_BEETLE,
                        Text.translatable("advancements.desolated_dungeons.sandswept_ruins.title"),
                        Text.translatable("advancements.desolated_dungeons.sandswept_ruins.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("found_sandswept_ruins", TickCriterion.Conditions
                        .createLocation(new LocationPredicate.Builder().structure(RegistryKey.of(RegistryKeys.STRUCTURE, new Identifier("desolated_dungeons:sandswept_ruins")))))
                .build(consumer, DesolatedDungeons.MOD_ID + "/sandswept_ruins");
    }
}
