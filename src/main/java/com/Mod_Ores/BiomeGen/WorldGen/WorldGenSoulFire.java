package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulFire extends WorldGenerator{
	
	private Block fireBlock;
	private Block[] blocksCantStayOn = new Block[]{SoulBlocks.SoulWaterMoving.get(), SoulBlocks.FyrisedSand.get(), SoulBlocks.FyrisedSandGrass.get()};
	 
    public WorldGenSoulFire(Block par1){
        this.fireBlock = par1;
    }
	
    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
		for (int l = 0; l < 64; ++l){
		    int i1 = pos.getX() + par2Random.nextInt(8) - par2Random.nextInt(8);
		    int j1 = pos.getY() + par2Random.nextInt(4) - par2Random.nextInt(4);
		    int k1 = pos.getZ() + par2Random.nextInt(8) - par2Random.nextInt(8);
		    if(pos.getX() > 100){
				return false;
			}
		    BlockPos position = new BlockPos(i1, j1, k1);		    
			if (par1World.isAirBlock(position) && this.fireBlock.canPlaceBlockAt(par1World, position) &&
					!par1World.isAirBlock(position.down()) && par1World.getBlockState(position).getBlock() != SoulBlocks.SoulWaterMoving.get()){
				boolean cantStay = true;
				for(int i = 0; i < this.blocksCantStayOn.length; i++){
					Block block = this.blocksCantStayOn[i];
					if(par1World.getBlockState(position.down()).getBlock() != block){
						cantStay = false;
					}
				}
				if(cantStay){
					par1World.setBlockState(position, this.fireBlock.getDefaultState());
				}
		    }
		}
		return true;
    }
}