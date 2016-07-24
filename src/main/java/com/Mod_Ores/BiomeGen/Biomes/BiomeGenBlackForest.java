package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityFurivoli;

public class BiomeGenBlackForest extends BiomeGenBase{
	private TheBiomeDeco customBiomeDecorator;
	
    public BiomeGenBlackForest(int par1){
        super(par1);
        this.topBlock = SoulBlocks.FyrisedSandGrass.get().getDefaultState();
        this.fillerBlock = SoulBlocks.FyrisedSand.get().getDefaultState();

        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityFurivoli.class, SoulConfigCreatures.furivoliSpawnFreq, SoulConfigCreatures.furivoliMinGroup, SoulConfigCreatures.furivoliMaxGroup));
        this.temperature = 1.0F;
        theBiomeDecorator = new TheBiomeDeco(this);
        customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
        customBiomeDecorator.soulfiresperchunk = 0;
        customBiomeDecorator.fireblossomsperchunk = 10;
        customBiomeDecorator.hardwoodtreeperchunk = 15;
    }
}