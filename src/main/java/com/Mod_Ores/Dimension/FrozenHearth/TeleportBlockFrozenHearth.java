package com.Mod_Ores.Dimension.FrozenHearth;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfig;
import com.Mod_Ores.Particles.RenderParticles;

import cpw.mods.fml.common.registry.GameRegistry;

public class TeleportBlockFrozenHearth extends BlockBreakable
{
    public TeleportBlockFrozenHearth(String Unlname)
    {
	super("soulforest:Soulportal_inside", Material.portal, false);
	this.setCreativeTab(soul_forest.tabSoulOther);
	this.setTickRandomly(true);
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulBlocks.TurquoiseBlock.get().blockID;
    }*/

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random){
	super.updateTick(par1World, par2, par3, par4, par5Random);
    }

    /**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4){
	for(int x = 0; x < 3; x++){
	    for(int z = 0; z < 3; z++){
		if(par1World.getBlock(par2 + x, par3, par4 - 1) == SoulBlocks.TurquoiseBlock.get()){
		    System.out.println("LEUK : " + (par2 + x) + ", " + par3 + ", " + (par4 - 1));
		}
	    }
	}
	
	
	
	byte b0 = 0;
	byte b1 = 0;

	if (par1World.getBlock(par2 - 1, par3, par4) == SoulBlocks.TurquoiseBlock.get() || par1World.getBlock(par2 + 1, par3, par4) == SoulBlocks.TurquoiseBlock.get())
	{
	    b0 = 1;
	}

	if (par1World.getBlock(par2, par3, par4 - 1) == SoulBlocks.TurquoiseBlock.get() || par1World.getBlock(par2, par3, par4 + 1) == SoulBlocks.TurquoiseBlock.get())
	{
	    b1 = 1;
	}

	if (b0 == b1)
	{
	    return false;
	}
	else
	{
	    if (par1World.isAirBlock(par2 - b0, par3, par4 - b1))
	    {
		par2 -= b0;
		par4 -= b1;
	    }

	    int l;
	    int i1;

	    for (l = -1; l <= 2; ++l)
	    {
		for (i1 = -1; i1 <= 3; ++i1)
		{
		    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

		    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
		    {
			Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);
			boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);

			if (flag)
			{
			    if (j1 != SoulBlocks.TurquoiseBlock.get())
			    {
				return false;
			    }
			}
			else if (!isAirBlock && j1 != SoulBlocks.SoulFire.get())
			{
			    return false;
			}
		    }
		}
	    }

	    for (l = 0; l < 2; ++l)
	    {
		for (i1 = 0; i1 < 3; ++i1)
		{
		    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, this, 0, 2);
		}
	    }

	    return true;
	}
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5){
	if ((var5.ridingEntity == null) && (var5.riddenByEntity == null) && ((var5 instanceof EntityPlayerMP))){
	    EntityPlayerMP var6 = (EntityPlayerMP)var5;
	    //var1.getMinecraftServerInstance(); 
	    MinecraftServer mServer = MinecraftServer.getServer();

	    if (var6.timeUntilPortal > 0){
		var6.timeUntilPortal = 10;
	    } 
	    else if (var6.dimension != SoulConfig.FrozenHearthID){
		var6.timeUntilPortal = 10;
		var6.mcServer.getConfigurationManager().transferPlayerToDimension(var6, SoulConfig.FrozenHearthID, new TeleporterFrozenHearth(mServer.worldServerForDimension(SoulConfig.FrozenHearthID)));
		//var6.addStat(InitAchievements.soulForest, 1);
	    }
	    else {
		var6.timeUntilPortal = 10;
		var6.mcServer.getConfigurationManager().transferPlayerToDimension(var6, 0, new TeleporterFrozenHearth(mServer.worldServerForDimension(SoulConfig.SoulForestID)));
	    }
	}
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
	return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
	float f;
	float f1;

	if (par1IBlockAccess.getBlock(par2 - 1, par3, par4) != this && par1IBlockAccess.getBlock(par2 + 1, par3, par4) != this){
	    f = 0.125F;
	    f1 = 0.5F;
	    this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}
	else{
	    f = 0.5F;
	    f1 = 0.125F;
	    this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube(){
	return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock(){
	return false;
    }
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
	byte b0 = 0;
	byte b1 = 1;

	if (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this){
	    b0 = 1;
	    b1 = 0;
	}

	int i1;

	for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1){
	    ;
	}

	if (par1World.getBlock(par2, i1 - 1, par4) != SoulBlocks.TurquoiseBlock.get()){
	    par1World.setBlockToAir(par2, par3, par4);
	}
	else{
	    int j1;

	    for (j1 = 1; j1 < 4 && par1World.getBlock(par2, i1 + j1, par4) == this; ++j1){
		;
	    }

	    if (j1 == 3 && par1World.getBlock(par2, i1 + j1, par4) == SoulBlocks.TurquoiseBlock.get()){
		boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this;
		boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this;

		if (flag && flag1){
		    par1World.setBlockToAir(par2, par3, par4);
		}
		else
		{
		    if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != SoulBlocks.TurquoiseBlock.get() || par1World.getBlock(par2 - b0, par3, par4 - b1) != this) && (par1World.getBlock(par2 - b0, par3, par4 - b1) != SoulBlocks.TurquoiseBlock.get() || par1World.getBlock(par2 + b0, par3, par4 + b1) != this))
		    {
			par1World.setBlockToAir(par2, par3, par4);
		    }
		}
	    }
	    else
	    {
		par1World.setBlockToAir(par2, par3, par4);
	    }
	}
    }

    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
	if (par1IBlockAccess.getBlock(par2, par3, par4) == this)
	{
	    return false;
	}
	else
	{
	    boolean flag = par1IBlockAccess.getBlock(par2 - 1, par3, par4) == this && par1IBlockAccess.getBlock(par2 - 2, par3, par4) != this;
	    boolean flag1 = par1IBlockAccess.getBlock(par2 + 1, par3, par4) == this && par1IBlockAccess.getBlock(par2 + 2, par3, par4) != this;
	    boolean flag2 = par1IBlockAccess.getBlock(par2, par3, par4 - 1) == this && par1IBlockAccess.getBlock(par2, par3, par4 - 2) != this;
	    boolean flag3 = par1IBlockAccess.getBlock(par2, par3, par4 + 1) == this && par1IBlockAccess.getBlock(par2, par3, par4 + 2) != this;
	    boolean flag4 = flag || flag1;
	    boolean flag5 = flag2 || flag3;
	    return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
	}
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
     public int quantityDropped(Random par1Random)
     {
	 return 0;
     }

     public int getRenderBlockPass()
     {
	 return 1;
     }

     public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
     {
	 if (par5Random.nextInt(100) == 0)
	 {
	     par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
	 }

	 for (int l = 0; l < 4; ++l)
	 {
	     double d0 = (double)((float)par2 + par5Random.nextFloat());
	     double d1 = (double)((float)par3 + par5Random.nextFloat());
	     double d2 = (double)((float)par4 + par5Random.nextFloat());
	     double d3 = 0.0D;
	     double d4 = 0.0D;
	     double d5 = 0.0D;
	     int i1 = par5Random.nextInt(2) * 2 - 1;
	     d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
	     d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
	     d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

	     if (par1World.getBlock(par2 - 1, par3, par4) != this && par1World.getBlock(par2 + 1, par3, par4) != this)
	     {
		 d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
		 d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
	     }
	     else
	     {
		 d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
		 d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
	     }

	     RenderParticles.spawnParticle("soulportal", d0, d1, d2, d3, d4, d5);
	 }
     }

     public int idPicked(World par1World, int par2, int par3, int par4)
     {
	 return 0;
     }
}

