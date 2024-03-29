package dukefloppa.desolateddungeons.world;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORE_PERIDOTITE_UPPER = registerKey("ore_peridotite_upper");
    public static final RegistryKey<PlacedFeature> ORE_PERIDOTITE_LOWER = registerKey("ore_peridotite_lower");
    public static final RegistryKey<PlacedFeature> ORE_LATERITE = registerKey("ore_laterite");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        var configuredFeatureRegistryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(featureRegisterable, ORE_PERIDOTITE_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_PERIDOTITE),
                ModOrePlacement.modifiersWithRarity(6, HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(128))));
        register(featureRegisterable, ORE_PERIDOTITE_LOWER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_PERIDOTITE),
                ModOrePlacement.modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60))));
        register(featureRegisterable, ORE_LATERITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_LATERITE),
                List.of(CountPlacementModifier.of(4),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.fixed(192)),
                        BiomePlacementModifier.of(),
                        SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG, -13, -3)));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(DesolatedDungeons.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
