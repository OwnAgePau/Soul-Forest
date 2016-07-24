package com.Mod_Ores.BiomeGen;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.*;

public class BiomeEventSoulForest extends Event{
    public final BiomeGenBase biome;

    public BiomeEventSoulForest(BiomeGenBase biome){
        this.biome = biome;
    }
    
    public static class CreateDecorator extends BiomeEventSoulForest{
        public final BiomeDecorator originalTheBiomeDeco;
        public BiomeDecorator newTheBiomeDeco;
        
        public CreateDecorator(BiomeGenBase biome, BiomeDecorator original){
            super(biome);
            originalTheBiomeDeco = original;
            newTheBiomeDeco = original;
        }
    }

    public static class BlockReplacement extends BiomeEventSoulForest{
        public final int original;
        public int replacement;

        public BlockReplacement(BiomeGenBase biome, int original, int replacement){
            super(biome);
            this.original = original;
            this.replacement = replacement;
        }
    }
    

    @SideOnly(Side.CLIENT)
    public static class BiomeColor extends BiomeEventSoulForest{
        public final int originalColor;
        public int newColor;
        
        public BiomeColor(BiomeGenBase biome, int original){
            super(biome);
            originalColor = original;
            newColor = original;
        }
    }

    @HasResult
    public static class GetVillageBlockID extends BlockReplacement{
        public GetVillageBlockID(BiomeGenBase biome, int original, int replacement){
            super(biome, original, replacement);
        }
    }

    @HasResult
    public static class GetVillageBlockMeta extends BlockReplacement{
        public GetVillageBlockMeta(BiomeGenBase biome, int original, int replacement){
            super(biome, original, replacement);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public static class GetGrassColor extends BiomeColor{
        public GetGrassColor(BiomeGenBase biome, int original){
            super(biome, original);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public static class GetFoliageColor extends BiomeColor{
        public GetFoliageColor(BiomeGenBase biome, int original){
            super(biome, original);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public static class GetWaterColor extends BiomeColor{
        public GetWaterColor(BiomeGenBase biome, int original){
            super(biome, original);
        }
    }
}