package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemFrostShard extends Item
{
	public ItemFrostShard()
	{
		super();
		this.setCreativeTab(soul_forest.tabSoulOther);
		this.setUnlocalizedName("Frost_shard");
		GameRegistry.registerItem(this, "Frost_shard", soul_forest.MODID);
	}
    public String getTextureFile()
    {
        return "/mod_Ores/gui/ItemsMe.png";
    }
    
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		par3List.add("\u00A73Ammo for tool : Frost Wand");
	}
}
