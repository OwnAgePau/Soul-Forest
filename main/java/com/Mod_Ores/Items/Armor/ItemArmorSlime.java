package com.Mod_Ores.Items.Armor;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorSlime extends ItemArmor{
    private static final String[] SLIME_ARMOR = new String[] {"Slime_helmet", "Slime_chestplate", "Slime_legs", "Slime_boots"};
    private ItemArmor.ArmorMaterial mat;
    private int armorSlot;

    /**
     * This is the slime armor constructor
     * @param par1 Item id
     * @param par2EnumArmorMaterial The Armor Material
     * @param par3 Adds the armor
     * @param par4 The Armor type (0 for helmet, 1 for chestplate, 2 for legs and 3 for boots)
     * @param UnLname This is the unlocalized name
     * @param InGname This is the name that will be shown in game
     */
    public ItemArmorSlime(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String UnLname){
	super(par2EnumArmorMaterial, par3, par4);
	setMaxStackSize(1);
	setCreativeTab(soul_forest.tabSoulTools);
	setUnlocalizedName(UnLname);
	GameRegistry.registerItem(this, UnLname, soul_forest.MODID);
	this.mat = par2EnumArmorMaterial;
	this.armorSlot = par4;
    }

    @Override
    public void registerIcons(IIconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon(soul_forest.MODID + ":" + SLIME_ARMOR[this.armorSlot]);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack par1, Entity entity, int slot, String layer){
	if(par1.getItem().equals(SoulItems.SlimeHelmet.get()) || par1.getItem().equals(SoulItems.SlimeChestplate.get()) || 
		par1.getItem().equals(SoulItems.SlimeBoots.get())){
	    return "soulforest:textures/armor/slime_layer_1.png";
	}
	else if(par1.getItem().equals(SoulItems.SlimeLeggings.get())){
	    return "soulforest:textures/armor/slime_layer_2.png";
	}
	else{
	    return null;
	}
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
	return EnumRarity.common;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	if(par1ItemStack.equals(SoulItems.SlimeHelmet.get())){
	    this.armorSlot = 0;
	}
	else if(par1ItemStack.equals(SoulItems.SlimeChestplate.get())){
	    this.armorSlot = 1;
	}
	else if(par1ItemStack.equals(SoulItems.SlimeLeggings.get())){
	    this.armorSlot = 2;
	}
	else if(par1ItemStack.equals(SoulItems.SlimeBoots.get())){
	    this.armorSlot = 3;
	}

	int uses = mat.getDurability(this.armorSlot);
	int damageRedu = mat.getDamageReductionAmount(this.armorSlot);
	int ench = mat.getEnchantability();
	int damage = (uses - par1ItemStack.getItemDamage());
	if(SoulForestKeyHandler.isKeyPressed){
		par3List.add("\u00A73Max damage taken : " + damage + "/" + uses);
		par3List.add("\u00A72Damage Reduction : " + damageRedu);
		par3List.add("\u00A74Enchantability : " + ench);
		par3List.add("\u00A71Set Bonus : " + "Higher Jumping, No Falling Damage" + ", \u00A74Side effect : None");
	}
	else{
	    par3List.add("Press " + Keyboard.getKeyName(SoulForestKeyHandler.keyValues[SoulForestKeyHandler.CUSTOM_INV]) + " to show more details.");
	}
    }
}

