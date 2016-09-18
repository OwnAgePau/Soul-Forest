package com.Mod_Ores.Init;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.BiomeGen.WorldGenGrapeTree;
import com.Mod_Ores.BiomeGen.WorldGenTallTrees;
import com.Mod_Ores.Blocks.*;
import com.Mod_Ores.Blocks.Special.*;
import com.Mod_Ores.Blocks.Special.Fluid.SoulWaterFlowing;
import com.Mod_Ores.Blocks.Special.Slab.ItemSoulSlab;
import com.Mod_Ores.Blocks.Special.Slab.SoulDoubleSlab;
import com.Mod_Ores.Blocks.Special.Slab.SoulHalfSlab;
import com.Mod_Ores.Blocks.Special.Slab.SoulSlab;
import com.Mod_Ores.Blocks.TileEntities.*;
import com.Mod_Ores.Dimension.FrozenHearth.TeleportBlockFrozenHearth;
import com.Mod_Ores.Dimension.SoulForest.TeleportBlockSoulForest;
import com.google.common.base.Optional;

public class InitBlocks {
    private static Random rand;
    
	public static String[] slabNames = new String[]{
		"Bauxitebrick", "Icebrick", "Porphyrybrick", "Slatebrick", "Titaniumbrick", "Soulwood", "Frozenwood", "Hardwood"
	};

    public static void init(){
		initializeBlocks();
		registerTileEntities();
		//registerBlocks();
    }

