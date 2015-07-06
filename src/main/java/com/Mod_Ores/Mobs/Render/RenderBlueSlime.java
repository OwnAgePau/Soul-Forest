package com.Mod_Ores.Mobs.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.Mod_Ores.Mobs.Entity.EntityKotek;

public class RenderBlueSlime extends RenderLiving
{
	private static ResourceLocation field_110897_a;
	private ModelBase scaleAmount;
	private String textureName;
	
	public RenderBlueSlime (ModelSlime ModelSlime, ModelBase par2ModelBase, float f)
	{
		super(ModelSlime, f);
		this.scaleAmount = par2ModelBase;
	}
 
    /**
     * Determines whether Slime Render should pass or not.
     */
    protected int shouldSlimeRenderPass(EntityKotek par1EntitySlime, int par2, float par3)
    {
        if (par1EntitySlime.isInvisible())
        {
            return 0;
        }
        else if (par2 == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }
        else
        {
            if (par2 == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return -1;
        }
    }
    
    /**
     * sets the scale for the slime based on getSlimeSize in EntitySlime
     */
    protected void doRenderCallBack(EntityKotek par1EntitySlime, float par2)
    {
        float f1 = (float)par1EntitySlime.getSlimeSize();
        float f2 = (par1EntitySlime.prevSquishFactor + (par1EntitySlime.squishFactor - par1EntitySlime.prevSquishFactor) * par2) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
    
    protected ResourceLocation func_110896_a(EntityKotek par1EntitySlime)
    {
        if(EntityKotek.slimeSize == 1)
        {
        	this.textureName = "bluekotek.png";
        }
        else if(EntityKotek.slimeSize == 2)
        {
        	this.textureName = "redkotek.png";
        }	
        else
        {
        	this.textureName = "greenkotek.png";
        }
        field_110897_a = new ResourceLocation("soulforest:textures/entities/kotek/" + this.textureName);
        return field_110897_a;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.doRenderCallBack((EntityKotek)par1EntityLivingBase, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldSlimeRenderPass((EntityKotek)par1EntityLivingBase, par2, par3);
    }


	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return this.func_110896_a((EntityKotek)var1);
	}
}
