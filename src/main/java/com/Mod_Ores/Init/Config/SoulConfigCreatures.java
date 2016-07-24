package com.Mod_Ores.Init.Config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.config.Configuration;

public class SoulConfigCreatures {
   
    public static Configuration config;

    // Damage
    public static int kotekDamage;
    public static int kingKotekDamage;
    public static int exclosDamage;
    public static int furivoliDamage;
    public static int yetiDamage; 
    public static int icefairyDamage; 
    public static int groundhogDamage;
    public static int iceQueenDamage;

    // Health
    public static int kotekHealth;
    public static int kingKotekHealth;
    public static int exclosHealth;
    public static int furivoliHealth;
    public static int yetiHealth; 
    public static int icefairyHealth; 
    public static int groundhogHealth;
    public static int iceQueenHealth;

    // Follow Range
    public static int icefairyFollowRange;

    // Speed
    public static double yetiMovement; 
    public static double icefairyMovement; 
    public static double groundhogMovement;

    // Knockback Resistance
    public static int furivoliKnockback;
    public static int groundhogKnockback;

    // Min Group Ammount
    public static int kotekMinGroup;
    public static int exclosMinGroup;
    public static int furivoliMinGroup;
    public static int yetiMinGroup; 
    public static int icefairyMinGroup; 
    public static int groundhogMinGroup;

    // Max Group Ammount
    public static int kotekMaxGroup;
    public static int exclosMaxGroup;
    public static int furivoliMaxGroup;
    public static int yetiMaxGroup; 
    public static int icefairyMaxGroup; 
    public static int groundhogMaxGroup;

    // Spawn Frequency
    public static int kotekSpawnFreq;
    public static int exclosSpawnFreq;
    public static int furivoliSpawnFreq;
    public static int yetiSpawnFreq; 
    public static int icefairySpawnFreq; 
    public static int groundhogSpawnFreq;

    public static void init(File configFile){
		config = new Configuration(configFile);
	
		try{
		    config.load();
	
		    // Configurations
		    // Kotek
		    kotekDamage = config.get("Kotek", "Base Damage", 10).getInt();
		    kotekHealth = config.get("Kotek", "Base Health", 10, "The health of the smallest slime (the health is multiplied with the size)").getInt();		
		    kotekMinGroup = config.get("Kotek", "Minimum Group Size", 8).getInt();
		    kotekMaxGroup = config.get("Kotek", "Maximum Group Size", 10).getInt();
		    kotekSpawnFreq = config.get("Kotek", "Spawn Frequency", 20).getInt();
	
		    // King Kotek
		    kingKotekDamage = config.get("King Kotek", "Base Damage", 50).getInt();
		    kingKotekHealth = config.get("King Kotek", "Base Health", 200).getInt();	
		    
		    // Ice Queen
		    iceQueenDamage = config.get("Ice Queen", "Base Damage", 60).getInt();
		    iceQueenHealth = config.get("Ice Queen", "Base Health", 500).getInt();
	
		    // Exclos
		    exclosDamage = config.get("Exclos", "Base Damage", 25).getInt();
		    exclosHealth = config.get("Exclos", "Base Health", 70).getInt();		
		    exclosMinGroup = config.get("Exclos", "Minimum Group Size", 8).getInt();
		    exclosMaxGroup = config.get("Exclos", "Maximum Group Size", 10).getInt();
		    exclosSpawnFreq = config.get("Exclos", "Spawn Frequency", 5).getInt();
	
		    // Yeti
		    yetiDamage = config.get("Yeti", "Base Damage", 14).getInt();
		    yetiHealth = config.get("Yeti", "Base Health", 60).getInt();		
		    yetiMovement = config.get("Yeti", "Movement Speed Factor", 0.5D).getDouble();	
		    yetiMinGroup = config.get("Yeti", "Minimum Group Size", 8).getInt();
		    yetiMaxGroup = config.get("Yeti", "Maximum Group Size", 10).getInt();
		    yetiSpawnFreq = config.get("Yeti", "Spawn Frequency", 5).getInt();
	
		    // Ice Fairy
		    icefairyDamage = config.get("Ice Fairy", "Base Damage", 30).getInt();
		    icefairyHealth = config.get("Ice Fairy", "Base Health", 10).getInt();
		    icefairyMovement = config.get("Ice Fairy", "Movement Speed Factor", 0.3D).getDouble();	
		    icefairyFollowRange = config.get("Ice Fairy", "Follow Range", 40).getInt();
		    icefairyMinGroup = config.get("Ice Fairy", "Minimum Group Size", 5).getInt();
		    icefairyMaxGroup = config.get("Ice Fairy", "Maximum Group Size", 7).getInt();
		    icefairySpawnFreq = config.get("Ice Fairy", "Spawn Frequency", 5).getInt();
	
		    // Groundhog
		    groundhogDamage = config.get("Groundhog", "Base Damage", 20).getInt();
		    groundhogHealth = config.get("Groundhog", "Base Health", 80).getInt();		
		    groundhogMovement = config.get("Groundhog", "Movement Speed Factor", 0.2D).getDouble();
		    groundhogKnockback = config.get("Groundhog", "Knockback Resistance", 30).getInt();
		    groundhogMinGroup = config.get("Groundhog", "Minimum Group Size", 1).getInt();
		    groundhogMaxGroup = config.get("Groundhog", "Maximum Group Size", 1).getInt();
		    groundhogSpawnFreq = config.get("Groundhog", "Spawn Frequency", 3).getInt();
	
		    // Furivoli
		    furivoliDamage = config.get("Furivoli", "Base Damage", 18).getInt();
		    furivoliHealth = config.get("Furivoli", "Base Health", 60).getInt();		
		    furivoliKnockback = config.get("Furivoli", "Knockback Resistance", 40).getInt();
		    furivoliMinGroup = config.get("Furivoli", "Minimum Group Size", 0).getInt();
		    furivoliMaxGroup = config.get("Furivoli", "Maximum Group Size", 1).getInt();
		    furivoliSpawnFreq = config.get("Furivoli", "Spawn Frequency", 1).getInt();
	
	
		    //FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[Soul Forest] [ConfigCreature] Generated Config!");
		}
		catch (Exception e){
		    //FMLLog.log(Level.SEVERE, e, "Soul Forest has had a problem loading its configuration : [ConfigCreature]");
		}
		finally{
		    if (config.hasChanged()) {
		    	config.save();
		    }
		}
    }
}
