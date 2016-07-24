package com.Mod_Ores;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Items.Entity.EntityFrostShard;
import com.Mod_Ores.Items.Entity.RenderFrostShard;

public class ClientProxy extends CommonProxy {    
    @Override
    public void registerRenderers() {
    	RenderItem itemRender = Minecraft.getMinecraft().getRenderItem();
    	RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostShard.class, new RenderFrostShard(manager, SoulItems.FrostShard.get(), itemRender));
		EntityRegistry.registerGlobalEntityID(EntityFrostShard.class, "Frost_shard", EntityRegistry.findGlobalUniqueEntityId());
    }

    /*public int addArmor(String armor){
    	return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }*/
}