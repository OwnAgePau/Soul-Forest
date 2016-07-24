package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPlant extends WorldGenerator
{
    /** The ID of the plant block used in this plant generator. */
    private Block plantBlock;

    public WorldGenPlant(Block par1){
        this.plantBlock = par1;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
		for (int l = 0; l < 64; ++l){
		    int i1 = pos.getX() + par2Random.nextInt(8) - par2Random.nextInt(8);
		    int j1 = pos.getY() + par2Random.nextInt(4) - par2Random.nextInt(4);
		    int k1 = pos.getZ() + par2Random.nextInt(8) - par2Random.nextInt(8);
		    if(pos.getX() > 100){
				return false;
			}
		    BlockPos position = new BlockPos(i1, j1, k1);		   
            if (par1World.isAirBlock(position) && this.plantBlock.canPlaceBlockAt(par1World, position)){
	            par1World.setBlockState(position, this.plantBlock.getDefaultState(), 0);
            }
        }
        return true;
    }
}