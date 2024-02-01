package dukefloppa.desolateddungeons.world.gen.placementmodifier;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;

public class ModPlacementModifierType {
    public static final PlacementModifierType<ModDESPlacementModifier> MOD_DES =
            Registry.register(Registries.PLACEMENT_MODIFIER_TYPE, new Identifier(DesolatedDungeons.MOD_ID, "mod_des"), () -> ModDESPlacementModifier.MODIFIER_CODEC);

    public static void initializeModPlacementModifiers() {
        DesolatedDungeons.LOGGER.info("Registering Mod Placement Modifiers for " + DesolatedDungeons.MOD_ID);
    }
}
