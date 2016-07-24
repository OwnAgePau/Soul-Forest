package com.Mod_Ores.Items;

import com.Mod_Ores.soul_forest;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSoulIngot extends Item{
	
    private EnumRarity rarity;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    /**
     * ItemSoulIngot Constructor
     * @param Unlname This is the Unlocalized Name
     */
    public ItemSoulIngot(String Unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulGems);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
    }

    /**
     * ItemSoulIngot Constructor
     * @param Unlname This is the Unlocalized Name
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public ItemSoulIngot(String Unlname, EnumRarity rarity){
		this(Unlname);
		this.rarity = rarity;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
		if(this.rarity != null){
		    return this.rarity;
		}
		else{
		    return EnumRarity.COMMON;
		}
    }
}