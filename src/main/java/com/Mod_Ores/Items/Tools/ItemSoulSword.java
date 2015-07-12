package com.Mod_Ores.Items.Tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemSoulSword extends ItemSword{
    private String Rarity;
    private Item.ToolMaterial mat;
    /**
     * ItemSoulSword Constructor
     * @param id this is the ItemSword ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param EnumToolMaterial This will set the tools material
     */
    public ItemSoulSword(String Unlname, Item.ToolMaterial material, int level){
	super(material);
	setCreativeTab(soul_forest.tabSoulTools);
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	this.mat = material;
	this.setHarvestLevel("sword", level);
	InitItems.soulSwords.add(this);
    }

    /**
     * ItemSoulSword Constructor
     * @param id this is the ItemSword ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param EnumToolMaterial This will set the tools material
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public ItemSoulSword(String Unlname, Item.ToolMaterial material, int level, String rarity){
	super(material);
	setCreativeTab(soul_forest.tabSoulTools);
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	this.Rarity = rarity;
	this.mat = material;
	this.setHarvestLevel("sword", level);
	InitItems.soulSwords.add(this);
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

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	int uses = mat.getMaxUses();
	float eff = mat.getEfficiencyOnProperMaterial();
	int ench = mat.getEnchantability();
	int harvl = mat.getHarvestLevel();
	int damage = (uses - par1ItemStack.getItemDamage());
	if(SoulForestKeyHandler.isKeyPressed){
	    par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
	    par3List.add("\u00A72Efficiency : " + eff);
	    par3List.add("\u00A74Enchantability : " + ench);
	    par3List.add("\u00A76Harvest Level : " + harvl);
	}
	else{
	    par3List.add("Press " + Keyboard.getKeyName(SoulForestKeyHandler.keyValues[SoulForestKeyHandler.CUSTOM_INV]) + " to show more details.");
	}
    }
}