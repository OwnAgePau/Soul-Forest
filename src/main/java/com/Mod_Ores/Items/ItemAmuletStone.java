package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAmuletStone extends Item{

    private EnumRarity rarity;
    private int potionID;
    private int durability;
    private String amuletType;
    private boolean isPotionBuff;

    /** Create an amulet without a rarity and a different use then a potion effect
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     */
    public ItemAmuletStone(String Unlname, int durability){
	super();
	this.registerItem(Unlname, durability, false);
    }

    /** Create an amulet with a rarity and a different use then a potion effect.
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     * @param rarity the rarity of the amulet
     */
    public ItemAmuletStone(String Unlname, int durability, EnumRarity rarity){
	super();
	this.registerItem(Unlname, durability, false);
	this.rarity = rarity;
    }

    /** Create an amulet with a potion and without a rarity
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     * @param potionID the id of the potion
     */
    public ItemAmuletStone(String Unlname, int potionID, int potionDurability, int durability){
	super();
	this.registerItem(Unlname, durability, true);
	this.potionID = potionID;
	this.durability = potionDurability;
    }

    /** Create an amulet with a potion effect and rarity
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     * @param potionID the id of the potion
     * @param rarity the rarity of the amulet
     */
    public ItemAmuletStone(String Unlname, int potionID, int potionDurability, int durability, EnumRarity rarity){
	super();
	this.registerItem(Unlname, durability, true);
	this.rarity = rarity;
	this.potionID = potionID;
	this.durability = potionDurability;
    }
    
    private void registerItem(String Unlname, int durability, boolean isPotionBuff){
	this.setCreativeTab(soul_forest.tabAmulets);
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	this.setMaxDamage(durability);
	this.isPotionBuff = isPotionBuff;
	this.canRepair = true;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
	if(this.rarity != null){
	    return this.rarity;
	}
	else{
	    return EnumRarity.common;
	}
    }

    public ItemAmuletStone setAmuletStoneType(String type){
	this.amuletType = type;
	return this;
    }
    
    
    
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
	if(p_77630_1_.getItem() == SoulItems.CitrineAmuletStone.get() || 
		p_77630_1_.getItem() == SoulItems.ScarletiteAmuletStone.get() || 
		p_77630_1_.getItem() == SoulItems.JetAmuletStone.get()){
	    return false;
	}
	return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
	if(this.rarity == EnumRarity.epic){
	    return true;
	}
	else{
	    return false;
	}
    }
    
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2Entity, List par3List, boolean par4boolean) {
	int uses = this.getMaxDamage();
	int damage = (uses - par1ItemStack.getItemDamage());
	par3List.add(this.amuletType);
	if(this.getMaxDamage() > 0){
	    par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
	}
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
	boolean isUsed = false;
	if(this.isPotionBuff){
	    player.addPotionEffect(new PotionEffect(this.potionID, this.durability, 1, false));
	    isUsed = true;
	}
	
	if(this == SoulItems.AmazoniteAmuletStone.get()){
	    player.setHealth(player.getHealth() + 4);
	    isUsed = true;
	}
	else if(this == SoulItems.AquamarineAmuletStone.get()){
	    // Use to teleport
	    isUsed = true;
	}
	else if(this == SoulItems.AmethystAmuletStone.get()){
	    PotionEffect effect = player.getActivePotionEffect(Potion.poison);
	    if(effect != null){
		player.removePotionEffect(effect.getPotionID());
		isUsed = true;
	    }
	}
	else if(this == SoulItems.LilaAmuletStone.get()){
	    player.setHealth(player.getHealth() + 2);
	    isUsed = true;
	}
	// use the below 3 in a different way
	/*else if(this == SoulItems.CitrineAmuletStone.get()){
	    isUsed = true;
	}
	else if(this == SoulItems.ScarletiteAmuletStone.get()){
	    isUsed = true;
	}
	else if(this == SoulItems.JetAmuletStone.get()){
	    isUsed = true;
	}*/
	if(isUsed){
	    item.damageItem(1, player);
	}
	return false;
    }
}