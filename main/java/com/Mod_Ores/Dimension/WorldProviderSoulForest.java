package com.Mod_Ores.Dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;

import com.Mod_Ores.Init.Config.SoulConfig;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderSoulForest extends WorldProvider{

    //The WorldProvider covers all the basics of the dimension. Look in WorldProviderBase.java and
    //WorldProvider.java for all the potential qualities you can assign to your dimension.
    public WorldType terrainType;

    /*public WorldProviderMarona()
	{
		this.isHellWorld = false;
		this.hasNoSky = true;
		this.getDimensionID();
		this.getDimensionName();
		this.getWelcomeMessage();
		this.getDepartMessage();
		this.canRespawnHere();
		this.isSkyColored();
		this.setCloudRenderer(null);
        this.registerWorldChunkManager();
        this.generateLightBrightnessTable();
	}*/

    //The save file will be called DIM65 (DIM + id number).
    public int getDimensionID(){			
	return 65;		
    }

    @SideOnly(Side.CLIENT)
    public boolean isSkyColored(){
	return false;
    }

    @Override 
    public boolean isSurfaceWorld(){
	return false;
    }

    @Override
    public String getDimensionName(){
	return "Soul Forest";
    }

    @Override
    public String getWelcomeMessage(){
	return "Entering the Soul Forest";
    }

    /**
     * Creates the light to brightness table
     */
    @Override
    protected void generateLightBrightnessTable(){
	float f = 0.1F;

	for (int i = 0; i <= 15; ++i)
	{
	    float f1 = 1.0F - (float)i / 15.0F;
	    this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
	}
    }

    @Override
    public String getDepartMessage(){
	return "Leaving the Soul Forest";
    }

    //You can use an existing WorldChunkManager, or create your own. You must create your own to
    //add multiple unique biomes to a dimension.
    public void registerWorldChunkManager(){			
	this.worldChunkMgr = new WorldChunkManagerSoulForest(worldObj.getSeed(), terrainType); 
	this.dimensionId = SoulConfig.SoulForestID;
	this.isHellWorld = false;
	this.hasNoSky = true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int p_76568_1_, int p_76568_2_){
        return true;
    }

    //This is where you define your terrain generator.
    @Override
    public IChunkProvider createChunkGenerator(){	
	return new ChunkProviderSoulForest(worldObj, worldObj.getSeed());		
    }

    //Note that, if you respawn in the dimension, you will end up at the coordinates 	of your
    //overworld spawn point, not at the location of your first entrance to the dimension or
    //something like that. Note also that beds don't work if yo	u cannot respawn in the dimension.
    @Override
    public boolean canRespawnHere(){

	return false;
    }

    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks){
	return worldObj.getSkyColorBody(cameraEntity, partialTicks);
    }

    @Override
    public Vec3 getFogColor(float par1, float par2){
	float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

	if (f2 < 0.0F){
	    f2 = 0.0F;
	}

	if (f2 > 1.0F){
	    f2 = 1.0F;
	}

	float f3 = 0.00000000F;
	float f4 = 0.34705883F;
	float f5 = 0.00000000F;
	f3 *= f2 * 0.94F + 0.06F;
	f4 *= f2 * 0.94F + 0.06F;
	f5 *= f2 * 0.91F + 0.09F;
	return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
    }

    @Override
    public float calculateCelestialAngle(long par1, float par3){
	int j = (int)(par1 % 24000L);
	float f1 = 24000.0F;

	return f1;
    }

    @Override
    public float[] calcSunriseSunsetColors(float par1, float par2){
	return null;
    }
}