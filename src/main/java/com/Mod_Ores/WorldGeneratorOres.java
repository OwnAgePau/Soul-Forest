package com.Mod_Ores;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfig;

public class WorldGeneratorOres implements IWorldGenerator{	
    public void generate(Random soulRNG, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		if(world.provider.getDimensionId() == SoulConfig.SoulForestID){
		    generateSoulForest(world, soulRNG, chunkX*16, chunkZ*16);
		}
		else if(world.provider.getDimensionId() == SoulConfig.FrozenHearthID){
		    generateSoulForest(world, soulRNG, chunkX*16, chunkZ*16);
		}
		else if(world.provider.getDimensionId() == -1){
		    generateNether(world, soulRNG, chunkX*16, chunkZ*16);
		}
		else if(world.provider.getDimensionId() == 0){
		    generateSurface(world, soulRNG, chunkX*16, chunkZ*16);
		}
    }

    private void generateSurface(World worldObj, Random soulRNG, int chunkX, int chunkZ){
		if(soulRNG.nextInt(2) == 0){ // Was 11
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(15);				//Rarerity 11 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Cobaltore.get().getDefaultState(), 8, BlockHelper.forBlock(Blocks.stone))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 10; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(100);				//Rarerity 2 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Copperore.get().getDefaultState(), 12, BlockHelper.forBlock(Blocks.stone))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}		
		if(soulRNG.nextInt(2) == 0){ // Was 11
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(20);				//Rarerity 11 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Steelore.get().getDefaultState(), 8, BlockHelper.forBlock(Blocks.stone))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		    
		}
		for (int i = 0; i < 6; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(15);				//Rarerity 5 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Silverore.get().getDefaultState(), 6, BlockHelper.forBlock(Blocks.stone))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 10; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(100);				//Rarerity 2 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Tinore.get().getDefaultState(), 12, BlockHelper.forBlock(Blocks.stone))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));   
		}
		//if(soulRNG.nextInt(4) == 0){ // was 13
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(35);				//Rarerity 12 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Uraniumore.get().getDefaultState(), 4, BlockHelper.forBlock(Blocks.stone))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		//}		
	    }
	
	    private void generateNether(World world, Random soulRNG, int chunkX, int chunkZ){
	    }
	
	    private void generateSoulForest(World worldObj, Random soulRNG, int chunkX, int chunkZ){
		for (int i = 0; i < 14; i++){ // Was 7
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 6 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Amazoniteore.get().getDefaultState(), 7, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 9; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Amethystore.get().getDefaultState(), 7, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 18; i++){ // Was 9
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);	
		    (new WorldGenMinable(SoulBlocks.Aquamarineore.get().getDefaultState(), 9, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
	
		for(int i = 0; i < 5; i++){ // Was soulRNG.nextInt(13) == 0
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 12 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Blackdiamondore.get().getDefaultState(), 5, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 7; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 6 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Chromiteore.get().getDefaultState(), 7, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 9; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Citrineore.get().getDefaultState(), 9, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 20; i++){ // Was 9
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Jadeore.get().getDefaultState(), 8, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 9; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);	
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Jetore.get().getDefaultState(), 8, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 9; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Lilaore.get().getDefaultState(), 9, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 8; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Olivineore.get().getDefaultState(), 8, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for(int i = 0; i < 3; i++){ // Was soulRNG.nextInt(13)
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 10 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);	
		    (new WorldGenMinable(SoulBlocks.Onyxore.get().getDefaultState(), 4, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 13; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 1 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Opalore.get().getDefaultState(), 12, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 18; i++){ // was 9
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Scarletiteore.get().getDefaultState(), 6, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 18; i++){ // was 9
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 4 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Tanzaniteore.get().getDefaultState(), 7, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for(int i = 0; i < 3; i++){ // was soulRNG.next(13)
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 11 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Titaniumore.get().getDefaultState(), 4, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 20; i++){ // was 10
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Topazore.get().getDefaultState(), 7, BlockHelper.forBlock(SoulBlocks.Slate.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 10; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Turquoiseore.get().getDefaultState(), 8, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 10; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Violetore.get().getDefaultState(), 7, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}
		for (int i = 0; i < 10; i++){
		    int randPosX = chunkX + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);				//Rarerity 3 (1-15) 1 is very common 15 is extremely rare
		    int randPosZ = chunkZ + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Whiteopalore.get().getDefaultState(), 6, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}		
    }
}