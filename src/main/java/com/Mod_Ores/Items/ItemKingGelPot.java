package com.Mod_Ores.Items;

import java.util.List;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;

public class ItemKingGelPot extends Item{	 
	
    private boolean hasSpawn = false;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    /**
     * Item Constructor
     * @param Unlname This is the Unlocalized Name
     */
    public ItemKingGelPot(String Unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulOther); 
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
		this.maxStackSize = 1;
		this.setMaxDamage(1);
		hasSpawn = false;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.RARE;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
    	return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, 
    		float hitX, float hitY, float hitZ) {		
		if(!worldIn.isRemote){
		    boolean spawned = false;
		    EntityKingKotek entityKingKotek = new EntityKingKotek(worldIn);
		    entityKingKotek.copyLocationAndAnglesFrom(playerIn);
		    entityKingKotek.onInitialSpawn(worldIn.getDifficultyForLocation(pos), (IEntityLivingData)null);
		    spawned = worldIn.spawnEntityInWorld(entityKingKotek);
		    playerIn.addChatMessage(new ChatComponentText("\u00A72You have summoned King Kotek!"));
		    stack.damageItem(2, playerIn);
		    return spawned;
		}
		else{		
		    return false;
		}
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		int uses = this.getMaxDamage();
		par3List.add("\u00A73Max Uses : " + uses);
    }
}