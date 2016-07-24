package com.Mod_Ores.Items.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFrostShard extends EntityThrowable{
    
	private static final String __OBFID = "CL_00001722";

    private double damage = 12.0D;
    private int knockbackStrength = 5;

    public EntityFrostShard(World p_i1773_1_){
    	super(p_i1773_1_);
    }

    public EntityFrostShard(World worldObj, EntityLivingBase p_i1774_2_){
    	super(worldObj, p_i1774_2_);
    }

    public EntityFrostShard(World worldObj, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_){
    	super(worldObj, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected void entityInit(){
    	this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition p_70184_1_){
		if (p_70184_1_.entityHit != null){
		    byte b0 = (byte) this.getDamage();
	
		    if (p_70184_1_.entityHit instanceof EntityBlaze){
		    	b0 = 3;
		    }
	
		    p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
		}
	
		for (int i = 0; i < 8; ++i){
		    this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
	
		if (!this.worldObj.isRemote){
		    this.setDead();
		}
    }

    public void setIsCritical(boolean b) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		if (b){
		    this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
		}
		else{
		    this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
		}
    }

    public boolean getIsCritical(){
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		return (b0 & 1) != 0;
    }

    public void setDamage(double par1){
    	this.damage = par1;
    }

    public double getDamage(){
    	return this.damage;
    }

    public void setKnockbackStrength(int par1){
    	this.knockbackStrength = par1;
    }
}