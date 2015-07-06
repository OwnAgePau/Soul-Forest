package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenDarkHouse extends WorldGenerator
{
	private int height = 20;
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) 
	{
        int x1;
        int y1;
        int z1;
        
        int y2;
        int yLevel;
        int width = 4;
        
		while (world.isAirBlock(x, y, z) && y > 2 && y < 100)
		{
			--y;
			--y;
		}
		
		//Can it spawn here?
		Block l = world.getBlock(x, y, z);
        if (l != SoulBlocks.FyrisedSandGrass.get() && l != SoulBlocks.FyrisedSand.get())
        {  	
        	return false;
        }
        
    	if(!world.isAirBlock(x, y + height, z))
		{
			return false;
        }
        	
        // The Island
        for(x1 = 0; x1 < 6; x1++)      	
        {
        	for(z1 = 0; z1 < 6; z1++)
        	{
        		world.setBlock(x + x1, y + height, z + z1, SoulBlocks.FyrisedSandGrass.get());      
        		world.setBlock(x + x1, y + height, z - z1, SoulBlocks.FyrisedSandGrass.get());
        		world.setBlock(x - x1, y + height, z - z1, SoulBlocks.FyrisedSandGrass.get());
        		world.setBlock(x - x1, y + height, z + z1, SoulBlocks.FyrisedSandGrass.get());
        	}
        }
        
        // The Island bottom part
        for(x1 = 0; x1 < 5; x1++)
        {
        	for(z1 = 0; z1 < 5; z1++)
        	{
        		world.setBlock(x + x1, y + height - 1, z + z1, SoulBlocks.FyrisedSand.get());
        		world.setBlock(x + x1, y + height - 1, z - z1, SoulBlocks.FyrisedSand.get());
        		world.setBlock(x - x1, y + height - 1, z - z1, SoulBlocks.FyrisedSand.get());
        		world.setBlock(x - x1, y + height - 1, z + z1, SoulBlocks.FyrisedSand.get());	     		
        	}
        }
        
        // The House

        for(y1 = 0; y1 < 8; y1++)
        {
        	for(z1 = 0; z1 < width; z1++)
            {
        		world.setBlock(x, y + height + y1, z - z1, SoulBlocks.BauxiteBrick.get());
        		world.setBlock(x, y + height + y1, z + z1, SoulBlocks.BauxiteBrick.get());
        		world.setBlock(x + 4, y + height + y1, z + z1, SoulBlocks.BauxiteBrick.get());
        		world.setBlock(x + 4, y + height + y1, z + z1, SoulBlocks.BauxiteBrick.get());
        	}
        	
        	for(x1 = 0; x1 < width; x1++)
        	{
        		world.setBlock(x + x1, y + height + y1, z, SoulBlocks.BauxiteBrick.get());
        		world.setBlock(x - x1, y + height + y1, z, SoulBlocks.BauxiteBrick.get());
        		world.setBlock(x + x1, y + height + y1, z + 4, SoulBlocks.BauxiteBrick.get());
        		world.setBlock(x - x1, y + height + y1, z + 4, SoulBlocks.BauxiteBrick.get());
        	}
        }
        
        // The roof
        for(yLevel = 7; yLevel < 14; yLevel++)
        {
	        for(x1 = 0; x1 < width; x1++)
	        {
	        	for(z1 = 0; z1 < width; z1++)
	        	{
	        		for(y1 = 0; y1 < 8; y1++)
	        		{
	        			world.setBlock(x + x1, (y + height + y1), z + z1, SoulBlocks.BauxiteBrick.get());
	        			world.setBlock(x + x1, (y + height + y1), z - z1, SoulBlocks.BauxiteBrick.get());
	        			world.setBlock(x - x1, (y + height + y1), z - z1, SoulBlocks.BauxiteBrick.get());
	        			world.setBlock(x - x1, (y + height + y1), z + z1, SoulBlocks.BauxiteBrick.get());
	        		}
	        	}
	        }
	        
	        width --;
        }    
        
        return true;
	}
}

