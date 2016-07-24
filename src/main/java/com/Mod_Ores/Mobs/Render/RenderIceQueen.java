package com.Mod_Ores.Mobs.Render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import com.Mod_Ores.Mobs.Entity.EntityIceQueen;
import com.Mod_Ores.Mobs.Entity.EntityIceQueenIllusion;
import com.Mod_Ores.Mobs.Model.ModelIceQueen;

public class RenderIceQueen extends RenderLiving{
    protected ModelIceQueen model;

    public RenderIceQueen (RenderManager manager, ModelIceQueen modelIceQueen, float f){
		super(manager, modelIceQueen, f);
		model = ((ModelIceQueen)mainModel);
    }

    public void renderIceQueen(EntityIceQueen entity, double par2, double par4, double par6, float par8, float par9){
		BossStatus.setBossStatus(entity, false);
		super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    public void renderIceQueenIllusion(EntityIceQueenIllusion entity, double par2, double par4, double par6, float par8, float par9){
    	super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		if(par1EntityLiving instanceof EntityIceQueen){
		    renderIceQueen((EntityIceQueen)par1EntityLiving, par2, par4, par6, par8, par9); 
		}
		else{
		    renderIceQueenIllusion((EntityIceQueenIllusion)par1EntityLiving, par2, par4, par6, par8, par9);
		}	
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
		if(par1Entity instanceof EntityIceQueen){
		    renderIceQueen((EntityIceQueen)par1Entity, par2, par4, par6, par8, par9);
		}
		else{
		    renderIceQueenIllusion((EntityIceQueenIllusion)par1Entity, par2, par4, par6, par8, par9);
		}
    }
    
    /*protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3){
	if(par1EntityLivingBase instanceof EntityIceQueen){
	    BossStatus.setBossStatus((EntityIceQueen)par1EntityLivingBase, false);
	}
	if (par1EntityLivingBase.isInvisible()){
	    return 0;
	}
	else if (par2 == 0){
	    return 1;
	}
	else{
	    return -1;
	}
    }*/

    @Override
    protected ResourceLocation getEntityTexture(Entity entity){
    	return (new ResourceLocation("soulforest:textures/entities/IceQueen.png"));
    }
}