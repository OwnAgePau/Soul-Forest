package com.Mod_Ores.Dimension.GenLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.Mod_Ores.soul_forest;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class GenLayerBiomeSoulForest extends GenLayerSoulForest {

    protected BiomeGenBase[] allowedBiomes = {
	    soul_forest.SoulForest, soul_forest.PeatBog, soul_forest.BlackForest, soul_forest.DarkCaverns,
	    soul_forest.MaronaWoods, soul_forest.SoulShrubbery, soul_forest.FyrisedShrubbery,
    };

    protected List<BiomeEntry> weightedBiomes = Arrays.asList(
	    new BiomeEntry(soul_forest.SoulForest, 10),
	    new BiomeEntry(soul_forest.PeatBog, 9),
	    new BiomeEntry(soul_forest.BlackForest, 9),
	    new BiomeEntry(soul_forest.DarkCaverns, 8),
	    new BiomeEntry(soul_forest.MaronaWoods, 8),
	    new BiomeEntry(soul_forest.SoulShrubbery, 9),
	    new BiomeEntry(soul_forest.FyrisedShrubbery, 10)
	    );

    public GenLayerBiomeSoulForest(long seed, GenLayerSoulForest genlayer) {
	super(seed);
	this.parent = genlayer;
    }

    public GenLayerBiomeSoulForest(long seed) {
	super(seed);
    }

    /*protected BiomeEntry getWeightedBiomeEntry(BiomeManager.BiomeType type){
	List<BiomeEntry> biomeList = this.weightedBiomes;
	int totalWeight = WeightedRandom.getTotalWeight(biomeList);
	int weight = BiomeManager.isTypeListModded(type)?nextInt(totalWeight):nextInt(totalWeight / 10) * 10;
	return (BiomeEntry)WeightedRandom.getItem(biomeList, weight);
    }*/

    /*@Override
    public int[] getInts(int x, int z, int width, int depth){
	int[] dest = IntCache.getIntCache(width*depth);

	for (int dz=0; dz<depth; dz++){
	    for (int dx=0; dx<width; dx++){
		this.initChunkSeed(dx+x, dz+z);
		dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
	    }
	}
	return dest;
    }*/

    @Override
    public int[] getInts(int par1, int par2, int par3, int par4){
	int[] var5 = this.parent.getInts(par1, par2, par3, par4);
	int[] var6 = IntCache.getIntCache(par3 * par4);

	for (int var7 = 0; var7 < par4; ++var7){
	    for (int var8 = 0; var8 < par3; ++var8){
		this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
		int var9 = var5[var8 + var7 * par3];
		var6[var8 + var7 * par3] = getWeightedBiomeFromList(this.weightedBiomes);
	    }
	}
	return var6;
    }

    private int getWeightedBiomeFromList(List<BiomeEntry> biomeList){
	int totalWeight = WeightedRandom.getTotalWeight(biomeList);
	
	long randomLong = this.nextLong(totalWeight / 10);
	System.out.println("Total Weight : " + totalWeight + ", Random Long : " + randomLong);
	int randomNr = (int)randomLong * 10;
	BiomeEntry entry = (BiomeEntry)WeightedRandom.getItem(biomeList, randomNr);
	System.out.println(entry.biome.biomeName);
	int biomeID = entry.biome.biomeID;
	return ((BiomeEntry)WeightedRandom.getItem(biomeList, (int)this.nextLong(WeightedRandom.getTotalWeight(biomeList) / 10) * 10)).biome.biomeID;
    }
}
