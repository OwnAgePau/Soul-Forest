package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenDarkAltar extends WorldGenerator{
    private int height = 20;
    private int pillarHeight = 4;

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
		
		if(pos.getY() > 100){
		    return false;
		}
	
		//Can it spawn here?
		Block l = world.getBlockState(pos).getBlock();
		if (l != SoulBlocks.FyrisedSandGrass.get() && l != SoulBlocks.FyrisedSand.get()){  	
		    return false;
		}
	
		if(!world.isAirBlock(new BlockPos(pos.getX(), pos.getY() + height, pos.getZ()))){
		    return false;
		}
	
		for(x1 = 0; x1 < 5; x1++){
		    for(z1 = 0; z1 < 5; z1++){
			Block block = null;
			int r = new Random().nextInt(2);
			if(r == 0){
			    block = SoulBlocks.BauxiteMossy.get();
			}
			else{
			    block = SoulBlocks.Bauxite.get();
			}
				world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() + z1), block.getDefaultState());      
		    }
		}
		
		for(int y = 0; y < this.pillarHeight; y++){
		    world.setBlockState(new BlockPos(pos.getX() + 0 , pos.getY() + height + y, pos.getZ() + 0), SoulBlocks.BauxiteBrick.get().getDefaultState());
		    world.setBlockState(new BlockPos(pos.getX() + 4 , pos.getY() + height + y, pos.getZ() + 0), SoulBlocks.BauxiteBrick.get().getDefaultState());
		    world.setBlockState(new BlockPos(pos.getX() + 0 , pos.getY() + height + y, pos.getZ() + 4), SoulBlocks.BauxiteBrick.get().getDefaultState());
		    world.setBlockState(new BlockPos(pos.getX() + 4 , pos.getY() + height + y, pos.getZ() + 4), SoulBlocks.BauxiteBrick.get().getDefaultState());
		}
		
		Block topBlock = null;
		switch(new Random().nextInt(4)){
		case 0:
		    topBlock = SoulBlocks.AmethystBlock.get();
		    break;
		case 1:
		    topBlock = SoulBlocks.TanzaniteBlock.get();
		    break;
		case 2:
		    topBlock = SoulBlocks.TopazBlock.get();
		    break;
		case 3:
		    topBlock = SoulBlocks.ScarletiteBlock.get();
		    break;
		}
		world.setBlockState(new BlockPos(pos.getX() + 0 , pos.getY() + height + this.pillarHeight, pos.getZ() + 0), topBlock.getDefaultState());
		world.setBlockState(new BlockPos(pos.getX() + 4 , pos.getY() + height + this.pillarHeight, pos.getZ() + 0), topBlock.getDefaultState());
		world.setBlockState(new BlockPos(pos.getX() + 0 , pos.getY() + height + this.pillarHeight, pos.getZ() + 4), topBlock.getDefaultState());
		world.setBlockState(new BlockPos(pos.getX() + 4 , pos.getY() + height + this.pillarHeight, pos.getZ() + 4), topBlock.getDefaultState());
		world.setBlockState(new BlockPos(pos.getX() + 2 , pos.getY() + height, pos.getZ() + 2), SoulBlocks.BlackdiamondBlock.get().getDefaultState());
		return true;
    }
}