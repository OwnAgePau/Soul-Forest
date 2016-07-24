package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemFrostShard extends Item{
	
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
	
	public ItemFrostShard(String unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulOther);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlname);
		this.textureName = unlname;
		GameRegistry.registerItem(this, unlname);
	}
	    
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("\u00A73Ammo for tool : Frost Wand");
	}
}