package com.Mod_Ores.BiomeGen.Biomes;

import net.minecraft.world.biome.BiomeGenBase;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.Entity.EntityGroundhog;

public class BiomeGenPeatBog extends BiomeGenBase{    
    private TheBiomeDeco customBiomeDecorator;
    public BiomeGenPeatBog(int par1){
        super(par1);
        this.topBlock = SoulBlocks.BogGrass.get().getDefaultState();
        this.fillerBlock = SoulBlocks.BogDirt.get().getDefaultState();

        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityGroundhog.class, SoulConfigCreatures.groundhogSpawnFreq, SoulConfigCreatures.groundhogMinGroup, SoulConfigCreatures.groundhogMaxGroup));
        theBiomeDecorator = new TheBiomeDeco(this);
        customBiomeDecorator = (TheBiomeDeco)theBiomeDecorator;
        temperature = 0.5F;
        //theBiomeDecorator.grassPerChunk = 40;
        //theBiomeDecorator.mushroomsPerChunk = 10;
        customBiomeDecorator.tallgrasstype = 1;
        customBiomeDecorator.tallgrassperchunk = 250;
        customBiomeDecorator.vineplantperchunk = 50;
        customBiomeDecorator.bogwaterperchunk = 250;
    }
}