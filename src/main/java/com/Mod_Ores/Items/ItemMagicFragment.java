package com.Mod_Ores.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Mod_Ores.soul_forest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMagicFragment extends Item{
    /** List of all record items and their names. */
    private static final Map fragments = new HashMap();

    /** The name of the record. */
    public final String fragmentName;
    public final String fragmentAdvancement; 
    public final Boolean isMagicalFragment;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

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
		fragments.put(name, this); //TODO Not sure if this is the correct name to store in the list, maybe use fragName instead
		String fragName = "";
		String unlocalizedFragment = "";
		if(this.isMagicalFragment){
		    if(this.fragmentAdvancement != ""){
				fragName = this.fragmentAdvancement + " " + this.fragmentName;
				unlocalizedFragment = this.fragmentName + "_Magic_Fragment_" + this.fragmentAdvancement;
		    }
		    else{
				fragName = this.fragmentName;
				unlocalizedFragment = this.fragmentName + "_Magic_Fragment";
		    }
		}
		else{
		    if(this.fragmentAdvancement == "Ehanced"){
		    	fragName = this.fragmentAdvancement + " " + this.fragmentName + " Fragment";
		    	unlocalizedFragment = this.fragmentName + "_Fragment_" + this.fragmentAdvancement;
		    }
		    else{
		    	fragName = this.fragmentAdvancement + this.fragmentName + " Fragment ";
		    	String extra = this.fragmentAdvancement.equals("") ? "" : "_" + this.fragmentAdvancement;
		    	unlocalizedFragment = this.fragmentName + "_Fragment" + extra;

		    }
		} 
		// TODO maybe also set fragName to be this fragments name so that you can get that name down below in the getFragmentName
		this.registerFragment(unlocalizedFragment);
		this.textureName = unlocalizedFragment;
    }
    
    private void registerFragment(String fagmentName){
    	GameRegistry.registerItem(this, fagmentName);
		this.setUnlocalizedName(soul_forest.MODID + "_" + fagmentName);
    }

    //@SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    /*public IIcon getIconFromDamage(int par1){
    	return this.itemIcon;
    }*/

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
		    return EnumRarity.UNCOMMON;
		}
	
		if(this.fragmentAdvancement == "Advanced"){
		    return EnumRarity.EPIC;
		}
		else{
		    if(isMagicalFragment || this.fragmentAdvancement == "Enhanced"){
		    	return EnumRarity.RARE;
		    }
		    else{
		    	return EnumRarity.UNCOMMON;
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

    /*@SideOnly(Side.CLIENT)
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
    }*/
}