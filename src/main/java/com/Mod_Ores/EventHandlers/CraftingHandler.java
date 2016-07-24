package com.Mod_Ores.EventHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Items.*;
import com.Mod_Ores.Items.Armor.*;
import com.Mod_Ores.Blocks.*;

public class CraftingHandler{

    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event){		
		Item itemCrafted = event.crafting.getItem();
		String itemName = event.crafting.getItem().getUnlocalizedName();
		if(itemCrafted instanceof ItemSoulFood){
		    event.player.addStat(InitAchievements.soulFood, 1);
		}
	
		if (itemName.equals(SoulItems.BerryCollector.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.berryCollectorCraft, 1);
		}
	
		if(itemCrafted instanceof ItemSoulBushel){
		    event.player.addStat(InitAchievements.berryCollector, 1);
		}
	
		if (itemName.equals(SoulItems.BronzeIngot.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.getBronze, 1);
		}
	
		if (itemName.equals(SoulItems.SteelPickaxe.get().getUnlocalizedName()) || itemName.equals(SoulItems.CobaltPickaxe.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.getSteelOrCobaltPickaxe, 1);
		}
	
		if (itemName.equals(SoulItems.TitaniumStick.get().getUnlocalizedName()) || itemName.equals(SoulItems.OnyxStick.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.reinforcedSticks, 1);
		}
	
		if(itemCrafted instanceof ItemArmorFyrised){
		    event.player.addStat(InitAchievements.getFyrisedArmorPiece, 1);
		}
	
		if(itemName.equals(SoulItems.FrostWand.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.wand, 1);
		}
	
		if(itemName.equals(SoulBlocks.GelExtractor.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.gelExtractor, 1);
		}
		
		if(itemName.equals((SoulBlocks.IceWorkbench.get().getUnlocalizedName()))){
		    event.player.addStat(InitAchievements.iceWorkbench, 1);
		}
		
		if(itemName.equals((SoulBlocks.GemmerationTable.get().getUnlocalizedName()))){
		    event.player.addStat(InitAchievements.gemmerationTable, 1);
		}
		
		if(itemName.equals((SoulBlocks.GemmingTable.get().getUnlocalizedName()))){
		    event.player.addStat(InitAchievements.gemmingTable, 1);
		}
		
		if(itemName.equals((SoulBlocks.GembleTable.get().getUnlocalizedName()))){
		    event.player.addStat(InitAchievements.gembleTable, 1);
		}
		
		if(itemCrafted instanceof ItemAmuletStone){
		    event.player.addStat(InitAchievements.amuletStone, 1);
		}
		
		if(itemCrafted instanceof ItemAmuletRing){
		    event.player.addStat(InitAchievements.amuletRing, 1);
		}
		if(itemName.equals((SoulItems.MagicEmblem.get().getUnlocalizedName()))){
		    event.player.addStat(InitAchievements.magicEmblem, 1);
		}
    }

    @SubscribeEvent
    public void onSmelting(ItemSmeltedEvent event){
		String smeltedItem = event.smelting.getItem().getUnlocalizedName();
		if (smeltedItem.equals(SoulItems.SteelIngot.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.CobaltIngot.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.getSteelOrCobaltIngot, 1);
		}
		// TODO Change this to "instanceof
		if(event.smelting.getItem() instanceof ItemGem){
			event.player.addStat(InitAchievements.firstGem, 1);
		}
    }

    @SubscribeEvent
    public void onPickup(ItemPickupEvent event){
		String pickedUpItem = event.pickedUp.getEntityItem().getItem().getUnlocalizedName();
		if(pickedUpItem.equals(SoulItems.BlueGel.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.gel, 1);
		}
		if(pickedUpItem.equals(SoulItems.FrostShard.get().getUnlocalizedName()) || pickedUpItem.equals(SoulItems.StrengthShard.get().getUnlocalizedName()) || pickedUpItem.equals(SoulItems.BucketSoulWater.get().getUnlocalizedName())){
		    event.player.addStat(InitAchievements.shards, 1);
		}
    }
}

