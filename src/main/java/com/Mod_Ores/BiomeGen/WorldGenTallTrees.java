package com.Mod_Ores.BiomeGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenTallTrees extends WorldGenerator{
    
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
    public boolean generate(World world, Random random, BlockPos pos){
		this.leavesCounter = 1;
		this.leavesWidth = 3;
		this.leavesLevel = 0;
		this.height = 10 + random.nextInt(4);
		this.leavesStartLevel = this.height - 7;
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;
	
		int y2;
	
		while (world.isAirBlock(pos) && pos.getY() > 2 && pos.getY() < 100){
			pos = pos.add(0, -2, 0);
		}
		
		if(pos.getY() > 100){
		    return false;
		}
	
		// Check the block to generate the tree on
		Block l = world.getBlockState(pos).getBlock();
		if (l != this.allowedTop && l != this.allowedBottom){
		    return false;
		}
	
		// Check if there is enough space for the tree to spawn
		for(y2 = 2; y2 < (height + 5); y2++){
		    Block blockid = world.getBlockState(new BlockPos(pos.getX(), (pos.getY() + y2), pos.getZ())).getBlock();
		    if(!blockid.isAir(world, new BlockPos(x1, y1, z1))){
		    	return false;
		    }
		}
	
		// Random Height
		for(y1 = 0; y1 < (height); y1++){        	
		    world.setBlockState(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ()), this.log.getDefaultState(), 0);
		}
	
		// The tree
		for(this.leavesLevel = this.leavesStartLevel; this.leavesLevel < (this.height + 1); this.leavesLevel ++){
		    for(x1 = -this.leavesWidth; x1 <= this.leavesWidth; x1++){
				for(z1 = -this.leavesWidth; z1 <= this.leavesWidth; z1++){
				    if(world.getBlockState(new BlockPos(pos.getX() + x1, pos.getY() + this.leavesLevel, pos.getZ() + z1)) != this.log){
				    	boolean flag = x1 == -this.leavesWidth || x1 == this.leavesWidth;
						boolean flag1 = z1 == -this.leavesWidth || z1 == this.leavesWidth;
						if(!(flag && flag1)){
						    world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + this.leavesLevel, pos.getZ() + z1), this.leaves.getDefaultState());
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
		    world.setBlockState(new BlockPos(pos.getX(), (pos.getY() + this.height), pos.getZ()), this.leaves.getDefaultState());
		}
		return true;
    }
}