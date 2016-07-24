package com.Mod_Ores.Particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class EntityTorchFlameFX extends EntityFX
{
    /** the scale of the flame FX */
    private float flameScale;
    public float red;
    public float blue;
    public float green;

    public EntityTorchFlameFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12){
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.motionX = this.motionX * 0.009999999776482582D + par8;
        this.motionY = this.motionY * 0.009999999776482582D + par10;
        this.motionZ = this.motionZ * 0.009999999776482582D + par12;
        double d6 = par2 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        d6 = par4 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        d6 = par6 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.flameScale = this.particleScale;   
        this.particleRed = this.red;
        this.particleGreen = this.blue;
        this.particleBlue = this.green;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        this.noClip = true;
        this.setParticleTextureIndex(48);
    }

    public void renderParticle(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_){
    	float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0F - f * f * 0.5F);
        super.renderParticle(worldRendererIn, entityIn, partialTicks, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
    }

    public int getBrightnessForRender(float par1){
        float f1 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;

        if (f1 < 0.0F){
            f1 = 0.0F;
        }

        if (f1 > 1.0F){
            f1 = 1.0F;
        }

        int i = super.getBrightnessForRender(par1);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f1 * 15.0F * 16.0F);

        if (j > 240){
            j = 240;
        }

        return j | k << 16;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1){
        float f1 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;

        if (f1 < 0.0F){
            f1 = 0.0F;
        }

        if (f1 > 1.0F){
            f1 = 1.0F;
        }

        float f2 = super.getBrightness(par1);
        return f2 * f1 + (1.0F - f1);
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

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround){
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
    
    public void setColour(float par1Red, float par2Blue, float par3Green){
    	this.red = par1Red;
    	this.blue = par2Blue;
    	this.green = par3Green;
    }
}