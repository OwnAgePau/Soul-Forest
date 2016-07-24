package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSoulGrass extends WorldGenerator
{
    /** Stores ID for WorldGenTallGrass */
    private Block tallGrass;
    private int tallGrassMetadata;
    private Block[] blocksCantStayOn = new Block[]{SoulBlocks.SoulLog.get(), SoulBlocks.FyrisedSand.get(), SoulBlocks.FyrisedSandGrass.get(), SoulBlocks.FrozenGrass.get()};

    public WorldGenSoulGrass(Block par1, int par2){
		this.tallGrass = par1;
		this.tallGrassMetadata = par2;
    }
    
    @Override
    public boolean generate(World par1World, Random par2Random, BlockPos pos){
		int l;
	
		Block block = null;
		do {
		    block = par1World.getBlockState(pos).getBlock();
		    if (block != null && !block.isLeaves(par1World, pos)){
		    	break;
		    }
		    pos.add(0, -1, 0);
		} 
		while (pos.getY() > 0); // TODO what is this for???
	
		for (l = 0; l < 128; ++l){
		    int i1 = pos.getX() + par2Random.nextInt(8) - par2Random.nextInt(8);
		    int j1 = pos.getY() + par2Random.nextInt(4) - par2Random.nextInt(4);
		    int k1 = pos.getZ() + par2Random.nextInt(8) - par2Random.nextInt(8);
		    if(pos.getY() > 100){
		    	return false;
		    }
		    BlockPos position = new BlockPos(i1, j1, k1);	
		    if (par1World.isAirBlock(position) && this.tallGrass.canPlaceBlockAt(par1World, position) && !par1World.isAirBlock(position.down())){
				boolean cantStay = true;
				for(int i = 0; i < this.blocksCantStayOn.length; i++){
					Block checkBlock = this.blocksCantStayOn[i];
					if(par1World.getBlockState(position).getBlock() != checkBlock){ // TODO shouldn't this check position below instead
						cantStay = false;
					}
				}
				if(cantStay){
					par1World.setBlockState(position, this.tallGrass.getDefaultState());
				}
		    }
		}
	
		return true;
    }
}