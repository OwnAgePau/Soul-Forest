package com.Mod_Ores.Particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class EntityOreFX extends EntityFX{
    float reddustParticleScale;

    public EntityOreFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10){
        this(par1World, par2, par4, par6, 1.0F, par8, par9, par10);
    }

    public EntityOreFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, float par11){
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;

        float f4 = (float)Math.random() * 0.4F + 0.6F;
        //this.particleRed = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * par9 * f4;
        //this.particleGreen = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * par10 * f4;
        //this.particleBlue = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * par11 * f4;
        this.particleRed = par9;
        this.particleGreen = par10;
        this.particleBlue = par11;
        this.particleScale *= 0.75F;
        this.particleScale *= par8;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * par8);
        this.noClip = false;
    }
    
    public void renderParticle(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_){
    	float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge * 32.0F;
    	if (f < 0.0F){
            f = 0.0F;
        }
        if (f > 1.0F){
            f = 1.0F;
        }
        this.particleScale = this.reddustParticleScale * (1.0F - f * f * 0.5F);
        super.renderParticle(worldRendererIn, entityIn, partialTicks, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
    }


    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate(){
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge){
            this.setDead();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY){
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround){
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}