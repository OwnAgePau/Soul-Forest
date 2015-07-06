package com.Mod_Ores.Blocks.Special;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class SoulVine extends Block implements IScollectable
{
    private int dropQuantity;
    /**
     * This is the constructor for a soul vine
     * @param par1blockID, the blocks id
     * @param par2dropID, the blocks drop id
     * @param par3dropQuantity, the quantity of the blocks drop
     * @param par4Name, the Unlocalized Name of the block
     * @param par5Name, the In game Name of the block
     */
    public SoulVine(int par3dropQuantity, String par4Name)
    {
	super(Material.vine);
	this.dropQuantity = par3dropQuantity;
	this.setTickRandomly(true);
	this.setCreativeTab(soul_forest.tabSoulBerries);
	this.setHardness(0.2F);
	this.setStepSound(Block.soundTypeGrass);  
	GameRegistry.registerBlock(this, par4Name);
	setBlockName(par4Name);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
	return 20;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
	return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
	return false;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
	float f = 0.0625F;
	int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_);
	float f1 = 1.0F;
	float f2 = 1.0F;
	float f3 = 1.0F;
	float f4 = 0.0F;
	float f5 = 0.0F;
	float f6 = 0.0F;
	boolean flag = l > 0;

	if ((l & 2) != 0)
	{
	    f4 = Math.max(f4, 0.0625F);
	    f1 = 0.0F;
	    f2 = 0.0F;
	    f5 = 1.0F;
	    f3 = 0.0F;
	    f6 = 1.0F;
	    flag = true;
	}

	if ((l & 8) != 0)
	{
	    f1 = Math.min(f1, 0.9375F);
	    f4 = 1.0F;
	    f2 = 0.0F;
	    f5 = 1.0F;
	    f3 = 0.0F;
	    f6 = 1.0F;
	    flag = true;
	}

	if ((l & 4) != 0)
	{
	    f6 = Math.max(f6, 0.0625F);
	    f3 = 0.0F;
	    f1 = 0.0F;
	    f4 = 1.0F;
	    f2 = 0.0F;
	    f5 = 1.0F;
	    flag = true;
	}

	if ((l & 1) != 0)
	{
	    f3 = Math.min(f3, 0.9375F);
	    f6 = 1.0F;
	    f1 = 0.0F;
	    f4 = 1.0F;
	    f2 = 0.0F;
	    f5 = 1.0F;
	    flag = true;
	}

	if (!flag && this.canPlaceOnBlock(p_149719_1_.getBlock(p_149719_2_, p_149719_3_ + 1, p_149719_4_)))
	{
	    f2 = Math.min(f2, 0.9375F);
	    f5 = 1.0F;
	    f1 = 0.0F;
	    f4 = 1.0F;
	    f3 = 0.0F;
	    f6 = 1.0F;
	}

	this.setBlockBounds(f1, f2, f3, f4, f5, f6);
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
     * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
     */

    @Override
    public boolean canPlaceBlockOnSide(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_)
    {
	switch (p_149707_5_)
	{
	case 1:
	    return this.canPlaceOnBlock(p_149707_1_.getBlock(p_149707_2_, p_149707_3_ + 1, p_149707_4_));
	case 2:
	    return this.canPlaceOnBlock(p_149707_1_.getBlock(p_149707_2_, p_149707_3_, p_149707_4_ + 1));
	case 3:
	    return this.canPlaceOnBlock(p_149707_1_.getBlock(p_149707_2_, p_149707_3_, p_149707_4_ - 1));
	case 4:
	    return this.canPlaceOnBlock(p_149707_1_.getBlock(p_149707_2_ + 1, p_149707_3_, p_149707_4_));
	case 5:
	    return this.canPlaceOnBlock(p_149707_1_.getBlock(p_149707_2_ - 1, p_149707_3_, p_149707_4_));
	default:
	    return false;
	}
    }

    /**
     * returns true if a vine can be placed on that block (checks for render as normal block and if it is solid)
     */
    private boolean canPlaceOnBlock(Block p_150093_1_)
    {
	return p_150093_1_.renderAsNormalBlock() && p_150093_1_.getMaterial().blocksMovement();
    }

    /**
     * Returns if the vine can stay in the world. It also changes the metadata according to neighboring blocks.
     */
    private boolean canVineStay(World par1World, int par2, int par3, int par4)
    {
	int l = par1World.getBlockMetadata(par2, par3, par4);
	int i1 = l;

	if (l > 0)
	{
	    for (int j1 = 0; j1 <= 3; ++j1)
	    {
		int k1 = 1 << j1;

		if ((l & k1) != 0 && !this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[j1], par3, par4 + Direction.offsetZ[j1]) && (par1World.getBlock(par2, par3 + 1, par4) != this || (par1World.getBlockMetadata(par2, par3 + 1, par4) & k1) == 0))
		{
		    i1 &= ~k1;
		}
	    }
	}

	if (i1 == 0 && !this.canPlaceBlockAt(par1World, par2, par3 + 1, par4))
	{
	    return false;
	}
	else
	{
	    if (i1 != l)
	    {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, i1, 2);
	    }

	    return true;
	}
    }

    /*@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    /*public int getRenderColor(int par1)
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    /*public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return par1IBlockAccess.getBiomeGenForCoords(par2, par4).getBiomeFoliageColor();
    }*/

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
	if (!par1World.isRemote && !this.canVineStay(par1World, par2, par3, par4))
	{
	    this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
	    par1World.setBlockToAir(par2, par3, par4);
	}
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
	if (!par1World.isRemote && par1World.rand.nextInt(4) == 0)
	{
	    byte b0 = 4;
	    int l = 5;
	    boolean flag = false;
	    int i1;
	    int j1;
	    int k1;
	    label138:

		for (i1 = par2 - b0; i1 <= par2 + b0; ++i1)
		{
		    for (j1 = par4 - b0; j1 <= par4 + b0; ++j1)
		    {
			for (k1 = par3 - 1; k1 <= par3 + 1; ++k1)
			{
			    if (par1World.getBlock(i1, k1, j1) == this)
			    {
				--l;

				if (l <= 0)
				{
				    flag = true;
				    break label138;
				}
			    }
			}
		    }
		}

	    i1 = par1World.getBlockMetadata(par2, par3, par4);
	    j1 = par1World.rand.nextInt(6);
	    k1 = Direction.facingToDirection[j1];
	    int l1 = 0;
	    int i2;

	    if (j1 == 1 && par3 < 255 && par1World.isAirBlock(par2, par3 + 1, par4))
	    {
		if (flag)
		{
		    return;
		}

		l1 = par1World.rand.nextInt(16) & i1;

		if (l1 > 0)
		{
		    for (i2 = 0; i2 <= 3; ++i2)
		    {
			if (!this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[i2], par3 + 1, par4 + Direction.offsetZ[i2]))
			{
			    l1 &= ~(1 << i2);
			}
		    }

		    if (l1 > 0)
		    {
			par1World.setBlock(par2, par3 + 1, par4, this, l1, 2);
		    }
		}
	    }
	    else
	    {
		int j2;

		if (j1 >= 2 && j1 <= 5 && (i1 & 1 << k1) == 0)
		{
		    if (flag)
		    {
			return;
		    }

		    Block i4 = par1World.getBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1]);

		    if (l1 != 0 && i4 != null)
		    {
			if (i4.getMaterial().isOpaque() && i4.renderAsNormalBlock())
			{
			    par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 | 1 << k1, 2);
			}
		    }
		    else
		    {
			i2 = k1 + 1 & 3;
			j2 = k1 + 3 & 3;

			if ((i1 & 1 << i2) != 0 && this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[k1] + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[i2]))
			{
			    par1World.setBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1], this, 1 << i2, 2);
			}
			else if ((i1 & 1 << j2) != 0 && this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[k1] + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[j2]))
			{
			    par1World.setBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1], this, 1 << j2, 2);
			}
			else if ((i1 & 1 << i2) != 0 && par1World.isAirBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[i2]) && this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[i2]))
			{
			    par1World.setBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[i2], this, 1 << (k1 + 2 & 3), 2);
			}
			else if ((i1 & 1 << j2) != 0 && par1World.isAirBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[j2]) && this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[j2]))
			{
			    par1World.setBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[j2], this, 1 << (k1 + 2 & 3), 2);
			}
			else if (this.canPlaceBlockAt(par1World, par2 + Direction.offsetX[k1], par3 + 1, par4 + Direction.offsetZ[k1]))
			{
			    par1World.setBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1], this, 0, 2);
			}
		    }
		}
		else if (par3 > 1)
		{
		    for (l = 1; par1World.getBlock(par2, par3 + l, par4) == this; ++l)
		    {
			;
		    }

		    if (l < 10)
		    {
			Block l11 = par1World.getBlock(par2, par3 - 1, par4);

			if (l11.isAir(par1World, par2, par3 - 1, par4))
			{
			    i2 = par1World.rand.nextInt(16) & i1;

			    if (i2 > 0)
			    {
				par1World.setBlock(par2, par3 - 1, par4, this, i2, 2);                            
			    }
			}
			else if (l11 == this)
			{
			    i2 = par1World.rand.nextInt(16) & i1;
			    j2 = par1World.getBlockMetadata(par2, par3 - 1, par4);

			    if (j2 != (j2 | i2))
			    {
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j2 | i2, 2);
			    }
			}
		    }
		}
	    }
	}
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
	byte b0 = 0;

	switch (par5)
	{
	case 2:
	    b0 = 1;
	    break;
	case 3:
	    b0 = 4;
	    break;
	case 4:
	    b0 = 8;
	    break;
	case 5:
	    b0 = 2;
	}

	return b0 != 0 ? b0 : par9;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
	return 0;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
	return 0;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
	super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
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
	ret.add(new ItemStack(this, this.dropQuantity, 0));       
	return ret;
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase enitityliving)
    {
	return false;
    }
}
