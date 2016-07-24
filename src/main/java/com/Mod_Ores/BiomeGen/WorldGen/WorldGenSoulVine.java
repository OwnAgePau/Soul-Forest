package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Blocks.Special.SoulVine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSoulVine extends WorldGenerator{
    private Block block;

    public WorldGenSoulVine(Block par2){
    	this.block = par2;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
		int l = pos.getX();
	
		for (int i1 = pos.getZ(); pos.getY() < 128; i1 += pos.getY()){
		    if (par1World.isAirBlock(pos)){
                for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL.facings()){
                    if (this.block.canPlaceBlockOnSide(par1World, pos, enumfacing)){
                    	IBlockState iblockstate = this.block.getDefaultState().withProperty(SoulVine.NORTH, Boolean.valueOf(enumfacing == EnumFacing.NORTH)).withProperty(SoulVine.EAST, Boolean.valueOf(enumfacing == EnumFacing.EAST)).withProperty(SoulVine.SOUTH, Boolean.valueOf(enumfacing == EnumFacing.SOUTH)).withProperty(SoulVine.WEST, Boolean.valueOf(enumfacing == EnumFacing.WEST));
                    	par1World.setBlockState(pos, iblockstate, 2);
						break;
				    }
				}
			}
			else{
				pos = pos.add(par2Random.nextInt(4) - par2Random.nextInt(4), 0, par2Random.nextInt(4) - par2Random.nextInt(4));
		    }
		}
	
		return true;
	
		/*int l = par3;

        for (int i1 = par4; par4 < 128; ++par4)
        {
            if (!par1World.isAirBlock(par3, par4, par5) && par1World.getBlock(par3, par4, par5).isBlockNormalCube() && !(par1World.getBlock(par3, par4, par5) instanceof SoulVine))
            {
                for (int j1 = 2; j1 <= 5; ++j1)
                {
                    if (this.block.canPlaceBlockOnSide(par1World, par3, par4, par5, j1))
                    {
                    	//Direction.facingToDirection[Facing.oppositeSide[j1]]
                        par1World.setBlock(par3, par4, par5, this.block, 1 << Direction.facingToDirection[j1], 2);
                        break;
                    }
                }
            }
            else
            {
                par3 = l + par2Random.nextInt(4) - par2Random.nextInt(4);
                par5 = i1 + par2Random.nextInt(4) - par2Random.nextInt(4);
            }
        }

        return true;*/
    }
}
