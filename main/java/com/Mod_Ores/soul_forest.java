package com.Mod_Ores;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

import com.Mod_Ores.BiomeGen.Biomes.BiomeGenBlackForest;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenDarkCaverns;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenFrostCaves;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenFrozenPlains;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenFyrisedShrubbery;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenMaronaWoods;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenPeatBog;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenSoulForest;
import com.Mod_Ores.BiomeGen.Biomes.BiomeGenSoulShrubbery;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulGrass;
import com.Mod_Ores.Dimension.WorldProviderSoulForest;
import com.Mod_Ores.Enchantments.EnchantmentEnhanced;
import com.Mod_Ores.Enchantments.EnchantmentFrost;
import com.Mod_Ores.EventHandlers.CommonTickHandler;
import com.Mod_Ores.EventHandlers.CraftingHandler;
import com.Mod_Ores.EventHandlers.ForgeHookEventHelper;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.InitBlocks;
import com.Mod_Ores.Init.InitEntities;
import com.Mod_Ores.Init.InitItems;
import com.Mod_Ores.Init.InitRecipes;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfig;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Items.SoulPotion;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid="soulforest", name="Soul Forest Mod", version="1.9.6")
/*@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec =
@SidedPacketHandler(channels = {"soul_forest" }, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"soul_forest" }, packetHandler = ServerPacketHandler.class))
 */
public class soul_forest{
    @Instance("soulforest") // instance
    public static soul_forest instance;

    public static String MODID = "soulforest";
    public static String VERSION = "1.9.6";

    @SidedProxy(clientSide="com.Mod_Ores.ClientProxy", serverSide="com.Mod_Ores.CommonProxy")
    public static CommonProxy proxy;

    static int startEntityId = 300;

    private IGuiHandlerCustom guiHandler = new IGuiHandlerCustom();
    public static CraftingHandler craftHandler = new CraftingHandler();

    public static String configPath;
    public static File config;
    public static File configCreatures;
    public static File configItems;
    public static File configBlocks;

    // Enchantments
    public static Enchantment enchantmentFrost;
    public static Enchantment enchantmentEnhanced;

    // Creative Tabs
    public static CreativeTabs tabSoulTools;
    public static CreativeTabs tabSoulGems;
    public static CreativeTabs tabSoulBlocks;
    public static CreativeTabs tabSoulOther;
    public static CreativeTabs tabSoulBerries;

    // Biomes
    public static BiomeGenBase BlackForest;
    public static BiomeGenBase DarkCaverns;
    public static BiomeGenBase FrostCaves;
    public static BiomeGenBase FrozenPlains;
    public static BiomeGenBase MaronaWoods;
    public static BiomeGenBase PeatBog;
    public static BiomeGenBase SoulForest;
    public static BiomeGenBase SoulShrubbery;
    public static BiomeGenBase FyrisedShrubbery;

    // Potions
    public static Potion lavaImmunity;

    // Random chest loot for inside Ice Towers
    public static WeightedRandomChestContent[] iceTowerChestContent;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {		
	//Creative Tabs Icons
	tabSoulTools = new CreativeTabs("tabSoulTools") {
	    public Item getTabIconItem() {
		return SoulItems.FyrisedHelmet.get();
	    }};
	    tabSoulGems = new CreativeTabs("tabSoulGems") {
		public Item getTabIconItem() {
		    return SoulItems.AquamarineGem.get();
		}
	    };					
	    tabSoulBlocks = new CreativeTabs("tabSoulBlocks") {
		public Item getTabIconItem() {
		    return Item.getItemFromBlock(SoulBlocks.SoulSnowTop.get()); 
		}
	    };	
	    tabSoulOther = new CreativeTabs("tabSoulOther") {
		public Item getTabIconItem() {
		    return SoulItems.PolisherTowel.get(); 
		}
	    };	
	    tabSoulBerries = new CreativeTabs("tabSoulBerries") {
		public Item getTabIconItem() {
		    return Item.getItemFromBlock(SoulBlocks.Blackberry.get()); 
		}
	    };		

	    // Potion array length increased
	    Potion[] potionTypes = null;
	    for (Field f : Potion.class.getDeclaredFields()) {
		f.setAccessible(true);
		try {
		    if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
			Field modfield = Field.class.getDeclaredField("modifiers");
			modfield.setAccessible(true);
			modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
			potionTypes = (Potion[])f.get(null);
			final Potion[] newPotionTypes = new Potion[256];
			System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
			f.set(null, newPotionTypes);
		    }
		} catch (Exception e) {
		    System.err.println("Severe error while adding potions, please report this to the mod author:");
		    System.err.println(e);
		}
	    }

