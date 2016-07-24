package com.Mod_Ores.Mobs.Render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.Mod_Ores.Mobs.Entity.EntityIceFairy;
import com.Mod_Ores.Mobs.Model.ModelFairy;

public class RenderIceFairy extends RenderLiving{
    protected ModelFairy model;

    public RenderIceFairy (RenderManager manager, ModelFairy modelFairy, float f){
		super(manager, modelFairy, f);
		model = ((ModelFairy)mainModel);
    }

    public void renderIceFairy(EntityIceFairy entity, double par2, double par4, double par6, float par8, float par9){
    	super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
    	renderIceFairy((EntityIceFairy)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
    	renderIceFairy((EntityIceFairy)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    	return (new ResourceLocation("soulforest:textures/entities/Fairy.png"));
    }
}