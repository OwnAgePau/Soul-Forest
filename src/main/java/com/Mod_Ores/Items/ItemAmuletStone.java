package com.Mod_Ores.Items;

import java.util.List;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAmuletStone extends Item{

    private EnumRarity rarity;
    private int potionID;
    private int durability;
    private String amuletType;
    private String amuletDescription;
    private boolean isPotionBuff;
    private String usage;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    /** Create an amulet without a rarity and a different use then a potion effect
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     */
    public ItemAmuletStone(String Unlname, int durability, String description, String usage, boolean isPotionBuffed){
		super();
		this.registerItem(Unlname, durability, isPotionBuffed);
		this.textureName = Unlname;
		this.amuletDescription = description;
		this.usage = usage;
    }

    /** Create an amulet with a rarity and a different use then a potion effect.
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     * @param rarity the rarity of the amulet
     */
    public ItemAmuletStone(String Unlname, int durability, EnumRarity rarity, String description, String usage){
    	this(Unlname, durability, description, usage, false);
		this.rarity = rarity;
    }

    /** Create an amulet with a potion and without a rarity
     * 
     * @param Unlname the name of the amulet
     * @param durability the durability of the potion
     * @param potionID the id of the potion
     */
    public ItemAmuletStone(String Unlname, int potionID, int potionDurability, int durability, String description, String usage){
		this(Unlname, durability, description, usage, true);
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
    public ItemAmuletStone(String Unlname, int potionID, int potionDurability, int durability, EnumRarity rarity, String description, String usage){
		this(Unlname, potionID, potionDurability, durability, description, usage);
		this.rarity = rarity;
    }
    
    private void registerItem(String Unlname, int durability, boolean isPotionBuff){
		this.setCreativeTab(soul_forest.tabAmulets);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		GameRegistry.registerItem(this, Unlname);
		this.setMaxDamage(durability);
		this.isPotionBuff = isPotionBuff;
		this.canRepair = true;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
		if(this.rarity != null){
		    return this.rarity;
		}
		else{
		    return EnumRarity.COMMON;
		}
    }

    public ItemAmuletStone setAmuletStoneType(String type){
		this.amuletType = type;
		return this;
    }
    
    /*@Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
		if(p_77630_1_.getItem() == SoulItems.CitrineAmuletStone.get() || 
			p_77630_1_.getItem() == SoulItems.ScarletiteAmuletStone.get() || 
			p_77630_1_.getItem() == SoulItems.JetAmuletStone.get()){
		    return false;
		}
		return true;
    }*/

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
		if(this.rarity == EnumRarity.EPIC){
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
		    par3List.add("\u00A73" + this.amuletDescription);
		    par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
		    par3List.add("Usage: " + this.usage);
		    if(this.durability > 0){
			par3List.add("Duration: " + this.durability);
		    }
		}
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		boolean isUsed = false;
		if(this.isPotionBuff){
		    player.addPotionEffect(new PotionEffect(this.potionID, this.durability, 1, false, true));
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
		if(isUsed){
		    item.damageItem(1, player);
		}
		return false;
    }
}