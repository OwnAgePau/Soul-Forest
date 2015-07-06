/*package com.Mod_Ores.Init.Config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class SoulConfigItems 
{
	public static Configuration config;
	
	// Item ID's
	// Item Gem & Uncut ID's
	public static int amazoniteGemID; public static int amazoniteUncutID; public static int amethystGemID; public static int amethystUncutID;
	public static int aquamarineGemID; public static int aquamarineUncutID;
	public static int blackDiamondGemID; public static int blackDiamondUncutID;
	public static int citrineGemID;	public static int citrineUncutID;
	public static int jadeGemID; public static int jadeUncutID;	public static int jetGemID;	public static int jetUncutID;
	public static int lilaGemID; public static int lilaUncutID;
	public static int olivineGemID;	public static int olivineUncutID;
	public static int onyxGemID; public static int onyxUncutID;	public static int opalGemID; public static int opalUncutID;		
	public static int scarletiteGemID; public static int scarletiteUncutID;
	public static int topazGemID; public static int topazUncutID; public static int titaniumGemID; public static int titaniumUncutID;
	public static int turquoiseGemID; public static int turquoiseUncutID;
	public static int uraniumGemID;
	public static int violetGemID; public static int violetUncutID;
	public static int whiteOpalGemID; public static int whiteOpalUncutID;
	// Bushel ID's
	public static int strawberriesID;
	public static int baneberryBushelID; public static int blackberryBushelID; public static int blueberryBushelID;	public static int cranberryBushelID; public static int raspberryBushelID; public static int razzberryBushelID; public static int grapesBushelID;
	// Ingot ID's
	public static int bronzeIngotID; public static int copperIngotID; public static int cobaltIngotID; public static int chromiteIngotID; public static int silverIngotID; public static int steelIngotID; public static int tinIngotID; public static int tanzaniteIngotID; public static int mithrilIngotID;
	// Food ID's
	public static int blueberryMuffinID; public static int baneberryCakeID; public static int blackberryCrumbleID; public static int cranberryJuiceID; public static int cranberryMuffinID;	public static int raspberryJuiceID;	public static int razzberryJuiceID; public static int razzberryPieID; public static int strawberryPieID; public static int wineID;
	// Tool ID's
	public static int aquamarineAxeID; public static int bronzeAxeID; public static int copperAxeID; public static int cobaltAxeID; public static int chromiteAxeID; public static int silverAxeID; public static int steelAxeID; public static int tinAxeID; public static int tanzaniteAxeID; public static int mithrilAxeID; //public static int rubyAxeID; public static int sapphireAxeID; public static int emeraldAxeID;
	public static int aquamarinePickaxeID; public static int bronzePickaxeID; public static int copperPickaxeID; public static int cobaltPickaxeID; public static int chromitePickaxeID; public static int silverPickaxeID; public static int steelPickaxeID; public static int tinPickaxeID; public static int tanzanitePickaxeID; public static int mithrilPickaxeID; //public static int rubyPickaxeID; public static int sapphirePickaxeID; public static int emeraldPickaxeID;
	public static int aquamarineShovelID; public static int bronzeShovelID; public static int copperShovelID; public static int cobaltShovelID; public static int chromiteShovelID; public static int silverShovelID; public static int steelShovelID; public static int tinShovelID; public static int tanzaniteShovelID; public static int mithrilShovelID; //public static int rubyShovelID; public static int sapphireShovelID; public static int emeraldShovelID;
	public static int aquamarineHoeID; public static int bronzeHoeID; public static int copperHoeID; public static int cobaltHoeID; public static int chromiteHoeID; public static int silverHoeID; public static int steelHoeID; public static int tinHoeID; public static int tanzaniteHoeID; public static int mithrilHoeID; //public static int rubyHoeID; public static int sapphireHoeID; public static int emeraldHoeID;
	public static int aquamarineSwordID; public static int bronzeSwordID; public static int cobaltSwordID; public static int chromiteSwordID; public static int silverSwordID; public static int steelSwordID; public static int mithrilSwordID; public static int tanzaniteSwordID; //public static int rubySwordID; public static int sapphireSwordID; public static int emeraldSwordID;
	public static int aquamarineWaraxeID;
	public static int tinThrowingknifeID;
	public static int copperThrowingknifeID;
	// Armor ID's
	public static int bronzeHelmetID; public static int cobaltHelmetID; public static int mithrilHelmetID; public static int silverHelmetID; public static int steelHelmetID;
	public static int bronzeChestplateID; public static int cobaltChestplateID; public static int mithrilChestplateID; public static int silverChestplateID; public static int steelChestplateID;
	public static int bronzeLeggingsID; public static int cobaltLeggingsID; public static int mithrilLeggingsID; public static int silverLeggingsID; public static int steelLeggingsID;
	public static int bronzeBootsID; public static int cobaltBootsID; public static int mithrilBootsID; public static int silverBootsID; public static int steelBootsID;
	// Custom Item ID's
	public static int polisherID; public static int polisherTowelID;
	public static int uraniumLiquidID;
	public static int berryCollectorID;
	public static int soulLighterID;
	public static int frostWandID;
	public static int bucketSoulWaterID;
	public static int soulBucketID;
	public static int frostShardID;
	public static int frozenRodID;
	public static int blueGelID;
	public static int blueMoltenGelID;
	public static int gelPotID;
	public static int gelPotFilledID;
	public static int gelPotKingID;
	public static int burnedShardID;
	public static int lightShardID;
	public static int strenghtShardID;
	public static int soulID;
	public static int mochanEagleFeatherID;
	public static int mochanEagleWingID;
			
	public static int itemVineplantID;
	
	public static int frozenStickID;
	public static int onyxStickID;
	public static int titaniumStickID;
			
	public static int magicEmblemID;
	// Magic Fragment ID's
	public static int burnedFragmentID;
	public static int frostFragmentID;
	public static int lightFragmentID;
	public static int soulFragmentID;
	public static int strenghtFragmentID;
	public static int soulFragmentEnhancedID;
	public static int burnedMagicFragmentAdvID;
	public static int enlightedMagicFragmentAdvID;
	public static int fireMagicFragmentAdvID;
	public static int flightMagicFragmentAdvID;
	public static int frozenMagicFragmentAdvID;
	public static int hardenedMagicFragmentAdvID;
	public static int powerMagicFragmentAdvID;
	public static int sharpMagicFragmentAdvID;
	public static int shinyMagicFragmentAdvID;
	public static int soulMagicFragmentAdvID;
	public static int strenghtMagicFragmentAdvID;
	public static int strongMagicFragmentAdvID;
			
	public static int enlightedMagicFragmentHalfID;
	public static int fireMagicFragmentHalfID;
	public static int flightMagicFragmentHalfID;
	public static int frozenMagicFragmentHalfID;
	public static int hardenedMagicFragmentHalfID;
	public static int powerMagicFragmentHalfID;
	public static int sharpMagicFragmentHalfID;
	public static int shinyMagicFragmentHalfID;
	public static int soulMagicFragmentHalfID;
	public static int strenghtMagicFragmentHalfID;
	public static int strongMagicFragmentHalfID;
	
	public static int burnedMagicFragmentID;
	public static int enlightedMagicFragmentID;
	public static int fireMagicFragmentID;
	public static int flightMagicFragmentID;
	public static int frozenMagicFragmentID;
	public static int hardenedMagicFragmentID;
	public static int hotMagicFragmentID;
	public static int powerMagicFragmentID;
	public static int sharpMagicFragmentID;
	public static int shinyMagicFragmentID;
	public static int soulMagicFragmentID;
	public static int strenghtMagicFragmentID;
	public static int strongMagicFragmentID;
			
	public static void init(File configFile)
	{
		config = new Configuration(configFile);
	
		try
		{
			config.load();
			
			// Configurations
			// Item ID's
			// Gem & Uncut ID's
			amazoniteGemID = config.get("Item ID's", "Amazonite Gem", 26300).getInt();
			amazoniteUncutID = config.get("Item ID's", "Amazonite Uncut", 26301).getInt();
			amethystGemID = config.get("Item ID's", "Amethyst Gem", 26302).getInt();
			amethystUncutID = config.get("Item ID's", "Amethyst Uncut", 26303).getInt();
			aquamarineGemID = config.get("Item ID's", "Aquamarine Gem", 26304).getInt();
			aquamarineUncutID = config.get("Item ID's", "Aquamarine Uncut", 26305).getInt();
			blackDiamondGemID = config.get("Item ID's", "Black Diamond Gem", 26306).getInt();
			blackDiamondUncutID = config.get("Item ID's", "Black Diamond Uncut", 26307).getInt();
			citrineGemID = config.get("Item ID's", "Citrine Gem", 26308).getInt();
			citrineUncutID = config.get("Item ID's", "Citrine Uncut", 26309).getInt();
			jadeGemID = config.get("Item ID's", "Jade Gem", 26312).getInt();
			jadeUncutID = config.get("Item ID's", "Jade Uncut", 26313).getInt();
			jetGemID = config.get("Item ID's", "Jet Gem", 26314).getInt();
			jetUncutID = config.get("Item ID's", "Jet Uncut", 26315).getInt();
			lilaGemID = config.get("Item ID's", "Lila Gem", 26317).getInt();
			lilaUncutID = config.get("Item ID's", "Lila Uncut", 26318).getInt();
			olivineGemID = config.get("Item ID's", "Olivine Gem", 26319).getInt();
			olivineUncutID = config.get("Item ID's", "Olivine Uncut", 26320).getInt();
			onyxGemID = config.get("Item ID's", "Onyx Gem", 26321).getInt();
			onyxUncutID = config.get("Item ID's", "Onyx Uncut", 26322).getInt();
			opalGemID = config.get("Item ID's", "Opal Gem", 26323).getInt();
			opalUncutID = config.get("Item ID's", "Opal Uncut", 26324).getInt();
			scarletiteGemID = config.get("Item ID's", "Scarletite Gem", 26329).getInt();
			scarletiteUncutID = config.get("Item ID's", "Scarletite Uncut", 26330).getInt();
			topazGemID = config.get("Item ID's", "Topaz Gem", 26331).getInt();
			topazUncutID = config.get("Item ID's", "Topaz Uncut", 26332).getInt();
			titaniumGemID = config.get("Item ID's", "Titanium Gem", 26333).getInt();
			titaniumUncutID = config.get("Item ID's", "Titanium Uncut", 26334).getInt();
			turquoiseGemID = config.get("Item ID's", "Turquoise Gem", 26335).getInt();
			turquoiseUncutID = config.get("Item ID's", "Turquoise Uncut", 26336).getInt();
			uraniumGemID = config.get("Item ID's", "Uranium Gem", 26337).getInt();
			violetGemID = config.get("Item ID's", "Violet Gem", 26338).getInt();
			violetUncutID = config.get("Item ID's", "Violet Uncut", 26339).getInt();
			whiteOpalGemID = config.get("Item ID's", "White Opal Gem", 26340).getInt();
			whiteOpalUncutID = config.get("Item ID's", "White Opal Uncut", 26341).getInt();
			// Bushel ID's
			baneberryBushelID = config.get("Bushel ID's", "Baneberry Bushel", 26342).getInt();
			blackberryBushelID = config.get("Bushel ID's", "Blackberry Bushel", 26343).getInt();
			blueberryBushelID = config.get("Bushel ID's", "Blueberry Bushel", 26344).getInt();
			cranberryBushelID = config.get("Bushel ID's", "Cranberry Bushel", 26345).getInt();
			raspberryBushelID = config.get("Bushel ID's", "Raspberry Bushel", 26346).getInt();
			razzberryBushelID = config.get("Bushel ID's", "Razzberry Bushel", 26347).getInt();
			grapesBushelID = config.get("Bushel ID's", "Grapes Bushel", 26348).getInt();
			strawberriesID = config.get("Bushel ID's", "Strawberries", 26478).getInt();
			// Ingot ID's
			bronzeIngotID = config.get("Ingot ID's", "Bronze Ingot", 26349).getInt();
			copperIngotID = config.get("Ingot ID's", "Copper Ingot", 26350).getInt();
			cobaltIngotID = config.get("Ingot ID's", "Cobalt Ingot", 26351).getInt();
			chromiteIngotID = config.get("Ingot ID's", "Chromite Ingot", 26352).getInt();
			silverIngotID = config.get("Ingot ID's", "Silver Ingot", 26354).getInt();
			steelIngotID = config.get("Ingot ID's", "Steel Ingot", 26355).getInt();
			tinIngotID = config.get("Ingot ID's", "Tin Ingot", 26356).getInt();
			tanzaniteIngotID = config.get("Ingot ID's", "Tanzanite Ingot", 26357).getInt();
			mithrilIngotID = config.get("Ingot ID's", "Mithril Ingot", 26358).getInt();
			/// Food ID's
			blueberryMuffinID = config.get("Food ID's", "Blueberry Muffin", 26359).getInt();
			baneberryCakeID = config.get("Food ID's", "Baneberry Cake", 26360).getInt();
			blackberryCrumbleID = config.get("Food ID's", "Blackberry Crumble", 26361).getInt();
			cranberryJuiceID = config.get("Food ID's", "Cranberry Juice", 26362).getInt();
			cranberryMuffinID = config.get("Food ID's", "Cranberry Muffin", 26363).getInt();
			raspberryJuiceID = config.get("Food ID's", "Raspberry Juice", 26364).getInt();
			razzberryJuiceID = config.get("Food ID's", "Razzberry Juice", 26365).getInt();
			razzberryPieID = config.get("Food ID's", "Razzberry Pie", 26366).getInt();
			strawberryPieID = config.get("Food ID's", "Strawberry Pie", 26367).getInt();
			wineID = config.get("Food ID's", "Wine", 26368).getInt();
			// Tool ID's
				// Axe ID's
				aquamarineAxeID = config.get("Tool ID's", "Aquamarine Axe", 26373).getInt();
				bronzeAxeID = config.get("Tool ID's", "Bronze Axe", 26369).getInt();
				copperAxeID = config.get("Tool ID's", "Copper Axe", 26370).getInt();
				cobaltAxeID = config.get("Tool ID's", "Cobalt Axe", 26371).getInt();
				chromiteAxeID = config.get("Tool ID's", "Chromite Axe", 26372).getInt();
				silverAxeID = config.get("Tool ID's", "Silver Axe", 26374).getInt();
				steelAxeID = config.get("Tool ID's", "Steel Axe", 26375).getInt();
				tinAxeID = config.get("Tool ID's", "Tin Axe", 26376).getInt();
				tanzaniteAxeID = config.get("Tool ID's", "Tanzanite Axe", 26377).getInt();
				mithrilAxeID = config.get("Tool ID's", "Mithril Axe", 26378).getInt();
				// Hoe ID's
				aquamarineHoeID = config.get("Tool ID's", "Aquamarine Hoe", 26380).getInt();
				bronzeHoeID = config.get("Tool ID's", "Bronze Hoe", 26381).getInt();
				copperHoeID = config.get("Tool ID's", "Copper Hoe", 26382).getInt();
				cobaltHoeID = config.get("Tool ID's", "Cobalt Hoe", 26383).getInt();
				chromiteHoeID = config.get("Tool ID's", "Chromite Hoe", 26384).getInt();
				silverHoeID = config.get("Tool ID's", "Silver Hoe", 26386).getInt();
				steelHoeID = config.get("Tool ID's", "Steel Hoe", 26387).getInt();
				tinHoeID = config.get("Tool ID's", "Tin Hoe", 26388).getInt();
				tanzaniteHoeID = config.get("Tool ID's", "Tanzanite Hoe", 26389).getInt();
				mithrilHoeID = config.get("Tool ID's", "Mithril Hoe", 26390).getInt();
				// Pickaxe ID's
				aquamarinePickaxeID = config.get("Tool ID's", "Aquamarine Pickaxe", 26392).getInt();
				bronzePickaxeID = config.get("Tool ID's", "Bronze Pickaxe", 26393).getInt();
				copperPickaxeID = config.get("Tool ID's", "Copper Pickaxe", 26394).getInt();
				cobaltPickaxeID = config.get("Tool ID's", "Cobalt Pickaxe", 26395).getInt();
				chromitePickaxeID = config.get("Tool ID's", "Chromite Pickaxe", 26396).getInt();
				silverPickaxeID = config.get("Tool ID's", "Silver Pickaxe", 26398).getInt();
				steelPickaxeID = config.get("Tool ID's", "Steel Pickaxe", 26399).getInt();
				tinPickaxeID = config.get("Tool ID's", "Tin Pickaxe", 26400).getInt();
				tanzanitePickaxeID = config.get("Tool ID's", "Tanzanite Pickaxe", 26401).getInt();
				mithrilPickaxeID = config.get("Tool ID's", "Mithril Pickaxe", 26402).getInt();
				// Shovel ID's
				aquamarineShovelID = config.get("Tool ID's", "Aquamarine Shovel", 26404).getInt();
				bronzeShovelID = config.get("Tool ID's", "Bronze Shovel", 26405).getInt();
				copperShovelID = config.get("Tool ID's", "Copper Shovel", 26406).getInt();
				cobaltShovelID = config.get("Tool ID's", "Cobalt Shovel", 26407).getInt();
				chromiteShovelID = config.get("Tool ID's", "Chromite Shovel", 26408).getInt();
				silverShovelID = config.get("Tool ID's", "Silver Shovel", 26410).getInt();
				steelShovelID = config.get("Tool ID's", "Steel Shovel", 26411).getInt();
				tinShovelID = config.get("Tool ID's", "Tin Shovel", 26412).getInt();
				tanzaniteShovelID = config.get("Tool ID's", "Tanzanite Shovel", 26413).getInt();
				mithrilShovelID = config.get("Tool ID's", "Mithril Shovel", 26414).getInt();
				// Sword ID's
				aquamarineSwordID = config.get("Tool ID's", "Aquamarine Sword", 26416).getInt();
				bronzeSwordID = config.get("Tool ID's", "Bronze Sword", 26417).getInt();
				cobaltSwordID = config.get("Tool ID's", "Cobalt Sword", 26419).getInt();
				chromiteSwordID = config.get("Tool ID's", "Chromite Sword", 26420).getInt();
				silverSwordID = config.get("Tool ID's", "Silver Sword", 26422).getInt();
				steelSwordID = config.get("Tool ID's", "Steel Sword", 26423).getInt();
				mithrilSwordID = config.get("Tool ID's", "Mithril Sword", 26426).getInt();
				tanzaniteSwordID = config.get("Tool ID's", "Tanzanite Sword", 26415).getInt();
			// Armor ID's
				// Boot ID's
				bronzeBootsID = config.get("Armor ID's", "Bronze Boots", 26429).getInt();
				cobaltBootsID = config.get("Armor ID's", "Cobalt Boots", 26430).getInt();
				mithrilBootsID = config.get("Armor ID's", "Mithril Boots", 26432).getInt();
				silverBootsID = config.get("Armor ID's", "Silver Boots", 26433).getInt();
				steelBootsID = config.get("Armor ID's", "Steel Boots", 26434).getInt();
				// Legging ID's
				bronzeLeggingsID = config.get("Armor ID's", "Bronze Leggings", 26436).getInt();
				cobaltLeggingsID = config.get("Armor ID's", "Cobalt Leggings", 26437).getInt();
				mithrilLeggingsID = config.get("Armor ID's", "Mithril Leggings", 26439).getInt();
				silverLeggingsID = config.get("Armor ID's", "Silver Leggings", 26440).getInt();
				steelLeggingsID = config.get("Armor ID's", "Steel Leggings", 26441).getInt();
				// Chestplate ID's
				bronzeChestplateID = config.get("Armor ID's", "Bronze Chestplate", 26443).getInt();
				cobaltChestplateID = config.get("Armor ID's", "Cobalt Chestplate", 26444).getInt();
				mithrilChestplateID = config.get("Armor ID's", "Mithril Chestplate", 26446).getInt();
				silverChestplateID = config.get("Armor ID's", "Silver Chestplate", 26447).getInt();
				steelChestplateID = config.get("Armor ID's", "Steel Chestplate", 26448).getInt();
				// Helmet ID's
				bronzeHelmetID = config.get("Armor ID's", "Bronze Helmet", 26450).getInt();
				cobaltHelmetID = config.get("Armor ID's", "Cobalt Helmet", 26451).getInt();
				mithrilHelmetID = config.get("Armor ID's", "Mithril Helmet", 26453).getInt();
				silverHelmetID = config.get("Armor ID's", "Silver Helmet", 26454).getInt();
				steelHelmetID = config.get("Armor ID's", "Steel Helmet", 26455).getInt();		
			// Custom Item ID's
				polisherID = config.get("Custom Item ID's", "Polisher", 26457).getInt();
				polisherTowelID = config.get("Custom Item ID's", "Polisher Towel", 26458).getInt();
				uraniumLiquidID = config.get("Custom Item ID's", "Uranium Liquid", 26459).getInt();
				berryCollectorID = config.get("Custom Item ID's", "Berrycollector", 26460).getInt();
				soulLighterID = config.get("Custom Item ID's", "Soul Lighter", 26461).getInt();
				bucketSoulWaterID = config.get("Custom Item ID's", "Soul Water Bucket", 26462).getInt();
				soulBucketID = config.get("Custom Item ID's", "Empty Soul Water Bucket", 26463).getInt();
				frostShardID = config.get("Custom Item ID's", "Frost Shard", 26464).getInt();
				frozenRodID = config.get("Custom Item ID's", "Frozen Rod", 26465).getInt();
				blueGelID = config.get("Custom Item ID's", "Blue Gel", 26466).getInt();
				frostWandID = config.get("Custom Item ID's", "Frost Wand", 26467).getInt();
				onyxStickID = config.get("Custom Item ID's", "Onyx Stick", 26468).getInt();
				titaniumStickID = config.get("Custom Item ID's", "Titanium Stick", 26469).getInt();
				frozenStickID = config.get("Custom Item ID's", "Frozen Stick", 26470).getInt();
				burnedShardID = config.get("Custom Item ID's", "Burned Shard", 26471).getInt();
				lightShardID = config.get("Custom Item ID's", "Light Shard", 26472).getInt();
				strenghtShardID = config.get("Custom Item ID's", "Strenght Shard", 26473).getInt();
				soulID = config.get("Custom Item ID's", "Soul", 26474).getInt();
				magicEmblemID = config.get("Custom Item ID's", "Magic Emblem", 26475).getInt();
				mochanEagleFeatherID = config.get("Custom Item ID's", "Mochan Eagle Feather", 26476).getInt();
				mochanEagleWingID = config.get("Custom Item ID's", "Mochan Eagle Wing", 26477).getInt();
				blueMoltenGelID = config.get("Custom Item ID's", "Blue Molten Gel", 26478).getInt();
				gelPotID = config.get("Custom Item ID's", "Gel Pot Empty", 26479).getInt();
				gelPotFilledID = config.get("Custom Item ID's", "Gel Pot Filled", 26480).getInt();
				gelPotKingID = config.get("Custom Item ID's", "King Gel Pot", 26481).getInt();
				itemVineplantID = config.get("Custom Item ID's", "Item Vineplant", 26482).getInt();
				// War Axes
				aquamarineWaraxeID = config.get("Tool ID's", "Aquamarine War Axe", 26490).getInt();
				tinThrowingknifeID = config.get("Tool ID's", "Tin Throwing Knife", 26491).getInt();
				copperThrowingknifeID = config.get("Tool ID's", "Copper Throwing Knife", 26492).getInt();
				
			// Magic Fragment ID's
				burnedFragmentID = config.get("Fragment ID's", "Burned Fragment", 26500).getInt();
				frostFragmentID  = config.get("Fragment ID's", "Frost Fragment", 26501).getInt();
				lightFragmentID = config.get("Fragment ID's", "Light Fragment", 26502).getInt();
				soulFragmentID = config.get("Fragment ID's", "Soul Fragment", 26503).getInt();
				strenghtFragmentID = config.get("Fragment ID's", "Strenght Fragment", 26504).getInt();
				soulFragmentEnhancedID = config.get("Fragment ID's", "Soul Fragment Enhanced", 26505).getInt();
				burnedMagicFragmentAdvID = config.get("Fragment ID's", "Burned Magic Fragment Advanced", 26506).getInt();
				enlightedMagicFragmentAdvID = config.get("Fragment ID's", "Enlighted Magic Fragment Advanced", 26507).getInt();
				fireMagicFragmentAdvID = config.get("Fragment ID's", "Fire Magic Fragment Advanced", 26508).getInt();
				flightMagicFragmentAdvID = config.get("Fragment ID's", "Flight Magic Fragment Advanced", 26509).getInt();
				frozenMagicFragmentAdvID = config.get("Fragment ID's", "Frozen Magic Fragment Advanced", 26510).getInt();
				hardenedMagicFragmentAdvID = config.get("Fragment ID's", "Hardened Magic Fragment Advanced", 26511).getInt();
				powerMagicFragmentAdvID = config.get("Fragment ID's", "Power Magic Fragment Advanced", 26512).getInt();
				sharpMagicFragmentAdvID = config.get("Fragment ID's", "Sharp Magic Fragment Advanced", 26513).getInt();
				shinyMagicFragmentAdvID = config.get("Fragment ID's", "Shiny Magic Fragment Advanced", 26514).getInt();
				soulMagicFragmentAdvID = config.get("Fragment ID's", "Soul Magic Fragment Advanced", 26515).getInt();
				strenghtMagicFragmentAdvID = config.get("Fragment ID's", "Strenght Magic Fragment Advanced", 26516).getInt();
				strongMagicFragmentAdvID = config.get("Fragment ID's", "Strong Magic Fragment Advanced", 26517).getInt();
				enlightedMagicFragmentHalfID = config.get("Fragment ID's", "Enlighted Magic Fragment Half", 26518).getInt();
				fireMagicFragmentHalfID = config.get("Fragment ID's", "Fire Magic Fragment Half", 26519).getInt();
				flightMagicFragmentHalfID = config.get("Fragment ID's", "Flight Magic Fragment Half", 26520).getInt();
				frozenMagicFragmentHalfID = config.get("Fragment ID's", "Frozen Magic Fragment Half", 26521).getInt();
				hardenedMagicFragmentHalfID = config.get("Fragment ID's", "Hardened Magic Fragment Half", 26522).getInt();
				powerMagicFragmentHalfID = config.get("Fragment ID's", "Power Magic Fragment Half", 26523).getInt();
				sharpMagicFragmentHalfID = config.get("Fragment ID's", "Sharp Magic Fragment Half", 26524).getInt();
				shinyMagicFragmentHalfID = config.get("Fragment ID's", "Shiny Magic Fragment Half", 26525).getInt();
				soulMagicFragmentHalfID = config.get("Fragment ID's", "Soul Magic Fragment Half", 26526).getInt();
				strenghtMagicFragmentHalfID = config.get("Fragment ID's", "Strenght Magic Fragment Half", 26527).getInt();
				strongMagicFragmentHalfID = config.get("Fragment ID's", "Strong Magic Fragment Half", 26528).getInt();
				burnedMagicFragmentID = config.get("Fragment ID's", "Burned Magic Fragment", 26529).getInt();
				enlightedMagicFragmentID = config.get("Fragment ID's", "Enlighted Magic Fragment", 26530).getInt();
				fireMagicFragmentID = config.get("Fragment ID's", "Fire Magic Fragment", 26531).getInt();
				flightMagicFragmentID = config.get("Fragment ID's", "Flight Magic Fragment", 26532).getInt();
				frozenMagicFragmentID = config.get("Fragment ID's", "Frozen Magic Fragment", 26533).getInt();
				hardenedMagicFragmentID = config.get("Fragment ID's", "Hardened Magic Fragment", 26534).getInt();
				hotMagicFragmentID = config.get("Fragment ID's", "Hot Magic Fragment", 26535).getInt();
				powerMagicFragmentID = config.get("Fragment ID's", "Power Magic Fragment", 26536).getInt();
				sharpMagicFragmentID = config.get("Fragment ID's", "Sharp Magic Fragment", 26537).getInt();
				shinyMagicFragmentID = config.get("Fragment ID's", "Shiny Magic Fragment", 26538).getInt();
				soulMagicFragmentID = config.get("Fragment ID's", "Soul Magic Fragment", 26539).getInt();
				strenghtMagicFragmentID = config.get("Fragment ID's", "Strenght Magic Fragment", 26540).getInt();
				strongMagicFragmentID = config.get("Fragment ID's", "Strong Magic Fragment", 26541).getInt();				
			
			FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[Soul Forest] [ConfigItems] Generated Config!");
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Soul Forest has had a problem loading its configuration : [ConfigItems]");
		}
		finally
		{
			if (config.hasChanged()) 
			{
				config.save();
			}
		}
	}
}*/
