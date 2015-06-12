package com.Mod_Ores.Blocks.Special;

import java.util.Random;

import com.Mod_Ores.soul_forest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SoulBlock extends Block
{
	/**
	 * Decoration Block Constructor
	 * @param id this is the Block ID
	 * @param Unlname This is the Unlocalized Name
	 * @param InGname This is the Name that you will see In game
	 * @param Hardness sets the hardness of the block
	 * @param Resistance sets the resistance of the block
	 * @param LightValue sets the blocks light value
	 * @param Material
	 */
	 public SoulBlock(String Unlname, float Hardness, float Resistance, Boolean LightValue, Material mat) //id - item ID, UName - Unlocalized Name, IGName - IngameName
	 {
		  super(mat); //This super will load item ID and UName
		  setCreativeTab(soul_forest.tabSoulBlocks); //Set Tab in ModBase.class and place it here (with many items its VERY code-shortening), this will load unlocalized name
		  setHardness(Hardness); // Default 3.0F
		  setResistance(Resistance); // Default 2F
		  
		  if(LightValue == true)
		  {
			  setLightLevel(1F); // Default 1F
		  }
		  
		  setStepSound(Block.soundTypeMetal);
		  GameRegistry.registerBlock(this, Unlname);
		  setBlockName(Unlname);
	 }
	 
	 /*@Override
	 public int idDropped(int par1, Random random, int par2)
	 {
	    return this.blockID;
	 }*/
	 
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) 
	{
	    return false;
	}
}