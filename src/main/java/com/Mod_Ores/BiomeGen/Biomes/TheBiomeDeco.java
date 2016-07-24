package com.Mod_Ores.BiomeGen.Biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.BiomeGen.WorldGenGrapeTree;
import com.Mod_Ores.BiomeGen.WorldGenTallTrees;
import com.Mod_Ores.BiomeGen.WorldGenSoulTrees;
import com.Mod_Ores.BiomeGen.Stuctures.WorldGenDarkAltar;
import com.Mod_Ores.BiomeGen.Stuctures.WorldGenTower;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenCantaloupe;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenPeatBogWater;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenPlant;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSapplingGrape;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulBush;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulFire;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulLakes;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulShrub;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulVine;
import com.Mod_Ores.BiomeGen.WorldGen.WorldGenSoulWaterfalls;
import com.Mod_Ores.Init.SoulBlocks;

public class TheBiomeDeco extends BiomeDecorator{	
    
	/** The world the BiomeDecorator is currently decorating */
    public World currentWorld;

    /** The Biome Decorator's random number generator. */
    public Random randomGenerator;

    /** The Biome That is being decorated. */
    public BiomeGenBase thebiome;

    /** The X-coordinate of the chunk currently being decorated */
    public int chunk_X;

    /** The Z-coordinate of the chunk currently being decorated */
    public int chunk_Z;

    protected int baneberryvineperchunk;	
    protected int blackberryvineperchunk;
    protected int blueberryvineperchunk;	
    protected int cranberryvineperchunk;
    protected int raspberryvineperchunk;
    protected int razzberryvineperchunk;	
    protected int strawberryvineperchunk;

    protected int grapetreeperchunk;
    protected int hardwoodtreeperchunk;
    protected int soultreeperchunk;
    protected int frozentreeperchunk;
    protected int soulbushperchunk;
    protected int fyrisedbushperchunk;

    protected int cantaloupeperchunk;
    protected int shrubperchunk;
    protected int tallgrassperchunk;
    protected int bushesperchunk;
    protected int grapesapplingperchunk;
    protected int fireblossomsperchunk;
    protected int shinaiperchunk;
    protected int vineplantperchunk;

    protected int lakesperchunk;
    protected int waterfallsperchunk;
    protected int lavafallsperchunk;
    protected int bogwaterperchunk;

    protected int soulfiresperchunk;
    
    protected Block blockToPlaceWaterIn;

    /** the type of the tall grass that is being spawned 1 == brown, grey & green, 2 == frozen, 3 == same as 1 with the addition of purple
     * 
     */
    protected int tallgrasstype;

    protected int icetowersperchunk;
    protected int titaniumtowersperchunk;
    protected int slatetowersperchunk;
    protected int darkaltarsperchunk;

    protected WorldGenerator baneberryVineGen;
    protected WorldGenerator blueberryVineGen;
    protected WorldGenerator blackberryVineGen;
    protected WorldGenerator cranberryVineGen;
    protected WorldGenerator raspberryVineGen;
    protected WorldGenerator razzberryVineGen;
    protected WorldGenerator strawberryVineGen;

    protected WorldGenerator grapetreeGen;
    protected WorldGenerator hardwoodtreeGen;
    protected WorldGenerator soultreeGen;
    protected WorldGenerator frozentreeGen;
    protected WorldGenerator soulbushGen;
    protected WorldGenerator fyrisedbushGen;

    protected WorldGenerator cantaloupeGen;
    protected WorldGenerator shrubGen;
    protected WorldGenerator tallgrassGen;
    protected WorldGenerator bushesGen;
    protected WorldGenerator grapesapplingGen;
    protected WorldGenerator fireblossomGen;
    protected WorldGenerator shinaiGen;
    protected WorldGenerator vineplantGen;

    protected WorldGenerator icetowerGen;
    protected WorldGenerator titaniumtowerGen;
    protected WorldGenerator slatetowerGen;
    protected WorldGenerator darkAltarGen;

    protected WorldGenerator lakeGen;
    protected WorldGenerator waterfallGen;
    protected WorldGenerator lavafallGen;
    protected WorldGenerator bogwaterGen;

    protected WorldGenerator soulfireGen;

