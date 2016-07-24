package com.Mod_Ores.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class ItemSoulLighter extends Item{
	
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    public ItemSoulLighter(String unlName, int maxDamage){
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(maxDamage);
		this.setCreativeTab(soul_forest.tabSoulTools);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlName);
		this.textureName = unlName;
		GameRegistry.registerItem(this, unlName);
    }
    
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
		        worldIn.setBlockState(pos, SoulBlocks.SoulFire.get().getDefaultState());
		    }
		
		    stack.damageItem(1, playerIn);
		    return true;
		}
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.UNCOMMON;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
    	return true;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		int uses = this.getMaxDamage();
		int damage = (uses - par1ItemStack.getItemDamage());
		par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
    }
}