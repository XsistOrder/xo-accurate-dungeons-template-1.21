package net.xo.xoaccuratedungeons.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_BARRENS,BiomeKeys.END_HIGHLANDS,
                        BiomeKeys.END_MIDLANDS,BiomeKeys.THE_END,BiomeKeys.SMALL_END_ISLANDS), SpawnGroup.MONSTER,
                EntityType.ENDERMITE, 35, 1, 2);
    }
}