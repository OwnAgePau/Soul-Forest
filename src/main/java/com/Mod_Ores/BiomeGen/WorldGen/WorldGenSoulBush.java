package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
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
    public boolean generate(World world, Random rand, BlockPos pos) {
		while (world.isAirBlock(pos) && pos.getY() > 2 && pos.getY() < 100){
		    pos.add(0, -1, 0);
		    pos.add(0, -1, 0);
		}
		if(pos.getY() > 100){
		    return false;
		}
		Block l = world.getBlockState(pos).getBlock();
		if (l != this.grassAllowed && l != this.dirtAllowed){
		    return false;
		}
	
		boolean flag = false;
		for(int height = 0; height < this.bushHeight; height++){
			BlockPos posHeight = new BlockPos(pos.getX(), pos.getY() + height, pos.getZ());
		    if(world.getBlockState(posHeight).getBlock() == SoulBlocks.SoulWaterMoving.get()){
		    	return false;
		    }
		    if(world.isAirBlock(posHeight)){
		    	flag = true;
		    }
		}
		if(!flag){
		    return flag;
		}
	
		for(int y1 = 1; y1 <= this.bushHeight; y1++){
			BlockPos posHeight = new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ());
		    world.setBlockState(posHeight, this.log.getDefaultState(), 0);
		}
	
		world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY() + (this.bushHeight - 1), pos.getZ()), this.leaves.getDefaultState(), 0);
		world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + (this.bushHeight - 1), pos.getZ()), this.leaves.getDefaultState(), 0);
		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + (this.bushHeight - 1), pos.getZ() + 1), this.leaves.getDefaultState(), 0);
		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + (this.bushHeight - 1), pos.getZ() - 1), this.leaves.getDefaultState(), 0);
		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + this.bushHeight, pos.getZ()), this.leaves.getDefaultState(), 0);
		return true;
    }
}