package com.Mod_Ores.Blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;




import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFrozenGrass extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon iconBogTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSnowSide;
    @SideOnly(Side.CLIENT)
    private IIcon iconBogSideOverlay;

    public BlockFrozenGrass(String Unlname)
    {
	super(Material.grass);
	this.setTickRandomly(true);
	this.slipperiness = 0.98F;
	this.setCreativeTab(soul_forest.tabSoulBlocks);
	this.setStepSound(soundTypeGrass);
	this.setHardness(0.2F);
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int par1, int par2)
    {
	return par1 == 1 ? this.iconBogTop : (par1 == 0 ?  SoulBlocks.BogDirt.get().getBlockTextureFromSide(par1) : this.blockIcon);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
	if(plant != Block.getBlockFromName("yellow_flower") || plant != Block.getBlockFromName("red_flower"))
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
	if (!par1World.isRemote)
	{
	    if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
	    {
		par1World.setBlock(par2, par3, par4, SoulBlocks.BogDirt.get());
	    }
	    else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	    {
		for (int l = 0; l < 4; ++l)
		{
		    int i1 = par2 + par5Random.nextInt(3) - 1;
		    int j1 = par3 + par5Random.nextInt(5) - 3;
		    int k1 = par4 + par5Random.nextInt(3) - 1;
		    Block l1 = par1World.getBlock(i1, j1 + 1, k1);

		    if (par1World.getBlock(i1, j1, k1) == SoulBlocks.BogDirt.get() && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
		    {
			par1World.setBlock(i1, j1, k1, SoulBlocks.BogDirt.get());
		    }
		}
	    }
	}
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulBlocks.BogDirt.get().blockID;
    }*/

    @SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
	if (par5 == 1)
	{
	    return this.iconBogTop;
	}
	else if (par5 == 0)
	{
	    return SoulBlocks.BogDirt.get().getBlockTextureFromSide(par5);
	}
	else
	{
	    Material material = par1IBlockAccess.getBlock(par2, par3 + 1, par4).getMaterial();
	    return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
	}
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
	this.blockIcon = par1IconRegister.registerIcon("soulforest:Frozen_grass");
	this.iconBogTop = par1IconRegister.registerIcon("soulforest:Frozen_grass_top");
	this.iconSnowSide = par1IconRegister.registerIcon("soulforest:Frozen_grass");
	this.iconBogSideOverlay = par1IconRegister.registerIcon("soulforest:Frozen_grass");
    }
}

