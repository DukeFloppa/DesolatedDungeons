package dukefloppa.desolateddungeons.datagen;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import dukefloppa.desolateddungeons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureKeys;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.SCARAB_BEETLE, // The display icon
                        Text.literal("Sandswept Ruins"), // The title
                        Text.literal("Discover secrets from ancient times"), // The description
                        new Identifier("textures/block/sand.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("found_sandswept_ruins", TickCriterion.Conditions.createLocation(new LocationPredicate.Builder().structure(StructureKeys.DESERT_PYRAMID)))
                .build(consumer, DesolatedDungeons.MOD_ID + "/root");
    }
}
