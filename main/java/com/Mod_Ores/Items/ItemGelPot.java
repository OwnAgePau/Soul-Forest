package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemGelPot extends Item{	 
    
    private boolean isFull;
    /**
     * Item Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param isFilled This will tell whether the item is filled with gel or not
     */
    public ItemGelPot(String Unlname, boolean isFilled){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
	super(); //This super will load item ID and UName
	this.isFull = isFilled;
	this.setCreativeTab(soul_forest.tabSoulOther); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	if(!this.isFull){
	    this.maxStackSize = 1;
	    this.setMaxDamage(10);
	    this.setDamage(new ItemStack(this, 1), 9);
	}
    }			

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
	if(this.isFull){
	    par3List.add("Contains sticky gel!");
	}
	else{
	    par3List.add("Contains : " + (9 - this.getDamage(par1ItemStack)) + " gel");
	}
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
	if(this.isFull){
	    return EnumRarity.uncommon;
	}
	else{
	    return EnumRarity.common;
	}
    }

    @Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	//par1ItemStack.damageItem(9, par3EntityPlayer);
    }
}
