package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulLakes extends WorldGenerator{
    private Block blockIndex;

    public WorldGenSoulLakes(Block par1){
    	this.blockIndex = par1;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
		pos.add(-8, 0, 0);
	
		if (pos.getY() <= 4){
		    return false;
		}
		else{
		    pos.add(0, -4, 0);
		    boolean[] aboolean = new boolean[2048];
		    int l = par2Random.nextInt(4) + 4;
		    int i1;
	
		    for (i1 = 0; i1 < l; ++i1){
				double d0 = par2Random.nextDouble() * 6.0D + 3.0D;
				double d1 = par2Random.nextDouble() * 4.0D + 2.0D;
				double d2 = par2Random.nextDouble() * 6.0D + 3.0D;
				double d3 = par2Random.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
				double d4 = par2Random.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
				double d5 = par2Random.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;
		
				for (int j1 = 1; j1 < 15; ++j1){
				    for (int k1 = 1; k1 < 15; ++k1){
						for (int l1 = 1; l1 < 7; ++l1){
						    double d6 = ((double)j1 - d3) / (d0 / 2.0D);
						    double d7 = ((double)l1 - d4) / (d1 / 2.0D);
						    double d8 = ((double)k1 - d5) / (d2 / 2.0D);
						    double d9 = d6 * d6 + d7 * d7 + d8 * d8;
			
						    if (d9 < 1.0D){
							aboolean[(j1 * 16 + k1) * 8 + l1] = true;
						    }
						}
				    }
				}
		    }
	
		    int i2;
		    int j2;
		    boolean flag;
	
		    for (i1 = 0; i1 < 16; ++i1){
				for (j2 = 0; j2 < 16; ++j2){
				    for (i2 = 0; i2 < 8; ++i2){
						flag = !aboolean[(i1 * 16 + j2) * 8 + i2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + i2] || i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + i2] || j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + i2] || j2 > 0 && aboolean[(i1 * 16 + (j2 - 1)) * 8 + i2] || i2 < 7 && aboolean[(i1 * 16 + j2) * 8 + i2 + 1] || i2 > 0 && aboolean[(i1 * 16 + j2) * 8 + (i2 - 1)]);
			
						if (flag){
						    Material material = par1World.getBlockState(new BlockPos(pos.getX() + i1, pos.getY() + i2, pos.getZ() + j2)).getBlock().getMaterial();
			
						    if (i2 >= 4 && material.isLiquid()){
						    	return false;
						    }
			
						    if (i2 < 4 && !material.isSolid() && par1World.getBlockState(new BlockPos(pos.getX() + i1, pos.getY() + i2, pos.getZ() + j2)).getBlock() != this.blockIndex){
						    	return false;
						    }
						}
				    }
				}
		    }
	
		    for (i1 = 0; i1 < 16; ++i1){
				for (j2 = 0; j2 < 16; ++j2){
				    for (i2 = 0; i2 < 8; ++i2){
						if (aboolean[(i1 * 16 + j2) * 8 + i2]){
						    par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY() + i2, pos.getZ() + j2), i2 >= 4 ? Block.getBlockFromName("air").getDefaultState() : this.blockIndex.getDefaultState(), 0);
						}
				    }
				}
		    }
	
		    for (i1 = 0; i1 < 16; ++i1){
				for (j2 = 0; j2 < 16; ++j2){
				    for (i2 = 4; i2 < 8; ++i2){
						if (aboolean[(i1 * 16 + j2) * 8 + i2]){
						    BiomeGenBase biomegenbase = par1World.getBiomeGenForCoords(new BlockPos(pos.getX() + i1, 0, pos.getZ() + j2));
			
						    par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY() + i2 - 1, pos.getZ() + j2), biomegenbase.topBlock, 0);
						}
				    }
				}
		    }
	
		    if (this.blockIndex.getMaterial() == Material.lava){
				for (i1 = 0; i1 < 16; ++i1){
				    for (j2 = 0; j2 < 16; ++j2){
						for (i2 = 0; i2 < 8; ++i2){
						    flag = !aboolean[(i1 * 16 + j2) * 8 + i2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + i2] || i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + i2] || j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + i2] || j2 > 0 && aboolean[(i1 * 16 + (j2 - 1)) * 8 + i2] || i2 < 7 && aboolean[(i1 * 16 + j2) * 8 + i2 + 1] || i2 > 0 && aboolean[(i1 * 16 + j2) * 8 + (i2 - 1)]);
			
						    if (flag && (i2 < 4 || par2Random.nextInt(2) != 0) && par1World.getBlockState(new BlockPos(pos.getX() + i1, pos.getY() + i2, pos.getZ() + j2)).getBlock().getMaterial().isSolid()){
						    	par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY() + i2, pos.getZ() + j2), SoulBlocks.Porphyry.get().getDefaultState(), 0);
						    }
						}
				    }
				}
		    }
	
		    if (this.blockIndex.getMaterial() == Material.water){
				for (i1 = 0; i1 < 16; ++i1){
				    for (j2 = 0; j2 < 16; ++j2){
						byte b0 = 4;
			
						if (par1World.canBlockFreezeWater(new BlockPos(pos.getX() + i1, pos.getY() + b0, pos.getZ() + j2))){
						    par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY() + b0, pos.getZ() + j2), Block.getBlockFromName("ice").getDefaultState(), 0);
						}
				    }
				}
		    }
	
		    return true;
		}
    }
}