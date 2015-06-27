package com.Mod_Ores.Blocks.Recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;

import cpw.mods.fml.common.registry.GameRegistry;

public class IceWorkbenchCraftingRecipes{
    /** The static instance of this class */
    private static final IceWorkbenchCraftingRecipes instance = new IceWorkbenchCraftingRecipes();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private List enchList = new ArrayList();
    
    private ItemStack test;
    /**
     * Returns the static instance of this class
     */
    public static final IceWorkbenchCraftingRecipes getInstance(){
        return instance;
    }

    /** All of the Ice Workbench's crafting recipes
     * 
     */
    private IceWorkbenchCraftingRecipes(){
    	// Half magic fragment recipes
    	this.addRecipe(new ItemStack(SoulItems.FireMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.TopazBlock.get(), '%', SoulBlocks.ScarletiteBlock.get(), 'B', SoulItems.BurnedShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulBlocks.ChromiteBlock.get()});       
    	this.addRecipe(new ItemStack(SoulItems.StrongMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmethystBlock.get(), '%', SoulBlocks.AmethystBlock.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulBlocks.SilverBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.HardenedMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.BronzeBlock.get(), '%', SoulBlocks.BronzeBlock.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulBlocks.TopazBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.ShinyMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.ChromiteBlock.get(), '%', SoulBlocks.ChromiteBlock.get(), 'B', SoulItems.LightShard.get(), 'S', SoulItems.LightShard.get(), 'C', SoulBlocks.CitrineBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.FlightMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.WhiteopalBlock.get(), '%', SoulBlocks.WhiteopalBlock.get(), 'B', SoulItems.MochanEagleFeather.get(), 'S', SoulItems.MochanEagleFeather.get(), 'C', SoulBlocks.JetBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.SharpMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.TanzaniteBlock.get(), '%', SoulBlocks.TanzaniteBlock.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulBlocks.JadeBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.StrengthMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.SlateBrick.get(), '%', SoulBlocks.SlateBrick.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulBlocks.BronzeBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.FrozenMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AquamarineBlock.get(), '%', SoulBlocks.AquamarineBlock.get(), 'B', SoulItems.FrostShard.get(), 'S', SoulItems.FrostShard.get(), 'C', SoulBlocks.TurquoiseBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.SoulMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.LilaBlock.get(), '%', SoulBlocks.LilaBlock.get(), 'B', SoulItems.Soul.get(), 'S', SoulItems.Soul.get(), 'C', SoulBlocks.VioletBlock.get()});  
    	this.addRecipe(new ItemStack(SoulItems.EnlightedMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.CitrineBlock.get(), '%', SoulBlocks.CitrineBlock.get(), 'B', SoulItems.LightShard.get(), 'S', SoulItems.LightShard.get(), 'C', Block.getBlockFromName("gold_block")});  
    	this.addRecipe(new ItemStack(SoulItems.PowerMagicFragmentHalf.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmethystBlock.get(), '%', SoulBlocks.AmethystBlock.get(), 'B', SoulItems.Soul.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulBlocks.OlivineBlock.get()});  
    	
    	// Magic fragment recipes
    	this.addRecipe(new ItemStack(SoulItems.FireMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.TopazBlock.get(), '%', SoulBlocks.ScarletiteBlock.get(), 'B', SoulItems.BurnedShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulItems.TitaniumGem.get()});       
    	this.addRecipe(new ItemStack(SoulItems.StrongMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmethystBlock.get(), '%', SoulBlocks.AmethystBlock.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulItems.TitaniumGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.HardenedMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.BronzeBlock.get(), '%', SoulBlocks.BronzeBlock.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.ShinyMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.ChromiteBlock.get(), '%', SoulBlocks.ChromiteBlock.get(), 'B', SoulItems.LightShard.get(), 'S', SoulItems.LightShard.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.FlightMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.WhiteopalBlock.get(), '%', SoulBlocks.WhiteopalBlock.get(), 'B', SoulItems.MochanEagleFeather.get(), 'S', SoulItems.MochanEagleFeather.get(), 'C', SoulItems.OnyxGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.SharpMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.TanzaniteBlock.get(), '%', SoulBlocks.TanzaniteBlock.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulItems.TitaniumGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.BurnedMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.ScarletiteBlock.get(), '%', SoulBlocks.ScarletiteBlock.get(), 'B', SoulItems.BurnedShard.get(), 'S', SoulItems.BurnedShard.get(), 'C', SoulItems.OnyxGem.get()});
    	this.addRecipe(new ItemStack(SoulItems.StrengthMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.SlateBrick.get(), '%', SoulBlocks.SlateBrick.get(), 'B', SoulItems.StrengthShard.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulItems.OnyxGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.FrozenMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AquamarineBlock.get(), '%', SoulBlocks.AquamarineBlock.get(), 'B', SoulItems.FrostShard.get(), 'S', SoulItems.FrostShard.get(), 'C', SoulItems.OnyxGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.SoulMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.LilaBlock.get(), '%', SoulBlocks.LilaBlock.get(), 'B', SoulItems.Soul.get(), 'S', SoulItems.Soul.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.EnlightedMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.CitrineBlock.get(), '%', SoulBlocks.CitrineBlock.get(), 'B', SoulItems.LightShard.get(), 'S', SoulItems.LightShard.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.HotMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmazoniteBlock.get(), '%', SoulBlocks.AmazoniteBlock.get(), 'B', SoulItems.BurnedShard.get(), 'S', SoulItems.BurnedShard.get(), 'C', SoulItems.TitaniumGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.PowerMagicFragment.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmethystBlock.get(), '%', SoulBlocks.AmethystBlock.get(), 'B', SoulItems.Soul.get(), 'S', SoulItems.StrengthShard.get(), 'C', SoulItems.BlackdiamondGem.get()});     	
    	
    	// Advanced magic fragment recipes
    	this.addRecipe(new ItemStack(SoulItems.FireMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.TopazBlock.get(), '%', SoulBlocks.ScarletiteBlock.get(), 'B', SoulItems.BurnedFragment.get(), 'S', SoulItems.StrengthFragment.get(), 'C', SoulItems.TitaniumGem.get()});       
    	this.addRecipe(new ItemStack(SoulItems.StrongMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmethystBlock.get(), '%', SoulBlocks.AmethystBlock.get(), 'B', SoulItems.StrengthFragment.get(), 'S', SoulItems.StrengthFragment.get(), 'C', SoulItems.TitaniumGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.HardenedMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.BronzeBlock.get(), '%', SoulBlocks.BronzeBlock.get(), 'B', SoulItems.StrengthFragment.get(), 'S', SoulItems.StrengthFragment.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.ShinyMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.ChromiteBlock.get(), '%', SoulBlocks.ChromiteBlock.get(), 'B', SoulItems.LightFragment.get(), 'S', SoulItems.LightFragment.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.FlightMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.WhiteopalBlock.get(), '%', SoulBlocks.WhiteopalBlock.get(), 'B', SoulItems.MochanEagleWing.get(), 'S', SoulItems.MochanEagleWing.get(), 'C', SoulItems.OnyxGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.SharpMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.TanzaniteBlock.get(), '%', SoulBlocks.TanzaniteBlock.get(), 'B', SoulItems.StrengthFragment.get(), 'S', SoulItems.StrengthFragment.get(), 'C', SoulItems.TitaniumGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.BurnedMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.ScarletiteBlock.get(), '%', SoulBlocks.ScarletiteBlock.get(), 'B', SoulItems.BurnedFragment.get(), 'S', SoulItems.BurnedFragment.get(), 'C', SoulItems.OnyxGem.get()});
    	this.addRecipe(new ItemStack(SoulItems.StrengthMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.SlateBrick.get(), '%', SoulBlocks.SlateBrick.get(), 'B', SoulItems.StrengthFragment.get(), 'S', SoulItems.StrengthFragment.get(), 'C', SoulItems.OnyxGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.FrozenMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AquamarineBlock.get(), '%', SoulBlocks.AquamarineBlock.get(), 'B', SoulItems.FrostFragment.get(), 'S', SoulItems.FrostFragment.get(), 'C', SoulItems.OnyxGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.SoulMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.LilaBlock.get(), '%', SoulBlocks.LilaBlock.get(), 'B', SoulItems.SoulFragment.get(), 'S', SoulItems.SoulFragment.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.EnlightedMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.SilverBlock.get(), '%', SoulBlocks.SilverBlock.get(), 'B', SoulItems.LightFragment.get(), 'S', SoulItems.LightFragment.get(), 'C', SoulItems.BlackdiamondGem.get()});  
    	this.addRecipe(new ItemStack(SoulItems.PowerMagicFragmentAdv.get(), 2), new Object[] {"#BB#", "SCCS", "SCCS", "%BB%", '#', SoulBlocks.AmethystBlock.get(), '%', SoulBlocks.AmethystBlock.get(), 'B', SoulItems.SoulFragment.get(), 'S', SoulItems.StrengthFragment.get(), 'C', SoulItems.BlackdiamondGem.get()});     	 	
    	
    	// Other
    	this.addRecipe(new ItemStack(SoulItems.MagicEmblem.get(), 1), new Object[] {"GSSH", "SOOS", "SOOS", "ISSJ", 'S', Block.getBlockFromName("obsidian"), 'O', SoulItems.SoulFragmentEnhanced.get(), 'G', SoulItems.FrostFragment.get() , 'H', SoulItems.LightFragment.get() , 'I', SoulItems.StrengthFragment.get() , 'J', SoulItems.BurnedFragment.get()});     	 	
    	this.addRecipe(new ItemStack(SoulItems.BlueMoltenGel.get(), 1), new Object[] {"GGGG", "GGGG", "GGGG", "GFFG", 'G', SoulItems.BlueGel.get(), 'F', Item.getItemById(259)});     	 	
    	this.addRecipe(new ItemStack(SoulItems.GelPot.get(), 1, 9), new Object[] {"GGGG", "GGGG", "GGGG", "WWWW", 'G', Block.getBlockFromName("glass"), 'W', Block.getBlockFromName("planks")}); 
    	this.addRecipe(new ItemStack(SoulItems.GelPot.get(), 1, 9), new Object[] {"GGGG", "GGGG", "GGGG", "WWWW", 'G', Block.getBlockFromName("glass"), 'W', SoulBlocks.HardwoodPlanks.get()});
    	this.addRecipe(new ItemStack(SoulItems.GelPot.get(), 1, 9), new Object[] {"GGGG", "GGGG", "GGGG", "WWWW", 'G', Block.getBlockFromName("glass"), 'W', SoulBlocks.SoulPlanks.get()});
    	
    	this.addRecipe(new ItemStack(SoulItems.GelPotKing.get(), 1), new Object[] {"GGG", "GPG", "MMM", 'G', Block.getBlockFromName("glass"), 'M', SoulItems.BlueMoltenGel.get(), 'P', SoulItems.GelPotFilled.get()});
    	this.addRecipe(new ItemStack(SoulBlocks.GelExtractor.get(), 1), new Object[] {"SSSS", "GGGG", "GGGG", "SSSS", 'G', SoulItems.BlueMoltenGel.get(), 'S', Block.getBlockFromName("stone")});
    	this.addRecipe(new ItemStack(SoulItems.IceCrystal.get(), 1), new Object[] {"SFRS", "RAHF", "FHMR", "SRFS", 'S', SoulItems.FrostShard.get(), 'F', SoulItems.FrostFragment.get(), 'R', SoulItems.FrozenRod.get(), 'A', SoulItems.FrozenMagicFragmentAdv.get(), 'H', SoulItems.FrozenMagicFragmentHalf.get(), 'M', SoulItems.FrozenMagicFragment.get()});
    	
    	// Amulets
    	this.addRecipe(new ItemStack(SoulItems.AmazoniteAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.AmazoniteGem.get(), 'D', Item.getItemById(264)});
    	this.addRecipe(new ItemStack(SoulItems.AmethystAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.AmethystGem.get(), 'D', Item.getItemById(376)});
    	this.addRecipe(new ItemStack(SoulItems.AquamarineAmuletStone.get(), 1), new Object[] {"AAAA", "ACCA", "ACDA", "AAAA", 'A', SoulItems.AquamarineGem.get(), 'C', Item.getItemById(381),'D', SoulItems.BucketSoulWater.get()});
    	this.addRecipe(new ItemStack(SoulItems.BlackdiamondAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.BlackdiamondGem.get(), 'D', SoulItems.StrengthFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.CitrineAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.CitrineGem.get(), 'D', SoulItems.LightFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.JadeAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.JadeGem.get(), 'D', SoulItems.BlueMoltenGel.get()});
    	this.addRecipe(new ItemStack(SoulItems.JetAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.JetGem.get(), 'D', SoulBlocks.TinBlock.get()});
    	this.addRecipe(new ItemStack(SoulItems.LilaAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.LilaGem.get(), 'D', Item.getItemById(264)});
    	this.addRecipe(new ItemStack(SoulItems.OlivineAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.OlivineGem.get(), 'D', SoulItems.StrengthFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.OnyxAmuletStone.get(), 1), new Object[] {"BAAB", "ADDA", "ADDA", "BAAB", 'A', SoulItems.OnyxGem.get(), 'B', SoulItems.OpalGem.get() ,'D', SoulItems.LightFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.OnyxAmuletStone.get(), 1), new Object[] {"BAAB", "ADDA", "ADDA", "BAAB", 'A', SoulItems.OnyxGem.get(), 'B', SoulItems.WhiteopalGem.get() ,'D', SoulItems.LightFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.ScarletiteAmuletStone.get(), 1), new Object[] {"AAAA", "ADCA", "ACDA", "AAAA", 'A', SoulItems.ScarletiteGem.get(), 'D', Block.getBlockById(49),'C', Item.getItemById(264)});
    	this.addRecipe(new ItemStack(SoulItems.TopazAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.TopazGem.get(), 'D', SoulItems.LightFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.TurquoiseAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.TurquoiseGem.get(), 'D', SoulItems.LightFragment.get()});
    	this.addRecipe(new ItemStack(SoulItems.VioletAmuletStone.get(), 1), new Object[] {"AAAA", "ADDA", "ADDA", "AAAA", 'A', SoulItems.VioletGem.get(), 'D', Item.getItemById(264)});
    	
    	this.addRecipe(new ItemStack(SoulItems.BlackdiamondAmuletRing.get(), 1), new Object[] {" AA ", "ADDA", "ADDA", " AA ", 'A', Item.getItemById(266), 'D', SoulItems.BlackdiamondAmuletStone.get()});
    	this.addRecipe(new ItemStack(SoulItems.OlivineAmuletRing.get(), 1), new Object[] {" AA ", "ADDA", "ADDA", " AA ", 'A', Item.getItemById(266), 'D', SoulItems.OlivineAmuletStone.get()});
    	this.addRecipe(new ItemStack(SoulItems.TurquoiseAmuletRing.get(), 1), new Object[] {" AA ", "ADDA", "ADDA", " AA ", 'A', Item.getItemById(266), 'D', SoulItems.TurquoiseAmuletStone.get()});
    	
    	//Torches
    	this.addShapelessRecipe(new ItemStack(Blocks.torch, 1), new Object[] {Items.stick, SoulItems.BlueGel.get()});   
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.AmazoniteTorch.get(), 1), new Object[] {SoulItems.AmazoniteGem.get(), Block.getBlockFromName("torch")});   
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.AmethystTorch.get(), 1), new Object[] {SoulItems.AmethystGem.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.BronzeTorch.get(), 1), new Object[] {SoulItems.BronzeIngot.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.ChromiteTorch.get(), 1), new Object[] {SoulItems.ChromiteIngot.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.JetTorch.get(), 1), new Object[] {SoulItems.JetGem.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.OlivineTorch.get(), 1), new Object[] {SoulItems.OlivineGem.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.TopazTorch.get(), 1), new Object[] {SoulItems.TopazGem.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.TurquoiseTorch.get(), 1), new Object[] {SoulItems.TurquoiseGem.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.VioletTorch.get(), 1), new Object[] {SoulItems.VioletGem.get(), Block.getBlockFromName("torch")});
    	this.addShapelessRecipe(new ItemStack(SoulBlocks.WhiteOpalTorch.get(), 1), new Object[] {SoulItems.WhiteopalGem.get(), Block.getBlockFromName("torch")});
    	
    	
    	// Enchanted Book Recipes
    	this.addEnchantedBookRecipe(Enchantment.fireProtection, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FireMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.protection, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.StrongMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.blastProtection, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.HardenedMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.projectileProtection, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.ShinyMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.featherFalling, 1, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FlightMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.sharpness, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.SharpMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.smite, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.StrengthMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(soul_forest.enchantmentFrost, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FrozenMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(soul_forest.enchantmentEnhanced, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.SoulMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.efficiency, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.EnlightedMagicFragmentHalf.get()});   
    	this.addEnchantedBookRecipe(Enchantment.power, 1, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.PowerMagicFragmentHalf.get()});   
    	
    	this.addEnchantedBookRecipe(Enchantment.fireProtection, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FireMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.protection, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.StrongMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.blastProtection, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.HardenedMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.projectileProtection, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.ShinyMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.featherFalling, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FlightMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.fireAspect, 1, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.BurnedMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.sharpness, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.SharpMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.smite, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.StrengthMagicFragment.get()});   
    	this.addEnchantedBookRecipe(soul_forest.enchantmentFrost, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FrozenMagicFragment.get()});   
    	this.addEnchantedBookRecipe(soul_forest.enchantmentEnhanced, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.SoulMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.efficiency, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.EnlightedMagicFragment.get()});   
    	this.addEnchantedBookRecipe(Enchantment.flame, 1, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.HotMagicFragment.get()}); 
    	this.addEnchantedBookRecipe(Enchantment.power, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.PowerMagicFragment.get()});   
    	
    	this.addEnchantedBookRecipe(Enchantment.fireProtection, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FireMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.protection, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.StrongMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.blastProtection, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.HardenedMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.projectileProtection, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.ShinyMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.featherFalling, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FlightMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.fireAspect, 2, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.BurnedMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.sharpness, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.SharpMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.smite, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.StrengthMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(soul_forest.enchantmentFrost, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.FrozenMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(soul_forest.enchantmentEnhanced, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.SoulMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.efficiency, 4, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.EnlightedMagicFragmentAdv.get()});   
    	this.addEnchantedBookRecipe(Enchantment.power, 3, 1);
    	this.addRecipe(this.test, new Object[] {"#BB#", "BSSB", "BSSB", "#BB#", '#', SoulItems.MagicEmblem.get(), 'B', Item.getItemById(340), 'S', SoulItems.PowerMagicFragmentAdv.get()});   
    	
    	Collections.sort(this.recipes, new IceRecipeSorter(this));
    }
    
    public void addEnchantedBookRecipe(Enchantment par1Enchantment, int par2level, int par3AmmountOfBooksCrafted){
    	this.test = new ItemStack((Item)Item.getItemById(403), par3AmmountOfBooksCrafted);
    	this.test.addEnchantment(par1Enchantment, par2level);
    }

    public IceWorkbenchShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj){
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[]){
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else{
            while (par2ArrayOfObj[i] instanceof String){
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2){
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item){
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block){
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack){
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1){
            char c0 = s.charAt(i1);
            if (hashmap.containsKey(Character.valueOf(c0))){
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();      
            }
            else{
                aitemstack[i1] = null;
            }
        }

        IceWorkbenchShapedRecipes shapedrecipes = new IceWorkbenchShapedRecipes(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj){
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j){
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack){
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item){
                arraylist.add(new ItemStack((Item)object1));
            }
            else{
                if (!(object1 instanceof Block)){
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new IceWorkbenchShapelessRecipes(par1ItemStack, arraylist));
    }
    
    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World){
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;
        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j){
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
            
            if (itemstack2 != null){
                if (i == 0){
                    itemstack = itemstack2;
                }

                if (i == 1){
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack == itemstack1 && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()){
            Item item = itemstack.getItem();
            int k = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int l = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int i1 = k + l + item.getMaxDamage() * 5 / 100;
            int j1 = item.getMaxDamage() - i1;
            if (j1 < 0)
            {
                j1 = 0;
            }

            return new ItemStack(item, 1, j1);
        }
        else{
            for (j = 0; j < this.recipes.size(); ++j){
            	IRecipe irecipe = (IRecipe)this.recipes.get(j);
            	
                if (irecipe.matches(par1InventoryCrafting, par2World)){                 
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList(){
        return this.recipes;
    }
}
