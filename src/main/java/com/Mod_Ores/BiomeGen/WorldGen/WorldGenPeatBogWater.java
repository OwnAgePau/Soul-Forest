package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPeatBogWater extends WorldGenerator{
    /** The ID of the plant block used in this plant generator. */
    private Block water;

    public WorldGenPeatBogWater(Block par1){
	this.water = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5){
	int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
	int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
	int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

	Block startblock = par1World.getBlock(i1, j1, k1);
	if (startblock == SoulBlocks.BogGrass.get() || startblock == SoulBlocks.BogDirt.get()){
	    if(par1World.getBlock(i1 + 1, j1, k1).isBlockNormalCube() && par1World.getBlock(i1 - 1, j1, k1).isBlockNormalCube() && 
		    par1World.getBlock(i1, j1, k1 + 1).isBlockNormalCube() && par1World.getBlock(i1, j1, k1 - 1).isBlockNormalCube() &&
		    par1World.getBlock(i1, j1 - 1, k1).isBlockNormalCube() && par1World.isAirBlock(i1, j1 + 1, k1)){
		par1World.setBlock(i1, j1, k1, water, 0, 2);
	    }
	}
	return true;
    }
}