package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityFurivoli;
import com.Mod_Ores.Mobs.Entity.EntityKotek;

public class BiomeGenFyrisedShrubbery extends BiomeGenBase {
    private TheBiomeDeco customBiomeDecorator;

    public BiomeGenFyrisedShrubbery(int par1){
		super(par1);
		this.topBlock = SoulBlocks.FyrisedSandGrass.get().getDefaultState();
		this.fillerBlock = SoulBlocks.FyrisedSand.get().getDefaultState();
	
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableWaterCreatureList.clear();
		this.temperature = 0.5F;
		spawnableMonsterList.add(new SpawnListEntry(EntityFurivoli.class, SoulConfigCreatures.furivoliSpawnFreq, SoulConfigCreatures.furivoliMinGroup, SoulConfigCreatures.furivoliMaxGroup));
		theBiomeDecorator = new TheBiomeDeco(this);
		customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
		customBiomeDecorator.fireblossomsperchunk = 80;
		customBiomeDecorator.fyrisedbushperchunk = 100;
    }
}