package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulShrub extends WorldGenerator
{
    private Block block;
    private int meta;

    public WorldGenSoulShrub(Block par1)
    {
        this.block = par1;
        this.meta = 0;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	if(par4 < 35){
    		return false;
    	}
    	while (true)
        {
            if (par4 > 3)
            {
                label63:
                {
                    if (!par1World.isAirBlock(par3, par4 - 1, par5))
                    {
                        Block block = par1World.getBlock(par3, par4 - 1, par5);

                        if (block == SoulBlocks.LateriteGrass.get() || block == SoulBlocks.LateriteDirt.get() || block == SoulBlocks.Porphyry.get() || block == SoulBlocks.Slate.get())
                        {
                            break label63;
                        }
                    }

                    --par4;
                    continue;
                }
            }

            if (par4 <= 3)
            {
                return false;
            }

            int k2 = this.meta;

            for (int l = 0; k2 >= 0 && l < 3; ++l)
            {
                int i1 = k2 + par2Random.nextInt(2);
                int j1 = k2 + par2Random.nextInt(2);
                int k1 = k2 + par2Random.nextInt(2);
                float f = (float)(i1 + j1 + k1) * 0.333F + 0.5F;

                for (int l1 = par3 - i1; l1 <= par3 + i1; ++l1)
                {
                    for (int i2 = par5 - k1; i2 <= par5 + k1; ++i2)
                    {
                        for (int j2 = par4 - j1; j2 <= par4 + j1; ++j2)
                        {
                            float f1 = (float)(l1 - par3);
                            float f2 = (float)(i2 - par5);
                            float f3 = (float)(j2 - par4);

                            if (f1 * f1 + f2 * f2 + f3 * f3 <= f * f)
                            {
                            	if(par1World.getBlock(l1, j2, i2) != SoulBlocks.SoulWaterMoving.get() && j2 > 35){
                            		par1World.setBlock(l1, j2, i2, this.block, 0, 4);
                            	}
                            }
                        }
                    }
                }

                par3 += -(k2 + 1) + par2Random.nextInt(2 + k2 * 2);
                par5 += -(k2 + 1) + par2Random.nextInt(2 + k2 * 2);
                par4 += 0 - par2Random.nextInt(2);
            }

            return true;
        }
    }
}
