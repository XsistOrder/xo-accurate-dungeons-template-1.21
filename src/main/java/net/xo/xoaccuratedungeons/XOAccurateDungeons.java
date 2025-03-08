package net.xo.xoaccuratedungeons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.xo.xoaccuratedungeons.block.ModBlocks;
import net.xo.xoaccuratedungeons.item.ModItems;
import net.xo.xoaccuratedungeons.world.gen.ModWorldGeneration;
import net.xo.xoaccuratedungeons.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XOAccurateDungeons implements ModInitializer {
	public static final String MOD_ID = "xo-accurate-dungeons";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		ModTrunkPlacerTypes.register();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_STEM_BLOCK, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.INVERTED_LEAVES, 30, 60);
	}
}