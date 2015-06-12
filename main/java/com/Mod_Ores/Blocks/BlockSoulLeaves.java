package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockSoulLeaves extends BlockLeavesBase implements IScollectable
{
	/**
	 * 
	 * @param id The block ID
	 * @param Unlname this is the Unlocalized name
	 * @param InGname this is the in game name
	 * @param Hardness this is the blocks hardness
	 * @param Resistance this is the blocks resistance
	 */
	public BlockSoulLeaves(String Unlname, float Hardness, float Resistance)
    {
    	super(Material.leaves, false);
        this.setTickRandomly(true);
        this.setCreativeTab(soul_forest.tabSoulBerries);
	  	  setHardness(Hardness); // Default 3.0F
	  	  setResistance(Resistance); // Default 2F
	  	  setStepSound(soundTypeGrass);
	  	  GameRegistry.registerBlock(this, Unlname);
	  	  setBlockName(Unlname);
    }
    
    public int quanitityDropped(Random random)
    {
    	return random.nextInt(5) != 0 ? 0 : 1;
    }
    public int getRenderBlockPass()
    {
    	return 1;
    }
    public boolean isOpaqueCube()
    {
    	return false;
    }
    public String getTextureFile()
    {
            return "/mod_Ores/Blocks.png";
    }
    
    public int idDropped(int par1, Random random, int par2)
    {
    	return 0;
    }

	@Override
	public boolean isCollectable(ItemStack item, World world, int x, int y, int z)
    {
        return true;
    }

	@Override
	public ArrayList<ItemStack> onCollected(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }

}