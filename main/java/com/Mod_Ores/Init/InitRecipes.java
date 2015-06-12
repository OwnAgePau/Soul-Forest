package com.Mod_Ores.Init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitRecipes {
    public static void init(){
	addCraftingRecipes();
	addSmeltingRecipes();
    }

    public static void addCraftingRecipes(){
	// Storage Blocks Create
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.AmazoniteBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.AmazoniteGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.AmethystBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.AmethystGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.AquamarineBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.AquamarineGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.BlackdiamondBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.BlackdiamondGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.BronzeBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.BronzeIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.ChromiteBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.ChromiteIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.CitrineBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.CitrineGem.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.CobaltBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.CobaltIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.CopperBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.CopperIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.JadeBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.JadeGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.JetBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.JetGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.LilaBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.LilaGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.MithrilBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.MithrilIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.OlivineBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.OlivineGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.OnyxBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.OnyxGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.OpalBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.OpalGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.ScarletiteBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.ScarletiteGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SilverBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.SilverIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SteelBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.SteelIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TanzaniteBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.TanzaniteIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TinBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.TinIngot.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TitaniumBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.TitaniumGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TopazBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.TopazGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TurquoiseBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.TurquoiseGem.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.UraniumBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.UraniumGem.get() 	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.VioletBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.VioletGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.WhiteopalBlock.get(), 1), new Object[] {
	    "XXX", "XXX", "XXX",  'X', SoulItems.WhiteopalGem.get()	//Crafting Line  
	});

	// Reclaiming Storage Blocks
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.AmazoniteGem.get(), 9), new Object[] {
	    SoulBlocks.AmazoniteBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.AmethystGem.get(), 9), new Object[] {
	    SoulBlocks.AmethystBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.AquamarineGem.get(), 9), new Object[] {
	    SoulBlocks.AquamarineBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.BlackdiamondGem.get(), 9), new Object[] {
	    SoulBlocks.BlackdiamondBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.CitrineGem.get(), 9), new Object[] {
	    SoulBlocks.CitrineBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.JadeGem.get(), 9), new Object[] {
	    SoulBlocks.JadeBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.JetGem.get(), 9), new Object[] {
	    SoulBlocks.JetBlock	.get()		//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.LilaGem.get(), 9), new Object[] {
	    SoulBlocks.LilaBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.OlivineGem.get(), 9), new Object[] {
	    SoulBlocks.OlivineBlock.get()		//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.OnyxGem.get(), 9), new Object[] {
	    SoulBlocks.OnyxBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.OpalGem.get(), 9), new Object[] {
	    SoulBlocks.OpalBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.TitaniumGem.get(), 9), new Object[] {
	    SoulBlocks.TitaniumBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.TopazGem.get(), 9), new Object[] {
	    SoulBlocks.TopazBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.TurquoiseGem.get(), 9), new Object[] {
	    SoulBlocks.TurquoiseBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.UraniumGem.get(), 9), new Object[] {
	    SoulBlocks.UraniumBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.VioletGem.get(), 9), new Object[] {
	    SoulBlocks.VioletBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.WhiteopalGem.get(), 9), new Object[] {
	    SoulBlocks.WhiteopalBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.BronzeIngot.get(), 9), new Object[] {
	    SoulBlocks.BronzeBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.ScarletiteGem.get(), 9), new Object[] {
	    SoulBlocks.ScarletiteBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.CobaltIngot.get(), 9), new Object[] {
	    SoulBlocks.CobaltBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.CopperIngot.get(), 9), new Object[] {
	    SoulBlocks.CopperBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.MithrilIngot.get(), 9), new Object[] {
	    SoulBlocks.MithrilBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.SilverIngot.get(), 9), new Object[] {
	    SoulBlocks.SilverBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.SteelIngot.get(), 9), new Object[] {
	    SoulBlocks.SteelBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.TanzaniteIngot.get(), 9), new Object[] {
	    SoulBlocks.TanzaniteBlock.get()			//Crafting Line  
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.TinIngot.get(), 9), new Object[] {
	    SoulBlocks.TinBlock.get()			//Crafting Line  
	});

	// Food Recipes
	GameRegistry.addRecipe(new ItemStack(SoulItems.BlueberryMuffin.get(), 2), new Object[]{
	    "WWW", "YBY", "SEM",  'W', Items.wheat , 'Y', SoulItems.BlueberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'E', Items.egg , 'M', Items.milk_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CranberryMuffin.get(), 2), new Object[] {
	    "WWW", "YBY", "SEM",  'W', Items.wheat , 'Y', SoulItems.CranberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'E', Items.egg , 'M', Items.milk_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BaneberryCake.get(), 1), new Object[] {
	    "WWW", "YBY", "SEM",  'W', Items.wheat , 'Y', SoulItems.BaneberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'E', Items.egg , 'M', Items.milk_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BlackberryCrumble.get(), 1), new Object[] {
	    "WWW", "YBY", "SEM",  'W', Items.wheat , 'Y', SoulItems.BlackberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'E', Items.apple , 'M', Items.milk_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CranberryJuice.get(), 1), new Object[] {
	    "SMS", "YBY", "SMS", 'Y', SoulItems.CranberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'M', Items.water_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.RaspberryJuice.get(), 1), new Object[] {
	    "SMS", "YBY", "SMS", 'Y', SoulItems.RaspberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'M', Items.water_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.RazzberryJuice.get(), 1), new Object[] {
	    "SMS", "YBY", "SMS", 'Y', SoulItems.RazzberryBushel.get(), 'B', Items.bowl , 'S', Items.sugar , 'M', Items.water_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.RazzberryPie.get(), 1), new Object[] {
	    "WWW", "YBX", "SEM",  'W', Items.wheat , 'Y', SoulItems.RaspberryBushel.get(), 'X', SoulItems.RazzberryBushel.get(), 'B', SoulItems.RazzberryJuice.get() , 'S', Items.sugar , 'E', Items.egg , 'M', Items.milk_bucket		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.StrawberryPie.get(), 1), new Object[] {
	    "WWW", "YBY", "SEM",  'W', Items.wheat , 'Y', SoulItems.Strawberries.get(), 'B', SoulItems.RaspberryJuice.get(), 'S', Items.sugar , 'E', Items.egg , 'M', Items.milk_bucket		//Crafting Line  
	});

	// Bushels
	GameRegistry.addRecipe(new ItemStack(SoulItems.GrapesBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.GrapesLeaves.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BaneberryBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Baneberry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BlackberryBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Blackberry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BlueberryBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Blueberry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CranberryBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Cranberry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.RaspberryBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Raspberry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.RazzberryBushel.get(), 1), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Razzberry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.Strawberries.get(), 9), new Object[] {
	    "YYY", "YYY", "YYY",  'Y', SoulBlocks.Strawberry.get()		//Crafting Line  
	});					    	

	//Custom Item Recipes
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.IceWorkbench.get(), 1), new Object[] 
		{
	    "ZZZ", "XXX", "ZZZ", 'X', SoulItems.FrostShard.get(),  'Z',	SoulItems.FrostFragment.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.GemcutterIdle.get(), 1), new Object[] 
		{
	    "ZZZ", "YXY", "ZZZ",  'Y', SoulBlocks.SoulLog.get(), 'X', SoulItems.ScarletiteUncut.get(),  'Z',	SoulBlocks.SoulPlanks.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.GemcutterIdle.get(), 1), new Object[] 
		{
	    "ZZZ", "YXY", "ZZZ",  'Y', SoulBlocks.SoulLog.get(), 'X', SoulItems.ScarletiteUncut.get(),  'Z',	SoulBlocks.HardwoodPlanks.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.Polisher.get(), 1), new Object[] 
		{
	    "CCC", "YXY", "YZY",  'Y', SoulItems.OpalUncut.get(), 'X', SoulItems.WhiteopalUncut.get(),  'Z',	Items.bucket, 'C', SoulItems.CitrineUncut.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.PolisherTowel.get(), 3), new Object[] 
		{
	    "YZY", "ZXZ", "YZY",  'Y', SoulItems.OpalUncut.get(), 'X', SoulItems.WhiteopalUncut.get(),	'Z', Blocks.wool,	//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.FrozenRod.get(), 1), new Object[] 
		{
	    " Y ", " Y ", " Y ",  'Y', SoulItems.FrostShard.get(),	//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SoulBucket.get(), 3), new Object[] 
		{
	    "   ", "Y Y", " Y ",  'Y', SoulItems.TitaniumGem.get(),	//Crafting Line
		});	
	GameRegistry.addRecipe(new ItemStack(SoulItems.FrozenStick.get(), 1), new Object[] 
		{
	    "YXY", "YSY", "YXY",  'Y', SoulItems.FrozenRod.get(), 'X', SoulItems.FrostShard.get(), 'S', Items.stick	//Crafting Line
		});	
	GameRegistry.addRecipe(new ItemStack(SoulItems.MochanEagleWing.get(), 1), new Object[] 
		{
	    "YYY", " YY", "  Y",  'Y', SoulItems.MochanEagleFeather.get()	//Crafting Line
		});

	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.SoulLighter.get(), 1), new Object[] 
		{
	    SoulItems.SteelIngot.get(), SoulItems.UraniumGem.get()	//Crafting Line  
		});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.BronzeIngot.get(), 2), new Object[] 
		{
	    SoulItems.CopperIngot.get(), SoulItems.TinIngot.get()				//Crafting Line  
		});
	//Liquid Uranium
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.UraniumLiquid.get(), 1), new Object[] 
		{
	    SoulItems.UraniumGem.get(), Items.lava_bucket					//Crafting Line  
		});	
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.TitaniumStick.get(), 2), new Object[] 
		{
	    SoulItems.TitaniumGem.get(), Items.stick					//Crafting Line
		});	
	GameRegistry.addShapelessRecipe(new ItemStack(SoulItems.OnyxStick.get(), 2), new Object[] 
		{
	    SoulItems.OnyxGem.get(), Items.stick						//Crafting Line
		});	

	// Fragments
	GameRegistry.addRecipe(new ItemStack(SoulItems.SoulFragment.get(), 1), new Object[] 
		{
	    "YYY", "YYY", "YYY",  'Y', SoulItems.Soul.get()	//Crafting Line
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SoulFragmentEnhanced.get(), 1), new Object[] 
		{
	    "YYY", "YDY", "YYY",  'Y', SoulItems.SoulFragment.get(), 'D', Items.diamond	//Crafting Line
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.FrostFragment.get(), 1), new Object[] 
		{
	    "YYY", "YYY", "YYY",  'Y', SoulItems.FrostShard.get()	//Crafting Line
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.LightFragment.get(), 1), new Object[] 
		{
	    "YYY", "YYY", "YYY",  'Y', SoulItems.LightShard.get()	//Crafting Line
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BurnedFragment.get(), 1), new Object[] 
		{
	    "YYY", "YYY", "YYY",  'Y', SoulItems.BurnedShard.get()	//Crafting Line
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.StrengthFragment.get(), 1), new Object[] 
		{
	    "YYY", "YYY", "YYY",  'Y', SoulItems.StrengthShard.get()	//Crafting Line
		});				    			

	//Brick Recipes
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.IceBrick.get(), 4), new Object[] {
	    "SSS", "FXF", "YXY",  'Y', SoulBlocks.SoulSnowBottom.get(), 'X', SoulBlocks.SoulSnowTop.get(), 'F', SoulItems.FrozenRod.get(), 'S', SoulItems.FrostShard.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.BauxiteBrick.get(), 4), new Object[] {
	    "YY", "YY",  'Y', SoulBlocks.Bauxite.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.PorphyryBrick.get(), 4), new Object[] {
	    "YY", "YY",  'Y', SoulBlocks.Porphyry.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SlateBrick.get(), 4), new Object[] {
	    "YY", "YY",  'Y', SoulBlocks.Slate.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TitaniumBrick.get(), 4), new Object[] {
	    "YY", "YY",  'Y', SoulItems.TitaniumGem.get()		//Crafting Line  
	});

	// Brick Stairs
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.IceBrickStairs.get(), 1), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.IceBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.IceBrickStairs.get(), 1), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.IceBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.BauxiteBrickStairs.get(), 1), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.BauxiteBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.BauxiteBrickStairs.get(), 1), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.BauxiteBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.PorphyryBrickStairs.get(), 1), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.PorphyryBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.PorphyryBrickStairs.get(), 1), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.PorphyryBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SlateBrickStairs.get(), 1), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.SlateBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SlateBrickStairs.get(), 1), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.SlateBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TitaniumBrickStairs.get(), 1), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.TitaniumBrick.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.TitaniumBrickStairs.get(), 1), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.TitaniumBrick.get()	//Crafting Line  
	});	

	// Wood
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.HardwoodPlanks.get(), 4), new Object[] {
	    SoulBlocks.HardwoodLog.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.SoulPlanks.get(), 4), new Object[] {
	    SoulBlocks.SoulLog.get()	//Crafting Line
	});
	GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {
	    "B", "B",  'B', SoulBlocks.SoulPlanks.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {
	    "B", "B",  'B', SoulBlocks.HardwoodPlanks.get()	//Crafting Line  
	});	

	// Wooden Stairs
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SoulStairs.get(), 4), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.SoulPlanks.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.SoulStairs.get(), 4), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.SoulPlanks.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.HardwoodStairs.get(), 4), new Object[] {
	    "B  ", "BB ", "BBB",  'B', SoulBlocks.HardwoodPlanks.get()	//Crafting Line  
	});	
	GameRegistry.addRecipe(new ItemStack(SoulBlocks.HardwoodStairs.get(), 4), new Object[] {
	    "  B", " BB", "BBB",  'B', SoulBlocks.HardwoodPlanks.get()	//Crafting Line  
	});	

	// Custom Torches
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.AmazoniteTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.AmazoniteGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.AmethystTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.AmethystGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.BronzeTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.BronzeIngot.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.ChromiteTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.ChromiteIngot.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.JetTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.JetGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.OlivineTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.OlivineGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.TopazTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.TopazGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.TurquoiseTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.TurquoiseGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.VioletTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.VioletGem.get()	//Crafting Line
	});
	GameRegistry.addShapelessRecipe(new ItemStack(SoulBlocks.WhiteOpalTorch.get(), 1), new Object[] {
	    Blocks.torch, SoulItems.WhiteopalGem.get()	//Crafting Line
	});
	//Custom Tools
	GameRegistry.addRecipe(new ItemStack(SoulItems.BerryCollector.get(), 1), new Object[] {
	    "X X", " Y ", " Y ",  'Y', Items.stick, 'X', SoulItems.SteelIngot.get(),	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.FrostWand.get(), 1), new Object[] {
	    "XKX", " Y ", " Y ",  'Y', SoulItems.FrozenStick.get(), 'X', SoulItems.FrozenRod.get(), 'K', SoulItems.UraniumGem.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.AquamarineWaraxe.get(), 1), new Object[] {
	    "XKX", "XYX", " Y ",  'Y', SoulItems.FrozenStick.get(), 'X', SoulItems.AquamarineGem.get(), 'K', SoulItems.FrostFragment.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TinThrowingknife.get(), 2), new Object[] {
	    " X ", "XXX", " Y ",  'Y', Items.stick, 'X', SoulItems.TinIngot.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CopperThrowingknife.get(), 2), new Object[] {
	    " X ", "XXX", " Y ",  'Y', Items.stick, 'X',  SoulItems.CopperIngot.get()	//Crafting Line  
	});

	//Create Special Torches
	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.torch, 1), new Object[] {
	    Items.stick, SoulItems.BlueGel.get()	//Crafting Line
	});

	//Tools
	// Aquamarine
	GameRegistry.addRecipe(new ItemStack(SoulItems.AquamarineAxe.get(), 1), new Object[] 
		{
	    "FX ","XY " ," Y " ,  'Y', SoulItems.FrozenRod.get(), 'X', SoulItems.AquamarineGem.get(), 'F', SoulItems.FrostShard.get() 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.AquamarineShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', SoulItems.FrozenRod.get(), 'X', SoulItems.AquamarineGem.get()
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.AquamarineSword.get(), 1), new Object[] 
		{
	    " F "," X " ," Y " ,  'Y', SoulItems.FrozenRod.get(), 'X', SoulItems.AquamarineGem.get(), 'F', SoulItems.FrostShard.get()  	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.AquamarinePickaxe.get(), 1), new Object[] 
		{
	    "XFX"," Y " ," Y " ,  'Y', SoulItems.FrozenRod.get(), 'X', SoulItems.AquamarineGem.get(), 'F', SoulItems.FrostShard.get()  	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.AquamarineHoe.get(), 1), new Object[] 
		{
	    "FX "," Y " ," Y " ,  'Y', SoulItems.FrozenRod.get(), 'X', SoulItems.AquamarineGem.get(), 'F', SoulItems.FrostShard.get() 	  
		});

	// Bronze
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick, 'X', SoulItems.BronzeIngot.get()				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.BronzeIngot.get()
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeSword.get(), 1), new Object[] 
		{
	    " X "," X " ," Y " ,  'Y', Items.stick, 'X', SoulItems.BronzeIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzePickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.BronzeIngot.get() 	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.BronzeIngot.get()	  
		});

	// Chromite
	GameRegistry.addRecipe(new ItemStack(SoulItems.ChromiteAxe.get(), 1), new Object[] 
		{
	    "GX ","XY " ," Y " ,  'Y', Items.stick, 'X', SoulItems.ChromiteIngot.get(), 'G', SoulItems.ScarletiteGem.get()				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.ChromiteShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.ChromiteIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.ChromiteSword.get(), 1), new Object[] 
		{
	    " G "," X " ," Y " ,  'Y', Items.stick, 'X', SoulItems.ChromiteIngot.get(), 'G', SoulItems.ScarletiteGem.get()	 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.ChromitePickaxe.get(), 1), new Object[] 
		{
	    "XGX"," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.ChromiteIngot.get(), 'G', SoulItems.ScarletiteGem.get() 	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.ChromiteHoe.get(), 1), new Object[] 
		{
	    "GX "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.ChromiteIngot.get(), 'G', SoulItems.ScarletiteGem.get()	 	  
		});

	// Copper
	GameRegistry.addRecipe(new ItemStack(SoulItems.CopperAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick, 'X', SoulItems.CopperIngot.get() 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CopperShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.CopperIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CopperPickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.CopperIngot.get() 	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CopperHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.CopperIngot.get() 	  
		});

	// Mithril
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick , 'X', SoulItems.MithrilIngot.get()				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick , 'X', SoulItems.MithrilIngot.get()	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilSword.get(), 1), new Object[] 
		{
	    " X "," X " ," Y " ,  'Y', Items.stick , 'X', SoulItems.MithrilIngot.get()	 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilPickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick , 'X', SoulItems.MithrilIngot.get()	 	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick , 'X', SoulItems.MithrilIngot.get()	 	  
		});
	// Silver
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick, 'X', SoulItems.SilverIngot.get() 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.SilverIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverSword.get(), 1), new Object[] 
		{
	    " X "," X " ," Y " ,  'Y', Items.stick, 'X', SoulItems.SilverIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverPickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.SilverIngot.get()	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.SilverIngot.get() 	  
		});

	// Steel
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick , 'X', SoulItems.SteelIngot.get() 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick , 'X', SoulItems.SteelIngot.get()
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelSword.get(), 1), new Object[] 
		{
	    " X "," X " ," Y " ,  'Y', Items.stick , 'X', SoulItems.SteelIngot.get()	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelPickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick , 'X', SoulItems.SteelIngot.get() 	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick , 'X', SoulItems.SteelIngot.get()	  
		});

	// Tanzanite
	GameRegistry.addRecipe(new ItemStack(SoulItems.TanzaniteAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TanzaniteIngot.get(), 'G', SoulItems.JadeGem.get()	 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TanzaniteShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TanzaniteIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TanzaniteSword.get(), 1), new Object[] 
		{
	    " G "," X " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TanzaniteIngot.get(), 'G', SoulItems.JadeGem.get()	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TanzanitePickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TanzaniteIngot.get(), 'G', SoulItems.JadeGem.get()	 	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TanzaniteHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TanzaniteIngot.get(), 'G', SoulItems.JadeGem.get()	 	  
		});

	// Tin
	GameRegistry.addRecipe(new ItemStack(SoulItems.TinAxe.get(), 1), new Object[] 
		{
	    "XX ","XY " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TinIngot.get() 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TinShovel.get(), 1), new Object[] 
		{
	    " X "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TinIngot.get() 	
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TinPickaxe.get(), 1), new Object[] 
		{
	    "XXX"," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TinIngot.get()	 
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.TinHoe.get(), 1), new Object[] 
		{
	    "XX "," Y " ," Y " ,  'Y', Items.stick, 'X', SoulItems.TinIngot.get()	  
		});

	// Cobalt
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltPickaxe.get(), 1), new Object[] 
		{
	    "XXX", " Y ", " Y ",  'X', SoulItems.CobaltIngot.get(), 'Y', Items.stick 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltSword.get(), 1), new Object[] 
		{
	    " X ", " X ", " Y ",  'X', SoulItems.CobaltIngot.get(), 'Y', Items.stick  											//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltShovel.get(), 1), new Object[] 
		{
	    " X ", " Y ", " Y ",  'X', SoulItems.CobaltIngot.get(), 'Y', Items.stick 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltAxe.get(), 1), new Object[] 
		{
	    " XX", " YX", " Y ",  'X', SoulItems.CobaltIngot.get(), 'Y', Items.stick 				//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltHoe.get(), 1), new Object[] 
		{
	    "XX ", " Y ", " Y ",  'X', SoulItems.CobaltIngot.get(), 'Y', Items.stick  				//Crafting Line  
		});

	// Armor
	// Bronze
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeHelmet.get(), 1), new Object[] 
		{
	    "XXX", "X X", "   ",  'X', SoulItems.BronzeIngot.get(),		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeChestplate.get(), 1), new Object[] 
		{
	    "X X", "XXX", "XXX",  'X', SoulItems.BronzeIngot.get(),		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeLeggings.get(), 1), new Object[] 
		{
	    "XXX", "X X", "X X", 'X', SoulItems.BronzeIngot.get(),		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.BronzeBoots.get(), 1), new Object[] 
		{
	    "   ", "X X", "X X",  'X', SoulItems.BronzeIngot.get(),		//Crafting Line  
		});
	// Cobalt
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltHelmet.get(), 1), new Object[] 
		{
	    "XXX", "G G", "   ",  'X', SoulItems.CobaltIngot.get(), 'G', SoulItems.TitaniumGem.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltChestplate.get(), 1), new Object[] 
		{
	    "G G", "XGX", "XXX",  'X', SoulItems.CobaltIngot.get(), 'G', SoulItems.TitaniumGem.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltLeggings.get(), 1), new Object[] 
		{
	    "XXX", "G G", "G G", 'X', SoulItems.CobaltIngot.get(),	'G', SoulItems.TitaniumGem.get()	//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.CobaltBoots.get(), 1), new Object[] 
		{
	    "   ", "G G", "X X",  'X', SoulItems.CobaltIngot.get(), 'G', SoulItems.TitaniumGem.get()		//Crafting Line  
		});
	// Mithril
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilHelmet.get(), 1), new Object[] 
		{
	    "XXX", "G G", "   ",  'X', SoulItems.MithrilIngot.get(), 'G', SoulItems.OnyxGem.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilChestplate.get(), 1), new Object[] 
		{
	    "G G", "XGX", "XXX",  'X', SoulItems.MithrilIngot.get(), 'G', SoulItems.OnyxGem.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilLeggings.get(), 1), new Object[] 
		{
	    "XXX", "G G", "G G", 'X', SoulItems.MithrilIngot.get(), 'G', SoulItems.OnyxGem.get()		//Crafting Line  
		});
	GameRegistry.addRecipe(new ItemStack(SoulItems.MithrilBoots.get(), 1), new Object[] 
		{
	    "   ", "G G", "X X",  'X', SoulItems.MithrilIngot.get(), 'G', SoulItems.OnyxGem.get()		//Crafting Line  
		});
	// Silver
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverHelmet.get(), 1), new Object[] {
	    "XXX", "X X", "   ",  'X', SoulItems.SilverIngot.get(),		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverChestplate.get(), 1), new Object[] {
	    "X X", "XXX", "XXX",  'X', SoulItems.SilverIngot.get(),		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverLeggings.get(), 1), new Object[] {
	    "XXX", "X X", "X X", 'X', SoulItems.SilverIngot.get(),		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SilverBoots.get(), 1), new Object[] {
	    "   ", "X X", "X X",  'X', SoulItems.SilverIngot.get(),		//Crafting Line  
	});

	// Slime
	GameRegistry.addRecipe(new ItemStack(SoulItems.SlimeHelmet.get(), 1), new Object[] {
	    "XYX", "X X", "   ",  'X', SoulItems.BlueMoltenGel.get(), 'Y' , SoulItems.FrozenMagicFragmentAdv.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SlimeChestplate.get(), 1), new Object[] {
	    "X X", "XYX", "XYX",  'X', SoulItems.BlueMoltenGel.get(), 'Y' , SoulItems.FrozenMagicFragmentAdv.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SlimeLeggings.get(), 1), new Object[] {
	    "XYX", "X X", "X X", 'X', SoulItems.BlueMoltenGel.get(), 'Y' , SoulItems.FrozenMagicFragmentAdv.get()	//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SlimeBoots.get(), 1), new Object[] {
	    "   ", "X X", "X X",  'X', SoulItems.BlueMoltenGel.get(), 'Y' , SoulItems.FrozenMagicFragmentAdv.get()	//Crafting Line  
	});

	// Steel
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelHelmet.get(), 1), new Object[] {
	    "XXX", "G G", "   ",  'X', SoulItems.SteelIngot.get(), 'G', SoulItems.TitaniumGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelChestplate.get(), 1), new Object[] {
	    "G G", "XGX", "XXX",  'X', SoulItems.SteelIngot.get(), 'G', SoulItems.TitaniumGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelLeggings.get(), 1), new Object[] {
	    "XXX", "G G", "G G", 'X', SoulItems.SteelIngot.get(), 'G', SoulItems.TitaniumGem.get()		//Crafting Line  
	});
	GameRegistry.addRecipe(new ItemStack(SoulItems.SteelBoots.get(), 1), new Object[] {
	    "   ", "G G", "X X",  'X', SoulItems.SteelIngot.get(), 'G', SoulItems.TitaniumGem.get()	//Crafting Line  
	});		
	System.out.println("[Soul Forest] Recipes Initiated");
    }

    public static void addSmeltingRecipes(){
	// Smelting Recipes	
	GameRegistry.addSmelting(SoulBlocks.Cobaltore.get(), new ItemStack(SoulItems.CobaltIngot.get()), 1.0F);
	GameRegistry.addSmelting(SoulBlocks.Chromiteore.get(), new ItemStack(SoulItems.ChromiteIngot.get()), 0.5F);
	GameRegistry.addSmelting(SoulBlocks.Copperore.get(), new ItemStack(SoulItems.CopperIngot.get()), 0.3F);
	GameRegistry.addSmelting(SoulBlocks.Mithrilore.get(), new ItemStack(SoulItems.MithrilIngot.get()), 1.5F);
	GameRegistry.addSmelting(SoulBlocks.Silverore.get(), new ItemStack(SoulItems.SilverIngot.get()), 0.8F);
	GameRegistry.addSmelting(SoulBlocks.Steelore.get(), new ItemStack(SoulItems.SteelIngot.get()), 1.0F);
	GameRegistry.addSmelting(SoulBlocks.Tanzaniteore.get(), new ItemStack(SoulItems.TanzaniteIngot.get()), 0.5F);
	GameRegistry.addSmelting(SoulBlocks.Tinore.get(), new ItemStack(SoulItems.TinIngot.get()), 0.3F);	
	System.out.println("[Soul Forest] Smelting Recipes Initiated");
    }
}
