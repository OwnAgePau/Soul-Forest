package com.Mod_Ores.Items.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Blocks.Special.SoulVine;
import com.Mod_Ores.Init.SoulBlocks;

public class ItemBerrycollector extends Item{
	
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
	
    public ItemBerrycollector(String unlname){
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(238);
		this.setCreativeTab(soul_forest.tabSoulTools);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlname);
		this.textureName = unlname;
		GameRegistry.registerItem(this, unlname);
    }


    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3Block, BlockPos par4Position, EntityLivingBase par5EntityLiving){
		if(par3Block instanceof SoulVine){
			return super.onBlockDestroyed(par1ItemStack, par2World, par3Block, par4Position, par5EntityLiving);
		}
		else{
		    return true;
		}
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    @Override
    public boolean canHarvestBlock(Block par1Block, ItemStack par2ItemStack){
    	return par1Block instanceof SoulVine;
    	//return par1Block == SoulBlocks.Baneberry.get() || par1Block == SoulBlocks.Blackberry.get() || par1Block == SoulBlocks.Blueberry.get() || par1Block == SoulBlocks.Cranberry.get() || par1Block == SoulBlocks.Raspberry.get() || par1Block == SoulBlocks.Razzberry.get() || par1Block == SoulBlocks.Strawberry.get() || par1Block == SoulBlocks.GrapesLeaves.get() || par1Block == SoulBlocks.SoulLeaves.get() || par1Block == SoulBlocks.HardwoodLeaves.get();
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    @Override
    public float getDigSpeed(ItemStack par1ItemStack, IBlockState par2BlockState){
    	return par2BlockState.getBlock() instanceof SoulVine ? 15.0F : super.getDigSpeed(par1ItemStack, par2BlockState);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
		if (player.worldObj.isRemote){
		    return false;
		}
		IBlockState id = player.worldObj.getBlockState(pos);
		if (id.getBlock() instanceof IScollectable){
		    IScollectable target = (IScollectable)id;
		    if (target.isCollectable(itemstack, player.worldObj, pos)){
				ArrayList<ItemStack> drops = target.onCollected(itemstack, player.worldObj, pos, EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
				Random rand = new Random();
		
				for(ItemStack stack : drops){
				    float f = 0.7F;
				    double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
				    double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
				    double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
				    EntityItem entityitem = new EntityItem(player.worldObj, (double)pos.getX() + d, (double)pos.getY() + d1, (double)pos.getZ() + d2, stack);
				    entityitem.setPickupDelay(10);
				    player.worldObj.spawnEntityInWorld(entityitem);
				}
		
				itemstack.damageItem(1, player);
				player.addStat(StatList.mineBlockStatArray[id.getBlock().getIdFromBlock(id.getBlock())], 1);
		    }
		}
		return false;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.UNCOMMON;
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