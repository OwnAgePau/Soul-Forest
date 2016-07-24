package com.Mod_Ores.Mobs.AI;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityAITeleport<T extends EntityLivingBase> extends EntityAITarget{

    private final Class targetClass;
    private final EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter; 
    private final Predicate <? super T > targetEntitySelector;
    private EntityLivingBase targetEntity;

    private EntityCreature theEntity;
    private EntityPlayerMP player;
    private static final String __OBFID = "CL_00001584";
    private Random random;
    private float blocksTooFar = 16F;
    private float blocksTooClose = 2.3F;

    public EntityAITeleport(EntityCreature entity, Class<T> targetClass){
    	this(entity, targetClass, (Predicate <? super T >)null);
    }

    public EntityAITeleport(EntityCreature entity, Class<T> targetClass, final Predicate <? super T > entitySelector){
		super(entity, false);
		this.theEntity = entity;
		this.setMutexBits(4);
		random = new Random();
		((PathNavigateGround)entity.getNavigator()).setCanSwim(true);
		this.theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(entity);
		this.targetClass = targetClass;
			this.targetEntitySelector = new Predicate<T>(){	   
			public boolean apply(T entity){
				return !(entity instanceof EntityLivingBase) ? false : (entitySelector != null && !entitySelector.apply(entity) ? false : EntityAITeleport.this.isSuitableTarget((EntityLivingBase)entity, false));
			}					
		};
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute(){
		// Get Player from near area
		double d0 = this.getTargetDistance() * 3;
		List<T> list = this.taskOwner.worldObj.<T>getEntitiesWithinAABB(this.targetClass, this.taskOwner.getCollisionBoundingBox().expand(d0, 4.0D, d0), this.targetEntitySelector);
		Collections.sort(list, this.theNearestAttackableTargetSorter);
	
		if (list.isEmpty()){
		    return false;
		}
		else{
		    this.targetEntity = (EntityLivingBase)list.get(0);
		    this.player = (EntityPlayerMP)this.targetEntity;
		}
		if(this.player != null){
		    if(this.theEntity.isInWater() || this.theEntity.handleWaterMovement() || this.checkPlayerTooClose() || this.checkPlayerTooFar()){
			return true;
		    }
		}
		return false;
    }

    /**
     * Updates the task
     */
    public void updateTask(){
		if(this.checkPlayerTooClose()){
		    // Teleport randomly
		    this.teleportRandomly();
		}
		else{
		    // Teleport to player
		    this.teleportToEntity(this.player);
		}
    }

    private boolean checkPlayerTooClose(){
		double distance = getDistanceToPlayer();
		if(distance < 16.0F * this.blocksTooClose){
		    return true;
		}
		else{
		    return false;
		}
    }

    private boolean checkPlayerTooFar(){
		double distance = getDistanceToPlayer();
		if(distance > 32.0F * this.blocksTooFar){
		    return true;
		}
		else{
		    return false;
		}
    }

    private double getDistanceToPlayer(){
		BlockPos playerCoords = this.player.getPosition();
		int xPos = MathHelper.floor_double(this.theEntity.posX + 0.5D);
		int yPos = MathHelper.floor_double(this.theEntity.posY + 0.5D);
		int zPos = MathHelper.floor_double(this.theEntity.posZ + 0.5D);
		return playerCoords.distanceSq(xPos, yPos, zPos);
    }

    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly(){
		double d0 = this.theEntity.posX + (random.nextDouble() - 0.5D) * 24.0D; // was 64.0D
		double d1 = this.theEntity.posY + (double)(random.nextInt(64) - 32);
		double d2 = this.theEntity.posZ + (random.nextDouble() - 0.5D) * 24.0D; // was 64.0D
		return this.teleportTo(d0, d1, d2);
    }

    /**
     * Teleport the enderman to another entity
     */
    protected boolean teleportToEntity(Entity entity){
		Vec3 vec3 = new Vec3(this.theEntity.posX - entity.posX, this.theEntity.getCollisionBoundingBox().minY + (double)(this.theEntity.height / 2.0F) - entity.posY + (double)entity.getEyeHeight(), this.theEntity.posZ - entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.theEntity.posX + (random.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
		double d2 = this.theEntity.posY + (double)(random.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.theEntity.posZ + (random.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
    }
    
    protected boolean teleportTo(double x, double y, double z){
    	net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this.theEntity, x, y, z, 0);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
		double d3 = this.theEntity.posX;
		double d4 = this.theEntity.posY;
		double d5 = this.theEntity.posZ;
		this.theEntity.posX = x;
		this.theEntity.posY = y;
		this.theEntity.posZ = z;
		boolean flag = false;
		BlockPos blockPos = new BlockPos(this.theEntity.posX, this.theEntity.posY, this.theEntity.posZ);
	
		if (this.theEntity.worldObj.isBlockLoaded(blockPos)){
		    boolean flag1 = false;
	
		    while (!flag1 && blockPos.getY() > 0){
		    	 BlockPos blockPosBelow = blockPos.down();
	             Block block = this.theEntity.worldObj.getBlockState(blockPosBelow).getBlock();
		
				if (block.getMaterial().blocksMovement()){
				    flag1 = true;
				}
				else{
				    --this.theEntity.posY;
				    blockPos = blockPosBelow;
				}
		    }
	
		    if (flag1){
				this.theEntity.setPosition(this.theEntity.posX, this.theEntity.posY, this.theEntity.posZ);
				if (this.theEntity.worldObj.getCollidingBoundingBoxes(this.theEntity, this.theEntity.getCollisionBoundingBox()).isEmpty() && !this.theEntity.worldObj.isAnyLiquid(this.theEntity.getCollisionBoundingBox())){
				    flag = true;
				}
		    }
		}
	
		if (!flag){
		    this.theEntity.setPosition(d3, d4, d5);
		    return false;
		}
		else{
		    short short1 = 128;
	
		    for (int l = 0; l < short1; ++l){
				double d6 = (double)l / ((double)short1 - 1.0D);
				float f = (random.nextFloat() - 0.5F) * 0.2F;
				float f1 = (random.nextFloat() - 0.5F) * 0.2F;
				float f2 = (random.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.theEntity.posX - d3) * d6 + (random.nextDouble() - 0.5D) * (double)this.theEntity.width * 2.0D;
				double d8 = d4 + (this.theEntity.posY - d4) * d6 + random.nextDouble() * (double)this.theEntity.height;
				double d9 = d5 + (this.theEntity.posZ - d5) * d6 + (random.nextDouble() - 0.5D) * (double)this.theEntity.width * 2.0D;
				this.theEntity.worldObj.spawnParticle(EnumParticleTypes.PORTAL, d7, d8, d9, (double)f, (double)f1, (double)f2, new int[0]);
		    }
	
		    this.theEntity.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
		    this.theEntity.playSound("mob.endermen.portal", 1.0F, 1.0F);
		    return true;
		}
    }
}