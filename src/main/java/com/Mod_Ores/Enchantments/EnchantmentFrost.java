package com.Mod_Ores.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;

import com.Mod_Ores.Enums.EnumCreatureHelper;
import com.Mod_Ores.Enums.EnumSoulCreatureAttribute;

public class EnchantmentFrost extends Enchantment{
    /**EnchantmentFrost constructor
     * 
     * @param par1id the effectId
     * @param par2weight the weight (rarity something)
     * @param par3enumenchantmenttype the enchantment type
     */
    public EnchantmentFrost(int par1id, int par2weight, EnumEnchantmentType par3enumenchantmenttype){
	super(par1id, par2weight, par3enumenchantmenttype);
	this.setName("Frost");
    }

    public String getName(){
	return name;
    }

    /**
     * Calculates the (magic) damage done by the enchantment on a living entity based on level and entity passed.
     */
    public float calcModifierLiving(int par1, EntityLivingBase par2EntityLivingBase){
	if(EnumCreatureHelper.getSoulCreatureAttribute(par2EntityLivingBase) == EnumSoulCreatureAttribute.FROST){
	    return (float)par1 * 2.5F;
	}
	else{
	    return (float)par1 * 0.0F;
	}
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMinEnchantability(int par1){
	return 10 + 20 * (par1 - 1);
    }

    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMaxEnchantability(int par1){
	return super.getMinEnchantability(par1) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    @Override
    public int getMaxLevel(){
	return 4;
    }
}