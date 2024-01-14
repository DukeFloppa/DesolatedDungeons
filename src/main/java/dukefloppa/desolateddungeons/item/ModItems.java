package dukefloppa.desolateddungeons.item;

import dukefloppa.desolateddungeons.DesolatedDungeons;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SCARAB_BEETLE = registerItem("scarab_beetle", new Item(new FabricItemSettings()));

    public static void registerModItems() {
        DesolatedDungeons.LOGGER.info("Registering Mod Items for " + DesolatedDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DesolatedDungeons.MOD_ID, name), item);
    }

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }
}
