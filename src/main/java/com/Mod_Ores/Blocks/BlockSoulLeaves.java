package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockSoulLeaves extends BlockLeaves implements IScollectable{
    
    private Block sapling;
    private String unlName;
    private IIcon icon;
    
    /**
     * 
     * @param id The block ID
     * @param unlName this is the Unlocalized name
     * @param InGname this is the in game name
     * @param Hardness this is the blocks hardness
     * @param Resistance this is the blocks resistance
     */
    public BlockSoulLeaves(String unlName, float Hardness, float Resistance){
	super();
	this.setTickRandomly(true);
	this.setCreativeTab(soul_forest.tabSoulBerries);
	this.setHardness(Hardness); // Default 3.0F
	this.setResistance(Resistance); // Default 2F
	this.setLightOpacity(1);
	this.setStepSound(soundTypeGrass);
	GameRegistry.registerBlock(this, unlName);
	this.setBlockName(unlName);
	this.unlName = unlName;
    }
    
    public Block setSapling(Block sapling){
	this.sapling = sapling;
	return this.sapling;
    }
    
    @Override
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_){
	return 0xFFFFFF;
    }

    public int idDropped(int par1, Random random, int par2){
	return -1;
    }
    
    @Override
    public int quantityDropped(Random p_149745_1_){
        return p_149745_1_.nextInt(20) == 0 ? 1 : 0;
    }
    
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
	System.out.println("OI");
        return Item.getItemFromBlock(this.sapling);
    }

    @Override
    public boolean isCollectable(ItemStack item, World world, int x, int y, int z){
	return true;
    }

    @Override
    public ArrayList<ItemStack> onCollected(ItemStack item, World world, int x, int y, int z, int fortune){
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
	return ret;
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
	return this.icon;
    }
    
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
	this.icon = par1IconRegister.registerIcon("soulforest:" + this.unlName);
    }

    @Override
    public String[] func_150125_e() {
	// TODO Auto-generated method stub
	return null;
    }
}