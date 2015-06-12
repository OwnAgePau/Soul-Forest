package com.Mod_Ores.Dimension.GenLayer;

import com.Mod_Ores.soul_forest;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeSoulForest extends GenLayer {

    protected BiomeGenBase[] allowedBiomes = {
	    soul_forest.SoulForest, soul_forest.FrostCaves, soul_forest.PeatBog, 
	    soul_forest.BlackForest, soul_forest.DarkCaverns, soul_forest.FrozenPlains, 
	    soul_forest.MaronaWoods, soul_forest.SoulShrubbery, soul_forest.FyrisedShrubbery
	    };

    public GenLayerBiomeSoulForest(long seed, GenLayer genlayer) {
	super(seed);
	this.parent = genlayer;
    }

    public GenLayerBiomeSoulForest(long seed) {
	super(seed);
    }


    @Override
    public int[] getInts(int x, int z, int width, int depth){
	int[] dest = IntCache.getIntCache(width*depth);

	for (int dz=0; dz<depth; dz++){
	    for (int dx=0; dx<width; dx++){
		this.initChunkSeed(dx+x, dz+z);
		dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
	    }
	}

	return dest;
    }
}
