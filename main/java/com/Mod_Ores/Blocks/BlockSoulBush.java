package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulBush extends BlockFlower implements IScollectable{
    private static final String[] grassTypes = new String[] {"Bush"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BlockSoulBush(String Unlname){
	super(0);
	float f = 0.4F;
	this.setStepSound(soundTypeGrass);
	this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
	this.setCreativeTab(soul_forest.tabSoulBerries);
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2){
	if (par2 >= this.iconArray.length){
	    par2 = 0;
	}

	return this.iconArray[par2];
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4){
	Block block = par1World.getBlock(par2, par3 - 1, par4);
	if(block != null){
	    if(block.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this))
		return true;   
	}
	else{
	    return false;
	}

	return block.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this);
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z){
	return true;
    }
    
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant){
	return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
	this.checkBlockCoordValid(par1World, par2, par3, par4);
    }

    /**
     * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
     */
    protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4){
	if (!this.canBlockStay(par1World, par2, par3, par4)){
	    //this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	    par1World.setBlockToAir(par2, par3, par4);
	}
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4){
	return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    public static EnumPlantType getPlantType(World world, int x, int y, int z){
	return EnumPlantType.Cave;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3){
	return -1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random){
	return 0;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6){
	super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }

    /*@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    @SideOnly(Side.CLIENT)*/

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    /*public int getRenderColor(int par1)
    {
        return 0;
    }*/

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
	int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	return l == 0 ? 16777215 : par1IBlockAccess.getBiomeGenForCoords(par2, par4).getBiomeGrassColor(par2, par3, par4);
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
	for (int j = 1; j < 2; ++j){
	    par3List.add(new ItemStack(par1, 1, j));
	}
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
	this.iconArray = new IIcon[2];
	for (int i = 0; i < this.iconArray.length; ++i)
	{
	    this.iconArray[i] = par1IconRegister.registerIcon("soulforest:Bush");
	}
    }

    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune){
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	if (world.rand.nextInt(8) != 0){
	    return ret;
	}

	ItemStack item = ForgeHooks.getGrassSeed(world);
	if (item != null){
	    ret.add(item);
	}
	return ret;
    }

    @Override
    public boolean isCollectable(ItemStack item, World world, int x, int y, int z){
	return true;
    }

    @Override
    public ArrayList<ItemStack> onCollected(ItemStack item, World world, int x, int y, int z, int fortune) {
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
	return ret;
    }
}
