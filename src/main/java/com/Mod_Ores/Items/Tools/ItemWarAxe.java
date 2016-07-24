package com.Mod_Ores.Items.Tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;
import com.google.common.collect.Multimap;

public class ItemWarAxe extends ItemAxe{
	
    private String Rarity;
    private Item.ToolMaterial mat;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * ItemWarAxe Constructor
     * @param id this is the ItemWarAxe ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param EnumToolMaterial This will set the tools material
     */
    public ItemWarAxe(String Unlname, Item.ToolMaterial material, int level){
		super(material);
		this.setCreativeTab(soul_forest.tabSoulTools);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		GameRegistry.registerItem(this, Unlname);
		this.textureName = Unlname;
		this.mat = material;
		this.setHarvestLevel("waraxe", level);
		InitItems.soulWarAxes.add(this);
    }

    /**
     * ItemWarAxe Constructor
     * @param id this is the ItemWarAxe ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param EnumToolMaterial This will set the tools material
     * @param rarity This will give the gem a color representing its rarity. "U" = uncommon, "R" = rare, "E" = epic
     */
    public ItemWarAxe(String Unlname, Item.ToolMaterial material, String rarity, int level){
		this(Unlname, material, level);
		this.Rarity = rarity;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
		if(Rarity == "U"){
		    return EnumRarity.UNCOMMON;
		}
		else if(Rarity == "R"){
		    return EnumRarity.RARE;
		}
		else if(Rarity == "E"){
		    return EnumRarity.EPIC;
		}
		else{
		    return EnumRarity.COMMON;
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

    @Override
    public Multimap getItemAttributeModifiers(){
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", 15, 0));
		return multimap;
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase){
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
    }
}
