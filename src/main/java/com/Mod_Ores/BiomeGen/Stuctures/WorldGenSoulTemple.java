package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulTemple  extends WorldGenerator
{
    private int height = 6;
    private int width = 8;

    @Override
    public boolean generate(World world, Random random, int x, int y, int z)
    {
	while (world.isAirBlock(x, y, z) && y > 2 && y < 100)
	{
	    --y;
	}

	Block l = world.getBlock(x, y, z);

	if (l != SoulBlocks.LateriteDirt.get())
	{
	    return false;
	}
	else
	{
	    //Temple Pillars
	    int x1 = 0;
	    int y1 = 0;
	    int z1 = 0;
	    for(y1 = 0; y1 < height; ++y1)
	    {
		world.setBlock(x, y + y1, z, SoulBlocks.Bauxite.get());
		world.setBlock(x, y + y1, z + width, SoulBlocks.Bauxite.get());
		world.setBlock(x + width, y + y1, z, SoulBlocks.Bauxite.get());
		world.setBlock(x + width, y + y1, z + width, SoulBlocks.Bauxite.get());
	    }
	    for(x1 = 1; x1 < (width); ++x1)
	    {
		for(z1 = 1; z1 < (width); ++z1)
		{
		    for(y1 = 0; y1 < height; ++y1)
		    {
			world.setBlockToAir(x + x1, y + y1, z + z1);
			if(y1 == 0)
			{
			    world.setBlock(x + x1, y + y1, z + z1, SoulBlocks.Bauxite.get());
			}
		    }
		}
	    }

	    //Temple Roof

	    //Row 1
	    for(x1 = 0; x1 < (width +1); ++x1)
	    {
		for(z1 = 0; z1 < (width +1); ++z1)
		{
		    if(x1 == 0 | x1 == width || z1 == 0 | z1  == width)
		    {				
			world.setBlock(x + x1, y + height, z + z1,  SoulBlocks.Bauxite.get());
		    }
		    else
		    {				
			world.setBlock(x + x1, y + height, z + z1,  SoulBlocks.BauxiteMossy.get());						
		    }
		}
	    }

	    //Row 2
	    ++height;
	    for(x1 = 1; x1 < (width +1); ++x1)
	    {
		for(z1 = 1; z1 < (width); ++z1)
		{							
		    world.setBlock(x + x1, y + height, z + z1,  SoulBlocks.BauxiteMossy.get());
		}
	    }

	    //Row 3
	    ++height;
	    for(x1 = 2; x1 < (width +1); ++x1)
	    {
		for(z1 = 2; z1 < (width -1); ++z1)
		{							
		    world.setBlock(x + x1, y + height, z + z1,  SoulBlocks.BauxiteMossy.get());
		}
	    }

	    //Row 4
	    ++height;
	    for(x1 = 3; x1 < (width +1); ++x1)
	    {
		for(z1 = 3; z1 < (width -2); ++z1)
		{							
		    world.setBlock(x + x1, y + height, z + z1,  SoulBlocks.BauxiteMossy.get());
		}
	    }

	    //Main Part
	    for(y1 = 0; y1 < height; ++y1)
	    {
		for(x1 = (width +1); x1 < 21; ++x1)
		{
		    for(z1 = -2; z1 < 11; ++z1)
		    {					
			world.setBlock(x + x1, y + y1, z + z1,  SoulBlocks.Bauxite.get());
			world.setBlockToAir(x, y + y1, z);
			world.setBlockToAir(x, y + y1, z + 1);
			world.setBlockToAir(x, y + y1, z + 2);
			world.setBlockToAir(x, y + y1, z + 3);				
		    }
		}
	    }
	    for(x1 = (width +3); x1 < 20; --x1)
	    {
		for(z1 = -1; z1 < 10; ++z1)
		{
		    for(y1 = 0; y1 < (height - 1); ++y1)
		    {
			world.setBlockToAir(x + x1, y + y1, z + z1);
		    }
		}
	    }
	}
	return true;
    }

}
