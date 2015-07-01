package com.Mod_Ores.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulLighter extends Item
{
    public ItemSoulLighter()
    {
	super();
	this.maxStackSize = 1;
	this.setMaxDamage(2);
	this.setCreativeTab(soul_forest.tabSoulTools);
	this.setUnlocalizedName("soul_lighter");
	GameRegistry.registerItem(this, "soul_lighter", soul_forest.MODID);
	//LanguageRegistry.addName(this, "Soul Lighter");
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
	if (par7 == 0)
	{
	    --par5;
	}

	if (par7 == 1)
	{
	    ++par5;
	}

	if (par7 == 2)
	{
	    --par6;
	}

	if (par7 == 3)
	{
	    ++par6;
	}

	if (par7 == 4)
	{
	    --par4;
	}

	if (par7 == 5)
	{
	    ++par4;
	}

	if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	{
	    return false;
	}
	else
	{
	    Block i1 = par3World.getBlock(par4, par5, par6);

	    if (i1.isAir(par3World, par4, par5, par6))
	    {
		par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
		par3World.setBlock(par4, par5, par6, SoulBlocks.SoulFire.get());
	    }

	    par1ItemStack.damageItem(1, par2EntityPlayer);
	    return true;
	}
    }

    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
	return EnumRarity.uncommon;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
	return true;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	int uses = this.getMaxDamage();
	int damage = (uses - par1ItemStack.getItemDamage());
	par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
    }
}