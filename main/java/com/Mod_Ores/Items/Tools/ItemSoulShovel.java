package com.Mod_Ores.Items.Tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemSoulShovel extends ItemSpade{
    private Item.ToolMaterial mat;

    /**
     * ItemSoulShovel Constructor
     * @param id this is the ItemShovel ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param EnumToolMaterial This will set the tools material
     */
    public ItemSoulShovel(String Unlname, Item.ToolMaterial material, int level){
	super(material);
	setCreativeTab(soul_forest.tabSoulTools);
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	this.mat = material;
	this.setHarvestLevel("shovel", level);
	InitItems.soulShovels.add(this);
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