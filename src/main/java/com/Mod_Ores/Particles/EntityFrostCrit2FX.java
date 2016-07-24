package com.Mod_Ores.Particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class EntityFrostCrit2FX extends EntityFX{
    /** Entity that had been hit and done the Critical hit on. */
    private Entity theEntity;
    private int currentLife;
    private int maximumLife;
    private String particleName;

    public EntityFrostCrit2FX(World par1World, Entity par2Entity){
        this(par1World, par2Entity, "frostcrit");
    }

    public EntityFrostCrit2FX(World par1World, Entity par2Entity, String par3Str){
        super(par1World, par2Entity.posX, par2Entity.getCollisionBoundingBox().minY + (double)(par2Entity.height / 2.0F), par2Entity.posZ, par2Entity.motionX, par2Entity.motionY, par2Entity.motionZ);
        this.theEntity = par2Entity;
        this.maximumLife = 3;
        this.particleName = par3Str;
        this.onUpdate();
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {}

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate(){
        for (int i = 0; i < 16; ++i){
            double d0 = 0.0F;
            double d1 = 0.0F;
            double d2 = 0.6F;
            double d3 = this.theEntity.posX + d0 * (double)this.theEntity.width / 4.0D;
            double d4 = this.theEntity.getCollisionBoundingBox().minY + (double)(this.theEntity.height / 2.0F) + d1 * (double)this.theEntity.height / 4.0D;
            double d5 = this.theEntity.posZ + d2 * (double)this.theEntity.width / 4.0D;
            //this.worldObj.spawnParticle(this.particleName, d3, d4, d5, d0, d1, d2);
            this.worldObj.spawnParticle(EnumParticleTypes.CRIT, d3, d4, d5, d0, d1, d2, new int[0]);
        }

        ++this.currentLife;

        if (this.currentLife >= this.maximumLife){
            this.setDead();
        }
    }

    public int getFXLayer(){
        return 3;
    }
}