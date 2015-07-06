package com.Mod_Ores.BiomeGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenHardwoodTrees extends WorldGenerator
{
    private int height = 15;
    private int leavesStartLevel = 0;
    private int leavesLevel = 0;
    private int leavesWidth = 4;
    private int leavesCounter = 0;

    public WorldGenHardwoodTrees(Random par1random){
	//this.height += 0;
	this.leavesStartLevel = 0;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z){
	this.leavesCounter = 0;
	this.leavesWidth = 4;
	this.leavesLevel = 0;
	this.leavesStartLevel = 0;
	this.height = 15;
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
	if (l != SoulBlocks.FyrisedSandGrass.get() && l != SoulBlocks.FyrisedSand.get()){
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
	    world.setBlock(x, y + y1, z, SoulBlocks.HardwoodLog.get(), 0, 2);
	}

	// The tree
	for(this.leavesLevel = 4 + this.leavesStartLevel; this.leavesLevel < (this.height + 1); this.leavesLevel += 2){
	    for(x1 = 0; x1 < this.leavesWidth; x1++){
		for(z1 = 0; z1 < this.leavesWidth; z1++){
		    if(world.getBlock(x + x1, y + this.leavesLevel, z + z1) != SoulBlocks.HardwoodLog.get()){
			/*if(this.leavesStartLevel == 4 && this.leavesLevel == 8){
	        				world.setBlock(x + x1, y + this.leavesLevel - 2, z + z1, SoulBlocks.HardwoodLeaves.get()); 		
	        				world.setBlock(x + x1, y + this.leavesLevel - 2, z - z1, SoulBlocks.HardwoodLeaves.get()); 	
	        				world.setBlock(x - x1, y + this.leavesLevel - 2, z - z1, SoulBlocks.HardwoodLeaves.get()); 	
	        				world.setBlock(x - x1, y + this.leavesLevel - 2, z + z1, SoulBlocks.HardwoodLeaves.get()); 	
	        			}*/

			world.setBlock(x + x1, y + this.leavesLevel, z + z1, SoulBlocks.HardwoodLeaves.get());
			world.setBlock(x + x1, y + this.leavesLevel, z - z1, SoulBlocks.HardwoodLeaves.get());
			world.setBlock(x - x1, y + this.leavesLevel, z - z1, SoulBlocks.HardwoodLeaves.get());
			world.setBlock(x - x1, y + this.leavesLevel, z + z1, SoulBlocks.HardwoodLeaves.get());
		    }
		}
	    }

	    // LeavesCounter helps to make the leavesWidth decay only once every 2 rows in the tree.
	    this.leavesCounter++;

	    if(this.leavesCounter == 2){
		this.leavesWidth -= 1;
		this.leavesCounter = 0;
	    }

	    // The top of the tree
	    world.setBlock(x, (y + this.height), z, SoulBlocks.HardwoodLeaves.get());
	}
	return true;
    }

}
