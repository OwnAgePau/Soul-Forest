package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenDarkHouse extends WorldGenerator
{
	private int height = 20;
	
    @Override
    public boolean generate(World world, Random par2Random, BlockPos pos){
        int x1;
        int y1;
        int z1;
        
        int y2;
        int yLevel;
        int width = 4;
        
		while (world.isAirBlock(pos) && pos.getY() > 2 && pos.getY() < 100){
			pos.add(0, -2, 0);
		}
		
		//Can it spawn here?
		Block l = world.getBlockState(pos).getBlock();
        if (l != SoulBlocks.FyrisedSandGrass.get() && l != SoulBlocks.FyrisedSand.get().getDefaultState()){  	
        	return false;
        }
        
    	if(!world.isAirBlock(new BlockPos(pos.getX(), pos.getY() + height, pos.getZ()))){
			return false;
        }
        	
        // The Island
        for(x1 = 0; x1 < 6; x1++){
        	for(z1 = 0; z1 < 6; z1++){
        		world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() + z1), SoulBlocks.FyrisedSandGrass.get().getDefaultState());      
        		world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() - z1), SoulBlocks.FyrisedSandGrass.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() - x1, pos.getY() + height, pos.getZ() - z1), SoulBlocks.FyrisedSandGrass.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() - x1, pos.getY() + height, pos.getZ() + z1), SoulBlocks.FyrisedSandGrass.get().getDefaultState());
        	}
        }
        
        // The Island bottom part
        for(x1 = 0; x1 < 5; x1++){
        	for(z1 = 0; z1 < 5; z1++){
        		world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height - 1, pos.getZ() + z1), SoulBlocks.FyrisedSand.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height - 1, pos.getZ() - z1), SoulBlocks.FyrisedSand.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() - x1, pos.getY() + height - 1, pos.getZ() - z1), SoulBlocks.FyrisedSand.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() - x1, pos.getY() + height - 1, pos.getZ() + z1), SoulBlocks.FyrisedSand.get().getDefaultState());	     		
        	}
        }
        
        // The House

        for(y1 = 0; y1 < 8; y1++){
        	for(z1 = 0; z1 < width; z1++){
        		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + height + y1, pos.getZ() - z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + height + y1, pos.getZ() + z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() + 4, pos.getY() + height + y1, pos.getZ() + z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() + 4, pos.getY() + height + y1, pos.getZ() + z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
        	}
        	
        	for(x1 = 0; x1 < width; x1++){
        		world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height + y1, pos.getZ()), SoulBlocks.BauxiteBrick.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() - x1, pos.getY() + height + y1, pos.getZ()), SoulBlocks.BauxiteBrick.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height + y1, pos.getZ() + 4), SoulBlocks.BauxiteBrick.get().getDefaultState());
        		world.setBlockState(new BlockPos(pos.getX() - x1, pos.getY() + height + y1, pos.getZ() + 4), SoulBlocks.BauxiteBrick.get().getDefaultState());
        	}
        }
        
        // The roof
        for(yLevel = 7; yLevel < 14; yLevel++){
	        for(x1 = 0; x1 < width; x1++){
	        	for(z1 = 0; z1 < width; z1++){
	        		for(y1 = 0; y1 < 8; y1++){
	        			world.setBlockState(new BlockPos(pos.getX() + x1, (pos.getY() + height + y1), pos.getZ() + z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
	        			world.setBlockState(new BlockPos(pos.getX() + x1, (pos.getY() + height + y1), pos.getZ() - z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
	        			world.setBlockState(new BlockPos(pos.getX() - x1, (pos.getY() + height + y1), pos.getZ() - z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
	        			world.setBlockState(new BlockPos(pos.getX() - x1, (pos.getY() + height + y1), pos.getZ() + z1), SoulBlocks.BauxiteBrick.get().getDefaultState());
	        		}
	        	}
	        }
	        
	        width --;
        }    
        return true;
	}
}