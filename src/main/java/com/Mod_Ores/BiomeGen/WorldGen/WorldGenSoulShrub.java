package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Blocks.Special.SoulBlock;
import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulShrub extends WorldGenerator{
    private Block leaves;
    private Block log;
    private int meta;

    public WorldGenSoulShrub(Block par1, Block par2){
		this.leaves = par1;
		this.log = par2;
		this.meta = 0;
    }
    
    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
		if(pos.getY() < 35){
		    return false;
		}
		while (true){
		    if (pos.getY() > 3){
				label63:{
					if (!par1World.isAirBlock(pos.down())){
					    Block block = par1World.getBlockState(pos.down()).getBlock();
			
					    if (block == SoulBlocks.LateriteGrass.get() || block == SoulBlocks.LateriteDirt.get() || block == SoulBlocks.Porphyry.get() || block == SoulBlocks.Slate.get()){
					    	break label63;
					    }
					}
					pos.add(0, -1, 0);
					continue;
				}
			}
		
			if (pos.getY() <= 3){
		    	return false;
		    }
	
		    int k2 = this.meta;
		    
		    for (int l = 0; k2 >= 0 && l < 3; ++l){
				int i1 = k2 + par2Random.nextInt(2);
				int j1 = k2 + par2Random.nextInt(2);
				int k1 = k2 + par2Random.nextInt(2);
				float f = (float)(i1 + j1 + k1) * 0.333F + 0.5F;
		
				for (int l1 = pos.getX() - i1; l1 <= pos.getX() + i1; ++l1){
				    for (int i2 = pos.getZ() - k1; i2 <= pos.getZ() + k1; ++i2){
						for (int j2 = pos.getY() - j1; j2 <= pos.getY() + j1; ++j2){
						    float f1 = (float)(l1 - pos.getX());
						    float f2 = (float)(i2 - pos.getY());
						    float f3 = (float)(j2 - pos.getZ());
						    if(j2 > 100){
						    	return false;
						    }
						    if (f1 * f1 + f2 * f2 + f3 * f3 <= f * f){
								if(par1World.getBlockState(new BlockPos(l1, j2, i2)).getBlock() != SoulBlocks.SoulWaterMoving.get() && !(par1World.getBlockState(new BlockPos(l1, j2, i2)).getBlock() instanceof SoulBlock) && j2 > 33){
								    if(par1World.getBlockState(new BlockPos(l1, j2, i2)).getBlock() == Blocks.air){
								    	par1World.setBlockState(new BlockPos(l1, j2, i2), this.leaves.getDefaultState(), 0);
								    }
								}
						    }
						}
				    }
				}
				pos = pos.add(-(k2 + 1) + par2Random.nextInt(2 + k2 * 2), 0 - par2Random.nextInt(2), -(k2 + 1) + par2Random.nextInt(2 + k2 * 2));
		    }	    
		    return true;
		}
    }
}