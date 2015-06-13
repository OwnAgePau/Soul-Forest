package com.Mod_Ores.Init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Items.ItemBlackBucket;
import com.Mod_Ores.Items.ItemFrostShard;
import com.Mod_Ores.Items.ItemGelPot;
import com.Mod_Ores.Items.ItemGem;
import com.Mod_Ores.Items.ItemIceCrystal;
import com.Mod_Ores.Items.ItemKingGelPot;
import com.Mod_Ores.Items.ItemMagicFragment;
import com.Mod_Ores.Items.ItemSoulBushel;
import com.Mod_Ores.Items.ItemSoulFood;
import com.Mod_Ores.Items.ItemSoulIngot;
import com.Mod_Ores.Items.ItemSoulLighter;
import com.Mod_Ores.Items.ItemVineplant;
import com.Mod_Ores.Items.SoulItem;
import com.Mod_Ores.Items.SoulPotion;
import com.Mod_Ores.Items.Armor.ItemArmorBronze;
import com.Mod_Ores.Items.Armor.ItemArmorCobalt;
import com.Mod_Ores.Items.Armor.ItemArmorMithril;
import com.Mod_Ores.Items.Armor.ItemArmorSilver;
import com.Mod_Ores.Items.Armor.ItemArmorSlime;
import com.Mod_Ores.Items.Armor.ItemArmorSteel;
import com.Mod_Ores.Items.Tools.ItemBerrycollector;
import com.Mod_Ores.Items.Tools.ItemFrostWand;
import com.Mod_Ores.Items.Tools.ItemSoulAxe;
import com.Mod_Ores.Items.Tools.ItemSoulHoe;
import com.Mod_Ores.Items.Tools.ItemSoulPickaxe;
import com.Mod_Ores.Items.Tools.ItemSoulShovel;
import com.Mod_Ores.Items.Tools.ItemSoulSword;
import com.Mod_Ores.Items.Tools.ItemThrowingKnife;
import com.Mod_Ores.Items.Tools.ItemWarAxe;
import com.google.common.base.Optional;

public class InitItems {	
    public static void init(){
	InitMaterials.init();	
	initializeItems();

	// SetToolClass
	// Axes
	SoulItems.AquamarineAxe.get().setHarvestLevel("axe", 3);
	SoulItems.BronzeAxe.get().setHarvestLevel("axe", 2);
	SoulItems.ChromiteAxe.get().setHarvestLevel("axe", 2);
	SoulItems.CobaltAxe.get().setHarvestLevel("axe", 4);
	SoulItems.CopperAxe.get().setHarvestLevel("axe", 1);
	SoulItems.MithrilAxe.get().setHarvestLevel("axe", 5);
	SoulItems.SilverAxe.get().setHarvestLevel("axe", 3);
	SoulItems.SteelAxe.get().setHarvestLevel("axe", 4);
	SoulItems.TanzaniteAxe.get().setHarvestLevel("axe", 2);
	SoulItems.TinAxe.get().setHarvestLevel("axe", 1);
	// War Axes
	SoulItems.AquamarineWaraxe.get().setHarvestLevel("waraxe", 4);
	// Pickaxes
	SoulItems.AquamarinePickaxe.get().setHarvestLevel("pickaxe", 3);
	SoulItems.BronzePickaxe.get().setHarvestLevel("pickaxe", 2);
	SoulItems.ChromitePickaxe.get().setHarvestLevel("pickaxe", 2);
	SoulItems.CobaltPickaxe.get().setHarvestLevel("pickaxe", 4);
	SoulItems.CopperPickaxe.get().setHarvestLevel("pickaxe", 1);
	SoulItems.MithrilPickaxe.get().setHarvestLevel("pickaxe", 5);
	SoulItems.SilverPickaxe.get().setHarvestLevel("pickaxe", 3);
	SoulItems.SteelPickaxe.get().setHarvestLevel("pickaxe", 4);
	SoulItems.TanzanitePickaxe.get().setHarvestLevel("pickaxe", 2);
	SoulItems.TinPickaxe.get().setHarvestLevel("pickaxe", 1);
	// Shovels
	SoulItems.AquamarineShovel.get().setHarvestLevel("shovel", 3);
	SoulItems.BronzeShovel.get().setHarvestLevel("shovel", 2);
	SoulItems.ChromiteShovel.get().setHarvestLevel("shovel", 2);
	SoulItems.CobaltShovel.get().setHarvestLevel("shovel", 4);
	SoulItems.CopperShovel.get().setHarvestLevel("shovel", 1);
	SoulItems.MithrilShovel.get().setHarvestLevel("shovel", 5);
	SoulItems.SilverShovel.get().setHarvestLevel("shovel", 3);
	SoulItems.SteelShovel.get().setHarvestLevel("shovel", 4);
	SoulItems.TanzaniteShovel.get().setHarvestLevel("shovel", 2);
	SoulItems.TinShovel.get().setHarvestLevel("shovel", 1);
    }

