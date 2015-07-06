package com.Mod_Ores.BiomeGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenTallTrees extends WorldGenerator
{
    private int height = 15;
    private int leavesStartLevel = 0;
    private int leavesLevel = 0;
    private int leavesWidth = 3;
    private int leavesCounter = 0;
    private Block leaves;
    private Block log;
    private Block allowedTop;
    private Block allowedBottom;

    public WorldGenTallTrees(Random par1random, Block leaves, Block log, Block allowedTop, Block allowedBottom){
	this.leaves = leaves;
	this.log = log;
	this.allowedTop = allowedTop;
	this.allowedBottom = allowedBottom;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z){
	this.leavesCounter = 1;
	this.leavesWidth = 3;
	this.leavesLevel = 0;
	this.height = 10 + random.nextInt(4);
	this.leavesStartLevel = this.height - 7;
	int x1 = 0;
	int y1 = 0;
	int z1 = 0;

	int y2;

	while (world.isAirBlock(x, y, z) && y > 2 && y < 100){
	    --y;
	    --y;
	}
	
	if(y > 100){
	    return false;
	}

	// Check the block to generate the tree on
	Block l = world.getBlock(x, y, z);
	if (l != this.allowedTop && l != this.allowedBottom){
	    return false;
	}

	// Check if there is enough space for the tree to spawn
	for(y2 = 2; y2 < (height + 5); y2++){
	    Block blockid = world.getBlock(x, (y + y2), z);
	    if(!blockid.isAir(world, x1, y1, z1)){
		return false;
	    }
	}

	// Random Height
	for(y1 = 0; y1 < (height); y1++){        	
	    world.setBlock(x, y + y1, z, this.log, 0, 2);
	}

	// The tree
	for(this.leavesLevel = this.leavesStartLevel; this.leavesLevel < (this.height + 1); this.leavesLevel ++){
	    for(x1 = -this.leavesWidth; x1 <= this.leavesWidth; x1++){
		for(z1 = -this.leavesWidth; z1 <= this.leavesWidth; z1++){
		    if(world.getBlock(x + x1, y + this.leavesLevel, z + z1) != this.log){
			boolean flag = x1 == -this.leavesWidth || x1 == this.leavesWidth;
			boolean flag1 = z1 == -this.leavesWidth || z1 == this.leavesWidth;
			if(!(flag && flag1)){
			    world.setBlock(x + x1, y + this.leavesLevel, z + z1, this.leaves);
			}
		    }
		}
	    }

	    // LeavesCounter helps to make the leavesWidth decay only once every 2 rows in the tree.
	    this.leavesCounter++;

	    if(this.leavesCounter == 2){
		this.leavesWidth -= 1;
		this.leavesCounter = 0;
	    }
	    else{
		this.leavesLevel++;
	    }

	    // The top of the tree
	    world.setBlock(x, (y + this.height), z, this.leaves);
	}
	return true;
    }
}