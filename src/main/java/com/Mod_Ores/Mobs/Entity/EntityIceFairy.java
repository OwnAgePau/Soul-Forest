package com.Mod_Ores.Mobs.Entity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;

public class EntityIceFairy extends EntityMob{
    private BlockPos spawnPosition;

    private double moveSpeed;

    public EntityIceFairy(World world){
		super(world);
		this.moveSpeed = SoulConfigCreatures.icefairyMovement;
		this.setCustomNameTag(this.getCommandSenderName());
		this.setSize(0.8F, 1.0F);
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
		//this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySnowCreeper.class, false));
    }

    public String getCommandSenderName() {
    	return "Ice Fairy";
    }

    // Set max health and attack damage
    @Override
    protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(SoulConfigCreatures.icefairyFollowRange);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulConfigCreatures.icefairyHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulConfigCreatures.icefairyDamage);
    }


    public int getAttackStrength(Entity par1Entity){
    	return 15;
    }

    @Override
	public EntityLivingBase getAttackTarget(){
		EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 16.0D);
		return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
    }

    protected boolean isAIEnabled(){
    	return true;
    }
    
    public boolean canBePushed(){
        return false;
    }

    protected boolean canTriggerWalking(){
    	return false;
    }
    
    protected float getSoundVolume(){
        return 0.3F;
    }
    
    protected float getSoundPitch(){
        return super.getSoundPitch() * 0.95F;
    }
    
    protected String getLivingSound(){
    	return this.rand.nextInt(8) != 0 ? null : "mob.bat.idle";
    }

    protected String getHurtSound(){
    	return "mob.bat.hurt";
    }

    protected String getDeathSound(){
    	return "mob.bat.death";
    }
    
    @Override
    protected Item getDropItem(){
    	return SoulItems.PolisherTowel.get();
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2){
		Random r = new Random();
		this.dropItem(SoulItems.PolisherTowel.get(), r.nextInt(3) + 1);
		this.dropItem(SoulItems.Soul.get(), r.nextInt(2) + 1);
    }

    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase){
		super.onKillEntity(par1EntityLivingBase);
		this.dropRareDrop(2);
    }

    protected void dropRareDrop(int par1){
		switch (this.rand.nextInt(3)){
		case 0:
		    this.dropItem(SoulItems.FrozenRod.get(), 3);
		    break;
		case 1:
		    this.dropItem(SoulItems.FrostShard.get(), this.rand.nextInt(4));
		    break;
		case 2:
		    this.dropItem(SoulItems.LightShard.get(), 5);
		    break;
		}
    }

    protected boolean canDespawn(){
    	return false;
    }

    public boolean attackEntityFrom(DamageSource dmgSource, int damage){
		if (this.isEntityInvulnerable(dmgSource)){
		    return false;
		}
		else{
		    return super.attackEntityFrom(dmgSource, damage);
		}
    }

    protected void fall(float par1) {}

    protected void updateFallState(double par1, boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate(){
    	return true;
    }

    public void onUpdate(){
		super.onUpdate();
		this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks(){
		super.updateAITasks();
		if (this.worldObj.getClosestPlayerToEntity(this, 4.0D) != null){
		    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
		}
		else{
		    if (!this.worldObj.isBlockNormalCube(new BlockPos(MathHelper.floor_double(this.posX), (int)this.posY + 1, MathHelper.floor_double(this.posZ)), false)){
		    	this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
		    }
		    else{
				if (this.rand.nextInt(200) == 0){
				    this.rotationYawHead = (float)this.rand.nextInt(360);
				}
		    }
	
		    if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)){
		    	this.spawnPosition = null;
		    }
	
		    if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F){
		    	this.spawnPosition  = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		    }
	
		    double d0 = (double)this.getAttackTarget().posX + 0.5D - this.posX;
		    double d1 = (double)this.getAttackTarget().posY + 0.1D - this.posY;
		    double d2 = (double)this.getAttackTarget().posZ + 0.5D - this.posZ;
		    this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
		    this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		    this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
		    float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
		    float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		    this.moveForward = 0.5F;
		    this.rotationYaw += f1;
		}
    }
}
