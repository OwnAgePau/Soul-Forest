package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityKotek;

public class BiomeGenSoulForest extends BiomeGenBase{
    private TheBiomeDeco customBiomeDecorator;
    
    public BiomeGenSoulForest(int par1){
	super(par1);
	this.topBlock = SoulBlocks.LateriteGrass.get();
	this.fillerBlock = SoulBlocks.LateriteDirt.get();

	spawnableMonsterList.clear();
	spawnableCreatureList.clear();
	spawnableCaveCreatureList.clear();
	spawnableWaterCreatureList.clear();
	spawnableMonsterList.add(new SpawnListEntry(EntityKotek.class, SoulConfigCreatures.kotekSpawnFreq, SoulConfigCreatures.kotekMinGroup, SoulConfigCreatures.kotekMaxGroup));
	theBiomeDecorator = new TheBiomeDeco(this);
	customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
	customBiomeDecorator.baneberryvineperchunk = 15;
	customBiomeDecorator.blueberryvineperchunk = 15;
	customBiomeDecorator.blackberryvineperchunk = 15;
	customBiomeDecorator.cranberryvineperchunk = 15;
	customBiomeDecorator.raspberryvineperchunk = 15;
	customBiomeDecorator.razzberryvineperchunk = 15;
	customBiomeDecorator.strawberryvineperchunk = 15;
	customBiomeDecorator.grapetreeperchunk = 50;
	customBiomeDecorator.cantaloupeperchunk = 40;
	customBiomeDecorator.tallgrasstype = 1;
	customBiomeDecorator.tallgrassperchunk = 200;
	customBiomeDecorator.bushesperchunk = 50;
	customBiomeDecorator.shrubperchunk = 100;
	customBiomeDecorator.grapesapplingperchunk = 5;
	this.temperature = 0.5F;
    }
}
