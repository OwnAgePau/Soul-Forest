package com.Mod_Ores.Items.Tools;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Items.Entity.EntityCopperThrowingKnife;
import com.Mod_Ores.Items.Entity.EntityTinThrowingKnife;

public class ItemThrowingKnife extends Item{
	
    private static Minecraft mc = Minecraft.getMinecraft();
    private static World theWorld = mc.theWorld;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * ItemThrowingKnife Constructor
     * @param id this is the Throwing Knife ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     */
    public ItemThrowingKnife(String Unlname){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
		super(); //This super will load item ID and UName
		this.setCreativeTab(soul_forest.tabSoulTools); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
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
    public int getItemStackLimit() {
    	return 64;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		int j = this.getMaxItemUseDuration(par1ItemStack);
	
		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
	
		if (flag || par3EntityPlayer.inventory.hasItem(this)){
		    float f = (float)j / 20.0F;
		    f = (f * f + f * 2.0F) / 3.0F;
	
		    if ((double)f < 0.1D){
		    	//return;
		    }
	
		    if (f > 1.0F){
		    	f = 1.0F;
		    }
		    EntityCopperThrowingKnife entityCopper = null;
		    EntityTinThrowingKnife entityTin = null;
	
		    if(this == SoulItems.CopperThrowingknife.get()){
		    	entityCopper = new EntityCopperThrowingKnife(par2World, par3EntityPlayer, f * 2.0F);
		    }
		    else if(this == SoulItems.TinThrowingknife.get()){
		    	entityTin = new EntityTinThrowingKnife(par2World, par3EntityPlayer, f * 2.0F);
		    }
	
		    if (f == 1.0F){
				if(entityCopper != null){
				    entityCopper.setIsCritical(true);
				}
				else{
				    entityTin.setIsCritical(true);
				}
		    }
	
		    int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
	
		    if (k > 0){
				if(entityCopper != null){
				    entityCopper.setDamage(entityCopper.getDamage() + (double)k * 0.5D + 0.5D);
				}
				else{
				    entityTin.setDamage(entityTin.getDamage() + (double)k * 0.5D + 0.5D);
				}
		    }
	
		    int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
	
		    if (l > 0){
				if(entityCopper != null){
				    entityCopper.setKnockbackStrength(1);
				}
				else{
				    entityTin.setKnockbackStrength(1);
				}
		    }
	
		    if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0){
				if(entityCopper != null){
				    entityCopper.setFire(100);
				}
				else{
				    entityTin.setFire(100);
				}
		    }
	
		    par1ItemStack.damageItem(1, par3EntityPlayer);
		    par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	
		    if(!flag){
		    	par3EntityPlayer.inventory.consumeInventoryItem(this);
		    }	            
	
		    if(entityCopper != null){
		    	par2World.spawnEntityInWorld(entityCopper);
		    }
		    else{
		    	par2World.spawnEntityInWorld(entityTin);
		    }
	
		    return par1ItemStack;
		}
	
		return par1ItemStack;	      
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	par3List.add("Consumable");
    }
}