    public TheBiomeDeco(BiomeGenBase biomeGenBaseMarona){
		super();
		this.randomGenerator = new Random();
		this.icetowerGen = new WorldGenTower(SoulBlocks.IceBrick.get(), SoulBlocks.IceBrickStairs.get(), 
			SoulBlocks.SoulSnowTop.get(), soul_forest.soulForestChestContents.iceTowerChestContent);
		this.titaniumtowerGen = new WorldGenTower(SoulBlocks.TitaniumBrick.get(), SoulBlocks.TitaniumBrickStairs.get(), 
			SoulBlocks.FyrisedSandGrass.get(), soul_forest.soulForestChestContents.titaniumTowerChestContent);
		this.slatetowerGen = new WorldGenTower(SoulBlocks.SlateBrick.get(), SoulBlocks.SlateBrickStairs.get(), 
			SoulBlocks.BogGrass.get(), soul_forest.soulForestChestContents.slateTowerChestContent);
		this.darkAltarGen = new WorldGenDarkAltar();
		this.grapetreeGen = new WorldGenGrapeTree(false);
		this.hardwoodtreeGen = new WorldGenTallTrees(this.randomGenerator, SoulBlocks.HardwoodLeaves.get(), SoulBlocks.HardwoodLog.get(), 
			SoulBlocks.FyrisedSandGrass.get(), SoulBlocks.FyrisedSand.get());
		this.frozentreeGen = new WorldGenTallTrees(this.randomGenerator, SoulBlocks.IceLeaves.get(), SoulBlocks.IceLog.get(), 
			SoulBlocks.FrozenGrass.get(), SoulBlocks.BogDirt.get());
		this.soultreeGen = new WorldGenSoulTrees();
		this.shrubGen = new WorldGenSoulShrub(SoulBlocks.SoulLeaves.get(), SoulBlocks.SoulLog.get());
		this.soulbushGen = new WorldGenSoulBush(SoulBlocks.SoulLog.get(), SoulBlocks.SoulLeaves.get(), 
			SoulBlocks.BogGrass.get(), SoulBlocks.BogDirt.get(), 2);
		this.fyrisedbushGen = new WorldGenSoulBush(SoulBlocks.HardwoodLog.get(), SoulBlocks.HardwoodLeaves.get(), 
			SoulBlocks.FyrisedSandGrass.get(), SoulBlocks.FyrisedSand.get(), 2);
		this.cantaloupeGen = new WorldGenCantaloupe(SoulBlocks.PlantCantaloupe.get());
		this.grapesapplingGen = new WorldGenSapplingGrape(SoulBlocks.SaplingGrape.get());
		this.fireblossomGen =  new WorldGenPlant(SoulBlocks.Fireblossom.get());
		this.shinaiGen =  new WorldGenPlant(SoulBlocks.FrozenShinai.get());
		this.vineplantGen =  new WorldGenPlant(SoulBlocks.Vineplant.get());
		this.lakeGen = new WorldGenSoulLakes(SoulBlocks.SoulWaterMoving.get());
		this.bogwaterGen = new WorldGenPeatBogWater(SoulBlocks.SoulWaterMoving.get());
		this.waterfallGen = new WorldGenSoulWaterfalls(SoulBlocks.SoulWaterMoving.get(), this.blockToPlaceWaterIn, true);
		this.lavafallGen = new WorldGenSoulWaterfalls(Block.getBlockFromName("flowing_lava"), this.blockToPlaceWaterIn, true);
		this.soulfireGen = new WorldGenSoulFire(SoulBlocks.SoulFire.get());
		this.baneberryVineGen = new WorldGenSoulVine(SoulBlocks.Baneberry.get());
		this.blueberryVineGen = new WorldGenSoulVine(SoulBlocks.Blueberry.get());
		this.blackberryVineGen = new WorldGenSoulVine(SoulBlocks.Blackberry.get());
		this.cranberryVineGen = new WorldGenSoulVine(SoulBlocks.Cranberry.get());
		this.raspberryVineGen = new WorldGenSoulVine(SoulBlocks.Raspberry.get());
		this.razzberryVineGen = new WorldGenSoulVine(SoulBlocks.Razzberry.get());
		this.strawberryVineGen = new WorldGenSoulVine(SoulBlocks.Strawberry.get());        
		this.thebiome = biomeGenBaseMarona;
    }

    @Override
    public void decorate(World worldIn, Random random, BiomeGenBase base, BlockPos pos){
		if (this.currentWorld != null){
		    //System.out.println("Allready decorating!!");
		}
		else{
		    this.currentWorld = worldIn;
		    this.randomGenerator = random;
		    this.chunk_X = pos.getX();
		    this.chunk_Z = pos.getY();
		    this.genDecorations(base);
		    this.currentWorld = null;
		    this.randomGenerator = null;
		}
    }

