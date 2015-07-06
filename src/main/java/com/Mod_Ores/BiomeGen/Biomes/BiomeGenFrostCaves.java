package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityEnt;
import com.Mod_Ores.Mobs.Entity.EntityIceFairy;
import com.Mod_Ores.Mobs.Entity.EntitySnowCreeper;

public class BiomeGenFrostCaves extends BiomeGenBase
{
	private WorldGenerator theWorldGenerator;
	private TheBiomeDeco customBiomeDecorator;
	
    public BiomeGenFrostCaves(int par1)
    {
        super(par1);
        this.topBlock = SoulBlocks.SoulSnowTop.get();
        this.fillerBlock = SoulBlocks.SoulSnowBottom.get();

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
        customBiomeDecorator.icetowersperchunk = 2;
    }
}
