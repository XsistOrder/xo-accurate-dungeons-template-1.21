package net.xo.xoaccuratedungeons.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.xo.xoaccuratedungeons.XOAccurateDungeons;

public class ModBlocks {
    public static final Block CHISELED_PURPUR_BASALT = registerBlock("chiseled_purpur_basalt",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool().strength(1.25F, 4.2F).sounds(BlockSoundGroup.BASALT)));

    public static final Block ENDSTONE_TILES = registerBlock("endstone_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0F, 9.0F)
                    .requiresTool().instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.STONE)));

    public static final Block GREENSTONE_TILES = registerBlock("greenstone_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(3.0F, 9.0F)
                    .requiresTool().instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.DEEPSLATE_TILES)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(XOAccurateDungeons.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(XOAccurateDungeons.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        XOAccurateDungeons.LOGGER.info("Registering Mod Blocks for " + XOAccurateDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CHISELED_PURPUR_BASALT);

            entries.add(ModBlocks.ENDSTONE_TILES);

            entries.add(ModBlocks.GREENSTONE_TILES);
        });
    }
}