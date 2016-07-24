package com.Mod_Ores.Dimension;

import java.util.List;
import java.util.Random;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.BiomeGen.WorldGenSoulTrees;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenCavesSoulForest;
import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.*;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class OldChunkProviderMarona implements IChunkProvider{
	
    private Random soulRNG;
    /** A NoiseGeneratorOctaves used in generating nether terrain */
    private NoiseGeneratorOctaves netherNoiseGen1;
    private NoiseGeneratorOctaves netherNoiseGen2;
    private NoiseGeneratorOctaves netherNoiseGen3;
    /** Determines whether slowsand or gravel can be generated at a location */
    private NoiseGeneratorOctaves lateriteGrassPorphyryNoise;
    /** Determines whether something other than nettherack can be generated at a location */
    private NoiseGeneratorOctaves porphyryExclusivityNoiseGen;
    public NoiseGeneratorOctaves netherNoiseGen6;
    public NoiseGeneratorOctaves netherNoiseGen7;
    /** Is the world that the nether is getting generated. */
    private World worldObj;
    private double[] noiseField;
    public MapGenNetherBridge genNetherBridge = new MapGenNetherBridge();
    /** Holds the noise used to determine whether slowsand can be generated at a location */
    private double[] lateriteGrassNoise = new double[256];
    private double[] porphyryNoise = new double[256];
    /** Holds the noise used to determine whether something other than netherrack can be generated at a location */
    private double[] porphyryExclusiveNoise = new double[256];
    private MapGenBase soulForestCaveGenerator = new WorldGenCavesSoulForest();
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;

    /** The biomes that are used to generate the chunk */
    private BiomeGenBase[] biomesForGeneration;

    private Object theBiomeDecorator;

    private static final String __OBFID = "CL_00000392";{
		genNetherBridge = (MapGenNetherBridge) TerrainGen.getModdedMapGen(genNetherBridge, NETHER_BRIDGE);
		soulForestCaveGenerator = TerrainGen.getModdedMapGen(soulForestCaveGenerator, NETHER_CAVE);
    }

    public OldChunkProviderMarona(World p_i2005_1_, long p_i2005_2_){
		this.worldObj = p_i2005_1_;
		this.soulRNG = new Random(p_i2005_2_);
		this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.soulRNG, 16);
		this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.soulRNG, 16);
		this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.soulRNG, 8);
		this.lateriteGrassPorphyryNoise = new NoiseGeneratorOctaves(this.soulRNG, 4);
		this.porphyryExclusivityNoiseGen = new NoiseGeneratorOctaves(this.soulRNG, 4);
		this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.soulRNG, 10);
		this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.soulRNG, 16);
	
		NoiseGenerator[] noiseGens = {netherNoiseGen1, netherNoiseGen2, netherNoiseGen3, lateriteGrassPorphyryNoise, porphyryExclusivityNoiseGen, netherNoiseGen6, netherNoiseGen7};
		noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2005_1_, this.soulRNG, noiseGens);
		this.netherNoiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
		this.netherNoiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
		this.netherNoiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
		this.lateriteGrassPorphyryNoise = (NoiseGeneratorOctaves)noiseGens[3];
		this.porphyryExclusivityNoiseGen = (NoiseGeneratorOctaves)noiseGens[4];
		this.netherNoiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
		this.netherNoiseGen7 = (NoiseGeneratorOctaves)noiseGens[6];
    }

    public void setBlocksInChunk(int p_147419_1_, int p_147419_2_, ChunkPrimer primer){
		byte b0 = 4;
		byte b1 = 32;
		int k = b0 + 1;
		byte b2 = 17;
		int l = b0 + 1;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(new BlockPos(k + 16, 0, l + 16));
		float t = biomegenbase.getFloatTemperature(new BlockPos(k, 16, l));
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147419_1_ * 4 - 2, p_147419_2_ * 4 - 2, k + 5, l + 5);
	
		this.noiseField = this.initializeNoiseField(this.noiseField, p_147419_1_ * b0, 0, p_147419_2_ * b0, k, b2, l);
	
		for (int i1 = 0; i1 < b0; ++i1){
		    for (int j1 = 0; j1 < b0; ++j1){
				for (int k1 = 0; k1 < 16; ++k1){
				    double d0 = 0.125D;
				    double d1 = this.noiseField[((i1 + 0) * l + j1 + 0) * b2 + k1 + 0];
				    double d2 = this.noiseField[((i1 + 0) * l + j1 + 1) * b2 + k1 + 0];
				    double d3 = this.noiseField[((i1 + 1) * l + j1 + 0) * b2 + k1 + 0];
				    double d4 = this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 0];
				    double d5 = (this.noiseField[((i1 + 0) * l + j1 + 0) * b2 + k1 + 1] - d1) * d0;
				    double d6 = (this.noiseField[((i1 + 0) * l + j1 + 1) * b2 + k1 + 1] - d2) * d0;
				    double d7 = (this.noiseField[((i1 + 1) * l + j1 + 0) * b2 + k1 + 1] - d3) * d0;
				    double d8 = (this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 1] - d4) * d0;
		
				    for (int l1 = 0; l1 < 8; ++l1){
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
			
						for (int i2 = 0; i2 < 4; ++i2){
						    int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
						    short short1 = 128;
						    double d14 = 0.25D;
						    double d15 = d10;
						    double d16 = (d11 - d10) * d14;
			
						    for (int k2 = 0; k2 < 4; ++k2){
						    	IBlockState block = null;
				
								if (k1 * 8 + l1 < b1){
								    block = SoulBlocks.SoulWaterMoving.get().getDefaultState();
								}
				
								if (d15 > 0.0D){
								    block = SoulBlocks.Porphyry.get().getDefaultState();
								}
				
								int l2 = j2 + j1 * 4;
                                int i3 = i2 + l1 * 8;
                                int j3 = k2 + k1 * 4;
								primer.setBlockState(l2, i3, j3, block);
								j2 += short1;
								d15 += d16;
						    }
			
						    d10 += d12;
						    d11 += d13;
						}
			
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
				    }
				}
		    }
		}
    }

    /*@Deprecated //You should provide meatadata and biome data in the below method
    public void func_180516_b(int p_147418_1_, int p_147418_2_, ChunkPrimer primer){
    	replaceBiomeBlocks(p_147418_1_, p_147418_2_, p_147418_3_, new byte[p_147418_3_.length], null);
    } */
    
    public void replaceBiomeBlocks(int p_147418_1_, int p_147418_2_, ChunkPrimer primer, BiomeGenBase[] biomes){
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_147418_1_, p_147418_2_, primer, this.worldObj);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return;
	
		byte b0 = 33; // was 64
		double d0 = 0.03125D;
		this.lateriteGrassNoise = this.lateriteGrassPorphyryNoise.generateNoiseOctaves(this.lateriteGrassNoise, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d0, d0, 1.0D);
		this.porphyryNoise = this.lateriteGrassPorphyryNoise.generateNoiseOctaves(this.porphyryNoise, p_147418_1_ * 16, 109, p_147418_2_ * 16, 16, 1, 16, d0, 1.0D, d0);
		this.porphyryExclusiveNoise = this.porphyryExclusivityNoiseGen.generateNoiseOctaves(this.porphyryExclusiveNoise, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);
	
		for (int k = 0; k < 16; ++k){
		    for (int l = 0; l < 16; ++l){
				BiomeGenBase biomegenbase = biomes[l + k * 16];
				//System.out.println(biomegenbase.biomeName);
				//biomegenbase.genTerrainBlocks(this.worldObj, this.soulRNG, p_147418_3_, meta, p_147418_1_ * 16 + k, p_147418_2_ * 16 + l, this.porphyryExclusiveNoise[l + k * 16]);
				boolean flag = this.lateriteGrassNoise[k + l * 16] + this.soulRNG.nextDouble() * 0.2D > 0.0D;
				boolean flag1 = this.porphyryNoise[k + l * 16] + this.soulRNG.nextDouble() * 0.2D > 0.0D;
				int i1 = (int)(this.porphyryExclusiveNoise[k + l * 16] / 3.0D + 3.0D + this.soulRNG.nextDouble() * 0.25D);
				int j1 = -1;
				IBlockState block = biomegenbase.topBlock;
				IBlockState block1 = biomegenbase.fillerBlock;
		
				for (int k1 = 127; k1 >= 0; --k1){
				    int l1 = (l * 16 + k) * 128 + k1;
				    
				    if (k1 < 127 - this.soulRNG.nextInt(5) && k1 > 0 + this.soulRNG.nextInt(5)){
				    	IBlockState block2 = primer.getBlockState(k, k1, l);
						if (block2 != null && block2.getBlock().getMaterial() != Material.air){
						    if (block2.getBlock() == SoulBlocks.Porphyry.get()){
								if (j1 == -1){
								    if (i1 <= 0){
										block = null;
										block1 = SoulBlocks.Porphyry.get().getDefaultState();  
								    }
								    else if (k1 >= 0 - 4 && k1 <= b0 + 1){
										block = biomegenbase.topBlock;
										block1 = biomegenbase.fillerBlock;
			
										if (flag1){
										    block = biomegenbase.topBlock;   
										    block1 = biomegenbase.fillerBlock;
										}
			
										//System.out.println("Block1 : " + biomegenbase.topBlock);
										//System.out.println("Block2 : " + biomegenbase.fillerBlock);
			
										if (flag){
										    block = biomegenbase.topBlock;
										    block1 = biomegenbase.fillerBlock;
										}
								    }
		
								    if (k1 < b0 && (block == null || block.getBlock().getMaterial() == Material.air)){
										if (biomegenbase == soul_forest.FrostCaves || biomegenbase == soul_forest.FrozenPlains) // Generate ice when temp below certain value
										{
											//b1 = (byte) SoulBlocks.soulIceID;
										} 
										else {
										    //block1 = SoulBlocks.SoulWaterMoving.get();
										}
								    }
		
								    j1 = i1;
		
								    if (k1 >= b0 - 1){
								    	// TODO no ffing if this is the correct coordinates
								    	primer.setBlockState(k1, j1, l, block);
								    	//p_147418_3_[l1] = block; 
								    }
								    else{
								    	primer.setBlockState(k1, j1, l, block1);
								    	//p_147418_3_[l1] = block1;
								    }
								}
								else if (j1 > 0){
								    --j1;
								    primer.setBlockState(k1, j1, l, block1);
								    //p_147418_3_[l1] = block1;
								}
					    	}	
						}
						else{
			    			j1 = -1;
						}
		    		}
		    		else{
		    			primer.setBlockState(k1, j1, l, Blocks.bedrock.getDefaultState());
						//p_147418_3_[l1] = Blocks.bedrock;
				    }
				}
	    	}
		}
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int p_73158_1_, int p_73158_2_){
    	return this.provideChunk(p_73158_1_, p_73158_2_);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    @Override
    public Chunk provideChunk(int x, int z){
		this.soulRNG.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer primer = new ChunkPrimer();
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16); //Forge Move up to allow for passing to replaceBiomeBlocks
		this.setBlocksInChunk(x, z, primer);
		this.replaceBiomeBlocks(x, z, primer, this.biomesForGeneration);
		this.soulForestCaveGenerator.generate(this, this.worldObj, x, z, primer);
		//this.genNetherBridge.func_151539_a(this, this.worldObj, p_73154_1_, p_73154_2_, ablock);
		Chunk chunk = new Chunk(this.worldObj, primer, x, z);
		byte[] abyte = chunk.getBiomeArray();
	
		for (int k = 0; k < abyte.length; ++k){
		    abyte[k] = (byte)biomesForGeneration[k].biomeID;
		}
		chunk.resetRelightChecks();
		return chunk;
    }

    /**
     * generates a subset of the level's terrain data. Takes 7 arguments: the [empty] noise array, the position, and the
     * size.
     */
    private double[] initializeNoiseField(double[] p_73164_1_, int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_){
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, p_73164_1_, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;
		if (p_73164_1_ == null){
			p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
		}
		
		double d0 = 684.412D;
		double d1 = 2053.236D;
		this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
		this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100.0D, 0.0D, 100.0D);
		this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0 / 80.0D, d1 / 60.0D, d0 / 80.0D);
		this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
		this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
		int k1 = 0;
		int l1 = 0;
		double[] adouble1 = new double[p_73164_6_];
		int i2;
		
		for (i2 = 0; i2 < p_73164_6_; ++i2){
		    adouble1[i2] = Math.cos((double)i2 * Math.PI * 6.0D / (double)p_73164_6_) * 2.0D;
		    double d2 = (double)i2;
		
		    if (i2 > p_73164_6_ / 2){
		    	d2 = (double)(p_73164_6_ - 1 - i2);
		    }
		
		    if (d2 < 4.0D){
				d2 = 4.0D - d2;
				adouble1[i2] -= d2 * d2 * d2 * 10.0D;
		    }
		}
		
		for (i2 = 0; i2 < p_73164_5_; ++i2){
		    for (int k2 = 0; k2 < p_73164_7_; ++k2){
		    	double d3 = (this.noiseData4[l1] + 256.0D) / 512.0D;
		
				if (d3 > 1.0D){
				    d3 = 1.0D;
				}
		
				double d4 = 0.0D;
				double d5 = this.noiseData5[l1] / 8000.0D;
			
				if (d5 < 0.0D){
				    d5 = -d5;
				}
		
				d5 = d5 * 3.0D - 3.0D;
			
				if (d5 < 0.0D){
				    d5 /= 2.0D;
		
				    if (d5 < -1.0D){
				    	d5 = -1.0D;
				    }
			
				    d5 /= 1.4D;
				    d5 /= 2.0D;
				    d3 = 0.0D;
				}
				else{
				    if (d5 > 1.0D){
				    	d5 = 1.0D;
				    }
				    d5 /= 6.0D;
				}
		
				d3 += 0.5D;
				d5 = d5 * (double)p_73164_6_ / 16.0D;
				++l1;
		
				for (int j2 = 0; j2 < p_73164_6_; ++j2){
				    double d6 = 0.0D;
				    double d7 = adouble1[j2];
				    double d8 = this.noiseData2[k1] / 512.0D;
				    double d9 = this.noiseData3[k1] / 512.0D;
				    double d10 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;
			
				    if (d10 < 0.0D){
				    	d6 = d8;
				    }
				    else if (d10 > 1.0D){
				    	d6 = d9;
				    }
				    else{
				    	d6 = d8 + (d9 - d8) * d10;
				    }
		
				    d6 -= d7;
				    double d11;
		
				    if (j2 > p_73164_6_ - 4){
						d11 = (double)((float)(j2 - (p_73164_6_ - 4)) / 3.0F);
						d6 = d6 * (1.0D - d11) + -10.0D * d11;
				    }
			
				    if ((double)j2 < d4){
				    	d11 = (d4 - (double)j2) / 4.0D;
		
						if (d11 < 0.0D){
						    d11 = 0.0D;
						}
		
						if (d11 > 1.0D){
						    d11 = 1.0D;
						}
		
						d6 = d6 * (1.0D - d11) + -10.0D * d11;
				    }
				    p_73164_1_[k1] = d6;
				    ++k1;
				}
		    }
		}
		return p_73164_1_;
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int p_73149_1_, int p_73149_2_){
    	return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_){
		BlockSand.fallInstantly = true;
	
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(p_73153_1_, worldObj, soulRNG, p_73153_2_, p_73153_3_, false));
	
		int k = p_73153_2_ * 16;
		int l = p_73153_3_ * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(new BlockPos(k + 16, 0, l + 16));
		//this.genNetherBridge.generateStructuresInChunk(this.worldObj, this.soulRNG, par2, par3);
		int i1;
		int j1;
		int k1;
		int l1 = 0;
		int j2;
	
		biomegenbase.decorate(this.worldObj, this.soulRNG, new BlockPos(k, 0, l));
		//boolean doGen = TerrainGen.populate(p_73153_1_, worldObj, soulRNG, p_73153_2_, p_73153_3_, false, NETHER_LAVA);
	
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldObj, soulRNG, new BlockPos(k, 0, l)));
	
		i1 = this.soulRNG.nextInt(this.soulRNG.nextInt(10) + 1) + 1;
		int i2;
	
		//doGen = TerrainGen.decorate(worldObj, soulRNG, k, l, SHROOM);
		// Everything not biome related       
	
		// #region Ore Gen
		//WorldGenMinable worldgenminable;
	
		for (int i = 0; i < 5; i++){
		    int randPosX = k + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);
		    int randPosZ = l + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Bauxite.get().getDefaultState(), 30, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}	
		for (int i = 0; i < 10; i++){
		    int randPosX = k + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);
		    int randPosZ = l + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.Slate.get().getDefaultState(), 50, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}	
		for (int i = 0; i < 15; i++){
		    int randPosX = k + soulRNG.nextInt(16);
		    int randPosY = soulRNG.nextInt(128);
		    int randPosZ = l + soulRNG.nextInt(16);
		    (new WorldGenMinable(SoulBlocks.DarkPorphyry.get().getDefaultState(), 20, BlockHelper.forBlock(SoulBlocks.Porphyry.get()))).generate(worldObj, soulRNG, new BlockPos(randPosX, randPosY, randPosZ));
		}	
	
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldObj, soulRNG, new BlockPos(k, 0, l)));
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(p_73153_1_, worldObj, soulRNG, p_73153_2_, p_73153_3_, false));
	
		BlockSand.fallInstantly = false;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_){
	return true;
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unimplemented.
     */
    public void saveExtraData() {}

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks(){
	return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave(){
	return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString(){
	return "SoulForestLevelSource";
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos){
	BiomeGenBase biomegenbase = (BiomeGenBase) this.worldObj.getBiomeGenForCoords(pos);
	return biomegenbase == null ? null : biomegenbase.getSpawnableList(creatureType);
    }

    public int getLoadedChunkCount(){
    	return 0;
    }

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName,
			BlockPos position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_,
			int p_180514_3_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_,
			int p_177460_3_, int p_177460_4_) {
		// TODO Auto-generated method stub
		return false;
	}
}