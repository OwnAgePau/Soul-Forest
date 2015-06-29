package com.Mod_Ores.Dimension;

import java.util.ArrayList;
import java.util.List;

import com.Mod_Ores.Dimension.SoulForest.WorldChunkManagerSoulForest;

import net.minecraft.util.LongHashMap;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCacheSoulForest{
    private final WorldChunkManagerSoulForest chunkManager;

    private long lastCleanupTime = 0L;

    private LongHashMap cacheMap = new LongHashMap();

    private List cache = new ArrayList();

    public BiomeCacheSoulForest(WorldChunkManagerSoulForest par1WorldChunkManager){
        this.chunkManager = par1WorldChunkManager;
    }

    public BiomeCacheBlockSoulForest getBiomeCacheBlock(int par1, int par2){
        par1 >>= 4;
        par2 >>= 4;
        long k = (long)par1 & 4294967295L | ((long)par2 & 4294967295L) << 32;
        BiomeCacheBlockSoulForest biomecacheblock = (BiomeCacheBlockSoulForest)this.cacheMap.getValueByKey(k);

        if (biomecacheblock == null){
            biomecacheblock = new BiomeCacheBlockSoulForest(this, par1, par2);
            this.cacheMap.add(k, biomecacheblock);
            this.cache.add(biomecacheblock);
        }

        biomecacheblock.lastAccessTime = System.currentTimeMillis();
        return biomecacheblock;
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2){
        return this.getBiomeCacheBlock(par1, par2).getBiomeGenAt(par1, par2);
    }

    public void cleanupCache(){
        long i = System.currentTimeMillis();
        long j = i - this.lastCleanupTime;

        if (j > 7500L || j < 0L){
            this.lastCleanupTime = i;

            for (int k = 0; k < this.cache.size(); ++k){
            	BiomeCacheBlockSoulForest biomecacheblock = (BiomeCacheBlockSoulForest)this.cache.get(k);
                long l = i - biomecacheblock.lastAccessTime;

                if (l > 30000L || l < 0L){
                    this.cache.remove(k--);
                    long i1 = (long)biomecacheblock.xPosition & 4294967295L | ((long)biomecacheblock.zPosition & 4294967295L) << 32;
                    this.cacheMap.remove(i1);
                }
            }
        }
    }

    public BiomeGenBase[] getCachedBiomes(int par1, int par2){
        return this.getBiomeCacheBlock(par1, par2).biomes;
    }

    static WorldChunkManagerSoulForest getChunkManager(BiomeCacheSoulForest par0BiomeCache){
        return par0BiomeCache.chunkManager;
    }
}
