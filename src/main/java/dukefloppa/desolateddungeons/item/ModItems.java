package dukefloppa.desolateddungeons.item;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SCARAB_BEETLE = registerItem("scarab_beetle", new Item(new FabricItemSettings()));
    public static final Item ANKH_TOTEM = registerItem("ankh_totem", new Item(new FabricItemSettings()));
    public static final Item KHOPESH_HANDLE = registerItem("khopesh_handle", new Item(new FabricItemSettings()));
    public static final Item WOODEN_KHOPESH = registerItem("wooden_khopesh",
            new SwordItem(ToolMaterials.WOOD, 4, -2.6f, new FabricItemSettings()));
    public static final Item STONE_KHOPESH = registerItem("stone_khopesh",
            new SwordItem(ToolMaterials.STONE, 5, -2.8f, new FabricItemSettings()));
    public static final Item IRON_KHOPESH = registerItem("iron_khopesh",
            new SwordItem(ToolMaterials.IRON, 4, -2.5f, new FabricItemSettings()));
    public static final Item GOLDEN_KHOPESH = registerItem("golden_khopesh",
            new SwordItem(ToolMaterials.GOLD, 5, -2.7f, new FabricItemSettings()));
    public static final Item DIAMOND_KHOPESH = registerItem("diamond_khopesh",
            new SwordItem(ToolMaterials.DIAMOND, 4, -2.5f, new FabricItemSettings()));
    public static final Item NETHERITE_KHOPESH = registerItem("netherite_khopesh",
            new SwordItem(ToolMaterials.NETHERITE, 4, -2.5f, new FabricItemSettings()));


    public static void registerModItems() {
        DesolatedDungeons.LOGGER.info("Registering Mod Items for " + DesolatedDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DesolatedDungeons.MOD_ID, name), item);
    }

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(WOODEN_KHOPESH);
        entries.add(STONE_KHOPESH);
        entries.add(IRON_KHOPESH);
        entries.add(GOLDEN_KHOPESH);
        entries.add(DIAMOND_KHOPESH);
        entries.add(NETHERITE_KHOPESH);
    }
}
