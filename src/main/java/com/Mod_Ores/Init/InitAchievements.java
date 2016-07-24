package com.Mod_Ores.Init;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class InitAchievements {
	// Achievements	
	public static Achievement soulForest;	
	
	//Overworld ores/ingots tree
	public static Achievement mineTinCopper;
	public static Achievement getBronze;
	public static Achievement getRareOverworldOre;
	public static Achievement getSteelOrCobaltIngot;
	public static Achievement getSteelOrCobaltPickaxe;
	public static Achievement getFyrisedArmorPiece;	
	
	//Gem collecting achievement tree		
	public static Achievement firstUncutfound; 
	public static Achievement firstGem;
	public static Achievement reinforcedSticks;
	
	//Berry collecting achievement tree
	public static Achievement berryCollectorCraft;
	public static Achievement berryCollector;
	public static Achievement soulFood;
	
	//Gel collecting achievement tree
	public static Achievement gel;
	public static Achievement gelExtractor;
	public static Achievement gelKing;
	
	// Frozen Dimension achievement tree
	public static Achievement frozenHearth;
	
	public static Achievement shards;
	public static Achievement wand;
	public static Achievement iceCrystal;
	public static Achievement iceQueen;
	
	public static Achievement iceWorkbench;
	public static Achievement gemmerationTable;
	public static Achievement gemmingTable;
	public static Achievement gembleTable;
	
	public static Achievement amuletStone;
	public static Achievement amuletRing;
	public static Achievement magicEmblem;
		
	//Place all achievements above!! And add them right at the end of this ->
	public static AchievementPage pageSoulforest;
	
	
	public static void init(){
		if(soulForest == null){
			soulForest = 		(new Achievement("achievement.soulforest", "soulForest", 0, 0, SoulBlocks.SilverBlock.get(), null).initIndependentStat().registerStat()); // Base achievement
					
			//Overworld mining & smelting tree
			mineTinCopper = 	(new Achievement("achievement.mineTinCopper", "mineTinCopper", -2, 4, SoulBlocks.Tinore.get(), null).registerStat()); // Base achievement
			getBronze = 		(new Achievement("achievement.getBronze", "getBronze", -2, 6, SoulItems.BronzeIngot.get(), mineTinCopper).registerStat()); // Base achievement
			getRareOverworldOre = 	(new Achievement("achievement.getRareOverworldOre", "getRareOverworldOre", -2, 8, SoulBlocks.Uraniumore.get(), getBronze).registerStat()); // Base achievement
			getSteelOrCobaltIngot = (new Achievement("achievement.getSteelOrCobaltIngot", "getSteelOrCobaltIngot", -4, 8, SoulItems.CobaltIngot.get(), getRareOverworldOre).setSpecial().registerStat()); // Base achievement

			//Gem collecting achievement tree			
			firstUncutfound = 	(new Achievement("achievement.firstUncutFound", "firstUncutFound", -2, 0, SoulBlocks.Amazoniteore.get(), soulForest).registerStat());
			firstGem = 			(new Achievement("achievement.firstGem", "firstGem", -4, 0, SoulBlocks.GemcutterIdle.get(), firstUncutfound).registerStat());
			reinforcedSticks = (new Achievement("achievement.reinforcedSticks", "reinforcedSticks", -6, 0, SoulItems.TitaniumStick.get(), firstGem).registerStat());
			//getSteelOrCobaltPickaxe = 	(new Achievement("achievement.getSteelOrCobaltPickaxe", "getSteelOrCobaltPickaxe", -6, -2, SoulItems.CobaltPickaxe.get(), reinforcedSticks).registerStat()); // Base achievement
			getFyrisedArmorPiece = 		(new Achievement("achievement.getFyrisedArmorPiece", "getFyrisedArmorPiece", -6, -2, SoulItems.FyrisedHelmet.get(), reinforcedSticks).setSpecial().registerStat()); // Base achievement

			// Using gems to craft enchantment books and more (gemble table and the other tables)
			frozenHearth = (new Achievement("achievement.frozenHearth", "frozenHearth", 0, -2, SoulBlocks.TurquoiseBlock.get(), null).registerStat());
			shards = (new Achievement("achievement.shards", "shards", 2, -2, SoulItems.FrostShard.get(), frozenHearth).registerStat());
			wand = (new Achievement("achievement.wand", "wand", 4, -2, SoulItems.FrostWand.get(), shards).registerStat());
			//iceCrystal = (new Achievement("achievement.iceQueen", "iceQueen", 6, -2, SoulItems.IceCrystal.get(), wand).setSpecial().registerStat());
			iceQueen = (new Achievement("achievement.iceQueen", "iceQueen", 6, -2, SoulItems.IceCrystal.get(), wand).setSpecial().registerStat());
			
			iceWorkbench = (new Achievement("achievement.iceWorkbench", "iceWorkbench", 0, -4, SoulBlocks.IceWorkbench.get(), frozenHearth).registerStat());
			gemmerationTable = (new Achievement("achievement.gemmerationTable", "gemmerationTable", -2, -5, SoulBlocks.GemmerationTable.get(), iceWorkbench).registerStat());
			gemmingTable = (new Achievement("achievement.gemmingTable", "gemmingTable", -2, -6, SoulBlocks.GemmingTable.get(), iceWorkbench).registerStat());
			gembleTable = (new Achievement("achievement.gembleTable", "gembleTable", -2, -7, SoulBlocks.GembleTable.get(), iceWorkbench).registerStat());
			
			amuletStone = (new Achievement("achievement.amuletStone", "amuletStone", 2, -6, SoulItems.AmazoniteAmuletStone.get(), iceWorkbench).registerStat());
			amuletRing = (new Achievement("achievement.amuletRing", "amuletRing", 2, -8, SoulItems.BlackdiamondAmuletRing.get(), amuletStone).registerStat());
			
			magicEmblem = (new Achievement("achievement.magicEmblem", "magicEmblem", 4, -4, SoulItems.MagicEmblem.get(), iceWorkbench).setSpecial().registerStat());
			
			//Gel collecting achievement tree
			gel = (new Achievement("achievement.gel", "gel", 2, 0, SoulItems.BlueGel.get(), soulForest).registerStat());
			gelExtractor = (new Achievement("achievement.gelExtractor", "gelExtractor", 4, 0, SoulBlocks.GelExtractor.get(), gel).registerStat());
			gelKing = (new Achievement("achievement.gelKing", "gelKing", 6, 0, SoulItems.GelPotKing.get(), gelExtractor).setSpecial().registerStat());
			
			//Berry collecting achievement tree
			berryCollectorCraft = (new Achievement("achievement.berryCollectorCraft", "berryCollectorCraft", 0, 2, SoulItems.BerryCollector.get(), soulForest).registerStat());
			berryCollector = 	(new Achievement("achievement.berryCollector", "berryCollector", 0, 4, SoulItems.CranberryBushel.get(), berryCollectorCraft).registerStat());
			soulFood = 	(new Achievement("achievement.soulFood", "soulFood", 0, 6, SoulItems.CranberryMuffin.get(), berryCollector).setSpecial().registerStat());
			
			// Achievement Page
			//Place all achievements above!! And add them right at the end of this ->
			pageSoulforest = 	(new AchievementPage("Soul Forest", soulForest, mineTinCopper, getBronze, getRareOverworldOre, 
					getSteelOrCobaltIngot, firstGem, firstUncutfound, reinforcedSticks, getFyrisedArmorPiece, 
					berryCollectorCraft, berryCollector, soulFood, gel, gelExtractor, gelKing, frozenHearth,
					shards, wand, iceQueen, iceWorkbench, gemmerationTable, gemmingTable, gembleTable, amuletStone, amuletRing, magicEmblem));
			AchievementPage.registerAchievementPage(pageSoulforest);
			System.out.println("[Soul Forest] Achievements Initiated");
		}
		else{
			System.out.println("[Soul Forest] Could not add achievements");
		}
	}
}