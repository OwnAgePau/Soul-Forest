package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityEnt;
import com.Mod_Ores.Mobs.Entity.EntityIceFairy;
import com.Mod_Ores.Mobs.Entity.EntitySnowCreeper;

public class BiomeGenFrozenPlains extends BiomeGenBase{
	private WorldGenerator theWorldGenerator;
	private TheBiomeDeco customBiomeDecorator;
	
    public BiomeGenFrozenPlains(int par1){
        super(par1);
        this.topBlock = SoulBlocks.FrozenGrass.get().getDefaultState();
        this.fillerBlock = SoulBlocks.BogDirt.get().getDefaultState();

        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntitySnowCreeper.class, SoulConfigCreatures.exclosSpawnFreq, SoulConfigCreatures.exclosMinGroup, SoulConfigCreatures.exclosMaxGroup));
        spawnableMonsterList.add(new SpawnListEntry(EntityEnt.class, SoulConfigCreatures.yetiSpawnFreq, SoulConfigCreatures.yetiMinGroup, SoulConfigCreatures.yetiMaxGroup));
        spawnableMonsterList.add(new SpawnListEntry(EntityIceFairy.class, SoulConfigCreatures.icefairySpawnFreq, SoulConfigCreatures.icefairyMinGroup, SoulConfigCreatures.icefairyMaxGroup));
        this.temperature = 0.3F;
        theBiomeDecorator = new TheBiomeDeco(this);
        customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
        customBiomeDecorator.icetowersperchunk = 1;
        customBiomeDecorator.tallgrasstype = 2;
        customBiomeDecorator.tallgrassperchunk = 40;
    }
}