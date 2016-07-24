package com.Mod_Ores.Items.Tools;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Items.Entity.EntityFrostShard;

public class ItemFrostWand extends Item{
	
    private static Minecraft mc = Minecraft.getMinecraft();
    private static World theWorld = mc.theWorld;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * ItemFrostWand Constructor
     * @param Unlname This is the Unlocalized Name
     */
    public ItemFrostWand(String Unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulTools);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		GameRegistry.registerItem(this, Unlname);
		this.textureName = Unlname;
		this.setMaxStackSize(1);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack){
    	return 300;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
    	return par1ItemStack;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){

		int j = this.getMaxItemUseDuration(par1ItemStack);
	
		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
	
		if (flag || par3EntityPlayer.inventory.hasItem(SoulItems.FrostShard.get())){
		    float f = (float)j / 20.0F;
		    f = (f * f + f * 2.0F) / 3.0F;
	
		    if ((double)f < 0.1D){
		    	//return;
		    }
	
		    if (f > 1.0F){
		    	f = 1.0F;
		    }
	
		    //EntityFrostShard entityfrostshard = new EntityFrostShard(par2World, par3EntityPlayer, f * 2.0F);
		    EntityFrostShard entityfrostshard = new EntityFrostShard(par2World, par3EntityPlayer);
	
		    if (f == 1.0F){
		    	entityfrostshard.setIsCritical(true);
		    }
	
		    int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
	
		    if (k > 0){
		    	entityfrostshard.setDamage(entityfrostshard.getDamage() + (double)k * 0.5D + 0.5D);
		    }
	
		    int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
	
		    if (l > 0){
		    	entityfrostshard.setKnockbackStrength(1);
		    }
	
		    if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0){
		    	entityfrostshard.setFire(100);
		    }
	
		    par1ItemStack.damageItem(1, par3EntityPlayer);
		    par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	
		    if(!flag){
		    	par3EntityPlayer.inventory.consumeInventoryItem(SoulItems.FrostShard.get());
		    }
	
		    par2World.spawnEntityInWorld(entityfrostshard);
		    return par1ItemStack;
		}
	
		return par1ItemStack;	      
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.RARE;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Powerfull yet painfull");
		par3List.add("");
		par3List.add("\u00A73Ammo : Frost Shards");
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
    	return true;
    }
}