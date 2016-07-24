package com.Mod_Ores.Items.Armor;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;
import com.Mod_Ores.Init.SoulItems;

public class ItemArmorCobalt extends ItemArmor{
    
	private static final String[] COBALT_ARMOR = new String[] {"Cobalt_helmet", "Cobalt_chestplate", "Cobalt_legs", "Cobalt_boots"};
    private ItemArmor.ArmorMaterial mat;
    private int armorSlot;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * This is the cobalt armor constructor
     * @param par2EnumArmorMaterial The Armor Material
     * @param par3 Adds the armor
     * @param par4 The Armor type (0 for helmet, 1 for chestplate, 2 for legs and 3 for boots)
     * @param UnLname This is the unlocalized name
     */
    public ItemArmorCobalt(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String Unlname){
		super(par2EnumArmorMaterial, par3, par4);
		this.setMaxStackSize(1);
		this.setCreativeTab(soul_forest.tabSoulTools);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		GameRegistry.registerItem(this, Unlname);
		this.textureName = Unlname;
		this.mat = par2EnumArmorMaterial;
		this.armorSlot = par4;
		InitItems.soulArmors.add(this);
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.RARE;
    }

    /*@Override
    public void registerIcons(IIconRegister par1IconRegister){
    	this.itemIcon = par1IconRegister.registerIcon(soul_forest.MODID + ":" + COBALT_ARMOR[this.armorSlot]);
    }*/

    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack par1, Entity entity, int slot, String layer){
		if(par1.getItem().equals(SoulItems.CobaltHelmet.get()) || par1.getItem().equals(SoulItems.CobaltChestplate.get()) || par1.getItem().equals(SoulItems.CobaltBoots.get())){
		    return "soulforest:textures/armor/cobalt_layer_1.png";
		}
		else if(par1.getItem().equals(SoulItems.CobaltLeggings.get())){
		    return "soulforest:textures/armor/cobalt_layer_2.png";
		}
		else{
		    return null;
		}
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(par1ItemStack.equals(SoulItems.CobaltHelmet.get())){
		    this.armorSlot = 0;
		}
		else if(par1ItemStack.equals(SoulItems.CobaltChestplate.get())){
		    this.armorSlot = 1;
		}
		else if(par1ItemStack.equals(SoulItems.CobaltLeggings.get())){
		    this.armorSlot = 2;
		}
		else if(par1ItemStack.equals(SoulItems.CobaltBoots.get())){
		    this.armorSlot = 3;
		}
	
		int uses = mat.getDurability(this.armorSlot);
		int damageRedu = mat.getDamageReductionAmount(this.armorSlot);
		int ench = mat.getEnchantability();
		int damage = (uses - par1ItemStack.getItemDamage());
		if(SoulForestKeyHandler.isKeyPressed){
			par3List.add("\u00A73Max Damage Taken : " + damage + "/" + uses);
			par3List.add("\u00A72Damage Reduction : " + damageRedu);
			par3List.add("\u00A74Enchantability : " + ench);
		}
		else{
		    par3List.add("Press " + Keyboard.getKeyName(SoulForestKeyHandler.keyValues[SoulForestKeyHandler.CUSTOM_INV]) + " to show more details.");
		}
    }
}