/*package com.Mod_Ores.Init.Config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class SoulConfigBlocks 
{
	public static Configuration config;
	
	// Block ID's
	// Block Ore ID's 
	public static int amazoniteOreID; public static int amethystOreID; public static int aquamarineOreID;
	public static int blackDiamondOreID;
	public static int chromiteOreID; public static int citrineOreID; public static int cobaltOreID; public static int copperOreID;		
	public static int jadeOreID; public static int jetOreID;
	public static int lilaOreID;
	public static int mithrilOreID;
	public static int olivineOreID;	public static int onyxOreID; public static int opalOreID;		
	public static int scarletiteOreID; public static int silverOreID; public static int steelOreID;
	public static int tanzaniteOreID; public static int tinOreID; public static int topazOreID;	public static int titaniumOreID; public static int turquoiseOreID;
	public static int uraniumOreID;
	public static int violetOreID;
	public static int whiteOpalOreID;		
	// Storage Block ID's
	public static int amazoniteBlockID; public static int amethystBlockID; public static int aquamarineBlockID;
	public static int blackDiamondBlockID; public static int bronzeBlockID;
	public static int chromiteBlockID; public static int citrineBlockID; public static int cobaltBlockID; public static int copperBlockID;		
	public static int jadeBlockID; public static int jetBlockID;
	public static int lilaBlockID;
	public static int mithrilBlockID;
	public static int olivineBlockID;	public static int onyxBlockID; public static int opalBlockID;		
	public static int scarletiteBlockID; public static int silverBlockID; public static int steelBlockID;
	public static int tanzaniteBlockID; public static int tinBlockID; public static int topazBlockID;	public static int titaniumBlockID; public static int turquoiseBlockID;
	public static int uraniumBlockID;
	public static int violetBlockID;
	public static int whiteOpalBlockID;	
	// Terrain Block ID's
	//public static int soulIceID;
	public static int soulLiquidFlowID; public static int soulLiquidStillID;
	public static int lateriteGrassID; public static int lateriteDirtID;
	public static int bogGrassID; public static int bogDirtID; public static int frozenGrassID;
	public static int fyrisedSandID; public static int fyrisedSandGrassID;	
	public static int porphyryID; public static int slateID; public static int darkPorphyryID;
	public static int bauxiteID; public static int bauxiteMossyID;		
	public static int thickSnowID; public static int snowID;
	public static int baneberryVineID;	public static int blueberryVineID;	public static int blackberryVineID;	public static int cranberryVineID;	public static int raspberryVineID;	public static int razzberryVineID;	public static int strawberryVineID;
	public static int flowerCantaloupeID; public static int flowerFireblossomID; public static int bogTallGrassGreyID; public static int bogTallGrassGreenID; public static int bogTallGrassBrownID; public static int bogTallGrassPurpleID; public static int frozenTallGrassID;
	public static int vineplantID; public static int vineplantTopID;
	//Trees
	//Leaves
	public static int grapesLeavesID; public static int soulLeavesID; public static int hardwoodLeavesID; public static int soulLeavesPinkID; public static int soulLeavesOrangeID; public static int soulLeavesYellowID; public static int soulLeavesBlueID;
	//Logs
	public static int soulLogID; public static int hardwoodLogID;
	//Planks
	public static int soulPlanksID; public static int hardwoodPlanksID;
	//Sapplings
	public static int grapesSapplingID; public static int soulSapplingID; public static int hardwoodSapplingID;
	// Custom Block ID's
	public static int iceBrickID; public static int bauxiteBrickID; public static int porphyryBrickID; public static int slateBrickID; public static int titaniumBrickID;
	public static int soulHalfSlabID;
	public static int soulDoubleSlabID;
			
	public static int gemcutterIdleID; public static int gemcutterActiveID;
	public static int iceWorkbenchID;
	public static int gelExtractorID;
	public static int soulFireID; 
	public static int teleporterID;	
			
	// Torches
	public static int torchAmazoniteID;
	public static int torchAmethystID;
	public static int torchBronzeID;
	public static int torchChromiteID;
	public static int torchJetID;
	public static int torchOlivineID;
	public static int torchTopazID;
	public static int torchTurquoiseID;
	public static int torchVioletID;
	public static int torchWhiteOpalID;
			
	public static void init(File configFile)
	{
		config = new Configuration(configFile);
	
		try
		{
			config.load();	
			//Block ID's
				// Terrain Blocks				

				soulLiquidStillID = config.getTerrainBlock("Terrain Block ID's", "Liquid Still ID", 222, "The stationary liquid used in the Soul Forest Dimension").getInt();				
				soulLiquidFlowID = config.getTerrainBlock("Terrain Block ID's", "Liquid Flow ID", 223, "The flowing liquid used in the Soul Forest Dimension").getInt();
				
				//soulIceID = config.getTerrainBlock("Terrain Block ID's", "Soul Ice", 233, "The ice used in the Soul Forest Dimension").getInt();
				fyrisedSandID = config.getTerrainBlock("Terrain Block ID's", "Fyrised Sand Bottom", 234, "The sand used in the Dark Caverns biome").getInt();
				fyrisedSandGrassID = config.getTerrainBlock("Terrain Block ID's", "Fyrised Sand Top", 235, "The sand used in the Dark Caverns biome").getInt();
				bogGrassID = config.getTerrainBlock("Terrain Block ID's", "Bog Grass", 236, "The grass used in the Peat Bog biome").getInt();
				bogDirtID = config.getTerrainBlock("Terrain Block ID's", "Bog Dirt", 237, "The dirt used in the Peat Bog biome").getInt();
				lateriteGrassID = config.getTerrainBlock("Terrain Block ID's", "Laterite Grass", 238, "The grass used in the Soul Forest biome").getInt();
				lateriteDirtID = config.getTerrainBlock("Terrain Block ID's", "Laterite Dirt", 239, "The dirt used in the Soul Forest biome").getInt();
				thickSnowID = config.getTerrainBlock("Terrain Block ID's", "Thick Soul Snow", 240, "The snow used in the Frost Caves biome").getInt();
				snowID = config.getTerrainBlock("Terrain Block ID's", "Soul Snow", 241, "The snow used in the Soul Forest biome").getInt();				
				porphyryID = config.getTerrainBlock("Terrain Block ID's", "Porphyry", 242, "One of the stones used in the Soul Forest Dimension").getInt();
				slateID = config.getTerrainBlock("Terrain Block ID's", "Slate", 243, "One of the stones used in the Soul Forest Dimension").getInt();
				bauxiteID = config.getTerrainBlock("Terrain Block ID's", "Bauxite", 244, "One of the stones used in the Soul Forest Dimension").getInt();
				bauxiteMossyID = config.getTerrainBlock("Terrain Block ID's", "Mossy Bauxite", 245, "One of the stones used in the Soul Forest Dimension").getInt();				
				// Ores
				amazoniteOreID = config.getBlock("Ore ID's", "Amazonite Ore", 3400).getInt();
				amethystOreID = config.getBlock("Ore ID's", "Amethyst Ore", 3401).getInt();
				aquamarineOreID = config.getBlock("Ore ID's", "Aquamarine Ore", 3402).getInt();
				blackDiamondOreID = config.getBlock("Ore ID's", "Black Diamond Ore", 3403).getInt();
				chromiteOreID = config.getBlock("Ore ID's", "Chromite Ore", 3404).getInt();
				citrineOreID = config.getBlock("Ore ID's", "Citrine Ore", 3405).getInt();
				cobaltOreID = config.getBlock("Ore ID's", "Cobalt Ore", 3406).getInt();
				copperOreID = config.getBlock("Ore ID's", "Copper Ore", 3407).getInt();
				jadeOreID = config.getBlock("Ore ID's", "Jade Ore", 3409).getInt();
				jetOreID = config.getBlock("Ore ID's", "Jet Ore", 3410).getInt();
				lilaOreID = config.getBlock("Ore ID's", "Lila Ore", 3411).getInt();
				mithrilOreID = config.getBlock("Ore ID's", "Mithril Ore", 3412).getInt();
				olivineOreID = config.getBlock("Ore ID's", "Olivine Ore", 3413).getInt();
				onyxOreID = config.getBlock("Ore ID's", "Onyx Ore", 3414).getInt();
				opalOreID = config.getBlock("Ore ID's", "Opal Ore", 3415).getInt();
				scarletiteOreID = config.getBlock("Ore ID's", "Scarletite Ore", 3416).getInt();
				silverOreID = config.getBlock("Ore ID's", "Silver Ore", 3417).getInt();
				steelOreID = config.getBlock("Ore ID's", "Steel Ore", 3418).getInt();
				tanzaniteOreID = config.getBlock("Ore ID's", "Tanzanite Ore", 3419).getInt();
				tinOreID = config.getBlock("Ore ID's", "Tin Ore", 3420).getInt();
				topazOreID = config.getBlock("Ore ID's", "Topaz Ore", 3421).getInt();
				titaniumOreID = config.getBlock("Ore ID's", "Titanium Ore", 3422).getInt();
				turquoiseOreID = config.getBlock("Ore ID's", "Turquoise Ore", 3423).getInt();
				uraniumOreID = config.getBlock("Ore ID's", "Uruanium Ore", 3424).getInt();
				violetOreID = config.getBlock("Ore ID's", "Violet Ore", 3425).getInt();
				whiteOpalOreID = config.getBlock("Ore ID's", "White Opal Ore", 3426).getInt();			
				// Storage Blocks
				amazoniteBlockID = config.getBlock("Block ID's", "Amazonite Block", 3427).getInt();
				amethystBlockID = config.getBlock("Block ID's", "Amethyst Block", 3428).getInt();
				aquamarineBlockID = config.getBlock("Block ID's", "Aquamarine Block", 3429).getInt();
				blackDiamondBlockID = config.getBlock("Block ID's", "Black Diamond Block", 3430).getInt();
				chromiteBlockID = config.getBlock("Block ID's", "Chromite Block", 3431).getInt();
				citrineBlockID = config.getBlock("Block ID's", "Citrine Block", 3432).getInt();
				cobaltBlockID = config.getBlock("Block ID's", "Cobalt Block", 3433).getInt();
				copperBlockID = config.getBlock("Block ID's", "Copper Block", 3434).getInt();
				jadeBlockID = config.getBlock("Block ID's", "Jade Block", 3435).getInt();
				jetBlockID = config.getBlock("Block ID's", "Jet Block", 3436).getInt();
				lilaBlockID = config.getBlock("Block ID's", "Lila Block", 3437).getInt();
				mithrilBlockID = config.getBlock("Block ID's", "Mithril Block", 3438).getInt();
				olivineBlockID = config.getBlock("Block ID's", "Olivine Block", 3439).getInt();
				onyxBlockID = config.getBlock("Block ID's", "Onyx Block", 3440).getInt();
				opalBlockID = config.getBlock("Block ID's", "Opal Block", 3441).getInt();
				scarletiteBlockID = config.getBlock("Block ID's", "Scarletite Block", 3442).getInt();
				silverBlockID = config.getBlock("Block ID's", "Silver Block", 3443).getInt();
				steelBlockID = config.getBlock("Block ID's", "Steel Block", 3444).getInt();
				tanzaniteBlockID = config.getBlock("Block ID's", "Tanzanite Block", 3445).getInt();
				tinBlockID = config.getBlock("Block ID's", "Tin Block", 3446).getInt();
				topazBlockID = config.getBlock("Block ID's", "Topaz Block", 3447).getInt();
				titaniumBlockID = config.getBlock("Block ID's", "Titanium Block", 3448).getInt();
				turquoiseBlockID = config.getBlock("Block ID's", "Turquoise Block", 3449).getInt();
				uraniumBlockID = config.getBlock("Block ID's", "Uruanium Block", 3450).getInt();
				violetBlockID = config.getBlock("Block ID's", "Violet Block", 3451).getInt();
				whiteOpalBlockID = config.getBlock("Block ID's", "White Opal Block", 3452).getInt();
				bronzeBlockID = config.getBlock("Block ID's", "Bronze Block", 3453).getInt();		
				// Other Blocks
				darkPorphyryID = config.getBlock("Block ID's", "Dark Porphyry", 3454).getInt();
				soulLogID = config.getBlock("Block ID's", "Soul Log", 3455).getInt();
				hardwoodLogID = config.getBlock("Block ID's", "Hardwood Log", 3456).getInt();				
				soulPlanksID = config.getBlock("Block ID's", "Soul Planks", 3460).getInt();
				hardwoodPlanksID = config.getBlock("Block ID's", "Hardwood Planks", 3461).getInt();
				// -- Stairs and slabs go here
				
				iceBrickID = config.getBlock("Block ID's", "Ice Brick", 3470).getInt();
				bauxiteBrickID = config.getBlock("Block ID's", "Bauxite Brick", 3471).getInt();
				porphyryBrickID = config.getBlock("Block ID's", "Porphyry Brick", 3472).getInt();
				slateBrickID = config.getBlock("Block ID's", "Slate Brick", 3473).getInt();
				titaniumBrickID = config.getBlock("Block ID's", "Titanium Brick", 3474).getInt();
				soulHalfSlabID = config.getBlock("Block ID's", "Soul Half Slab", 3475).getInt();
				soulDoubleSlabID = config.getBlock("Block ID's", "Soul Double Slab", 3476).getInt();
				
				baneberryVineID = config.getBlock("Plant Block ID's", "Baneberry Vine", 3500).getInt();
				blueberryVineID = config.getBlock("Plant Block ID's", "Blueberry Vine", 3501).getInt();
				blackberryVineID = config.getBlock("Plant Block ID's", "Blackberry Vine", 3502).getInt();
				cranberryVineID = config.getBlock("Plant Block ID's", "Cranberry Vine", 3503).getInt();
				raspberryVineID = config.getBlock("Plant Block ID's", "Raspberry Vine", 3504).getInt();
				razzberryVineID = config.getBlock("Plant Block ID's", "Razzberry Vine", 3505).getInt();
				strawberryVineID = config.getBlock("Plant Block ID's", "Strawberry Vine", 3506).getInt();			
				grapesSapplingID = config.getBlock("Plant Block ID's", "Grapes Sappling", 3507).getInt();
				soulSapplingID = config.getBlock("Plant Block ID's", "Soul Sappling", 3508).getInt();
				hardwoodSapplingID = config.getBlock("Plant Block ID's", "Hardwood Sappling", 3509).getInt();
				grapesLeavesID = config.getBlock("Plant Block ID's", "Grapes Leaves", 3510).getInt();
				hardwoodLeavesID = config.getBlock("Plant Block ID's", "Hardwood Leaves", 3511).getInt();
				soulLeavesID = config.getBlock("Plant Block ID's", "Soul Leaves", 3512).getInt();
				soulLeavesPinkID = config.getBlock("Plant Block ID's", "Soul Leaves Pink", 3513).getInt();
				soulLeavesOrangeID = config.getBlock("Plant Block ID's", "Soul Leaves Orange", 3514).getInt();
				soulLeavesBlueID = config.getBlock("Plant Block ID's", "Soul Leaves Blue", 3515).getInt();
				soulLeavesYellowID = config.getBlock("Plant Block ID's", "Soul Leaves Yellow", 3516).getInt();					
				bogTallGrassGreyID = config.getBlock("Plant Block ID's", "Bog Grass Grey", 3517).getInt();
				bogTallGrassGreenID = config.getBlock("Plant Block ID's", "Bog Grass Green", 3518).getInt();
				bogTallGrassBrownID = config.getBlock("Plant Block ID's", "Bog Grass Brown", 3519).getInt();
				bogTallGrassPurpleID = config.getBlock("Plant Block ID's", "Bog Grass Purple", 3520).getInt();
				frozenTallGrassID = config.getBlock("Plant Block ID's", "Frozen Tall Grass", 3521).getInt();	
				frozenGrassID = config.getBlock("Plant Block ID's", "Frozen Grass", 3522).getInt();
				flowerFireblossomID = config.getBlock("Plant Block ID's", "Fireblossom", 3523).getInt();
				flowerCantaloupeID = config.getBlock("Plant Block ID's", "Cantaloupe Flower", 3524).getInt();
				vineplantID = config.getBlock("Plant Block ID's", "Vineplant", 3525).getInt();
				vineplantTopID = config.getBlock("Plant Block ID's", "Vineplant Top", 3526).getInt();
				
				//Custom Block ID's			
				gelExtractorID = config.getBlock("Block ID's", "Gel Extractor", 3539).getInt();
				gemcutterIdleID = config.getBlock("Block ID's", "Gemcutter Idle", 3540).getInt();
				gemcutterActiveID = config.getBlock("Block ID's", "Gemcutter Active", 3541).getInt();
				soulFireID = config.getBlock("Block ID's", "Soul Fire", 3542).getInt();
				teleporterID = config.getBlock("Block ID's", "Teleporter (filler) Block", 3543).getInt();	
				iceWorkbenchID = config.getBlock("Block ID's", "Ice Workbench", 3544).getInt();
				
				
				torchAmazoniteID = config.getBlock("Block ID's", "Torch Amazonite", 3545).getInt();;
				torchAmethystID = config.getBlock("Block ID's", "Torch Amethyst", 3546).getInt();;
				torchBronzeID = config.getBlock("Block ID's", "Torch Bronze", 3547).getInt();;
				torchChromiteID = config.getBlock("Block ID's", "Torch Chromite", 3548).getInt();;
				torchJetID = config.getBlock("Block ID's", "Torch Jet", 3549).getInt();;
				torchOlivineID = config.getBlock("Block ID's", "Torch Olivine", 3550).getInt();;
				torchTopazID = config.getBlock("Block ID's", "Torch Topaz", 3551).getInt();;
				torchTurquoiseID = config.getBlock("Block ID's", "Torch Turquoise", 3552).getInt();;
				torchVioletID = config.getBlock("Block ID's", "Torch Violet", 3553).getInt();;
				torchWhiteOpalID = config.getBlock("Block ID's", "Torch White Opal", 3554).getInt();;	
			
			FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[Soul Forest] [ConfigBlocks] Generated Config!");
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Soul Forest has had a problem loading its configuration : [ConfigBlocks]");
		}
		finally
		{
			if (config.hasChanged()) 
			{
				config.save();
			}
		}
	}
}
*/