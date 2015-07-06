package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Blocks.Special.SoulVine;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSoulVine extends WorldGenerator{
    private Block block;

    public WorldGenSoulVine(Block par2){
	this.block = par2;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5){
	int l = par3;

	for (int i1 = par5; par4 < 128; ++par4){
	    if (par1World.isAirBlock(par3, par4, par5)){
		for (int j1 = 2; j1 <= 5; ++j1){
		    if (this.block.canPlaceBlockOnSide(par1World, par3, par4, par5, j1)){
			par1World.setBlock(par3, par4, par5, this.block, 1 << Direction.facingToDirection[Facing.oppositeSide[j1]], 2);
			break;
		    }
		}
	    }
	    else{
		par3 = l + par2Random.nextInt(4) - par2Random.nextInt(4);
		par5 = i1 + par2Random.nextInt(4) - par2Random.nextInt(4);
	    }
	}

	return true;

	/*int l = par3;

        for (int i1 = par4; par4 < 128; ++par4)
        {
            if (!par1World.isAirBlock(par3, par4, par5) && par1World.getBlock(par3, par4, par5).isBlockNormalCube() && !(par1World.getBlock(par3, par4, par5) instanceof SoulVine))
            {
                for (int j1 = 2; j1 <= 5; ++j1)
                {
                    if (this.block.canPlaceBlockOnSide(par1World, par3, par4, par5, j1))
                    {
                    	//Direction.facingToDirection[Facing.oppositeSide[j1]]
                        par1World.setBlock(par3, par4, par5, this.block, 1 << Direction.facingToDirection[j1], 2);
                        break;
                    }
                }
            }
            else
            {
                par3 = l + par2Random.nextInt(4) - par2Random.nextInt(4);
                par5 = i1 + par2Random.nextInt(4) - par2Random.nextInt(4);
            }
        }

        return true;*/
    }
}
