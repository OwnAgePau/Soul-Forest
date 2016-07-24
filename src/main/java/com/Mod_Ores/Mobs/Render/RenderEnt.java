package com.Mod_Ores.Mobs.Render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.Mod_Ores.Mobs.Entity.EntityEnt;

public class RenderEnt extends RenderLiving{
	protected ModelZombie model;
 
	public RenderEnt (RenderManager manager, ModelZombie modelZombie, float f){
		super(manager, modelZombie, f);
	  	model = ((ModelZombie)mainModel);
	}
 
 	public void renderEnt(EntityEnt entity, double par2, double par4, double par6, float par8, float par9){
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
 
 	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
 		renderEnt((EntityEnt)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
 		renderEnt((EntityEnt)par1Entity, par2, par4, par6, par8, par9);
    }
 
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return (new ResourceLocation("soulforest:textures/entities/SoulYeti.png"));
	}
}
