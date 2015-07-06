package com.Mod_Ores.BiomeGen.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulWaterfalls extends WorldGenerator
{
    /** Stores the ID for WorldGenHellLava */
    private Block block;
    private Block water;
    private boolean field_94524_b;

    public WorldGenSoulWaterfalls(Block par1, Block par2, boolean par3)
    {
        this.water = par1;
        this.field_94524_b = par3;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        if (par1World.getBlock(par3, par4 + 1, par5) != this.block){
            return false;
        }
        else if (par1World.getBlock(par3, par4, par5).isAir(par1World, par3, par4, par5) && par1World.getBlock(par3, par4, par5) != this.block){
            return false;
        }
        else{
            int l = 0;

            if (par1World.getBlock(par3 - 1, par4, par5) == this.block){
                ++l;
            }

            if (par1World.getBlock(par3 + 1, par4, par5) == this.block){
                ++l;
            }

            if (par1World.getBlock(par3, par4, par5 - 1) == this.block){
                ++l;
            }

            if (par1World.getBlock(par3, par4, par5 + 1) == this.block){
                ++l;
            }

            if (par1World.getBlock(par3, par4 + 1, par5) == this.block){
                ++l;
            }
            
            int i1 = 0;

            /*if (par1World.isAirBlock(par3 - 1, par4, par5))
            {
                ++i1;
            }

            if (par1World.isAirBlock(par3 + 1, par4, par5))
            {
                ++i1;
            }

            if (par1World.isAirBlock(par3, par4, par5 - 1))
            {
                ++i1;
            }

            if (par1World.isAirBlock(par3, par4, par5 + 1))
            {
                ++i1;
            }*/

            if (par1World.isAirBlock(par3, par4 - 1, par5)){
                ++i1;
            }

            if (!this.field_94524_b && l == 4 && i1 == 1 || l == 5){
                par1World.setBlock(par3, par4, par5, this.water, 0, 2);
                par1World.scheduledUpdatesAreImmediate = true;
                this.water.updateTick(par1World, par3, par4, par5, par2Random);
                par1World.scheduledUpdatesAreImmediate = false;
            }

            return true;
        }
    }
}

