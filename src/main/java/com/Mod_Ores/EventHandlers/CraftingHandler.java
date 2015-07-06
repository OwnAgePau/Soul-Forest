package com.Mod_Ores.EventHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class CraftingHandler{

    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event){		
	String craftedItem = event.crafting.getItem().getUnlocalizedName();
	if (craftedItem.equals(SoulItems.BaneberryCake.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.BlueberryMuffin.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.BlackberryCrumble.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.CranberryMuffin.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.CranberryJuice.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.RaspberryJuice.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.RazzberryJuice.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.RazzberryPie.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.StrawberryPie.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.Wine.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.soulFood, 1);
	}

	if (craftedItem.equals(SoulItems.BerryCollector.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.berryCollectorCraft, 1);
	}

	if (craftedItem.equals(SoulItems.CranberryBushel.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.RaspberryBushel.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.RazzberryBushel.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.BlueberryBushel.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.BlackberryBushel.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.BaneberryBushel.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.GrapesBushel.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.berryCollector, 1);
	}

	if (craftedItem.equals(SoulItems.BronzeIngot.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.getBronze, 1);
	}

	if (craftedItem.equals(SoulItems.SteelPickaxe.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.CobaltPickaxe.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.getSteelOrCobaltPickaxe, 1);
	}

	if (craftedItem.equals(SoulItems.TitaniumStick.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.OnyxStick.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.reinforcedSticks, 1);
	}

	if (craftedItem.equals(SoulItems.FyrisedBoots.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.FyrisedLeggings.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.FyrisedChestplate.get().getUnlocalizedName()) || craftedItem.equals(SoulItems.FyrisedHelmet.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.getFyrisedArmorPiece, 1);
	}

	if(craftedItem.equals(SoulItems.FrostWand.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.wand, 1);
	}

	if(craftedItem.equals(SoulBlocks.GelExtractor.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.gelExtractor, 1);
	}
    }

    @SubscribeEvent
    public void onSmelting(ItemSmeltedEvent event){
	String smeltedItem = event.smelting.getItem().getUnlocalizedName();
	if (smeltedItem.equals(SoulItems.SteelIngot.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.CobaltIngot.get().getUnlocalizedName())){
	    event.player.addStat(InitAchievements.getSteelOrCobaltIngot, 1);
	}
	if (smeltedItem.equals(SoulItems.AmazoniteGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.AmethystGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.AquamarineGem.get().getUnlocalizedName())
		|| smeltedItem.equals(SoulItems.BlackdiamondGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.CitrineGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.JadeGem.get().getUnlocalizedName())
		|| smeltedItem.equals(SoulItems.JetGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.LilaGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.OlivineGem.get().getUnlocalizedName())
		|| smeltedItem.equals(SoulItems.OnyxGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.OpalGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.ScarletiteGem.get().getUnlocalizedName())
		|| smeltedItem.equals(SoulItems.TitaniumGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.TopazGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.TurquoiseGem.get().getUnlocalizedName())
		|| smeltedItem.equals(SoulItems.VioletGem.get().getUnlocalizedName()) || smeltedItem.equals(SoulItems.WhiteopalGem.get().getUnlocalizedName())){
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

