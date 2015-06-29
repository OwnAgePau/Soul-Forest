package com.Mod_Ores.Init;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Blocks.*;
import com.Mod_Ores.Blocks.Special.*;
import com.Mod_Ores.Blocks.TileEntities.*;
import com.Mod_Ores.Dimension.FrozenHearth.TeleportBlockFrozenHearth;
import com.Mod_Ores.Dimension.SoulForest.TeleportBlockSoulForest;
import com.google.common.base.Optional;

import cpw.mods.fml.common.registry.GameRegistry;

public class InitBlocks {
    private static Random rand;

    public static void init(){
	initializeBlocks();
	registerTileEntities();
	//registerBlocks();
    }

    public static void initializeBlocks(){
	// Ores
	SoulBlocks.Amazoniteore = 			Optional.of((new SoulOre(SoulItems.AmazoniteUncut.get(), 1, "Amazoniteore", 3.0F, 2F, true)).setBlockTextureName(soul_forest.MODID + ":Amazoniteore")); 			
	SoulBlocks.Amethystore =  			Optional.of((new SoulOre(SoulItems.AmethystUncut.get(), 1, "Amethystore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Amethystore"));
	SoulBlocks.Aquamarineore =  			Optional.of((new SoulOre(SoulItems.AquamarineUncut.get(), 1, "Aquamarineore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Aquamarineore"));
	SoulBlocks.Blackdiamondore = 			Optional.of((new SoulOre(SoulItems.BlackdiamondUncut.get(), 1, "Blackdiamondore", 4.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Blackdiamondore"));
	SoulBlocks.Citrineore =  			Optional.of((new SoulOre(SoulItems.CitrineUncut.get(), 1, "Citrineore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Citrineore"));		
	SoulBlocks.Jadeore = 				Optional.of((new SoulOre(SoulItems.JadeUncut.get(), 1, "Jadeore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Jadeore"));
	SoulBlocks.Jetore =  				Optional.of((new SoulOre(SoulItems.JetUncut.get(), 1, "Jetore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Jetore"));
	SoulBlocks.Lilaore =  				Optional.of((new SoulOre(SoulItems.LilaUncut.get(), 1, "Lilaore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Lilaore"));
	SoulBlocks.Olivineore =  			Optional.of((new SoulOre(SoulItems.OlivineUncut.get(), 1, "Olivineore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Olivineore"));
	SoulBlocks.Onyxore =  				Optional.of((new SoulOre(SoulItems.OnyxUncut.get(), 1, "Onyxore", 5.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Onyxore"));
	SoulBlocks.Opalore =  				Optional.of((new SoulOre(SoulItems.OpalUncut.get(), 1, "Opalore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Opalore"));
	SoulBlocks.Scarletiteore =  			Optional.of((new SoulOre(SoulItems.ScarletiteUncut.get(), 1, "Scarletiteore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Scarletiteore"));
	SoulBlocks.Titaniumore = 			Optional.of((new SoulOre(SoulItems.TitaniumUncut.get(), 1, "Titaniumore", 5.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Titaniumore"));
	SoulBlocks.Topazore =  				Optional.of((new SoulOre(SoulItems.TopazUncut.get(), 1, "Topazore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Topazore"));		
	SoulBlocks.Turquoiseore =  			Optional.of((new SoulOre(SoulItems.TurquoiseUncut.get(), 1, "Turquoiseore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Turquoiseore"));
	SoulBlocks.Uraniumore =  			Optional.of((new SoulOre(SoulItems.UraniumGem.get(), 1, "Uraniumore", 5.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Uraniumore"));
	SoulBlocks.Violetore =  			Optional.of((new SoulOre(SoulItems.VioletUncut.get(), 1, "Violetore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Violetore"));
	SoulBlocks.Whiteopalore =  			Optional.of((new SoulOre(SoulItems.WhiteopalUncut.get(), 1, "Whiteopalore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID+":Whiteopalore"));

	// Decoration Blocks
	SoulBlocks.AmazoniteBlock =  			Optional.of((new SoulBlock("Amazoniteblock", 4.0F, 2F, true, Material.iron)).setBlockTextureName(soul_forest.MODID+":Amazonite_block"));  				
	SoulBlocks.AmethystBlock =  			Optional.of((new SoulBlock("Amethystblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Amethyst_block"));			
	SoulBlocks.AquamarineBlock = 			Optional.of((new SoulBlock("Aquamarineblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Aquamarine_block"));
	SoulBlocks.BlackdiamondBlock =			Optional.of((new SoulBlock("Blackdiamondblock", 6.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Blackdiamond_block"));			
	SoulBlocks.BronzeBlock = 			Optional.of((new SoulBlock("Bronzeblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Bronze_block"));
	SoulBlocks.CitrineBlock =  			Optional.of((new SoulBlock("Citrineblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Citrine_block"));
	SoulBlocks.ChromiteBlock =  			Optional.of((new SoulBlock("Chromiteblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Chromite_block"));
	SoulBlocks.CobaltBlock =  			Optional.of((new SoulBlock("Cobaltblock", 4.0F, 2F, true, Material.iron)).setBlockTextureName(soul_forest.MODID+":Cobalt_block")); 	
	SoulBlocks.CopperBlock = 			Optional.of((new SoulBlock("Copperblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Copper_block"));
	SoulBlocks.JadeBlock = 				Optional.of((new SoulBlock("Jadeblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Jade_block"));
	SoulBlocks.JetBlock =  				Optional.of((new SoulBlock("Jetblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Jet_block"));
	SoulBlocks.LilaBlock =  			Optional.of((new SoulBlock("Lilablock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Lila_block"));
	SoulBlocks.OlivineBlock =  			Optional.of((new SoulBlock("Olivineblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Olivine_block")); 
	SoulBlocks.OnyxBlock =  			Optional.of((new SoulBlock("Onyxblock", 5.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Onyx_block"));
	SoulBlocks.OpalBlock =  			Optional.of((new SoulBlock("Opalblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Opal_block"));
	SoulBlocks.ScarletiteBlock = 			Optional.of((new SoulBlock("Scarletiteblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Scarletite_block"));
	SoulBlocks.SilverBlock =  			Optional.of((new SoulBlock("Silverblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Silver_block"));
	SoulBlocks.SteelBlock = 			Optional.of((new SoulBlock("Steelblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Steel_block"));
	SoulBlocks.TanzaniteBlock = 			Optional.of((new SoulBlock("Tanzaniteblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Tanzanite_block"));
	SoulBlocks.TinBlock =  				Optional.of((new SoulBlock("Tinblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Tin_block"));
	SoulBlocks.TitaniumBlock = 			Optional.of((new SoulBlock("Titaniumblock", 5.5F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Titanium_block"));
	SoulBlocks.TopazBlock =  			Optional.of((new SoulBlock("Topazblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Topaz_block"));
	SoulBlocks.TurquoiseBlock = 			Optional.of((new SoulBlock("Turquoiseblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Turquoise_block"));
	SoulBlocks.UraniumBlock =  			Optional.of((new SoulBlock("Uraniumblock", 4.5F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Uranium_block"));
	SoulBlocks.VioletBlock =  			Optional.of((new SoulBlock("Violetblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Violet_block"));				
	SoulBlocks.WhiteopalBlock =  			Optional.of((new SoulBlock("Whiteopalblock", 4.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID+":Whiteopal_block"));		

	//Bricks		
	SoulBlocks.IceBrick =  				Optional.of((new SoulBlock("Icebrick", 3.0F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":icebrick"));  			
	SoulBlocks.BauxiteBrick =  			Optional.of((new SoulBlock("Bauxitebrick", 5.0F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":bauxitebrick"));  	
	SoulBlocks.PorphyryBrick =  			Optional.of((new SoulBlock("Porphyrybrick", 5.0F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":porphyry_brick"));  	
	SoulBlocks.SlateBrick =  			Optional.of((new SoulBlock("Slatebrick", 5.0F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":slate_brick"));  	
	SoulBlocks.TitaniumBrick =  			Optional.of((new SoulBlock("Titaniumbrick", 7.0F, 2F, false, Material.iron)).setBlockTextureName(soul_forest.MODID + ":titanium_brick"));  	

	//Slabs
	SoulBlocks.SoulHalfSlab =  			Optional.of(((SoulHalfslab)new SoulStep("Soul_half_slab", 4.0F, 2F, false, false)).setBlockTextureName(soul_forest.MODID + ":soulhalfslab"));
	SoulBlocks.SoulDoubleSlab =  			Optional.of(((SoulHalfslab)new SoulStep("Soul_double_slab", 4.0F, 2F, false, true)).setBlockTextureName(soul_forest.MODID + ":soulhalfslab"));

	//Complex Blocks
	SoulBlocks.IceWorkbench =  			Optional.of((new BlockIceWorkbench("Ice_workbench_side").setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName(soul_forest.MODID + ":Ice_workbench_side")));		
	SoulBlocks.GemcutterIdle =  			Optional.of((new BlockGemcutterBench("Gemcutter", false)).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks).setBlockTextureName(soul_forest.MODID + ":Gemcutter"));	
	SoulBlocks.GemcutterActive = 			Optional.of((new BlockGemcutterBench("Gemcutter_active", true)).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName(soul_forest.MODID + ":Gemcutter"));	
	SoulBlocks.SoulFire = 				Optional.of((new SoulFire("Soul_fire")).setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName(soul_forest.MODID + ":Soul_Fire"));  	//Teleporter
	SoulBlocks.Teleporter =   			Optional.of((new TeleportBlockSoulForest("Blueish_dizzling_portal_passage").setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName(soul_forest.MODID + ":Soulportal_inside")));  
	SoulBlocks.TeleporterFrozenHearth =   		Optional.of((new TeleportBlockFrozenHearth("Blueish_dizzling_portal_passage_2").setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName(soul_forest.MODID + ":Soulportal_inside")));  
	SoulBlocks.GelExtractor =			Optional.of((new BlockGelExtractor("Gelextractor")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks).setBlockTextureName("Gel_extractor_front"));
	SoulBlocks.GemmerationTable =			Optional.of((new BlockGemmerationTable("Gemmeration_table")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks).setBlockTextureName("Gemmeration_side"));
	SoulBlocks.GemmingTable =			Optional.of((new BlockGemmingTable("Gemming_table")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks).setBlockTextureName("Gemming_side"));
	SoulBlocks.GembleTable =			Optional.of((new BlockGembleTable("Gemble_table")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks).setBlockTextureName("Gemmeble_table_front"));

	//Water
	SoulBlocks.SoulWaterMovingFluid = 		Optional.of((new Fluid("Soul_water_flow")));
	FluidRegistry.registerFluid(SoulBlocks.SoulWaterMovingFluid.get());
	SoulBlocks.SoulWaterMoving = 			Optional.of((new SoulWaterFlowing(SoulBlocks.SoulWaterMovingFluid.get(), "Soul_water_flow")).setBlockTextureName(soul_forest.MODID + ":Soul_Water_Flow"));	
	//SoulBlocks.SoulWater =				Optional.of((new SoulWaterStationary("Soul Water Still")).setBlockTextureName(soul_forest.MODID + ":Soul_Water"));

	//Ice
	//SoulBlocks.SoulIce = 				Optional.of((new BlockSoulIce(SoulConfigBlocks.soulIceID)).func_111022_d(soul_forest.MODID + ":soul_ice"));

	//Stones
	SoulBlocks.DarkPorphyry =  			Optional.of((new SoulBlock("Porphyrydark", 5.0F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":Porphyry_dark"));  	
	SoulBlocks.Porphyry =  				Optional.of((new SoulBlock("Porphyry", 4.0F, 5.0F, false, Material.rock)).setStepSound(Block.soundTypeStone).setBlockTextureName(soul_forest.MODID + ":Porphyry"));  				
	SoulBlocks.Slate =  				Optional.of((new SoulBlock("Slate", 4.5F, 5.0F, false, Material.rock)).setStepSound(Block.soundTypeStone).setBlockTextureName(soul_forest.MODID + ":Slate"));  	
	SoulBlocks.Bauxite =  				Optional.of((new SoulBlock("Bauxite", 3.0F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":Bauxite"));   
	SoulBlocks.BauxiteMossy =  			Optional.of((new SoulBlock("Mossybauxite", 3.5F, 2F, false, Material.rock)).setBlockTextureName(soul_forest.MODID + ":Mossy_Bauxite"));   

	//Grass & Dirt - used in Soul Forest & Marona Woods biome
	SoulBlocks.LateriteGrass =  			Optional.of((new BlockLateriteGrass("Laterite_grass_side")).setHardness(0.6F).setStepSound(Block.soundTypeGrass).setBlockTextureName(soul_forest.MODID + ":Laterite_grass_side"));  	
	SoulBlocks.LateriteDirt =  			Optional.of((new BlockSoulDirt("Laterite")).setHardness(0.6F).setStepSound(Block.soundTypeGrass).setBlockTextureName(soul_forest.MODID + ":Laterite"));  

	//Grass & Dirt - used in Soul Forest & Marona Woods biome
	SoulBlocks.FyrisedSandGrass =  			Optional.of((new BlockFyrisedSand("Fyrised_sand_side")).setHardness(0.5F).setStepSound(Block.soundTypeSand).setBlockTextureName(soul_forest.MODID + ":Fyrised_sand_side"));  	
	SoulBlocks.FyrisedSand =  			Optional.of((new BlockSoulDirt("Fyrised_sand")).setHardness(0.5F).setStepSound(Block.soundTypeGrass).setBlockTextureName(soul_forest.MODID + ":Fyrised_sand"));  

	//Snow	- used in Frost Caves & Frozen Plains biome
	SoulBlocks.SoulSnowTop =  			Optional.of((new BlockSnowTopLayer("SnowTopLayer")).setHardness(0.1F).setStepSound(Block.soundTypeSnow).setCreativeTab(soul_forest.tabSoulBlocks).setBlockTextureName(soul_forest.MODID + ":SnowTopLayer"));	
	SoulBlocks.SoulSnowBottom =  			Optional.of((new SoulBlock("SnowBottomLayer", 0.2F, 0.2F, false, Material.sand)).setStepSound(Block.soundTypeSnow).setBlockTextureName(soul_forest.MODID + ":SnowBottomLayer"));

	//Grass & Dirt - used in Peat Bog biome
	SoulBlocks.BogGrass =  				Optional.of((new BlockBogGrass("Bog_grass")).setBlockTextureName(soul_forest.MODID + ":Bog_grass"));  	
	SoulBlocks.BogDirt =  				Optional.of((new BlockSoulDirt("Bog_dirt")).setHardness(0.2F).setStepSound(Block.soundTypeGrass).setBlockTextureName(soul_forest.MODID + ":Bog_dirt"));  	

	//Grass - used in Frozen Plains biome
	SoulBlocks.FrozenGrass =  			Optional.of((new BlockFrozenGrass("Frozen_grass")).setHardness(0.3F).setStepSound(Block.soundTypeGrass).setBlockTextureName(soul_forest.MODID + ":Frozen_grass"));  	

	SoulBlocks.BogTallGrassGrey =  			Optional.of((new BlockBogTallGrassGrey("Bog_grass_tall_grey")).setHardness(0.0F).setBlockTextureName(soul_forest.MODID + ":Bog_grass_tall_grey"));  	
	SoulBlocks.BogTallGrassGreen =  		Optional.of((new BlockBogTallGrassGreen("Bog_grass_tall_green")).setHardness(0.0F).setBlockTextureName(soul_forest.MODID + ":Bog_grass_tall_green"));  	
	SoulBlocks.BogTallGrassBrown =  		Optional.of((new BlockBogTallGrassBrown("Bog_grass_tall_dark")).setHardness(0.0F).setBlockTextureName(soul_forest.MODID + ":Bog_grass_tall_dark"));  
	SoulBlocks.BogTallGrassPurple =  		Optional.of((new BlockBogTallGrassPurple("Bog_grass_tall_purple")).setHardness(0.0F).setBlockTextureName(soul_forest.MODID + ":Bog_grass_tall_purple"));  
	SoulBlocks.FrozenTallGrass =  			Optional.of((new BlockFrozenTallGrass("Frozen_tallgrass")).setHardness(0.0F).setBlockTextureName(soul_forest.MODID + ":Frozen_tallgrass"));  
	SoulBlocks.SoulBush =				Optional.of((new BlockSoulBush("Bush").setHardness(0.0F)).setBlockTextureName(soul_forest.MODID + ":Bush"));

	// Wooden Planks
	SoulBlocks.HardwoodPlanks =  			Optional.of((new SoulWood("Hardwood_wood", 2F, 4F)).setBlockTextureName(soul_forest.MODID + ":Hardwood_planks"));  
	SoulBlocks.SoulPlanks =  			Optional.of((new SoulWood("Soul_wood", 2F, 4F)).setBlockTextureName(soul_forest.MODID + ":Soulwood_planks"));  
	SoulBlocks.IcePlanks = 				Optional.of((new SoulWood("Frozen_wood", 2F, 4F)).setBlockTextureName(soul_forest.MODID + ":Frozenwood_planks"));

	// Plants	
	//Logs			
	SoulBlocks.HardwoodLog = 			Optional.of((new BlockSoulLog("Hardwood_log", 4.0F)).setBlockTextureName(soul_forest.MODID + ":Hardwood_log"));
	SoulBlocks.SoulLog = 				Optional.of((new BlockSoulLog("Soul_log", 4.0F)).setBlockTextureName(soul_forest.MODID + ":Sou_log"));
	SoulBlocks.IceLog = 				Optional.of((new BlockSoulLog("Frozen_log", 4.0F)).setBlockTextureName(soul_forest.MODID + ":Frozen_log"));

	//Leaves
	SoulBlocks.GrapesLeaves = 			Optional.of((new BlockSoulLeaves("Grapes", 2.0F, 10F)).setBlockTextureName(soul_forest.MODID + ":Grapes"));
	SoulBlocks.HardwoodLeaves = 			Optional.of((new BlockSoulLeaves("Hardwood_leaves", 2.0F, 2.0F)).setBlockTextureName(soul_forest.MODID + ":Hardwood_leaves"));
	SoulBlocks.SoulLeaves = 			Optional.of((new BlockSoulLeaves("Soul_leaves", 2.0F, 1.0F)).setBlockTextureName(soul_forest.MODID + ":Soul_leaves"));
	SoulBlocks.SoulLeavesOrange = 			Optional.of((new BlockSoulLeaves("Soul_leaves_orange", 2.0F, 1.0F)).setBlockTextureName(soul_forest.MODID + ":Soul_leaves_orange"));
	SoulBlocks.SoulLeavesPink = 			Optional.of((new BlockSoulLeaves("Soul_leaves_pink", 2.0F, 1.0F)).setBlockTextureName(soul_forest.MODID + ":Soul_leaves_pink"));
	SoulBlocks.SoulLeavesYellow = 			Optional.of((new BlockSoulLeaves("Soul_leaves_yellow", 2.0F, 1.0F)).setBlockTextureName(soul_forest.MODID + ":Soul_leaves_yellow"));
	SoulBlocks.SoulLeavesBlue = 			Optional.of((new BlockSoulLeaves("Soul_leaves_blue", 2.0F, 1.0F)).setBlockTextureName(soul_forest.MODID + ":Soul_leaves_blue"));
	SoulBlocks.IceLeaves = 				Optional.of((new BlockSoulLeaves("Frozen_leaves", 2.0F, 1.0F)).setBlockTextureName(soul_forest.MODID + ":Frozen_leaves"));

	//Sapplings
	SoulBlocks.SapplingGrape = 			Optional.of((new BlockSoulSappling("Sappling_soul").setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries).setBlockTextureName(soul_forest.MODID + ":Sappling_soul")));

	//Flowers
	SoulBlocks.PlantCantaloupe = 			Optional.of((BlockCantaloupe)(new BlockCantaloupe("Cantaloupe_flower")).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries).setBlockTextureName(soul_forest.MODID + ":Cantaloupe_Flower"));
	SoulBlocks.Fireblossom = 			Optional.of((BlockFireblossom)(new BlockFireblossom("Fireblossom")).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries).setBlockTextureName(soul_forest.MODID + ":Fireblossom"));
	SoulBlocks.FrozenSinai = 			Optional.of((BlockFireblossom)(new BlockFireblossom("Frozen_shinai")).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries).setBlockTextureName(soul_forest.MODID + ":Frozen_shinai"));
	SoulBlocks.Vineplant	=			Optional.of(new BlockVineplant("Vineplant").setCreativeTab(soul_forest.tabSoulBerries).setBlockTextureName(soul_forest.MODID + ":Vineplant"));
	SoulBlocks.VineplantTop	=			Optional.of(new BlockVineplant("Vineplant_top").setCreativeTab(soul_forest.tabSoulBerries).setBlockTextureName(soul_forest.MODID + ":Vineplant_top"));

	//Vines
	SoulBlocks.Baneberry = 				Optional.of((new SoulVine(1, "Baneberry")).setBlockTextureName(soul_forest.MODID + ":Baneberry"));
	SoulBlocks.Blackberry = 			Optional.of((new SoulVine(1, "Blackberry")).setBlockTextureName(soul_forest.MODID + ":Blackberry"));				
	SoulBlocks.Blueberry = 				Optional.of((new SoulVine(1, "Blueberry")).setBlockTextureName(soul_forest.MODID + ":Blueberry"));
	SoulBlocks.Cranberry = 				Optional.of((new SoulVine(1, "Cranberry")).setBlockTextureName(soul_forest.MODID + ":Cranberry"));
	SoulBlocks.Raspberry = 				Optional.of((new SoulVine(1, "Raspberry")).setBlockTextureName(soul_forest.MODID + ":Raspberry"));
	SoulBlocks.Razzberry= 				Optional.of((new SoulVine(1, "Razzberry")).setBlockTextureName(soul_forest.MODID + ":Razzberry"));
	SoulBlocks.Strawberry = 			Optional.of((new SoulVine(2, "Strawberry")).setBlockTextureName(soul_forest.MODID + ":Strawberry"));

	//Torches
	SoulBlocks.AmazoniteTorch = 			Optional.of((new SoulTorch("Torch_amazonite")).setBlockTextureName(soul_forest.MODID + ":torchAmazonite"));
	SoulBlocks.AmethystTorch = 			Optional.of((new SoulTorch("Torch_amethyst")).setBlockTextureName(soul_forest.MODID + ":torchAmethyst"));
	SoulBlocks.BronzeTorch = 			Optional.of((new SoulTorch("Torch_bronze")).setBlockTextureName(soul_forest.MODID + ":torchBronze"));
	SoulBlocks.ChromiteTorch = 			Optional.of((new SoulTorch("Torch_chromite")).setBlockTextureName(soul_forest.MODID + ":torchChromite"));
	SoulBlocks.JetTorch = 				Optional.of((new SoulTorch("Torch_jet")).setBlockTextureName(soul_forest.MODID + ":torchJet"));
	SoulBlocks.OlivineTorch = 			Optional.of((new SoulTorch("Torch_olivine")).setBlockTextureName(soul_forest.MODID + ":torchOlivine"));
	SoulBlocks.TopazTorch = 			Optional.of((new SoulTorch("Torch_topaz")).setBlockTextureName(soul_forest.MODID + ":torchTopaz"));
	SoulBlocks.TurquoiseTorch = 			Optional.of((new SoulTorch("Torch_turquoise")).setBlockTextureName(soul_forest.MODID + ":torchTurquoise"));
	SoulBlocks.VioletTorch = 			Optional.of((new SoulTorch("Torch_violet")).setBlockTextureName(soul_forest.MODID + ":torchViolet"));
	SoulBlocks.WhiteOpalTorch = 			Optional.of((new SoulTorch("Torch_whiteOpal")).setBlockTextureName(soul_forest.MODID + ":torchWhiteOpal"));
	System.out.println("[Soul Forest] Blocks initialised");
    }

    public static void registerTileEntities(){
	GameRegistry.registerTileEntity(TileEntityGemcutter.class, "Gemcutter");
	GameRegistry.registerTileEntity(TileEntityGelExtractor.class, "Gel Extractor");
	GameRegistry.registerTileEntity(TileEntityGembleTable.class, "Gemble Table");
	GameRegistry.registerTileEntity(TileEntityGemmingTable.class, "Gemming Table");
	GameRegistry.registerTileEntity(TileEntityGemmerationTable.class, "Gemmeration Table");
    }

    public static void initItemBlockDependantBlocks(){
	// Stairs (brick)
	SoulBlocks.IceBrickStairs = 			Optional.of(new BlockSoulStairs(SoulBlocks.IceBrick.get(), 0, "Ice_brick_stairs", soul_forest.tabSoulBlocks));  	
	SoulBlocks.BauxiteBrickStairs = 		Optional.of(new BlockSoulStairs(SoulBlocks.BauxiteBrick.get(), 0, "Bauxite_brick_stairs", soul_forest.tabSoulBlocks));  	
	SoulBlocks.PorphyryBrickStairs = 		Optional.of(new BlockSoulStairs(SoulBlocks.PorphyryBrick.get(), 0, "Porphyry_brick_stairs", soul_forest.tabSoulBlocks));  	
	SoulBlocks.SlateBrickStairs = 			Optional.of(new BlockSoulStairs(SoulBlocks.SlateBrick.get(), 0, "Slate_brick_stairs", soul_forest.tabSoulBlocks));  	
	SoulBlocks.TitaniumBrickStairs = 		Optional.of(new BlockSoulStairs(SoulBlocks.TitaniumBrick.get(), 0, "Titanium_brick_stairs", soul_forest.tabSoulBlocks));  	
	// Staris (wood)
	SoulBlocks.HardwoodStairs = 			Optional.of(new BlockSoulStairs(SoulBlocks.HardwoodPlanks.get(), 0, "Hardwood_stairs", soul_forest.tabSoulBlocks));  	
	SoulBlocks.SoulStairs = 			Optional.of(new BlockSoulStairs(SoulBlocks.SoulPlanks.get(), 0, "Soul_stairs", soul_forest.tabSoulBlocks));  	
	SoulBlocks.IceStairs = 				Optional.of(new BlockSoulStairs(SoulBlocks.IcePlanks.get(), 0, "Frozen_stairs", soul_forest.tabSoulBlocks));  	


	SoulBlocks.Chromiteore =  			Optional.of((new SoulOre(1, "Chromiteore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Chromiteore"));
	SoulBlocks.Cobaltore =  			Optional.of((new SoulOre(1, "Cobaltore", 4.0F, 2F, true)).setBlockTextureName(soul_forest.MODID + ":Cobaltore"));
	SoulBlocks.Copperore = 				Optional.of((new SoulOre(1, "Copperore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Copperore"));
	SoulBlocks.Silverore =  			Optional.of((new SoulOre(1, "Silverore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Silverore"));
	SoulBlocks.Steelore = 				Optional.of((new SoulOre(1, "Steelore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Steelore"));
	SoulBlocks.Tanzaniteore =  			Optional.of((new SoulOre(1, "Tanzaniteore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Tanzaniteore"));
	SoulBlocks.Tinore =  				Optional.of((new SoulOre(1, "Tinore", 3.0F, 2F, false)).setBlockTextureName(soul_forest.MODID + ":Tinore"));
	initToolClasses();
    }

    public static void initToolClasses(){
	// SetBlockHarvestLevel
	SoulBlocks.Amazoniteore.get().setHarvestLevel("pickaxe", 3); //Soul Forest
	SoulBlocks.Amethystore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Aquamarineore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Blackdiamondore.get().setHarvestLevel("pickaxe", 5); //Soul Forest
	SoulBlocks.Chromiteore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Citrineore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Cobaltore.get().setHarvestLevel("pickaxe", 3);
	SoulBlocks.Copperore.get().setHarvestLevel("pickaxe", 0);
	SoulBlocks.Jadeore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Jetore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Lilaore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Olivineore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Onyxore.get().setHarvestLevel("pickaxe", 5); //Soul Forest
	SoulBlocks.Opalore.get().setHarvestLevel("pickaxe", 1); //Soul Forest
	SoulBlocks.Scarletiteore.get().setHarvestLevel("pickaxe", 3); //Soul Forest
	SoulBlocks.Silverore.get().setHarvestLevel("pickaxe", 2);
	SoulBlocks.Steelore.get().setHarvestLevel("pickaxe", 3);
	SoulBlocks.Tanzaniteore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Tinore.get().setHarvestLevel("pickaxe", 0);
	SoulBlocks.Titaniumore.get().setHarvestLevel("pickaxe", 5); //Soul Forest
	SoulBlocks.Topazore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Turquoiseore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Uraniumore.get().setHarvestLevel("pickaxe", 5);
	SoulBlocks.Violetore.get().setHarvestLevel("pickaxe", 2); //Soul Forest
	SoulBlocks.Whiteopalore.get().setHarvestLevel("pickaxe", 2); //Soul Forest	
    }
}