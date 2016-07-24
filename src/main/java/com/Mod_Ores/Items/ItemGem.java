package com.Mod_Ores.Items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;

public class ItemGem extends Item{
	
    private EnumRarity rarity;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    /**
     * ItemGem Constructor
     * @param Unlname This is the Unlocalized Name
     */
    public ItemGem(String Unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulGems);
		setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
    }

    /**
     * ItemGem Constructor
     * @param Unlname This is the Unlocalized Name
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public ItemGem(String Unlname, EnumRarity rarity){
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

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
    	return true;
    }
}