package com.Mod_Ores;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.Mod_Ores.Blocks.GelExtractor.ContainerGelExtractor;
import com.Mod_Ores.Blocks.GelExtractor.GuiGelExtractor;
import com.Mod_Ores.Blocks.GelExtractor.TileEntityGelExtractor;
import com.Mod_Ores.Blocks.Gemcutter.ContainerGemcutter;
import com.Mod_Ores.Blocks.Gemcutter.GuiGemcutter;
import com.Mod_Ores.Blocks.Gemcutter.TileEntityGemcutter;
import com.Mod_Ores.Blocks.IceWorkbench.ContainerIceWorkbench;
import com.Mod_Ores.Blocks.IceWorkbench.GuiIceCrafting;

import cpw.mods.fml.common.network.IGuiHandler;

public class IGuiHandlerCustom implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tileEntity = world.getTileEntity(x, y, z);
	if(tileEntity instanceof TileEntityGemcutter){
	    return new ContainerGemcutter(player.inventory, (TileEntityGemcutter) tileEntity);
	}
	else if(tileEntity instanceof TileEntityGelExtractor){
	    return new ContainerGelExtractor(player.inventory, (TileEntityGelExtractor) tileEntity);
	}
	if(id == 1){
	    return new ContainerIceWorkbench(player.inventory, world, x, y, z);
	}
	return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tileEntity = world.getTileEntity(x, y, z);
	if(tileEntity instanceof TileEntityGemcutter){
	    return new GuiGemcutter(player.inventory, (TileEntityGemcutter) tileEntity);
	}
	else if(tileEntity instanceof TileEntityGelExtractor){
	    return new GuiGelExtractor(player.inventory, (TileEntityGelExtractor) tileEntity);
	}
	if(id == 1){
	    return new GuiIceCrafting(player.inventory, world, x, y, z);
	}
	return null;
    }
}