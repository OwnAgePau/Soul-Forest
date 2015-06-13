package com.Mod_Ores.BiomeGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.Blocks.BlockSoulSappling;
import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenGrapeTree extends WorldGenAbstractTree
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;
    private static final String __OBFID = "CL_00000438";

    public WorldGenGrapeTree(boolean par1)
    {
	this(par1, 5, 0, 0, false);
    }

    public WorldGenGrapeTree(boolean par1, int par2, int par3, int par4, boolean par5)
    {
	super(par1);
	this.minTreeHeight = par2;
	this.metaWood = par3;
	this.metaLeaves = par4;
	this.vinesGrow = par5;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
	int l = par2Random.nextInt(5) + this.minTreeHeight;
	boolean flag = true;

	if (par4 >= 1 && par4 + l + 1 <= 256)
	{
	    byte b0;
	    int k1;
	    Block block;

	    for (int i1 = par4; i1 <= par4 + 1 + l; ++i1)
	    {
		b0 = 1;

		if (i1 == par4)
		{
		    b0 = 0;
		}

		if (i1 >= par4 + 1 + l - 2)
		{
		    b0 = 2;
		}

		for (int j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1)
		{
		    for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1)
		    {
			if (i1 >= 0 && i1 < 256)
			{
			    block = par1World.getBlock(j1, i1, k1);

			    if (!this.isReplaceable(par1World, j1, i1, k1))
			    {
				flag = false;
			    }
			}
			else
			{
			    flag = false;
			}
		    }
		}
	    }

	    if (!flag)
	    {
		return false;
	    }
	    else
	    {
		Block block2 = par1World.getBlock(par3, par4 - 1, par5);

		boolean isSoil = block2.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSoulSappling)SoulBlocks.SapplingGrape.get());
		if (isSoil && par4 < 256 - l - 1)
		{
		    block2.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
		    b0 = 3;
		    byte b1 = 0;
		    int l1;
		    int i2;
		    int j2;
		    int i3;

		    for (k1 = par4 - b0 + l; k1 <= par4 + l; ++k1)
		    {
			i3 = k1 - (par4 + l);
			l1 = b1 + 1 - i3 / 2;

			for (i2 = par3 - l1; i2 <= par3 + l1; ++i2)
			{
			    j2 = i2 - par3;

			    for (int k2 = par5 - l1; k2 <= par5 + l1; ++k2)
			    {
				int l2 = k2 - par5;

				if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || par2Random.nextInt(2) != 0 && i3 != 0)
				{
				    Block block1 = par1World.getBlock(i2, k1, k2);

				    if (block1.isAir(par1World, i2, k1, k2) || block1.isLeaves(par1World, i2, k1, k2))
				    {
					this.setBlockAndNotifyAdequately(par1World, i2, k1, k2, SoulBlocks.GrapesLeaves.get(), this.metaLeaves);
				    }
				}
			    }
			}
		    }

		    for (k1 = 0; k1 < l; ++k1)
		    {
			block = par1World.getBlock(par3, par4 + k1, par5);

			if (block.isAir(par1World, par3, par4 + k1, par5) || block.isLeaves(par1World, par3, par4 + k1, par5))
			{
			    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5, SoulBlocks.SoulLog.get(), this.metaWood);

			    if (this.vinesGrow && k1 > 0)
			    {
				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 - 1, par4 + k1, par5))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3 - 1, par4 + k1, par5, SoulBlocks.Baneberry.get(), 2);
				}

				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 1, par4 + k1, par5))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3 + 1, par4 + k1, par5, SoulBlocks.Blackberry.get(), 2);
				}

				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + k1, par5 - 1))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 - 1, SoulBlocks.Blueberry.get(), 1);
				}

				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + k1, par5 + 1))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 + 1, SoulBlocks.Cranberry.get(), 1);
				}
				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + k1, par5 + 1))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 + 1, SoulBlocks.Razzberry.get(), 1);
				}
				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + k1, par5 + 1))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 + 1, SoulBlocks.Raspberry.get(), 2);
				}
				if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + k1, par5 + 1))
				{
				    this.setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 + 1, SoulBlocks.Strawberry.get(), 8);
				}
			    }
			}
		    }

		    if (this.vinesGrow)
		    {
			for (k1 = par4 - 3 + l; k1 <= par4 + l; ++k1)
			{
			    i3 = k1 - (par4 + l);
			    l1 = 2 - i3 / 2;

			    for (i2 = par3 - l1; i2 <= par3 + l1; ++i2)
			    {
				for (j2 = par5 - l1; j2 <= par5 + l1; ++j2)
				{
				    if (par1World.getBlock(i2, k1, j2).isLeaves(par1World, i2, k1, j2))
				    {
					if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2 - 1, k1, j2).isAir(par1World, i2 - 1, k1, j2))
					{
					    this.growVines(par1World, i2 - 1, k1, j2, 8);
					}

					if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2 + 1, k1, j2).isAir(par1World, i2 + 1, k1, j2))
					{
					    this.growVines1(par1World, i2 + 1, k1, j2, 2);
					}

					if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2, k1, j2 - 1).isAir(par1World, i2, k1, j2 - 1))
					{
					    this.growVines2(par1World, i2, k1, j2 - 1, 1);
					}
					if (par2Random.nextInt(4) == 1 && par1World.getBlock(i2, k1, j2 - 1).isAir(par1World, i2, k1, j2 - 1))
					{
					    this.growVines3(par1World, i2, k1, j2 - 1, 1);
					}

					if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2, k1, j2 + 1).isAir(par1World, i2, k1, j2 + 1))
					{
					    this.growVines4(par1World, i2, k1, j2 + 1, 4);
					}
					if (par2Random.nextInt(4) == 1 && par1World.getBlock(i2, k1, j2 + 1).isAir(par1World, i2, k1, j2 + 1))
					{
					    this.growVines5(par1World, i2, k1, j2 + 1, 4);
					}
				    }
				}
			    }
			}

			if (par2Random.nextInt(5) == 0 && l > 5)
			{
			    for (k1 = 0; k1 < 2; ++k1)
			    {
				for (i3 = 0; i3 < 4; ++i3)
				{
				    if (par2Random.nextInt(4 - k1) == 0)
				    {
					l1 = par2Random.nextInt(3);
					this.setBlockAndNotifyAdequately(par1World, par3 + Direction.offsetX[Direction.rotateOpposite[i3]], par4 + l - 5 + k1, par5 + Direction.offsetZ[Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
				    }
				}
			    }
			}
		    }

		    return true;
		}
		else
		{
		    return false;
		}
	    }
	}
	else
	{
	    return false;
	}
    }

    /**
     * Grows vines downward from the given block for a given length. Args: World, x, starty, z, vine-length
     */
     private void growVines(World par1World, int par2, int par3, int par4, int par5)
    {
	this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Baneberry.get(), par5);
	int i1 = 4;

	while (true)
	{
	    --par3;

	    if (par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4) || i1 <= 0)
	    {
		return;
	    }

	    this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Baneberry.get(), par5);
	    --i1;

	}
    }

     private void growVines1(World par1World, int par2, int par3, int par4, int par5)
     {
	 this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Blueberry.get(), par5);
	 int i3 = 4;

	 while (true)
	 {
	     --par3;

	     if (par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4) || i3 <= 0)
	     {
		 return;
	     }

	     this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Blueberry.get(), par5);
	     --i3;
	 }

     }


     private void growVines2(World par1World, int par2, int par3, int par4, int par5)
     {
	 this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Cranberry.get(), par5);
	 int i4 = 4;

	 while (true)
	 {
	     --par3;

	     if (par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4) || i4 <= 0)
	     {
		 return;
	     }

	     this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Cranberry.get(), par5);
	     --i4;
	 }
     }


     private void growVines3(World par1World, int par2, int par3, int par4, int par5)
     {
	 this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Raspberry.get(), par5);
	 int i5 = 4;

	 while (true)
	 {
	     --par3;

	     if (par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4) || i5 <= 0)
	     {
		 return;
	     }

	     this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Raspberry.get(), par5);
	     --i5;
	 }
     }

     private void growVines4(World par1World, int par2, int par3, int par4, int par5)
     {
	 this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Razzberry.get(), par5);
	 int i6 = 4;

	 while (true)
	 {
	     --par3;

	     if (par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4) || i6 <= 0)
	     {
		 return;
	     }

	     this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Razzberry.get(), par5);
	     --i6;
	 }
     }

     private void growVines5(World par1World, int par2, int par3, int par4, int par5){
	 this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Strawberry.get(), par5);
	 int i7 = 4;

	 while (true)
	 {
	     --par3;

	     if (par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4) || i7 <= 0)
	     {
		 return;
	     }

	     this.setBlockAndNotifyAdequately(par1World, par2, par3, par4, SoulBlocks.Strawberry.get(), par5);
	     --i7;
	 }
     }
}