package com.Mod_Ores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfig;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorOres implements IWorldGenerator{	
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
	if(world.provider.dimensionId == SoulConfig.SoulForestID){
	    generateSoulForest(world, random, chunkX*16, chunkZ*16);
	}
	else if(world.provider.dimensionId == SoulConfig.FrozenHearthID){
	    generateSoulForest(world, random, chunkX*16, chunkZ*16);
	}
	else if(world.provider.dimensionId == -1){
	    generateNether(world, random, chunkX*16, chunkZ*16);
	}
	else if(world.provider.dimensionId == 0){
	    generateSurface(world, random, chunkX*16, chunkZ*16);
	}
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ){
	if(random.nextInt(2) == 0){ // Was 11
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(15);				//Rarerity 11 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Cobaltore.get(), 8, Block.getBlockFromName("stone"))).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 10; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(100);				//Rarerity 2 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Copperore.get(), 12, Block.getBlockFromName("stone"))).generate(world, random, randPosX, randPosY, randPosZ);
	}		
	if(random.nextInt(2) == 0){ // Was 11
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(20);				//Rarerity 11 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Steelore.get(), 8, Block.getBlockFromName("stone"))).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 6; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(15);				//Rarerity 5 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Silverore.get(), 6, Block.getBlockFromName("stone"))).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 10; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(100);				//Rarerity 2 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Tinore.get(), 12, Block.getBlockFromName("stone"))).generate(world, random, randPosX, randPosY, randPosZ);
	}
	//if(random.nextInt(4) == 0){ // was 13
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(35);				//Rarerity 12 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Uraniumore.get(), 4, Block.getBlockFromName("stone"))).generate(world, random, randPosX, randPosY, randPosZ);
	//}		
    }

    private void generateNether(World world, Random random, int chunkX, int chunkZ){
    }

    private void generateSoulForest(World world, Random random, int chunkX, int chunkZ){
	for (int i = 0; i < 14; i++){ // Was 7
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 6 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Amazoniteore.get(), 7, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 9; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Amethystore.get(), 9, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 18; i++){ // Was 9
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);	
	    (new WorldGenMinable(SoulBlocks.Aquamarineore.get(), 9, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);		}

	for(int i = 0; i < 5; i++){ // Was random.nextInt(13) == 0
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 12 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Blackdiamondore.get(), 5, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 7; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 6 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Chromiteore.get(), 7, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 9; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Citrineore.get(), 9, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 20; i++){ // Was 9
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Jadeore.get(), 8, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 9; i++){
	    int randPosX = chunkX + random.nextInt(16);	
	    int randPosY = random.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Jetore.get(), 8, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 9; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Lilaore.get(), 9, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 8; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Olivineore.get(), 8, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for(int i = 0; i < 3; i++){ // Was random.nextInt(13)
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 10 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);	
	    (new WorldGenMinable(SoulBlocks.Onyxore.get(), 4, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 13; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 1 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Opalore.get(), 12, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 18; i++){ // was 9
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Scarletiteore.get(), 6, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 18; i++){ // was 9
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Tanzaniteore.get(), 7, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for(int i = 0; i < 3; i++){ // was random.next(13)
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 11 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Titaniumore.get(), 4, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 20; i++){ // was 10
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Topazore.get(), 7, SoulBlocks.Slate.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 10; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Turquoiseore.get(), 8, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 10; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Violetore.get(), 7, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}
	for (int i = 0; i < 10; i++){
	    int randPosX = chunkX + random.nextInt(16);
	    int randPosY = random.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
	    int randPosZ = chunkZ + random.nextInt(16);
	    (new WorldGenMinable(SoulBlocks.Whiteopalore.get(), 6, SoulBlocks.Porphyry.get())).generate(world, random, randPosX, randPosY, randPosZ);
	}		
    }
}
