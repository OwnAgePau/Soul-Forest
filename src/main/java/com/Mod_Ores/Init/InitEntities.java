package com.Mod_Ores.Init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Items.Entity.EntityFrostShard;
import com.Mod_Ores.Items.Entity.RenderFrostShard;
import com.Mod_Ores.Mobs.Entity.EntityEnt;
import com.Mod_Ores.Mobs.Entity.EntityFurivoli;
import com.Mod_Ores.Mobs.Entity.EntityGroundhog;
import com.Mod_Ores.Mobs.Entity.EntityIceFairy;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;
import com.Mod_Ores.Mobs.Entity.EntityIceQueenIllusion;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;
import com.Mod_Ores.Mobs.Entity.EntityKotek;
import com.Mod_Ores.Mobs.Entity.EntitySnowCreeper;
import com.Mod_Ores.Mobs.Model.ModelFairy;
import com.Mod_Ores.Mobs.Model.ModelFurivoli;
import com.Mod_Ores.Mobs.Model.ModelGroundhog;
import com.Mod_Ores.Mobs.Model.ModelIceQueen;
import com.Mod_Ores.Mobs.Render.RenderBlueSlime;
import com.Mod_Ores.Mobs.Render.RenderEnt;
import com.Mod_Ores.Mobs.Render.RenderFurivoli;
import com.Mod_Ores.Mobs.Render.RenderGroundhog;
import com.Mod_Ores.Mobs.Render.RenderIceFairy;
import com.Mod_Ores.Mobs.Render.RenderIceQueen;
import com.Mod_Ores.Mobs.Render.RenderKingKotek;
import com.Mod_Ores.Mobs.Render.RenderSnowCreeper;

public class InitEntities 
{

    // Entity Registry
    public static void init()
    {
		// Mob Entity Registry		
		// Entity Blue Slime
		EntityRegistry.registerGlobalEntityID(EntityKotek.class, "SoulKotek", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityKotek.class, 0x33CC33, 0x0066FF);
	
		// King Kotek
		EntityRegistry.registerGlobalEntityID(EntityKingKotek.class, "SoulKingKotek", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityKingKotek.class, 0x33CC33, 0xFFE066);
	
		// Entity Ent
		EntityRegistry.registerGlobalEntityID(EntityEnt.class, "SoulYeti", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityEnt.class, 0xE6E6E6, 0xffffff);
	
		// Entity Snow Creeper
		EntityRegistry.registerGlobalEntityID(EntitySnowCreeper.class, "SoulExclos", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntitySnowCreeper.class, 0xffffff, 0xE6E6E6);
	
		// Entity Ice Fairy
		EntityRegistry.registerGlobalEntityID(EntityIceFairy.class, "SoulIceFairy", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityIceFairy.class, 0xffffff, 0xCCFFFF);
	
	
		// Entity Groundhog
		EntityRegistry.registerGlobalEntityID(EntityGroundhog.class, "SoulGroundhog", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityGroundhog.class, 0x002900, 0x003300);
	
		// Entity Furivoli
		EntityRegistry.registerGlobalEntityID(EntityFurivoli.class, "SoulFurivoli", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityFurivoli.class, 0x6B4700, 0x993300);
	
		// Entity Ice Queen
		EntityRegistry.registerGlobalEntityID(EntityIceQueen.class, "SoulIceQueen", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityIceQueen.class, 0xffffff, 0xCCFFFF);
		
		// Entity Ice Queen Illusion
		EntityRegistry.registerGlobalEntityID(EntityIceQueenIllusion.class, "SoulIceQueenIllusion", EntityRegistry.findGlobalUniqueEntityId());
		soul_forest.registerEntityEgg(EntityIceQueenIllusion.class, 0xffffff, 0xCCFFFF);
	
		// Throwable Entity Registry
		// Entity Frost Shard
	
		registerRenderers();
		System.out.println("[Soul Forest] Entities registered");
    }

    public static void registerRenderers()
    {
		// Renderer Registry
		// Renderers for mobs
    	RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		RenderingRegistry.registerEntityRenderingHandler(EntityEnt.class, new RenderEnt(manager, new ModelZombie(), 0.5F)); // The float is the size of the shadow	
		RenderingRegistry.registerEntityRenderingHandler(EntityKotek.class, new RenderBlueSlime(manager, new ModelSlime(0), new ModelSlime(10), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowCreeper.class, new RenderSnowCreeper(manager, new ModelCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceFairy.class, new RenderIceFairy(manager, new ModelFairy(), 0.5F));	
		RenderingRegistry.registerEntityRenderingHandler(EntityGroundhog.class, new RenderGroundhog(manager, new ModelGroundhog(), 1.0F));	
		RenderingRegistry.registerEntityRenderingHandler(EntityFurivoli.class, new RenderFurivoli(manager, new ModelFurivoli(), 0.8F));	
		RenderingRegistry.registerEntityRenderingHandler(EntityKingKotek.class, new RenderKingKotek(manager, new ModelSlime(0), new ModelSlime(40), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceQueen.class, new RenderIceQueen(manager, new ModelIceQueen(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceQueenIllusion.class, new RenderIceQueen(manager, new ModelIceQueen(), 1.0F));
	
		// Renderers for throwable entities
		//RenderItem itemRender = Minecraft.getMinecraft().getRenderItem();
		//RenderingRegistry.registerEntityRenderingHandler(EntityFrostShard.class, new RenderFrostShard(manager, SoulItems.FrostShard.get(), itemRender));
    }
}