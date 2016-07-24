package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPeatBogWater extends WorldGenerator{
    /** The ID of the plant block used in this plant generator. */
    private Block water;

    public WorldGenPeatBogWater(Block par1){
	this.water = par1;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
	    int i1 = pos.getX() + par2Random.nextInt(8) - par2Random.nextInt(8);
	    int j1 = pos.getY() + par2Random.nextInt(4) - par2Random.nextInt(4);
	    int k1 = pos.getZ() + par2Random.nextInt(8) - par2Random.nextInt(8);
	    BlockPos position = new BlockPos(i1, j1, k1);	
		Block startblock = par1World.getBlockState(position).getBlock();
		if (startblock == SoulBlocks.BogGrass.get() || startblock == SoulBlocks.BogDirt.get()){
		    if(par1World.getBlockState(position.north()).getBlock().isBlockNormalCube() && par1World.getBlockState(position.south()).getBlock().isBlockNormalCube() && 
				    par1World.getBlockState(position.west()).getBlock().isBlockNormalCube() && par1World.getBlockState(position.east()).getBlock().isBlockNormalCube() &&
				    par1World.getBlockState(position.down()).getBlock().isBlockNormalCube() && par1World.isAirBlock(position.up())){
		    	par1World.setBlockState(position, this.water.getDefaultState(), 0);
		    }
		}
		return true;
    }
}