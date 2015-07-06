package com.Mod_Ores.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.TerrainGen;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.BiomeGen.WorldGenGrapeTree;
import com.Mod_Ores.Init.SoulBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulSappling extends BlockFlower
{
    @SideOnly(Side.CLIENT)
    private IIcon[] saplingIcon;

    public BlockSoulSappling(String Unlname)
    {
        super(0);
        float f = 0.4F;
        this.setStepSound(soundTypeGrass);
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(soul_forest.tabSoulBerries);
        GameRegistry.registerBlock(this, Unlname);
        setBlockName(Unlname);
    }
    
    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(Block par1)
    {
    	return par1 == SoulBlocks.LateriteGrass.get() || par1 == SoulBlocks.LateriteDirt.get();
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        Block block =par1World.getBlock(par2, par3 - 1, par4);
        if(block != null)
        {
        	if(block.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this))
        	return true;   
        }
        else
        {
        	return false;
        }
        
        return block.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
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
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }
    
    /*@Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Cave;
    }*/

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);
        this.markOrGrowMarked(par1World, par2, par3, par4, par5Random);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int par1, int par2)
    {
        par2 &= 3;
        return this.saplingIcon[par2];
    }

    public void markOrGrowMarked(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        if(par5Random.nextInt(2) == 0)
        {
        	this.func_149878_d(par1World, par2, par3, par4, par5Random);
        }
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    public void func_149878_d(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)){
    		return;
    	}
        int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
        //Object object = par5Random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        Object object = new WorldGenGrapeTree(true);

        /*if (l == 1)
        {
            object = new WorldGenTaiga2(true);
        }
        else if (l == 2)
        {
            object = new WorldGenForest(true);
        }
        else if (l == 3)
        {
            for (i1 = 0; i1 >= -1; --i1)
            {
                for (j1 = 0; j1 >= -1; --j1)
                {
                    if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
                    {
                        object = new WorldGenGrapeTree(true, 4 + par5Random.nextInt(7), 3, 3, false);
                        flag = true;
                        break;
                    }
                }

                if (object != null)
                {
                    break;
                }
            }

            if (object == null)
            {
                j1 = 0;
                i1 = 0;
                object = new WorldGenGrapeTree(true, 4 + par5Random.nextInt(7), 3, 3, false);
            }
        }
        else
        {
            object = new WorldGenGrapeTree(true);

            if (par5Random.nextInt(10) == 0)
            {
                object = new WorldGenGrapeTree(true);
            }
        }*/

        if (flag)
        {
            par1World.setBlock(par2 + i1, par3, par4 + j1, Block.getBlockFromName("air"), 0, 4);
            par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, Block.getBlockFromName("air"), 0, 4);
            par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, Block.getBlockFromName("air"), 0, 4);
            par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, Block.getBlockFromName("air"), 0, 4);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, Block.getBlockFromName("air"), 0, 4);
        }

        if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
        {
            if (flag)
            {
                par1World.setBlock(par2 + i1, par3, par4 + j1, this, l, 4);
                par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this, l, 4);
                par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this, l, 4);
                par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this, l, 4);
            }
            else
            {
                par1World.setBlock(par2, par3, par4, this, l, 4);
            }
        }
    }

    /**
     * Determines if the same sapling is present at the given location.
     */
    public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
    {
        return par1World.getBlock(par2, par3, par4) == this && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    @Override
    public int damageDropped(int par1)
    {
        return par1 & 3;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.saplingIcon = new IIcon[2];

        for (int i = 0; i < 2; ++i)
        {
            this.saplingIcon[i] = par1IconRegister.registerIcon("soulforest:Sappling_soul");
        }
    }
}
