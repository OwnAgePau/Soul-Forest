package com.Mod_Ores.Items.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBigFrostShard extends EntitySmallFireball {

    public EntityBigFrostShard(World worldObj) {
	super(worldObj);
    }

    public EntityBigFrostShard(World worldObj, EntityLivingBase entity, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_){
        super(worldObj, entity, p_i1771_3_, p_i1771_5_, p_i1771_7_);
    }

    public EntityBigFrostShard(World worldObj, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_){
        super(worldObj, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObj){
	if (movingObj.entityHit != null){
	    movingObj.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), (float)this.shootingEntity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() / 3);
	    this.shootingEntity.worldObj.createExplosion(this.shootingEntity, this.posX, this.posY, this.posZ, 2F, false);
	}
	
	if (!this.worldObj.isRemote){
	    this.setDead();
	}
    }
}
