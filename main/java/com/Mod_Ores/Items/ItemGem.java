package com.Mod_Ores.Items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.Mod_Ores.soul_forest;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGem extends Item{
    private String Rarity;

    /**
     * ItemGem Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     */
    public ItemGem(String Unlname){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
	super(); //This super will load item ID and UName
	this.setCreativeTab(soul_forest.tabSoulGems); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
    }

    /**
     * ItemGem Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public ItemGem(String Unlname, String rarity){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
	super(); //This super will load item ID and UName
	this.setCreativeTab(soul_forest.tabSoulGems); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	this.Rarity = rarity;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
	if(Rarity == "U"){
	    return EnumRarity.uncommon;
	}
	else if(Rarity == "R"){
	    return EnumRarity.rare;
	}
	else if(Rarity == "E"){
	    return EnumRarity.epic;
	}
	else{
	    return EnumRarity.common;
	}
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
	return true;
    }
}
