package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulTemple  extends WorldGenerator
{
    private int height = 6;
    private int width = 8;

    @Override
    public boolean generate(World world, Random par2Random, BlockPos pos){
		while (world.isAirBlock(pos) && pos.getY() > 2 && pos.getY() < 100){
			pos.add(0, -1, 0);
		}
	
		Block l = world.getBlockState(pos).getBlock();
	
		if (l != SoulBlocks.LateriteDirt.get()){
		    return false;
		}
		else{
		    //Temple Pillars
		    int x1 = 0;
		    int y1 = 0;
		    int z1 = 0;
		    for(y1 = 0; y1 < height; ++y1){
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ()), SoulBlocks.Bauxite.get().getDefaultState());
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ() + width), SoulBlocks.Bauxite.get().getDefaultState());
				world.setBlockState(new BlockPos(pos.getX() + width, pos.getY() + y1, pos.getZ()), SoulBlocks.Bauxite.get().getDefaultState());
				world.setBlockState(new BlockPos(pos.getX() + width, pos.getY() + y1, pos.getZ() + width), SoulBlocks.Bauxite.get().getDefaultState());
		    }
		    for(x1 = 1; x1 < (width); ++x1){
				for(z1 = 1; z1 < (width); ++z1){
				    for(y1 = 0; y1 < height; ++y1){
						world.setBlockToAir(new BlockPos(pos.getX() + x1, pos.getY() + y1, pos.getZ() + z1));
						if(y1 == 0){
						    world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + y1, pos.getZ() + z1), SoulBlocks.Bauxite.get().getDefaultState());
						}
				    }
				}
		    }
	
		    //Temple Roof
	
		    //Row 1
		    for(x1 = 0; x1 < (width +1); ++x1){
				for(z1 = 0; z1 < (width +1); ++z1){
					BlockPos newPos = new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() + z1);
				    if(x1 == 0 | x1 == width || z1 == 0 | z1  == width){				
				    	world.setBlockState(newPos,  SoulBlocks.Bauxite.get().getDefaultState());
				    }
				    else{				
				    	world.setBlockState(newPos,  SoulBlocks.BauxiteMossy.get().getDefaultState());						
				    }
				}
		    }
	
		    //Row 2
		    ++height;
		    for(x1 = 1; x1 < (width +1); ++x1){
				for(z1 = 1; z1 < (width); ++z1){							
				    world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() + z1),  SoulBlocks.BauxiteMossy.get().getDefaultState());
				}
		    }
	
		    //Row 3
		    ++height;
		    for(x1 = 2; x1 < (width +1); ++x1){
				for(z1 = 2; z1 < (width -1); ++z1){							
					world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() + z1),  SoulBlocks.BauxiteMossy.get().getDefaultState());
				}
		    }
	
		    //Row 4
		    ++height;
		    for(x1 = 3; x1 < (width +1); ++x1){
				for(z1 = 3; z1 < (width -2); ++z1){							
					world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + height, pos.getZ() + z1),  SoulBlocks.BauxiteMossy.get().getDefaultState());
				}
		    }
	
		    //Main Part
		    for(y1 = 0; y1 < height; ++y1){
				for(x1 = (width +1); x1 < 21; ++x1){
				    for(z1 = -2; z1 < 11; ++z1){					
						world.setBlockState(new BlockPos(pos.getX() + x1, pos.getY() + y1, pos.getZ() + z1),  SoulBlocks.Bauxite.get().getDefaultState());
						world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ()));
						world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ() + 1));
						world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ() + 2));
						world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + y1, pos.getZ() + 3));				
				    }
				}
		    }
		    for(x1 = (width +3); x1 < 20; --x1){
				for(z1 = -1; z1 < 10; ++z1){
				    for(y1 = 0; y1 < (height - 1); ++y1){
				    	world.setBlockToAir(new BlockPos(pos.getX() + x1, pos.getY() + y1, pos.getZ() + z1));
				    }
				}
		    }
		}
		return true;
    }
}