package com.Mod_Ores;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.Mod_Ores.Blocks.Containers.ContainerGelExtractor;
import com.Mod_Ores.Blocks.Containers.ContainerGemble;
import com.Mod_Ores.Blocks.Containers.ContainerGemcutter;
import com.Mod_Ores.Blocks.Containers.ContainerGemmeration;
import com.Mod_Ores.Blocks.Containers.ContainerGemming;
import com.Mod_Ores.Blocks.Containers.ContainerIceWorkbench;
import com.Mod_Ores.Blocks.GUI.GuiGelExtractor;
import com.Mod_Ores.Blocks.GUI.GuiGembleTable;
import com.Mod_Ores.Blocks.GUI.GuiGemcutter;
import com.Mod_Ores.Blocks.GUI.GuiGemmerationTable;
import com.Mod_Ores.Blocks.GUI.GuiGemmingTable;
import com.Mod_Ores.Blocks.GUI.GuiIceCrafting;
import com.Mod_Ores.Blocks.TileEntities.TileEntityGelExtractor;
import com.Mod_Ores.Blocks.TileEntities.TileEntityGembleTable;
import com.Mod_Ores.Blocks.TileEntities.TileEntityGemcutter;

public class IGuiHandlerCustom implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		if(tileEntity instanceof TileEntityGemcutter){
		    return new ContainerGemcutter(player.inventory, (TileEntityGemcutter) tileEntity);
		}
		else if(tileEntity instanceof TileEntityGelExtractor){
		    return new ContainerGelExtractor(player.inventory, (TileEntityGelExtractor) tileEntity);
		}
		
		if(id == 1){
		    return new ContainerIceWorkbench(player.inventory, world, x, y, z);
		}
		else if(id == 2){
		    return new ContainerGemble(player.inventory, world, x, y, z);
		}
		else if(id == 3){
		    return new ContainerGemmeration(player.inventory, world, x, y, z);
		}
		else if(id == 4){
		    return new ContainerGemming(player.inventory, world, x, y, z);
		}
		return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		if(tileEntity instanceof TileEntityGemcutter){
		    return new GuiGemcutter(player.inventory, (TileEntityGemcutter) tileEntity);
		}
		else if(tileEntity instanceof TileEntityGelExtractor){
		    return new GuiGelExtractor(player.inventory, (TileEntityGelExtractor) tileEntity);
		}
		
		if(id == 1){
		    return new GuiIceCrafting(player.inventory, world, x, y, z);
		}
		else if(id == 2){
		    return new GuiGembleTable(player.inventory, world, x, y, z);
		}
		else if(id == 3){
		    return new GuiGemmerationTable(player.inventory, world, x, y, z);
		}
		else if(id == 4){
		    return new GuiGemmingTable(player.inventory, world, x, y, z);
		}
		return null;
    }
}