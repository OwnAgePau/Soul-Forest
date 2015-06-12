package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityKotek;

public class BiomeGenSoulShrubbery  extends BiomeGenBase {
    private TheBiomeDeco customBiomeDecorator;

    public BiomeGenSoulShrubbery(int par1){
	super(par1);
	this.topBlock = SoulBlocks.BogGrass.get();
	this.fillerBlock = SoulBlocks.BogDirt.get();

	spawnableMonsterList.clear();
	spawnableCreatureList.clear();
	spawnableCaveCreatureList.clear();
	spawnableWaterCreatureList.clear();
	this.temperature = 0.5F;
	spawnableMonsterList.add(new SpawnListEntry(EntityKotek.class, SoulConfigCreatures.kotekSpawnFreq, SoulConfigCreatures.kotekMinGroup, SoulConfigCreatures.kotekMaxGroup));
	theBiomeDecorator = new TheBiomeDeco(this);
	customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
	customBiomeDecorator.tallgrasstype = 1;
	customBiomeDecorator.tallgrassperchunk = 80;
	customBiomeDecorator.soulbushperchunk = 100;
    }
}
