package com.Mod_Ores.Init;

import jline.internal.Log;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Blocks.*;
import com.Mod_Ores.Blocks.Special.*;
import com.Mod_Ores.Blocks.Special.Slab.SoulSlab;
import com.Mod_Ores.Items.*;
import com.Mod_Ores.Items.Armor.*;
import com.Mod_Ores.Items.Tools.*;
import com.Mod_Ores.Dimension.SoulForest.*;
import com.Mod_Ores.Dimension.FrozenHearth.*;
import com.google.common.base.Optional;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockRenderRegistry {
		
	public static void init(){
		registerBlocks();
		registerItems();
	}
	
	public static void registerBlocks(){
		//regItemVariants(BlockSoulSapling.getEnumTypes(), SoulBlocks.SaplingGrape.get(), BlockSoulSapling.class);
		reg(SoulBlocks.Amazoniteore.get(), 0, ((SoulOre)SoulBlocks.Amazoniteore.get()).getName());
		reg(SoulBlocks.Amethystore.get(), 0, ((SoulOre)SoulBlocks.Amethystore.get()).getName());
		reg(SoulBlocks.Aquamarineore.get(), 0, ((SoulOre)SoulBlocks.Aquamarineore.get()).getName());
		reg(SoulBlocks.Blackdiamondore.get(), 0, ((SoulOre)SoulBlocks.Blackdiamondore.get()).getName());
		reg(SoulBlocks.Citrineore.get(), 0, ((SoulOre)SoulBlocks.Citrineore.get()).getName());
		reg(SoulBlocks.Jadeore.get(), 0, ((SoulOre)SoulBlocks.Jadeore.get()).getName());
		reg(SoulBlocks.Jetore.get(), 0, ((SoulOre)SoulBlocks.Jetore.get()).getName());
		reg(SoulBlocks.Lilaore.get(), 0, ((SoulOre)SoulBlocks.Lilaore.get()).getName());
		reg(SoulBlocks.Olivineore.get(), 0, ((SoulOre)SoulBlocks.Olivineore.get()).getName());
		reg(SoulBlocks.Onyxore.get(), 0, ((SoulOre)SoulBlocks.Onyxore.get()).getName());
		reg(SoulBlocks.Opalore.get(), 0, ((SoulOre)SoulBlocks.Opalore.get()).getName());
		reg(SoulBlocks.Scarletiteore.get(), 0, ((SoulOre)SoulBlocks.Scarletiteore.get()).getName());
		reg(SoulBlocks.Titaniumore.get(), 0, ((SoulOre)SoulBlocks.Titaniumore.get()).getName());
		reg(SoulBlocks.Topazore.get(), 0, ((SoulOre)SoulBlocks.Topazore.get()).getName());
		reg(SoulBlocks.Turquoiseore.get(), 0, ((SoulOre)SoulBlocks.Turquoiseore.get()).getName());
		reg(SoulBlocks.Uraniumore.get(), 0, ((SoulOre)SoulBlocks.Uraniumore.get()).getName());
		reg(SoulBlocks.Violetore.get(), 0, ((SoulOre)SoulBlocks.Violetore.get()).getName());
		reg(SoulBlocks.Whiteopalore.get(), 0, ((SoulOre)SoulBlocks.Whiteopalore.get()).getName());
		reg(SoulBlocks.Chromiteore.get(), 0, ((SoulOre)SoulBlocks.Chromiteore.get()).getName());
		reg(SoulBlocks.Cobaltore.get(), 0, ((SoulOre)SoulBlocks.Cobaltore.get()).getName());
		reg(SoulBlocks.Copperore.get(), 0, ((SoulOre)SoulBlocks.Copperore.get()).getName());
		reg(SoulBlocks.Silverore.get(), 0, ((SoulOre)SoulBlocks.Silverore.get()).getName());
		reg(SoulBlocks.Steelore.get(), 0, ((SoulOre)SoulBlocks.Steelore.get()).getName());
		reg(SoulBlocks.Tanzaniteore.get(), 0, ((SoulOre)SoulBlocks.Tanzaniteore.get()).getName());
		reg(SoulBlocks.Tinore.get(), 0, ((SoulOre)SoulBlocks.Tinore.get()).getName());
		
		reg(SoulBlocks.AmazoniteBlock.get(), 0, ((SoulBlock)SoulBlocks.AmazoniteBlock.get()).getName());
		reg(SoulBlocks.AmethystBlock.get(), 0, ((SoulBlock)SoulBlocks.AmethystBlock.get()).getName());
		reg(SoulBlocks.AquamarineBlock.get(), 0, ((SoulBlock)SoulBlocks.AquamarineBlock.get()).getName());
		reg(SoulBlocks.BlackdiamondBlock.get(), 0, ((SoulBlock)SoulBlocks.BlackdiamondBlock.get()).getName());
		reg(SoulBlocks.BronzeBlock.get(), 0, ((SoulBlock)SoulBlocks.BronzeBlock.get()).getName());
		reg(SoulBlocks.CitrineBlock.get(), 0, ((SoulBlock)SoulBlocks.CitrineBlock.get()).getName());
		reg(SoulBlocks.ChromiteBlock.get(), 0, ((SoulBlock)SoulBlocks.ChromiteBlock.get()).getName());
		reg(SoulBlocks.CobaltBlock.get(), 0, ((SoulBlock)SoulBlocks.CobaltBlock.get()).getName());
		reg(SoulBlocks.CopperBlock.get(), 0, ((SoulBlock)SoulBlocks.CopperBlock.get()).getName());
		reg(SoulBlocks.JadeBlock.get(), 0, ((SoulBlock)SoulBlocks.JadeBlock.get()).getName());
		reg(SoulBlocks.JetBlock.get(), 0, ((SoulBlock)SoulBlocks.JetBlock.get()).getName());
		reg(SoulBlocks.LilaBlock.get(), 0, ((SoulBlock)SoulBlocks.LilaBlock.get()).getName());
		reg(SoulBlocks.OlivineBlock.get(), 0, ((SoulBlock)SoulBlocks.OlivineBlock.get()).getName());
		reg(SoulBlocks.OnyxBlock.get(), 0, ((SoulBlock)SoulBlocks.OnyxBlock.get()).getName());
		reg(SoulBlocks.OpalBlock.get(), 0, ((SoulBlock)SoulBlocks.OpalBlock.get()).getName());
		reg(SoulBlocks.ScarletiteBlock.get(), 0, ((SoulBlock)SoulBlocks.ScarletiteBlock.get()).getName());
		reg(SoulBlocks.SilverBlock.get(), 0, ((SoulBlock)SoulBlocks.SilverBlock.get()).getName());
		reg(SoulBlocks.SteelBlock.get(), 0, ((SoulBlock)SoulBlocks.SteelBlock.get()).getName());
		reg(SoulBlocks.TanzaniteBlock.get(), 0, ((SoulBlock)SoulBlocks.TanzaniteBlock.get()).getName());
		reg(SoulBlocks.TinBlock.get(), 0, ((SoulBlock)SoulBlocks.TinBlock.get()).getName());
		reg(SoulBlocks.TitaniumBlock.get(), 0, ((SoulBlock)SoulBlocks.TitaniumBlock.get()).getName());
		reg(SoulBlocks.TopazBlock.get(), 0, ((SoulBlock)SoulBlocks.TopazBlock.get()).getName());
		reg(SoulBlocks.TurquoiseBlock.get(), 0, ((SoulBlock)SoulBlocks.TurquoiseBlock.get()).getName());
		reg(SoulBlocks.UraniumBlock.get(), 0, ((SoulBlock)SoulBlocks.UraniumBlock.get()).getName());
		reg(SoulBlocks.VioletBlock.get(), 0, ((SoulBlock)SoulBlocks.VioletBlock.get()).getName());
		reg(SoulBlocks.WhiteopalBlock.get(), 0, ((SoulBlock)SoulBlocks.WhiteopalBlock.get()).getName());
		
		reg(SoulBlocks.IceBrick.get(), 0, ((SoulBlock)SoulBlocks.IceBrick.get()).getName());
		reg(SoulBlocks.BauxiteBrick.get(), 0, ((SoulBlock)SoulBlocks.BauxiteBrick.get()).getName());
		reg(SoulBlocks.PorphyryBrick.get(), 0, ((SoulBlock)SoulBlocks.PorphyryBrick.get()).getName());
		reg(SoulBlocks.SlateBrick.get(), 0, ((SoulBlock)SoulBlocks.SlateBrick.get()).getName());
		reg(SoulBlocks.TitaniumBrick.get(), 0, ((SoulBlock)SoulBlocks.TitaniumBrick.get()).getName());
		
		reg(SoulBlocks.DarkPorphyry.get(), 0, ((SoulBlock)SoulBlocks.DarkPorphyry.get()).getName());
		reg(SoulBlocks.Porphyry.get(), 0, ((SoulBlock)SoulBlocks.Porphyry.get()).getName());
		reg(SoulBlocks.Slate.get(), 0, ((SoulBlock)SoulBlocks.Slate.get()).getName());
		reg(SoulBlocks.Bauxite.get(), 0, ((SoulBlock)SoulBlocks.Bauxite.get()).getName());
		reg(SoulBlocks.BauxiteMossy.get(), 0, ((SoulBlock)SoulBlocks.BauxiteMossy.get()).getName());
		
		reg(SoulBlocks.IceWorkbench.get(), 0, ((BlockIceWorkbench)SoulBlocks.IceWorkbench.get()).getName());
		reg(SoulBlocks.GemcutterIdle.get(), 0, ((BlockGemcutterBench)SoulBlocks.GemcutterIdle.get()).getName());
		reg(SoulBlocks.SoulFire.get(), 0, ((SoulFire)SoulBlocks.SoulFire.get()).getName());
		reg(SoulBlocks.SoulFireFrozenHearth.get(), 0, ((SoulFireFrozenHearth)SoulBlocks.SoulFireFrozenHearth.get()).getName());
		reg(SoulBlocks.Teleporter.get(), 0, ((TeleportBlockSoulForest)SoulBlocks.Teleporter.get()).getName());
		reg(SoulBlocks.TeleporterFrozenHearth.get(), 0, ((TeleportBlockFrozenHearth)SoulBlocks.TeleporterFrozenHearth.get()).getName());
		reg(SoulBlocks.GelExtractor.get(), 0, ((BlockGelExtractor)SoulBlocks.GelExtractor.get()).getName());
		reg(SoulBlocks.GemmerationTable.get(), 0, ((BlockGemmerationTable)SoulBlocks.GemmerationTable.get()).getName());
		reg(SoulBlocks.GemmingTable.get(), 0, ((BlockGemmingTable)SoulBlocks.GemmingTable.get()).getName());
		reg(SoulBlocks.GembleTable.get(), 0, ((BlockGembleTable)SoulBlocks.GembleTable.get()).getName());
		
		reg(SoulBlocks.SoulIce.get(), 0, ((BlockSoulIce)SoulBlocks.SoulIce.get()).getName());
		
		reg(SoulBlocks.LateriteGrass.get(), 0, ((BlockLateriteGrass)SoulBlocks.LateriteGrass.get()).getName());
		reg(SoulBlocks.LateriteDirt.get(), 0, ((BlockSoulDirt)SoulBlocks.LateriteDirt.get()).getName());
		reg(SoulBlocks.FyrisedSandGrass.get(), 0, ((BlockFyrisedSand)SoulBlocks.FyrisedSandGrass.get()).getName());
		reg(SoulBlocks.FyrisedSand.get(), 0, ((BlockSoulDirt)SoulBlocks.FyrisedSand.get()).getName());
		reg(SoulBlocks.SoulSnowTop.get(), 0, ((BlockSnowTopLayer)SoulBlocks.SoulSnowTop.get()).getName());
		reg(SoulBlocks.SoulSnowBottom.get(), 0, ((SoulBlock)SoulBlocks.SoulSnowBottom.get()).getName());
		reg(SoulBlocks.BogGrass.get(), 0, ((BlockBogGrass)SoulBlocks.BogGrass.get()).getName());
		reg(SoulBlocks.BogDirt.get(), 0, ((BlockSoulDirt)SoulBlocks.BogDirt.get()).getName());
		reg(SoulBlocks.FrozenGrass.get(), 0, ((BlockFrozenGrass)SoulBlocks.FrozenGrass.get()).getName());
		reg(SoulBlocks.Fauna.get(), 0, ((BlockSoulFaunaGround)SoulBlocks.Fauna.get()).getName());
		
		reg(SoulBlocks.IceBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.IceBrickStairs.get()).getName());
		reg(SoulBlocks.BauxiteBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.BauxiteBrickStairs.get()).getName());
		reg(SoulBlocks.PorphyryBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.PorphyryBrickStairs.get()).getName());
		reg(SoulBlocks.SlateBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.SlateBrickStairs.get()).getName());
		reg(SoulBlocks.TitaniumBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.TitaniumBrickStairs.get()).getName());
		reg(SoulBlocks.HardwoodStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.HardwoodStairs.get()).getName());
		reg(SoulBlocks.SoulStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.SoulStairs.get()).getName());
		reg(SoulBlocks.IceStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.IceStairs.get()).getName());
		
		reg(SoulBlocks.HardwoodPlanks.get(), 0, ((SoulWood)SoulBlocks.HardwoodPlanks.get()).getName());
		reg(SoulBlocks.SoulPlanks.get(), 0, ((SoulWood)SoulBlocks.SoulPlanks.get()).getName());
		reg(SoulBlocks.IcePlanks.get(), 0, ((SoulWood)SoulBlocks.IcePlanks.get()).getName());
		
		reg(SoulBlocks.HardwoodLog.get(), 0, ((BlockSoulLog)SoulBlocks.HardwoodLog.get()).getName());
		reg(SoulBlocks.SoulLog.get(), 0, ((BlockSoulLog)SoulBlocks.SoulLog.get()).getName());
		reg(SoulBlocks.IceLog.get(), 0, ((BlockSoulLog)SoulBlocks.IceLog.get()).getName());
		
		reg(SoulBlocks.GrapesLeaves.get(), 0, ((BlockSoulLeaves)SoulBlocks.GrapesLeaves.get()).getName());
		reg(SoulBlocks.HardwoodLeaves.get(), 0, ((BlockSoulLeaves)SoulBlocks.HardwoodLeaves.get()).getName());
		reg(SoulBlocks.SoulLeaves.get(), 0, ((BlockSoulLeaves)SoulBlocks.SoulLeaves.get()).getName());
		reg(SoulBlocks.SoulLeavesOrange.get(), 0, ((BlockSoulLeaves)SoulBlocks.SoulLeavesOrange.get()).getName());
		reg(SoulBlocks.SoulLeavesPink.get(), 0, ((BlockSoulLeaves)SoulBlocks.SoulLeavesPink.get()).getName());
		reg(SoulBlocks.SoulLeavesYellow.get(), 0, ((BlockSoulLeaves)SoulBlocks.SoulLeavesYellow.get()).getName());
		reg(SoulBlocks.SoulLeavesBlue.get(), 0, ((BlockSoulLeaves)SoulBlocks.SoulLeavesBlue.get()).getName());
		reg(SoulBlocks.IceLeaves.get(), 0, ((BlockSoulLeaves)SoulBlocks.IceLeaves.get()).getName());
		
		reg(SoulBlocks.SaplingHardwood.get(), 0, ((BlockSoulSapling)SoulBlocks.SaplingHardwood.get()).getName());
		reg(SoulBlocks.SaplingFrozen.get(), 0, ((BlockSoulSapling)SoulBlocks.SaplingFrozen.get()).getName());
		reg(SoulBlocks.SaplingGrape.get(), 0, ((BlockSoulSapling)SoulBlocks.SaplingGrape.get()).getName());
		
		reg(SoulBlocks.PlantCantaloupe.get(), 0, ((BlockSoulPlant)SoulBlocks.PlantCantaloupe.get()).getName());
		reg(SoulBlocks.Fireblossom.get(), 0, ((BlockSoulPlant)SoulBlocks.Fireblossom.get()).getName());
		reg(SoulBlocks.FrozenShinai.get(), 0, ((BlockSoulPlant)SoulBlocks.FrozenShinai.get()).getName());
		
		reg(SoulBlocks.Vineplant.get(), 0, ((BlockVineplant)SoulBlocks.Vineplant.get()).getName());
		reg(SoulBlocks.VineplantTop.get(), 0, ((BlockVineplant)SoulBlocks.VineplantTop.get()).getName());
				
		reg(SoulBlocks.Baneberry.get(), 0, ((SoulVine)SoulBlocks.Baneberry.get()).getName());
		reg(SoulBlocks.Blackberry.get(), 0, ((SoulVine)SoulBlocks.Blackberry.get()).getName());
		reg(SoulBlocks.Blueberry.get(), 0, ((SoulVine)SoulBlocks.Blueberry.get()).getName());
		reg(SoulBlocks.Cranberry.get(), 0, ((SoulVine)SoulBlocks.Cranberry.get()).getName());
		reg(SoulBlocks.Raspberry.get(), 0, ((SoulVine)SoulBlocks.Raspberry.get()).getName());
		reg(SoulBlocks.Razzberry.get(), 0, ((SoulVine)SoulBlocks.Razzberry.get()).getName());
		reg(SoulBlocks.Strawberry.get(), 0, ((SoulVine)SoulBlocks.Strawberry.get()).getName());
		
		reg(SoulBlocks.AmazoniteTorch.get(), 0, ((SoulTorch)SoulBlocks.AmazoniteTorch.get()).getName());
		reg(SoulBlocks.AmethystTorch.get(), 0, ((SoulTorch)SoulBlocks.AmethystTorch.get()).getName());
		reg(SoulBlocks.BronzeTorch.get(), 0, ((SoulTorch)SoulBlocks.BronzeTorch.get()).getName());
		reg(SoulBlocks.ChromiteTorch.get(), 0, ((SoulTorch)SoulBlocks.ChromiteTorch.get()).getName());
		reg(SoulBlocks.JetTorch.get(), 0, ((SoulTorch)SoulBlocks.JetTorch.get()).getName());
		reg(SoulBlocks.OlivineTorch.get(), 0, ((SoulTorch)SoulBlocks.OlivineTorch.get()).getName());
		reg(SoulBlocks.TopazTorch.get(), 0, ((SoulTorch)SoulBlocks.TopazTorch.get()).getName());
		reg(SoulBlocks.TurquoiseTorch.get(), 0, ((SoulTorch)SoulBlocks.TurquoiseTorch.get()).getName());
		reg(SoulBlocks.VioletTorch.get(), 0, ((SoulTorch)SoulBlocks.VioletTorch.get()).getName());
		reg(SoulBlocks.WhiteOpalTorch.get(), 0, ((SoulTorch)SoulBlocks.WhiteOpalTorch.get()).getName());
		
		reg(SoulBlocks.BauxiteBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.BauxiteBrickStairs.get()).getName());
		reg(SoulBlocks.IceBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.IceBrickStairs.get()).getName());
		reg(SoulBlocks.SlateBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.SlateBrickStairs.get()).getName());
		reg(SoulBlocks.PorphyryBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.PorphyryBrickStairs.get()).getName());
		reg(SoulBlocks.TitaniumBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.TitaniumBrickStairs.get()).getName());
		reg(SoulBlocks.BauxiteBrickStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.BauxiteBrickStairs.get()).getName());
		
		reg(SoulBlocks.HardwoodStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.HardwoodStairs.get()).getName());
		reg(SoulBlocks.SoulStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.SoulStairs.get()).getName());
		reg(SoulBlocks.IceStairs.get(), 0, ((BlockSoulStairs)SoulBlocks.IceStairs.get()).getName());
		
		String[] faunaVariants = new String[BlockSoulFaunaGround.grassTypes.length];
		for(int i = 0; i < BlockSoulFaunaGround.grassTypes.length; i++){
			faunaVariants[i] = BlockSoulFaunaGround.grassTypes[i];
			reg(SoulBlocks.Fauna.get(), i, BlockSoulFaunaGround.grassTypes[i]);
			//System.out.print(i + ", " + BlockSoulFaunaGround.grassTypes[i]);
		}
		regItemVariants(faunaVariants, (BlockSoulFaunaGround)SoulBlocks.Fauna.get());
		
		String[] variantNames = new String[InitBlocks.slabNames.length];
		for(int i = 0; i < InitBlocks.slabNames.length; i++){
			SoulSlab slab = (SoulSlab)SoulBlocks.slabs[i * 2].get();
			SoulSlab doubleSlab = (SoulSlab)SoulBlocks.slabs[i * 2 + 1].get();
			reg(slab, i * 2, slab.getName());
			reg(doubleSlab, i * 2 + 1, doubleSlab.getName());
			variantNames[i] = slab.getName();
		}
		regItemVariants(variantNames, (SoulSlab)SoulBlocks.slabs[0].get());
	}
	
	public static void registerItems(){
		reg(SoulItems.AquamarineAxe.get(), 0, ((ItemSoulAxe)SoulItems.AquamarineAxe.get()).getName());
		reg(SoulItems.BronzeAxe.get(), 0, ((ItemSoulAxe)SoulItems.BronzeAxe.get()).getName());
		reg(SoulItems.ChromiteAxe.get(), 0, ((ItemSoulAxe)SoulItems.ChromiteAxe.get()).getName());
		reg(SoulItems.CobaltAxe.get(), 0, ((ItemSoulAxe)SoulItems.CobaltAxe.get()).getName());
		reg(SoulItems.CopperAxe.get(), 0, ((ItemSoulAxe)SoulItems.CopperAxe.get()).getName());
		reg(SoulItems.FyrisedAxe.get(), 0, ((ItemSoulAxe)SoulItems.FyrisedAxe.get()).getName());
		reg(SoulItems.SilverAxe.get(), 0, ((ItemSoulAxe)SoulItems.SilverAxe.get()).getName());
		reg(SoulItems.SteelAxe.get(), 0, ((ItemSoulAxe)SoulItems.SteelAxe.get()).getName());
		reg(SoulItems.TanzaniteAxe.get(), 0, ((ItemSoulAxe)SoulItems.TanzaniteAxe.get()).getName());
		reg(SoulItems.TinAxe.get(), 0, ((ItemSoulAxe)SoulItems.TinAxe.get()).getName());
		
		reg(SoulItems.AquamarineHoe.get(), 0, ((ItemSoulHoe)SoulItems.AquamarineHoe.get()).getName());
		reg(SoulItems.BronzeHoe.get(), 0, ((ItemSoulHoe)SoulItems.BronzeHoe.get()).getName());
		reg(SoulItems.ChromiteHoe.get(), 0, ((ItemSoulHoe)SoulItems.ChromiteHoe.get()).getName());
		reg(SoulItems.CobaltHoe.get(), 0, ((ItemSoulHoe)SoulItems.CobaltHoe.get()).getName());
		reg(SoulItems.CopperHoe.get(), 0, ((ItemSoulHoe)SoulItems.CopperHoe.get()).getName());
		reg(SoulItems.FyrisedHoe.get(), 0, ((ItemSoulHoe)SoulItems.FyrisedHoe.get()).getName());
		reg(SoulItems.SilverHoe.get(), 0, ((ItemSoulHoe)SoulItems.SilverHoe.get()).getName());
		reg(SoulItems.SteelHoe.get(), 0, ((ItemSoulHoe)SoulItems.SteelHoe.get()).getName());
		reg(SoulItems.TanzaniteHoe.get(), 0, ((ItemSoulHoe)SoulItems.TanzaniteHoe.get()).getName());
		reg(SoulItems.TinHoe.get(), 0, ((ItemSoulHoe)SoulItems.TinHoe.get()).getName());
		
		reg(SoulItems.AquamarinePickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.AquamarinePickaxe.get()).getName());
		reg(SoulItems.BronzePickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.BronzePickaxe.get()).getName());
		reg(SoulItems.ChromitePickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.ChromitePickaxe.get()).getName());
		reg(SoulItems.CobaltPickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.CobaltPickaxe.get()).getName());
		reg(SoulItems.CopperPickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.CopperPickaxe.get()).getName());
		reg(SoulItems.FyrisedPickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.FyrisedPickaxe.get()).getName());
		reg(SoulItems.SilverPickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.SilverPickaxe.get()).getName());
		reg(SoulItems.SteelPickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.SteelPickaxe.get()).getName());
		reg(SoulItems.TanzanitePickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.TanzanitePickaxe.get()).getName());
		reg(SoulItems.TinPickaxe.get(), 0, ((ItemSoulPickaxe)SoulItems.TinPickaxe.get()).getName());
		
		reg(SoulItems.AquamarineShovel.get(), 0, ((ItemSoulShovel)SoulItems.AquamarineShovel.get()).getName());
		reg(SoulItems.BronzeShovel.get(), 0, ((ItemSoulShovel)SoulItems.BronzeShovel.get()).getName());
		reg(SoulItems.ChromiteShovel.get(), 0, ((ItemSoulShovel)SoulItems.ChromiteShovel.get()).getName());
		reg(SoulItems.CobaltShovel.get(), 0, ((ItemSoulShovel)SoulItems.CobaltShovel.get()).getName());
		reg(SoulItems.CopperShovel.get(), 0, ((ItemSoulShovel)SoulItems.CopperShovel.get()).getName());
		reg(SoulItems.FyrisedShovel.get(), 0, ((ItemSoulShovel)SoulItems.FyrisedShovel.get()).getName());
		reg(SoulItems.SilverShovel.get(), 0, ((ItemSoulShovel)SoulItems.SilverShovel.get()).getName());
		reg(SoulItems.SteelShovel.get(), 0, ((ItemSoulShovel)SoulItems.SteelShovel.get()).getName());
		reg(SoulItems.TanzaniteShovel.get(), 0, ((ItemSoulShovel)SoulItems.TanzaniteShovel.get()).getName());
		reg(SoulItems.TinShovel.get(), 0, ((ItemSoulShovel)SoulItems.TinShovel.get()).getName());
		
		reg(SoulItems.AquamarineSword.get(), 0, ((ItemSoulSword)SoulItems.AquamarineSword.get()).getName());
		reg(SoulItems.BronzeSword.get(), 0, ((ItemSoulSword)SoulItems.BronzeSword.get()).getName());
		reg(SoulItems.ChromiteSword.get(), 0, ((ItemSoulSword)SoulItems.ChromiteSword.get()).getName());
		reg(SoulItems.CobaltSword.get(), 0, ((ItemSoulSword)SoulItems.CobaltSword.get()).getName());
		reg(SoulItems.FyrisedSword.get(), 0, ((ItemSoulSword)SoulItems.FyrisedSword.get()).getName());
		reg(SoulItems.SilverSword.get(), 0, ((ItemSoulSword)SoulItems.SilverSword.get()).getName());
		reg(SoulItems.SteelSword.get(), 0, ((ItemSoulSword)SoulItems.SteelSword.get()).getName());
		reg(SoulItems.TanzaniteSword.get(), 0, ((ItemSoulSword)SoulItems.TanzaniteSword.get()).getName());
		
		reg(SoulItems.AquamarineWaraxe.get(), 0, ((ItemWarAxe)SoulItems.AquamarineWaraxe.get()).getName());
		
		reg(SoulItems.TinThrowingknife.get(), 0, ((ItemThrowingKnife)SoulItems.TinThrowingknife.get()).getName());
		reg(SoulItems.CopperThrowingknife.get(), 0, ((ItemThrowingKnife)SoulItems.CopperThrowingknife.get()).getName());
		
		reg(SoulItems.AmazoniteGem.get(), 0, ((ItemGem)SoulItems.AmazoniteGem.get()).getName());
		reg(SoulItems.AmazoniteUncut.get(), 0, ((ItemGem)SoulItems.AmazoniteUncut.get()).getName());
		reg(SoulItems.AmethystGem.get(), 0, ((ItemGem)SoulItems.AmethystGem.get()).getName());
		reg(SoulItems.AmethystUncut.get(), 0, ((ItemGem)SoulItems.AmethystUncut.get()).getName());
		reg(SoulItems.AquamarineGem.get(), 0, ((ItemGem)SoulItems.AquamarineGem.get()).getName());
		reg(SoulItems.AquamarineUncut.get(), 0, ((ItemGem)SoulItems.AquamarineUncut.get()).getName());
		reg(SoulItems.BlackdiamondGem.get(), 0, ((ItemGem)SoulItems.BlackdiamondGem.get()).getName());
		reg(SoulItems.BlackdiamondUncut.get(), 0, ((ItemGem)SoulItems.BlackdiamondUncut.get()).getName());
		reg(SoulItems.CitrineGem.get(), 0, ((ItemGem)SoulItems.CitrineGem.get()).getName());
		reg(SoulItems.CitrineUncut.get(), 0, ((ItemGem)SoulItems.CitrineUncut.get()).getName());
		reg(SoulItems.JadeGem.get(), 0, ((ItemGem)SoulItems.JadeGem.get()).getName());
		reg(SoulItems.JadeUncut.get(), 0, ((ItemGem)SoulItems.JadeUncut.get()).getName());
		reg(SoulItems.JetGem.get(), 0, ((ItemGem)SoulItems.JetGem.get()).getName());
		reg(SoulItems.JetUncut.get(), 0, ((ItemGem)SoulItems.JetUncut.get()).getName());
		reg(SoulItems.LilaGem.get(), 0, ((ItemGem)SoulItems.LilaGem.get()).getName());
		reg(SoulItems.LilaUncut.get(), 0, ((ItemGem)SoulItems.LilaUncut.get()).getName());
		reg(SoulItems.OlivineGem.get(), 0, ((ItemGem)SoulItems.OlivineGem.get()).getName());
		reg(SoulItems.OlivineUncut.get(), 0, ((ItemGem)SoulItems.OlivineUncut.get()).getName());
		reg(SoulItems.OnyxGem.get(), 0, ((ItemGem)SoulItems.OnyxGem.get()).getName());
		reg(SoulItems.OnyxUncut.get(), 0, ((ItemGem)SoulItems.OnyxUncut.get()).getName());
		reg(SoulItems.OpalGem.get(), 0, ((ItemGem)SoulItems.OpalGem.get()).getName());
		reg(SoulItems.OpalUncut.get(), 0, ((ItemGem)SoulItems.OpalUncut.get()).getName());
		reg(SoulItems.ScarletiteGem.get(), 0, ((ItemGem)SoulItems.ScarletiteGem.get()).getName());
		reg(SoulItems.ScarletiteUncut.get(), 0, ((ItemGem)SoulItems.ScarletiteUncut.get()).getName());
		reg(SoulItems.TitaniumGem.get(), 0, ((ItemGem)SoulItems.TitaniumGem.get()).getName());
		reg(SoulItems.TitaniumUncut.get(), 0, ((ItemGem)SoulItems.TitaniumUncut.get()).getName());
		reg(SoulItems.TopazGem.get(), 0, ((ItemGem)SoulItems.TopazGem.get()).getName());
		reg(SoulItems.TopazUncut.get(), 0, ((ItemGem)SoulItems.TopazUncut.get()).getName());
		reg(SoulItems.TurquoiseGem.get(), 0, ((ItemGem)SoulItems.TurquoiseGem.get()).getName());
		reg(SoulItems.TurquoiseUncut.get(), 0, ((ItemGem)SoulItems.TurquoiseUncut.get()).getName());
		reg(SoulItems.UraniumGem.get(), 0, ((ItemGem)SoulItems.UraniumGem.get()).getName());
		reg(SoulItems.VioletGem.get(), 0, ((ItemGem)SoulItems.VioletGem.get()).getName());
		reg(SoulItems.VioletUncut.get(), 0, ((ItemGem)SoulItems.VioletUncut.get()).getName());
		reg(SoulItems.WhiteopalGem.get(), 0, ((ItemGem)SoulItems.WhiteopalGem.get()).getName());
		reg(SoulItems.WhiteopalUncut.get(), 0, ((ItemGem)SoulItems.WhiteopalUncut.get()).getName());
		
		reg(SoulItems.AmazoniteAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.AmazoniteAmuletStone.get()).getName());
		reg(SoulItems.AmethystAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.AmethystAmuletStone.get()).getName());
		reg(SoulItems.AquamarineAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.AquamarineAmuletStone.get()).getName());
		reg(SoulItems.BlackdiamondAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.BlackdiamondAmuletStone.get()).getName());
		reg(SoulItems.CitrineAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.CitrineAmuletStone.get()).getName());
		reg(SoulItems.JadeAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.JadeAmuletStone.get()).getName());
		reg(SoulItems.JetAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.JetAmuletStone.get()).getName());
		reg(SoulItems.LilaAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.LilaAmuletStone.get()).getName());
		reg(SoulItems.OlivineAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.OlivineAmuletStone.get()).getName());
		reg(SoulItems.OnyxAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.OnyxAmuletStone.get()).getName());
		reg(SoulItems.ScarletiteAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.ScarletiteAmuletStone.get()).getName());
		reg(SoulItems.TopazAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.TopazAmuletStone.get()).getName());
		reg(SoulItems.TurquoiseAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.TurquoiseAmuletStone.get()).getName());
		reg(SoulItems.VioletAmuletStone.get(), 0, ((ItemAmuletStone)SoulItems.VioletAmuletStone.get()).getName());
		
		reg(SoulItems.BlackdiamondAmuletRing.get(), 0, ((ItemAmuletRing)SoulItems.BlackdiamondAmuletRing.get()).getName());
		reg(SoulItems.OlivineAmuletRing.get(), 0, ((ItemAmuletRing)SoulItems.OlivineAmuletRing.get()).getName());
		reg(SoulItems.TurquoiseAmuletRing.get(), 0, ((ItemAmuletRing)SoulItems.TurquoiseAmuletRing.get()).getName());
		
		reg(SoulItems.GrapesBushel.get(), 0, ((ItemSoulBushel)SoulItems.GrapesBushel.get()).getName());
		reg(SoulItems.BaneberryBushel.get(), 0, ((ItemSoulBushel)SoulItems.BaneberryBushel.get()).getName());
		reg(SoulItems.BlackberryBushel.get(), 0, ((ItemSoulBushel)SoulItems.BlackberryBushel.get()).getName());
		reg(SoulItems.BlueberryBushel.get(), 0, ((ItemSoulBushel)SoulItems.BlueberryBushel.get()).getName());
		reg(SoulItems.CranberryBushel.get(), 0, ((ItemSoulBushel)SoulItems.CranberryBushel.get()).getName());
		reg(SoulItems.RaspberryBushel.get(), 0, ((ItemSoulBushel)SoulItems.RaspberryBushel.get()).getName());
		reg(SoulItems.RazzberryBushel.get(), 0, ((ItemSoulBushel)SoulItems.RazzberryBushel.get()).getName());
		reg(SoulItems.Strawberries.get(), 0, ((ItemSoulBushel)SoulItems.Strawberries.get()).getName());

		reg(SoulItems.BlueberryMuffin.get(), 0, ((ItemSoulFood)SoulItems.BlueberryMuffin.get()).getName());
		reg(SoulItems.BaneberryCake.get(), 0, ((ItemSoulFood)SoulItems.BaneberryCake.get()).getName());
		reg(SoulItems.BlackberryCrumble.get(), 0, ((ItemSoulFood)SoulItems.BlackberryCrumble.get()).getName());
		reg(SoulItems.CranberryJuice.get(), 0, ((ItemSoulFood)SoulItems.CranberryJuice.get()).getName());
		reg(SoulItems.CranberryMuffin.get(), 0, ((ItemSoulFood)SoulItems.CranberryMuffin.get()).getName());
		reg(SoulItems.RaspberryJuice.get(), 0, ((ItemSoulFood)SoulItems.RaspberryJuice.get()).getName());
		reg(SoulItems.RazzberryJuice.get(), 0, ((ItemSoulFood)SoulItems.RazzberryJuice.get()).getName());
		reg(SoulItems.RazzberryPie.get(), 0, ((ItemSoulFood)SoulItems.RazzberryPie.get()).getName());
		reg(SoulItems.StrawberryPie.get(), 0, ((ItemSoulFood)SoulItems.StrawberryPie.get()).getName());
		reg(SoulItems.Wine.get(), 0, ((ItemSoulFood)SoulItems.Wine.get()).getName());
		
		reg(SoulItems.BronzeIngot.get(), 0, ((ItemSoulIngot)SoulItems.BronzeIngot.get()).getName());
		reg(SoulItems.ChromiteIngot.get(), 0, ((ItemSoulIngot)SoulItems.ChromiteIngot.get()).getName());
		reg(SoulItems.CobaltIngot.get(), 0, ((ItemSoulIngot)SoulItems.CobaltIngot.get()).getName());
		reg(SoulItems.CopperIngot.get(), 0, ((ItemSoulIngot)SoulItems.CopperIngot.get()).getName());
		reg(SoulItems.SilverIngot.get(), 0, ((ItemSoulIngot)SoulItems.SilverIngot.get()).getName());
		reg(SoulItems.SteelIngot.get(), 0, ((ItemSoulIngot)SoulItems.SteelIngot.get()).getName());
		reg(SoulItems.TanzaniteIngot.get(), 0, ((ItemSoulIngot)SoulItems.TanzaniteIngot.get()).getName());
		reg(SoulItems.TinIngot.get(), 0, ((ItemSoulIngot)SoulItems.TinIngot.get()).getName());
		
		reg(SoulItems.BronzeChestplate.get(), 0, ((ItemArmorBronze)SoulItems.BronzeChestplate.get()).getName());
		reg(SoulItems.CobaltChestplate.get(), 0, ((ItemArmorCobalt)SoulItems.CobaltChestplate.get()).getName());
		reg(SoulItems.FyrisedChestplate.get(), 0, ((ItemArmorFyrised)SoulItems.FyrisedChestplate.get()).getName());
		reg(SoulItems.SilverChestplate.get(), 0, ((ItemArmorSilver)SoulItems.SilverChestplate.get()).getName());
		reg(SoulItems.SteelChestplate.get(), 0, ((ItemArmorSteel)SoulItems.SteelChestplate.get()).getName());
		reg(SoulItems.SlimeChestplate.get(), 0, ((ItemArmorSlime)SoulItems.SlimeChestplate.get()).getName());
		
		reg(SoulItems.BronzeLeggings.get(), 0, ((ItemArmorBronze)SoulItems.BronzeLeggings.get()).getName());
		reg(SoulItems.CobaltLeggings.get(), 0, ((ItemArmorCobalt)SoulItems.CobaltLeggings.get()).getName());
		reg(SoulItems.FyrisedLeggings.get(), 0, ((ItemArmorFyrised)SoulItems.FyrisedLeggings.get()).getName());
		reg(SoulItems.SilverLeggings.get(), 0, ((ItemArmorSilver)SoulItems.SilverLeggings.get()).getName());
		reg(SoulItems.SteelLeggings.get(), 0, ((ItemArmorSteel)SoulItems.SteelLeggings.get()).getName());
		reg(SoulItems.SlimeLeggings.get(), 0, ((ItemArmorSlime)SoulItems.SlimeLeggings.get()).getName());
		
		reg(SoulItems.BronzeBoots.get(), 0, ((ItemArmorBronze)SoulItems.BronzeBoots.get()).getName());
		reg(SoulItems.CobaltBoots.get(), 0, ((ItemArmorCobalt)SoulItems.CobaltBoots.get()).getName());
		reg(SoulItems.FyrisedBoots.get(), 0, ((ItemArmorFyrised)SoulItems.FyrisedBoots.get()).getName());
		reg(SoulItems.SilverBoots.get(), 0, ((ItemArmorSilver)SoulItems.SilverBoots.get()).getName());
		reg(SoulItems.SteelBoots.get(), 0, ((ItemArmorSteel)SoulItems.SteelBoots.get()).getName());
		reg(SoulItems.SlimeBoots.get(), 0, ((ItemArmorSlime)SoulItems.SlimeBoots.get()).getName());
		
		reg(SoulItems.BronzeHelmet.get(), 0, ((ItemArmorBronze)SoulItems.BronzeHelmet.get()).getName());
		reg(SoulItems.CobaltHelmet.get(), 0, ((ItemArmorCobalt)SoulItems.CobaltHelmet.get()).getName());
		reg(SoulItems.FyrisedHelmet.get(), 0, ((ItemArmorFyrised)SoulItems.FyrisedHelmet.get()).getName());
		reg(SoulItems.SilverHelmet.get(), 0, ((ItemArmorSilver)SoulItems.SilverHelmet.get()).getName());
		reg(SoulItems.SteelHelmet.get(), 0, ((ItemArmorSteel)SoulItems.SteelHelmet.get()).getName());
		reg(SoulItems.SlimeHelmet.get(), 0, ((ItemArmorSlime)SoulItems.SlimeHelmet.get()).getName());
		
		reg(SoulItems.BerryCollector.get(), 0, ((ItemBerrycollector)SoulItems.BerryCollector.get()).getName());
		reg(SoulItems.SoulLighter.get(), 0, ((ItemSoulLighter)SoulItems.SoulLighter.get()).getName());
		reg(SoulItems.FrostLighter.get(), 0, ((ItemFrostLighter)SoulItems.FrostLighter.get()).getName());
		reg(SoulItems.FrostWand.get(), 0, ((ItemFrostWand)SoulItems.FrostWand.get()).getName());
		
		reg(SoulItems.Polisher.get(), 0, ((SoulItem)SoulItems.Polisher.get()).getName());
		reg(SoulItems.PolisherTowel.get(), 0, ((SoulItem)SoulItems.PolisherTowel.get()).getName());
		reg(SoulItems.UraniumLiquid.get(), 0, ((SoulItem)SoulItems.UraniumLiquid.get()).getName());
		reg(SoulItems.FrostShard.get(), 0, ((SoulItem)SoulItems.FrostShard.get()).getName());
		reg(SoulItems.BurnedShard.get(), 0, ((SoulItem)SoulItems.BurnedShard.get()).getName());
		reg(SoulItems.LightShard.get(), 0, ((SoulItem)SoulItems.LightShard.get()).getName());
		reg(SoulItems.StrengthShard.get(), 0, ((SoulItem)SoulItems.StrengthShard.get()).getName());
		reg(SoulItems.Soul.get(), 0, ((SoulItem)SoulItems.Soul.get()).getName());
		reg(SoulItems.FrozenRod.get(), 0, ((SoulItem)SoulItems.FrozenRod.get()).getName());
		reg(SoulItems.BlueGel.get(), 0, ((SoulItem)SoulItems.BlueGel.get()).getName());
		reg(SoulItems.BlueMoltenGel.get(), 0, ((SoulItem)SoulItems.BlueMoltenGel.get()).getName());
		reg(SoulItems.GelPot.get(), 0, ((ItemGelPot)SoulItems.GelPot.get()).getName());
		reg(SoulItems.GelPotFilled.get(), 0, ((ItemGelPot)SoulItems.GelPotFilled.get()).getName());
		reg(SoulItems.GelPotKing.get(), 0, ((ItemKingGelPot)SoulItems.GelPotKing.get()).getName());
		reg(SoulItems.IceCrystal.get(), 0, ((ItemIceCrystal)SoulItems.IceCrystal.get()).getName());
		reg(SoulItems.MochanEagleFeather.get(), 0, ((SoulItem)SoulItems.MochanEagleFeather.get()).getName());
		reg(SoulItems.MochanEagleWing.get(), 0, ((SoulItem)SoulItems.MochanEagleWing.get()).getName());
		reg(SoulItems.FrozenStick.get(), 0, ((SoulItem)SoulItems.FrozenStick.get()).getName());
		reg(SoulItems.OnyxStick.get(), 0, ((SoulItem)SoulItems.OnyxStick.get()).getName());
		reg(SoulItems.TitaniumStick.get(), 0, ((SoulItem)SoulItems.TitaniumStick.get()).getName());
		reg(SoulItems.MagicEmblem.get(), 0, ((SoulItem)SoulItems.MagicEmblem.get()).getName());

		reg(SoulItems.BurnedFragment.get(), 0, ((ItemMagicFragment)SoulItems.BurnedFragment.get()).getName());
		reg(SoulItems.FrostFragment.get(), 0, ((ItemMagicFragment)SoulItems.FrostFragment.get()).getName());
		reg(SoulItems.LightFragment.get(), 0, ((ItemMagicFragment)SoulItems.LightFragment.get()).getName());
		reg(SoulItems.SoulFragment.get(), 0, ((ItemMagicFragment)SoulItems.SoulFragment.get()).getName());
		reg(SoulItems.StrengthFragment.get(), 0, ((ItemMagicFragment)SoulItems.StrengthFragment.get()).getName());
		reg(SoulItems.SoulFragmentEnhanced.get(), 0, ((ItemMagicFragment)SoulItems.SoulFragmentEnhanced.get()).getName());
		reg(SoulItems.BurnedMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.BurnedMagicFragmentAdv.get()).getName());
		reg(SoulItems.EnlightedMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.EnlightedMagicFragmentAdv.get()).getName());
		reg(SoulItems.FireMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.FireMagicFragmentAdv.get()).getName());
		reg(SoulItems.FlightMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.FlightMagicFragmentAdv.get()).getName());
		reg(SoulItems.FrozenMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.FrozenMagicFragmentAdv.get()).getName());
		reg(SoulItems.HardenedMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.HardenedMagicFragmentAdv.get()).getName());
		reg(SoulItems.PowerMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.PowerMagicFragmentAdv.get()).getName());
		reg(SoulItems.SharpMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.SharpMagicFragmentAdv.get()).getName());
		reg(SoulItems.ShinyMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.ShinyMagicFragmentAdv.get()).getName());
		reg(SoulItems.SoulMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.SoulMagicFragmentAdv.get()).getName());
		reg(SoulItems.StrengthMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.StrengthMagicFragmentAdv.get()).getName());
		reg(SoulItems.StrongMagicFragmentAdv.get(), 0, ((ItemMagicFragment)SoulItems.StrongMagicFragmentAdv.get()).getName());
		reg(SoulItems.EnlightedMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.EnlightedMagicFragmentHalf.get()).getName());
		reg(SoulItems.FireMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.FireMagicFragmentHalf.get()).getName());
		reg(SoulItems.FlightMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.FlightMagicFragmentHalf.get()).getName());
		reg(SoulItems.FrozenMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.FrozenMagicFragmentHalf.get()).getName());
		reg(SoulItems.HardenedMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.HardenedMagicFragmentHalf.get()).getName());
		reg(SoulItems.PowerMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.PowerMagicFragmentHalf.get()).getName());
		reg(SoulItems.SharpMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.SharpMagicFragmentHalf.get()).getName());
		reg(SoulItems.ShinyMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.ShinyMagicFragmentHalf.get()).getName());
		reg(SoulItems.SoulMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.SoulMagicFragmentHalf.get()).getName());
		reg(SoulItems.StrengthMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.StrengthMagicFragmentHalf.get()).getName());
		reg(SoulItems.StrongMagicFragmentHalf.get(), 0, ((ItemMagicFragment)SoulItems.StrongMagicFragmentHalf.get()).getName());
		reg(SoulItems.BurnedMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.BurnedMagicFragment.get()).getName());
		reg(SoulItems.EnlightedMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.EnlightedMagicFragment.get()).getName());
		reg(SoulItems.FireMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.FireMagicFragment.get()).getName());
		reg(SoulItems.FlightMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.FlightMagicFragment.get()).getName());
		reg(SoulItems.FrozenMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.FrozenMagicFragment.get()).getName());
		reg(SoulItems.HardenedMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.HardenedMagicFragment.get()).getName());
		reg(SoulItems.HotMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.HotMagicFragment.get()).getName());
		reg(SoulItems.PowerMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.PowerMagicFragment.get()).getName());
		reg(SoulItems.SharpMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.SharpMagicFragment.get()).getName());
		reg(SoulItems.ShinyMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.ShinyMagicFragment.get()).getName());
		reg(SoulItems.SoulMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.SoulMagicFragment.get()).getName());
		reg(SoulItems.StrengthMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.StrengthMagicFragment.get()).getName());
		reg(SoulItems.StrongMagicFragment.get(), 0, ((ItemMagicFragment)SoulItems.StrongMagicFragment.get()).getName());
		
		reg(SoulItems.SoulBucket.get(), 0, ((ItemBlackBucket)SoulItems.SoulBucket.get()).getName());
		reg(SoulItems.BucketSoulWater.get(), 0, ((ItemBlackBucket)SoulItems.BucketSoulWater.get()).getName());
		reg(SoulItems.ItemVineplant.get(), 0, ((ItemVineplant)SoulItems.ItemVineplant.get()).getName());
	}
	
	public static void reg(Block block, int meta, String blockName) {
		reg(Item.getItemFromBlock(block), meta, blockName);
	}
	
	public static void reg(Item item, int meta, String itemName) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(item, meta, 
				new ModelResourceLocation(soul_forest.MODID + ":" + itemName, "inventory"));
	}
	
	/*public static void registerBlockRenderer() {
	    reg(SoulBlocks.SaplingGrape.get(), 0, "block_properties_white");
	    reg(SoulBlocks.SaplingGrape.get(), 1, "block_properties_black");
	}*/
		
	public static void regItemVariants(String[] variants, Block block){
		ResourceLocation[] resLoc = new ResourceLocation[variants.length];
		for (int i = 0; i < variants.length; i++){
			resLoc[i] = new ResourceLocation(soul_forest.MODID + ":" + variants[i]);
		}
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), resLoc);
	}
}