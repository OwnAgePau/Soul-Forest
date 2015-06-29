package com.Mod_Ores.Blocks.Special;

import java.util.IdentityHashMap;
import java.util.Random;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.Dimension.SoulForest.TeleportBlockSoulForest;
import com.Mod_Ores.Init.SoulBlocks;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulFire extends BlockFire
{
    private int[] chanceToEncourageFire = new int[256];
    private int[] abilityToCatchFire = new int[256];
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public SoulFire(String Unlname)
    {
        super();
        this.setTickRandomly(true);
		GameRegistry.registerBlock(this, Unlname);
		setBlockName(Unlname);
    }

    public void initializeBlock()
    {
        this.setBurnRate(Blocks.planks, 5, 20);
        this.setBurnRate(Blocks.double_wooden_slab, 5, 20);
        this.setBurnRate(Blocks.wooden_slab, 5, 20);
        this.setBurnRate(Blocks.fence, 5, 20);
        this.setBurnRate(Blocks.oak_stairs, 5, 20);
        this.setBurnRate(Blocks.birch_stairs, 5, 20);
        this.setBurnRate(Blocks.spruce_stairs, 5, 20);
        this.setBurnRate(Blocks.jungle_stairs, 5, 20);
        this.setBurnRate(Blocks.log, 5, 5);
        this.setBurnRate(Blocks.log2, 5, 5);
        this.setBurnRate(Blocks.leaves, 30, 60);
        this.setBurnRate(Blocks.leaves2, 30, 60);
        this.setBurnRate(Blocks.bookshelf, 30, 20);
        this.setBurnRate(Blocks.tnt, 15, 100);
        this.setBurnRate(Blocks.tallgrass, 60, 100);
        this.setBurnRate(Blocks.wool, 30, 60);
        this.setBurnRate(Blocks.vine, 15, 100);
    }

    private void setBurnRate(Block par1, int par2, int par3)
    {
    	this.setFireInfo(par1, par2, par3);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 3;
    }

    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    public int tickRate(World par1World)
    {
        return 30;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.getGameRules().getGameRuleBooleanValue("doFireTick"))
        {
            Block base = par1World.getBlock(par2, par3 - 1, par4);
            boolean flag = (base != null && base.isFireSource(par1World, par2, par3 - 1, par4, ForgeDirection.UP));

            if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
            {
                par1World.setBlockToAir(par2, par3, par4);
            }

            if (!flag && par1World.isRaining() && (par1World.canLightningStrikeAt(par2, par3, par4) || par1World.canLightningStrikeAt(par2 - 1, par3, par4) || par1World.canLightningStrikeAt(par2 + 1, par3, par4) || par1World.canLightningStrikeAt(par2, par3, par4 - 1) || par1World.canLightningStrikeAt(par2, par3, par4 + 1)))
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
            else
            {
                int l = par1World.getBlockMetadata(par2, par3, par4);

                if (l < 15)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l + par5Random.nextInt(3) / 2, 4);
                }

                par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World) + par5Random.nextInt(10));

                if (!flag && !this.canNeighborBurn(par1World, par2, par3, par4))
                {
                    if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) || l > 3)
                    {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
                else if (!flag && !this.canBlockCatchFire(par1World, par2, par3 - 1, par4, ForgeDirection.UP) && l == 15 && par5Random.nextInt(4) == 0)
                {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else
                {
                    boolean flag1 = par1World.isBlockHighHumidity(par2, par3, par4);
                    byte b0 = 0;

                    if (flag1)
                    {
                        b0 = -50;
                    }

                    this.tryToCatchBlockOnFire(par1World, par2 + 1, par3, par4, 300 + b0, par5Random, l, ForgeDirection.WEST );
                    this.tryToCatchBlockOnFire(par1World, par2 - 1, par3, par4, 300 + b0, par5Random, l, ForgeDirection.EAST );
                    this.tryToCatchBlockOnFire(par1World, par2, par3 - 1, par4, 250 + b0, par5Random, l, ForgeDirection.UP   );
                    this.tryToCatchBlockOnFire(par1World, par2, par3 + 1, par4, 250 + b0, par5Random, l, ForgeDirection.DOWN );
                    this.tryToCatchBlockOnFire(par1World, par2, par3, par4 - 1, 300 + b0, par5Random, l, ForgeDirection.SOUTH);
                    this.tryToCatchBlockOnFire(par1World, par2, par3, par4 + 1, 300 + b0, par5Random, l, ForgeDirection.NORTH);

                    for (int i1 = par2 - 1; i1 <= par2 + 1; ++i1)
                    {
                        for (int j1 = par4 - 1; j1 <= par4 + 1; ++j1)
                        {
                            for (int k1 = par3 - 1; k1 <= par3 + 4; ++k1)
                            {
                                if (i1 != par2 || k1 != par3 || j1 != par4)
                                {
                                    int l1 = 100;

                                    if (k1 > par3 + 1)
                                    {
                                        l1 += (k1 - (par3 + 1)) * 100;
                                    }

                                    int i2 = this.getChanceOfNeighborsEncouragingFire(par1World, i1, k1, j1);

                                    if (i2 > 0)
                                    {
                                    	int difficulty = par1World.difficultySetting.getDifficultyId();
                                        int j2 = (i2 + 40 + difficulty * 7) / (l + 30);

                                        if (flag1)
                                        {
                                            j2 /= 2;
                                        }

                                        if (j2 > 0 && par5Random.nextInt(l1) <= j2 && (!par1World.isRaining() || !par1World.canLightningStrikeAt(i1, k1, j1)) && !par1World.canLightningStrikeAt(i1 - 1, k1, par4) && !par1World.canLightningStrikeAt(i1 + 1, k1, j1) && !par1World.canLightningStrikeAt(i1, k1, j1 - 1) && !par1World.canLightningStrikeAt(i1, k1, j1 + 1))
                                        {
                                            int k2 = l + par5Random.nextInt(5) / 4;

                                            if (k2 > 15)
                                            {
                                                k2 = 15;
                                            }

                                            par1World.setBlock(i1, k1, j1, this, k2, 3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean func_82506_l()
    {
        return false;
    }

    @Deprecated
    private void tryToCatchBlockOnFire(World par1World, int par2, int par3, int par4, int par5, Random par6Random, int par7)
    {
        tryToCatchBlockOnFire(par1World, par2, par3, par4, par5, par6Random, par7, ForgeDirection.UP);
    }

    private void tryToCatchBlockOnFire(World par1World, int par2, int par3, int par4, int par5, Random par6Random, int par7, ForgeDirection face)
    {
        int j1 = 0;
        Block block = par1World.getBlock(par2, par3, par4);
        if (block != null)
        {
            j1 = block.getFlammability(par1World, par2, par3, par4, face);
        }

        if (par6Random.nextInt(par5) < j1)
        {
            boolean flag = par1World.getBlock(par2, par3, par4) == Block.getBlockFromName("tnt");

            if (par6Random.nextInt(par7 + 10) < 5 && !par1World.canLightningStrikeAt(par2, par3, par4))
            {
                int k1 = par7 + par6Random.nextInt(5) / 4;

                if (k1 > 15)
                {
                    k1 = 15;
                }

                par1World.setBlock(par2, par3, par4, this, k1, 3);
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
            }

            if (flag)
            {
                Block.getBlockFromName("tnt").onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
            }
        }
    }

    private boolean canNeighborBurn(World par1World, int par2, int par3, int par4)
    {
        return canBlockCatchFire(par1World, par2 + 1, par3, par4, ForgeDirection.WEST ) ||
               canBlockCatchFire(par1World, par2 - 1, par3, par4, ForgeDirection.EAST ) ||
               canBlockCatchFire(par1World, par2, par3 - 1, par4, ForgeDirection.UP   ) ||
               canBlockCatchFire(par1World, par2, par3 + 1, par4, ForgeDirection.DOWN ) ||
               canBlockCatchFire(par1World, par2, par3, par4 - 1, ForgeDirection.SOUTH) ||
               canBlockCatchFire(par1World, par2, par3, par4 + 1, ForgeDirection.NORTH);
    }

    private int getChanceOfNeighborsEncouragingFire(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;

        if (!par1World.isAirBlock(par2, par3, par4))
        {
            return 0;
        }
        else
        {
            int l = this.getChanceToEncourageFire(par1World, par2 + 1, par3, par4, b0, ForgeDirection.WEST);
            l = this.getChanceToEncourageFire(par1World, par2 - 1, par3, par4, l, ForgeDirection.EAST);
            l = this.getChanceToEncourageFire(par1World, par2, par3 - 1, par4, l, ForgeDirection.UP);
            l = this.getChanceToEncourageFire(par1World, par2, par3 + 1, par4, l, ForgeDirection.DOWN);
            l = this.getChanceToEncourageFire(par1World, par2, par3, par4 - 1, l, ForgeDirection.SOUTH);
            l = this.getChanceToEncourageFire(par1World, par2, par3, par4 + 1, l, ForgeDirection.NORTH);
            return l;
        }
    }

    public boolean isCollidable()
    {
        return false;
    }

    @Deprecated
    public boolean canBlockCatchFire(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return canBlockCatchFire(par1IBlockAccess, par2, par3, par4, ForgeDirection.UP);
    }

    @Deprecated
    public int getChanceToEncourageFire(World par1World, int par2, int par3, int par4, int par5)
    {
        return getChanceToEncourageFire(par1World, par2, par3, par4, par5, ForgeDirection.UP);
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) || this.canNeighborBurn(par1World, par2, par3, par4);
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && !this.canNeighborBurn(par1World, par2, par3, par4))
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    /**
     * The Portal to the dimension
     */
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if ((par1World.provider.dimensionId > 0 || par1World.getBlock(par2, par3 - 1, par4) != SoulBlocks.SilverBlock.get() || ((TeleportBlockSoulForest)SoulBlocks.Teleporter.get()).tryToCreatePortal(par1World, par2, par3, par4)))
        {
            if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && !this.canNeighborBurn(par1World, par2, par3, par4))
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
            else
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World) + par1World.rand.nextInt(10));
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(24) == 0)
        {
            par1World.playSound((double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), "fire.fire", 1.0F + par5Random.nextFloat(), par5Random.nextFloat() * 0.7F + 0.3F, false);
        }

        int l;
        float f;
        float f1;
        float f2;

        if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && !Blocks.fire.canCatchFire(par1World, par2, par3 - 1, par4, ForgeDirection.UP))
        {
            if (Blocks.fire.canCatchFire(par1World, par2 - 1, par3, par4, ForgeDirection.EAST))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)par2 + par5Random.nextFloat() * 0.1F;
                    f1 = (float)par3 + par5Random.nextFloat();
                    f2 = (float)par4 + par5Random.nextFloat();
                    par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Blocks.fire.canCatchFire(par1World, par2 + 1, par3, par4, ForgeDirection.WEST))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)(par2 + 1) - par5Random.nextFloat() * 0.1F;
                    f1 = (float)par3 + par5Random.nextFloat();
                    f2 = (float)par4 + par5Random.nextFloat();
                    par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Blocks.fire.canCatchFire(par1World, par2, par3, par4 - 1, ForgeDirection.SOUTH))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)par2 + par5Random.nextFloat();
                    f1 = (float)par3 + par5Random.nextFloat();
                    f2 = (float)par4 + par5Random.nextFloat() * 0.1F;
                    par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Blocks.fire.canCatchFire(par1World, par2, par3, par4 + 1, ForgeDirection.NORTH))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)par2 + par5Random.nextFloat();
                    f1 = (float)par3 + par5Random.nextFloat();
                    f2 = (float)(par4 + 1) - par5Random.nextFloat() * 0.1F;
                    par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Blocks.fire.canCatchFire(par1World, par2, par3 + 1, par4, ForgeDirection.DOWN))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)par2 + par5Random.nextFloat();
                    f1 = (float)(par3 + 1) - par5Random.nextFloat() * 0.1F;
                    f2 = (float)par4 + par5Random.nextFloat();
                    par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
        else
        {
            for (l = 0; l < 3; ++l)
            {
                f = (float)par2 + par5Random.nextFloat();
                f1 = (float)par3 + par5Random.nextFloat() * 0.5F + 0.5F;
                f2 = (float)par4 + par5Random.nextFloat();
                par1World.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
            }
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
        this.iconArray = new IIcon[] {par1IconRegister.registerIcon("soulforest:Soul_Fire"), par1IconRegister.registerIcon("soulforest:Soul_Fire")};
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(int par1)
    {
    	return this.iconArray[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int par1, int par2)
    {
        return this.iconArray[0];
    }
    
    private static class FireInfo
    {
        private int encouragement = 0;
        private int flammibility = 0;
    }
    private IdentityHashMap<Block, FireInfo> blockInfo = Maps.newIdentityHashMap();
    
    public void setFireInfo(Block block, int encouragement, int flammibility)
    {
        if (block == Blocks.air) throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
        int id = Block.getIdFromBlock(block);
        this.chanceToEncourageFire[id] = encouragement;
        this.abilityToCatchFire[id] = flammibility;

        FireInfo info = getInfo(block, true);
        info.encouragement = encouragement;
        info.flammibility = flammibility;
    }
    
    private FireInfo getInfo(Block block, boolean garentee)
    {
        FireInfo ret = blockInfo.get(block);
        if (ret == null && garentee)
        {
            ret = new FireInfo();
            blockInfo.put(block, ret);
        }
        return ret;
    }
    
    public void rebuildFireInfo()
    {
        for (int x = 0; x < 4096; x++)
        {
            //If we care.. we could detect changes in here and make sure we keep them, however 
            //it's my thinking that anyone who hacks into the private variables should DIAF and we don't care about them.
            abilityToCatchFire[x] = 0;
            chanceToEncourageFire[x] = 0;
        }

        for (Entry<Block, FireInfo> e : blockInfo.entrySet())
        {
            int id = Block.getIdFromBlock(e.getKey());
            if (id >= 0 && id < 4096)
            {
                chanceToEncourageFire[id] = e.getValue().encouragement;
                abilityToCatchFire[id] = e.getValue().flammibility;
            }
        }
    }
    
    /**
     * Side sensitive version that calls the block function.
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param face The side the fire is coming from
     * @return True if the face can catch fire.
     */
    public boolean canBlockCatchFire(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        Block block = world.getBlock(x, y, z);
        if (block != null)
        {
            return block.isFlammable(world, x, y, z, face);
        }
        return false;
    }

    /**
     * Side sensitive version that calls the block function.
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param oldChance The previous maximum chance.
     * @param face The side the fire is coming from
     * @return The chance of the block catching fire, or oldChance if it is higher
     */
    public int getChanceToEncourageFire(World world, int x, int y, int z, int oldChance, ForgeDirection face)
    {
        int newChance = 0;
        Block block = world.getBlock(x, y, z);
        if (block != null)
        {
            newChance = block.getFireSpreadSpeed(world, x, y, z, face);
        }
        return (newChance > oldChance ? newChance : oldChance);
    }
    
    public int getFlammability(Block block)
    {
        int id = Block.getIdFromBlock(block);
        return id >= 0 && id < 4096 ? abilityToCatchFire[id] : 0;
    }

    public int getEncouragement(Block block)
    {
        int id = Block.getIdFromBlock(block);
        return id >= 0 && id < 4096 ? chanceToEncourageFire[id] : 0;
    }

}
