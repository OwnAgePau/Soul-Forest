package com.Mod_Ores.BiomeGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulTrees  extends WorldGenerator
{
    private int height = 7;
    private int leaveHeight = height;
    private int ylevel = -1;
    private Boolean hasEnoughRoom;
    public String side;
    private Block leaves;

    public WorldGenSoulTrees(){}
    
    private void randomizeLeaves(Random rand){
	this.height = 7;
	this.height += rand.nextInt(4);
	Random r = new Random();
	switch(r.nextInt(10)){
	case 0:
	    this.leaves = SoulBlocks.SoulLeaves.get();
	    break;
	case 1:
	    this.leaves = SoulBlocks.SoulLeaves.get();
	    break;
	case 2:
	    this.leaves = SoulBlocks.SoulLeaves.get();
	    break;
	case 3:
	    this.leaves = SoulBlocks.SoulLeaves.get();
	    break;
	case 4:
	    this.leaves = SoulBlocks.SoulLeavesYellow.get();
	    break;
	case 5:
	    this.leaves = SoulBlocks.SoulLeavesYellow.get();
	    break;
	case 6:
	    this.leaves = SoulBlocks.SoulLeavesYellow.get();
	    break;
	case 7:
	    this.leaves = SoulBlocks.SoulLeavesYellow.get();
	    break;
	case 8:
	    this.leaves = SoulBlocks.SoulLeavesBlue.get();
	    break;
	case 9:
	    this.leaves = SoulBlocks.SoulLeavesBlue.get();
	    break;
	}
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z){
	this.randomizeLeaves(random);
	while (world.isAirBlock(x, y, z) && y > 2 && y < 100){
	    --y;
	    --y;
	}

	if(y > 100){
	    return false;
	}

	Block l = world.getBlock(x, y, z);
	if (l != SoulBlocks.LateriteGrass.get() && l != SoulBlocks.LateriteDirt.get()){
	    return false;
	}

	// This will generate the water under the tree
	//waterBathGen(world, x, y, z);

	int x1 = 0;
	int y1 = 0;
	int z1 = 0;

	int y2;

	for(y2 = 2; y2 < (height + 5); y2++){
	    // Check if there is enough space for the tree to spawn
	    Block blockid = world.getBlock(x, (y + y2), z);
	    if(!blockid.isAir(world, x1, y2, z1))
	    {
		return false;
	    }
	}

	// Random Height
	for(y1 = 0; y1 < (height + 1); y1++){        	
	    world.setBlock(x, y + y1, z, SoulBlocks.SoulLog.get(), 0, 2);
	}

	// tree trunk
	if(ylevel == -1)
	{
	    world.setBlockToAir(x + 2, y + ylevel, z + 3);
	    world.setBlockToAir(x - 1, y + ylevel, z + 4);
	    world.setBlockToAir(x - 2, y + ylevel, z);
	    world.setBlockToAir(x - 3, y + ylevel, z + 1);
	    world.setBlockToAir(x - 3, y + ylevel, z + 2);
	    world.setBlockToAir(x - 4, y + ylevel, z + 2);

	    world.setBlock(x + 2, y + ylevel, z + 3, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 1, y + ylevel, z + 4, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 2, y + ylevel, z, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 3, y + ylevel, z + 1, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 3, y + ylevel, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 4, y + ylevel, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	    ylevel++;
	}

	if(ylevel == 0)
	{
	    world.setBlockToAir(x + 3, y + ylevel, z + 2);
	    world.setBlockToAir(x + 1, y + ylevel, z + 2);
	    world.setBlockToAir(x - 1, y + ylevel, z);
	    world.setBlockToAir(x - 2, y + ylevel, z + 2);
	    world.setBlockToAir(x - 2, y + ylevel, z + 3);
	    world.setBlockToAir(x - 3, y + ylevel, z - 1);

	    world.setBlock(x + 3, y + ylevel, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x + 1, y + ylevel, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 1, y + ylevel, z, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 2, y + ylevel, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 2, y + ylevel, z + 3, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 3, y + ylevel, z - 1, SoulBlocks.SoulLog.get(), 0, 2);
	    ylevel++;
	}

	if(ylevel == 1)
	{
	    world.setBlockToAir(x + 3, y + ylevel, z + 1);
	    world.setBlockToAir(x, y + ylevel, z - 1);
	    world.setBlockToAir(x - 2, y + ylevel, z + 2);
	    world.setBlockToAir(x - 2, y + ylevel, z - 2);
	    world.setBlockToAir(x - 2, y + ylevel, z - 3);

	    world.setBlock(x + 3, y + ylevel, z + 1, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x, y + ylevel, z - 1, SoulBlocks.SoulLog.get());
	    world.setBlock(x - 2, y + ylevel, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 2, y + ylevel, z - 2, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 2, y + ylevel, z - 3, SoulBlocks.SoulLog.get(), 0, 2);
	    ylevel++;
	}

	if(ylevel == 2)
	{
	    world.setBlockToAir(x + 2, y + ylevel, z);
	    world.setBlockToAir(x - 1, y + ylevel, z + 1);
	    world.setBlockToAir(x - 1, y + ylevel, z - 2);

	    world.setBlock(x + 2, y + ylevel, z, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 1, y + ylevel, z + 1, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 1, y + ylevel, z - 2, SoulBlocks.SoulLog.get(), 0, 2);
	    ylevel++;
	}

	if(ylevel == 3)
	{
	    world.setBlockToAir(x + 1, y + ylevel, z);
	    world.setBlockToAir(x - 1, y + ylevel, z - 1);

	    world.setBlock(x + 1, y + ylevel, z, SoulBlocks.SoulLog.get(), 0, 2);
	    world.setBlock(x - 1, y + ylevel, z - 1, SoulBlocks.SoulLog.get(), 0, 2);
	}              

	// Some of the leaves that should spawn (some spawn randomly)
	Random r = new Random();
	genTop(world, x + 2, y + leaveHeight + 1, z - 3, "WEST", false, this.leaves);
	genTop(world, x, y + height + 1, z + 1, "EAST", true, this.leaves);
	if(r.nextInt(2) == 0){
	    genTop(world, x + 4, y + leaveHeight + 3, z + 2, "SOUTH", false, this.leaves);
	}
	if(r.nextInt(2) == 0){
	    genTop(world, x - 3, y + leaveHeight - 1, z - 1, "NORTH", false, this.leaves);
	}


	// NORTH
	world.setBlock(x - 1, y + leaveHeight - 2, z, SoulBlocks.SoulLog.get(), 0, 2);
	world.setBlock(x - 2, y + leaveHeight - 1, z - 1, SoulBlocks.SoulLog.get(), 0, 2);

	// WEST
	world.setBlock(x + 1, y + leaveHeight, z - 1, SoulBlocks.SoulLog.get(), 0, 2);
	world.setBlock(x + 2, y + leaveHeight + 1, z - 2, SoulBlocks.SoulLog.get(), 0, 2);

	// SOUTH
	world.setBlock(x + 1, y + leaveHeight + 1, z + 1, SoulBlocks.SoulLog.get(), 0, 2);
	world.setBlock(x + 2, y + leaveHeight + 2, z + 2, SoulBlocks.SoulLog.get(), 0, 2);
	world.setBlock(x + 3, y + leaveHeight + 3, z + 2, SoulBlocks.SoulLog.get(), 0, 2);

	this.ylevel = -1;
	return true;
    }

    /** This takes care of the rendering of the leaves
     * 
     * @param world the world obj
     * @param x The x-cord
     * @param y the y-cord
     * @param z the z-cord
     * @param side the side it should go
     * @param mid if the topGenMid should be rendered
     * @param leaveid the id of the leaves that should be used in this top
     */
    public void genTop(World world, int x, int y, int z, String side, Boolean mid, Block leaveid)
    {
	int x1 = 0;
	int y1 = 0;
	int z1 = 0;

	int x2 = 0;
	int z2 = 0;		
	Random rand = new Random();

	// This is the base block of the top
	world.setBlock(x , y, z, SoulBlocks.SoulLog.get(), 0, 2);

	// Desides what side it should go
	if(side == "SOUTH") // -x
	{
	    world.setBlock(x - 1, y, z, SoulBlocks.SoulLog.get(), 0, 2);
	    x2 = -1;
	}
	else if(side == "NORTH") // +x
	{
	    world.setBlock(x + 1, y, z, SoulBlocks.SoulLog.get(), 0, 2);
	    x2 = +1;
	}
	else if(side == "EAST") // -z
	{
	    world.setBlock(x, y, z - 1, SoulBlocks.SoulLog.get(), 0, 2);
	    z2 = -1;
	}
	else if(side == "WEST") // +z
	{
	    world.setBlock(x, y, z + 1, SoulBlocks.SoulLog.get(), 0, 2);
	    z2 = +1;
	}

	// 1e layer
	if(mid == false)
	{
	    for(y1 = 0; y1 < 2; y1++)
	    {
		for(x1 = -1; x1 < 2; x1++)
		{
		    for(z1 = -1; z1 < 2; z1++)
		    {
			world.setBlock((x + x2 + x1), (y + y1), (z + z2 + z1), leaveid, 0, 2);

			//a random empty corner
			if(rand.nextInt(4) == 0)
			{
			    world.setBlockToAir(x2 + 1, y + 1, z2 + 1);
			}
			else if (rand.nextInt(4) == 1)
			{
			    world.setBlockToAir(x2 + 1, y + 1, z2 - 1);
			}
			else if (rand.nextInt(4) == 2)
			{
			    world.setBlockToAir(x2 - 1, y + 1, z2 + 1);
			}
			else if (rand.nextInt(3) == 3)
			{
			    world.setBlockToAir(x2 - 1, y + 1, z2 - 1);
			}
		    }
		}
	    }
	}
	else
	{
	    for(y1 = 0; y1 < 2; y1++)
	    {
		for(x1 = -2; x1 < 3; x1++)
		{
		    for(z1 = -2; z1 < 3; z1++)
		    {
			world.setBlock((x + x2 + x1), (y + y1), (z + z2 + z1), leaveid, 0, 2);

			//a random empty corner
			if(rand.nextInt(4) == 0)
			{
			    world.setBlockToAir(x2 + 2, y + 1, z2 + 2);
			}
			else if (rand.nextInt(4) == 1)
			{
			    world.setBlockToAir(x2 + 2, y + 1, z2 - 2);
			}
			else if (rand.nextInt(4) == 2)
			{
			    world.setBlockToAir(x2 - 2, y + 1, z2 + 2);
			}
			else if (rand.nextInt(3) == 3)
			{
			    world.setBlockToAir(x2 - 2, y + 1, z2 - 2);
			}
		    }
		}
	    }
	}

	// 2e layer
	if(mid == false)
	{
	    for(x1 = 0; x1 < 1; x1++)
	    {
		for(z1 = 0; z1 < 1; z1++)
		{
		    world.setBlock((x + x2 - x1), (y + 2), (z + z2 - z1), leaveid, 0, 2);
		}
	    }		
	}
	else
	{
	    for(x1 = -1; x1 < 2; x1++)
	    {
		for(z1 = -1; z1 < 2; z1++)
		{
		    world.setBlock((x + x2 - x1), (y - 1), (z + z2 - z1), leaveid, 0, 2);
		}
	    }

	    for(x1 = -1; x1 < 2; x1++)
	    {
		for(z1 = -1; z1 < 2; z1++)
		{
		    world.setBlock((x + x2 - x1), (y + 2), (z + z2 - z1), leaveid, 0, 2);
		}
	    }

	    for(x1 = 0; x1 < 1; x1++)
	    {
		for(z1 = 0; z1 < 1; z1++)
		{
		    world.setBlock((x + x2 - x1), (y + 3), (z + z2 - z1), leaveid, 0, 2);
		}
	    }	
	}
    }

    /** This takes care of the rendering of the water under the tree
     * 
     * @param world the world obj
     * @param x the x-cord
     * @param y the y-cord
     * @param z the z-cord
     */
    /*public void waterBathGen(World world, int x, int y, int z)
	{
		/*int x1 = 0;
		int y1 = 0;
		int z1 = 0;

		int x2 = 0;
		int z2 = 0;	

		int x3 = 0;
		int z3 = 0;
		Random rand = new Random();
		Boolean spawn = false;

		for(y1 = -2; y1 < -1; y1++)
		{
			for(z1 = -4; z1 < 5; z1++)
			{
				for(x1 = 0; x1 < 7; z1++)
				{
					if(world.isAirBlock(x + x1, y + y1, z + z1))
					{
						spawn = false;
					}
					else
					{
						spawn = true;
					}
				}
			}
		}

		/*if(spawn)
		{
			for(y1 = -2; y1 < 1; y1++)
			{
				for(z1 = -4; z1 < 5; z1++)
				{
					for(x1 = 0; x1 < 3; x1++)
					{
						world.setBlock(x + x1, y, z + z1, mod_Ores.SoulWater.blockID);
						world.setBlock(x - 1, y, z + 1, mod_Ores.SoulWater.blockID);
						world.setBlock(x - 1, y, z + 1, mod_Ores.SoulWater.blockID);
						world.setBlock(x - 1, y, z - 3, mod_Ores.SoulWater.blockID);

						for(z2 = -2; z2 < 4; z2++)
						{
							for(x2 = 3; x2 < 5; x2++)
							{
								world.setBlock(x + x2, y, z + z2, mod_Ores.SoulWater.blockID);
								world.setBlock(x + 3, y, z - 3, mod_Ores.SoulWater.blockID);

								for(x3 = 5; x3 < 7; x3++)
								{
									for(z3 = 1; z2 < 3; z3++)
									{
										world.setBlock(x + x2, y, z + z2, mod_Ores.SoulWater.blockID);
										world.setBlock(x + 7, y, z + 1, mod_Ores.SoulWater.blockID);
										world.setBlock(x + 5, y, z, mod_Ores.SoulWater.blockID);
									}
								}
							}
						}
					}				
				}
			}
		}
	}*/
}