	    // Configuration and Initialization
	    this.configPath = event.getModConfigurationDirectory() + "/soulforest/";
	    config = new File(this.configPath + "soulmain.cfg");
	    configCreatures = new File(this.configPath + "soulcreatures.cfg");
	    SoulConfig.init(config);
	    SoulConfigCreatures.init(configCreatures);
	    InitItems.init();
	    InitBlocks.init();
	    InitItems.initBlockDependantItems();
	    InitBlocks.initItemBlockDependantBlocks();
	    InitRecipes.init();
	    InitAchievements.init();	
	    InitEntities.init();

	    // WeightedRandomChestContent(item, metadeta, min, max, chance)
	    this.iceTowerChestContent = new WeightedRandomChestContent[] {
		    new WeightedRandomChestContent(SoulItems.FrostShard.get(), 0, 3, 7, 10), 
		    new WeightedRandomChestContent(SoulItems.BurnedShard.get(), 0, 3, 7, 10), 
		    new WeightedRandomChestContent(SoulItems.Soul.get(), 0, 3, 7, 10), 
		    new WeightedRandomChestContent(SoulItems.LightShard.get(), 0, 3, 7, 10), 
		    new WeightedRandomChestContent(SoulItems.FrostFragment.get(), 0, 1, 2, 8), 
		    new WeightedRandomChestContent(SoulItems.BurnedFragment.get(), 0, 1, 2, 8), 
		    new WeightedRandomChestContent(SoulItems.SoulFragment.get(), 0, 1, 2, 8), 
		    new WeightedRandomChestContent(SoulItems.LightFragment.get(), 0, 1, 2, 8), 
		    new WeightedRandomChestContent(SoulItems.FrozenMagicFragmentHalf.get(), 0, 1, 1, 6), 
		    new WeightedRandomChestContent(SoulItems.FrozenMagicFragmentAdv.get(), 0, 1, 1, 4), 
		    new WeightedRandomChestContent(SoulItems.FrostWand.get(), 0, 1, 1, 1), 
		    new WeightedRandomChestContent(SoulItems.FrozenRod.get(), 0, 1, 4, 7), 
		    new WeightedRandomChestContent(SoulItems.FrozenStick.get(), 0, 1, 4, 7), 
		    new WeightedRandomChestContent(SoulItems.BlackdiamondGem.get(), 0, 1, 3, 2), 
		    new WeightedRandomChestContent(SoulItems.AmethystGem.get(), 0, 3, 6, 7), 
		    new WeightedRandomChestContent(SoulItems.CranberryMuffin.get(), 0, 1, 5, 7), 
		    new WeightedRandomChestContent(SoulItems.BaneberryCake.get(), 0, 1, 1, 8), 
		    new WeightedRandomChestContent(SoulItems.WhiteopalGem.get(), 0, 4, 19, 10), 
		    new WeightedRandomChestContent(SoulItems.Polisher.get(), 0, 3, 12, 7), 
		    new WeightedRandomChestContent(SoulItems.PolisherTowel.get(), 0, 4, 19, 9), 
		    new WeightedRandomChestContent(SoulItems.TitaniumGem.get(), 0, 1, 2, 1), 
		    new WeightedRandomChestContent(SoulItems.OnyxGem.get(), 0, 1, 2, 1), 
		    new WeightedRandomChestContent(SoulItems.BerryCollector.get(), 0, 1, 1, 5), 
		    new WeightedRandomChestContent(SoulItems.CitrineGem.get(), 0, 4, 19, 10), 
		    new WeightedRandomChestContent(SoulItems.SteelSword.get(), 0, 1, 1, 4), 
		    new WeightedRandomChestContent(SoulItems.OpalGem.get(), 0, 4, 19, 9), 
		    new WeightedRandomChestContent(SoulItems.OlivineGem.get(), 0, 5, 14, 6)};

