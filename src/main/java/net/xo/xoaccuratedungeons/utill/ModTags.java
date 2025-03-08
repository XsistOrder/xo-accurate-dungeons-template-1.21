package net.xo.xoaccuratedungeons.utill;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xo.xoaccuratedungeons.XOAccurateDungeons;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> END_NYLIUM = createTag("end_nylium");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(XOAccurateDungeons.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(XOAccurateDungeons.MOD_ID, name));
        }
    }
}