package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSoulGrass extends WorldGenerator
{
    /** Stores ID for WorldGenTallGrass */
    private Block tallGrass;
    private int tallGrassMetadata;

    public WorldGenSoulGrass(Block par1, int par2)
    {
	this.tallGrass = par1;
	this.tallGrassMetadata = par2;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5){
	int l;

	Block block = null;
	do {
	    block = par1World.getBlock(par3,  par4, par5);
	    if (block != null && !block.isLeaves(par1World, par3, par4, par5)){
		break;
	    }
	    par4--;
	} while (par4 > 0);

	for (l = 0; l < 128; ++l){
	    int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
	    int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
	    int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
	    if(par4 > 100){
		return false;
	    }
	    if(this.tallGrass != null){
		if (par1World.isAirBlock(i1, j1, k1) && this.tallGrass.canBlockStay(par1World, i1, j1, k1) && par1World.getBlock(i1, j1, k1) != SoulBlocks.SoulLog.get() && par1World.getBlock(i1, j1, k1) != SoulBlocks.FyrisedSand.get() && par1World.getBlock(i1, j1, k1) != SoulBlocks.FyrisedSandGrass.get() && par1World.getBlock(i1, j1, k1) != SoulBlocks.FrozenGrass.get()){
		    par1World.setBlock(i1, j1, k1, this.tallGrass, this.tallGrassMetadata, 2);
		}
	    }
	}

	return true;
    }
}

