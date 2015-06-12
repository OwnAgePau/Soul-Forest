package com.Mod_Ores.Init.Config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class SoulConfig {
    public static Configuration config;

    //>>DIMENSION ID<<
    public static int SoulForestID;
    // Enchantment ID's
    public static int ENCfrostID;
    public static int ENCenhancedID;
    // Biome ID's
    public static int BIOsoulForestID; 
    public static int BIOfrostCavesID; 
    public static int BIOpeatBogID; 
    public static int BIOfrozenPlainsID; 
    public static int BIOmaronaWoodsID; 
    public static int BIOdarkCavernsID; 
    public static int BIOblackForestID;
    public static int BIOsoulShrubberyID;
    public static int BIOfyrisedShrubberyID;

    public static void init(File configFile){
	config = new Configuration(configFile);
	try{ // Configurations	
	    config.load();			
	    //>>DIMENSION ID<<
	    SoulForestID = config.get("Dimension ID", "Soul Forest Dimension", 20).getInt();

	    // Enchantment ID's
	    ENCfrostID = config.get("Enchantment ID's", "Frost Enchantment", 36).getInt();
	    ENCenhancedID = config.get("Enchantment ID's", "Enhanced Enchantment", 37).getInt();

	    // Biome ID's
	    BIOsoulForestID = config.get("Biome ID's", "Soul Forest Biome", 100).getInt();
	    BIOfrostCavesID = config.get("Biome ID's", "Frost Caves Biome", 101).getInt();
	    BIOpeatBogID = config.get("Biome ID's", "Peat Bog Biome", 102).getInt();
	    BIOfrozenPlainsID = config.get("Biome ID's", "Frozen Plains Biome", 103).getInt();
	    BIOmaronaWoodsID = config.get("Biome ID's", "Marona Woods Biome", 104).getInt();
	    BIOdarkCavernsID = config.get("Biome ID's", "Dark Caverns Biome", 105).getInt();
	    BIOblackForestID = config.get("Biome ID's", "Black Forest Biome", 106).getInt();		
	    BIOsoulShrubberyID = config.get("Biome ID's", "Soul Shrubbery Biome", 107).getInt();
	    BIOfyrisedShrubberyID = config.get("Biome ID's", "Fyrised Shrubbery Biome", 108).getInt();	
	    //FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[Soul Forest] [soulforest] Generated Config!");
	}
	catch (Exception e){
	    //FMLLog.Log(Level.SEVERE, e.toString(), new Object[]{"Soul Forest : ", " Has had a problem loading its configuration"});
	}
	finally{
	    if (config.hasChanged()) {
		config.save();
	    }
	}
    }
}