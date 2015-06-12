package com.Mod_Ores.Items;

import java.util.List;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemKingGelPot extends Item{	 
    private boolean hasSpawn = false;

    /**
     * Item Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     */
    public ItemKingGelPot(String Unlname){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
	super(); //This super will load item ID and UName
	this.setCreativeTab(soul_forest.tabSoulOther); //Set Tab in ModBase.class and place it here (with many items its VERY code-shortening), this will load unlocalized name
	setUnlocalizedName(Unlname);
	GameRegistry.registerItem(this, Unlname, soul_forest.MODID);
	this.maxStackSize = 1;
	this.setMaxDamage(1);
	hasSpawn = false;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
	return EnumRarity.rare;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
	return true;
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {		
	if(!par3World.isRemote){
	    boolean spawned = false;
	    EntityKingKotek entityKingKotek = new EntityKingKotek(par3World);
	    entityKingKotek.copyLocationAndAnglesFrom(par2EntityPlayer);
	    entityKingKotek.onSpawnWithEgg((IEntityLivingData)null);
	    spawned = par3World.spawnEntityInWorld(entityKingKotek);
	    par2EntityPlayer.addChatMessage(new ChatComponentText("\u00A72You have summoned King Kotek!"));
	    par1ItemStack.damageItem(2, par2EntityPlayer);
	    //}
	    return spawned;
	}
	else{		
	    return false;
	}
	/*if(!hasSpawn)
		{
			if(!par3World.isRemote){
				EntityKingKotek entityKingKotek = new EntityKingKotek(par3World);
				entityKingKotek.setPosition(entityKingKotek.posX + 1, entityKingKotek.posY + 0, entityKingKotek.posZ + 0);
				boolean spawned = par3World.spawnEntityInWorld(entityKingKotek);
				if(spawned)
				{
					par2EntityPlayer.addChatMessage(new ChatComponentText("\u00A73You have summoned King Kotek!"));
					par1ItemStack.damageItem(2, par2EntityPlayer);
					hasSpawn = true;
				}
				return hasSpawn;
			}
		}
		else
		{
			hasSpawn = false;
		}
		return hasSpawn;*/
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	int uses = this.getMaxDamage();
	par3List.add("\u00A73Max Uses : " + uses);
    }
}
