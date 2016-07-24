package com.Mod_Ores.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class ItemFrostLighter extends ItemSoulLighter{
	
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    public ItemFrostLighter(String unlName, int maxDamage) {
    	super(unlName, maxDamage);
    	this.setUnlocalizedName(soul_forest.MODID + "_" + unlName);
    	this.textureName = unlName;
    }
    
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, 
    		float hitX, float hitY, float hitZ){
    	pos = pos.offset(side);

		if (!playerIn.canPlayerEdit(pos, side, stack)){
		    return false;
		}
		else{
			if (worldIn.isAirBlock(pos)){
				worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
		        worldIn.setBlockState(pos, SoulBlocks.SoulFireFrozenHearth.get().getDefaultState());
		    }
		
		    stack.damageItem(1, playerIn);
		    return true;
		}
    }
}