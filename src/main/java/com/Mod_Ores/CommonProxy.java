package com.Mod_Ores;

import com.Mod_Ores.Blocks.Special.Fluid.SoulWaterFlowing;
import com.Mod_Ores.EventHandlers.CommonTickHandler;
import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy{
    public static String ITEMS_PNG = "soulforest/textures/items.png";
    public static final ResourceLocation FrostShard = new ResourceLocation("soulforest:textures/entities/Frost_shard.png");

    public void initialize() {
    	FMLCommonHandler.instance().bus().register(new CommonTickHandler(Minecraft.getMinecraft()));
    }

    public void registerRenderers(){}

    public int addArmor(String string){
    	return 0;
    }
}