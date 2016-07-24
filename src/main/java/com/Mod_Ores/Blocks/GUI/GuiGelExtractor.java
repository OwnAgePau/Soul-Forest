package com.Mod_Ores.Blocks.GUI;

import java.util.Random;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import org.lwjgl.opengl.GL11;

import com.Mod_Ores.Blocks.Containers.ContainerGelExtractor;
import com.Mod_Ores.Blocks.TileEntities.TileEntityGelExtractor;
import com.Mod_Ores.Init.SoulItems;

@SideOnly(Side.CLIENT)
public class GuiGelExtractor extends GuiContainer{
    public static final ResourceLocation TEXTURE = new ResourceLocation("soulforest", "textures/gui/gelextractor.png");
    private TileEntityGelExtractor gelExtractorInventory;
    private int onOffint = 0;
    
    public GuiGelExtractor(InventoryPlayer par1InventoryPlayer, TileEntityGelExtractor par2TileEntityGelextractor){
        super(new ContainerGelExtractor(par1InventoryPlayer, par2TileEntityGelextractor));
        this.gelExtractorInventory = par2TileEntityGelextractor;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        String s = this.gelExtractorInventory.isInvNameLocalized() ? this.gelExtractorInventory.getInvName() : StatCollector.translateToLocal(this.gelExtractorInventory.getInvName());
        this.fontRendererObj.drawString("Gel Extractor", 58, 32, 0x000000);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        
        if(gelExtractorInventory.canExtract()){
        	this.fontRendererObj.drawString("On", 100, 48, 0x000000);
        }
        else{
        	this.fontRendererObj.drawString("Off", 62, 48, 0x000000);
        }
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

        Random r = new Random();
        
        if(!gelExtractorInventory.canExtract()){
        	this.onOffint = 1;
        	// X, Y pos of drawing, x, y pos of picture, x, y size of picture
        	this.drawTexturedModalRect(k + 81, l + 36 + 9, 176, 0, 14, 14); // Off button        	
        }
        else{
        	this.onOffint = 0;
        	this.drawTexturedModalRect(k + 81, l + 36 + 9, 190, 0, 14, 14); // On button       
        }
        i1 = this.gelExtractorInventory.getExtractProgressScaled(61);
	    this.drawTexturedModalRect(k + 58, l + 41, 176, 14, i1 + 1, 3); // Arrow
        
        itemRender.zLevel = 100.0F;
        // TODO Check which one of the 2 or something else is how to render it
        itemRender.renderItemAndEffectIntoGUI(new ItemStack(SoulItems.BlueMoltenGel.get()), k + 8, l + 24);
        itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, new ItemStack(SoulItems.GelPot.get()), k + 153, l + 22, "");
        
        //itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(SoulItems.BlueMoltenGel.get()), k + 8, l + 24);
        //itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(SoulItems.GelPot.get()), k + 153, l + 22);
        itemRender.zLevel = 0.0F;
    }
}
