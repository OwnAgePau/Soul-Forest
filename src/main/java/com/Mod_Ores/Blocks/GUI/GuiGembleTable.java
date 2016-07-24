package com.Mod_Ores.Blocks.GUI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import org.lwjgl.opengl.GL11;

import com.Mod_Ores.Blocks.Containers.ContainerGemble;
import com.Mod_Ores.Blocks.Containers.ContainerGemmeration;
import com.Mod_Ores.Blocks.Containers.ContainerIceWorkbench;

@SideOnly(Side.CLIENT)
public class GuiGembleTable extends GuiContainer{	
    public static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");
    
    public GuiGembleTable(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5){
        super(new ContainerGemble(par1InventoryPlayer, par2World, par3, par4, par5));
    }
   
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        this.fontRendererObj.drawString("Gemble Table", 50, 6, 0x000000);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 85, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        FMLClientHandler.instance().getClient().getTextureManager().bindTexture(TEXTURE);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}