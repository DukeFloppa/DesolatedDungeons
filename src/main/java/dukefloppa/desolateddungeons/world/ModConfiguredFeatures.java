package dukefloppa.desolateddungeons.world;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import dukefloppa.desolateddungeons.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PERIDOTITE = registerKey("ore_peridotite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_LATERITE = registerKey("ore_laterite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_LIMESTONE = registerKey("ore_limestone");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RuleTest baseStoneOverworld = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);

        register(featureRegisterable, ORE_PERIDOTITE, Feature.ORE,
                new OreFeatureConfig(baseStoneOverworld, ModBlocks.PERIDOTITE.getDefaultState(), 64));

        register(featureRegisterable, ORE_LATERITE, Feature.ORE,
                new OreFeatureConfig(baseStoneOverworld, ModBlocks.LATERITE.getDefaultState(), 64));

        register(featureRegisterable, ORE_LIMESTONE, Feature.ORE,
                new OreFeatureConfig(baseStoneOverworld, ModBlocks.LIMESTONE.getDefaultState(), 64));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(DesolatedDungeons.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>>
    void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
