package com.Mod_Ores.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockSoulDirt extends Block
{
    public BlockSoulDirt(String Unlname)
    {
        super(Material.ground);
        this.setCreativeTab(soul_forest.tabSoulBlocks);
		GameRegistry.registerBlock(this, Unlname);
		setBlockName(Unlname);
    }
    
    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        if(this == SoulBlocks.FyrisedSand.get())
        {
        	return true;
        	//return getFlammability(world, x, y, z, metadata, face) > 0;
        }       
        else
        {
        	return false;
        }
    }      
    
    @Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant){
    	if(plant != Block.getBlockFromName("yellow_flower") || plant != Block.getBlockFromName("red_flower"))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
	}

}