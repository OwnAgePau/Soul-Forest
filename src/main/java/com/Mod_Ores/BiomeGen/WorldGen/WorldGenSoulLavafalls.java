package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulLavafalls extends WorldGenerator{

	/** Stores the ID for WorldGenHellLava */
    private Block lava;
    private boolean field_94524_b;

    public WorldGenSoulLavafalls(Block par1, boolean par2){
        this.lava = par1;
        this.field_94524_b = par2;
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
                worldIn.setBlockState(position, this.lava.getDefaultState(), 2);
                worldIn.forceBlockUpdateTick(this.lava, position, rand);
            }

            return true;
        }
    }
}