    private static void initializeItems(){
	// Axes		
	SoulItems.AquamarineAxe = Optional.of(new ItemSoulAxe("Aquamarineaxe", InitMaterials.toolAquamarine).setTextureName("soulforest:Aquamarine_axe"));
	SoulItems.BronzeAxe = Optional.of(new ItemSoulAxe("Bronzeaxe", InitMaterials.toolBronze).setTextureName("soulforest:Bronze_axe"));
	SoulItems.ChromiteAxe = Optional.of(new ItemSoulAxe("Chromiteaxe", InitMaterials.toolChromite).setTextureName("soulforest:Chromite_axe"));
	SoulItems.CobaltAxe = Optional.of(new ItemSoulAxe("Cobaltaxe", InitMaterials.toolCobalt).setTextureName("soulforest:Cobalt_axe"));
	SoulItems.CopperAxe = Optional.of(new ItemSoulAxe("Copperaxe", InitMaterials.toolCopper).setTextureName("soulforest:Copper_axe"));
	SoulItems.MithrilAxe = Optional.of(new ItemSoulAxe("Mithrilaxe", InitMaterials.toolMithril).setTextureName("soulforest:Mithril_axe"));
	SoulItems.SilverAxe = Optional.of(new ItemSoulAxe("Silveraxe", InitMaterials.toolSilver).setTextureName("soulforest:Silver_axe"));
	SoulItems.SteelAxe = Optional.of(new ItemSoulAxe("Steelaxe", InitMaterials.toolSteel).setTextureName("soulforest:Steel_axe"));
	SoulItems.TanzaniteAxe = Optional.of(new ItemSoulAxe("Tanzaniteaxe", InitMaterials.toolTanzanite).setTextureName("soulforest:Tanzanite_axe"));
	SoulItems.TinAxe = Optional.of(new ItemSoulAxe("Tinaxe", InitMaterials.toolTin).setTextureName("soulforest:Tin_axe"));						
	// Hoes
	SoulItems.AquamarineHoe = Optional.of(new ItemSoulHoe("Aquamarinehoe", InitMaterials.toolAquamarine).setTextureName("soulforest:Aquamarine_hoe"));
	SoulItems.BronzeHoe = Optional.of(new ItemSoulHoe("Bronzehoe", InitMaterials.toolBronze).setTextureName("soulforest:Bronze_hoe"));
	SoulItems.ChromiteHoe = Optional.of(new ItemSoulHoe("Chromitehoe", InitMaterials.toolChromite).setTextureName("soulforest:Chromite_hoe"));
	SoulItems.CobaltHoe = Optional.of(new ItemSoulHoe("Cobalthoe", InitMaterials.toolCobalt).setTextureName("soulforest:Cobalt_hoe"));
	SoulItems.CopperHoe = Optional.of(new ItemSoulHoe("Copperhoe", InitMaterials.toolCopper).setTextureName("soulforest:Copper_hoe"));
	SoulItems.MithrilHoe = Optional.of(new ItemSoulHoe("Mithrilhoe", InitMaterials.toolMithril).setTextureName("soulforest:Mithril_hoe"));
	SoulItems.SilverHoe = Optional.of(new ItemSoulHoe("Silverhoe", InitMaterials.toolSilver).setTextureName("soulforest:Silver_hoe"));
	SoulItems.SteelHoe = Optional.of(new ItemSoulHoe("Steelhoe", InitMaterials.toolSteel).setTextureName("soulforest:Steel_hoe"));
	SoulItems.TanzaniteHoe = Optional.of(new ItemSoulHoe("Tanzanitehoe", InitMaterials.toolTanzanite).setTextureName("soulforest:Tanzanite_hoe"));
	SoulItems.TinHoe = Optional.of(new ItemSoulHoe("Tinhoe", InitMaterials.toolTin).setTextureName("soulforest:Tin_hoe"));								
	// Pickaxes		
	SoulItems.AquamarinePickaxe = Optional.of(new ItemSoulPickaxe("Aquamarinepickaxe", InitMaterials.toolAquamarine).setTextureName("soulforest:Aquamarine_pickaxe"));
	SoulItems.BronzePickaxe = Optional.of(new ItemSoulPickaxe("Bronzepickaxe", InitMaterials.toolBronze).setTextureName("soulforest:Bronze_pickaxe"));
	SoulItems.ChromitePickaxe = Optional.of(new ItemSoulPickaxe("Chromitepickaxe", InitMaterials.toolChromite).setTextureName("soulforest:Chromite_pickaxe"));
	SoulItems.CobaltPickaxe = Optional.of(new ItemSoulPickaxe("Cobaltpickaxe", InitMaterials.toolCobalt).setTextureName("soulforest:Cobalt_pickaxe"));
	SoulItems.CopperPickaxe = Optional.of(new ItemSoulPickaxe("Copperpickaxe", InitMaterials.toolCopper).setTextureName("soulforest:Copper_pickaxe"));
	SoulItems.MithrilPickaxe = Optional.of(new ItemSoulPickaxe("Mithrilpickaxe", InitMaterials.toolMithril).setTextureName("soulforest:Mithril_pickaxe"));
	SoulItems.SilverPickaxe = Optional.of(new ItemSoulPickaxe("Silverpickaxe", InitMaterials.toolSilver).setTextureName("soulforest:Silver_pickaxe"));
	SoulItems.SteelPickaxe = Optional.of(new ItemSoulPickaxe("Steelpickaxe", InitMaterials.toolSteel).setTextureName("soulforest:Steel_pickaxe"));
	SoulItems.TanzanitePickaxe = Optional.of(new ItemSoulPickaxe("Tanzanitepickaxe", InitMaterials.toolTanzanite).setTextureName("soulforest:Tanzanite_pickaxe"));
	SoulItems.TinPickaxe = Optional.of(new ItemSoulPickaxe("Tinpickaxe", InitMaterials.toolTin).setTextureName("soulforest:Tin_pickaxe"));			
	// Shovels		
	SoulItems.AquamarineShovel = Optional.of(new ItemSoulShovel("Aquamarineshovel", InitMaterials.toolAquamarine).setTextureName("soulforest:Aquamarine_shovel"));
	SoulItems.BronzeShovel = Optional.of(new ItemSoulShovel("Bronzeshovel", InitMaterials.toolBronze).setTextureName("soulforest:Bronze_shovel"));
	SoulItems.ChromiteShovel = Optional.of(new ItemSoulShovel("Chromiteshovel", InitMaterials.toolChromite).setTextureName("soulforest:Chromite_shovel"));
	SoulItems.CobaltShovel = Optional.of(new ItemSoulShovel("Cobaltshovel", InitMaterials.toolCobalt).setTextureName("soulforest:Cobalt_shovel"));
	SoulItems.CopperShovel = Optional.of(new ItemSoulShovel("Coppershovel", InitMaterials.toolCopper).setTextureName("soulforest:Copper_shovel"));
	SoulItems.MithrilShovel = Optional.of(new ItemSoulShovel("Mithrilshovel", InitMaterials.toolMithril).setTextureName("soulforest:Mithril_shovel"));
	SoulItems.SilverShovel = Optional.of(new ItemSoulShovel("Silvershovel", InitMaterials.toolSilver).setTextureName("soulforest:Silver_shovel"));
	SoulItems.SteelShovel = Optional.of(new ItemSoulShovel("Steelshovel", InitMaterials.toolSteel).setTextureName("soulforest:Steel_shovel"));
	SoulItems.TanzaniteShovel = Optional.of(new ItemSoulShovel("Tanzaniteshovel", InitMaterials.toolTanzanite).setTextureName("soulforest:Tanzanite_shovel"));
	SoulItems.TinShovel = Optional.of(new ItemSoulShovel("Tinshovel", InitMaterials.toolTin).setTextureName("soulforest:Tin_shovel"));
	// Swords		
	SoulItems.AquamarineSword = Optional.of(new ItemSoulSword("Aquamarinesword", InitMaterials.toolAquamarine).setTextureName("soulforest:Aquamarine_sword"));
	SoulItems.BronzeSword = Optional.of(new ItemSoulSword("Bronzesword", InitMaterials.toolBronze).setTextureName("soulforest:Bronze_sword"));
	SoulItems.ChromiteSword = Optional.of(new ItemSoulSword("Chromitesword", InitMaterials.toolChromite).setTextureName("soulforest:Chromite_sword"));
	SoulItems.CobaltSword = Optional.of(new ItemSoulSword("Cobaltsword", InitMaterials.toolCobalt, "R").setTextureName("soulforest:Cobalt_sword"));
	SoulItems.MithrilSword = Optional.of(new ItemSoulSword("Mithrilsword", InitMaterials.toolMithril, "E").setTextureName("soulforest:Mithril_sword"));
	SoulItems.SilverSword = Optional.of(new ItemSoulSword("Silversword", InitMaterials.toolSilver, "U").setTextureName("soulforest:Silver_sword"));
	SoulItems.SteelSword = Optional.of(new ItemSoulSword("Steelsword", InitMaterials.toolSteel, "R").setTextureName("soulforest:Steel_sword"));
	SoulItems.TanzaniteSword = Optional.of(new ItemSoulSword("Tanzanitesword", InitMaterials.toolTanzanite, "R").setTextureName("soulforest:Tanzanite_sword"));

	// War Axes
	SoulItems.AquamarineWaraxe = Optional.of(new ItemWarAxe("Aquamarinewaraxe", InitMaterials.toolWaraxe, "R").setTextureName("soulforest:Aquamarine_waraxe"));

	// Throwing Knifes
	SoulItems.TinThrowingknife = 	Optional.of(new ItemThrowingKnife("TinthrowingKnife").setTextureName("soulforest:Tin_throwingKnife"));
	SoulItems.CopperThrowingknife = Optional.of(new ItemThrowingKnife("CopperthrowingKnife").setTextureName("soulforest:Copper_throwingKnife"));

	//Gems - cuts and uncuts
	SoulItems.AmazoniteGem = 		Optional.of(new ItemGem("Amazonitegem", "U").setTextureName("soulforest:Amazonite_gem"));
	SoulItems.AmazoniteUncut = 		Optional.of(new ItemGem("Amazoniteuncut").setTextureName("soulforest:Amazonite_uncut"));
	SoulItems.AmethystGem = 		Optional.of(new ItemGem("Amethystgem").setTextureName("soulforest:Amethyst_gem"));
	SoulItems.AmethystUncut = 		Optional.of(new ItemGem("Amethystuncut").setTextureName("soulforest:Amethyst_uncut"));
	SoulItems.AquamarineGem = 		Optional.of(new ItemGem("Aquamarinegem", "U").setTextureName("soulforest:Aquamarine_gem"));
	SoulItems.AquamarineUncut = 		Optional.of(new ItemGem("Aquamarineuncut").setTextureName("soulforest:Aquamarine_uncut"));
	SoulItems.BlackdiamondGem = 		Optional.of(new ItemGem("Blackdiamondgem", "E").setTextureName("soulforest:Blackdiamond_gem"));
	SoulItems.BlackdiamondUncut = 		Optional.of(new ItemGem("Blackdiamonduncut").setTextureName("soulforest:Blackdiamond_uncut"));
	SoulItems.CitrineGem = 			Optional.of(new ItemGem("Citrinegem").setTextureName("soulforest:Citrine_gem"));
	SoulItems.CitrineUncut = 		Optional.of(new ItemGem("Citrineuncut").setTextureName("soulforest:Citrine_uncut"));
	SoulItems.JadeGem = 			Optional.of(new ItemGem("Jadegem").setTextureName("soulforest:Jade_gem"));
	SoulItems.JadeUncut = 			Optional.of(new ItemGem("Jadeuncut").setTextureName("soulforest:Jade_uncut"));
	SoulItems.JetGem =			Optional.of(new ItemGem("Jetgem").setTextureName("soulforest:Jet_gem"));
	SoulItems.JetUncut = 			Optional.of(new ItemGem("Jetuncut").setTextureName("soulforest:Jet_uncut"));
	SoulItems.LilaGem = 			Optional.of(new ItemGem("Lilagem").setTextureName("soulforest:Lila_gem"));
	SoulItems.LilaUncut = 			Optional.of(new ItemGem("Lila_uncut").setTextureName("soulforest:Lila_uncut"));
	SoulItems.OlivineGem = 			Optional.of(new ItemGem("Olivinegem").setTextureName("soulforest:Olivine_gem"));
	SoulItems.OlivineUncut = 		Optional.of(new ItemGem("Olivineuncut").setTextureName("soulforest:Olivine_uncut"));
	SoulItems.OnyxGem = 			Optional.of(new ItemGem("Onyxgem", "E").setTextureName("soulforest:Onyx_gem"));
	SoulItems.OnyxUncut = 			Optional.of(new ItemGem("Onyxuncut").setTextureName("soulforest:Onyx_uncut"));
	SoulItems.OpalGem = 			Optional.of(new ItemGem("Opalgem").setTextureName("soulforest:Opal_gem"));
	SoulItems.OpalUncut = 			Optional.of(new ItemGem("Opaluncut").setTextureName("soulforest:Opal_uncut"));
	SoulItems.ScarletiteGem = 		Optional.of(new ItemGem("Scarletemeraldgem", "U").setTextureName("soulforest:Scarletemerald_gem"));
	SoulItems.ScarletiteUncut = 		Optional.of(new ItemGem("Scarletemeralduncut").setTextureName("soulforest:Scarletemerald_uncut"));
	SoulItems.TitaniumGem = 		Optional.of(new ItemGem("Titaniumgem", "E").setTextureName("soulforest:Titanium_gem"));
	SoulItems.TitaniumUncut = 		Optional.of(new ItemGem("Titaniumuncut").setTextureName("soulforest:Titanium_uncut"));
	SoulItems.TopazGem = 			Optional.of(new ItemGem("Topazgem").setTextureName("soulforest:Topaz_gem"));
	SoulItems.TopazUncut = 			Optional.of(new ItemGem("Topazuncut").setTextureName("soulforest:Topaz_uncut"));
	SoulItems.TurquoiseGem = 		Optional.of(new ItemGem("Turquoisegem").setTextureName("soulforest:Turquoise_gem"));
	SoulItems.TurquoiseUncut = 		Optional.of(new ItemGem("Turquoiseuncut").setTextureName("soulforest:Turquoise_uncut"));
	SoulItems.UraniumGem = 			Optional.of(new ItemGem("Uraniumgem", "E").setTextureName("soulforest:Uranium_gem"));
	SoulItems.VioletGem = 			Optional.of(new ItemGem("Violetgem").setTextureName("soulforest:Violet_gem"));
	SoulItems.VioletUncut = 		Optional.of(new ItemGem("Violetuncut").setTextureName("soulforest:Violet_uncut"));
	SoulItems.WhiteopalGem = 		Optional.of(new ItemGem("Whiteopalgem").setTextureName("soulforest:Whiteopal_gem"));
	SoulItems.WhiteopalUncut = 		Optional.of(new ItemGem("Whiteopaluncut").setTextureName("soulforest:Whiteopal_uncut"));
	// Plants		
	// Bushels
	SoulItems.GrapesBushel = 		Optional.of((new ItemSoulBushel("Grapesbushel")).setTextureName("soulforest:Grapes_bushel"));
	SoulItems.BaneberryBushel = 		Optional.of((new ItemSoulBushel("Baneberrybushel")).setTextureName("soulforest:Baneberry_bushel"));
	SoulItems.BlackberryBushel = 		Optional.of((new ItemSoulBushel("Blackberrybushel")).setTextureName("soulforest:Blackberry_bushel"));
	SoulItems.BlueberryBushel = 		Optional.of((new ItemSoulBushel("Blueberrybushel")).setTextureName("soulforest:Blueberry_bushel"));
	SoulItems.CranberryBushel = 		Optional.of((new ItemSoulBushel("Cranberrybushel")).setTextureName("soulforest:Cranberry_bushel"));
	SoulItems.RaspberryBushel = 		Optional.of((new ItemSoulBushel("Raspberrybushel")).setTextureName("soulforest:Raspberry_bushel"));
	SoulItems.RazzberryBushel = 		Optional.of((new ItemSoulBushel("Razzberrybushel")).setTextureName("soulforest:Razzberry_bushel"));
	SoulItems.Strawberries = 		Optional.of((new ItemSoulBushel("Strawberries")).setTextureName("soulforest:Strawberries"));		
	// Food		
	SoulItems.BlueberryMuffin = 		Optional.of(new ItemSoulFood(16, 4, 4F, false, "Blueberrymuffin").setTextureName("soulforest:Blueberry_muffin"));
	SoulItems.BaneberryCake = 		Optional.of(new ItemSoulFood(32, -2, 4F, false, "Baneberrycake").setPotionEffect(19, 4, 10, 4).setTextureName("soulforest:Baneberry_cake"));	
	SoulItems.BlackberryCrumble = 		Optional.of(new ItemSoulFood(32, 6, 4F, false, "Blackberrycrumble").setTextureName("soulforest:Blackberry_crumble"));	
	SoulItems.CranberryJuice = 		Optional.of(new ItemSoulFood(32, 3, 4F, false, "Cranberryjuice").setTextureName("soulforest:Cranberry_juice"));		
	SoulItems.CranberryMuffin = 		Optional.of(new ItemSoulFood(16, 4, 4F, false, "Cranberrymuffin").setTextureName("soulforest:Cranberry_muffin"));	
	SoulItems.RaspberryJuice = 		Optional.of(new ItemSoulFood(32, 3, 4F, false, "Raspberryjuice").setTextureName("soulforest:Raspberry_juice"));	
	SoulItems.RazzberryJuice = 		Optional.of(new ItemSoulFood(32, 3, 4F, false, "Razzberryjuice").setTextureName("soulforest:Razzberry_juice"));	
	SoulItems.RazzberryPie = 		Optional.of(new ItemSoulFood(32, 8, 4F, false, "Razzberrypie").setTextureName("soulforest:Razzberry_pie"));
	SoulItems.StrawberryPie = 		Optional.of(new ItemSoulFood(32, 8,  4F, false, "Strawberrypie").setTextureName("soulforest:Strawberry_pie"));	
	SoulItems.Wine = 			Optional.of(new ItemSoulFood(32, 0, 4F, false, "Wine").setPotionEffect(15, 8, 10, 4).setUnlocalizedName("Wine").setTextureName("soulforest:Wine"));

	// Ingots		
	SoulItems.BronzeIngot = 		Optional.of(new ItemSoulIngot("Bronzeingot").setTextureName("soulforest:Bronze_ingot"));
	SoulItems.ChromiteIngot = 		Optional.of((new ItemSoulIngot("Chromiteingot")).setTextureName("soulforest:Chromite_ingot"));
	SoulItems.CobaltIngot = 		Optional.of(new ItemSoulIngot("Cobaltingot", "R").setTextureName("soulforest:Cobalt_ingot"));
	SoulItems.CopperIngot = 		Optional.of((new ItemSoulIngot("Copperingot")).setTextureName("soulforest:Copper_ingot"));
	SoulItems.MithrilIngot = 		Optional.of((new ItemSoulIngot("Mithrilingot", "E")).setTextureName("soulforest:Mithril_ingot"));
	SoulItems.SilverIngot = 		Optional.of((new ItemSoulIngot("Silveringot", "U")).setTextureName("soulforest:Silver_ingot"));
	SoulItems.SteelIngot = 			Optional.of(new ItemSoulIngot("Steelingot", "R").setTextureName("soulforest:Steel_ingot"));
	SoulItems.TanzaniteIngot = 		Optional.of((new ItemSoulIngot("Tanzaniteingot")).setTextureName("soulforest:Tanzanite_ingot"));
	SoulItems.TinIngot = 			Optional.of((new ItemSoulIngot("Tiningot")).setTextureName("soulforest:Tin_ingot"));

	// Helmets		
	SoulItems.BronzeHelmet = 		Optional.of((new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),0, "Bronze_helmet")).setTextureName("soulforest:Bronze_helmet"));
	SoulItems.CobaltHelmet = 		Optional.of((new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),0, "Cobalt_helmet")).setTextureName("soulforest:Cobalt_helmet"));
	SoulItems.MithrilHelmet =		Optional.of((new ItemArmorMithril(InitMaterials.Mithril_Armor,soul_forest.proxy.addArmor("Mithril"),0, "Mithril_helmet").setTextureName("soulforest:Mithril_helmet")));
	SoulItems.SilverHelmet = 		Optional.of((new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),0, "Silver_helmet")).setTextureName("soulforest:Silver_helmet"));
	SoulItems.SteelHelmet = 		Optional.of((new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),0, "Steel_helmet")).setTextureName("soulforest:Steel_helmet"));
	SoulItems.SlimeHelmet = 		Optional.of((new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),0, "Slime_helmet")).setTextureName("soulforest:Slime_helmet"));
	// Chestplates		
	SoulItems.BronzeChestplate = 		Optional.of((new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),1, "Bronze_chestplate")).setTextureName("soulforest:Bronze_chestplate"));
	SoulItems.CobaltChestplate = 		Optional.of((new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),1, "Cobalt_chestplate")).setTextureName("soulforest:Cobalt_chestplate"));
	SoulItems.MithrilChestplate = 		Optional.of((new ItemArmorMithril(InitMaterials.Mithril_Armor,soul_forest.proxy.addArmor("Mithril"),1, "Mithril_chestplate").setTextureName("soulforest:Mithril_chestplate")));
	SoulItems.SilverChestplate = 		Optional.of((new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),1, "Silver_chestplate")).setTextureName("soulforest:Silver_chestplate"));
	SoulItems.SteelChestplate =		Optional.of((new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),1, "Steel_chestplate")).setTextureName("soulforest:Steel_chestplate"));
	SoulItems.SlimeChestplate =		Optional.of((new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),1, "Slime_chestplate")).setTextureName("soulforest:Slime_chestplate"));
	// Leggings
	SoulItems.BronzeLeggings = 		Optional.of((new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),2, "Bronze_legs")).setTextureName("soulforest:Bronze_legs"));
	SoulItems.CobaltLeggings = 		Optional.of((new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),2, "Cobalt_legs")).setTextureName("soulforest:Cobalt_legs"));				
	SoulItems.MithrilLeggings = 		Optional.of((new ItemArmorMithril(InitMaterials.Mithril_Armor,soul_forest.proxy.addArmor("Mithril"),2, "Mithril_legs").setTextureName("soulforest:Mithril_legs")));
	SoulItems.SilverLeggings = 		Optional.of((new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),2, "Silver_legs")).setTextureName("soulforest:Silver_legs"));
	SoulItems.SteelLeggings = 		Optional.of((new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),2, "Steel_legs")).setTextureName("soulforest:Steel_legs"));				
	SoulItems.SlimeLeggings = 		Optional.of((new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),2, "Slime_legs")).setTextureName("soulforest:Slime_legs"));				
	// Boots		
	SoulItems.BronzeBoots = 		Optional.of((new ItemArmorBronze(InitMaterials.Bronze_Armor,soul_forest.proxy.addArmor("Bronze"),3, "Bronze_boots")).setTextureName("soulforest:Bronze_boots"));
	SoulItems.CobaltBoots = 		Optional.of((new ItemArmorCobalt(InitMaterials.Cobalt_Armor,soul_forest.proxy.addArmor("Cobalt"),3, "Cobalt_boots")).setTextureName("soulforest:Cobalt_boots"));		
	SoulItems.MithrilBoots = 		Optional.of((new ItemArmorMithril(InitMaterials.Mithril_Armor,soul_forest.proxy.addArmor("Mithril"),3, "Mithril_boots").setTextureName("soulforest:Mithril_boots")));
	SoulItems.SilverBoots = 		Optional.of((new ItemArmorSilver(InitMaterials.Silver_Armor,soul_forest.proxy.addArmor("Silver"),3, "Silver_boots")).setTextureName("soulforest:Silver_boots"));
	SoulItems.SteelBoots = 			Optional.of((new ItemArmorSteel(InitMaterials.Steel_Armor,soul_forest.proxy.addArmor("Steel"),3, "Steel_boots")).setTextureName("soulforest:Steel_boots"));
	SoulItems.SlimeBoots = 			Optional.of((new ItemArmorSlime(InitMaterials.Slime_Armor,soul_forest.proxy.addArmor("Slime"),3, "Slime_boots")).setTextureName("soulforest:Slime_boots"));
	
	// Tools
	// Custom Tools
	SoulItems.BerryCollector = 		Optional.of(new ItemBerrycollector().setTextureName("soulforest:Berrycollector"));
	SoulItems.SoulLighter = 		Optional.of(new ItemSoulLighter().setTextureName("soulforest:soul_lighter"));		
	SoulItems.FrostWand = 			Optional.of(new ItemFrostWand("Frost_wand").setTextureName("soulforest:Frost_wand"));

	// Custom SoulItems
	SoulItems.Polisher = 			Optional.of((new SoulItem("Polisher").setTextureName("soulforest:Polisher")));
	SoulItems.PolisherTowel = 		Optional.of((new SoulItem("PolisherTowel").setTextureName("soulforest:PolisherTowel")));					
	SoulItems.UraniumLiquid = 		Optional.of((new SoulItem("Uranium_liquid")).setTextureName("soulforest:Uranium_liquid"));						
	SoulItems.FrostShard = 			Optional.of((new ItemFrostShard().setTextureName("soulforest:Frost_shard")));	
	SoulItems.BurnedShard = 		Optional.of((new SoulItem("Burned_Shard")).setTextureName("soulforest:Burned_Shard"));
	SoulItems.LightShard = 			Optional.of((new SoulItem("Light_Shard")).setTextureName("soulforest:Light_Shard"));
	SoulItems.StrengthShard = 		Optional.of((new SoulItem("Strength_Shard")).setTextureName("soulforest:Strength_Shard"));
	SoulItems.Soul = 				Optional.of((new SoulItem("Soul_item")).setTextureName("soulforest:Soul_item"));	
	SoulItems.FrozenRod = 			Optional.of((new SoulItem("Frozen_rod")).setTextureName("soulforest:Frozen_rod"));
	SoulItems.BlueGel = 			Optional.of((new SoulItem("Blue_gel")).setTextureName("soulforest:Blue_gel"));
	SoulItems.BlueMoltenGel = 		Optional.of((new SoulItem("Blue_molten_gel")).setTextureName("soulforest:Blue_molten_gel"));
	SoulItems.GelPot = 				Optional.of((new ItemGelPot("Gel_pot_empty", false)).setTextureName("soulforest:Gel_pot_empty"));
	SoulItems.GelPotFilled = 		Optional.of((new ItemGelPot("Gel_pot_filled", true)).setTextureName("soulforest:Gel_pot_filled"));		
	SoulItems.GelPotKing = 			Optional.of((new ItemKingGelPot("King_gel_pot")).setTextureName("soulforest:King_gel_pot"));
	SoulItems.IceCrystal =			Optional.of((new ItemIceCrystal("Ice_crystal")).setTextureName("soulforest:Ice_crystal"));
	SoulItems.MochanEagleFeather =		Optional.of((new SoulItem("Mochan_Eagle_Feather")).setTextureName("soulforest:Mochan_Eagle_Feather"));
	SoulItems.MochanEagleWing = 		Optional.of((new SoulItem("Mochan_Eagle_Wing")).setTextureName("soulforest:Mochan_Eagle_Wing"));

	SoulItems.FrozenStick = 		Optional.of((new SoulItem("Frozen_Stick")).setTextureName("soulforest:Frozen_Stick"));
	SoulItems.OnyxStick = 			Optional.of((new SoulItem("Onyx_stick")).setTextureName("soulforest:Onyx_stick"));
	SoulItems.TitaniumStick = 		Optional.of((new SoulItem("Titanium_stick")).setTextureName("soulforest:Titanium_stick"));

	SoulItems.MagicEmblem = 		Optional.of((new SoulItem("Magic_Emblem", "E", true)).setTextureName("soulforest:Magic_Emblem"));

	// Magic Fragments
	SoulItems.BurnedFragment = Optional.of(new ItemMagicFragment("", "Burned", false).setTextureName("soulforest:Burned_Fragment"));
	SoulItems.FrostFragment = Optional.of(new ItemMagicFragment("", "Frost", false).setTextureName("soulforest:Frost_Fragment"));
	SoulItems.LightFragment = Optional.of(new ItemMagicFragment("", "Light", false).setTextureName("soulforest:Light_Fragment"));
	SoulItems.SoulFragment = Optional.of(new ItemMagicFragment("", "Soul", false).setTextureName("soulforest:Soul_Fragment"));
	SoulItems.StrengthFragment = Optional.of(new ItemMagicFragment("", "Strength", false).setTextureName("soulforest:Strength_Fragment"));
	SoulItems.SoulFragmentEnhanced = Optional.of(new ItemMagicFragment("Enhanced", "Soul", false).setTextureName("soulforest:Soul_Fragment_Enhanced"));

	SoulItems.BurnedMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Burned", true).setTextureName("soulforest:Burned_Magic_Fragment_Advanced"));
	SoulItems.EnlightedMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Enlighted", true).setTextureName("soulforest:Enlighted_Magic_Fragment_Advanced"));
	SoulItems.FireMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Fire", true).setTextureName("soulforest:Fire_Magic_Fragment_Advanced"));
	SoulItems.FlightMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Flight", true).setTextureName("soulforest:Flight_Magic_Fragment_Advanced"));
	SoulItems.FrozenMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Frozen", true).setTextureName("soulforest:Frozen_Magic_Fragment_Advanced"));
	SoulItems.HardenedMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Hardened", true).setTextureName("soulforest:Hardened_Magic_Fragment_Advanced"));
	SoulItems.PowerMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Power", true).setTextureName("soulforest:Power_Magic_Fragment_Advanced"));
	SoulItems.SharpMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Sharp", true).setTextureName("soulforest:Sharp_Magic_Fragment_Advanced"));
	SoulItems.ShinyMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Shiny", true).setTextureName("soulforest:Shiny_Magic_Fragment_Advanced"));
	SoulItems.SoulMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Soul", true).setTextureName("soulforest:Soul_Magic_Fragmen_Advancedt"));
	SoulItems.StrengthMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Strength", true).setTextureName("soulforest:Strength_Magic_Fragment_Advanced"));
	SoulItems.StrongMagicFragmentAdv = Optional.of(new ItemMagicFragment("Advanced", "Strong", true).setTextureName("soulforest:Strong_Magic_Fragment_Advanced"));
	SoulItems.EnlightedMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Enlighted", true).setTextureName("soulforest:Enlighted_Magic_Fragment_Half"));
	SoulItems.FireMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Fire", true).setTextureName("soulforest:Fire_Magic_Fragment_Half"));
	SoulItems.FlightMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Flight", true).setTextureName("soulforest:Flight_Magic_Fragment_Half"));
	SoulItems.FrozenMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Frozen", true).setTextureName("soulforest:Frozen_Magic_Fragment_Half"));
	SoulItems.HardenedMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Hardened", true).setTextureName("soulforest:Hardened_Magic_Fragment_Half"));
	SoulItems.PowerMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Power", true).setTextureName("soulforest:Power_Magic_Fragment_Half"));
	SoulItems.SharpMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Sharp", true).setTextureName("soulforest:Sharp_Magic_Fragment_Half"));
	SoulItems.ShinyMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Shiny", true).setTextureName("soulforest:Shiny_Magic_Fragment_Half"));
	SoulItems.SoulMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Soul", true).setTextureName("soulforest:Soul_Magic_Fragment_Half"));
	SoulItems.StrengthMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Strength", true).setTextureName("soulforest:Strength_Magic_Fragment_Half"));
	SoulItems.StrongMagicFragmentHalf = Optional.of(new ItemMagicFragment("Half", "Strong", true).setTextureName("soulforest:Strong_Magic_Fragment_Half"));
	SoulItems.BurnedMagicFragment = Optional.of(new ItemMagicFragment("", "Burned", true).setTextureName("soulforest:Burned_Magic_Fragment"));
	SoulItems.EnlightedMagicFragment = Optional.of(new ItemMagicFragment("", "Enlighted", true).setTextureName("soulforest:Enlighted_Magic_Fragment"));
	SoulItems.FireMagicFragment = Optional.of(new ItemMagicFragment("", "Fire", true).setTextureName("soulforest:Fire_Magic_Fragment"));
	SoulItems.FlightMagicFragment = Optional.of(new ItemMagicFragment("", "Flight", true).setTextureName("soulforest:Flight_Magic_Fragment"));
	SoulItems.FrozenMagicFragment = Optional.of(new ItemMagicFragment("", "Frozen", true).setTextureName("soulforest:Frozen_Magic_Fragment"));
	SoulItems.HardenedMagicFragment = Optional.of(new ItemMagicFragment("", "Hardened", true).setTextureName("soulforest:Hardened_Magic_Fragment"));
	SoulItems.HotMagicFragment = Optional.of(new ItemMagicFragment("", "Hot", true).setTextureName("soulforest:Hot_Magic_Fragment"));
	SoulItems.PowerMagicFragment = Optional.of(new ItemMagicFragment("", "Power", true).setTextureName("soulforest:Power_Magic_Fragment"));
	SoulItems.SharpMagicFragment = Optional.of(new ItemMagicFragment("", "Sharp", true).setTextureName("soulforest:Sharp_Magic_Fragment"));
	SoulItems.ShinyMagicFragment = Optional.of(new ItemMagicFragment("", "Shiny", true).setTextureName("soulforest:Shiny_Magic_Fragment"));
	SoulItems.SoulMagicFragment = Optional.of(new ItemMagicFragment("", "Soul", true).setTextureName("soulforest:Soul_Magic_Fragment"));
	SoulItems.StrengthMagicFragment = Optional.of(new ItemMagicFragment("", "Strength", true).setTextureName("soulforest:Strength_Magic_Fragment"));
	SoulItems.StrongMagicFragment =  Optional.of(new ItemMagicFragment("", "Strong", true).setTextureName("soulforest:Strong_Magic_Fragment"));

	SoulItems.SoulPotion =  Optional.of(new ItemPotion().setUnlocalizedName("soulpotion").setTextureName("potion").setCreativeTab(soul_forest.tabSoulOther));
	SoulItems.SoulPotion.get().setPotionEffect("potion.lavaimmunity");
	System.out.println("[Soul Forest] SoulItems initialised");
    }

    public static void initBlockDependantItems(){
	SoulItems.SoulBucket = 			Optional.of((new ItemBlackBucket(Blocks.air, "bucketSoul").setTextureName("soulforest:bucketSoul")));	
	SoulItems.BucketSoulWater = 		Optional.of((new ItemBlackBucket(SoulBlocks.SoulWaterMoving.get(), "bucketSoulWater").setTextureName("soulforest:bucketSoulWater").setContainerItem(SoulItems.SoulBucket.get())));
	SoulItems.ItemVineplant = 		Optional.of((new ItemVineplant(SoulBlocks.Vineplant.get(), "ItemVineplant")).setTextureName("soulforest:ItemVineplant"));
	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("soul water flow", 
		FluidContainerRegistry.BUCKET_VOLUME), 
		new ItemStack(SoulItems.BucketSoulWater.get()), 
		new ItemStack(SoulItems.SoulBucket.get()));
    }
}
