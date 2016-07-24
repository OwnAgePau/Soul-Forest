package com.Mod_Ores.Items.Entity;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySmallSoulFireball extends EntitySmallFireball{
    private static final String __OBFID = "CL_00001721";

    public EntitySmallSoulFireball(World world){
        super(world);
    }

    public EntitySmallSoulFireball(World world, EntityLivingBase entityLiving, double accelX, double accelY, double accelZ){
        super(world, entityLiving, accelX, accelY, accelZ);
    }

    public EntitySmallSoulFireball(World world, double x, double y, double z, double accelX, double accelY, double accelZ){
        super(world, x, y, z, accelX, accelY, accelZ);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition movingObject){
        if (!this.worldObj.isRemote){
            if (movingObject.entityHit != null){
                if (!movingObject.entityHit.isImmuneToFire()){
                	movingObject.entityHit.setFire(5);
                }
                movingObject.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 5.0F);
                //p_70227_1_.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F);
            }
            else{                
                BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);

                if (this.worldObj.isAirBlock(blockpos)){
                    this.worldObj.setBlockState(blockpos, SoulBlocks.SoulFire.get().getDefaultState());
                }
            }
            this.setDead();
        }
    }
}