package com.Mod_Ores.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class BlockSoulDirt extends Block{
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockSoulDirt(String Unlname){
		super(Material.ground);
		this.setCreativeTab(soul_forest.tabSoulBlocks);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		GameRegistry.registerBlock(this, Unlname);
		this.textureName = Unlname;
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face){
		if(this == SoulBlocks.FyrisedSand.get()){
		    return true;
		    //return getFlammability(world, x, y, z, metadata, face) > 0;
		}       
		else{
		    return false;
		}
    }      

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant){
		if(plant != Block.getBlockFromName("yellow_flower") || plant != Block.getBlockFromName("red_flower")){
		    return true;
		}
		else{
		    return false;
		}
    }
}