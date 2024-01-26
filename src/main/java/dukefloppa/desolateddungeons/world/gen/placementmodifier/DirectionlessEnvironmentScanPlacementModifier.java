package dukefloppa.desolateddungeons.world.gen.placementmodifier;

import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.FeaturePlacementContext;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;

import java.util.stream.Stream;

public class DirectionlessEnvironmentScanPlacementModifier extends PlacementModifier {
    private final BlockPredicate targetPredicate;
    private final BlockPredicate allowedSearchPredicate;
    private final int maxSteps;
    //public static final Codec<DirectionlessEnvironmentScanPlacementModifier> MODIFIER_CODEC =
    //public static final Codec<EnvironmentScanPlacementModifier> MODIFIER_CODEC =
    // RecordCodecBuilder.create(instance -> instance.group(
    // ((MapCodec)Direction.VERTICAL_CODEC.fieldOf("direction_of_search"))
    // .forGetter(environmentScanPlacementModifier -> environmentScanPlacementModifier.direction),
    // ((MapCodec)BlockPredicate.BASE_CODEC.fieldOf("target_condition"))
    // .forGetter(environmentScanPlacementModifier -> environmentScanPlacementModifier.targetPredicate),
    // BlockPredicate.BASE_CODEC.optionalFieldOf("allowed_search_condition", BlockPredicate.alwaysTrue())
    // .forGetter(environmentScanPlacementModifier -> environmentScanPlacementModifier.allowedSearchPredicate),
    // ((MapCodec)Codec.intRange(1, 32).fieldOf("max_steps"))
    // .forGetter(environmentScanPlacementModifier -> environmentScanPlacementModifier.maxSteps))
    // .apply((Applicative<EnvironmentScanPlacementModifier, ?>)instance, EnvironmentScanPlacementModifier::new));

    private DirectionlessEnvironmentScanPlacementModifier(BlockPredicate targetPredicate, BlockPredicate allowedSearchPredicate, int maxSteps) {
        this.targetPredicate = targetPredicate;
        this.allowedSearchPredicate = allowedSearchPredicate;
        this.maxSteps = maxSteps;
    }

    public static DirectionlessEnvironmentScanPlacementModifier of(BlockPredicate targetPredicate, BlockPredicate allowedSearchPredicate, int maxSteps) {
        return new DirectionlessEnvironmentScanPlacementModifier(targetPredicate, allowedSearchPredicate, maxSteps);
    }

    public static DirectionlessEnvironmentScanPlacementModifier of(BlockPredicate targetPredicate, int maxSteps) {
        return DirectionlessEnvironmentScanPlacementModifier.of(targetPredicate, BlockPredicate.alwaysTrue(), maxSteps);
    }

    @Override
    public Stream<BlockPos> getPositions(FeaturePlacementContext context, Random random, BlockPos pos) {
        return null;
    }

    @Override
    public PlacementModifierType<?> getType() {
        return null;
    }

    private static <P extends PlacementModifier> PlacementModifierType<P> register(String id, Codec<P> codec) {
        //public static final PlacementModifierType<EnvironmentScanPlacementModifier> ENVIRONMENT_SCAN =
        //register("environment_scan", EnvironmentScanPlacementModifier.MODIFIER_CODEC);
        return Registry.register(Registries.PLACEMENT_MODIFIER_TYPE, id, () -> codec);
    }
}
