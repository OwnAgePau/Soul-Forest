package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemAmuletRing extends Item{
    
    private EnumRarity rarity;
    private String amuletType;
    private String amuletDescription;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    public ItemAmuletRing(String unlname, int durability, String name, String description){
		this.registerItem(unlname, durability);
		this.amuletType = name;
		this.amuletDescription = description;
		this.textureName = unlname;
    }
 
    public ItemAmuletRing(String unlname, int durability, String name, EnumRarity rarity, String description){
    	this(unlname, durability, name, description);
		this.rarity = rarity;
    }
    
    private void registerItem(String unlname, int durability){
		this.setCreativeTab(soul_forest.tabAmulets);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlname);
		GameRegistry.registerItem(this, unlname);
		this.setMaxDamage(durability);
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
		if(this.rarity != null){
		    return this.rarity;
		}
		else{
		    return EnumRarity.COMMON;
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