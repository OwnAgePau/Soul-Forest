package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityEnt;
import com.Mod_Ores.Mobs.Entity.EntityFurivoli;
import com.Mod_Ores.Mobs.Entity.EntitySnowCreeper;

public class BiomeGenShinaiForest extends BiomeGenBase
{
	private TheBiomeDeco customBiomeDecorator;
	
    public BiomeGenShinaiForest(int par1)
    {
        super(par1);
        this.topBlock = SoulBlocks.FrozenGrass.get();
        this.fillerBlock = SoulBlocks.BogDirt.get();

        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntitySnowCreeper.class, SoulConfigCreatures.exclosSpawnFreq * 5, SoulConfigCreatures.exclosMinGroup * 2, SoulConfigCreatures.exclosMaxGroup * 2));
        spawnableMonsterList.add(new SpawnListEntry(EntityEnt.class, SoulConfigCreatures.yetiSpawnFreq, SoulConfigCreatures.yetiMinGroup, SoulConfigCreatures.yetiMaxGroup));
        this.temperature = 1.0F;
        theBiomeDecorator = new TheBiomeDeco(this);
        customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
        this.customBiomeDecorator.shinaiperchunk = 60;
        this.customBiomeDecorator.frozentreeperchunk = 60;
        this.customBiomeDecorator.tallgrasstype = 2;
        this.customBiomeDecorator.tallgrassperchunk = 50;
    }
}

