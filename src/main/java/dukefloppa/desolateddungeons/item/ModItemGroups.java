package dukefloppa.desolateddungeons.item;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import dukefloppa.desolateddungeons.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DESOLATED_DUNGEONS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DesolatedDungeons.MOD_ID, "desolated_dungeons"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.desolated_dungeons"))
                    .icon(() -> new ItemStack(ModItems.SCARAB_BEETLE))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.SCARAB_BEETLE);

                        entries.add(ModBlocks.TEAL_WOOL);
                        entries.add(ModBlocks.SALMON_WOOL);
                        entries.add(ModBlocks.ALIEN_DIRT);
                    }))
                    .build());

    public static void registerItemGroups() {
        DesolatedDungeons.LOGGER.info("Registering Item Groups for " + DesolatedDungeons.MOD_ID);
    }
}
