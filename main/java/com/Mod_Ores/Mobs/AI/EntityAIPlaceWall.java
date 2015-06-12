package com.Mod_Ores.Mobs.AI;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;

public class EntityAIPlaceWall extends EntityAITarget{

    private EntityIceQueen queenEntity;

    private final Class targetClass;
    private final EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter; 
    private final IEntitySelector targetEntitySelector;
    private EntityLivingBase targetEntity;

    boolean entityCallsForHelp;
    private int timeUntillWall;
    private int wallHeight;
    private int wallWidth;
    private EntityPlayerMP player;
    private ChunkCoordinates wallCoords = null;
    private boolean isHorizontal = false;
    private static String __OBFID = "CL_00001619";

    public EntityAIPlaceWall(EntityCreature entity, Class targetClass, boolean callsForHelp){
	this(entity, targetClass, false, 2, 3);
    }

    public EntityAIPlaceWall(EntityCreature entity, Class targetClass, boolean callsForHelp, int wallHeight, int wallWidth){
	this(entity, targetClass, callsForHelp, wallHeight, wallWidth, (IEntitySelector)null);
    }

    public EntityAIPlaceWall(EntityCreature entity, Class targetClass, boolean callsForHelp, int wallHeight, int wallWidth, final IEntitySelector entitySelector){
	super(entity, false);
	this.queenEntity = (EntityIceQueen)entity;
	this.theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(entity);
	this.targetClass = targetClass;
	this.entityCallsForHelp = callsForHelp;
	this.wallHeight = wallHeight;
	this.wallWidth = wallWidth;
	//this.setMutexBits(3);
	this.targetEntitySelector = new IEntitySelector(){
	    private static final String __OBFID = "CL_00001621";
	    /**
	     * Return whether the specified entity is applicable to this filter.
	     */
	    public boolean isEntityApplicable(Entity entity){
		return !(entity instanceof EntityLivingBase) ? false : (entitySelector != null && !entitySelector.isEntityApplicable(entity) ? false : EntityAIPlaceWall.this.isSuitableTarget((EntityLivingBase)entity, false));
	    }
	};
    }
    
    // TO DO 
    // SAVE THE LAST WALL LOCATIONS TO MBT ALSO THE TIMER
    // READ THE LAST WALL LOCATIONS FROM NBT
    
    // Make the wall placement not replace any other block.

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute(){
	int timeLeft = this.queenEntity.getTimeUntillPlaceWall();
	if(timeLeft <= 0){
	    double d0 = this.getTargetDistance();
	    List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), this.targetEntitySelector);
	    Collections.sort(list, this.theNearestAttackableTargetSorter);

	    if (list.isEmpty()){
		return false;
	    }
	    else{
		this.targetEntity = (EntityLivingBase)list.get(0);
		return true;
	    }
	}
	else{
	    return false;
	}
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting(){
	if(wallCoords != null){
	    this.removeWalls();
	}
	this.player = (EntityPlayerMP)this.targetEntity;
	ChunkCoordinates playerCoords = player.getPlayerCoordinates();
	int xPosQueen = MathHelper.floor_double(this.queenEntity.posX + 0.5D);
	int zPosQueen = MathHelper.floor_double(this.queenEntity.posZ + 0.5D);
	int wallX = 0;
	int wallZ = 0;
	this.isHorizontal = false;

	int difX = xPosQueen - playerCoords.posX;
	if(difX < 0){
	    difX = -difX;
	}
	int difZ = zPosQueen - playerCoords.posZ;
	if(difZ < 0){
	    difZ = -difZ;
	}

	if(xPosQueen > playerCoords.posX){ 
	    wallX += 2;    
	}
	else{
	    wallX -= 2;
	}

	if(zPosQueen > playerCoords.posZ){
	    wallZ += 2;
	}
	else{
	    wallZ -= 2;
	}

	if(difX > difZ){
	    this.isHorizontal = true;
	}
	else{
	    this.isHorizontal = false;
	}

	this.wallCoords = new ChunkCoordinates(playerCoords.posX + wallX, playerCoords.posY, playerCoords.posZ + wallZ);
	for(int y = 0; y < this.wallHeight; y++){
	    if(!this.isHorizontal){
		// Place blocks on x
		for(int x = 0; x < this.wallWidth; x++){
		    this.queenEntity.worldObj.setBlock(wallCoords.posX + x, wallCoords.posY + y, wallCoords.posZ, SoulBlocks.IceBrick.get());
		}
	    }
	    else{
		// Place blocks on z
		for(int z = 0; z < this.wallWidth; z++){
		    this.queenEntity.worldObj.setBlock(wallCoords.posX, wallCoords.posY + y, wallCoords.posZ + z, SoulBlocks.IceBrick.get());
		}
	    }
	}
	this.queenEntity.setTimeUntillPlaceWall(this.queenEntity.getMinTimePlaceWall());
	super.startExecuting();
    }

    private void removeWalls(){
	for(int y = 0; y < this.wallHeight; y++){
	    if(!isHorizontal){
		for(int x = 0; x < this.wallWidth; x++){
		    this.queenEntity.worldObj.setBlockToAir(wallCoords.posX + x, wallCoords.posY + y, wallCoords.posZ);
		    this.queenEntity.worldObj.createExplosion(this.queenEntity, wallCoords.posX + x, wallCoords.posY, wallCoords.posZ, 1F, false);
		}
	    }
	    else{
		for(int z = 0; z < this.wallWidth; z++){
		    this.queenEntity.worldObj.setBlockToAir(wallCoords.posX, wallCoords.posY + y, wallCoords.posZ + z);
		    this.queenEntity.worldObj.createExplosion(this.queenEntity, wallCoords.posX, wallCoords.posY, wallCoords.posZ + z, 1F, false);
		}
	    }
	}
    }
}
