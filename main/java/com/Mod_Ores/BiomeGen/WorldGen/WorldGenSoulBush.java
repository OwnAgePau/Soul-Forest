package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSoulBush extends WorldGenerator{

    private int bushHeight;
    private Block log;
    private Block leaves;
    private Block grassAllowed;
    private Block dirtAllowed;

    public WorldGenSoulBush(Block parLog, Block parLeaves, Block parGrassAllowed, Block parDirtAllowed, int parBushHeight){
	this.log = parLog;
	this.leaves = parLeaves;
	this.grassAllowed = parGrassAllowed;
	this.dirtAllowed = parDirtAllowed;
	this.bushHeight = parBushHeight + 1;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
	while (world.isAirBlock(x, y, z) && y > 2 && y < 100){
	    --y;
	    --y;
	}
	if(y > 100){
	    return false;
	}
	Block l = world.getBlock(x, y, z);
	if (l != this.grassAllowed && l != this.dirtAllowed){
	    return false;
	}

	boolean flag = false;
	for(int height = 0; height < this.bushHeight; height++){
	    if(world.getBlock(x, y + height, z) == SoulBlocks.SoulWaterMoving.get()){
		return false;
	    }
	    if(world.isAirBlock(x, y + height, z)){
		flag = true;
	    }
	}
	if(!flag){
	    return flag;
	}

	for(int y1 = 1; y1 <= this.bushHeight; y1++){
	    world.setBlock(x, y + y1, z, this.log, 0, 2);
	}

	world.setBlock(x + 1, y + (this.bushHeight - 1), z, this.leaves, 0, 2);
	world.setBlock(x - 1, y + (this.bushHeight - 1), z, this.leaves, 0, 2);
	world.setBlock(x, y + (this.bushHeight - 1), z + 1, this.leaves, 0, 2);
	world.setBlock(x, y + (this.bushHeight - 1), z - 1, this.leaves, 0, 2);
	world.setBlock(x, y + this.bushHeight, z, this.leaves, 0, 2);
	return true;
    }
}
