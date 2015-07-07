package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityKotek;

public class BiomeGenMaronaWoods extends BiomeGenBase{
    private WorldGenerator theWorldGenerator;
    private TheBiomeDeco customBiomeDecorator;

    public BiomeGenMaronaWoods(int par1){
	super(par1);
	this.topBlock = SoulBlocks.LateriteGrass.get();
	this.fillerBlock = SoulBlocks.LateriteDirt.get();

	spawnableMonsterList.clear();
	spawnableCreatureList.clear();
	spawnableCaveCreatureList.clear();
	spawnableWaterCreatureList.clear();
	this.temperature = 0.5F;
	spawnableMonsterList.add(new SpawnListEntry(EntityKotek.class, SoulConfigCreatures.kotekSpawnFreq, SoulConfigCreatures.kotekMinGroup, SoulConfigCreatures.kotekMaxGroup));
	theBiomeDecorator = new TheBiomeDeco(this);
	customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
	customBiomeDecorator.shrubperchunk = 80;
	customBiomeDecorator.soultreeperchunk = 200;
	customBiomeDecorator.tallgrasstype = 1;
	customBiomeDecorator.tallgrassperchunk = 200;
    }
}

