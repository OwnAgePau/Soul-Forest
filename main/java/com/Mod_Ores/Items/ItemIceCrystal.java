package com.Mod_Ores.Items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemIceCrystal extends Item{	 
    private boolean hasSpawn = false;

    /**
     * Item Constructor
     * @param id this is the Item ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     */
    public ItemIceCrystal(String Unlname){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
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
	return EnumRarity.epic;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
	return true;
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {		
	if(!par3World.isRemote){
	    boolean spawned = false;
	    if(this.checkAreaForAltar(par3World, par4, par5, par6)){
		EntityIceQueen entityKingKotek = new EntityIceQueen(par3World);
		entityKingKotek.copyLocationAndAnglesFrom(par2EntityPlayer);
		entityKingKotek.onSpawnWithEgg((IEntityLivingData)null);
		spawned = par3World.spawnEntityInWorld(entityKingKotek);
		par2EntityPlayer.addChatMessage(new ChatComponentText("\u00A73You have summoned The Ice Queen!"));
		par1ItemStack.damageItem(2, par2EntityPlayer);
	    }
	    else{
		par2EntityPlayer.addChatMessage(new ChatComponentText("\u00A74The structure is incomplete!"));
	    }
	    return spawned;
	}
	else{		
	    return false;
	}
    }

    private boolean checkAreaForAltar(World par3World, int par4, int par5, int par6){
	int width = 5;
	int pillarHeight = 3;
	if(par3World.getBlock(par4, par5, par6) != SoulBlocks.AquamarineBlock.get()){
	    return false;
	}
	for(int x = 0; x < width; x++){
	    for(int z = 0; z < width; z++){
		if(x != 2 && z != 2){
		    if(par3World.getBlock(par4 + x - 2, par5, par6 + z - 2) != SoulBlocks.IceBrick.get()){
			return false;
		    }
		}
	    }
	}
	for(int y = 1; y < pillarHeight; y++){
	    if(par3World.getBlock(par4 - 2, par5 + y, par6 - 2) != SoulBlocks.IceBrick.get()){
		return false;
	    }
	    if(par3World.getBlock(par4 + 2, par5 + y, par6 - 2) != SoulBlocks.IceBrick.get()){
		return false;
	    }
	    if(par3World.getBlock(par4 - 2, par5 + y, par6 + 2) != SoulBlocks.IceBrick.get()){
		return false;
	    }
	    if(par3World.getBlock(par4 + 2, par5 + y, par6 + 2) != SoulBlocks.IceBrick.get()){
		return false;
	    }
	}
	if(par3World.getBlock(par4 - 2, par5 + pillarHeight, par6 - 2) != SoulBlocks.AmazoniteBlock.get()){
	    return false;
	}
	if(par3World.getBlock(par4 - 2, par5 + pillarHeight, par6 + 2) != SoulBlocks.AmazoniteBlock.get()){
	    return false;
	}
	if(par3World.getBlock(par4 + 2, par5 + pillarHeight, par6 - 2) != SoulBlocks.AmazoniteBlock.get()){
	    return false;
	}
	if(par3World.getBlock(par4 + 2, par5 + pillarHeight, par6 + 2) != SoulBlocks.AmazoniteBlock.get()){
	    return false;
	}
	return true;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	int uses = this.getMaxDamage();
	par3List.add("\u00A73Max Uses : " + uses);
	if(SoulForestKeyHandler.isKeyPressed){
	    par3List.add("Be sure to build an altar for your queen, ");
	    par3List.add("so she might have mercy on your soul!");
	}
	else{
	    par3List.add("Press " + Keyboard.getKeyName(SoulForestKeyHandler.keyValues[SoulForestKeyHandler.CUSTOM_INV]) + " to show more details.");
	}
    }
}
