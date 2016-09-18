package com.Mod_Ores;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.Mod_Ores.Blocks.Special.Fluid.SoulWaterFlowing;
import com.Mod_Ores.Init.SoulBlocks;
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
}