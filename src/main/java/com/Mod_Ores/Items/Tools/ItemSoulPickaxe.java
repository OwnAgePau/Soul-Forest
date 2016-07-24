package com.Mod_Ores.Items.Tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSoulPickaxe extends ItemPickaxe{
	
    private Item.ToolMaterial mat;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * ItemSoulPickaxe Constructor
     * @param id this is the ItemPickaxe ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param EnumToolMaterial This will set the tools material
     */
    public ItemSoulPickaxe(String Unlname, Item.ToolMaterial material, int level){
		super(material);
		this.setCreativeTab(soul_forest.tabSoulTools);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		GameRegistry.registerItem(this, Unlname);
		this.textureName = Unlname;
		this.mat = material;
		this.setHarvestLevel("pickaxe", level);
		InitItems.soulPickaxes.add(this);
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