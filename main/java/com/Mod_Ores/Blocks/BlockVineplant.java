package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVineplant extends Block implements IPlantable
{
    private static Icon iconTop;
    private static Icon iconBottom;

    public BlockVineplant(String Unlname)
    {
	super(Material.plants);
	float f = 0.375F;
	this.setStepSound(soundTypeGrass);
	this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
	this.setTickRandomly(true);
	setCreativeTab(soul_forest.tabSoulBerries);
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
	if (par1World.isAirBlock(par2, par3 + 1, par4))
	{
	    int l;

	    for (l = 1; par1World.getBlock(par2, par3 - l, par4) == SoulBlocks.Vineplant.get(); ++l)
	    {
		;
	    }

	    if (l == 0 || l == 1)
	    {
		par1World.setBlock(par2, par3 + 1, par4, SoulBlocks.Vineplant.get());
	    }
	    if (l == 2)
	    {
		par1World.setBlock(par2, par3 + 1, par4, SoulBlocks.VineplantTop.get());
	    }
	}
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
	Block block = par1World.getBlock(par2, par3 - 1, par4);
	if(block.isAir(par1World, par2, par3 - 1, par4)){
	    return false;
	}
	return block == SoulBlocks.BogGrass.get() || block == SoulBlocks.BogDirt.get() || block == SoulBlocks.Vineplant.get();
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block p_149695_5_){
	this.checkBlockCoordValid(par1World, par2, par3, par4);
    }

    /**
     * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
     */
    protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4)
    {
	if (!this.canBlockStay(par1World, par2, par3, par4))
	{
	    this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	    par1World.setBlockToAir(par2, par3, par4);
	}
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
	return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
	return null;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulItems.ItemVineplant.get();
    }*/

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
	return false;
    }



    @Override
    public boolean isBlockSolid(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) 
    {
	return true;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
	return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
	return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    @Override
    public ArrayList<ItemStack> getDrops(World par1World, int par2, int par3, int par4, int metadata, int fortune)
    {
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	ret.add(new ItemStack(SoulItems.ItemVineplant.get(), 1, damageDropped(metadata)));
	return ret;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
	return EnumPlantType.Cave;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
	return this;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
	return world.getBlockMetadata(x, y, z);
    }
}
