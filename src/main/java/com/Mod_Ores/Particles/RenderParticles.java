package com.Mod_Ores.Particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import com.Mod_Ores.Items.Entity.EntityFrostShard;

public class RenderParticles
{
    private static Minecraft mc = Minecraft.getMinecraft();
    private static World theWorld = mc.theWorld;
    private static TextureManager renderEngine = mc.renderEngine;
    public static EntityFrostShard entity;

    public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12){
		if (mc != null && mc.getRenderViewEntity() != null && mc.effectRenderer != null){
		    int var14 = mc.gameSettings.particleSetting;
	
		    if (var14 == 1 && theWorld.rand.nextInt(3) == 0){
				var14 = 2;
			}
		
		    Entity renderView = mc.getRenderViewEntity();
			double var15 = renderView.posX - par2;
			double var17 = renderView.posY - par4;
			double var19 = renderView.posZ - par6;
			EntityFX var21 = null;
			double var22 = 16.0D;
			if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22){
			  	return null;
			}
			else if (var14 > 1){
			   	return null;
			}
			else{
				if (particleName.equals("fyrite"))//if the name of the particle to be spawned equals test spawn our particle note the name here is the name that you use when you call spawn particle
				{
				    var21 = new EntityFyriteFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
				}
				else if (particleName.equals("amazonite"))//if the name of the particle to be spawned equals test spawn our particle note the name here is the name that you use when you call spawn particle
				{
				    var21 = new EntityOreFX(theWorld, par2, par4, par6, 0.0F, 0.6F, 0.7F);
				}
				else if (particleName.equals("cobalt"))//if the name of the particle to be spawned equals test spawn our particle note the name here is the name that you use when you call spawn particle
				{
				    var21 = new EntityOreFX(theWorld, par2, par4, par6, 0.0F, 0.0F, 0.3F);
				}
				else if (particleName.equals("soulportal"))//if the name of the particle to be spawned equals test spawn our particle note the name here is the name that you use when you call spawn particle
				{
				    var21 = new EntitySoulPortalFX(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
				}
				else if (particleName.equals("frostcrit"))//if the name of the particle to be spawned equals test spawn our particle note the name here is the name that you use when you call spawn particle
				{
				    mc.effectRenderer.addEffect(new EntityFrostCrit2FX(mc.theWorld, entity));
				    return (EntityFX)var21;
				}
				/*else if (particleName.equals("flame"))
					{
						float red = (float)par8;
						float blue = (float)par10;
						float green = (float)par12;
						EntityTorchFlameFX entity;
						entity = new EntityTorchFlameFX(theWorld, par2, par4, par6, 0.0D, 0.0D, 0.0D);
						entity.setColour(red, blue, green);
						var21 = entity;
					}*/
		
				if((EntityFX)var21 != null){
				    mc.effectRenderer.addEffect((EntityFX)var21);
				    return (EntityFX)var21;
				}
		    }
		}	
		return null;
    }
}
