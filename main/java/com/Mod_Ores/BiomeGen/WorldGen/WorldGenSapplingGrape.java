package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSapplingGrape extends WorldGenerator
{
    /** The ID of the plant block used in this plant generator. */
    private Block plantBLock;

    public WorldGenSapplingGrape(Block par1)
    {
        this.plantBLock = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5){
        for (int l = 0; l < 64; ++l){
            int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
            if(par4 > 100){
		return false;
	    }
            if (par1World.isAirBlock(i1, j1, k1) && this.plantBLock.canBlockStay(par1World, i1, j1, k1) && !par1World.isAirBlock(i1, (j1 - 1), k1)){
        	if(par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.LateriteGrass.get() || par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.LateriteDirt.get()){
	            	par1World.setBlock(i1, j1, k1, this.plantBLock, 0, 2);
            	}
            }
        }
        return true;
    }
}
