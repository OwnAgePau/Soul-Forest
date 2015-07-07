package com.Mod_Ores.Blocks.Special;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class SoulSlab extends BlockSlab{
    protected final boolean isDoubleSlab;
    private static final String __OBFID = "CL_00000253";

    public SoulSlab(boolean isDoubleSlab, Material par1Mat){
        super(isDoubleSlab, par1Mat);
        this.isDoubleSlab = isDoubleSlab;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_){
	System.out.println("YAY");
	return this == SoulBlocks.SoulHalfSlab.get() ? Item.getItemFromBlock(SoulBlocks.SoulHalfSlab.get()) : Item.getItemFromBlock(SoulBlocks.SoulDoubleSlab.get());
        //return func_150003_a(this) ? Item.getItemFromBlock(this) : (this == Blocks.double_stone_slab ? Item.getItemFromBlock(Blocks.stone_slab) : (this == Blocks.double_wooden_slab ? Item.getItemFromBlock(Blocks.wooden_slab) : Item.getItemFromBlock(Blocks.stone_slab)));
    }
}