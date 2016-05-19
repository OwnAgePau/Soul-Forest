package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemAmuletRing extends Item{
    
    private EnumRarity rarity;
    private String amuletType;
    private String amuletDescription;
    
    public ItemAmuletRing(String unlname, int durability, String name, String description){
	this.registerItem(unlname, durability);
	this.amuletType = name;
	this.amuletDescription = description;
    }
 
    public ItemAmuletRing(String unlname, int durability, String name, EnumRarity rarity, String description){
	this.registerItem(unlname, durability);
	this.rarity = rarity;
	this.amuletType = name;
	this.amuletDescription = description;
    }
    
    private void registerItem(String unlname, int durability){
	this.setCreativeTab(soul_forest.tabAmulets);
	setUnlocalizedName(unlname);
	GameRegistry.registerItem(this, unlname, soul_forest.MODID);
	this.setMaxDamage(durability);
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
	if(this.rarity != null){
	    return this.rarity;
	}
	else{
	    return EnumRarity.common;
	}
    }
    
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2Entity, List par3List, boolean par4boolean) {
	int uses = this.getMaxDamage();
	int damage = (uses - par1ItemStack.getItemDamage());
	par3List.add(this.amuletType);
	if(this.getMaxDamage() > 0){
	    par3List.add("\u00A73" + this.amuletDescription);
	    par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
	    par3List.add("Location: Hotbar");
	}
    }
}