    public static void initializeBlocks(){
		// Ores
		SoulBlocks.Amazoniteore = 			Optional.of(new SoulOre(SoulItems.AmazoniteUncut.get(), 1, 3, "Amazoniteore", 3.0F, 2F, true)); 			
		SoulBlocks.Amethystore =  			Optional.of(new SoulOre(SoulItems.AmethystUncut.get(), 1, 2, "Amethystore", 3.0F, 2F, false));
		SoulBlocks.Aquamarineore =  		Optional.of(new SoulOre(SoulItems.AquamarineUncut.get(), 1, 2, "Aquamarineore", 3.0F, 2F, false));
		SoulBlocks.Blackdiamondore = 		Optional.of(new SoulOre(SoulItems.BlackdiamondUncut.get(), 1, 5, "Blackdiamondore", 4.0F, 2F, false));
		SoulBlocks.Citrineore =  			Optional.of(new SoulOre(SoulItems.CitrineUncut.get(), 1, 2, "Citrineore", 3.0F, 2F, false));		
		SoulBlocks.Jadeore = 				Optional.of(new SoulOre(SoulItems.JadeUncut.get(), 1, 2, "Jadeore", 3.0F, 2F, false));
		SoulBlocks.Jetore =  				Optional.of(new SoulOre(SoulItems.JetUncut.get(), 1, 2, "Jetore", 3.0F, 2F, false));
		SoulBlocks.Lilaore =  				Optional.of(new SoulOre(SoulItems.LilaUncut.get(), 1, 2, "Lilaore", 3.0F, 2F, false));
		SoulBlocks.Olivineore =  			Optional.of(new SoulOre(SoulItems.OlivineUncut.get(), 1, 2, "Olivineore", 3.0F, 2F, false));
		SoulBlocks.Onyxore =  				Optional.of(new SoulOre(SoulItems.OnyxUncut.get(), 1, 4, "Onyxore", 5.0F, 2F, false));
		SoulBlocks.Opalore =  				Optional.of(new SoulOre(SoulItems.OpalUncut.get(), 1, 1, "Opalore", 3.0F, 2F, false));
		SoulBlocks.Scarletiteore =  		Optional.of(new SoulOre(SoulItems.ScarletiteUncut.get(), 1, 3, "Scarletiteore", 3.0F, 2F, false));
		SoulBlocks.Titaniumore = 			Optional.of(new SoulOre(SoulItems.TitaniumUncut.get(), 1, 4, "Titaniumore", 5.0F, 2F, false));
		SoulBlocks.Topazore =  				Optional.of(new SoulOre(SoulItems.TopazUncut.get(), 1, 2, "Topazore", 3.0F, 2F, false));		
		SoulBlocks.Turquoiseore =  			Optional.of(new SoulOre(SoulItems.TurquoiseUncut.get(), 1, 2, "Turquoiseore", 3.0F, 2F, false));
		SoulBlocks.Uraniumore =  			Optional.of(new SoulOre(SoulItems.UraniumGem.get(), 1, 4, "Uraniumore", 5.0F, 2F, false));
		SoulBlocks.Violetore =  			Optional.of(new SoulOre(SoulItems.VioletUncut.get(), 1, 2, "Violetore", 3.0F, 2F, false));
		SoulBlocks.Whiteopalore =  			Optional.of(new SoulOre(SoulItems.WhiteopalUncut.get(), 1, 2, "Whiteopalore", 3.0F, 2F, false));
	
		// Decoration Blocks
		SoulBlocks.AmazoniteBlock =  		Optional.of(new SoulBlock("Amazonite_block", 4.0F, 2F, true, Material.iron));  				
		SoulBlocks.AmethystBlock =  		Optional.of(new SoulBlock("Amethyst_block", 4.0F, 2F, false, Material.iron));			
		SoulBlocks.AquamarineBlock = 		Optional.of(new SoulBlock("Aquamarine_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.BlackdiamondBlock =		Optional.of(new SoulBlock("Blackdiamond_block", 6.0F, 2F, false, Material.iron));			
		SoulBlocks.BronzeBlock = 			Optional.of(new SoulBlock("Bronze_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.CitrineBlock =  			Optional.of(new SoulBlock("Citrine_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.ChromiteBlock =  		Optional.of(new SoulBlock("Chromite_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.CobaltBlock =  			Optional.of(new SoulBlock("Cobalt_block", 4.0F, 2F, true, Material.iron)); 	
		SoulBlocks.CopperBlock = 			Optional.of(new SoulBlock("Copper_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.JadeBlock = 				Optional.of(new SoulBlock("Jade_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.JetBlock =  				Optional.of(new SoulBlock("Jet_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.LilaBlock =  			Optional.of(new SoulBlock("Lila_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.OlivineBlock =  			Optional.of(new SoulBlock("Olivine_block", 4.0F, 2F, false, Material.iron)); 
		SoulBlocks.OnyxBlock =  			Optional.of(new SoulBlock("Onyx_block", 5.0F, 2F, false, Material.iron));
		SoulBlocks.OpalBlock =  			Optional.of(new SoulBlock("Opal_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.ScarletiteBlock = 		Optional.of(new SoulBlock("Scarletite_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.SilverBlock =  			Optional.of(new SoulBlock("Silver_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.SteelBlock = 			Optional.of(new SoulBlock("Steel_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.TanzaniteBlock = 		Optional.of(new SoulBlock("Tanzanite_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.TinBlock =  				Optional.of(new SoulBlock("Tin_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.TitaniumBlock = 			Optional.of(new SoulBlock("Titanium_block", 5.5F, 2F, false, Material.iron));
		SoulBlocks.TopazBlock =  			Optional.of(new SoulBlock("Topaz_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.TurquoiseBlock = 		Optional.of(new SoulBlock("Turquoise_block", 4.0F, 2F, false, Material.iron));
		SoulBlocks.UraniumBlock =  			Optional.of(new SoulBlock("Uranium_block", 4.5F, 2F, false, Material.iron));
		SoulBlocks.VioletBlock =  			Optional.of(new SoulBlock("Violet_block", 4.0F, 2F, false, Material.iron));				
		SoulBlocks.WhiteopalBlock =  		Optional.of(new SoulBlock("Whiteopal_block", 4.0F, 2F, false, Material.iron));		
	
		//Bricks		
		SoulBlocks.IceBrick =  				Optional.of(new SoulBlock("Icebrick", 3.0F, 2F, false, Material.rock));  			
		SoulBlocks.BauxiteBrick =  			Optional.of(new SoulBlock("Bauxitebrick", 5.0F, 2F, false, Material.rock));  	
		SoulBlocks.PorphyryBrick =  		Optional.of(new SoulBlock("Porphyrybrick", 5.0F, 2F, false, Material.rock));  	
		SoulBlocks.SlateBrick =  			Optional.of(new SoulBlock("Slatebrick", 5.0F, 2F, false, Material.rock));  	
		SoulBlocks.TitaniumBrick =  		Optional.of(new SoulBlock("Titaniumbrick", 7.0F, 2F, false, Material.iron));  	
	
		// Slabs & Double Slabs
		for (int i = 0; i < slabNames.length; i++) {
            SoulSlab slab = new SoulHalfSlab(i, 4.0f, 2);
            SoulSlab doubleSlab = new SoulDoubleSlab(i, 4.0f, 2);
            SoulBlocks.slabs[2 * i] = Optional.of(slab);
            SoulBlocks.slabs[2 * i + 1] = Optional.of(doubleSlab);
            GameRegistry.registerBlock(slab, ItemSoulSlab.class, slab.getId(), slab, doubleSlab, false);
            GameRegistry.registerBlock(doubleSlab, ItemSoulSlab.class, doubleSlab.getId(), slab, doubleSlab, true);
        }
	
		//Complex Blocks
		SoulBlocks.IceWorkbench =  			Optional.of(new BlockIceWorkbench("Ice_workbench").setHardness(4.0F).setStepSound(Block.soundTypeMetal));		
		SoulBlocks.GemcutterIdle =  		Optional.of((new BlockGemcutterBench("Gemcutter", false)).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks));	
		SoulBlocks.GemcutterActive = 		Optional.of((new BlockGemcutterBench("Gemcutter_active", true)).setHardness(4.0F).setStepSound(Block.soundTypeMetal));	
		SoulBlocks.SoulFire = 				Optional.of((new SoulFire("Soul_fire")).setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone));
		SoulBlocks.SoulFireFrozenHearth = 	Optional.of((new SoulFireFrozenHearth("Soul_fire_frozen_hearth")).setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone));
		SoulBlocks.Teleporter =   			Optional.of((new TeleportBlockSoulForest("Blueish_dizzling_portal_passage").setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone)));  
		SoulBlocks.TeleporterFrozenHearth = Optional.of((new TeleportBlockFrozenHearth("Blueish_dizzling_portal_passage_2").setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone)));  
		SoulBlocks.GelExtractor =			Optional.of((new BlockGelExtractor("Gel_extractor")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks));
		SoulBlocks.GemmerationTable =		Optional.of((new BlockGemmerationTable("Gemmeration_table")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks));
		SoulBlocks.GemmingTable =			Optional.of((new BlockGemmingTable("Gemming_table")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks));
		SoulBlocks.GembleTable =			Optional.of((new BlockGembleTable("Gemble_table")).setHardness(4.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(soul_forest.tabSoulBlocks));
	
		//Water
		// TODO No Idea how this is supposed to work just yet
		SoulBlocks.SoulWaterMovingFluid = 	Optional.of((new Fluid("soul_water", new ResourceLocation("blocks/Soul_Water_Flow"), new ResourceLocation("blocks/Soul_Water"))));
		FluidRegistry.registerFluid(SoulBlocks.SoulWaterMovingFluid.get());
		//SoulBlocks.SoulWaterMovingFluid = 	Optional.of(createFluid("Soul_Water", soul_forest.MODID + ":" + "blocks/Soul_Water", true).setLuminosity(10).setDensity(1600).setViscosity(100));
		//SoulBlocks.SoulWater =				Optional.of(new SoulWaterStationary("Soul_water_still"));
		SoulBlocks.SoulWaterMoving = 		Optional.of(new SoulWaterFlowing(SoulBlocks.SoulWaterMovingFluid.get(), "Soul_Water_Flow"));	
		
		
		//Ice
		SoulBlocks.SoulIce = 				Optional.of(new BlockSoulIce("Soul_ice"));
	
		//Stones
		SoulBlocks.DarkPorphyry =  			Optional.of(new SoulBlock("Porphyry_dark", 5.0F, 2F, false, Material.rock));  	
		SoulBlocks.Porphyry =  				Optional.of(new SoulBlock("Porphyry", 4.0F, 5.0F, false, Material.rock));  				
		SoulBlocks.Slate =  				Optional.of(new SoulBlock("Slate", 4.5F, 5.0F, false, Material.rock));  	
		SoulBlocks.Bauxite =  				Optional.of(new SoulBlock("Bauxite", 3.0F, 2F, false, Material.rock));   
		SoulBlocks.BauxiteMossy =  			Optional.of(new SoulBlock("Mossy_Bauxite", 3.5F, 2F, false, Material.rock));   
	
		//Grass & Dirt - used in Soul Forest & Marona Woods biome
		SoulBlocks.LateriteGrass =  		Optional.of((new BlockLateriteGrass("Laterite_grass")).setHardness(0.6F).setStepSound(Block.soundTypeGrass));  	
		SoulBlocks.LateriteDirt =  			Optional.of((new BlockSoulDirt("Laterite")).setHardness(0.6F).setStepSound(Block.soundTypeGrass));  
	
		//Grass & Dirt - used in Soul Forest & Marona Woods biome
		SoulBlocks.FyrisedSandGrass =  		Optional.of((new BlockFyrisedSand("Fyrised_sand_grass")).setHardness(0.5F).setStepSound(Block.soundTypeSand));  	
		SoulBlocks.FyrisedSand =  			Optional.of((new BlockSoulDirt("Fyrised_sand")).setHardness(0.5F).setStepSound(Block.soundTypeGrass));  
	
		//Snow	- used in Frost Caves & Frozen Plains biome
		SoulBlocks.SoulSnowTop =  			Optional.of((new BlockSnowTopLayer("SnowTopLayer")).setHardness(0.1F).setStepSound(Block.soundTypeSnow).setCreativeTab(soul_forest.tabSoulBlocks));	
		SoulBlocks.SoulSnowBottom =  		Optional.of((new SoulBlock("SnowBottomLayer", 0.2F, 0.2F, false, Material.sand)).setStepSound(Block.soundTypeSnow));
	
		//Grass & Dirt - used in Peat Bog biome
		SoulBlocks.BogGrass =  				Optional.of((new BlockBogGrass("Bog_grass")));  	
		SoulBlocks.BogDirt =  				Optional.of((new BlockSoulDirt("Bog_dirt")).setHardness(0.2F).setStepSound(Block.soundTypeGrass));  	
	
		//Grass - used in Frozen Plains biome
		SoulBlocks.FrozenGrass =  			Optional.of((new BlockFrozenGrass("Frozen_grass")).setHardness(0.3F).setStepSound(Block.soundTypeGrass));  	
	
		SoulBlocks.Fauna = 					Optional.of((new BlockSoulFaunaGround("fauna")));
		//GameRegistry.registerBlock(SoulBlocks.Fauna.get(), BlockSoulWithMetaData.class, "metablock");
		// TODO CHECK IF THIS WORKS???? AND HOW
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(SoulBlocks.Fauna.get()), 0, new ModelResourceLocation("modid:metablock", "inventory"));
	
		// Wooden Planks
		SoulBlocks.HardwoodPlanks =  		Optional.of((new SoulWood("Hardwood_planks", 2F, 4F)));  
		SoulBlocks.SoulPlanks =  			Optional.of((new SoulWood("Soulwood_planks", 2F, 4F)));  
		SoulBlocks.IcePlanks = 				Optional.of((new SoulWood("Frozenwood_planks", 2F, 4F)));
	
		//Logs			
		SoulBlocks.HardwoodLog = 			Optional.of((new BlockSoulLog("Hardwood_log", 4.0F)));
		SoulBlocks.SoulLog = 				Optional.of((new BlockSoulLog("Soul_log", 4.0F)));
		SoulBlocks.IceLog = 				Optional.of((new BlockSoulLog("Frozen_log", 4.0F)));
	
		//Leaves
		SoulBlocks.GrapesLeaves = 			Optional.of((new BlockSoulLeaves("Grapes", 0.5F, 10F)));
		SoulBlocks.HardwoodLeaves = 		Optional.of((new BlockSoulLeaves("Hardwood_leaves", 2.0F, 2.0F)));
		SoulBlocks.SoulLeaves = 			Optional.of((new BlockSoulLeaves("Soul_leaves", 0.5F, 1.0F)));
		SoulBlocks.SoulLeavesOrange = 		Optional.of((new BlockSoulLeaves("Soul_leaves_orange", 0.5F, 1.0F)));
		SoulBlocks.SoulLeavesPink = 		Optional.of((new BlockSoulLeaves("Soul_leaves_pink", 0.5F, 1.0F)));
		SoulBlocks.SoulLeavesYellow = 		Optional.of((new BlockSoulLeaves("Soul_leaves_yellow", 0.5F, 1.0F)));
		SoulBlocks.SoulLeavesBlue = 		Optional.of((new BlockSoulLeaves("Soul_leaves_blue", 0.5F, 1.0F)));
		SoulBlocks.IceLeaves = 				Optional.of((new BlockSoulLeaves("Frozen_leaves", 0.5F, 1.0F)));
			
		//Flowers
		SoulBlocks.PlantCantaloupe = 		Optional.of((BlockSoulPlant)(new BlockSoulPlant("Cantaloupe_flower")).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries));
		SoulBlocks.Fireblossom = 			Optional.of((BlockSoulPlant)(new BlockSoulPlant("Fireblossom")).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries));
		SoulBlocks.FrozenShinai = 			Optional.of((BlockSoulPlant)(new BlockSoulPlant("Frozen_shinai")).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries));
		SoulBlocks.Vineplant	=			Optional.of(new BlockVineplant("Vineplant").setCreativeTab(soul_forest.tabSoulBerries));
		SoulBlocks.VineplantTop	=			Optional.of(new BlockVineplant("Vineplant_top").setCreativeTab(soul_forest.tabSoulBerries));
	
		//Vines
		SoulBlocks.Baneberry = 				Optional.of(new SoulVine(1, "Baneberry"));
		SoulBlocks.Blackberry = 			Optional.of(new SoulVine(1, "Blackberry"));				
		SoulBlocks.Blueberry = 				Optional.of(new SoulVine(1, "Blueberry"));
		SoulBlocks.Cranberry = 				Optional.of(new SoulVine(1, "Cranberry"));
		SoulBlocks.Raspberry = 				Optional.of(new SoulVine(1, "Raspberry"));
		SoulBlocks.Razzberry= 				Optional.of(new SoulVine(1, "Razzberry"));
		SoulBlocks.Strawberry = 			Optional.of(new SoulVine(2, "Strawberry"));
	
		//Torches
		SoulBlocks.AmazoniteTorch = 		Optional.of(new SoulTorch("torchAmazonite"));
		SoulBlocks.AmethystTorch = 			Optional.of(new SoulTorch("torchAmethyst"));
		SoulBlocks.BronzeTorch = 			Optional.of(new SoulTorch("torchBronze"));
		SoulBlocks.ChromiteTorch = 			Optional.of(new SoulTorch("torchChromite"));
		SoulBlocks.JetTorch = 				Optional.of(new SoulTorch("torchJet"));
		SoulBlocks.OlivineTorch = 			Optional.of(new SoulTorch("torchOlivine"));
		SoulBlocks.TopazTorch = 			Optional.of(new SoulTorch("torchTopaz"));
		SoulBlocks.TurquoiseTorch = 		Optional.of(new SoulTorch("torchTurquoise"));
		SoulBlocks.VioletTorch = 			Optional.of(new SoulTorch("torchViolet"));
		SoulBlocks.WhiteOpalTorch = 		Optional.of(new SoulTorch("torchWhiteOpal"));
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
		SoulBlocks.IceStairs = 				Optional.of(new BlockSoulStairs(SoulBlocks.IcePlanks.get(), 0, "Ice_stairs", soul_forest.tabSoulBlocks));  	
	
		SoulBlocks.Chromiteore =  			Optional.of((new SoulOre(1, 2, "Chromiteore", 3.0F, 2F, false)));
		SoulBlocks.Cobaltore =  			Optional.of((new SoulOre(1, 3, "Cobaltore", 4.0F, 2F, true)));
		SoulBlocks.Copperore = 				Optional.of((new SoulOre(1, 0, "Copperore", 3.0F, 2F, false)));
		SoulBlocks.Silverore =  			Optional.of((new SoulOre(1, 2, "Silverore", 3.0F, 2F, false)));
		SoulBlocks.Steelore = 				Optional.of((new SoulOre(1, 3, "Steelore", 3.0F, 2F, false)));
		SoulBlocks.Tanzaniteore =  			Optional.of((new SoulOre(1, 2, "Tanzaniteore", 3.0F, 2F, false)));
		SoulBlocks.Tinore =  				Optional.of((new SoulOre(1, 0, "Tinore", 3.0F, 2F, false)));
		
		//Sapplings
		SoulBlocks.SaplingHardwood = 		Optional.of((new BlockSoulSapling("Sapling_hardwood", SoulBlocks.FyrisedSandGrass.get(), SoulBlocks.FyrisedSand.get(), new WorldGenTallTrees(new Random(), SoulBlocks.HardwoodLeaves.get(), SoulBlocks.HardwoodLog.get(), 
												SoulBlocks.FyrisedSandGrass.get(), SoulBlocks.FyrisedSand.get())).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries)));
		SoulBlocks.SaplingFrozen = 			Optional.of((new BlockSoulSapling("Sapling_frozen", SoulBlocks.FrozenGrass.get(), SoulBlocks.BogDirt.get(), new WorldGenTallTrees(new Random(), SoulBlocks.IceLeaves.get(), SoulBlocks.IceLog.get(), 
												SoulBlocks.FrozenGrass.get(), SoulBlocks.BogDirt.get())).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries)));
		SoulBlocks.SaplingGrape = 			Optional.of((new BlockSoulSapling("Sapling_soul", SoulBlocks.LateriteGrass.get(), SoulBlocks.LateriteDirt.get(), new WorldGenGrapeTree(true)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(soul_forest.tabSoulBerries)));
	    
		BlockSoulLeaves grapeleaves = (BlockSoulLeaves)SoulBlocks.GrapesLeaves.get();
		grapeleaves.setSapling(SoulBlocks.SaplingGrape.get());
		BlockSoulLeaves hardwoodleaves = (BlockSoulLeaves)SoulBlocks.HardwoodLeaves.get();
		hardwoodleaves.setSapling(SoulBlocks.SaplingHardwood.get());
		BlockSoulLeaves frozenleaves = (BlockSoulLeaves)SoulBlocks.IceLeaves.get();
		frozenleaves.setSapling(SoulBlocks.SaplingFrozen.get());
		BlockSoulLeaves soulLeaves = (BlockSoulLeaves)SoulBlocks.SoulLeaves.get();
		soulLeaves.setSapling(Blocks.air);
    }
}