package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityFurivoli;

public class BiomeGenDarkCaverns extends BiomeGenBase
{
	private WorldGenerator theWorldGenerator;
	private TheBiomeDeco customBiomeDecorator;
	
    public BiomeGenDarkCaverns(int par1)
    {
        super(par1);
        this.topBlock = SoulBlocks.FyrisedSandGrass.get();
        this.fillerBlock = SoulBlocks.FyrisedSand.get();

        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityFurivoli.class, SoulConfigCreatures.furivoliSpawnFreq * 4, SoulConfigCreatures.furivoliMinGroup, SoulConfigCreatures.furivoliMaxGroup));
        this.temperature = 1.0F;
        theBiomeDecorator = new TheBiomeDeco(this);
        customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
        customBiomeDecorator.soulfiresperchunk = 0;
        customBiomeDecorator.fireblossomsperchunk = 20;
        customBiomeDecorator.darkaltarsperchunk = 1;
        customBiomeDecorator.titaniumtowersperchunk = 1;
    }
}

