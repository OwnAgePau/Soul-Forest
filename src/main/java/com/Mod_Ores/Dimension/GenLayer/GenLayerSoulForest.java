package com.Mod_Ores.Dimension.GenLayer;

import java.util.List;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public abstract class GenLayerSoulForest extends GenLayer{

    public GenLayerSoulForest(long seed) {
    	super(seed);
    }

    public static GenLayer[] makeTheWorld(long seed) {
		/*GenLayer biomes = new GenLayerBiomeSoulForest(1L);
	
		// more GenLayerZoom = bigger biomes
		
		biomes = new GenLayerZoom(1300L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);	
	
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(50L, biomes);
	
		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);
	
		return new GenLayer[] {biomes, genlayervoronoizoom};*/
		
		int biomesize = 4;
		
		GenLayerSoulForest obj = new GenLayerSoulForestCreate(1L, false);
		obj = new GenLayerBiomeFuzzyZoom(2000L, (obj));
		for(int i = 1; i < 3; i++) { 
		    obj = new GenLayerBiomeZoom(2000L + i, (obj)); 
		}
		obj = GenLayerBiomeZoom.magnify(1000L, ((obj)), 0);
		obj = new GenLayerBiomeSoulForest(200L, ((obj)));
		obj = GenLayerBiomeZoom.magnify(1000L, ((obj)), 2);
		for(int j = 0; j < biomesize; j++) { 
		    obj = new GenLayerBiomeZoom(1000L + j, (obj)); 
		}
		GenLayerBiomeVoronoiZoom genlayervoronoizoom = new GenLayerBiomeVoronoiZoom(10L, ((obj)));
		(obj).initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);
		return (new GenLayer[] { obj, genlayervoronoizoom });
    }

    public static int getModdedBiomeSize(WorldType worldType, int original){
		WorldTypeEvent.BiomeSize event = new WorldTypeEvent.BiomeSize(worldType, original);
		MinecraftForge.TERRAIN_GEN_BUS.post(event);
		return event.newSize;
    }
}