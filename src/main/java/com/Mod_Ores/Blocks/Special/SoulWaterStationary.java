package com.Mod_Ores.Blocks.Special;

import com.Mod_Ores.Init.SoulBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SoulWaterStationary extends BlockStaticLiquid
{
    private IIcon[] theIcon;

	public SoulWaterStationary(String Unlname)
    {
        super(Material.water);
        this.setTickRandomly(true);
        this.blockHardness = 100F;
        this.setLightLevel(0);
        this.disableStats();
		GameRegistry.registerBlock(this, Unlname);
		setBlockName(Unlname);
    }

    @Override
    public int getRenderType()
    {
    	return 4;
    }
    
	/*@Override
	public int stillLiquidId() 
	{
		return this.blockID + 1;
	}

	@Override
	public boolean isMetaSensitive() 
	{
		return false;
	}

	@Override
	public int stillLiquidMeta() 
	{
		return 0;
	}*/
	
	@Override
	public void registerBlockIcons(IIconRegister iconReg)
	{
		this.theIcon = new IIcon[] {iconReg.registerIcon("soulforest:Soul_Water"), iconReg.registerIcon("soulforest:Soul_Water_Flow")};
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.theIcon[0];
    }
    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    @Override
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);

        if (p_149695_1_.getBlock(p_149695_2_, p_149695_3_, p_149695_4_) == this)
        {
            this.setNotStationary(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
        }
    }

    /**
     * Changes the block ID to that of an updating fluid.
     */
    private void setNotStationary(World p_149818_1_, int p_149818_2_, int p_149818_3_, int p_149818_4_)
    {
        int l = p_149818_1_.getBlockMetadata(p_149818_2_, p_149818_3_, p_149818_4_);
        p_149818_1_.setBlock(p_149818_2_, p_149818_3_, p_149818_4_, Block.getBlockById(Block.getIdFromBlock(this) - 1), l, 2);
        p_149818_1_.scheduleBlockUpdate(p_149818_2_, p_149818_3_, p_149818_4_, Block.getBlockById(Block.getIdFromBlock(this) - 1), this.tickRate(p_149818_1_));
    }
    
	/*@Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);       
        if(par1World.isAirBlock(par2, par3 + 1, par4))
        {
	    	if(par1World.getBiomeGenForCoords(par2, par3).biomeName == "Frozen Plains" || par1World.getBiomeGenForCoords(par2, par3).biomeName == "Frost Caves")
	        {
	            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	            
	            if(par5Random.nextInt(2) == 0)
	            {
	            	System.out.println("[Soul Forest] Ice");
	            	par1World.setBlock(par2, par3, par4, SoulConfig.soulIceID);
	            	
	            }
	        }
        }
    }*/
}
