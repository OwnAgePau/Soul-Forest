package com.Mod_Ores.Items;

import com.Mod_Ores.soul_forest;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SoulItem extends Item{
    private EnumRarity rarity;
    private Boolean Effect = false;

    /**
     * Item Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     */
    public SoulItem(String Unlname){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
	super(); //This super will load item ID and UName
	this.setCreativeTab(soul_forest.tabSoulOther); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
    }

    /**
     * Item Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public SoulItem(String Unlname, EnumRarity rarity, boolean effect){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
	super(); //This super will load item ID and UName
	this.rarity = rarity;
	this.Effect = effect;
	this.setCreativeTab(soul_forest.tabSoulOther); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname);
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
    public boolean hasEffect(ItemStack par1ItemStack) {
	if(Effect){
	    return true;
	}
	else{
	    return false;
	}
    }
}
