package com.Mod_Ores.Items.Armor;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;
import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorBronze extends ItemArmor{
    private static final String[] BRONZE_ARMOR = new String[] {"Bronze_helmet", "Bronze_chestplate", "Bronze_legs", "Bronze_boots"};
    private ItemArmor.ArmorMaterial mat;
    private int armorSlot;
    /**
     * This is the bronze armor constructor
     * @param par1.getItem() Item id
     * @param par2EnumArmorMaterial The Armor Material
     * @param par3 Adds the armor
     * @param par4 The Armor type (0 for helmet, 1 for chestplate, 2 for legs and 3 for boots)
     * @param UnLname This is the unlocalized name
     * @param InGname This is the name that will be shown in game
     */
    public ItemArmorBronze(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String UnLname){
	super(par2EnumArmorMaterial, par3, par4);
	setMaxStackSize(1);
	setCreativeTab(soul_forest.tabSoulTools);
	setUnlocalizedName(UnLname);
	GameRegistry.registerItem(this, UnLname, soul_forest.MODID);
	this.mat = par2EnumArmorMaterial;
	this.armorSlot = par4;
	InitItems.soulArmors.add(this);
    }

    @Override
    public void registerIcons(IIconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon(soul_forest.MODID + ":" + BRONZE_ARMOR[this.armorSlot]);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack par1, Entity entity, int slot, String layer){
	if(par1.getItem().equals(SoulItems.BronzeHelmet.get()) || par1.getItem().equals(SoulItems.BronzeChestplate.get()) || par1.getItem().equals(SoulItems.BronzeBoots.get())){
	    return "soulforest:textures/armor/bronze_layer_1.png";
	}
	else if(par1.getItem().equals(SoulItems.BronzeLeggings.get())){
	    return "soulforest:textures/armor/bronze_layer_2.png";
	}
	else{
	    return null;
	}
    }

    @Override
    public void addInformation(ItemStack par1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	if(par1.getItem().equals(SoulItems.BronzeHelmet.get())){
	    this.armorSlot = 0;
	}
	else if(par1.getItem().equals(SoulItems.BronzeChestplate.get())){
	    this.armorSlot = 1;
	}
	else if(par1.getItem().equals(SoulItems.BronzeLeggings.get())){
	    this.armorSlot = 2;
	}
	else if(par1.getItem().equals(SoulItems.BronzeBoots.get())){
	    this.armorSlot = 3;
	}

	int uses = mat.getDurability(this.armorSlot);
	int damageRedu = mat.getDamageReductionAmount(this.armorSlot);
	int ench = mat.getEnchantability();
	int damage = (uses - par1.getItemDamage());
	if(SoulForestKeyHandler.isKeyPressed){
		par3List.add("\u00A73Max Damage Taken : " + damage + "/" + uses);
		par3List.add("\u00A72Damage Reduction : " + damageRedu);
		par3List.add("\u00A74Enchantability : " + ench);
		par3List.add("\u00A71Set Bonus : ");
		par3List.add("	\u00A71Regenaration");
	}
	else{
	    par3List.add("Press " + Keyboard.getKeyName(SoulForestKeyHandler.keyValues[SoulForestKeyHandler.CUSTOM_INV]) + " to show more details.");
	}
    }
}

