package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSapplingGrape extends WorldGenerator
{
    /** The ID of the plant block used in this plant generator. */
    private Block plantBLock;

    public WorldGenSapplingGrape(Block par1)
    {
        this.plantBLock = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int l = 0; l < 64; ++l)
        {
            int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (par1World.isAirBlock(i1, j1, k1) && this.plantBLock.canBlockStay(par1World, i1, j1, k1) && !par1World.isAirBlock(i1, (j1 - 1), k1))
            {
            	if(par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.SoulWaterMoving.get()
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.BogTallGrassBrown.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.BogTallGrassGrey.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.BogTallGrassGreen.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.BogTallGrassPurple.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.SapplingGrape.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.PlantCantaloupe.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.GrapesLeaves.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.SoulLeaves.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.HardwoodLeaves.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.SoulLog.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.HardwoodLog.get()
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Slate.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Porphyry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Baneberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Blueberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Blackberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Cranberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Strawberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Razzberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.Raspberry.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.FyrisedSand.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.FyrisedSandGrass.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.SoulSnowTop.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.SoulSnowBottom.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.FrozenGrass.get() 
            			&& par1World.getBlock(i1, j1 - 1, k1) != SoulBlocks.FrozenTallGrass.get())
            	{
	            	par1World.setBlock(i1, j1, k1, this.plantBLock, 0, 2);
            	}
            }
        }

        return true;
    }
}