	    this.lavaImmunity = (new SoulPotion(50, false, 8356754)).setPotionName("potion.lavaimmunity");
    }

    @EventHandler
    public void load(FMLInitializationEvent ev){			
	// Enchantment
	enchantmentFrost = new EnchantmentFrost(SoulConfig.ENCfrostID, 10, EnumEnchantmentType.weapon);
	enchantmentEnhanced = new EnchantmentEnhanced(SoulConfig.ENCenhancedID, 7, EnumEnchantmentType.weapon);

	//Special Registers
	GameRegistry.registerWorldGenerator(new WorldGeneratorOres(), 2); 	// WorldGenerator Registry
	NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler); 		//GUI Registry
	FMLCommonHandler.instance().bus().register(craftHandler);
	MinecraftForge.EVENT_BUS.register(craftHandler);
	FMLCommonHandler.instance().bus().register(proxy);
	FMLCommonHandler.instance().bus().register(new CommonTickHandler(Minecraft.getMinecraft())); // Tick Handler
	FMLCommonHandler.instance().bus().register(new SoulForestKeyHandler()); // Key Handler
	MinecraftForge.EVENT_BUS.register(new ForgeHookEventHelper()); // Event Helper
	proxy.registerRenderers();	

	//Dimension
	DimensionManager.registerProviderType(SoulConfig.SoulForestID, WorldProviderSoulForest.class, false); // Provider Registry
	DimensionManager.registerDimension(SoulConfig.SoulForestID, SoulConfig.SoulForestID);	// Dimension Registry

	//Biomes
	this.FrostCaves = 	(new BiomeGenFrostCaves(SoulConfig.BIOfrostCavesID).setBiomeName("Frost Caves").setEnableSnow().setTemperatureRainfall(0.03F, 1.0F).setHeight(new Height(0.9F, 0.1F)));
	this.FrozenPlains = 	(new BiomeGenFrozenPlains(SoulConfig.BIOfrozenPlainsID).setBiomeName("Frozen Plains").setEnableSnow().setTemperatureRainfall(0.03F, 1.0F).setHeight(new Height(0.0F, 0.9F)));
	this.DarkCaverns = 	(new BiomeGenDarkCaverns(SoulConfig.BIOdarkCavernsID).setBiomeName("Dark Caverns").setTemperatureRainfall(1.0F, 1.0F).setHeight(new Height(0.0F, 1.0F)));
	this.BlackForest = 	(new BiomeGenBlackForest(SoulConfig.BIOblackForestID).setBiomeName("Black Forest").setTemperatureRainfall(1.0F, 1.0F).setHeight(new Height(0.0F, 0.5F)));
	this.PeatBog = 		(new BiomeGenPeatBog(SoulConfig.BIOpeatBogID).setBiomeName("Peat Bog").setTemperatureRainfall(0.5F, 1.0F).setHeight(new Height(0.0F, 0.5F)));
	this.SoulForest = 	(new BiomeGenSoulForest(SoulConfig.BIOsoulForestID).setBiomeName("Soul Forest").setTemperatureRainfall(0.5F, 1.0F).setHeight(new Height(0.0F, 0.9F)));
	this.MaronaWoods = 	(new BiomeGenMaronaWoods(SoulConfig.BIOmaronaWoodsID).setBiomeName("Marona Woods").setTemperatureRainfall(0.5F, 1.0F).setHeight(new Height(0.0F, 0.5F)));
	this.SoulShrubbery = 	(new BiomeGenSoulShrubbery(SoulConfig.BIOsoulShrubberyID).setBiomeName("Soul Shrubbery").setTemperatureRainfall(0.5F, 1.0F).setHeight(new Height(0.0F, 0.5F)));
	this.FyrisedShrubbery = (new BiomeGenFyrisedShrubbery(SoulConfig.BIOfyrisedShrubberyID).setBiomeName("Fyrised Shrubbery").setTemperatureRainfall(1.0F, 1.0F).setHeight(new Height(0.0F, 0.5F)));
    }

    /**
     * 
     * @param par1Random the random object
     * @param par2 the int value (1 = for normal tall grasses, 2 = for frozen tall grass)
     * @return
     */
    public static WorldGenSoulGrass getRandomWorldGenForGrass(Random par1Random, int par2){
	Block block = null;

	if(par2 == 1 || par2 == 3){	    	
	    if(par1Random.nextInt(5) == 0){
		block = SoulBlocks.BogTallGrassBrown.get();
	    }
	    else if(par1Random.nextInt(4) == 0){
		block = SoulBlocks.BogTallGrassGrey.get();
	    }
	    else{
		block = SoulBlocks.BogTallGrassGreen.get();
	    }
	}
	else if(par2 == 2){
	    block = SoulBlocks.FrozenTallGrass.get();
	}

	if(par2 == 3){
	    if(par1Random.nextInt(4) == 2){
		block = SoulBlocks.BogTallGrassPurple.get();
	    }
	}

	return new WorldGenSoulGrass(block, 0);
    }

    /**
     * In here a unique entity ID will be found
     */
    public static int getUniqueEntityId() {
	do{
	    startEntityId++;
	} 
	while (EntityList.getStringFromID(startEntityId) != null);{
	    return startEntityId;
	}
    }

    /**
     * In here an entity egg will be registered
     */	
    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
	int id = getUniqueEntityId();
	EntityList.IDtoClassMapping.put(id, entity);
	EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }

    /**
     * In here fuel can be added to a normal furnace
     */
    public int addFuel(int i, int j){
	/*if (i == SoulItems.UraniumLiquid)
	{
	    return 16000;
	}*/
	return 0;
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }

    /**
     * In here this mods version will be set
     */
    public String getVersion(){
	return this.VERSION;
    }
}