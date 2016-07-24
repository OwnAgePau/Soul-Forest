package com.Mod_Ores.Items;

import com.Mod_Ores.soul_forest;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoulItem extends Item{
	
    private EnumRarity rarity;
    private Boolean Effect = false;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    /**
     * Item Constructor
     * @param Unlname This is the Unlocalized Name
     */
    public SoulItem(String Unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulOther);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
    }

    /**
     * Item Constructor
     * @param Unlname This is the Unlocalized Name
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public SoulItem(String Unlname, EnumRarity rarity, boolean effect){
		this(Unlname);
		this.rarity = rarity;
		this.Effect = effect;
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
    public boolean hasEffect(ItemStack par1ItemStack) {
		if(Effect){
		    return true;
		}
		else{
		    return false;
		}
    }
}