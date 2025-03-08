package net.xo.xoaccuratedungeons.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.xo.xoaccuratedungeons.XOAccurateDungeons;
import net.xo.xoaccuratedungeons.block.custom.*;
import net.xo.xoaccuratedungeons.world.tree.ModSaplingGenerators;

public class ModBlocks {

    public static final Block CHISELED_PURPUR_BASALT = registerBlock("chiseled_purpur_basalt",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLUE)
                    .requiresTool().strength(1.25F, 4.2F).sounds(BlockSoundGroup.BASALT)));

    public static final Block ENDSTONE_TILES = registerBlock("endstone_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0F, 9.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block ENDSTONE_PILLAR = registerBlock("endstone_pillar",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0F, 9.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block CHISELED_ENDSTONE = registerBlock("chiseled_endstone",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0F, 9.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block CHISELED_ENDSTONE_BRICKS = registerBlock("chiseled_endstone_bricks",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0F, 9.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block ENDSTONE = registerBlock("endstone",
            new EndstoneBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0F, 9.0F)
                    .requiresTool().instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.STONE)));

    public static final Block END_ROD_BLOCK = registerBlock("end_rod_block",
            new Block(AbstractBlock.Settings.create().luminance(state -> 14).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block END_ROD_PILLAR = registerBlock("end_rod_pillar",
            new PillarBlock(AbstractBlock.Settings.create().luminance(state -> 14).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    public static final Block PURPUR_HALF_TILES = registerBlock("purpur_half_tiles",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PURPUR_CHECKERED_TILES = registerBlock("purpur_checkered_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PURPUR_HALF_CHECKERED_TILES = registerBlock("purpur_half_checkered_tiles",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block HOWLITE = registerBlock("howlite",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block POINTED_HOWLITE = registerBlock("pointed_howlite",
            new PointedDripstoneBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never).dynamicBounds().ticksRandomly().solid().nonOpaque()));

    public static final Block END_DIRT = registerBlock("end_dirt",
            new EndDirtBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLUE).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.GRAVEL)));

    public static final Block CHORUS_STEM_BLOCK = registerBlock("chorus_stem_block",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? MapColor.PURPLE : MapColor.LIGHT_BLUE)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block INVERTED_LEAVES = registerBlock("inverted_leaves",
            new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));
    public static final Block INVERTED_SAPLING = registerBlock("inverted_sapling",
            new ModSaplingBlock(
                    ModSaplingGenerators.INVERTED, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), ModBlocks.INVERTED_ENDSTONE_GRASS_BLOCK));
    public static final Block INVERTED_ENDDIRT_GRASS_BLOCK = registerBlock("inverted_enddirt_grass_block",
            new EndNyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(0.4F).ticksRandomly().sounds(BlockSoundGroup.WOOD)));
    public static final Block INVERTED_ENDROCK_GRASS_BLOCK = registerBlock("inverted_endrock_grass_block",
            new EndNyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(0.4F).ticksRandomly().sounds(BlockSoundGroup.WOOD)));
    public static final Block INVERTED_ENDSTONE_GRASS_BLOCK = registerBlock("inverted_endstone_grass_block",
            new EndNyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(0.4F).ticksRandomly().sounds(BlockSoundGroup.WOOD)));

    public static final Block CHORUS_LEAVES = registerBlock("chorus_leaves",
            new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE)
                    .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));
    public static final Block CHORUS_SAPLING = registerBlock("chorus_sapling",
            new ModSaplingBlock(
                    ModSaplingGenerators.INVERTED, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.OFF_WHITE), ModBlocks.CHORUS_ENDDIRT_GRASS_BLOCK));
    public static final Block CHORUS_ENDDIRT_GRASS_BLOCK = registerBlock("chorus_enddirt_grass_block",
            new EndNyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA)
                    .strength(0.4F).ticksRandomly().sounds(BlockSoundGroup.WOOD)));
    public static final Block CHORUS_ENDROCK_GRASS_BLOCK = registerBlock("chorus_endrock_grass_block",
            new EndNyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA)
                    .strength(0.4F).ticksRandomly().sounds(BlockSoundGroup.WOOD)));
    public static final Block CHORUS_ENDSTONE_GRASS_BLOCK = registerBlock("chorus_endstone_grass_block",
            new EndNyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA)
                    .strength(0.4F).ticksRandomly().sounds(BlockSoundGroup.WOOD)));

    public static final Block ENDROCK = registerBlock("endrock",
            new EndRockBlock(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ENDROCK_HALF_TILES = registerBlock("endrock_half_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ENDROCK_TILES = registerBlock("endrock_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ENDROCK_CHECKERED_TILES = registerBlock("endrock_checkered_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ENDROCK_HALF_CHECKERED_TILES = registerBlock("endrock_half_checkered_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ENDROCK_PILLAR = registerBlock("endrock_pillar",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));

    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block STONE_TILES = registerBlock("stone_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_STONE = registerBlock("polished_stone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_STONE_STAIRS = registerBlock("polished_stone_stairs",
            new StairsBlock(ModBlocks.POLISHED_STONE.getDefaultState(), AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY).requiresTool().strength(1.5F, 6.0F)
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_STONE_SLAB = registerBlock("polished_stone_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block DARK_STONE_PILLAR = registerBlock("dark_stone_pillar",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block DARK_STONE_TILES = registerBlock("dark_stone_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block DARK_STONE_TILES_SLAB = registerBlock("dark_stone_tiles_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block CHISELED_DARK_STONE = registerBlock("chiseled_dark_stone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CAGE_BLOCK = registerBlock("cage_block",
            new TransparentBlock(AbstractBlock.Settings.create().requiresTool().strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never)
                    .suffocates(Blocks::never).blockVision(Blocks::never)));

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
            entries.add(ModBlocks.ENDSTONE_PILLAR);
            entries.add(ModBlocks.CHISELED_ENDSTONE);
            entries.add(ModBlocks.CHISELED_ENDSTONE_BRICKS);

            entries.add(ModBlocks.PURPUR_HALF_TILES);
            entries.add(ModBlocks.PURPUR_CHECKERED_TILES);
            entries.add(ModBlocks.PURPUR_HALF_CHECKERED_TILES);

            entries.add(ModBlocks.HOWLITE);
            entries.add(ModBlocks.POINTED_HOWLITE);

            entries.add(ModBlocks.ENDROCK_HALF_TILES);
            entries.add(ModBlocks.ENDROCK_TILES);
            entries.add(ModBlocks.ENDROCK_CHECKERED_TILES);
            entries.add(ModBlocks.ENDROCK_HALF_CHECKERED_TILES);
            entries.add(ModBlocks.ENDROCK_PILLAR);

            entries.add(ModBlocks.STONE_PILLAR);
            entries.add(ModBlocks.STONE_TILES);
            entries.add(ModBlocks.POLISHED_STONE);
            entries.add(ModBlocks.POLISHED_STONE_STAIRS);
            entries.add(ModBlocks.POLISHED_STONE_SLAB);

            entries.add(ModBlocks.DARK_STONE_PILLAR);
            entries.add(ModBlocks.DARK_STONE_TILES);
            entries.add(ModBlocks.DARK_STONE_TILES_SLAB);
            entries.add(ModBlocks.CHISELED_DARK_STONE);

            entries.add(ModBlocks.CAGE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {

            entries.add(ModBlocks.HOWLITE);
            entries.add(ModBlocks.POINTED_HOWLITE);

            entries.add(ModBlocks.END_DIRT);

            entries.add(ModBlocks.CHORUS_STEM_BLOCK);

            entries.add(ModBlocks.INVERTED_LEAVES);
            entries.add(ModBlocks.INVERTED_SAPLING);
            entries.add(ModBlocks.INVERTED_ENDDIRT_GRASS_BLOCK);
            entries.add(ModBlocks.INVERTED_ENDROCK_GRASS_BLOCK);
            entries.add(ModBlocks.INVERTED_ENDSTONE_GRASS_BLOCK);

            entries.add(ModBlocks.CHORUS_LEAVES);
            entries.add(ModBlocks.CHORUS_SAPLING);
            entries.add(ModBlocks.CHORUS_ENDDIRT_GRASS_BLOCK);
            entries.add(ModBlocks.CHORUS_ENDROCK_GRASS_BLOCK);
            entries.add(ModBlocks.CHORUS_ENDSTONE_GRASS_BLOCK);

            entries.add(ModBlocks.ENDROCK);

        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {

            entries.add(ModBlocks.END_ROD_BLOCK);
            entries.add(ModBlocks.END_ROD_PILLAR);

        });
    }
}