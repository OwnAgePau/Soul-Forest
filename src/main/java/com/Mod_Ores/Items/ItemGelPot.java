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
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemGelPot extends Item{	 
    
    private boolean isFull;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * Item Constructor
     * @param Unlname This is the Unlocalized Name
     * @param isFilled This will tell whether the item is filled with gel or not
     */
    public ItemGelPot(String Unlname, boolean isFilled){
		super();
		this.isFull = isFilled;
		this.setCreativeTab(soul_forest.tabSoulOther);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
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
		    return EnumRarity.UNCOMMON;
		}
		else{
		    return EnumRarity.COMMON;
		}
    }

    @Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    	//par1ItemStack.damageItem(9, par3EntityPlayer);
    }
}