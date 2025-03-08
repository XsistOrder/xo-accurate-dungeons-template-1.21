package net.xo.xoaccuratedungeons.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.xo.xoaccuratedungeons.block.ModBlocks;

public class EndRockBlock extends Block implements Fertilizable {
    public static final MapCodec<net.minecraft.block.NetherrackBlock> CODEC = createCodec(net.minecraft.block.NetherrackBlock::new);

    @Override
    public MapCodec<net.minecraft.block.NetherrackBlock> getCodec() {
        return CODEC;
    }

    public EndRockBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        if (!world.getBlockState(pos.up()).isTransparent(world, pos)) {
            return false;
        } else {
            for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
                if (world.getBlockState(blockPos).isIn(BlockTags.NYLIUM)) {
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        boolean bl = false;
        boolean bl2 = false;

        for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(ModBlocks.INVERTED_ENDDIRT_GRASS_BLOCK)) {
                bl2 = true;
            }
            if (blockState.isOf(ModBlocks.INVERTED_ENDROCK_GRASS_BLOCK)) {
                bl2 = true;
            }
            if (blockState.isOf(ModBlocks.INVERTED_ENDSTONE_GRASS_BLOCK)) {
                bl2 = true;
            }

            if (blockState.isOf(ModBlocks.CHORUS_ENDDIRT_GRASS_BLOCK)) {
                bl = true;
            }
            if (blockState.isOf(ModBlocks.CHORUS_ENDROCK_GRASS_BLOCK)) {
                bl = true;
            }
            if (blockState.isOf(ModBlocks.CHORUS_ENDSTONE_GRASS_BLOCK)) {
                bl = true;
            }

            if (bl2 && bl) {
                break;
            }
        }

        if (bl2 && bl) {
            world.setBlockState(pos, random.nextBoolean() ? ModBlocks.INVERTED_ENDROCK_GRASS_BLOCK.getDefaultState() : ModBlocks.CHORUS_ENDROCK_GRASS_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
        } else if (bl2) {
            world.setBlockState(pos, ModBlocks.INVERTED_ENDROCK_GRASS_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
        } else if (bl) {
            world.setBlockState(pos, ModBlocks.CHORUS_ENDROCK_GRASS_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    public Fertilizable.FertilizableType getFertilizableType() {
        return Fertilizable.FertilizableType.NEIGHBOR_SPREADER;
    }
}
