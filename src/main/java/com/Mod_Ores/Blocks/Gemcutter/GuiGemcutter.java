package com.Mod_Ores.Blocks.Gemcutter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiGemcutter extends GuiContainer{
    public static final ResourceLocation TEXTURE = new ResourceLocation("soulforest", "textures/gui/gemcutter.png");
    private TileEntityGemcutter gemCutterInventory;

    public GuiGemcutter(InventoryPlayer par1InventoryPlayer, TileEntityGemcutter par2TileEntityGemcutter){
	super(new ContainerGemcutter(par1InventoryPlayer, par2TileEntityGemcutter));
	this.gemCutterInventory = par2TileEntityGemcutter;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
	String s = this.gemCutterInventory.isInvNameLocalized() ? this.gemCutterInventory.getInvName() : StatCollector.translateToLocal(this.gemCutterInventory.getInvName());
	this.fontRendererObj.drawString("Gemcutter", 6, 6, 0x000000);
	this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3){
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.getTextureManager().bindTexture(TEXTURE);
	int k = (this.width - this.xSize) / 2;
	int l = (this.height - this.ySize) / 2;
	this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	int i1;

	if (this.gemCutterInventory.isCutting()){
	    i1 = this.gemCutterInventory.getPolishTimeRemainingScaled(12);
	    this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
	}

	i1 = this.gemCutterInventory.getCutProgressScaled(24);
	this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
