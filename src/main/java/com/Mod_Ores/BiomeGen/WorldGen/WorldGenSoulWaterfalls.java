package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulWaterfalls extends WorldGenerator{
    
	/** Stores the ID for WorldGenHellLava */
    private Block block;
    private Block water;
    private boolean field_94524_b;

    public WorldGenSoulWaterfalls(Block par1, Block par2, boolean par3){
        this.water = par1;
        this.field_94524_b = par3;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position){
        if (worldIn.getBlockState(position.up()).getBlock() != SoulBlocks.Porphyry.get()){
            return false;
        }
        else if (worldIn.getBlockState(position.down()).getBlock() != SoulBlocks.Porphyry.get()){
            return false;
        }
        else if (worldIn.getBlockState(position).getBlock().getMaterial() != Material.air && worldIn.getBlockState(position).getBlock() != SoulBlocks.Porphyry.get()){
            return false;
        }
        else{
            int i = 0;

            if (worldIn.getBlockState(position.west()).getBlock() == SoulBlocks.Porphyry.get()){
                ++i;
            }

            if (worldIn.getBlockState(position.east()).getBlock() == SoulBlocks.Porphyry.get()){
                ++i;
            }

            if (worldIn.getBlockState(position.north()).getBlock() == SoulBlocks.Porphyry.get()){
                ++i;
            }

            if (worldIn.getBlockState(position.south()).getBlock() == SoulBlocks.Porphyry.get()){
                ++i;
            }

            int j = 0;

            if (worldIn.isAirBlock(position.west())){
                ++j;
            }

            if (worldIn.isAirBlock(position.east())){
                ++j;
            }

            if (worldIn.isAirBlock(position.north())){
                ++j;
            }

            if (worldIn.isAirBlock(position.south())){
                ++j;
            }

            if (i == 3 && j == 1){
                worldIn.setBlockState(position, this.block.getDefaultState(), 2);
                worldIn.forceBlockUpdateTick(this.block, position, rand);
            }

            return true;
        }
    }
}

