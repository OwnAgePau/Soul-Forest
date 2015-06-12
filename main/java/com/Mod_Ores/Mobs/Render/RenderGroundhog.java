package com.Mod_Ores.Mobs.Render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.Mod_Ores.Mobs.Entity.EntityGroundhog;
import com.Mod_Ores.Mobs.Model.ModelGroundhog;

public class RenderGroundhog extends RenderLiving{
    protected ModelGroundhog model;

    public RenderGroundhog (ModelGroundhog ModelFairy, float f){
	super(ModelFairy, f);
	model = ((ModelGroundhog)mainModel);
    }

    public void renderGroundhog(EntityGroundhog entity, double par2, double par4, double par6, float par8, float par9){
	super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
	renderGroundhog((EntityGroundhog)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
	renderGroundhog((EntityGroundhog)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
	return (new ResourceLocation("soulforest:textures/entities/Groundhog.png"));
    }
}
