package com.Mod_Ores.Particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class EntityFyriteFX extends EntityFX{
    public EntityFyriteFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12){
        super(par1World, par2, par4, par6, par8, par10, par12);
        //float f = this.rand.nextFloat() * 0.1F + 0.2F;
        this.particleRed = 0.3F;
        this.particleGreen = 0F;
        this.particleBlue = 0F;
        this.setParticleTextureIndex(0);
        this.setSize(0.01F, 0.01F);
        this.particleScale *= this.rand.nextFloat() * 0.9F + 0.9F;
        this.motionX *= 0.019999999552965164D;
        this.motionY *= 0.119999999552965164D;
        this.motionZ *= 0.019999999552965164D;
        this.particleMaxAge = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
        this.noClip = true;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate(){
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99D;
        this.motionY *= 0.99D;
        this.motionZ *= 0.99D;

        if (this.particleMaxAge-- <= 0){
            this.setDead();
        }
    }
}