package com.Mod_Ores.Blocks.Special;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSoulSlab extends SoulSlab
{
    public static final String[] TEXTURES = new String[] {"titanium_brick", "porphyry_brick", "slate_brick", "bauxitebrick", "icebrick"};
    @SideOnly(Side.CLIENT)
    private IIcon icon;
    private static final String __OBFID = "CL_00000320";
    private IIcon[] iconArray = new IIcon[1];

    public BlockSoulSlab(boolean p_i45431_1_, String unlName){
        super(p_i45431_1_, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName(unlName);
	this.setStepSound(soundTypeStone);
	this.setCreativeTab(soul_forest.tabSoulBlocks);
	this.setHardness(4.0F);
    }

    @Override
    public int damageDropped(int meta) {
	return meta;
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int par1, int par2){
	if (par2 > this.iconArray.length){
	    par2 = 0;
	}
	return this.iconArray[par2];
    }
    
    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World par1World, int par2, int par3, int par4){
	return par1World.getBlockMetadata(par2, par3, par4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List){
	for (int j = 0; j < this.TEXTURES.length; ++j){
	    par3List.add(new ItemStack(par1, 1, j));
	}
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
	this.iconArray = new IIcon[this.TEXTURES.length];
	for (int i = 0; i < this.iconArray.length; ++i){
	    this.iconArray[i] = par1IconRegister.registerIcon(soul_forest.MODID + ":" + TEXTURES[i]);
	}
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
        return Item.getItemFromBlock(this);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    @Override
    protected ItemStack createStackedBlock(int p_149644_1_){
	System.out.println(p_149644_1_);
        return new ItemStack(SoulBlocks.SoulDoubleSlab.get(), 2, p_149644_1_ & 7);
    }

    public String func_150002_b(int p_150002_1_)
    {
        if (p_150002_1_ < 0 || p_150002_1_ >= TEXTURES.length)
        {
            p_150002_1_ = 0;
        }

        return super.getUnlocalizedName() + "." + TEXTURES[p_150002_1_];
    }
}