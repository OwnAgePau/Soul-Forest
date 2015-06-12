package com.Mod_Ores.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Mod_Ores.soul_forest;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicFragment extends Item{
    /** List of all record items and their names. */
    private static final Map fragments = new HashMap();

    /** The name of the record. */
    public final String fragmentName;
    public final String fragmentAdvancement; 
    public final Boolean isMagicalFragment;

    /**
     * 
     * @param id = is the id of the magic fragment
     * @param par2 = is the advancement of the magic fragment
     * @param name = is the fragment name
     * @param isMagical = true = Magic Fragment, false = Fragment
     */
    public ItemMagicFragment(String adv, String name, Boolean isMagical){
	super();
	this.isMagicalFragment = isMagical;
	this.fragmentAdvancement = adv;
	this.fragmentName = name;
	this.maxStackSize = 24;
	this.setCreativeTab(soul_forest.tabSoulOther);
	fragments.put(name, this);
	String fragName = "";
	if(this.isMagicalFragment){
	    if(this.fragmentAdvancement != ""){
		fragName = this.fragmentAdvancement + " " + this.fragmentName;
		GameRegistry.registerItem(this, fragName, soul_forest.MODID);
		setUnlocalizedName(fragName);
	    }
	    else{
		fragName = this.fragmentName;
		GameRegistry.registerItem(this, fragName, soul_forest.MODID);
		setUnlocalizedName(fragName);
	    }
	}
	else{
	    if(this.fragmentAdvancement == "Ehanced"){
		fragName = this.fragmentAdvancement + " " + this.fragmentName + " Fragment";
		GameRegistry.registerItem(this, "Enhanced Soul Fragment", soul_forest.MODID);
		setUnlocalizedName("Enhanced Soul Fragment");
	    }
	    else{
		fragName = this.fragmentAdvancement + this.fragmentName + " Fragment ";
		GameRegistry.registerItem(this, fragName, soul_forest.MODID);
		setUnlocalizedName(fragName);
	    }
	}     
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public IIcon getIconFromDamage(int par1){
	return this.itemIcon;
    }

    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
	par3List.add(this.getFragmentName());
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return the title for this record.
     */
    public String getFragmentName(){
	if(this.isMagicalFragment){
	    if(this.fragmentAdvancement != ""){
		return this.fragmentAdvancement + " " + this.fragmentName;
	    }
	    else{
		return this.fragmentName;
	    }
	}
	else{
	    if(this.fragmentAdvancement == "Enhanced")
	    {
		return this.fragmentAdvancement + " " + this.fragmentName;
	    }
	    else{
		return this.fragmentAdvancement + this.fragmentName + " Fragment ";
	    }
	}
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack par1ItemStack){
	if(this.fragmentAdvancement == "Half"){
	    return EnumRarity.uncommon;
	}

	if(this.fragmentAdvancement == "Advanced"){
	    return EnumRarity.epic;
	}
	else{
	    if(isMagicalFragment || this.fragmentAdvancement == "Enhanced"){
		return EnumRarity.rare;
	    }
	    else{
		return EnumRarity.uncommon;
	    }
	}
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return the record item corresponding to the given name.
     */
    public static ItemMagicFragment getRecord(String par0Str){
	return (ItemMagicFragment)fragments.get(par0Str);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister){
	String l;
	String i;
	if(this.fragmentName == ""){
	    l = "";
	}
	else{ 
	    l = "_";
	}

	if(this.fragmentAdvancement == ""){
	    i = "";
	}
	else{
	    i = "_";
	}

	if(this.isMagicalFragment){
	    this.itemIcon = par1IconRegister.registerIcon("soulforest:" + this.fragmentName + l + "Magic_Fragment" + i + this.fragmentAdvancement);
	}
	else{
	    this.itemIcon = par1IconRegister.registerIcon("soulforest:" + this.fragmentName + l + "Fragment" + i + this.fragmentAdvancement);
	}
    }
}
