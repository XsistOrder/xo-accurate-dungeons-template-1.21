package net.xo.xoaccuratedungeons.world.tree;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.xo.xoaccuratedungeons.XOAccurateDungeons;
import net.xo.xoaccuratedungeons.mixin.TrunkPlacerTypeInvoker;
import net.xo.xoaccuratedungeons.world.tree.custom.InvertedTrunkPlacer;

public class ModTrunkPlacerTypes {
    // Directly register the InvertedTrunkPlacer type using Registry.register
    public static final TrunkPlacerType<?> INVERTED_TRUNK_PLACER = Registry.register(
            Registries.TRUNK_PLACER_TYPE,
            "inverted_trunk_placer",
            new TrunkPlacerType<>(InvertedTrunkPlacer.CODEC)
    );

    // Register method for logging or additional setup
    public static void register() {
        XOAccurateDungeons.LOGGER.info("Registering Trunk Placers for " + XOAccurateDungeons.MOD_ID);
    }
}