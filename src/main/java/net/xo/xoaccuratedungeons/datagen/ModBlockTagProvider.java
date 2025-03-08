package net.xo.xoaccuratedungeons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.xo.xoaccuratedungeons.block.ModBlocks;
import net.xo.xoaccuratedungeons.utill.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.END_NYLIUM)
                .add(ModBlocks.INVERTED_ENDDIRT_GRASS_BLOCK)
                .add(ModBlocks.INVERTED_ENDROCK_GRASS_BLOCK)
                .add(ModBlocks.INVERTED_ENDSTONE_GRASS_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)

                ;

        getOrCreateTagBuilder(BlockTags.FENCES)

                ;
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)

                ;
        getOrCreateTagBuilder(BlockTags.WALLS)

                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)

                ;

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHORUS_STEM_BLOCK)
                ;
    }
}