    @Override
    public void genDecorations(BiomeGenBase base) {
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.randomGenerator, new BlockPos(this.chunk_X, 0, this.chunk_Z)));
	
		//structures
		for (int g1 = 0; g1 < this.icetowersperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(16);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(16);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.icetowerGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.slatetowersperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(16);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(16);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.slatetowerGen.generate(currentWorld, randomGenerator, position);
		}
		if(this.titaniumtowersperchunk > 0){
		    if(this.randomGenerator.nextInt(32) <= this.titaniumtowersperchunk){
				int g2 = chunk_X + randomGenerator.nextInt(16);
				int h1 = randomGenerator.nextInt(128);
				int g3 = chunk_Z + randomGenerator.nextInt(16);
				BlockPos position = new BlockPos(g2, h1, g3);
				this.titaniumtowerGen.generate(currentWorld, randomGenerator, position);
		    }
		}
		if(this.darkaltarsperchunk > 0){
		    if(this.randomGenerator.nextInt(40) <= this.darkaltarsperchunk){
				int g2 = chunk_X + randomGenerator.nextInt(16);
				int h1 = randomGenerator.nextInt(128);
				int g3 = chunk_Z + randomGenerator.nextInt(16);
				BlockPos position = new BlockPos(g2, h1, g3);
				this.darkAltarGen.generate(currentWorld, randomGenerator, position);
		    }
		}
	
		//grass
		for (int g1 = 0; g1 < this.tallgrassperchunk * 2; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(16);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(16);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.tallgrassGen = soul_forest.getRandomWorldGenForGrass(randomGenerator, this.tallgrasstype);
		    this.tallgrassGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.bushesperchunk * 2; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.bushesGen = soul_forest.getRandomWorldGenForGrass(randomGenerator, 4);
		    this.bushesGen.generate(currentWorld, randomGenerator, position);
		}
		//trees
		for (int g1 = 0; g1 < this.grapetreeperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = this.randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(16);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.grapetreeGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.hardwoodtreeperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = this.randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(16);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.hardwoodtreeGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.soultreeperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = this.randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.soultreeGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.frozentreeperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = this.randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.frozentreeGen.generate(currentWorld, randomGenerator, position);
		}
		//vines
		for (int g1 = 0; g1 < this.baneberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.baneberryVineGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.blackberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.blackberryVineGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.blueberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.cranberryVineGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.cranberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.blueberryVineGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.raspberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.raspberryVineGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.razzberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.razzberryVineGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.strawberryvineperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.strawberryVineGen.generate(currentWorld, randomGenerator, position);
		}       
		//plants
		for (int g1 = 0; g1 < this.cantaloupeperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.cantaloupeGen.generate(currentWorld, randomGenerator, position);
		}     
		for (int g1 = 0; g1 < this.shrubperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(64);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(64);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.shrubGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.soulbushperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.soulbushGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.fyrisedbushperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.fyrisedbushGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.grapesapplingperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.grapesapplingGen.generate(currentWorld, randomGenerator, position);
		}		
		for (int g1 = 0; g1 < this.fireblossomsperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.fireblossomGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.shinaiperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(32);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(32);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.shinaiGen.generate(currentWorld, randomGenerator, position);
		}
		for (int g1 = 0; g1 < this.vineplantperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(24);
		    int h1 = this.randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(24);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.vineplantGen.generate(currentWorld, randomGenerator, position);
		}
	
		//water\lava\fire
		for (int g1 = 0; g1 < this.lakesperchunk; g1++){
	            int g2 = chunk_X + randomGenerator.nextInt(16) + 8;
	            int h1 = randomGenerator.nextInt(128);
	            int g3 = chunk_Z + randomGenerator.nextInt(16) + 8;
	            BlockPos position = new BlockPos(g2, h1, g3);
	            this.lakeGen.generate(currentWorld, randomGenerator, position);
	        }
	        for (int g1 = 0; g1 < this.waterfallsperchunk; g1++){
	        	int g2 = chunk_X + randomGenerator.nextInt(16) + 8;
	        	int h1 = randomGenerator.nextInt(108) + 10;
	            int g3 = chunk_Z + randomGenerator.nextInt(16);
	            BlockPos position = new BlockPos(g2, h1, g3);
	            this.waterfallGen = new WorldGenSoulWaterfalls(SoulBlocks.SoulWaterMoving.get(), this.blockToPlaceWaterIn, true);
	            this.waterfallGen.generate(currentWorld, randomGenerator, position);
	        }      
	        for (int g1 = 0; g1 < this.lavafallsperchunk; g1++){
	        	int g2 = chunk_X + randomGenerator.nextInt(16) + 8;
	        	int h1 = randomGenerator.nextInt(108) + 10;
	            int g3 = chunk_Z + randomGenerator.nextInt(16);
	            BlockPos position = new BlockPos(g2, h1, g3);
	            this.lavafallGen = new WorldGenSoulWaterfalls(Block.getBlockFromName("flowing_lava"), this.blockToPlaceWaterIn, true);
	            this.lavafallGen.generate(currentWorld, randomGenerator, position);
	        }
		for (int g1 = 0; g1 < this.bogwaterperchunk * 30; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(8);
		    int h1 = randomGenerator.nextInt(98) + 25;
		    int g3 = chunk_Z + randomGenerator.nextInt(8);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.bogwaterGen.generate(currentWorld, randomGenerator, position);
		}     
		for (int g1 = 0; g1 < this.soulfiresperchunk; g1++){
		    int g2 = chunk_X + randomGenerator.nextInt(16);
		    int h1 = randomGenerator.nextInt(128);
		    int g3 = chunk_Z + randomGenerator.nextInt(16);
		    BlockPos position = new BlockPos(g2, h1, g3);
		    this.soulfireGen.generate(currentWorld, randomGenerator, position);
		}		    	
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, new BlockPos(chunk_X, 0, chunk_Z)));		
    }
}