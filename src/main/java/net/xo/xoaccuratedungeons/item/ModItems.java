package net.xo.xoaccuratedungeons.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xo.xoaccuratedungeons.XOAccurateDungeons;

public class ModItems {
    public static final Item LICHEN_GOO = registerItem("lichen_goo", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(XOAccurateDungeons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        XOAccurateDungeons.LOGGER.info("Registering Mod Items for " + XOAccurateDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LICHEN_GOO);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
        });
    }
}