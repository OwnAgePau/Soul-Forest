package com.Mod_Ores.Items;

import com.Mod_Ores.soul_forest;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSoulBushel extends Item{
	
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
	/**
	 * ItemSoulBushel Constructor
	 * @param id this is the Item ID
	 * @param Unlname This is the Unlocalized Name
	 * @param InGname This is the Name that you will see In game
	 */
	 public ItemSoulBushel(String Unlname){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
		  super(); //This super will load item ID and UName
		  this.setCreativeTab(soul_forest.tabSoulBerries); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
		  setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		  this.textureName = Unlname;
		  GameRegistry.registerItem(this, Unlname);
	 }
}