package com.Mod_Ores;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Items.Entity.EntityFrostShard;
import com.Mod_Ores.Items.Entity.RenderFrostShard;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy {    
    @Override
    public void registerRenderers() {
	EntityRegistry.registerGlobalEntityID(EntityFrostShard.class, "Frost_shard", EntityRegistry.findGlobalUniqueEntityId());
	RenderingRegistry.registerEntityRenderingHandler(EntityFrostShard.class, new RenderFrostShard(SoulItems.FrostShard.get()));
    }

    public int addArmor(String armor){
	return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}