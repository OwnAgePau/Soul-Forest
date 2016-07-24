package com.Mod_Ores.Blocks.Special;

import java.util.List;
import java.util.Random;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class SoulSlab extends BlockSlab{
	
	public static final PropertyEnum<BlockSlab.EnumBlockHalf> HALF = PropertyEnum.<BlockSlab.EnumBlockHalf>create("half", BlockSlab.EnumBlockHalf.class);

    public SoulSlab(Material par1Mat){
        super(par1Mat);
        if (this.isDouble()){
            this.fullBlock = true;
        }
        else{
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        this.setLightOpacity(255);
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World p_149694_1_, BlockPos pos){
		System.out.println("YAY");
		return this == SoulBlocks.SoulHalfSlab.get() ? Item.getItemFromBlock(SoulBlocks.SoulHalfSlab.get()) : Item.getItemFromBlock(SoulBlocks.SoulDoubleSlab.get());
	        //return func_150003_a(this) ? Item.getItemFromBlock(this) : (this == Blocks.double_stone_slab ? Item.getItemFromBlock(Blocks.stone_slab) : (this == Blocks.double_wooden_slab ? Item.getItemFromBlock(Blocks.wooden_slab) : Item.getItemFromBlock(Blocks.stone_slab)));
    }
}