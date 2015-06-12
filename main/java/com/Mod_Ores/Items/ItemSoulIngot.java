package com.Mod_Ores.Items;

import com.Mod_Ores.soul_forest;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemSoulIngot extends Item
{
	private String Rarity;
	
	/**
	 * ItemSoulIngot Constructor
	 * @param id this is the Item ID
	 * @param Unlname This is the Unlocalized Name
	 * @param InGname This is the Name that you will see In game
	 */
	 public ItemSoulIngot(String Unlname) //id - item ID, UName - Unlocalized Name, IGName - IngameName
	 {
		  super(); //This super will load item ID and UName
		  this.setCreativeTab(soul_forest.tabSoulGems); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
		  setUnlocalizedName(Unlname);
		  GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	 }
	 
		/**
		 * ItemSoulIngot Constructor
		 * @param id this is the Item ID
		 * @param Unlname This is the Unlocalized Name
		 * @param InGname This is the Name that you will see In game
		 * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
		 */
		 public ItemSoulIngot(String Unlname, String rarity) //id - item ID, UName - Unlocalized Name, IGName - IngameName
		 {
		  super(); //This super will load item ID and UName
		  this.setCreativeTab(soul_forest.tabSoulGems); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
		  setUnlocalizedName(Unlname);
		  GameRegistry.registerItem(this, Unlname);
		  this.Rarity = rarity;
		 }
		 
			public EnumRarity getRarity(ItemStack par1ItemStack)
			{
				if(Rarity == "U")
				{
					return EnumRarity.uncommon;
				}
				else if(Rarity == "R")
				{
					return EnumRarity.rare;
				}
				else if(Rarity == "E")
				{
					return EnumRarity.epic;
				}
				else
				{
					return EnumRarity.common;
				}
			}
}
