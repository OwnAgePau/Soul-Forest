package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityGroundhog;
import com.Mod_Ores.Mobs.Entity.EntityKotek;

public class BiomeGenSoulShrubbery  extends BiomeGenBase {
    private TheBiomeDeco customBiomeDecorator;

    public BiomeGenSoulShrubbery(int par1){
		super(par1);
		this.topBlock = SoulBlocks.BogGrass.get().getDefaultState();
		this.fillerBlock = SoulBlocks.BogDirt.get().getDefaultState();
	
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableWaterCreatureList.clear();
		this.temperature = 0.5F;
		spawnableMonsterList.add(new SpawnListEntry(EntityGroundhog.class, SoulConfigCreatures.groundhogSpawnFreq, SoulConfigCreatures.groundhogMinGroup, SoulConfigCreatures.groundhogMaxGroup));
		theBiomeDecorator = new TheBiomeDeco(this);
		customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
		customBiomeDecorator.tallgrasstype = 1;
		customBiomeDecorator.tallgrassperchunk = 250;
		customBiomeDecorator.soulbushperchunk = 100;
		customBiomeDecorator.bushesperchunk = 25;
		customBiomeDecorator.slatetowersperchunk = 1;
    }
}