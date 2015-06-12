/*package Mod_Ores.BiomeGen;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBeach;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMushroomIsland;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import Mod_Ores.Mobs.Entity.EntityBlueSlime;
import Mod_Ores.Mobs.Entity.EntityEnt;
import Mod_Ores.Mobs.Entity.EntityIceFairy;
import Mod_Ores.Mobs.Entity.EntitySnowCreeper;
import Mod_Ores.BiomeGen.TheBiomeDeco;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenBaseMarona extends BiomeGenBase
{
	 	public static final BiomeGenBaseMarona[] biomeList = new BiomeGenBaseMarona[256];
	 	
	 	public static final BiomeGenBaseMarona SoulForest = (new BiomeGenSoulForest(0).setBiomeName("SoulForest").setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.0F, 0.9F)); //Custom Biome
	 	public static final BiomeGenBaseMarona FrostCaves = (new BiomeGenFrostCaves(1).setBiomeName("FrostCaves").setEnableSnow().setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.0F, 0.9F)); //Custom Biome
			    
		public String biomeName;
	    public int color;
	    public byte topBlock;

		public byte fillerBlock;
		public int field_76754_C;
	
		public float minHeight;	
		public float maxHeight;	
		public float temperature;	
		public float rainfall;
	
		public int waterColorMultiplier;
	
		public BiomeDecorator theBiomeDecorator;
	
		protected List spawnableMonsterList;	
		protected List spawnableCreatureList;	
		protected List spawnableWaterCreatureList;
		protected List spawnableCaveCreatureList;
	
		private boolean enableSnow;	
		private boolean enableRain;
	
		public final int biomeID;
		
	    protected WorldGenTrees worldGeneratorTrees;
	    protected WorldGenBigTree worldGeneratorBigTree;
	    protected WorldGenForest worldGeneratorForest;	    
	    protected WorldGenSwamp worldGeneratorSwamp;
	    
		public BiomeGenBaseMarona(int par1) 
		{
			super(par1);
			this.topBlock = (byte)Block.grass.blockID;
	        this.fillerBlock = (byte)Block.dirt.blockID;
	        this.field_76754_C = 5169201;
	        this.minHeight = 0.1F;
	        this.maxHeight = 0.3F;
	        this.temperature = 0.5F;
	        this.rainfall = 0.5F;
	        this.waterColorMultiplier = 16777215;
	        this.spawnableMonsterList = new ArrayList();
	        this.spawnableCreatureList = new ArrayList();
	        this.spawnableWaterCreatureList = new ArrayList();
	        this.spawnableCaveCreatureList = new ArrayList();
	        this.enableRain = true;
	        this.biomeID = par1;
	        biomeList[par1] = this;
	        this.worldGeneratorTrees = new WorldGenTrees(false);
	        this.worldGeneratorBigTree = new WorldGenBigTree(false);
	        this.worldGeneratorForest = new WorldGenForest(false);
	        this.worldGeneratorSwamp = new WorldGenSwamp();
	        this.theBiomeDecorator = this.createBiomeDecorator();
	        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
	        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
	        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
	        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 10, 4, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 10, 4, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntityBlueSlime.class, 7, 5, 10));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntitySnowCreeper.class, 6, 2, 4));
	        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnt.class, 8, 3, 5));
	        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityIceFairy.class, 10, 10, 10));
	        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
	        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
		}

		public BiomeDecorator createBiomeDecorator()
	    {   
	        return getModdedBiomeDecorator(new BiomeDecorator(this));
	    }

		public BiomeGenBaseMarona setTemperatureRainfall(float par1, float par2)
	    {
	        if (par1 > 0.1F && par1 < 0.2F)
	        {
	            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
	        }
	        else
	        {
	            this.temperature = par1;
	            this.rainfall = par2;
	            return this;
	        }
	    }

		public BiomeGenBaseMarona setMinMaxHeight(float par1, float par2)
	    {
	        this.minHeight = par1;
	        this.maxHeight = par2;
	        return this;
	    }

		public BiomeGenBaseMarona setDisableRain()
	    {
	        this.enableRain = false;
	        return this;
	    }

		public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	    {
	        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
	    }

		public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	    {
	        return new WorldGenTallGrass(Block.tallGrass.blockID, 1);
	    }

		public BiomeGenBaseMarona setEnableSnow()
	    {
	        this.enableSnow = true;
	        return this;
	    }

	    public BiomeGenBaseMarona setBiomeName(String par1Str)
	    {
	        this.biomeName = par1Str;
	        return this;
	    }

	    public BiomeGenBaseMarona func_76733_a(int par1)
	    {
	        this.field_76754_C = par1;
	        return this;
	    }

	    public BiomeGenBaseMarona setColor(int par1)
	    {
	        this.color = par1;
	        return this;
	    }

	    @SideOnly(Side.CLIENT)

	    public int getSkyColorByTemp(float par1)
	    {
	        par1 /= 3.0F;

	        if (par1 < -1.0F)
	        {
	            par1 = -1.0F;
	        }

	        if (par1 > 1.0F)
	        {
	            par1 = 1.0F;
	        }

	        return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
	    }

	    public List getSpawnableList(EnumCreatureType par1EnumCreatureType)
	    {
	        return par1EnumCreatureType == EnumCreatureType.monster ? this.spawnableMonsterList : (par1EnumCreatureType == EnumCreatureType.creature ? this.spawnableCreatureList : (par1EnumCreatureType == EnumCreatureType.waterCreature ? this.spawnableWaterCreatureList : (par1EnumCreatureType == EnumCreatureType.ambient ? this.spawnableCaveCreatureList : null)));
	    }

	    public boolean getEnableSnow()
	    {
	        return this.enableSnow;
	    }

	    public boolean canSpawnLightningBolt()
	    {
	        return this.enableSnow ? false : this.enableRain;
	    }

	    public boolean isHighHumidity()
	    {
	        return this.rainfall > 0.85F;
	    }

	    public float getSpawningChance()
	    {
	        return 0.1F;
	    }

	    public final float getFloatRainfall()
	    {
	        return this.rainfall;
	    }

	    public final float getFloatTemperature()
	    {
	        return this.temperature;
	    }
	    
	    public void decorate(World par1World, Random par2Random, int par3, int par4)
	    {
	        this.theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
	    }
	    
	    public final int getIntRainfall()
	    {
	        return (int)(this.rainfall * 65536.0F);
	    }

	    public int getIntTemperature()
	    {
	        return (int)(this.temperature * 65536.0F);
	    }
	    
	    @SideOnly(Side.CLIENT)

	    public int getBiomeGrassColor()
	    {
	        double d0 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
	        double d1 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
	        return getModdedBiomeGrassColor(ColorizerGrass.getGrassColor(d0, d1));
	    }

	    @SideOnly(Side.CLIENT)

	    public int getBiomeFoliageColor()
	    {
	        double d0 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
	        double d1 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
	        return getModdedBiomeFoliageColor(ColorizerFoliage.getFoliageColor(d0, d1));
	    }

	    public BiomeDecorator getModdedBiomeDecorator(BiomeDecorator original)
	    {
	    	BiomeEventMarona.CreateDecorator event = new BiomeEventMarona.CreateDecorator(this, original);
	        MinecraftForge.TERRAIN_GEN_BUS.post(event);
	        return event.newTheBiomeDeco;
	    }

	    @SideOnly(Side.CLIENT)
	    public int getWaterColorMultiplier()
	    {
	    	BiomeEventMarona.GetWaterColor event = new BiomeEventMarona.GetWaterColor(this, waterColorMultiplier);
	        MinecraftForge.EVENT_BUS.post(event);
	        return event.newColor;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public int getModdedBiomeGrassColor(int original)
	    {
	    	BiomeEventMarona.GetGrassColor event = new BiomeEventMarona.GetGrassColor(this, original);
	        MinecraftForge.EVENT_BUS.post(event);
	        return event.newColor;
	    }
	    

	    @SideOnly(Side.CLIENT)
	    public int getModdedBiomeFoliageColor(int original)
	    {
	    	BiomeEventMarona.GetFoliageColor event = new BiomeEventMarona.GetFoliageColor(this, original);
	        MinecraftForge.EVENT_BUS.post(event);
	        return event.newColor;
	    }
}*/
