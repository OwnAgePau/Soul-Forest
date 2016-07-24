package com.Mod_Ores.Init;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Items.*;
import com.Mod_Ores.Items.Armor.*;
import com.Mod_Ores.Items.Tools.*;
import com.google.common.base.Optional;

public class InitItems {	
    public static ArrayList<ItemSoulPickaxe> soulPickaxes = new ArrayList();
    public static ArrayList<ItemSoulAxe> soulAxes = new ArrayList();
    public static ArrayList<ItemSoulHoe> soulHoes = new ArrayList();
    public static ArrayList<ItemSoulSword> soulSwords = new ArrayList();
    public static ArrayList<ItemSoulShovel> soulShovels = new ArrayList();
    public static ArrayList<ItemWarAxe> soulWarAxes = new ArrayList();
    
    public static ArrayList<ItemArmor> soulArmors = new ArrayList();

    public static void init(){
		InitMaterials.init();	
		initializeItems();
    }

    private static void initializeItems(){
		// Axes
		SoulItems.AquamarineAxe = 		Optional.of(new ItemSoulAxe("Aquamarine_axe", InitMaterials.toolAquamarine, 3));
		SoulItems.BronzeAxe = 			Optional.of(new ItemSoulAxe("Bronze_axe", InitMaterials.toolBronze, 2));
		SoulItems.ChromiteAxe = 		Optional.of(new ItemSoulAxe("Chromite_axe", InitMaterials.toolChromite, 3));
		SoulItems.CobaltAxe = 			Optional.of(new ItemSoulAxe("Cobalt_axe", InitMaterials.toolCobalt, 4));
		SoulItems.CopperAxe = 			Optional.of(new ItemSoulAxe("Copper_axe", InitMaterials.toolCopper, 1));
		SoulItems.FyrisedAxe = 			Optional.of(new ItemSoulAxe("Fyrised_axe", InitMaterials.toolFyrised, 5));
		SoulItems.SilverAxe = 			Optional.of(new ItemSoulAxe("Silver_axe", InitMaterials.toolSilver, 3));
		SoulItems.SteelAxe = 			Optional.of(new ItemSoulAxe("Steel_axe", InitMaterials.toolSteel, 4));
		SoulItems.TanzaniteAxe = 		Optional.of(new ItemSoulAxe("Tanzanite_axe", InitMaterials.toolTanzanite, 2));
		SoulItems.TinAxe = 				Optional.of(new ItemSoulAxe("Tin_axe", InitMaterials.toolTin, 1));						
		// Hoes
		SoulItems.AquamarineHoe = 		Optional.of(new ItemSoulHoe("Aquamarine_hoe", InitMaterials.toolAquamarine, 3));
		SoulItems.BronzeHoe = 			Optional.of(new ItemSoulHoe("Bronze_hoe", InitMaterials.toolBronze, 2));
		SoulItems.ChromiteHoe = 		Optional.of(new ItemSoulHoe("Chromite_hoe", InitMaterials.toolChromite, 3));
		SoulItems.CobaltHoe = 			Optional.of(new ItemSoulHoe("Cobalt_hoe", InitMaterials.toolCobalt, 4));
		SoulItems.CopperHoe =			Optional.of(new ItemSoulHoe("Copper_hoe", InitMaterials.toolCopper, 1));
		SoulItems.FyrisedHoe = 			Optional.of(new ItemSoulHoe("Fyrised_hoe", InitMaterials.toolFyrised, 5));
		SoulItems.SilverHoe = 			Optional.of(new ItemSoulHoe("Silver_hoe", InitMaterials.toolSilver, 3));
		SoulItems.SteelHoe = 			Optional.of(new ItemSoulHoe("Steel_hoe", InitMaterials.toolSteel, 4));
		SoulItems.TanzaniteHoe = 		Optional.of(new ItemSoulHoe("Tanzanite_hoe", InitMaterials.toolTanzanite, 2));
		SoulItems.TinHoe = 				Optional.of(new ItemSoulHoe("Tin_hoe", InitMaterials.toolTin, 1));								
		// Pickaxes		
		SoulItems.AquamarinePickaxe = 	Optional.of(new ItemSoulPickaxe("Aquamarine_pickaxe", InitMaterials.toolAquamarine, 3));
		SoulItems.BronzePickaxe = 		Optional.of(new ItemSoulPickaxe("Bronze_pickaxe", InitMaterials.toolBronze, 2));
		SoulItems.ChromitePickaxe = 	Optional.of(new ItemSoulPickaxe("Chromite_pickaxe", InitMaterials.toolChromite, 3));
		SoulItems.CobaltPickaxe = 		Optional.of(new ItemSoulPickaxe("Cobalt_pickaxe", InitMaterials.toolCobalt, 4));
		SoulItems.CopperPickaxe = 		Optional.of(new ItemSoulPickaxe("Copper_pickaxe", InitMaterials.toolCopper, 1));
		SoulItems.FyrisedPickaxe = 		Optional.of(new ItemSoulPickaxe("Fyrised_pickaxe", InitMaterials.toolFyrised, 5));
		SoulItems.SilverPickaxe = 		Optional.of(new ItemSoulPickaxe("Silver_pickaxe", InitMaterials.toolSilver, 3));
		SoulItems.SteelPickaxe = 		Optional.of(new ItemSoulPickaxe("Steel_pickaxe", InitMaterials.toolSteel, 4));
		SoulItems.TanzanitePickaxe = 	Optional.of(new ItemSoulPickaxe("Tanzanite_pickaxe", InitMaterials.toolTanzanite, 2));
		SoulItems.TinPickaxe = 			Optional.of(new ItemSoulPickaxe("Tin_pickaxe", InitMaterials.toolTin, 1));			
		// Shovels		
		SoulItems.AquamarineShovel = 	Optional.of(new ItemSoulShovel("Aquamarine_shovel", InitMaterials.toolAquamarine, 3));
		SoulItems.BronzeShovel = 		Optional.of(new ItemSoulShovel("Bronze_shovel", InitMaterials.toolBronze, 2));
		SoulItems.ChromiteShovel = 		Optional.of(new ItemSoulShovel("Chromite_shovel", InitMaterials.toolChromite, 3));
		SoulItems.CobaltShovel = 		Optional.of(new ItemSoulShovel("Cobalt_shovel", InitMaterials.toolCobalt, 4));
		SoulItems.CopperShovel = 		Optional.of(new ItemSoulShovel("Copper_shovel", InitMaterials.toolCopper, 1));
		SoulItems.FyrisedShovel = 		Optional.of(new ItemSoulShovel("Fyrised_shovel", InitMaterials.toolFyrised, 5));
		SoulItems.SilverShovel = 		Optional.of(new ItemSoulShovel("Silver_shovel", InitMaterials.toolSilver, 3));
		SoulItems.SteelShovel = 		Optional.of(new ItemSoulShovel("Steel_shovel", InitMaterials.toolSteel, 4));
		SoulItems.TanzaniteShovel = 	Optional.of(new ItemSoulShovel("Tanzanite_shovel", InitMaterials.toolTanzanite, 2));
		SoulItems.TinShovel =			Optional.of(new ItemSoulShovel("Tin_shovel", InitMaterials.toolTin, 1));
		// Swords		
		SoulItems.AquamarineSword = 	Optional.of(new ItemSoulSword("Aquamarine_sword", InitMaterials.toolAquamarine, 3));
		SoulItems.BronzeSword = 		Optional.of(new ItemSoulSword("Bronze_sword", InitMaterials.toolBronze, 2));
		SoulItems.ChromiteSword = 		Optional.of(new ItemSoulSword("Chromite_sword", InitMaterials.toolChromite, 3));
		SoulItems.CobaltSword = 		Optional.of(new ItemSoulSword("Cobalt_sword", InitMaterials.toolCobalt, 4, "R"));
		SoulItems.FyrisedSword = 		Optional.of(new ItemSoulSword("Fyrised_sword", InitMaterials.toolFyrised, 5, "E"));
		SoulItems.SilverSword = 		Optional.of(new ItemSoulSword("Silver_sword", InitMaterials.toolSilver, 3, "U"));
		SoulItems.SteelSword = 			Optional.of(new ItemSoulSword("Steel_sword", InitMaterials.toolSteel, 4, "R"));
		SoulItems.TanzaniteSword = 		Optional.of(new ItemSoulSword("Tanzanite_sword", InitMaterials.toolTanzanite, 2, "R"));
	
		// War Axes
		SoulItems.AquamarineWaraxe = 	Optional.of(new ItemWarAxe("Aquamarine_waraxe", InitMaterials.toolWaraxe, "R", 4));
	
		// Throwing Knifes
		SoulItems.TinThrowingknife = 	Optional.of(new ItemThrowingKnife("Tin_throwing_knife"));
		SoulItems.CopperThrowingknife = Optional.of(new ItemThrowingKnife("Copper_throwing_knife"));
	
		//Gems - cuts and uncuts
		SoulItems.AmazoniteGem = 		Optional.of(new ItemGem("Amazonite_gem", EnumRarity.UNCOMMON));
		SoulItems.AmazoniteUncut = 		Optional.of(new ItemGem("Amazonite_uncut"));
		SoulItems.AmethystGem = 		Optional.of(new ItemGem("Amethyst_gem"));
		SoulItems.AmethystUncut = 		Optional.of(new ItemGem("Amethyst_uncut"));
		SoulItems.AquamarineGem = 		Optional.of(new ItemGem("Aquamarine_gem", EnumRarity.UNCOMMON));
		SoulItems.AquamarineUncut = 	Optional.of(new ItemGem("Aquamarine_uncut"));
		SoulItems.BlackdiamondGem = 	Optional.of(new ItemGem("Blackdiamond_gem", EnumRarity.EPIC));
		SoulItems.BlackdiamondUncut = 	Optional.of(new ItemGem("Blackdiamond_uncut"));
		SoulItems.CitrineGem = 			Optional.of(new ItemGem("Citrine_gem"));
		SoulItems.CitrineUncut = 		Optional.of(new ItemGem("Citrine_uncut"));
		SoulItems.JadeGem = 			Optional.of(new ItemGem("Jade_gem"));
		SoulItems.JadeUncut = 			Optional.of(new ItemGem("Jade_uncut"));
		SoulItems.JetGem =				Optional.of(new ItemGem("Jet_gem"));
		SoulItems.JetUncut = 			Optional.of(new ItemGem("Jet_uncut"));
		SoulItems.LilaGem = 			Optional.of(new ItemGem("Lila_gem"));
		SoulItems.LilaUncut = 			Optional.of(new ItemGem("Lila_uncut"));
		SoulItems.OlivineGem = 			Optional.of(new ItemGem("Olivine_gem"));
		SoulItems.OlivineUncut = 		Optional.of(new ItemGem("Olivine_uncut"));
		SoulItems.OnyxGem = 			Optional.of(new ItemGem("Onyx_gem", EnumRarity.EPIC));
		SoulItems.OnyxUncut = 			Optional.of(new ItemGem("Onyx_uncut"));
		SoulItems.OpalGem = 			Optional.of(new ItemGem("Opal_gem"));
		SoulItems.OpalUncut = 			Optional.of(new ItemGem("Opal_uncut"));
		SoulItems.ScarletiteGem = 		Optional.of(new ItemGem("Scarletemerald_gem", EnumRarity.UNCOMMON));
		SoulItems.ScarletiteUncut = 	Optional.of(new ItemGem("Scarletemerald_uncut"));
		SoulItems.TitaniumGem = 		Optional.of(new ItemGem("Titanium_gem", EnumRarity.EPIC));
		SoulItems.TitaniumUncut = 		Optional.of(new ItemGem("Titanium_uncut"));
		SoulItems.TopazGem = 			Optional.of(new ItemGem("Topaz_gem"));
		SoulItems.TopazUncut = 			Optional.of(new ItemGem("Topaz_uncut"));
		SoulItems.TurquoiseGem = 		Optional.of(new ItemGem("Turquoise_gem"));
		SoulItems.TurquoiseUncut = 		Optional.of(new ItemGem("Turquoise_uncut"));
		SoulItems.UraniumGem = 			Optional.of(new ItemGem("Uranium_gem", EnumRarity.EPIC));
		SoulItems.VioletGem = 			Optional.of(new ItemGem("Violet_gem"));
		SoulItems.VioletUncut = 		Optional.of(new ItemGem("Violet_uncut"));
		SoulItems.WhiteopalGem = 		Optional.of(new ItemGem("Whiteopal_gem"));
		SoulItems.WhiteopalUncut = 		Optional.of(new ItemGem("Whiteopal_uncut"));
		
		// Amulet Stones
		SoulItems.AmazoniteAmuletStone = 	Optional.of(new ItemAmuletStone("Amazonite_amulet_stone", 15, EnumRarity.RARE, "Can heal the player for 2 hearts.", "Right click").setAmuletStoneType("Amazonite"));
		SoulItems.AmethystAmuletStone = 	Optional.of(new ItemAmuletStone("Amethyst_amulet_stone", 30, EnumRarity.UNCOMMON, "Can cure the player from poison.", "Right click").setAmuletStoneType("Amethyst"));
		SoulItems.AquamarineAmuletStone = 	Optional.of(new ItemAmuletStone("Aquamarine_amulet_stone", 15, EnumRarity.RARE, "Is pretty.", "None").setAmuletStoneType("Aquamarine"));
		SoulItems.BlackdiamondAmuletStone = Optional.of(new ItemAmuletStone("Blackdiamond_amulet_stone", Potion.damageBoost.getId(), 400, 5, EnumRarity.EPIC, "Can increase the player's damage.", "Right click").setAmuletStoneType("Black Diamond"));
		SoulItems.CitrineAmuletStone = 		Optional.of(new ItemAmuletStone("Citrine_amulet_stone", 50, "Can be used to increase the value of certain items.", "Gemble Table", false).setAmuletStoneType("Citrine"));
		SoulItems.JadeAmuletStone = 		Optional.of(new ItemAmuletStone("Jade_amulet_stone", Potion.jump.getId(), 800, 50, "Can increase the player's jump height.", "Right click").setAmuletStoneType("Jade"));
		SoulItems.JetAmuletStone = 			Optional.of(new ItemAmuletStone("Jet_amulet_stone", 1000, "Can be used to repair certain items.", "Gemmeration Table", false).setAmuletStoneType("Jet"));
		SoulItems.LilaAmuletStone = 		Optional.of(new ItemAmuletStone("Lila_amulet_stone", 50, "Can heal the player for 1 heart.", "Right click", false).setAmuletStoneType("Lila"));
		SoulItems.OlivineAmuletStone = 		Optional.of(new ItemAmuletStone("Olivine_amulet_stone", Potion.resistance.getId(), 800, 50, "Can increase the player's resistance.", "Right click").setAmuletStoneType("Olivine"));
		SoulItems.OnyxAmuletStone = 		Optional.of(new ItemAmuletStone("Onyx_amulet_stone", Potion.invisibility.getId(), 400, 5, EnumRarity.EPIC, "Can make the player invisible.", "Right click").setAmuletStoneType("Onyx"));
		SoulItems.ScarletiteAmuletStone = 	Optional.of(new ItemAmuletStone("Scarletite_amulet_stone", 50, EnumRarity.UNCOMMON, "Can be used to enchant certain items.", "Gemming Table").setAmuletStoneType("Scarletite"));
		SoulItems.TopazAmuletStone = 		Optional.of(new ItemAmuletStone("Topaz_amulet_stone", Potion.digSpeed.getId(), 800, 50, "Can increase the player's dig speed.", "Right click").setAmuletStoneType("Topaz"));
		SoulItems.TurquoiseAmuletStone = 	Optional.of(new ItemAmuletStone("Turquoise_amulet_stone", Potion.moveSpeed.getId(), 800, 50, "Can increase the player's movement speed.", "Right click").setAmuletStoneType("Turquoise"));
		SoulItems.VioletAmuletStone = 		Optional.of(new ItemAmuletStone("Violet_amulet_stone", Potion.regeneration.getId(), 800, 50, "Can increase the player's health regeneration.", "Right click").setAmuletStoneType("Violet"));
		
		// Amulet Rings
		SoulItems.BlackdiamondAmuletRing = 	Optional.of(new ItemAmuletRing("Blackdiamond_amulet_ring", 1000, "Black Diamond", EnumRarity.EPIC, "Increases the player's damage."));
		SoulItems.OlivineAmuletRing = 		Optional.of(new ItemAmuletRing("Olivine_amulet_ring", 1000, "Olivine", "Increases the player's resistance."));
		SoulItems.TurquoiseAmuletRing = 	Optional.of(new ItemAmuletRing("Turquoise_amulet_ring", 1000, "Turquoise", "Increases the player's resistance."));
		// Plants		
		// Bushels
		SoulItems.GrapesBushel = 			Optional.of(new ItemSoulBushel("Grapes_bushel"));
		SoulItems.BaneberryBushel = 		Optional.of(new ItemSoulBushel("Baneberry_bushel"));
		SoulItems.BlackberryBushel = 		Optional.of(new ItemSoulBushel("Blackberry_bushel"));
		SoulItems.BlueberryBushel = 		Optional.of(new ItemSoulBushel("Blueberry_bushel"));
		SoulItems.CranberryBushel = 		Optional.of(new ItemSoulBushel("Cranberry_bushel"));
		SoulItems.RaspberryBushel = 		Optional.of(new ItemSoulBushel("Raspberry_bushel"));
		SoulItems.RazzberryBushel = 		Optional.of(new ItemSoulBushel("Razzberry_bushel"));
		SoulItems.Strawberries = 			Optional.of(new ItemSoulBushel("Strawberries"));		
		// Food		
		SoulItems.BlueberryMuffin = 		Optional.of(new ItemSoulFood(16, 4, 4F, false, "Blueberry_muffin"));
		SoulItems.BaneberryCake = 			Optional.of(new ItemSoulFood(32, -2, 4F, false, "Baneberry_cake").setPotionEffect(19, 4, 10, 4));	
		SoulItems.BlackberryCrumble = 		Optional.of(new ItemSoulFood(32, 6, 4F, false, "Blackberry_crumble"));	
		SoulItems.CranberryJuice = 			Optional.of(new ItemSoulFood(32, 3, 4F, false, "Cranberry_juice"));		
		SoulItems.CranberryMuffin = 		Optional.of(new ItemSoulFood(16, 4, 4F, false, "Cranberry_muffin"));	
		SoulItems.RaspberryJuice = 			Optional.of(new ItemSoulFood(32, 3, 4F, false, "Raspberry_juice"));	
		SoulItems.RazzberryJuice = 			Optional.of(new ItemSoulFood(32, 3, 4F, false, "Razzberry_juice"));	
		SoulItems.RazzberryPie = 			Optional.of(new ItemSoulFood(32, 8, 4F, false, "Razzberry_pie"));
		SoulItems.StrawberryPie = 			Optional.of(new ItemSoulFood(32, 8,  4F, false, "Strawberry_pie"));	
		SoulItems.Wine = 					Optional.of(new ItemSoulFood(32, 0, 4F, false, "Wine").setPotionEffect(15, 8, 10, 4).setUnlocalizedName("Wine"));
	
		// Ingots		
		SoulItems.BronzeIngot = 			Optional.of(new ItemSoulIngot("Bronze_ingot"));
		SoulItems.ChromiteIngot = 			Optional.of(new ItemSoulIngot("Chromite_ingot"));
		SoulItems.CobaltIngot = 			Optional.of(new ItemSoulIngot("Cobalt_ingot", EnumRarity.RARE));
		SoulItems.CopperIngot = 			Optional.of(new ItemSoulIngot("Copper_ingot"));
		SoulItems.SilverIngot = 			Optional.of(new ItemSoulIngot("Silver_ingot", EnumRarity.UNCOMMON));
		SoulItems.SteelIngot = 				Optional.of(new ItemSoulIngot("Steel_ingot", EnumRarity.RARE));
		SoulItems.TanzaniteIngot = 			Optional.of(new ItemSoulIngot("Tanzanite_ingot"));
		SoulItems.TinIngot = 				Optional.of(new ItemSoulIngot("Tin_ingot"));
	
		// Helmets
		SoulItems.BronzeHelmet = 			Optional.of(new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),0, "Bronze_helmet"));
		SoulItems.CobaltHelmet = 			Optional.of(new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),0, "Cobalt_helmet"));
		SoulItems.FyrisedHelmet =			Optional.of(new ItemArmorFyrised(InitMaterials.Fyrised_Armor,soul_forest.proxy.addArmor("Fyrised"),0, "Fyrised_helmet"));
		SoulItems.SilverHelmet = 			Optional.of(new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),0, "Silver_helmet"));
		SoulItems.SteelHelmet = 			Optional.of(new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),0, "Steel_helmet"));
		SoulItems.SlimeHelmet = 			Optional.of(new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),0, "Slime_helmet"));
		// Chestplates		
		SoulItems.BronzeChestplate = 		Optional.of(new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),1, "Bronze_chestplate"));
		SoulItems.CobaltChestplate = 		Optional.of(new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),1, "Cobalt_chestplate"));
		SoulItems.FyrisedChestplate = 		Optional.of(new ItemArmorFyrised(InitMaterials.Fyrised_Armor,soul_forest.proxy.addArmor("Fyrised"),1, "Fyrised_chestplate"));
		SoulItems.SilverChestplate = 		Optional.of(new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),1, "Silver_chestplate"));
		SoulItems.SteelChestplate =			Optional.of(new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),1, "Steel_chestplate"));
		SoulItems.SlimeChestplate =			Optional.of(new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),1, "Slime_chestplate"));
		// Leggings
		SoulItems.BronzeLeggings = 			Optional.of(new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),2, "Bronze_legs"));
		SoulItems.CobaltLeggings = 			Optional.of(new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),2, "Cobalt_legs"));				
		SoulItems.FyrisedLeggings = 		Optional.of(new ItemArmorFyrised(InitMaterials.Fyrised_Armor,soul_forest.proxy.addArmor("Fyrised"),2, "Fyrised_legs"));
		SoulItems.SilverLeggings = 			Optional.of(new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),2, "Silver_legs"));
		SoulItems.SteelLeggings = 			Optional.of(new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),2, "Steel_legs"));				
		SoulItems.SlimeLeggings = 			Optional.of(new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),2, "Slime_legs"));				
		// Boots		
		SoulItems.BronzeBoots = 			Optional.of(new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),3, "Bronze_boots"));
		SoulItems.CobaltBoots = 			Optional.of(new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),3, "Cobalt_boots"));		
		SoulItems.FyrisedBoots = 			Optional.of(new ItemArmorFyrised(InitMaterials.Fyrised_Armor,soul_forest.proxy.addArmor("Fyrised"),3, "Fyrised_boots"));
		SoulItems.SilverBoots = 			Optional.of(new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),3, "Silver_boots"));
		SoulItems.SteelBoots = 				Optional.of(new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),3, "Steel_boots"));
		SoulItems.SlimeBoots = 				Optional.of(new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),3, "Slime_boots"));
		
		// Tools
		// Custom Tools
		SoulItems.BerryCollector = 			Optional.of(new ItemBerrycollector("Berrycollector"));
		SoulItems.SoulLighter = 			Optional.of(new ItemSoulLighter("soul_lighter", 2));		
		SoulItems.FrostLighter = 			Optional.of(new ItemFrostLighter("frost_lighter", 2));		
		SoulItems.FrostWand = 				Optional.of(new ItemFrostWand("Frost_wand"));
	
		// Custom SoulItems
		SoulItems.Polisher = 				Optional.of(new SoulItem("Polisher"));
		SoulItems.PolisherTowel = 			Optional.of(new SoulItem("PolisherTowel"));					
		SoulItems.UraniumLiquid = 			Optional.of(new SoulItem("Uranium_liquid"));						
		SoulItems.FrostShard = 				Optional.of(new SoulItem("Frost_Shard"));	
		SoulItems.BurnedShard = 			Optional.of(new SoulItem("Burned_Shard"));
		SoulItems.LightShard = 				Optional.of(new SoulItem("Light_Shard"));
		SoulItems.StrengthShard = 			Optional.of(new SoulItem("Strength_Shard"));
		SoulItems.Soul = 					Optional.of(new SoulItem("Soul_item"));	
		SoulItems.FrozenRod = 				Optional.of(new SoulItem("Frozen_rod"));
		SoulItems.BlueGel = 				Optional.of(new SoulItem("Blue_gel"));
		SoulItems.BlueMoltenGel = 			Optional.of(new SoulItem("Blue_molten_gel"));
		SoulItems.GelPot = 					Optional.of(new ItemGelPot("Gel_pot_empty", false));
		SoulItems.GelPotFilled = 			Optional.of(new ItemGelPot("Gel_pot_filled", true));		
		SoulItems.GelPotKing = 				Optional.of(new ItemKingGelPot("King_gel_pot"));
		SoulItems.IceCrystal =				Optional.of(new ItemIceCrystal("Ice_crystal"));
		SoulItems.MochanEagleFeather =		Optional.of(new SoulItem("Mochan_Eagle_Feather"));
		SoulItems.MochanEagleWing = 		Optional.of(new SoulItem("Mochan_Eagle_Wing"));
	
		SoulItems.FrozenStick = 			Optional.of(new SoulItem("Frozen_Stick"));
		SoulItems.OnyxStick = 				Optional.of(new SoulItem("Onyx_stick"));
		SoulItems.TitaniumStick = 			Optional.of(new SoulItem("Titanium_stick"));
	
		SoulItems.MagicEmblem = 			Optional.of(new SoulItem("Magic_Emblem", EnumRarity.EPIC, true));
	
		// Magic Fragments
		SoulItems.BurnedFragment = 				Optional.of(new ItemMagicFragment("", "Burned", false));
		SoulItems.FrostFragment = 				Optional.of(new ItemMagicFragment("", "Frost", false));
		SoulItems.LightFragment =				Optional.of(new ItemMagicFragment("", "Light", false));
		SoulItems.SoulFragment = 				Optional.of(new ItemMagicFragment("", "Soul", false));
		SoulItems.StrengthFragment = 			Optional.of(new ItemMagicFragment("", "Strength", false));
		SoulItems.SoulFragmentEnhanced = 		Optional.of(new ItemMagicFragment("Enhanced", "Soul", false));
	
		SoulItems.BurnedMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Burned", true));
		SoulItems.EnlightedMagicFragmentAdv = 	Optional.of(new ItemMagicFragment("Advanced", "Enlighted", true));
		SoulItems.FireMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Fire", true));
		SoulItems.FlightMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Flight", true));
		SoulItems.FrozenMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Frozen", true));
		SoulItems.HardenedMagicFragmentAdv = 	Optional.of(new ItemMagicFragment("Advanced", "Hardened", true));
		SoulItems.PowerMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Power", true));
		SoulItems.SharpMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Sharp", true));
		SoulItems.ShinyMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Shiny", true));
		SoulItems.SoulMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Soul", true));
		SoulItems.StrengthMagicFragmentAdv = 	Optional.of(new ItemMagicFragment("Advanced", "Strength", true));
		SoulItems.StrongMagicFragmentAdv = 		Optional.of(new ItemMagicFragment("Advanced", "Strong", true));
		SoulItems.EnlightedMagicFragmentHalf = 	Optional.of(new ItemMagicFragment("Half", "Enlighted", true));
		SoulItems.FireMagicFragmentHalf = 		Optional.of(new ItemMagicFragment("Half", "Fire", true));
		SoulItems.FlightMagicFragmentHalf = 	Optional.of(new ItemMagicFragment("Half", "Flight", true));
		SoulItems.FrozenMagicFragmentHalf = 	Optional.of(new ItemMagicFragment("Half", "Frozen", true));
		SoulItems.HardenedMagicFragmentHalf = 	Optional.of(new ItemMagicFragment("Half", "Hardened", true));
		SoulItems.PowerMagicFragmentHalf = 		Optional.of(new ItemMagicFragment("Half", "Power", true));
		SoulItems.SharpMagicFragmentHalf = 		Optional.of(new ItemMagicFragment("Half", "Sharp", true));
		SoulItems.ShinyMagicFragmentHalf = 		Optional.of(new ItemMagicFragment("Half", "Shiny", true));
		SoulItems.SoulMagicFragmentHalf = 		Optional.of(new ItemMagicFragment("Half", "Soul", true));
		SoulItems.StrengthMagicFragmentHalf = 	Optional.of(new ItemMagicFragment("Half", "Strength", true));
		SoulItems.StrongMagicFragmentHalf = 	Optional.of(new ItemMagicFragment("Half", "Strong", true));
		SoulItems.BurnedMagicFragment = 		Optional.of(new ItemMagicFragment("", "Burned", true));
		SoulItems.EnlightedMagicFragment = 		Optional.of(new ItemMagicFragment("", "Enlighted", true));
		SoulItems.FireMagicFragment =			Optional.of(new ItemMagicFragment("", "Fire", true));
		SoulItems.FlightMagicFragment = 		Optional.of(new ItemMagicFragment("", "Flight", true));
		SoulItems.FrozenMagicFragment = 		Optional.of(new ItemMagicFragment("", "Frozen", true));
		SoulItems.HardenedMagicFragment = 		Optional.of(new ItemMagicFragment("", "Hardened", true));
		SoulItems.HotMagicFragment = 			Optional.of(new ItemMagicFragment("", "Hot", true));
		SoulItems.PowerMagicFragment = 			Optional.of(new ItemMagicFragment("", "Power", true));
		SoulItems.SharpMagicFragment = 			Optional.of(new ItemMagicFragment("", "Sharp", true));
		SoulItems.ShinyMagicFragment = 			Optional.of(new ItemMagicFragment("", "Shiny", true));
		SoulItems.SoulMagicFragment = 			Optional.of(new ItemMagicFragment("", "Soul", true));
		SoulItems.StrengthMagicFragment = 		Optional.of(new ItemMagicFragment("", "Strength", true));
		SoulItems.StrongMagicFragment =  		Optional.of(new ItemMagicFragment("", "Strong", true));
	
		SoulItems.SoulPotion =  			Optional.of(new ItemPotion().setUnlocalizedName(soul_forest.MODID + "_" + "soulpotion").setCreativeTab(soul_forest.tabSoulOther));
		SoulItems.SoulPotion.get().setPotionEffect("potion.lavaimmunity");
		System.out.println("[Soul Forest] SoulItems initialised");
    }

    public static void initBlockDependantItems(){
		SoulItems.SoulBucket = 				Optional.of(new ItemBlackBucket(Blocks.air, "bucketSoul"));	
		SoulItems.BucketSoulWater = 		Optional.of(new ItemBlackBucket(SoulBlocks.SoulWaterMoving.get(), "bucketSoulWater").setContainerItem(SoulItems.SoulBucket.get()));
		SoulItems.ItemVineplant = 			Optional.of(new ItemVineplant(SoulBlocks.Vineplant.get(), "ItemVineplant"));
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("soul_water_flow", 
			FluidContainerRegistry.BUCKET_VOLUME), 
			new ItemStack(SoulItems.BucketSoulWater.get()), 
			new ItemStack(SoulItems.SoulBucket.get()));
    }
}