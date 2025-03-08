package net.xo.xoaccuratedungeons.world.tree;


import net.minecraft.block.SaplingGenerator;
import net.xo.xoaccuratedungeons.XOAccurateDungeons;
import net.xo.xoaccuratedungeons.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator INVERTED = new SaplingGenerator(XOAccurateDungeons.MOD_ID + ":inverted",
            Optional.empty(), Optional.of(ModConfiguredFeatures.INVERTED_KEY), Optional.empty());
}