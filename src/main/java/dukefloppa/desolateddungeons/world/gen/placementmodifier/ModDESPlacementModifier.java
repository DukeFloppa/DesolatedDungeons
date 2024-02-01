package dukefloppa.desolateddungeons.world.gen.placementmodifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.FeaturePlacementContext;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ModDESPlacementModifier extends PlacementModifier {
    private final BlockPredicate targetPredicate;
    private final BlockPredicate allowedSearchPredicate;
    private final int maxTaxicabDistance;
    public static final Codec<ModDESPlacementModifier> MODIFIER_CODEC =
     RecordCodecBuilder.create(instance -> instance.group(
        BlockPredicate.BASE_CODEC.fieldOf("target_condition")
            .forGetter(modDESPlacementModifier -> modDESPlacementModifier.targetPredicate),
        BlockPredicate.BASE_CODEC.optionalFieldOf("allowed_search_condition", BlockPredicate.alwaysTrue())
            .forGetter(modDESPlacementModifier -> modDESPlacementModifier.allowedSearchPredicate),
        Codec.intRange(1, 3).fieldOf("max_taxicab_distance")
            .forGetter(modDESPlacementModifier -> modDESPlacementModifier.maxTaxicabDistance))
     .apply(instance, ModDESPlacementModifier::new));

    private ModDESPlacementModifier(BlockPredicate targetPredicate, BlockPredicate allowedSearchPredicate, int maxTaxicabDistance) {
        this.targetPredicate = targetPredicate;
        this.allowedSearchPredicate = allowedSearchPredicate;
        this.maxTaxicabDistance = maxTaxicabDistance;
    }

    public static ModDESPlacementModifier of(BlockPredicate targetPredicate, BlockPredicate allowedSearchPredicate, int maxTaxicabDistance) {
        return new ModDESPlacementModifier(targetPredicate, allowedSearchPredicate, maxTaxicabDistance);
    }

    public static ModDESPlacementModifier of(BlockPredicate targetPredicate, int maxTaxicabDistance) {
        return ModDESPlacementModifier.of(targetPredicate, BlockPredicate.alwaysTrue(), maxTaxicabDistance);
    }

    @Override
    public Stream<BlockPos> getPositions(FeaturePlacementContext context, Random random, BlockPos pos) {
        BlockPos.Mutable mutable = pos.mutableCopy();
        StructureWorldAccess structureWorldAccess = context.getWorld();

        if (!this.allowedSearchPredicate.test(structureWorldAccess, mutable)) {
            return Stream.of(new BlockPos[0]);
        }

        if (this.targetPredicate.test(structureWorldAccess, mutable)) {
            return Stream.of(mutable);
        }

        List<int[]> listOfPosAndWeight = new ArrayList<>();

        for (int x = -this.maxTaxicabDistance; x <= this.maxTaxicabDistance; x++) {
            for (int y = -this.maxTaxicabDistance; y <= this.maxTaxicabDistance; y++) {
                for (int z = -this.maxTaxicabDistance; z <= this.maxTaxicabDistance; z++) {
                    int weight = Math.abs(x) + Math.abs(y) + Math.abs(z);
                    if (weight <= this.maxTaxicabDistance) {
                        listOfPosAndWeight.add(new int[]{x, y, z, weight});
                    }
                }
            }
        }

        listOfPosAndWeight.sort(Comparator.comparingInt(arr -> arr[3]));

        for (int[] position : listOfPosAndWeight) {
            mutable.move(position[0], position[1], position[2]);

            if (structureWorldAccess.isOutOfHeightLimit(mutable.getY())) {
                mutable.move(-position[0], -position[1], -position[2]);
                continue;
            }

            if (this.targetPredicate.test(structureWorldAccess, mutable)) {
                return Stream.of(mutable);
            }

            if (!this.allowedSearchPredicate.test(structureWorldAccess, mutable)) break;

            mutable.move(-position[0], -position[1], -position[2]);
        }

        return Stream.of(new BlockPos[0]);
    }

    @Override
    public PlacementModifierType<?> getType() {
        return ModPlacementModifierType.MOD_DES;
    }
}
