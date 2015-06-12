package com.Mod_Ores.Init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class InitMaterials 
{
	public static Item.ToolMaterial toolAquamarine;
	public static Item.ToolMaterial toolTin;
	public static Item.ToolMaterial toolCopper;
	public static Item.ToolMaterial toolChromite;
	public static Item.ToolMaterial toolTanzanite;
	public static Item.ToolMaterial toolBronze;
	public static Item.ToolMaterial toolSilver;
	public static Item.ToolMaterial toolSteel;
	public static Item.ToolMaterial toolCobalt;
	public static Item.ToolMaterial toolMithril;
	
	public static Item.ToolMaterial toolWaraxe;
	
	public static ItemArmor.ArmorMaterial Bronze_Armor;
	public static ItemArmor.ArmorMaterial Cobalt_Armor;
	public static ItemArmor.ArmorMaterial Silver_Armor;
	public static ItemArmor.ArmorMaterial Steel_Armor;
	public static ItemArmor.ArmorMaterial Mithril_Armor;
	public static ItemArmor.ArmorMaterial Slime_Armor;
	
	public static void init()
	{
		// EnumTools
		toolAquamarine = EnumHelper.addToolMaterial("AQUAMARINE", 3, 3644, 6.5F, 3, 23);
		toolTin = EnumHelper.addToolMaterial("TIN", 1, 150, 2.5F, 1, 9);
		toolCopper = EnumHelper.addToolMaterial("COPPER", 1, 150, 2.5F, 1, 9);
		toolChromite = EnumHelper.addToolMaterial("CHROMITE", 3, 1524, 20.0F, 3, 23);
		toolTanzanite = EnumHelper.addToolMaterial("TANZANITE", 3, 1648, 7.5F, 3, 23);
		toolBronze = EnumHelper.addToolMaterial("BRONZE", 2, 408, 5.0F, 2, 14);
		toolSilver = EnumHelper.addToolMaterial("SILVER", 3, 230, 10.0F, 3, 20);
		toolSteel = EnumHelper.addToolMaterial("STEEL", 4, 2104, 11.5F, 4, 15);
		toolCobalt = EnumHelper.addToolMaterial("COBALT", 4, 2040, 11.0F, 4, 13);
		toolMithril = EnumHelper.addToolMaterial("MITHRIL", 5, 3216, 14.0F, 5, 12);
		// EnumArmors
		Bronze_Armor = EnumHelper.addArmorMaterial("BRONZE", 10, new int[]{2, 6, 3, 1}, 16);
		Slime_Armor = EnumHelper.addArmorMaterial("SLIME", 8, new int[]{2, 4, 3, 2}, 5);
		Silver_Armor = EnumHelper.addArmorMaterial("SILVER", 12, new int[]{3, 7, 4, 2}, 23);
		Steel_Armor = EnumHelper.addArmorMaterial("STEEL", 38, new int[]{4, 8, 6, 3}, 9);
		Cobalt_Armor = EnumHelper.addArmorMaterial("COBALT", 38, new int[]{4, 8, 5, 3}, 9);
		Mithril_Armor = EnumHelper.addArmorMaterial("MITHRIL", 45, new int[]{5, 9, 6, 4}, 10);
		//EnumTools for War Axes
		toolWaraxe = EnumHelper.addToolMaterial("Waraxe", 4, 2144, 12.0F, 8, 10);
		System.out.println("[Soul Forest] Materials initialized");
	}
}
