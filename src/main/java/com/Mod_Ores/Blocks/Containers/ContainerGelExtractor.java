package com.Mod_Ores.Blocks.Containers;

import com.Mod_Ores.Blocks.TileEntities.TileEntityGelExtractor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

public class ContainerGelExtractor extends Container{
    
	private TileEntityGelExtractor gelextractor;
    private int lastCookTime;
    //private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerGelExtractor(InventoryPlayer par1InventoryPlayer, TileEntityGelExtractor par2TileEntitygelextractor){
        this.gelextractor = par2TileEntitygelextractor;
        this.addSlotToContainer(new Slot(par2TileEntitygelextractor, 0, 8, 8));
        this.addSlotToContainer(new Slot(par2TileEntitygelextractor, 1, 152, 8));
        //this.addSlotToContainer(new Slotgelextractor(par1InventoryPlayer.player, par2TileEntitygelextractor, 2, 116, 35));
        int i;

        for (i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }
    
    public void onCraftGuiOpened(ICrafting listener){
        super.onCraftGuiOpened(listener);
        listener.sendAllWindowProperties(this, this.gelextractor);
    }

    /*public void addCraftingToCrafters(ICrafting par1ICrafting){
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.gelextractor.gelextractorCookTime);
        //par1ICrafting.sendProgressBarUpdate(this, 1, this.gelextractor.gelextractorBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.gelextractor.currentItemBurnTime);
    }*/

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges(){
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i){
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.gelextractor.gelextractorCookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.gelextractor.gelextractorCookTime);
            }

            if (this.lastItemBurnTime != this.gelextractor.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.gelextractor.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.gelextractor.gelextractorCookTime;
        //this.lastBurnTime = this.gelextractor.gelextractorBurnTime;
        this.lastItemBurnTime = this.gelextractor.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data){
    	this.gelextractor.setField(id, data);
        /*if (par1 == 0){
            this.gelextractor.gelextractorCookTime = par2;
        }

        if (par1 == 2){
            this.gelextractor.currentItemBurnTime = par2;
        }*/
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer){
        return this.gelextractor.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2){
    	return null;
        /*ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (GelExtractorRecipes.smelting().getExtractResult(itemstack1, itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityGelExtractor.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;*/
    }
}