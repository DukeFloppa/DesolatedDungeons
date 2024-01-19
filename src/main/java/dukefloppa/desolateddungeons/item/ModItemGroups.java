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
                    .icon(() -> new ItemStack(ModItems.ANKH_TOTEM))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.SCARAB_BEETLE);
                        entries.add(ModItems.ANKH_TOTEM);
                        entries.add(ModItems.KHOPESH_HANDLE);
                        entries.add(ModItems.WOODEN_KHOPESH);
                        entries.add(ModItems.STONE_KHOPESH);
                        entries.add(ModItems.IRON_KHOPESH);
                        entries.add(ModItems.GOLDEN_KHOPESH);
                        entries.add(ModItems.DIAMOND_KHOPESH);
                        entries.add(ModItems.NETHERITE_KHOPESH);

                        entries.add(ModBlocks.TEAL_WOOL);
                        entries.add(ModBlocks.SALMON_WOOL);
                        entries.add(ModBlocks.ALIEN_DIRT);
                        entries.add(ModBlocks.SANDSTONE_BRICKS);
                        entries.add(ModBlocks.SANDSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.SANDSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.SANDSTONE_BRICK_WALL);
                        entries.add(ModBlocks.LATERITE);
                        entries.add(ModBlocks.LATERITE_BRICKS);
                        entries.add(ModBlocks.LATERITE_BRICK_STAIRS);
                        entries.add(ModBlocks.LATERITE_BRICK_SLAB);
                        entries.add(ModBlocks.LATERITE_BRICK_WALL);
                        entries.add(ModBlocks.LIMESTONE);
                        entries.add(ModBlocks.PERIDOTITE);
                    }))
                    .build());

    public static void registerItemGroups() {
        DesolatedDungeons.LOGGER.info("Registering Item Groups for " + DesolatedDungeons.MOD_ID);
    }
}