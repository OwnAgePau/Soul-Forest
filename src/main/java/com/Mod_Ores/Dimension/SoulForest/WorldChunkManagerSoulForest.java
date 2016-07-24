package com.Mod_Ores.Dimension.SoulForest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Dimension.GenLayer.GenLayerSoulForest;

public class WorldChunkManagerSoulForest extends WorldChunkManager{
    private GenLayer myGenBiomes;
    private GenLayer myBiomeIndexLayer;
    private BiomeCache myBiomeCache;
    private List<BiomeGenBase> myBiomesToSpawnIn;

    public WorldChunkManagerSoulForest(){
		this.myBiomeCache = new BiomeCache(this);
		this.myBiomesToSpawnIn = new ArrayList<BiomeGenBase>();
		this.myBiomesToSpawnIn.add(soul_forest.SoulForest);
		this.myBiomesToSpawnIn.add(soul_forest.FrozenPlains);
		this.myBiomesToSpawnIn.add(soul_forest.PeatBog);
		this.myBiomesToSpawnIn.add(soul_forest.SoulShrubbery);
		this.myBiomesToSpawnIn.add(soul_forest.ShinaiForest);
    }

    public WorldChunkManagerSoulForest(long par1, WorldType par3WorldType){
		this();
		GenLayer[] agenlayer = GenLayerSoulForest.makeTheWorld(par1);
		this.myGenBiomes = agenlayer[0];
		this.myBiomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerSoulForest(World par1World){
    	this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType());
    }

    public List<BiomeGenBase> getBiomesToSpawnIn(){
    	return this.myBiomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenerator(BlockPos pos){
        return this.getBiomeGenerator(pos, (BiomeGenBase)null);
    }

    public BiomeGenBase getBiomeGenerator(BlockPos pos, BiomeGenBase biomeGenBaseIn){
        return this.myBiomeCache.func_180284_a(pos.getX(), pos.getZ(), biomeGenBaseIn);
    }

    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5){
		IntCache.resetIntCache();
	
		if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5){
		    par1ArrayOfFloat = new float[par4 * par5];
		}
	
		int[] aint = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);
	
		for (int i1 = 0; i1 < par4 * par5; ++i1){
		    float f = (float)BiomeGenBase.getBiomeGenArray()[aint[i1]].getIntRainfall() / 65536.0F;
	
		    if (f > 1.0F){
		    	f = 1.0F;
		    }
	
		    par1ArrayOfFloat[i1] = f;
		}
	
		return par1ArrayOfFloat;
    }

    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(float par1, int par2){
    	return par1;
    }

    public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5){
		IntCache.resetIntCache();
	
		if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5){
		    par1ArrayOfFloat = new float[par4 * par5];
		}
	
		int[] aint = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);
	
		for (int i1 = 0; i1 < par4 * par5; ++i1){
		    float f = (float)BiomeGenBase.getBiomeGenArray()[aint[i1]].getFloatTemperature(new BlockPos(par2, par3, par4)) / 65536.0F;
	
		    if (f > 1.0F){
		    	f = 1.0F;
		    }
	
		    par1ArrayOfFloat[i1] = f;
		}
	
		return par1ArrayOfFloat;
    }

    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5){
		IntCache.resetIntCache();
	
		if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5){
		    par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
		}
	
		int[] var6 = this.myGenBiomes.getInts(par2, par3, par4, par5);
	
		for (int var7 = 0; var7 < par4 * par5; ++var7){
		    par1ArrayOfBiomeGenBase[var7] = BiomeGenBase.getBiomeGenArray()[var6[var7]];
		}
	
		return par1ArrayOfBiomeGenBase;
	}
	
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5){
		return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
	}
	
	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6){
		IntCache.resetIntCache();
	
		if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5){
		    par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
		}
	
		if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0){
		    BiomeGenBase[] var9 = this.myBiomeCache.getCachedBiomes(par2, par3);
		    System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
		    return par1ArrayOfBiomeGenBase;
		}
		else{
		    int[] var7 = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);
	
		    for (int var8 = 0; var8 < par4 * par5; ++var8){
		    	par1ArrayOfBiomeGenBase[var8] = BiomeGenBase.getBiomeGenArray()[var7[var8]];
		    }
	
		    return par1ArrayOfBiomeGenBase;
		}
    }

    public boolean areBiomesViable(int par1, int par2, int par3, List par4List){
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.myGenBiomes.getInts(l, i1, l1, i2);
	
		for (int j2 = 0; j2 < l1 * i2; ++j2){
		    BiomeGenBase biomegenbase = BiomeGenBase.getBiomeGenArray()[aint[j2]];
	
		    if (!par4List.contains(biomegenbase)){
		    	return false;
		    }
		}
	
		return true;
    }

    public BlockPos findBiomePosition(int x, int z, int range, List<BiomeGenBase> biomes, Random random){
        IntCache.resetIntCache();
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.myGenBiomes.getInts(i, j, i1, j1);
        BlockPos blockpos = null;
        int k1 = 0;

        for (int l1 = 0; l1 < i1 * j1; ++l1){
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[l1]);

            if (biomes.contains(biomegenbase) && (blockpos == null || random.nextInt(k1 + 1) == 0)){
                blockpos = new BlockPos(i2, 0, j2);
                ++k1;
            }
        }

        return blockpos;
    }
	
	public void cleanupCache(){
		this.myBiomeCache.cleanupCache();
    }
}