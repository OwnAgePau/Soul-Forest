package com.Mod_Ores.Items.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBerrycollector extends Item{
    public ItemBerrycollector(){
	super();
	this.setMaxStackSize(1);
	this.setMaxDamage(238);
	this.setCreativeTab(soul_forest.tabSoulTools);
	this.setUnlocalizedName("Berrycollector");
	GameRegistry.registerItem(this, "Berrycollector", soul_forest.MODID);
	//LanguageRegistry.addName(this, "Berrycollector");
    }


    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLiving){
	if (par3 != SoulBlocks.Baneberry.get() && par3 != SoulBlocks.Blackberry.get() && par3 != SoulBlocks.Blueberry.get() && par3 != SoulBlocks.Cranberry.get() && par3 != SoulBlocks.Raspberry.get() && par3 != SoulBlocks.Razzberry.get() && par3 != SoulBlocks.Strawberry.get() && par3 != SoulBlocks.GrapesLeaves.get())
	{
	    return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLiving);
	}
	else
	{
	    return true;
	}
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    @Override
    public boolean canHarvestBlock(Block par1Block, ItemStack par2ItemStack){
	return par1Block == SoulBlocks.Baneberry.get() || par1Block == SoulBlocks.Blackberry.get() || par1Block == SoulBlocks.Blueberry.get() || par1Block == SoulBlocks.Cranberry.get() || par1Block == SoulBlocks.Raspberry.get() || par1Block == SoulBlocks.Razzberry.get() || par1Block == SoulBlocks.Strawberry.get() || par1Block == SoulBlocks.GrapesLeaves.get() || par1Block == SoulBlocks.SoulLeaves.get() || par1Block == SoulBlocks.HardwoodLeaves.get();
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    @Override
    public float getDigSpeed(ItemStack par1ItemStack, Block par2Block, int metadeta){
	return par2Block != SoulBlocks.Baneberry.get() && par2Block != SoulBlocks.Blackberry.get() && par2Block != SoulBlocks.Blueberry.get() && par2Block != SoulBlocks.Cranberry.get() && par2Block != SoulBlocks.Raspberry.get() && par2Block != SoulBlocks.Razzberry.get() && par2Block != SoulBlocks.Strawberry.get() ? (par2Block == SoulBlocks.GrapesLeaves.get() || par2Block == SoulBlocks.SoulLeaves.get() || par2Block == SoulBlocks.HardwoodLeaves.get() ? 15.0F : super.getDigSpeed(par1ItemStack, par2Block, metadeta)) : 5.0F;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
	if (player.worldObj.isRemote){
	    return false;
	}
	Block id = player.worldObj.getBlock(x, y, z);
	if (id instanceof IScollectable){
	    IScollectable target = (IScollectable)id;
	    if (target.isCollectable(itemstack, player.worldObj, x, y, z)){
		ArrayList<ItemStack> drops = target.onCollected(itemstack, player.worldObj, x, y, z,
			EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
		Random rand = new Random();

		for(ItemStack stack : drops){
		    float f = 0.7F;
		    double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
		    double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
		    double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
		    EntityItem entityitem = new EntityItem(player.worldObj, (double)x + d, (double)y + d1, (double)z + d2, stack);
		    entityitem.delayBeforeCanPickup = 10;
		    player.worldObj.spawnEntityInWorld(entityitem);
		}

		itemstack.damageItem(1, player);
		player.addStat(StatList.mineBlockStatArray[id.getIdFromBlock(id)], 1);
	    }
	}
	return false;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
	return EnumRarity.uncommon;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
	return false;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	int uses = this.getMaxDamage();
	int damage = (uses - par1ItemStack.getItemDamage());
	par3List.add("\u00A73Max Uses : " + damage + "/" + uses);
    }
}

