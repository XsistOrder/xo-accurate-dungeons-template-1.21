package net.xo.xoaccuratedungeons.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.xo.xoaccuratedungeons.world.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class InvertedTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<InvertedTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            fillTrunkPlacerFields(instance).apply(instance, InvertedTrunkPlacer::new));
    public InvertedTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.INVERTED_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                 Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        int height_ = (int)(Math.random() * 4) + 5;
        int placeBranch1 = (int)(Math.random() * 4) + 1;
        int xOffset = 0 ,zOffset = 0;

        for(int i = 0; i < height_; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
        if(placeBranch1 == 1) {
            for(int x = 1; x <= (int)(Math.random() * 4) + 1; x++) {
                replacer.accept(startPos.add(0,height_-1, x * -1), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.add(0,height_-1, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                zOffset -= 1;
            }
        }
        if(placeBranch1 == 2) {
            for(int x = 1; x <= (int)(Math.random() * 4) + 1; x++) {
                replacer.accept(startPos.add(0,height_-1, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.add(0,height_-1, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                zOffset += 1;
            }
        }
        if(placeBranch1 == 3) {
            for(int x = 1; x <= (int)(Math.random() * 4) + 1; x++) {
                replacer.accept(startPos.add(x,height_-1, 0), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.add(x,height_-1, 0)).with(PillarBlock.AXIS, Direction.Axis.X)));
                xOffset += 1;
            }
        }
        if(placeBranch1 == 4) {
            for(int x = 1; x <= (int)(Math.random() * 4) + 1; x++) {
                replacer.accept(startPos.add(x * -1,height_-1, 0), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.add(x,height_-1, 0)).with(PillarBlock.AXIS, Direction.Axis.X)));
                xOffset -= 1;
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.add(xOffset ,height_ - 1, zOffset), 0, false));
    }
}