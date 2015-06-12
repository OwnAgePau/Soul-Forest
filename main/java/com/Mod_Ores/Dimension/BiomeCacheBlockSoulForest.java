package com.Mod_Ores.Dimension;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCacheBlockSoulForest{
    public float[] temperatureValues;
    public float[] rainfallValues;

    public BiomeGenBase[] biomes;

    public int xPosition;
    public int zPosition;

    public long lastAccessTime;

    final BiomeCacheSoulForest theBiomeCache;

    public BiomeCacheBlockSoulForest(BiomeCacheSoulForest par1BiomeCache, int par2, int par3){
        this.theBiomeCache = par1BiomeCache;
        this.temperatureValues = new float[256];
        this.rainfallValues = new float[256];
        this.biomes = new BiomeGenBase[256];
        this.xPosition = par2;
        this.zPosition = par3;
        BiomeCacheSoulForest.getChunkManager(par1BiomeCache).getTemperatures(this.temperatureValues, par2 << 4, par3 << 4, 16, 16);
        BiomeCacheSoulForest.getChunkManager(par1BiomeCache).getRainfall(this.rainfallValues, par2 << 4, par3 << 4, 16, 16);
        BiomeCacheSoulForest.getChunkManager(par1BiomeCache).getBiomeGenAt(this.biomes, par2 << 4, par3 << 4, 16, 16, false);
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2){
        return this.biomes[par1 & 15 | (par2 & 15) << 4];
    }
}